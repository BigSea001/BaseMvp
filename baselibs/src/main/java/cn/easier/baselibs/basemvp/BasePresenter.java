package cn.easier.baselibs.basemvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BasePresenter {

    protected CompositeDisposable disposables;

    public void addDisposabe(Disposable disposable){
        if(disposables == null){
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);

    }
}
