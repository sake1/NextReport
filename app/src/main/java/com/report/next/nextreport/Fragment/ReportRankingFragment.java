package com.report.next.nextreport.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.R;
import com.report.next.nextreport.Class.Ranking;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Ranking.jpg
 */

public class ReportRankingFragment extends Fragment {

    @BindView(R.id.frr_output_listview) ListView listView;

    private HomeActivity main;

    class RankingAdapter extends ArrayAdapter<Ranking> {

        RankingAdapter(Context context, ArrayList<Ranking> rankings) {
            super(context, 0, rankings);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            Ranking ranking = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_layout_ranking, parent, false);
            }

            TextView tvRank = (TextView) convertView.findViewById(R.id.rlr_output_rank);
            TextView tvUsername = (TextView) convertView.findViewById(R.id.rlr_output_username);
            TextView tvDepartment = (TextView) convertView.findViewById(R.id.rlr_output_department);
            TextView tvPoints = (TextView) convertView.findViewById(R.id.rlr_output_points);
            TextView tvClients = (TextView) convertView.findViewById(R.id.rlr_output_clients);

            tvRank.setText(String.valueOf(ranking.getRank()));
            tvUsername.setText(ranking.getName());
            tvDepartment.setText(ranking.getDepartments() + " in " + ranking.getLocation());
            tvPoints.setText(String.valueOf(ranking.getPoints()));
            tvClients.setText(String.valueOf(ranking.getClients()));

            return convertView;
        }
    }

    public ReportRankingFragment() {
        // Required empty public constructor
    }

    private void init() {
        main = (HomeActivity) getActivity();

        main.setBottomBarVisibility(View.VISIBLE);
        main.setChecked(R.id.menu_ranking);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_report_ranking, container, false);
        ButterKnife.bind(this, thisFragmentView);
        init();
        setView();

        return thisFragmentView;
    }

    public void setView() {
        /**
         * Currently only using dummy data
         */
        ArrayList<Ranking> arrayOfRankings = new ArrayList<>();
        int rank = 0;

        arrayOfRankings.add(new Ranking(++rank, "Eka", "Sales", "Jakarta", 25, 30));
        arrayOfRankings.add(new Ranking(++rank, "Bejo", "Engineer", "New Delhi", 23, 27));
        arrayOfRankings.add(new Ranking(++rank, "Marcus", "PR", "London", 20, 24));
        arrayOfRankings.add(new Ranking(++rank, "Tarjo", "Sales", "Melbourne", 15, 16));
        arrayOfRankings.add(new Ranking(++rank, "Paijo", "Doctor", "Kuala Lumpur", 5, 3));
        arrayOfRankings.add(new Ranking(++rank, "Pok Inem", "IT", "Bandung", 2, 1));

        RankingAdapter adapter = new RankingAdapter(main, arrayOfRankings);
        listView.setAdapter(adapter);
    }
}
