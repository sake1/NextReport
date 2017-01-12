package com.report.next.nextreport.Class;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by USER on 11/01/2017.
 */

/**
 * This dialog is used for both accepted and rejected report
 */

public class ReportRespondedDialog extends Dialog {

    @BindView(R.id.drda_output_title) TextView title;
    @BindView(R.id.drda_output_date) TextView date;
    @BindView(R.id.drda_output_report_detail) TextView reportDetail;
    @BindView(R.id.drda_output_status) Button status;

    private Report reportData;

    @OnClick(R.id.drda_trigger_ok)
    public void ok() {
        dismiss();
    }

    public ReportRespondedDialog(Context context, Report report) {
        super(context);
        reportData = report;
    }

    private void init() {
        WindowManager.LayoutParams param = new WindowManager.LayoutParams();
        param.copyFrom(getWindow().getAttributes());
        param.width = WindowManager.LayoutParams.MATCH_PARENT;
        param.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(param);
    }

    private void setView() {
        title.setText(reportData.getTitle());
        date.setText(reportData.getDate() + " " + reportData.getMonth());
        reportDetail.setText(reportData.getDescription());
        if(reportData.getStatus().equals(ReportStatus.REJECTED)) {
            status.setText(ReportStatus.REJECTED.status());
            status.setBackgroundColor(Color.parseColor("#b90f1a"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_report_detail_responded);
        ButterKnife.bind(this);
        init();
        setView();
    }
}
