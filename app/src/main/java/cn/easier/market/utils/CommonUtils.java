package cn.easier.market.utils;


import cn.easier.market.BuildConfig;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public class CommonUtils {

    /**
     * 获取版本号
     * @return
     */
    public static String getVersionCode() {
        int versionCode = BuildConfig.VERSION_CODE;
        return String.valueOf(versionCode);
    }
}
