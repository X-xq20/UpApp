package com.example.daydayup.dao;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.daydayup.db.AppSqliteHelper;
import com.example.daydayup.model.user;


public class userDao {
    private AppSqliteHelper helper;
    private  String tableName = "user";
    private Integer id;

    public  userDao(Context context)
    {
        helper = new AppSqliteHelper(context);
    }

    /**
     * 查询用户（账号、密码）
     * @param account
     * @param password
     * @return
     */
    public user login(String account,String password)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        user user = null;
        Cursor c = db.query(tableName,null,"name=? and password = ?",new String[]{account,password},null,null,null,null);
        if(c!=null&&c.getCount()>0){
            if(c.moveToNext()){
                user = new user();
                user.setId(c.getColumnIndex("id"));
                user.setAccount(account);
                user.setPassword(password);
                user.setPhone(c.getString(c.getColumnIndex("phone")));

            }
        }
        return user;
    }
//根据账号或手机号查询用户是否存在
    public boolean isExistByAccountAndPhone(String account,String phone)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c =db.query(tableName,null,"name= ? or phone = ?",new String[]{account,phone},null,null,null,null);
        if(c != null && c.getCount()>0){
            return c.moveToNext();
        }
        return  false;
    }
    /**
     * 添加用户
     * @param bean
     * @return
     */
    public boolean insert(user bean)
    {
     SQLiteDatabase  db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",bean.getAccount());
        values.put("password",bean.getPassword());
        values.put("phone",bean.getPhone());
        long insert = db.insert(tableName,null,values);
        return insert > 0;

    }
    //根据账号或手机号查询密码
    public String queryPasswordByAccountAndPhone(String account,String phone)
    {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c =db.query(tableName,null,"name= ? or phone = ?",new String[]{account,phone},null,null,null,null);
        if(c != null && c.getCount()>0){
            if(c.moveToNext()){
                return c.getString(c.getColumnIndex("password"));
            }

        }
        return  null;
    }
}
