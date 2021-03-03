package com.example.daydayup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.daydayup.model.user;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_sign_up,btn_sign_in,btn_forget;

    public static List<user>list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btn_sign_up = findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(this);
        Button btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_sign_in.setOnClickListener(this);
        Button btn_forget = findViewById(R.id.btn_forget);
        btn_forget.setOnClickListener(this);
    }

    public void onClick(View v){
        int id = v.getId();
        Intent intent = new Intent();
        switch(id){
            case R.id.btn_sign_up:
                intent.setClass(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_sign_in:
                intent.setClass(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_forget:
                intent.setClass(LoginActivity.this,ForgetActivity.class);
                startActivity(intent);
                break;
        }

    }

}