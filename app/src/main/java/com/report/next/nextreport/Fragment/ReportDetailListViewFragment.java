package com.report.next.nextreport.Fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.R;
import com.report.next.nextreport.Class.Report;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReportDetailListViewFragment extends Fragment {

    @BindView(R.id.fsr_output_listview) ListView listView;

    private HomeActivity main;
    private ArrayList<Report> reports;

    class ReportAdapter extends ArrayAdapter<Report> {

        public ReportAdapter(Context context, ArrayList<Report> reports) {
            super(context, 0, reports);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            Report report = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout_report, parent, false);
            }

            TextView tvMonth = (TextView) convertView.findViewById(R.id.rlr_output_month);
            TextView tvDate = (TextView) convertView.findViewById(R.id.rlr_output_date);
            TextView tvTitle = (TextView) convertView.findViewById(R.id.rlr_output_title);
            TextView tvDescription = (TextView) convertView.findViewById(R.id.rlr_output_description);
            TextView tvStatus = (TextView) convertView.findViewById(R.id.rlr_output_status);

            if (report.getStatus().equalsIgnoreCase("Proses")) {
                tvStatus.setBackgroundColor(Color.parseColor("#FFFF00"));
            } else if (report.getStatus().equalsIgnoreCase("Approved")) {
                tvStatus.setBackgroundColor(Color.parseColor("#228B22"));
            } else if (report.getStatus().equalsIgnoreCase("Rejected")) {
                tvStatus.setBackgroundColor(Color.parseColor("#b90f1a"));
                tvStatus.setTextColor(Color.parseColor("#FFFFFF"));
            }

            tvStatus.setText(report.getStatus());
            tvMonth.setText(report.getMonth());
            tvDate.setText(report.getDate());
            tvTitle.setText(report.getTitle());
            tvDescription.setText(report.getDescription());

            return convertView;
        }
    }

    public ReportDetailListViewFragment() {
        // Required empty public constructor
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
        setView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_show_report, container, false);
        ButterKnife.bind(this, thisFragmentView);
        main = (HomeActivity) getActivity();

        setView();

        return thisFragmentView;
    }

    public void setView() {
        if(main == null || reports == null) {
            /**
             * Need to do this due to variable conflict
             * main is initialized in OnCreate (asynchronous)
             * reports is initialized in setReports (synchronous)
             * so both of them call this function
             */
            return;
        }
        ReportAdapter adapter = new ReportAdapter(main, reports);
        listView.setAdapter(adapter);
    }
}
