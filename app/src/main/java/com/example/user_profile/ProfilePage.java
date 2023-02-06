package com.example.user_profile;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

public class ProfilePage extends AppCompatActivity{


    private Button userSummaryButton;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        userSummaryButton = (Button) findViewById(R.id.userSummaryButton);
    userSummaryButton.setOnClickListener((new View.OnClickListener(){
        @Override
        public void onClick(View v){
            openSummary();
        }
    }));
    }
    public void openSummary(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
