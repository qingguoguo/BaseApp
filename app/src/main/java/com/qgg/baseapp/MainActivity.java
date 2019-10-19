package com.qgg.baseapp;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

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
//        method2(textView, "哈哈，你看我可以移动的");
//        method2(textView, new HelloLibrary().sayHello());
        getDensity();
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

    private void getDensity() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();

        Log.e(TAG, "Density is " + displayMetrics.density + " densityDpi is " + displayMetrics.densityDpi);
        Log.e(TAG, "屏幕分辨率：" + displayMetrics.heightPixels + "*" + displayMetrics.widthPixels + "px（height*width）");
        Log.e(TAG, "屏幕物理尺寸：" + displayMetrics.heightPixels + "*" + displayMetrics.widthPixels + "英寸");

        Log.e(TAG, "ppi：每一英寸所对应的像素数目");
        Log.e(TAG, "Density-independent pixel (dp)独立像素密度。标准是160dip.即1dp对应1个pixel，计算公式如：px = dp * (dpi / 160)，屏幕密度越大，1dp对应 的像素点越多。\n" +
                "上面的公式中有个dpi，dpi为DPI是Dots Per Inch（每英寸所打印的点数），也就是当设备的dpi为160的时候1px=1dp");
        getScreenSizeOfDevice2();
    }

    private void getScreenSizeOfDevice2() {
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getRealSize(point);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        double x = Math.pow(point.x / dm.xdpi, 2);
        double y = Math.pow(point.y / dm.ydpi, 2);
        double screenInches = Math.sqrt(x + y);
        Log.e(TAG, "Screen inches : " + screenInches);
    }

    class TestBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }
}
