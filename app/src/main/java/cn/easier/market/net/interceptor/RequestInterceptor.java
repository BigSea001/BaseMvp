package cn.easier.market.net.interceptor;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import cn.easier.baselibs.utils.DHLog;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public class RequestInterceptor implements Interceptor {

    @NonNull
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {

        Request request = chain.request();
        String method = request.method();
        String path = request.url().toString();
        if (TextUtils.equals(method, "GET")) {
            DHLog.e("GET 网络请求-->", path);
        } else {
            HashMap<String, String> map = new HashMap<>();
            RequestBody requestBody = request.body();
            if (requestBody instanceof FormBody) {
                FormBody formBody = (FormBody) requestBody;
                for (int size = formBody.size(); size > 0; size--) {
                    map.put(formBody.name(size), formBody.value(size));
                }
            }
            DHLog.e("POST 网络请求-->", path+ "\t" + new Gson().toJson(map));
        }
        return chain.proceed(request);
    }
}
