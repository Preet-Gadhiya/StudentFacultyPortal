package com.project.studentfacultyportal.activities;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.project.studentfacultyportal.R;
import com.project.studentfacultyportal.adapters.FileAdapter;

import java.io.File;
import java.util.ArrayList;

public class MyRecylerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_recycler_view);
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("urls");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //called for individual items at the database reference
                String fileName=dataSnapshot.getKey();//filename
                String url = dataSnapshot.getValue(String.class);
                ((FileAdapter)recyclerView.getAdapter()).update(fileName,url);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        //custom adapter to populate recycler view with items
        recyclerView.setLayoutManager(new LinearLayoutManager(MyRecylerViewActivity.this));
        FileAdapter fileAdapter = new FileAdapter(recyclerView,MyRecylerViewActivity.this,new ArrayList<String>(), new ArrayList<String>());
        recyclerView.setAdapter(fileAdapter);


    }
}
