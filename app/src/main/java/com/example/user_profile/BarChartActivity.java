package com.example.user_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;

import com.github.mikephil.charting.animation.Easing;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import android.graphics.Color;

import java.util.ArrayList;

public class BarChartActivity extends AppCompatActivity {

    ArrayList barArrayList;
    float carb_calories = 1000;
    float fat_calories = 450;
    float protein_calories = 450;
    float total_calories = (carb_calories + fat_calories + protein_calories);
    float carbs_percentage = (carb_calories/total_calories) * 100;
    float protein_percentage = (protein_calories/total_calories) * 100;
    float fat_percentage = (fat_calories/total_calories) * 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_chart);
        BarChart barChart = findViewById(R.id.barchart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArrayList, "Fats, Carbs, Proteins, consumed vs goals.");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.PASTEL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);

    }



    private void getData(){
        barArrayList = new ArrayList();
        barArrayList.add(new BarEntry(2f, fat_percentage));
        barArrayList.add(new BarEntry(4f, carbs_percentage));
        barArrayList.add(new BarEntry(6f, protein_percentage));
        barArrayList.add(new BarEntry(6f, 32));
        barArrayList.add(new BarEntry(2f, 10));
        barArrayList.add(new BarEntry(4f, 44));
    }
}