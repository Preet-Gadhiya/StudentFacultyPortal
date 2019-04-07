package com.project.studentfacultyportal.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.project.studentfacultyportal.R;
import com.project.studentfacultyportal.sql.DatabaseHelper;

public class ProfileActivity extends AppCompatActivity {
    TextView nameTextView, totalQuizTextView, scoreTextView, topScorerTextView, emailTextView, phoneNoTextView, semesterTextView, branchTextView;
    String email, name, totalQuiz, score, topScorer, phoneNo, semester, branch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        totalQuizTextView = (TextView) findViewById(R.id.totalQuizTextView);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        topScorerTextView = (TextView) findViewById(R.id.topScorerTextView);
        emailTextView = (TextView) findViewById(R.id.emailTextView);
        phoneNoTextView = (TextView) findViewById(R.id.phoneNumberTextView);
        semesterTextView = (TextView) findViewById(R.id.semesterTextView);
        branchTextView = (TextView) findViewById(R.id.branchTextView);
        updateProflie();
    }

    private void updateProflie() {
        Intent i = getIntent();
        Bundle b = i.getExtras();
        if (b != null) {
            email = (String) b.get("EMAIL");
            emailTextView.setText(email);
        }
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = databaseHelper.getInfo(email, db);
        if (cursor.moveToFirst()) {
            name = cursor.getString(0);
            nameTextView.setText(name);
            phoneNo = cursor.getString(1);
            phoneNoTextView.setText(phoneNo);
            branch = cursor.getString(2);
            branchTextView.setText(branch);
            semester =  cursor.getString(3);
            semesterTextView.setText(semester);
            totalQuiz =  cursor.getString(4);
            totalQuizTextView.setText(totalQuiz);
            topScorer =  cursor.getString(5);
            topScorerTextView.setText(topScorer);
            score = cursor.getString(6);
            scoreTextView.setText(score);
        }
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
            case R.id.settingsId:
                Log.i("Menu Item selected", "Settings Pressed");

            case R.id.aboutId:
                Log.i("Menu Item selected", "About us");
                return true;
            default:
                return false;
        }

    }
}
