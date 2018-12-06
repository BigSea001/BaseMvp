package cn.easier.market.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import cn.easier.baselibs.baseactivity.DHBaseActivity;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.market.R;
import cn.easier.market.beans.QtyAlertAdvert;
import cn.easier.market.contracts.SPContracts;
import cn.easier.market.ui.account.ui.LoginActivity;

/**
 * File: StartActivity.java
 * 作者: 大海
 * 创建日期: 2018/6/2 0002 16:29
 * 描述：
 */
public class StartActivity extends DHBaseActivity {

    private Handler handler = new Handler();
    private Runnable action;
    private TextView tv_cut_down;

    @Override
    public IPresenter getPresenter() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        initView();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startAct(LoginActivity.class);
            }
        },3000);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected boolean isSetStatusBarColor() {
        return false;
    }

    private void initView() {
        tv_cut_down = findViewById(R.id.tv_cut_down);
        tv_cut_down.setVisibility(View.GONE);
        ImageView iv_pic = findViewById(R.id.iv_pic);
        String json = Hawk.get(SPContracts.SP_NAME_START);
        if (TextUtils.isEmpty(json))return;
        QtyAlertAdvert alertAdvert = new Gson().fromJson(json, QtyAlertAdvert.class);
        if (alertAdvert==null) return;
        Glide.with(this).load(alertAdvert.getImgPathView()).into(iv_pic);
        iv_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bundle bundle = new Bundle();
//            bundle.putInt(Define.INTENT_DATA,1);
//            startAct(LMainActivity.class, bundle);
//            finish();
            }
        });

        tv_cut_down.setVisibility(View.VISIBLE);
        action = new Runnable() {
            private int time = 3;

            @Override
            public void run() {
                if (time-- > 0) {
                    if (tv_cut_down != null) {
                        tv_cut_down.setText(time + " 跳过");
                        tv_cut_down.postDelayed(this, 1000);
                    }
                } else {
                    if (isFinishing()) {
                        return;
                    }
                    startAct(LoginActivity.class);
                    finish();
                }
            }
        };
        tv_cut_down.postDelayed(action, 1000);
        tv_cut_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFinishing()) {
                    return;
                }
                startAct(LoginActivity.class);
                finish();
            }
        });
    }

    @Override
    public void onDestroy() {
        if (tv_cut_down != null) tv_cut_down.removeCallbacks(action);
        super.onDestroy();
    }
}
