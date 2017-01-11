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

public class ReportApprovedDialog extends Dialog {

    @BindView(R.id.drda_output_title) TextView title;
    @BindView(R.id.drda_output_date) TextView date;
    @BindView(R.id.drda_output_report_detail) TextView reportDetail;

    @OnClick(R.id.drda_trigger_ok)
    public void ok() {
        dismiss();
    }

    public ReportApprovedDialog(Context context) {
        super(context);
    }

    private void init() {
        WindowManager.LayoutParams param = new WindowManager.LayoutParams();
        param.copyFrom(getWindow().getAttributes());
        param.width = WindowManager.LayoutParams.MATCH_PARENT;
        param.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(param);
    }

    private void setView() {
        title.setText("Report Title");
        date.setText("Report Date");
        reportDetail.setText("In the mid-1990s Japan had a smaller proportion of over-65s than Britain or Germany. Thanks to an ultra-low birth rate, admirable longevity and a stingy immigration policy, it is now by far the oldest country in the OECD. And senescence is spreading to new areas. Many rural Japanese villages have been old for years, because young people have left them for cities. Now the suburbs are greying, too.");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_report_detail_approved);
        ButterKnife.bind(this);
        init();
        setView();
    }
}
