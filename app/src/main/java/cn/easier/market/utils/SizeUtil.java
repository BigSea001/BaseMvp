package cn.easier.market.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * File: SizeUtil.java
 * 作者: 大海
 * 创建日期: 2018/5/10 0010 10:15
 * 描述：尺寸工具类
 */
public class SizeUtil {

    /**
     * 将dp转成px
     * @param context 上下文
     * @param dpValue dp值
     * @return 返回像素单位
     */
    public static int dp2px(Context context,float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int getWidth(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density = dm.density;
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        return width;
    }
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
