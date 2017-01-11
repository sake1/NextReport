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
 * Login.jpg
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.al_input_email) EditText email;
    @BindView(R.id.al_input_password) EditText password;

    @OnClick(R.id.al_trigger_login)
    public void login() {
        if(email.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Inccorect Email/Password", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.al_trigger_signin)
    public void signin() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.al_trigger_forgetpass)
    public void forgetPassword() {
        Intent intent = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}
