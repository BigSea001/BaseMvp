package cn.easier.market.net;

import android.content.Context;
import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import cn.easier.market.contracts.NetContracts;
import cn.easier.market.net.interceptor.RequestInterceptor;
import cn.easier.market.net.interceptor.ResponseInterceptor;
import cn.easier.market.net.services.IUserApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * File: ApiProviderImpl.java
 * 作者: 大海
 * 创建日期: 2018/5/12 0012 17:17
 * 描述：
 */
public class ApiProviderImpl extends RetrofitApi implements ApiProvider{
    private OkHttpClient httpClient;

    protected ApiProviderImpl(Context context) {
        super(context);
    }

    @Override
    protected Retrofit onCreate(Context context) {
        this.httpClient = new OkHttpClient.Builder()
                .addInterceptor(new RequestInterceptor())
                .addInterceptor(new ResponseInterceptor())
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();
        return new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(NetContracts.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private <T> T create(Class<T> cls) {
        return this.mRetrofit.create(cls);
    }


    @Override
    public void clear() {

    }

    @Override
    public OkHttpClient client() {
        return httpClient;
    }

    @Override
    public IUserApi getUserApi() {
        return create(IUserApi.class);
    }
}
