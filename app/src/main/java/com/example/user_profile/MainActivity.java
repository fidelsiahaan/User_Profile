package com.example.user_profile;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_BREAKFAST_FAT_TEXT = "fat_value";
    public static final String EXTRA_BREAKFAST_CARBS_TEXT = "carbs_value";
    public static final String EXTRA_BREAKFAST_PROTEIN_TEXT = "protein_value";

    public static final String EXTRA_LUNCH_FAT_TEXT = "lunch_fat_value";
    public static final String EXTRA_LUNCH_CARBS_TEXT = "lunch_carbs_value";
    public static final String EXTRA_LUNCH_PROTEIN_TEXT = "lunch_protein_value";

    public static final String EXTRA_DINNER_FAT_TEXT = "dinner_fat_value";
    public static final String EXTRA_DINNER_CARBS_TEXT = "dinner_carbs_value";
    public static final String EXTRA_DINNER_PROTEIN_TEXT = "dinner_protein_value";

    public static final String EXTRA_BREAKFAST_CALORIES_TEXT = "breakfast_calories_value";
    public static final String EXTRA_LUNCH_CALORIES_TEXT = "lunch_calories_value";
    public static final String EXTRA_DINNER_CALORIES_TEXT = "dinner_calories_value";



    private Button breakfastButton, caloricBreakdownButton, goalDisplayButton,
            weightTrackingButton;
    private TextView breakfastFatValue, breakfastCarbsValue, breakfastProteinValue, lunchFatValue,
            lunchCarbsValue, lunchProteinValue, dinnerFatValue, dinnerCarbsValue, dinnerProteinValue,
            breakfastCaloriesValue, lunchCaloriesValue, dinnerCaloriesValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        breakfastButton = (Button) findViewById(R.id.breakfast_button);
        caloricBreakdownButton = (Button) findViewById(R.id.caloric_breakdown_button);
        goalDisplayButton = (Button) findViewById(R.id.goal_display_button);
        weightTrackingButton = (Button) findViewById(R.id.weightTrackingButton);

        breakfastFatValue = (TextView) findViewById(R.id.breakfastFatValue);
        breakfastCarbsValue = (TextView) findViewById(R.id.breakfastCarbsValue);
        breakfastProteinValue = (TextView) findViewById(R.id.breakfastProteinValue);

        lunchFatValue = (TextView) findViewById(R.id.lunchFatValue);
        lunchCarbsValue = (TextView) findViewById(R.id.lunchCarbsValue);
        lunchProteinValue = (TextView) findViewById(R.id.lunchProteinValue);

        dinnerFatValue = (TextView) findViewById(R.id.dinnerFatValue);
        dinnerCarbsValue = (TextView) findViewById(R.id.dinnerCarbsValue);
        dinnerProteinValue = (TextView) findViewById(R.id.dinnerProteinValue);

        breakfastCaloriesValue = (TextView) findViewById(R.id.breakfastCalories);
        lunchCaloriesValue = (TextView) findViewById(R.id.lunchCalories);
        dinnerCaloriesValue = (TextView) findViewById(R.id.dinnerCalories);




        breakfastButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openBreakfastActivity();
            }
        });

        caloricBreakdownButton.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openPieChartActivity();
            }
        }));

        goalDisplayButton.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openBarChartActivity();
            }
        }));

        weightTrackingButton.setOnClickListener((new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openWeightTrackingActivity();
            }
        }));

    }

    public void openBreakfastActivity(){
        Intent intent = new Intent(this, BreakfastActivity.class);
        startActivity(intent);
    }
    public void openWeightTrackingActivity(){
        Intent intent = new Intent(this, WeightTrackingActivity.class);
        startActivity(intent);
    }

    public void openPieChartActivity(){
        Intent intent = new Intent(this, PieChartActivity.class);


        intent.putExtra(EXTRA_BREAKFAST_FAT_TEXT, Integer.valueOf(breakfastFatValue.getText().toString()));
        intent.putExtra(EXTRA_BREAKFAST_CARBS_TEXT, Integer.valueOf(breakfastCarbsValue.getText().toString()));
        intent.putExtra(EXTRA_BREAKFAST_PROTEIN_TEXT, Integer.valueOf(breakfastProteinValue.getText().toString()));

        intent.putExtra(EXTRA_LUNCH_FAT_TEXT, Integer.valueOf(lunchFatValue.getText().toString()));
        intent.putExtra(EXTRA_LUNCH_CARBS_TEXT, Integer.valueOf(lunchCarbsValue.getText().toString()));
        intent.putExtra(EXTRA_LUNCH_PROTEIN_TEXT, Integer.valueOf(lunchProteinValue.getText().toString()));

        intent.putExtra(EXTRA_DINNER_FAT_TEXT, Integer.valueOf(dinnerFatValue.getText().toString()));
        intent.putExtra(EXTRA_DINNER_CARBS_TEXT, Integer.valueOf(dinnerCarbsValue.getText().toString()));
        intent.putExtra(EXTRA_DINNER_PROTEIN_TEXT, Integer.valueOf(dinnerProteinValue.getText().toString()));

        intent.putExtra(EXTRA_BREAKFAST_CALORIES_TEXT, Integer.valueOf(breakfastCaloriesValue.getText().toString()));
        intent.putExtra(EXTRA_LUNCH_CALORIES_TEXT, Integer.valueOf(lunchCaloriesValue.getText().toString()));
        intent.putExtra(EXTRA_DINNER_CALORIES_TEXT, Integer.valueOf(dinnerCaloriesValue.getText().toString()));


        startActivity(intent);
    }

    public void openBarChartActivity(){
        Intent intent = new Intent(this, BarChartActivity.class);
        startActivity(intent);
    }
}
