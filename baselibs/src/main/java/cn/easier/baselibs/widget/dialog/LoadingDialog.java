package cn.easier.baselibs.widget.dialog;

import android.app.Dialog;
import android.content.Context;


import com.dahai.baselibs.R;

import cn.easier.baselibs.widget.LoadingView;

/**
 * 描述：
 * 时间：2018/10/8/008
 * 作者：xjh
 */
public class LoadingDialog extends Dialog {

    private LoadingView loadingView;

    public LoadingDialog(Context context) {
        super(context, R.style.DialogWithClose);
        setContentView(R.layout.dialog_loading);
        setCancelable(false);

        loadingView = findViewById(R.id.load);
    }

    @Override
    public void show() {
        super.show();

        loadingView.start();
    }

    @Override
    public void dismiss() {
        if (isShowing()) {
            try {
                loadingView.stop();
                super.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
