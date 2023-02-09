package com.app.ccsit.zwls;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    PieChart pieChart;

@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);


    PieChart pieChart = findViewById(R.id.pie_chart);

    ArrayList<Integer> colors = new ArrayList<>();

    DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(this);
    SQLiteDatabase database = dbHelper.getReadableDatabase();

    ArrayList<PieEntry> pieEntries = new ArrayList<>();

    String query = "SELECT * FROM Recycle WHERE quantity != 0 ";

    Cursor cursor = database.rawQuery(query,null);

    while(cursor.moveToNext()){
        switch (cursor.getString(0)){
            case "plastic":
                pieEntries.add(new PieEntry(cursor.getInt(1),"Plastic"));
                colors.add(getResources().getColor(R.color.colorBlue, null));
                break;
            case "paper":
                pieEntries.add(new PieEntry(cursor.getInt(1),"Paper"));
                colors.add(getResources().getColor(R.color.colorGreen, null));
                break;
            case "glass":
                pieEntries.add(new PieEntry(cursor.getInt(1),"Glass"));
                colors.add(getResources().getColor(R.color.colorGray, null));
                break;
            case "ewaste":
                pieEntries.add(new PieEntry(cursor.getInt(1),"E-waste"));
                colors.add(getResources().getColor(R.color.colorPink, null));
                break;
            case "metal":
                pieEntries.add(new PieEntry(cursor.getInt(1),"Metal"));
                colors.add(getResources().getColor(R.color.colorPurple, null));
                break;
            case "battery":
                pieEntries.add(new PieEntry(cursor.getInt(1),"Battery"));
                colors.add(getResources().getColor(R.color.colorRed, null));
                break;

            case "bulbs":
                pieEntries.add(new PieEntry(cursor.getInt(1),"Bulbs"));
                colors.add(getResources().getColor(R.color.colorYellow, null));
                break;

        }
    }

    PieDataSet dataSet = new PieDataSet(pieEntries, "");
    dataSet.setColors(colors);
    dataSet.setValueTextSize(12);
    dataSet.setValueTextColor(Color.WHITE);
    dataSet.setSliceSpace(3f);
    dataSet.setSelectionShift(5f);

    pieChart.getDescription().setEnabled(false);
    pieChart.setCenterText("Your Performance");
    pieChart.setCenterTextSize(20);
    pieChart.setExtraBottomOffset(10);
    Legend legend = pieChart.getLegend();
    legend.setTextSize(20);
    legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
    legend.setOrientation(Legend.LegendOrientation.VERTICAL);
    legend.setYOffset(10);
    legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
    legend.setXEntrySpace(20);
    PieData data = new PieData(dataSet);

    data.setValueFormatter(new PercentFormatter());
    pieChart.setData(data);
    pieChart.invalidate();

    }

}
