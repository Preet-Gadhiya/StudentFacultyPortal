package com.project.studentfacultyportal.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.project.studentfacultyportal.R;

public class GeneralFacultyActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genereal_faculty);
    }

    public void uploadFile(View view) {
        Intent intentUpload = new Intent(getApplicationContext(), FileUpload.class);
        startActivity(intentUpload);
    }
}
