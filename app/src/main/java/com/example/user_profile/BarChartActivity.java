package com.example.user_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;

import android.graphics.Typeface;
import com.github.mikephil.charting.components.Description;

import com.github.mikephil.charting.animation.Easing;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import android.graphics.Color;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        BarChart barChart = findViewById(R.id.barchart);
        getData();

        Typeface font = Typeface.createFromAsset(getAssets(), "font/worksansnormal.ttf");

        BarDataSet barGoalDataSet = new BarDataSet(barArrayList, "Fats, Carbs, Proteins, consumed vs goals.");
        BarData barData = new BarData(barGoalDataSet);
        barChart.setData(barData);
        barGoalDataSet.setColors(Color.rgb(255, 255, 255), Color.rgb(0, 0, 255));
        barGoalDataSet.setValueTextColor(Color.BLACK);
        barGoalDataSet.setValueTextSize(16f);
        barGoalDataSet.setValueTypeface(font);
        barChart.getDescription().setEnabled(false);
        barChart.animateY(1400);
        barChart.getXAxis().setDrawGridLines(false);

        if (carbs_percentage > 50) {
            message += "- Carbs\n";
            exceededMacro = true;
        }
        else if (protein_percentage > 20) {
            message += "- Protein\n";
            exceededMacro = true;
        }
        else if (fat_percentage > 30) {
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

    private void getData(){
        barArrayList = new ArrayList();
        barArrayList.add(new BarEntry(2f, 50));
        barArrayList.add(new BarEntry(2f, carbs_percentage));
        barArrayList.add(new BarEntry(4f, 30));
        barArrayList.add(new BarEntry(4f, fat_percentage));
        barArrayList.add(new BarEntry(6f, 20));
        barArrayList.add(new BarEntry(6f, protein_percentage));

    }
}