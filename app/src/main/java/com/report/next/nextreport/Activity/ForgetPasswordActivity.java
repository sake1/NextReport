package com.report.next.nextreport.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.report.next.nextreport.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Forget_password.jpg
 */

public class ForgetPasswordActivity extends AppCompatActivity {

    @BindView(R.id.afp_input_email) EditText email;

    @OnClick(R.id.afp_trigger_reset)
    public void resetPassword() {
        Toast.makeText(this, "Password Reseted", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.afp_trigger_login)
    public void login() {
        Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.afp_trigger_signin)
    public void signin() {
        Intent intent = new Intent(ForgetPasswordActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        ButterKnife.bind(this);
    }
}
