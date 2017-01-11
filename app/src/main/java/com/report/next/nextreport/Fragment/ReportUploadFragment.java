package com.report.next.nextreport.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Upload_form.jpg
 */

public class ReportUploadFragment extends Fragment {

    @BindView(R.id.fru_input_fullname) EditText fullname;
    @BindView(R.id.fru_input_email) EditText email;
    @BindView(R.id.fru_input_phone_number) EditText phoneNumber;
    @BindView(R.id.fru_input_report_title) EditText title;
    @BindView(R.id.fru_input_description) EditText description;

    private HomeActivity main;

    @OnClick(R.id.fru_trigger_upload)
    public void upload() {
        if(validate()) {
            main.changeFragment(new HomeFragment(), true);
        }
    }

    private boolean validate() {
        if(fullname.getText().toString().equals("") ||
                email.getText().toString().equals("") ||
                phoneNumber.getText().toString().equals("") ||
                title.getText().toString().equals("") ||
                description.getText().toString().equals("")) {
            Toast.makeText(main, "Please Fill All Field", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public ReportUploadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisFragmentView = inflater.inflate(R.layout.fragment_report_upload, container, false);
        main = (HomeActivity) getActivity();
        ButterKnife.bind(this, thisFragmentView);
        main.setBottomBarVisibility(View.GONE);

        main.setChecked(R.id.menu_report_detail);

        return thisFragmentView;
    }

}
