package com.creolin.bar_chart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    // variable for our bar chart
    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;

    // array list for storing entries.
    ArrayList barEntriesArrayList;
    ArrayList barlablesArrayList;
    TextView txv;

    ArrayList<Tester> test = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.P)
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing variable for bar chart.
        barChart = findViewById(R.id.idBarChart);
        txv = findViewById(R.id.txv);
        //populating the array
        populateList();

        // calling method to get bar entries.
        getBarEntries();

        String[] mStrings = new String[barlablesArrayList.size()];
        String lables = "Key\n";
        for (int i = 0; i < barlablesArrayList.size(); i++) {
            mStrings[i] = barlablesArrayList.get(i).toString();
            lables = lables + "bar " + i + " : " + barlablesArrayList.get(i).toString() + "\n";
        }

        // creating a new bar data set.
        barDataSet = new BarDataSet(barEntriesArrayList, "bars in order ");

        // creating a new bar data and
        // passing our bar data set.
        barData = new BarData(barDataSet);

        // below line is to set data
        // to our bar chart.
        barChart.setData(barData);

        // adding color to our bar data set.
        barDataSet.setColors(ColorTemplate.LIBERTY_COLORS);


        // setting text color.
        barDataSet.setValueTextColor(Color.BLACK);

        txv.setText(lables);

        // setting text size
        barDataSet.setValueTextSize(16f);

        barDataSet.setStackLabels(mStrings);

        barChart.setAccessibilityHeading(false);


        barChart.getDescription().setEnabled(false);
    }

    private void getBarEntries() {
        // creating a new array list
        barEntriesArrayList = new ArrayList<>();
        barlablesArrayList = new ArrayList<>();
        int counter = 0;
//        if (test.size() == 0)
//        {
        for (Tester testing : test) {
            barEntriesArrayList.add(new BarEntry((float) counter, (float)testing.getMark()));
            barlablesArrayList.add(testing.getName());
            counter++;
        }
//        }
//        else
//        {
//            barEntriesArrayList.add(new BarEntry(1f, 4.F,"test1".toString()));
//            barEntriesArrayList.add(new BarEntry(2f, 6));
//            barEntriesArrayList.add(new BarEntry(3f, 8));
//            barEntriesArrayList.add(new BarEntry(4f, 2));
//            barEntriesArrayList.add(new BarEntry(5f, 4));
//            barEntriesArrayList.add(new BarEntry(6f, 1));
//        }

        // adding new entry to our array list with bar
        // entry and passing x and y axis value to it.

    }


    private void populateList() {
        Tester t1 = new Tester("Neil", 100);
        test.add(t1);
        Tester t2 = new Tester("Creolin", 10);
        test.add(t2);
        Tester t3 = new Tester("Nikshay", 90);
        test.add(t3);
        Tester t4 = new Tester("Sayen", 50);
        test.add(t4);
        Tester t5 = new Tester("Mojo", 20);
        test.add(t5);
        Tester t6 = new Tester("Azhar", 100);
        test.add(t6);
        Tester t7 = new Tester("Tafton", 50);
        test.add(t7);
    }


}