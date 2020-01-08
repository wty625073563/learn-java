package com.example.music.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.music.R;

import java.util.Timer;
import java.util.TimerTask;

import static android.content.ContentValues.TAG;


// 延时三秒后跳转页面
public class WelcomeActivity extends BaseActivity {

    /**
     * 声明mTimer变量
     */
    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    /**
     * 初始化（延时）
     */
    private void init() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
//                Log.e(TAG, "run: WecomeActvity，当前线程："+ Thread.currentThread());
//                toMain();
                toLogin();
            }
        }, 3 * 1000);
    }

    /**
     * 跳转页面到主页面
     */
    private void toMain() {
        Intent intent = new Intent(this, MainActivity.class);
        // 跳转
        startActivity(intent);
        // 关闭当前页面
        finish();
    }

    /**
     * 跳转页面到登陆页
     */
    private void toLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        // 跳转
        startActivity(intent);
        // 关闭当前页面
        finish();
    }
}
