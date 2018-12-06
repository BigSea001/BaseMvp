package cn.easier.market.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import cn.easier.baselibs.baseactivity.DHBaseActivity;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.market.R;
import cn.easier.market.beans.QtyAlertAdvert;
import cn.easier.market.beans.SysConfigBean;
import cn.easier.market.contracts.ExtraContracts;
import cn.easier.market.ui.dealer.home.MainContract;
import cn.easier.market.ui.dealer.home.MainPresenterImpl;
import cn.easier.market.ui.dealer.home.ui.DealerMainFragment;
import cn.easier.market.utils.AppUtils;

public class MainActivity extends DHBaseActivity implements MainContract.View {

    private MainPresenterImpl presenter;
    @Override
    public IPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String userType = getIntent().getStringExtra(ExtraContracts.INTENT_DATA);
        if (TextUtils.equals(userType,AppUtils.DEALER)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,new DealerMainFragment()).commitNow();
        } else {

        }

        presenter = new MainPresenterImpl(this,this);
        presenter.getSysConfig();
        presenter.qryPayConfig(AppUtils.getTokenId());
        presenter.qtyStartAdvert(AppUtils.getTokenId());

//        Bundle extras = getIntent().getExtras();
//        if (extras!=null) {
//            int type = extras.getInt(ExtraContracts.INTENT_DATA);
//            if (type==1) {
//                String json = Hawk.get(ExtraContracts.SP_NAME_START);
//                if (TextUtils.isEmpty(json)) return;
//                QtyAlertAdvert alertAdvert = new Gson().fromJson(json, QtyAlertAdvert.class);
//                String advertType = alertAdvert.getAdvertType();
//                if (TextUtils.equals(advertType,"01")) {   // 跳转到商家
//                    Bundle bundle = new Bundle();
//                    bundle.putString(ExtraContracts.INTENT_DATA,alertAdvert.getAdvertValue());
//                    startAct(StoreDetailActivity.class, bundle);
//                } else if (TextUtils.equals(advertType,"02")) {
//                    Bundle bundle = new Bundle();
//                    bundle.putString(Define.INTENT_DATA,alertAdvert.getAdvertValue());
//                    startAct(GoodsDetailActivity.class, bundle);
//                } else if (TextUtils.equals(alertAdvert.getAdvertType(),"03")) {
//                    Bundle bundle = new Bundle();
//                    bundle.putString(Define.INTENT_DATA,alertAdvert.getAdvertValue());
//                    startAct(WebActivity.class, bundle);
//                }
//            }
//        }
    }

    @Override
    public void getSysConfigSuccess(SysConfigBean data) {
        SysConfigBean.VersionInfoBean versionInfo = data.getVersionInfo();
        if (versionInfo!=null) {
//            CheckVersionUtil.checkVersionUpdate(this,versionInfo.getVersion(),versionInfo.getVersionDescp(),versionInfo.getDownloadUrl(),false);
        }
    }
}
