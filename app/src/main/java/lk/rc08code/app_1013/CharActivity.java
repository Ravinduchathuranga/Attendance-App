package lk.rc08code.app_1013;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class CharActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_char);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> barChartArrayList = new ArrayList<>();

// Convert String values to float before adding to BarEntry
        barChartArrayList.add(new BarEntry(10, MainActivity.attendance.getMonday()));
        barChartArrayList.add(new BarEntry(20, MainActivity.attendance.getTuesday()));
        barChartArrayList.add(new BarEntry(30, MainActivity.attendance.getWednesday()));
        barChartArrayList.add(new BarEntry(40, MainActivity.attendance.getThursday()));
        barChartArrayList.add(new BarEntry(50, MainActivity.attendance.getFriday()));
        barChartArrayList.add(new BarEntry(60, MainActivity.attendance.getSaturday()));
        barChartArrayList.add(new BarEntry(70, MainActivity.attendance.getSunday()));

        BarDataSet barDataSet = new BarDataSet(barChartArrayList, "Student Attendance");
        ArrayList<Integer> chartColors = new ArrayList<>();
        chartColors.add(getColor(R.color.black));
        chartColors.add(getColor(R.color.red));
        chartColors.add(getColor(R.color.blue));
        chartColors.add(getColor(R.color.pink));
        chartColors.add(getColor(R.color.green));
        chartColors.add(getColor(R.color.orange));
        barDataSet.setColors(chartColors);

        BarData barData = new BarData();
        barData.addDataSet(barDataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        //barChart.setPinchZoom(false);
        ArrayList<LegendEntry> arrayList = new ArrayList<>();
        arrayList.add(new LegendEntry("MON", Legend.LegendForm.CIRCLE, Float.NaN, Float.NaN, null, getColor(R.color.red)));
        arrayList.add(new LegendEntry("TUE", Legend.LegendForm.CIRCLE, Float.NaN, Float.NaN, null, getColor(R.color.green)));
        arrayList.add(new LegendEntry("WEND", Legend.LegendForm.CIRCLE, Float.NaN, Float.NaN, null, getColor(R.color.pink)));
        arrayList.add(new LegendEntry("THUR", Legend.LegendForm.CIRCLE, Float.NaN, Float.NaN, null, getColor(R.color.orange)));
        arrayList.add(new LegendEntry("FRI", Legend.LegendForm.CIRCLE, Float.NaN, Float.NaN, null, getColor(R.color.blue)));
        arrayList.add(new LegendEntry("SAT", Legend.LegendForm.CIRCLE, Float.NaN, Float.NaN, null, getColor(R.color.pink)));
        arrayList.add(new LegendEntry("SUN", Legend.LegendForm.CIRCLE, Float.NaN, Float.NaN, null, getColor(R.color.red)));
        barChart.getLegend().setCustom(arrayList);
        barChart.getLegend().setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        barChart.invalidate();

    }
}