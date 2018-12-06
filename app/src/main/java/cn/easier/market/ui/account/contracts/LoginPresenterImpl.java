package cn.easier.market.ui.account.contracts;

import android.content.Context;

import java.util.HashMap;

import cn.easier.baselibs.basemvp.BasePresenterImpl;
import cn.easier.baselibs.net.http.ErrorDisposableObserver;
import cn.easier.market.beans.SysConfigBean;
import cn.easier.market.beans.User;
import cn.easier.market.net.ApiFactory;
import cn.easier.market.net.services.IUserApi;
import cn.easier.market.utils.CommonUtils;

/**
 * File: LoginPresenterImpl.java
 * 作者: 大海
 * 创建日期: 2018/5/12 0012 16:56
 * 描述：
 */
public class LoginPresenterImpl extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {

    private IUserApi mUserApi = ApiFactory.getInstance().getUserApi();

    public LoginPresenterImpl(Context context, LoginContract.View view) {
        super(context, view);
    }

    @Override
    public void getSysConfig() {
        HashMap<String, String> param = new HashMap<>();
        param.put("appType","android");
        param.put("version",CommonUtils.getVersionCode());

        createObservable(mUserApi.getSysConfig(mapToJson(param))).subscribe(new ErrorDisposableObserver<SysConfigBean>(mContext) {
            @Override
            protected void onSuccess(SysConfigBean user) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void login(String phone,String password) {
        mView.showDialog();
        HashMap<String, String> param = new HashMap<>();
        param.put("account",phone);
        param.put("password",password);

        createObservable(mUserApi.login(mapToJson(param))).subscribe(new ErrorDisposableObserver<User>(mContext) {
            @Override
            protected void onSuccess(User user) {
                mView.loginSuccess(user);
            }

            @Override
            public void onComplete() {
                mView.dismiss();
            }
        });
    }


}
