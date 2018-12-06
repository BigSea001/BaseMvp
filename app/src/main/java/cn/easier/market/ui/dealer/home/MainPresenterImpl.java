package cn.easier.market.ui.dealer.home;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import java.util.HashMap;
import java.util.Map;

import cn.easier.baselibs.basemvp.BasePresenterImpl;
import cn.easier.baselibs.net.http.ErrorDisposableObserver;
import cn.easier.market.beans.PayConfigBean;
import cn.easier.market.beans.QtyAlertAdvert;
import cn.easier.market.beans.SysConfigBean;
import cn.easier.market.contracts.SPContracts;
import cn.easier.market.net.ApiFactory;
import cn.easier.market.net.services.IUserApi;
import cn.easier.market.utils.AppUtils;
import cn.easier.market.utils.CommonUtils;

/**
 * 作者： 大海
 * 时间： 2018/12/6
 * 描述：
 */
public class MainPresenterImpl extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter {

    private IUserApi mUserApi = ApiFactory.getInstance().getUserApi();

    public MainPresenterImpl(Context context, MainContract.View view) {
        super(context, view);
    }


    @Override
    public void qtyStartAdvert(String tokenid) {
        Map<String,String> map = new HashMap<>();
        map.put("tokenid",tokenid);
        createObservable(mUserApi.qtyStartAdvert(mapToJson(map))).subscribe(new ErrorDisposableObserver<QtyAlertAdvert>(mContext) {
            @Override
            protected void onSuccess(QtyAlertAdvert qtyAlertAdvert) {
                Hawk.put(SPContracts.SP_NAME_START,new Gson().toJson(qtyAlertAdvert));
            }
        });
    }

    @Override
    public void qryPayConfig(String tokenid) {
        PayConfigBean configBean = Hawk.get(SPContracts.SP_NAME_PAYCONFIG);
        if (configBean==null || configBean.getWeixin_pay()!=null) {
            Map<String, String> map = new HashMap<>();
            map.put("tokenid", AppUtils.getTokenId());
            createObservable(mUserApi.qryPayConfig(mapToJson(map))).subscribe(new ErrorDisposableObserver<PayConfigBean>(mContext) {
                @Override
                protected void onSuccess(PayConfigBean payConfigBean) {
                    Hawk.put(SPContracts.SP_NAME_PAYCONFIG,payConfigBean);
                }
            });
        }
    }

    @Override
    public void getSysConfig() {
        Map<String,String> map = new HashMap<>();
        map.put("appType","android");
        map.put("version",CommonUtils.getVersionCode());
        createObservable(mUserApi.getSysConfig(mapToJson(map))).subscribe(new ErrorDisposableObserver<SysConfigBean>(mContext) {
            @Override
            protected void onSuccess(SysConfigBean data) {
                Hawk.put(SPContracts.SP_NAME_SYSCONFIG, new Gson().toJson(data));
                        Hawk.put(SPContracts.SP_NAME_PHONE,data.getServiceTel());
                        Hawk.put(SPContracts.SP_NAME_URL,data.getIntroductionUrl());
                        Hawk.put(SPContracts.SP_NAME_ISNEW,false);

                SysConfigBean.VersionInfoBean versionInfo = data.getVersionInfo();
                        if (versionInfo!=null) {
                            String isNew = versionInfo.getIsNew();
                            if (TextUtils.equals(isNew,"true")) {
                                // 有新版本
                                Hawk.put(SPContracts.SP_NAME_ISNEW,true);
                                String version = Hawk.get(SPContracts.SP_NAME_VERSION);
                                if (TextUtils.equals(version,versionInfo.getVersion())) {
                                    return;
                                }
                                Hawk.put(SPContracts.SP_NAME_VERSION,data.getVersionInfo().getVersion());
                                mView.getSysConfigSuccess(data);
                            }
                        }
            }
        });
    }
}
