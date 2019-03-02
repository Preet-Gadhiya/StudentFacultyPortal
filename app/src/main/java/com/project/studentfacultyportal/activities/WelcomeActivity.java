package com.project.studentfacultyportal.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.project.studentfacultyportal.R;

public class WelcomeActivity extends AppCompatActivity {
    LinearLayout l1;
    Animation up_to_down,down_to_top;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        l1 = (LinearLayout) findViewById(R.id.l1);
        up_to_down = AnimationUtils.loadAnimation(this,R.anim.up_to_down);
        down_to_top = AnimationUtils.loadAnimation(this,R.anim.down_to_top);
        l1.setAnimation(up_to_down);
    }
}
