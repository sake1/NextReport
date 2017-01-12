package com.report.next.nextreport.Fragment;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.Class.ProfileSetter;
import com.report.next.nextreport.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * static_performance.jpg
 */

public class ReportPerformanceFragment extends Fragment {

    @BindView(R.id.frp_output_linechart) LineChart linechart;

    private HomeActivity main;

    public ReportPerformanceFragment() {
        // Required empty public constructor
    }

    private void setLinechartDummyData() {
        /**
         * [MOTI]
         * This method WILL be deleted when database access finnaly provided
         * it only being used in the mockup
         */

        linechart.setDragEnabled(false);
        linechart.setTouchEnabled(false);

        List<Entry> mockupdata = new ArrayList<>();
        mockupdata.add(new Entry(1, 100));
        mockupdata.add(new Entry(2, 20));
        mockupdata.add(new Entry(3, 300));
        mockupdata.add(new Entry(4, 40));
        mockupdata.add(new Entry(5, 500));

        LineDataSet dataSet = new LineDataSet(mockupdata, "First Data");
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet.setColor(getResources().getColor(R.color.BlueLineGraph)); //Blue
        dataSet.setDrawCircles(true);
        dataSet.setDrawCircleHole(true);
        dataSet.setCircleRadius(5f);
        dataSet.setCircleHoleRadius(3f);
        dataSet.setCircleColor(getResources().getColor(R.color.BlueLineGraph));
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(getResources().getColor(R.color.BlueGraphFill));
        dataSet.setLineWidth(2);
        dataSet.setFillAlpha(75);

        List<Entry> mockupdata2 = new ArrayList<>();
        mockupdata2.add(new Entry(1, 50));
        mockupdata2.add(new Entry(2, 400));
        mockupdata2.add(new Entry(3, 30));
        mockupdata2.add(new Entry(4, 200));
        mockupdata2.add(new Entry(5, 10));

        LineDataSet dataSet2 = new LineDataSet(mockupdata2, "Second Data");
        dataSet2.setAxisDependency(YAxis.AxisDependency.LEFT);
        dataSet2.setColor(getResources().getColor(R.color.GreenLineGraph)); //Green
        dataSet2.setDrawCircles(true);
        dataSet2.setDrawCircleHole(true);
        dataSet2.setCircleRadius(5f);
        dataSet2.setCircleHoleRadius(3f);
        dataSet2.setCircleColor(getResources().getColor(R.color.GreenLineGraph));
        dataSet2.setDrawFilled(true);
        dataSet2.setFillColor(getResources().getColor(R.color.GreenGraphFill));
        dataSet2.setFillAlpha(25);
        dataSet2.setLineWidth(2);

        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);
        dataSets.add(dataSet2);

        LineData data = new LineData(dataSets);
        linechart.setData(data);
        linechart.invalidate(); // refresh
    }

    private void setView() {
        setLinechartDummyData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_report_performance, container, false);
        ButterKnife.bind(this, thisFragmentView);
        main = (HomeActivity) getActivity();
        main.setBottomBarVisibility(View.VISIBLE);

        ProfileSetter setProfile = new ProfileSetter(main, thisFragmentView);
        setView();

        HomeActivity main = (HomeActivity) getActivity();

        main.setChecked(R.id.menu_performance);

        return thisFragmentView;
    }

}
