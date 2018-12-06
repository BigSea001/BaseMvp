package cn.easier.baselibs.net.http;


import android.content.Context;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

import cn.easier.baselibs.utils.DHLog;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * BaseInterceptor，use set okhttp call header
 * Created by Tamic on 2016-06-30.
 */
public class BaseInterceptor<T> implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");

    private Context context;
    private Map<String, T> headers;

    public BaseInterceptor(Map<String, T> headers, Context context) {
        this.context = context;
        this.headers = headers;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if(!NetworkUtil.isNetworkAvailable(context)){
            throw new NoNetWorkException();
        }
        Request request = chain.request();

        DHLog.e("intercept", "请求的网址: "+ URLDecoder.decode(request.url().toString(), "UTF-8"));
        RequestBody body = request.body();
        if (body!=null) {
            bodyToString(request);
        }

        Request.Builder builder = request.newBuilder();
        if (headers != null && headers.size() > 0) {
            Set<String> keys = headers.keySet();
            for (String headerKey : keys) {
                builder.addHeader(headerKey, headers.get(headerKey) == null? "": (String)headers.get(headerKey)).build();
            }
        }
        Response response = chain.proceed(builder.build());

        ResponseBody peekBody = response.peekBody(1024 * 124);
        String string = peekBody.string();
        DHLog.e("intercept", "返回数据: "+string);
        return response;

    }

    private void bodyToString(Request request) {
        try {
            Request copy = request.newBuilder().build();
            RequestBody body = copy.body();
            if (body == null) return;
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            Charset charset = getCharset(body.contentType());
            DHLog.e("intercept", "请求参数: " + buffer.readString(charset));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Charset getCharset(MediaType contentType) {
        Charset charset = contentType != null ? contentType.charset(UTF8) : UTF8;
        if (charset == null) charset = UTF8;
        return charset;
    }
}
