package com.qgg.tools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ToolsActivity extends AppCompatActivity {
    private static final String TAG = "ToolsActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        getScreenParameters();
    }

    private void getScreenParameters() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Density = ").append(ScreenUtil.getDensity()).append("，densityDpi = ").append(ScreenUtil.getDensityDpi()).append(System.getProperty("line.separator"));
        stringBuilder.append("屏幕分辨率 = ").append(ScreenUtil.getScreenWidth()).append("*").append(ScreenUtil.getScreenHeight()).append("px（width*height）").append(System.getProperty("line.separator"));
        stringBuilder.append("屏幕物理尺寸 = ").append(ScreenUtil.getScreenSizeInches()).append(" 英寸").append(System.getProperty("line.separator"));
        stringBuilder.append("1dp = ").append(ScreenUtil.getDensity()).append(" px").append(System.getProperty("line.separator"));
        stringBuilder.append("精确密度 = ").append(ScreenUtil.getScreenWidth() / ScreenUtil.getDensity()).append("*").
                append(ScreenUtil.getScreenHeight() / ScreenUtil.getDensity()).append("dp（width*height）").append(System.getProperty("line.separator"));

        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(System.getProperty("line.separator"));
        stringBuilder.append(System.getProperty("line.separator"));

        stringBuilder.append("ppi：每一英寸所对应的像素数目").append(System.getProperty("line.separator")).append(System.getProperty("line.separator"));
        stringBuilder.append("dp或者dip ：独立像素密度（Density-independent pixel）。").append("标准是160dip，即1dp对应1个pixel，计算公式如：px = dp * (dpi / 160)，屏幕密度越大，1dp对应 的像素点越多。")
                .append("上面的公式中有个dpi，也就是当设备的dpi为160的时候1px=1dp").append(System.getProperty("line.separator")).append(System.getProperty("line.separator"));
        stringBuilder.append("dpi：DPI是Dots Per Inch（每英寸所打印的点数）,像素密度，指的是在系统软件上指定的单位尺寸的像素数量，它往往是写在系统出厂配置文件的一个固定值");

        TextView textView = findViewById(R.id.hint);
        textView.setText(stringBuilder.toString());

        Log.e(TAG, stringBuilder.toString());
    }
}

