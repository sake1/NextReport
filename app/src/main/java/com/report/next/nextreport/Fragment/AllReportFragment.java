package com.report.next.nextreport.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.report.next.nextreport.R;

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

}
