package com.report.next.nextreport.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.report.next.nextreport.R;
import com.report.next.nextreport.Class.Report;
import com.report.next.nextreport.Class.ReportAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllReportFragment extends Fragment {


    public AllReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_report, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateData();
    }

    public void populateData() {
        ArrayList<Report> arrayOfReports = new ArrayList<>();

        arrayOfReports.add(new Report("10", "Jan", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Rejected"));
        arrayOfReports.add(new Report("20", "Mar", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Approved"));
        arrayOfReports.add(new Report("10", "Des", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Proses"));
        arrayOfReports.add(new Report("21", "Ags", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Approved"));
        arrayOfReports.add(new Report("20", "Feb", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Approved"));
        arrayOfReports.add(new Report("14", "Nov", "Belajar Android", "01-11 16:02:04.843 19358-19358/com.report.next.nextreport D/AbsListView: Get MotionRecognitionManager",   "Proses"));

        ListView listView = (ListView) getActivity().findViewById(R.id.report_list);
        ReportAdapter adapter = new ReportAdapter(getActivity(), arrayOfReports);
        listView.setAdapter(adapter);

    }

}
