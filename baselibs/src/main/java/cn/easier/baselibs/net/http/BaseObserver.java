package cn.easier.baselibs.net.http;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import cn.easier.baselibs.net.bean.BaseBean;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * File: BaseObserver.java
 * 作者: 大海
 * 创建日期: 2018/5/11 0011 10:31
 * 描述：
 */
public abstract class BaseObserver<T> implements Observer<BaseBean<T>> {

    private static final String TAG = "BaseObserver";
    private Context mContext;

    protected BaseObserver(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseBean<T> value) {
        if (value.getCode()==200) {
            T t = value.getData();
            onSuccess(t);
        } else {
            onError(value.getMessage());
            // 在这里处理错误码
        }
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof NoNetWorkException || e instanceof ConnectException ||
                e instanceof SocketTimeoutException ||
                e instanceof TimeoutException){
            Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "网络异常", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onComplete() {
        Log.d(TAG, "onComplete");
    }

    protected abstract void onSuccess(T t);

    protected void onError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
