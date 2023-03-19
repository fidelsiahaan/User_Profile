package com.example.user_profile;

import static java.security.AccessController.getContext;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Description;
import android.content.res.AssetManager;
import com.github.mikephil.charting.components.YAxis;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class WeightTrackingActivity extends AppCompatActivity {

    private LineChart chart;
    private static List<WeightEntry> weightEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracking);

        chart = findViewById(R.id.weightChart);


        weightEntries = new ArrayList<>();
        //example data
        weightEntries.add(new WeightEntry(75, new Date()));
        weightEntries.add(new WeightEntry(76, new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000)));
        weightEntries.add(new WeightEntry(74, new Date(System.currentTimeMillis() - 2 * 24 * 60 * 60 * 1000)));

        // create a list of Entry objects to represent the weight data on the chart
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < weightEntries.size(); i++) {
            WeightEntry entry = weightEntries.get(i);
            entries.add(new Entry(i, entry.getWeight()));
        }

        //font
        Typeface font = Typeface.createFromAsset(getAssets(), "font/worksansnormal.ttf");


        // create a data set from the Entry objects and customize the appearance
        LineDataSet dataSet = new LineDataSet(entries, "Weight (kg)");
        dataSet.setDrawFilled(true);
        dataSet.setColor(Color.rgb(0, 255, 0));
        dataSet.setFillColor(Color.rgb(0, 255, 0));
        dataSet.setDrawCircles(false);
        dataSet.setValueTextSize(30f);
        dataSet.setValueTypeface(font);

        // create a LineData object and add the data set to it
        LineData lineData = new LineData(dataSet);

        // customize the appearance of the chart
        chart.setData(lineData);
        chart.getDescription().setEnabled(false);
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getXAxis().setValueFormatter(new DateAxisValueFormatter());
        chart.getAxisLeft().setGranularity(0.01f);
        chart.getAxisLeft().setEnabled(false);
        chart.getAxisRight().setEnabled(false);
        chart.getXAxis().setAxisMinimum(lineData.getXMin() - 0.10f);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getAxisLeft().setDrawGridLines(false);

        Description description = chart.getDescription();
        description.setTypeface(font);

        showAddWeightDialog();
        // redraw the chart
        chart.invalidate();
    }

    private void showAddWeightDialog() {
        final EditText weightEditText = new EditText(this);
        weightEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        new AlertDialog.Builder(this)
                .setTitle("Add Weight Entry")
                .setMessage("Enter your weight in pounds:")
                .setView(weightEditText)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String weightString = weightEditText.getText().toString();
                        if (!weightString.isEmpty()) {
                            float weight = Float.parseFloat(weightString);
                            addWeightEntry(weight);
                        }
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    // custom ValueFormatter class to format the X-axis labels as dates
    private static class DateAxisValueFormatter extends ValueFormatter {
        private final SimpleDateFormat mDateFormat = new SimpleDateFormat("MMM dd", Locale.US);

        @Override
        public String getAxisLabel(float value, AxisBase axis) {
            Date date = weightEntries.get((int) value).getDate();
            return mDateFormat.format(date);
        }
    }

    // method to add a new weight entry to the list and update the chart
    private void addWeightEntry(float weight) {
        WeightEntry entry = new WeightEntry(weight, new Date());
        weightEntries.add(new WeightEntry(weight, new Date()));

        // add a new Entry object to the chart's data set and redraw the chart
        LineDataSet dataSet = (LineDataSet) chart.getData().getDataSetByIndex(0);
        dataSet.addEntry(new Entry(dataSet.getEntryCount(), entry.getWeight()));
        chart.getData().notifyDataChanged();
        chart.notifyDataSetChanged();
        chart.invalidate();
    }

    // inner class to represent a weight entry with a weight value and a date
    private static class WeightEntry {
        private final float weight;
        private final Date date;

        public WeightEntry(float weight, Date date) {
            this.weight = weight;
            this.date = date;
        }

        public float getWeight() {
            return weight;
        }

        public Date getDate() {
            return date;
        }
    }
}


