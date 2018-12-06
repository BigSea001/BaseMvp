package cn.easier.baselibs.net.http;

import android.content.Context;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * http helper负责创建ApiService实例
 */

public class HttpHelper {

    private static volatile HttpHelper httpHelper;
    private Context context;
    private Retrofit mRetrofitClient;
    private HashMap<String, Object> mServiceMap;
    private static final String BASE_URL = "http://47.104.178.80/guobao/api/";

    public static HttpHelper getInstance(Context context) {
        if (httpHelper==null) {
            synchronized (HttpHelper.class) {
                if (httpHelper==null) {
                    httpHelper = new HttpHelper(context);
                }
            }
        }
        return httpHelper;
    }

    private HttpHelper(Context context) {
        this.context = context;
        mServiceMap = new HashMap<>();
        initRetrofitClient();
    }


    @SuppressWarnings("unchecked")
    public <S> S getService(Class<S> serviceClass) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return (S) mServiceMap.get(serviceClass.getName());
        } else {
            Object obj = createService(serviceClass, null);
            mServiceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }


    }

    @SuppressWarnings("unchecked")
    public <S> S getService(Class<S> serviceClass, OkHttpClient client) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return (S) mServiceMap.get(serviceClass.getName());
        } else {
            Object obj = createService(serviceClass, client);
            mServiceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }
    }

    private void initRetrofitClient() {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new BaseInterceptor<>(null,context))
                .build();
        mRetrofitClient = createRetrofitClient(httpClient);
    }

    private Retrofit createRetrofitClient(OkHttpClient httpClient) {

        return new Retrofit.Builder()
                .client(httpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(CustomGsonConverterFactory.create()).build();
    }

    private <S> S createService(Class<S> serviceClass, OkHttpClient client){
        if(client == null){
            return mRetrofitClient.create(serviceClass);
        }else{
            return createRetrofitClient(client).create(serviceClass);
        }
    }

}
