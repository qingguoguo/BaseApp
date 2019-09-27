package com.qgg.baseapp;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.qgg.jni.HelloLibrary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TestBroadcastReceiver testBroadcastReceiver = new TestBroadcastReceiver();
        // getApplicationContext().registerReceiver(testBroadcastReceiver, );
        // unregisterReceiver(testBroadcastReceiver);
    }

    public void startAnimator(View view) {
        TextView textView = findViewById(R.id.tv);
        textView.setText("显示动画啊");
        //method1(textView);
        method2(textView, "哈哈，你看我可以移动的");
        method2(textView, new HelloLibrary().sayHello());
    }

    private void method2(final TextView textView, final String text) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, text.length());
        valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int index = (int) animation.getAnimatedValue();
                Log.e("MainActivity", "index = " + index);
                textView.setText(text.substring(0, index));
            }
        });
        valueAnimator.setDuration(text.length() * 150 + 200);
        valueAnimator.start();
    }

    class TestBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}
