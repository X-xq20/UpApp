package com.example.daydayup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daydayup.dao.userDao;
import com.example.daydayup.model.user;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_sign_up,btn_sign_in,btn_forget;
    private EditText et_user,et_pwd;

   // public static List<user>list = new ArrayList<>();
    private userDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_sign_up = findViewById(R.id.btn_sign_up);
        btn_sign_up.setOnClickListener(this);
        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_sign_in.setOnClickListener(this);
        btn_forget = findViewById(R.id.btn_forget);
        btn_forget.setOnClickListener(this);

        et_user = findViewById(R.id.et_user);
        et_pwd = findViewById(R.id.et_pwd);
        userDao = new userDao(this);
    }

    public void onClick(View v){
        int id = v.getId();
        Intent intent = new Intent();
        switch(id){
            case R.id.btn_sign_up:
                //获取内容
                String account = et_user.getText().toString();
                String password = et_pwd.getText().toString();
                //判断是否合理
                if(account.trim().length() == 0)
                {
                    Toast.makeText(LoginActivity.this,"账号不能为空",Toast.LENGTH_SHORT).show();
                    return;//结束方法
                }
                if(password.trim().length() == 0)
                {
                    Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //登录验证
                //user user = dologin(account,password);
                user user = userDao.login(account,password);
                if(user == null){
                    Toast.makeText(LoginActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    intent.setClass(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
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