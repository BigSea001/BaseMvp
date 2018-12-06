package cn.easier.market.net.interceptor;

import android.text.TextUtils;

import com.bumptech.glide.load.Key;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

import cn.easier.baselibs.net.http.ApiException;
import cn.easier.baselibs.utils.DHLog;
import cn.easier.market.contracts.NetContracts;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * File: ResponseInterceptor.java
 * 作者: 大海
 * 创建日期: 2018/5/12 0012 18:03
 * 描述：
 */
public class ResponseInterceptor implements Interceptor {


    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Response response = chain.proceed(request);
        String body = bufferBody(response);

        if (response.code() == NetContracts.CODE_ERROR_PATH) {
            throw new ApiException(NetContracts.CODE_ERROR_PATH, "没找到接口 " + request.url().encodedPath());
        }

        try {
            if (TextUtils.isEmpty(body) || "null".equalsIgnoreCase(body)) {
                throw new ApiException(NetContracts.CODE_OTHER_ERROR, "服务器没有返回任何数据");
            }
            int code=-1;
            String message = "";
            DHLog.e("HHH", "后端成功返回数据: " + body);

            JSONObject jsonObject = new JSONObject(body);
            code = jsonObject.getInt("code");
            message = jsonObject.getString("message");

            if (!response.isSuccessful()) {
                if (TextUtils.isEmpty(message)) {
                    message = "服务器发生了一点问题";
                }
                throw new ApiException(code, message);
            } else if (code==NetContracts.CODE_SUCCESS) {
                Response build = response.newBuilder()
                        .body(ResponseBody.create(MediaType.parse("application/json"), body))
                        .build();
                return build;
            } else {
                if (TextUtils.isEmpty(message)) {
                    message = "服务器返回错误，并且没有错误消息";
                }
                throw new ApiException(code, message);
            }
        } catch (JSONException e) {
            throw new ApiException(-1, "数据解析错误");
        }
    }

    private String bufferBody(Response response) throws IOException {
        BufferedSource source = response.body().source();
        source.request(Long.MAX_VALUE);
        Buffer buffer = source.buffer();
        return buffer.clone().readString(Charset.forName(Key.STRING_CHARSET_NAME));
    }
}
