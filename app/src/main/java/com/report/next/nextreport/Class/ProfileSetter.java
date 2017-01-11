package com.report.next.nextreport.Class;

import android.widget.ImageView;
import android.widget.TextView;

import com.report.next.nextreport.Activity.HomeActivity;
import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.View;

/**
 * Created by USER on 11/01/2017.
 */

public class ProfileSetter {

    /**
     * [MOTI]
     * This class will be used to separately set the view for header_user_profile.xml
     * which is included in many fragment
     * So that it is not necessary to do it in each java class in each fragment
     *
     * The feature to set the view will be added later
     */

    private TextView username;
    private TextView department;
    private ImageView profilePic;
    private TextView points;
    private TextView clientAmount;
    private TextView rank;

    private HomeActivity main;
    private View view;

    public ProfileSetter(HomeActivity main, View view) {
        this.main = main;
        this.view = view;
        init();
    }

    private void init() {
        username = (TextView) view.findViewById(R.id.hup_output_username);
        department = (TextView) view.findViewById(R.id.hup_output_department);
        profilePic = (ImageView) view.findViewById(R.id.hup_output_profile_pic);
        points = (TextView) view.findViewById(R.id.hup_output_points);
        clientAmount = (TextView) view.findViewById(R.id.hup_output_clients_amount);
        rank = (TextView) view.findViewById(R.id.hup_output_rank);
    }
}
