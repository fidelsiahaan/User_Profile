package com.example.user_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {
    private PieChart pieChart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pie_chart);

        pieChart = findViewById(R.id.activity_main_piechart);
        setupPieChart();
        loadPieChartData();
    }

    private void setupPieChart() {
        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setCenterText("Caloric Breakdown");
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);

        Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
    }
    private void loadPieChartData() {
        ArrayList<PieEntry> entries = new ArrayList<>();
        Intent intent = getIntent();
        float breakfastFatValue = intent.getIntExtra(MainActivity.EXTRA_BREAKFAST_FAT_TEXT, 0);
        float breakfastCarbsValue = intent.getIntExtra(MainActivity.EXTRA_BREAKFAST_CARBS_TEXT, 0);
        float breakfastProteinValue = intent.getIntExtra(MainActivity.EXTRA_BREAKFAST_PROTEIN_TEXT, 0);

        float lunchFatValue = intent.getIntExtra(MainActivity.EXTRA_LUNCH_FAT_TEXT, 0);
        float lunchCarbsValue = intent.getIntExtra(MainActivity.EXTRA_LUNCH_CARBS_TEXT, 0);
        float lunchProteinValue = intent.getIntExtra(MainActivity.EXTRA_LUNCH_PROTEIN_TEXT, 0);

        float dinnerFatValue = intent.getIntExtra(MainActivity.EXTRA_DINNER_FAT_TEXT, 0);
        float dinnerCarbsValue = intent.getIntExtra(MainActivity.EXTRA_DINNER_CARBS_TEXT, 0);
        float dinnerProteinValue = intent.getIntExtra(MainActivity.EXTRA_DINNER_PROTEIN_TEXT, 0);

        float breakfastCaloriesValue = intent.getIntExtra(MainActivity.EXTRA_BREAKFAST_CALORIES_TEXT, 0);
        float lunchCaloriesValue = intent.getIntExtra(MainActivity.EXTRA_LUNCH_CALORIES_TEXT, 0);
        float dinnerCaloriesValue = intent.getIntExtra(MainActivity.EXTRA_DINNER_CALORIES_TEXT, 0);

        float totalFatValue = (breakfastFatValue + lunchFatValue + dinnerFatValue);
        float totalCarbsValue = (breakfastCarbsValue + lunchCarbsValue + dinnerCarbsValue);
        float totalProteinValue = (breakfastProteinValue + lunchProteinValue + dinnerProteinValue);
        float totalCaloriesValue = (breakfastCaloriesValue + lunchCaloriesValue + dinnerCaloriesValue);

        entries.add(new PieEntry(totalCarbsValue / totalCaloriesValue, "Carbohydrates"));
        entries.add(new PieEntry(totalProteinValue / totalCaloriesValue, "Protein"));
        entries.add(new PieEntry(totalFatValue / totalCaloriesValue, "Fats"));


        ArrayList<Integer> colors = new ArrayList<>();
        for (int color: ColorTemplate.PASTEL_COLORS) {
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color);
        }

        PieDataSet dataSet = new PieDataSet(entries, "Category");
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);

        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);
    }
}