package cn.easier.market.net;

import cn.easier.market.net.services.IUserApi;
import okhttp3.OkHttpClient;

/**
 * File: ApiProvider.java
 * 作者: 大海
 * 创建日期: 2018/5/12 0012 17:16
 * 描述：
 */
public interface ApiProvider {

    void clear();

    OkHttpClient client();

    IUserApi getUserApi();
}
