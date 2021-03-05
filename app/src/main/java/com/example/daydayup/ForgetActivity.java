package com.example.daydayup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daydayup.dao.userDao;
import com.example.daydayup.model.user;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button btn_back,btn_inquire;
    private EditText et_account,et_phone;
    private userDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
         btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_inquire = findViewById(R.id.btn_inquire);
        btn_inquire.setOnClickListener(this);
        et_account = findViewById(R.id.et_account);
        et_phone = findViewById(R.id.et_phone);
        userDao = new userDao(this);
    }
    public void onClick(View v){
        int id = v.getId();
        Intent intent = new Intent();
        switch(id){
            case R.id.btn_back:
                intent.setClass(ForgetActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_inquire:
                //获取输入框内容
                String account = et_account.getText().toString();
                String phone = et_phone.getText().toString();
                //判断内容是否合法
                if(account.trim().length() == 0)
                {
                    Toast.makeText(ForgetActivity.this,"账号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(phone.trim().length() == 0)
                {
                    Toast.makeText(ForgetActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                String password = userDao.queryPasswordByAccountAndPhone(account,phone);
                if(password == null)
                {
                    Toast.makeText(ForgetActivity.this,"该账号和手机无法找到相应密码",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ForgetActivity.this,"您的密码为"+password,Toast.LENGTH_SHORT).show();
                }
          break;

        }
    }

}