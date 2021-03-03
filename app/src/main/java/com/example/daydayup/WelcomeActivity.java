package com.example.daydayup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity {
    private ImageView welcomeImg;
    private  static final String TAG = "WelcomeActivity";
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置为全屏
        setContentView(R.layout.activity_welcome);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,LoginActivity.class));
                finish();
            }
        };

        handler.postDelayed(runnable,3000);
    }

        protected void onDestroy() {
            super.onDestroy();
            handler.removeCallbacks(runnable);
            Log.i(TAG,"移除runable");

        }

}