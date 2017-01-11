package com.report.next.nextreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by TimotiusEk on 1/11/2017.
 */

public class ReportAdapter extends ArrayAdapter<Report>{
    public ReportAdapter(Context context, ArrayList<Report> reports) {
        super(context, 0, reports);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Report report = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout_report, parent, false);
        }

        TextView tvMonth = (TextView) convertView.findViewById(R.id.show_month_label);
        TextView tvDate = (TextView) convertView.findViewById(R.id.show_date_label);
        TextView tvTitle = (TextView) convertView.findViewById(R.id.show_title_label);
        TextView tvDescription = (TextView) convertView.findViewById(R.id.show_description_label);
        TextView tvStatus= (TextView) convertView.findViewById(R.id.show_status_label);

        if(report.getStatus().equalsIgnoreCase(""))

        return convertView;
    }
}
