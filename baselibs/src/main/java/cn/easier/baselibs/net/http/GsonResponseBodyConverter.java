package cn.easier.baselibs.net.http;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import cn.easier.baselibs.net.bean.BaseBean;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * File: GsonResponseBodyConverter.java
 * 作者: 大海
 * 创建日期: 2018/5/11 0011 10:40
 * 描述：
 */
final class GsonResponseBodyConverter <T> implements Converter<ResponseBody,T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        BaseBean httpResult = gson.fromJson(response, BaseBean.class);
        if (httpResult.getCode()!=200) {
            value.close();
            throw new ApiException(httpResult.getCode(), httpResult.getMessage());
        }
        MediaType contentType = value.contentType();
        Charset charset = contentType != null ? contentType.charset(Charset.forName("UTF-8")) : Charset.forName("UTF-8");
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader = new InputStreamReader(inputStream, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } finally {
            value.close();
        }
    }
}
