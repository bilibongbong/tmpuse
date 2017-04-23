package com.ycloud.tashlist.taskitemholder;

import android.content.Context;
import android.util.TypedValue;

/**
 * Created by wangshuhe on 2017/4/23.
 */
public class PixUtil {
    private final static String TAG = "PixUtil";
    public static int dpToPx(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

    public static int spToPx(int sp,Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, context.getResources().getDisplayMetrics());
    }
}
