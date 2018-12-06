package cn.easier.market.net;

import android.content.Context;

import cn.easier.market.net.services.IUserApi;

/**
 * File: ApiFactory.java
 * 作者: 大海
 * 创建日期: 2018/5/12 0012 17:17
 * 描述：
 */
public class ApiFactory {
    private static ApiProvider instance;

    public static void init(Context applicationContext) {
        if (instance == null) {
            synchronized (ApiFactory.class) {
                if (instance == null) {
                    instance = new ApiProviderImpl(applicationContext);
                }
            }
        }
    }

    public static ApiProvider getInstance() {
        if (instance != null) {
            return instance;
        }
        throw new NullPointerException("请在Application里面调动方法：ApiFactory.init(applicationContext)初始化接口实例。");
    }
}
