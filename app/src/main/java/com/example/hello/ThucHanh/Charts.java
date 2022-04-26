package com.example.hello.ThucHanh;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.hello.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

public class Charts extends AppCompatActivity {
    private BarChart barChart ;
    public void anhXa(){
        barChart = findViewById(R.id.BarChart);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);
        anhXa();
        List<String> arrList= new ArrayList<>();
        arrList.add("Label 1");arrList.add("Label 2");arrList.add("Label 3");
        arrList.add("Label 4");arrList.add("Label 5");
        int j=0;
        ArrayList<BarEntry> list = new ArrayList();
        list.add(new BarEntry(2014, 100));
        list.add(new BarEntry(2015, 120));
        list.add(new BarEntry(2016, 200));
        list.add(new BarEntry(2017, 30));
        list.add(new BarEntry(2018, 45));


        BarDataSet set2 = new BarDataSet(list, null);
        set2.setLabel("a");
        set2.setStackLabels(new String[]{"Stack 1", "Stack 2"});
        set2.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set2.setValueTextColor(Color.BLACK);
        set2.setValueTextSize(16f);

        BarData barData = new BarData(set2);
       
        barChart.setFitBars(true);
        barChart.setData(barData);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(arrList));
        xAxis.setCenterAxisLabels(true);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setGranularityEnabled(true);
        barChart.setDragEnabled(true);
       
        //barChart.groupBars(0,0.44f,0.08f);

        barChart.invalidate();
        barChart.animateY(2000);
    }
}