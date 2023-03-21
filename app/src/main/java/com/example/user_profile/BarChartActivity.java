package com.example.user_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ProgressBar;



import android.graphics.Typeface;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    ArrayList barArrayList;
    float carb_calories = 959;
    float fat_calories = 423;
    float protein_calories = 532;
    float total_calories = 2000;
    float carbs_percentage = (carb_calories/total_calories) * 100;
    float protein_percentage = (protein_calories/total_calories) * 100;
    float fat_percentage = (fat_calories/total_calories) * 100;
    boolean exceededMacro = false;
    String message = "You have exceeded the following macros today:\n";

    private Button weeklyButton, monthlyButton;
    private int calorieIntake = 900, calorieGoal = 2000,
            proteinIntake, proteinGoal,
            carbsIntake, carbsGoal,
            fatIntake, fatGoal;
    private TextView calorieIntakeT, calorieGoalT;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);

        //weeklyButton = (Button) findViewById(R.id.weeklyButton);
        //monthlyButton = (Button) findViewById(R.id.monthlyButton);

        Typeface font = Typeface.createFromAsset(getAssets(), "font/worksansnormal.ttf");


        //TestBench Values
        calorieIntakeT = findViewById(R.id.totalDailyCaloriesIntake);
        calorieIntakeT.setText(String.valueOf(calorieIntake));

        calorieGoalT = findViewById(R.id.totalDailyCaloriesGoal);
        calorieGoalT.setText(String.valueOf(calorieGoal));

        ProgressBar simpleProgressBar=(ProgressBar)findViewById(R.id.calorieBar); // initiate the progress bar
        simpleProgressBar.setMax(calorieGoal); // 100 maximum value for the progress value
        simpleProgressBar.setProgress(calorieIntake); // 50 default progress value for the progress bar




        if (calorieGoal > calorieIntake) {
            message += "- Calories\n";
            exceededMacro = true;
        } else if (proteinIntake > proteinGoal) {
            message += "- Protein\n";
            exceededMacro = true;
        } else if (carbsIntake > carbsGoal) {
            message += "- Carbs\n";
            exceededMacro = true;
        } else if (fatIntake > fatGoal) {
            message += "- Fat\n";
            exceededMacro = true;
        }


// Display warning if any macro exceeds its maximum value
        if (exceededMacro) {
            notif(message, "Watch out!");
        }
    }
    private void notif(String message, String title) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle(title);
        myAlert.setMessage(message);
        myAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        myAlert.show();
    }

/*
        weeklyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openWeeklyBarChartActivity();
            }
        });

        monthlyButton.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openMonthlyBarChartActivity();
            }
        }));
    }



    public void openMonthlyBarChartActivity(){
        Intent intent = new Intent(this, BarChartMonthlyActivity.class);
        startActivity(intent);
    }
    public void openWeeklyBarChartActivity(){
        Intent intent = new Intent(this, BarChartWeeklyActivity.class);
        startActivity(intent);
    }

 */
}