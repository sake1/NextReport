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
 * register.jpg
 */

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.ar_input_email) EditText email;
    @BindView(R.id.ar_input_password) EditText password;
    @BindView(R.id.ar_input_password_confirm) EditText passwordConfirm;

    @OnClick(R.id.ar_trigger_register)
    public void register() {
        if(validate()) {
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    @OnClick(R.id.ar_trigger_login)
    public void login() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    private boolean validate() {
        if(email.getText().toString().equals("") ||
                password.getText().toString().equals("") ||
                passwordConfirm.getText().toString().equals("")) {
            Toast.makeText(this, "Please Fill All Field", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password.getText().toString().equals(passwordConfirm.getText().toString())) {
            Toast.makeText(this, "Password You Input Mismatch", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
}
