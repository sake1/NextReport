package com.report.next.nextreport.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.fh_output_username)
    TextView username;
    @BindView(R.id.fh_output_department) TextView department;

    private HomeActivity main;

    @OnClick(R.id.fh_trigger_report_detail)
    public void detail() {
        main.changeFragment(new ReportDetailFragment(), true);
    }

    @OnClick(R.id.fh_trigger_report_performance)
    public void performance() {
        main.changeFragment(new ReportPerformanceFragment(), true);
    }

    @OnClick(R.id.fh_trigger_report_ranking)
    public void ranking() {
        main.changeFragment(new ReportRankingFragment(), true);
    }

    @OnClick(R.id.fh_trigger_report_upload)
    public void upload() {
        main.changeFragment(new ReportUploadFragment(), true);
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        main = (HomeActivity) getActivity();
        ButterKnife.bind(this, thisFragmentView);

        return thisFragmentView;
    }
}
