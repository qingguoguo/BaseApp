package com.qgg.tools;

import android.content.res.Resources;

/**
 * 作者：wangqing
 * 创建日期：2019/10/21 on 11:24
 * 描述：
 */
public class ScreenUtil {
    private ScreenUtil() {
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static float getDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int getDensityDpi() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    public static float getScaledDensity() {
        return Resources.getSystem().getDisplayMetrics().scaledDensity;
    }

    /**
     * 在x方向上每英寸屏幕的精确物理像素
     */
    public static float getXdpi() {
        return Resources.getSystem().getDisplayMetrics().xdpi;
    }

    /**
     * 在Y方向上每英寸屏幕的精确物理像素
     */
    public static float getYdpi() {
        return Resources.getSystem().getDisplayMetrics().ydpi;
    }

    public static double getScreenSizeInches() {
        double x = Math.pow(ScreenUtil.getScreenWidth() / ScreenUtil.getXdpi(), 2);
        double y = Math.pow(ScreenUtil.getScreenHeight() / ScreenUtil.getYdpi(), 2);
        return Math.sqrt(x + y);
    }
}
