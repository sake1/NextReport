package com.report.next.nextreport.Fragment;


import android.graphics.Color;
import android.media.ImageWriter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTouch;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.fh_output_username) TextView username;
    @BindView(R.id.fh_output_department) TextView department;
    @BindView(R.id.fh_trigger_report_detail) CardView reportDetail;
    @BindView(R.id.fh_trigger_report_ranking) CardView reportRanking;
    @BindView(R.id.fh_trigger_report_performance) CardView reportPerformance;
    @BindView(R.id.fh_trigger_report_upload) CardView reportUpload;

    private HomeActivity main;

    private class CardViewTouchListener implements View.OnTouchListener {

        private CardView card;

        public CardViewTouchListener(CardView card) {
            this.card = card;
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                card.setBackgroundColor(getResources().getColor(R.color.googleGrey));
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                card.setBackgroundColor(getResources().getColor(R.color.White));
            }
            return false;
        }
    }

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

    private void init() {
        reportDetail.setOnTouchListener(new CardViewTouchListener(reportDetail));
        reportRanking.setOnTouchListener(new CardViewTouchListener(reportRanking));
        reportPerformance.setOnTouchListener(new CardViewTouchListener(reportPerformance));
        reportUpload.setOnTouchListener(new CardViewTouchListener(reportUpload));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_home, container, false);
        main = (HomeActivity) getActivity();
        ButterKnife.bind(this, thisFragmentView);
        main.setBottomBarVisibility(View.VISIBLE);
        init();
        main.setChecked(R.id.menu_dashboard);

        ((ImageView) thisFragmentView.findViewById(R.id.fh_static_image_top)).setScaleType(ImageView.ScaleType.FIT_XY);

        return thisFragmentView;
    }
}
