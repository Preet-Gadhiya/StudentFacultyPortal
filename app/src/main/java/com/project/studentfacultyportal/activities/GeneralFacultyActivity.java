package com.project.studentfacultyportal.activities;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

     @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logoutMenu:
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                return true;

            case R.id.aboutMenu:
                Toast.makeText(this, "We are Anonnymous! :)", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;


        }

    }
}
