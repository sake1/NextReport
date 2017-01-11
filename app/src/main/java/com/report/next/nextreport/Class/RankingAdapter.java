package com.report.next.nextreport.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.report.next.nextreport.R;

import java.util.ArrayList;

/**
 * Created by TimotiusEk on 1/11/2017.
 */

public class RankingAdapter extends ArrayAdapter<Ranking> {
    public RankingAdapter(Context context, ArrayList<Ranking> rankings) {
        super(context, 0, rankings);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ranking ranking = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout_ranking, parent, false);
        }

        TextView tvRank = (TextView) convertView.findViewById(R.id.show_rank_label);
        TextView tvUsername = (TextView) convertView.findViewById(R.id.show_username_label);

        TextView tvDepartment = (TextView) convertView.findViewById(R.id.department_label);
        TextView tvPoints = (TextView) convertView.findViewById(R.id.show_points_label);
        TextView tvClients = (TextView) convertView.findViewById(R.id.show_clients_label);

        tvRank.setText(String.valueOf(ranking.getRank()));
        tvUsername.setText(ranking.getName());

        tvDepartment.setText(ranking.getDepartments() + " in " + ranking.getLocation());

        tvPoints.setText(String.valueOf(ranking.getPoints()));

        tvClients.setText(String.valueOf(ranking.getClients()));

        return convertView;
    }

}
