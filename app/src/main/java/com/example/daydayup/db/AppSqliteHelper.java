package com.example.daydayup.db;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AppSqliteHelper extends SQLiteOpenHelper {

    public AppSqliteHelper(@Nullable Context context) {
        //创建数据库
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建两个表
        db.execSQL("create table user(id Integer primary key autoincrement,name varchar(20),password varchar(40), phone varchar(11))");
        db.execSQL("create table concater(id Integer primary key autoincrement,name varchar(20),picture varchar(40), phone varchar(11))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
