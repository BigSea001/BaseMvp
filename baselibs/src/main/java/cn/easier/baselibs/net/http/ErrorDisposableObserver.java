package cn.easier.baselibs.net.http;

import android.content.Context;
import android.widget.Toast;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import cn.easier.baselibs.net.bean.BaseBean;
import cn.easier.baselibs.utils.DHLog;
import io.reactivex.observers.DisposableObserver;

/**
 */

public abstract class ErrorDisposableObserver<T> extends DisposableObserver<BaseBean<T>> {

    private static final String TAG = "BaseObserver";
    private Context mContext;

    protected ErrorDisposableObserver(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override
    public void onNext(BaseBean<T> value) {
        if (value.getCode()== 200) {
            T t = value.getData();
            onSuccess(t);
        } else {
            onError(value.getMessage());
        }
    }

    @Override
    public void onError(Throwable e) {
        if(e instanceof NoNetWorkException || e instanceof ConnectException ||
                e instanceof SocketTimeoutException ||
                e instanceof TimeoutException){
            onError("网络异常");
        } else if (e instanceof ApiException){
            ApiException e1 = (ApiException) e;
            onError(e1.getMsg());
        } else {
            onError("未知错误");
        }

        DHLog.e(TAG, "onError: ",e );
        onComplete();
    }

    @Override
    public void onComplete() {
    }

    protected abstract void onSuccess(T t);

    protected void onError(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
