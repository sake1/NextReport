package com.report.next.nextreport.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.Class.Report;
import com.report.next.nextreport.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * report_detail_list.jpg
 */

public class ReportDetailFragment extends Fragment {

    @BindView(R.id.frd_tab_layout) TabLayout tabLayout;
    @BindView(R.id.frd_view_pager) ViewPager viewPager;

    private HomeActivity main;

    class ReportDetailAdapter extends FragmentPagerAdapter {

        private static final int TAB_COUNT = 4;
        private static final int STATUS_ALL = 0;
        private static final int STATUS_PROCESS = 1;
        private static final int STATUS_ACCEPTED = 2;
        private static final int STATUS_REJECTED = 3;
        private ArrayList<Report> reports;

        public ReportDetailAdapter(FragmentManager fm, ArrayList<Report> reports) {
            super(fm);
            this.reports = reports;
        }

        @Override
        public Fragment getItem(int position) {
            /**
             * Return fragment with respect to Position .
             */

            /**
             * [MOTI]
             * If we code this Fragment in such a way
             * we can avoid using soo many java class and xml filed,
             * each for "all", "process", "approved", and "rejected"
             *
             * Initilaized the dummy data -here- and filter it in -here-
             * send in to a -same- class but with diffrent data and we are done
             */
            ReportDetailListViewFragment inflatedFragment = new ReportDetailListViewFragment();
            if(position == STATUS_ALL) {
                inflatedFragment.setReports(reports);
                return inflatedFragment;
            } else if(position == STATUS_PROCESS) {
                inflatedFragment.setReports(getFilteredReports("Process"));
                return inflatedFragment;
            } else if(position == STATUS_ACCEPTED) {
                inflatedFragment.setReports(getFilteredReports("Approved"));
                return inflatedFragment;
            } else if(position == STATUS_REJECTED) {
                inflatedFragment.setReports(getFilteredReports("Rejected"));
                return inflatedFragment;
            }
            return null;
        }

        private ArrayList<Report> getFilteredReports(String status) {
            ArrayList<Report> arrayOfFilteredReports = new ArrayList<>();

            for(Report report : reports) {
                if(report.getStatus().equalsIgnoreCase(status)){
                    arrayOfFilteredReports.add(report);
                }
            }

            return arrayOfFilteredReports;
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            /**
             * This method returns the title of the tab according to the position.
             */
            switch (position){
                case 0 : return "All";
                case 1 : return "Process";
                case 2 : return "Approved";
                case 3 : return "Rejected";
            }
            return null;
        }
    }

    private void init() {
        main.setBottomBarVisibility(View.VISIBLE);
        main.setChecked(R.id.menu_report_detail);
    }

    private void setView() {
        //Set an Apater for the View Pager
        viewPager.setAdapter(new ReportDetailAdapter(getChildFragmentManager(), getReportLists()));

        /**
         * Now , this is a workaround ,
         * The setupWithViewPager dose't works without the runnable .
         * Maybe a Support Library Bug .
         */
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
    }

    private ArrayList<Report> getReportLists() {
        /**
         * [MOTI]
         * This is currenty filled with dummy data, will be changed later
         * Coded the data here so when later on we use query,
         * we dont have to query the data 4 times (wasteful)
         *
         * TODO
         * Create enum class for these diffrent status to avid hard code
         */
        ArrayList<Report> arrayOfReports = new ArrayList<>();

        arrayOfReports.add(new Report("10", "Jan", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Rejected"));
        arrayOfReports.add(new Report("20", "Mar", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Approved"));
        arrayOfReports.add(new Report("10", "Des", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Process"));
        arrayOfReports.add(new Report("21", "Ags", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Approved"));
        arrayOfReports.add(new Report("20", "Feb", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Approved"));
        arrayOfReports.add(new Report("14", "Nov", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Process"));

        return arrayOfReports;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate tab_layout and setup Views.
        View thisFragmentView =  inflater.inflate(R.layout.fragment_report_detail, container, false);
        main = (HomeActivity) getActivity();
        ButterKnife.bind(this, thisFragmentView);
        init();
        setView();

        return thisFragmentView;
    }

}
