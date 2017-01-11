package com.report.next.nextreport.Fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.Class.ReportApprovedDialog;
import com.report.next.nextreport.Class.ReportInProcessDialog;
import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * report_detail_list.jpg
 */

public class ReportDetailFragment extends Fragment {

    private HomeActivity main;

    @OnClick(R.id.frd_trigger_approved)
    public void approved() {
        ReportApprovedDialog dialog = new ReportApprovedDialog(main);
        dialog.show();
    }

    @OnClick(R.id.frd_trigger_process)
    public void process() {
        ReportInProcessDialog dialog = new ReportInProcessDialog(main);
        dialog.show();
    }

    public ReportDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_report_detail, container, false);
        main = (HomeActivity) getActivity();
        ButterKnife.bind(this, thisFragmentView);
        main.setBottomBarVisibility(View.VISIBLE);

        return thisFragmentView;
    }

}
