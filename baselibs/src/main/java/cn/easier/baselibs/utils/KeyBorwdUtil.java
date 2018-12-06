package cn.easier.baselibs.utils;

import android.app.Activity;
import android.content.Context;
import android.view.inputmethod.InputMethodManager;

/**
 * 系统工具类
 *
 * @author yanchunhan
 * @created 2014-04-02
 */
public class KeyBorwdUtil {


    /**
     * 隐藏键盘
     */
    public static void dismissKeyBorwd(Activity activity) {
        try {
            if (activity.getCurrentFocus() != null) {
                ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(activity.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭键盘,稍微不同于上面的隐藏键盘
     * @param activity
     */
    public static void closeKeyBord(Activity activity){
        InputMethodManager imm = (InputMethodManager)activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&activity.getCurrentFocus()!=null){
            if (activity.getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    /**
     * 弹出键盘
     */
    public static void showKeyBorwd(Context context) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
    }
}
