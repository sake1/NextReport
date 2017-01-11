package com.report.next.nextreport.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.Class.ProfileSetter;
import com.report.next.nextreport.R;

import butterknife.ButterKnife;

/**
 * Ranking.jpg
 */

public class ReportRankingFragment extends Fragment {

    private HomeActivity main;

    public ReportRankingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_report_ranking, container, false);
        ButterKnife.bind(this, thisFragmentView);
        main = (HomeActivity) getActivity();
        main.setBottomBarVisibility(View.VISIBLE);
        ProfileSetter setProfile = new ProfileSetter(main, thisFragmentView);

        return thisFragmentView;
    }

}
