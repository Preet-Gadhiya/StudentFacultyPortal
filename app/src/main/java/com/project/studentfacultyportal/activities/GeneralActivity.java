package com.project.studentfacultyportal.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.project.studentfacultyportal.R;

public class GeneralActivity extends AppCompatActivity implements View.OnClickListener {
    CardView homeCard, documentsCard, gamesCard, profileCard;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        homeCard = findViewById(R.id.homeCard);
        documentsCard = findViewById(R.id.documentsCard);
        gamesCard = (CardView) findViewById(R.id.gamesCard);
        profileCard = findViewById(R.id.profileCard);
        homeCard.setOnClickListener(this);
        documentsCard.setOnClickListener(this);
        gamesCard.setOnClickListener(this);
        profileCard.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
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

    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.homeCard:
                i = new Intent(this, WelcomeActivity.class);
                startActivity(i);
                break;
            case R.id.documentsCard:
                i = new Intent(this, DocumentActivity.class);
                startActivity(i);
                break;
            case R.id.gamesCard:
                i = new Intent(this, BrainTrainerQuizActivity.class);
                 startActivity(i);
                break;
            case R.id.profileCard: {
                i = new Intent(this, ProfileActivity.class);
                Intent b = getIntent();
                Bundle mail = b.getExtras();
                email = (String) mail.get("EMAIL");
                i.putExtra("EMAIL", email);
                startActivity(i);
                break;
            }
            default:
                break;
        }
    }
}
