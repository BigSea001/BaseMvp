package cn.easier.market.net;

import android.content.Context;

import retrofit2.Retrofit;

/**
 * File: RetrofitApi.java
 * 作者: 大海
 * 创建日期: 2018/5/12 0012 17:18
 * 描述：
 */
public abstract class RetrofitApi {

    final Context mContext;

    Retrofit mRetrofit;

    protected abstract Retrofit onCreate(Context context);

    RetrofitApi(Context context) {
        this.mContext = context;
        this.mRetrofit = onCreate(context);
    }


    public Context getContext() {
        return this.mContext;
    }
}
