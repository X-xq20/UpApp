package com.example.daydayup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button btn_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
    }
    public void onClick(View v){
        int id = v.getId();
        Intent intent = new Intent();
        switch(id){
            case R.id.btn_back:
                intent.setClass(ForgetActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

}