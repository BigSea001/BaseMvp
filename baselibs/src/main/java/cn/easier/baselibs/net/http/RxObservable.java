package cn.easier.baselibs.net.http;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * File: RxObservable.java
 * 作者: 大海
 * 创建日期: 2018/5/12 0012 17:02
 * 描述：
 */
public class RxObservable {
    private static final Map<String, List<Disposable>> sObservableDisposableList = new WeakHashMap<>();

    public static <T> Observable<T> create(Observable<T> observable, final String tag) {
        return observable.doOnSubscribe(new Consumer<Disposable>() {
            public void accept(@NonNull Disposable disposable) {
                if (RxObservable.sObservableDisposableList.get(tag) == null) {
                    RxObservable.sObservableDisposableList.put(tag, new ArrayList<Disposable>());
                }
                sObservableDisposableList.get(tag).add(disposable);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static void dispose() {
        try {
            for (List<Disposable> disposables : sObservableDisposableList.values()) {
                for (Disposable disposable : disposables) {
                    if (!(disposable == null || disposable.isDisposed())) {
                        disposable.dispose();
                    }
                }
                disposables.clear();
            }
        } catch (Exception e) {
            Log.e("rae", "释放HTTP请求失败！", e);
        } finally {
            sObservableDisposableList.clear();
        }
    }

    public static void dispose(String tag) {
        List<Disposable> disposables = sObservableDisposableList.get(tag);
        if (disposables!=null) {
            for (Disposable disposable : disposables) {
                if (disposable!=null)
                disposable.dispose();
            }
            disposables.clear();
        }
    }

}
