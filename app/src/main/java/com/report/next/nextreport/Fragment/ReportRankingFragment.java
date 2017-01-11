package com.report.next.nextreport.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.report.next.nextreport.R;
import com.report.next.nextreport.Ranking;
import com.report.next.nextreport.RankingAdapter;

import java.util.ArrayList;

/**
 * Ranking.jpg
 */

public class ReportRankingFragment extends Fragment {

    private int rank = 0;

    public ReportRankingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report_ranking, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateData();
    }

    public void populateData(){
        ArrayList<Ranking> arrayOfRankings = new ArrayList<>();


        arrayOfRankings.add(new Ranking(++rank, "Eka", "Sales", "Jakarta", 25, 30));
        arrayOfRankings.add(new Ranking(++rank, "Bejo", "Engineer", "New Delhi", 23, 27));
        arrayOfRankings.add(new Ranking(++rank, "Marcus", "PR", "London", 20, 24));
        arrayOfRankings.add(new Ranking(++rank, "Tarjo", "Sales", "Melbourne", 15, 16));
        arrayOfRankings.add(new Ranking(++rank, "Paijo", "Doctor", "Kuala Lumpur", 5, 3));
        arrayOfRankings.add(new Ranking(++rank, "Pok Inem", "IT", "Bandung", 2, 1));

        ListView listView = (ListView) getActivity().findViewById(R.id.rank_list);
        RankingAdapter adapter = new RankingAdapter(getActivity(), arrayOfRankings);
        listView.setAdapter(adapter);
    }

}
