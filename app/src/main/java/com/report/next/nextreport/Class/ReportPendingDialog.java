package com.report.next.nextreport.Class;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by USER on 11/01/2017.
 */

public class ReportPendingDialog extends Dialog {

    @BindView(R.id.drdp_output_title) TextView title;
    @BindView(R.id.drdp_output_date) TextView date;
    @BindView(R.id.drdp_output_report_detail) TextView reportDetail;

    private Report reportData;

    @OnClick(R.id.drdp_trigger_edit)
    public void edit() {

    }

    @OnClick(R.id.drdp_trigger_ok)
    public void ok() {
        dismiss();
    }

    public ReportPendingDialog(Context context, Report report) {
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_report_detail_pendings);
        ButterKnife.bind(this);
        init();
        setView();
    }
}
