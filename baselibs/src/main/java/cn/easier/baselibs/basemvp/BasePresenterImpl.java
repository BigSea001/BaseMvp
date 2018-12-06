package cn.easier.baselibs.basemvp;

import android.content.Context;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import cn.easier.baselibs.net.http.RxObservable;
import io.reactivex.Observable;

/**
 * File: BasePresenterImpl.java
 * 作者: 大海
 * 创建日期: 2018/5/12 0012 17:00
 * 描述：
 */
public class BasePresenterImpl<T extends BaseView> implements IPresenter {

    protected Context mContext;
    private String mTag = getClass().getName();
    protected T mView;

    public BasePresenterImpl(Context context, T view) {
        this.mView = view;
        this.mContext = context;
    }


    protected <E> Observable<E> createObservable(Observable<E> observable) {
        return RxObservable.create(observable, this.mTag);
    }

    @Override
    public void destroy() {
        cancelRequest();
        this.mView = null;
        this.mContext = null;
    }

    protected void cancelRequest() {
        RxObservable.dispose(getTag());
    }

    public String getTag() {
        return this.mTag;
    }

    public void setTag(String tag) {
        this.mTag = tag;
    }

    protected String mapToJson(Map<String, String> map) {
        if (map!=null) {
            return new Gson().toJson(map);
        }
        return "";
    }

}
