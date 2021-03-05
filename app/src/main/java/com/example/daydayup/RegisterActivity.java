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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private  Button btn_back,btn_save;
    private EditText et_account,et_password,et_password_confirm,et_phone;
    private userDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(this);

         et_account = findViewById(R.id.et_account);
         et_password = findViewById(R.id.et_password);
         et_password_confirm = findViewById(R.id.et_password_confirm);
         et_phone= findViewById(R.id.et_phone);
         userDao = new userDao(RegisterActivity.this);
    }
    public void onClick(View v){
        int id = v.getId();
        switch(id){
            case R.id.btn_back:
                //跳转到登录界面
                Intent intent = new Intent();
                intent.setClass(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_save:
                //获取注册信息
                String account = et_account.getText().toString();
                String password = et_password.getText().toString();
                String password_confirm= et_password_confirm.getText().toString();
                String phone = et_phone.getText().toString();
                //判断内容是否合法
                if(account.trim().length() == 0)
                {
                    Toast.makeText(RegisterActivity.this,"账号不能为空",Toast.LENGTH_SHORT).show();
                    return;//结束方法
                }
                if(password.trim().length() == 0)
                {
                    Toast.makeText(RegisterActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!password.equals(password_confirm))
                {
                    Toast.makeText(RegisterActivity.this,"两次输入密码不一致",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(phone.trim().length() == 0)
                {
                    Toast.makeText(RegisterActivity.this,"手机号不能为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //判断账号和手机号是否重复
                if(userDao.isExistByAccountAndPhone(account,phone)){
                    Toast.makeText(RegisterActivity.this,"账号或手机号已存在，请重新输入",Toast.LENGTH_SHORT).show();
                }
                user bean = new user(account,password,phone);   //将数据打包到user对象中
                userDao.insert(bean);//添加到集合中
                finish();   //返回登录界面

                break;
        }
    }

}
