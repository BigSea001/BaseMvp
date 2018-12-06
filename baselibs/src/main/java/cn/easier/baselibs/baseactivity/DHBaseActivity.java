package cn.easier.baselibs.baseactivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.dahai.baselibs.R;
import com.gyf.barlibrary.ImmersionBar;

import java.util.Stack;

import cn.easier.baselibs.basemvp.BaseView;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.baselibs.utils.AppManager;
import cn.easier.baselibs.utils.DHLog;
import cn.easier.baselibs.utils.KeyBorwdUtil;
import cn.easier.baselibs.widget.dialog.LoadingDialog;


public abstract class DHBaseActivity extends FragmentActivity implements BaseView {

    private LoadingDialog loadingDialog;
    private InputMethodManager inputMethodManager;
    public ImmersionBar mImmersionBar;
    private Stack<DHBaseFragment> fragmentStack;//将fragment存进栈对列
    private FragmentManager fragmentManager;//fragment管理器
    private int paramInt;//用于存放fragment的布局id
    protected String TAG;

    public abstract IPresenter getPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mImmersionBar = ImmersionBar.with(this);//初始化
        if (isSetStatusBarColor()) {
            mImmersionBar.statusBarColor(R.color.white).statusBarDarkFont(true,0.2f).fitsSystemWindows(true);
        }
        mImmersionBar.init();

        TAG = getLocalClassName();
        DHLog.e(TAG, "onCreate:进入的 activity " + TAG );
        AppManager.getAppManager().addActivity(this);
    }

    protected boolean isSetStatusBarColor() {
        return true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
        }
        dismiss();
        // 结束Activity&从堆栈中移除
        AppManager.getAppManager().finishActivity(this);
        //销毁fragment单列对象，和资源
        if (fragmentStack != null) {
            fragmentStack.clear();
        }
        if (getPresenter() != null) {
            getPresenter().destroy();
        }
    }

    protected void startAct(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    protected void startAct(Class clazz,Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    protected void startActForResult(Class clazz,int requestCode) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, requestCode);
    }

    protected void startActForResult(Class clazz,Bundle bundle,int requestCode) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent, requestCode);
    }

    @Override
    protected void onResume() {
        /**
         * 设置为竖屏
         */
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 隐藏键盘
        KeyBorwdUtil.dismissKeyBorwd(this);
    }

    /**
     * 设置装fragment的layout
     *
     * @param paramInt 存放fragment的布局id
     */
    public void setParamInt(int paramInt) {
        this.paramInt = paramInt;
    }

    /**
     * 启动fragment 主要是应对tab效果
     */
    public void startFragment(DHBaseFragment f) {
        if (f == null)
            return;
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        if (fragmentStack == null) {
            fragmentStack = new Stack<>();
        }
        try {
            DHBaseFragment currentF;
            if (fragmentStack.size() > 0) {// 当前堆栈容量大于0，隐藏栈顶的对象
                FragmentTransaction t1 = fragmentManager.beginTransaction();//fragment事务
                currentF = fragmentStack.peek();
                t1.hide(currentF).commitAllowingStateLoss();
            }
            FragmentTransaction t = fragmentManager.beginTransaction();//fragment事务
            // 针对单例模式的fragment做处理
            if (fragmentStack.contains(f) && f.registStartMode() == DHBaseFragment.singleTask) {
                fragmentStack.remove(f);
                fragmentStack.push(f);
                t.show(f).commitAllowingStateLoss();
                return;
            }
            t.add(paramInt, f).commitAllowingStateLoss();
            fragmentStack.push(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && inputMethodManager.isActive()) {
            KeyBorwdUtil.dismissKeyBorwd(this);
        }
        return super.dispatchTouchEvent(event);
    }

    public void handleBack(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        if (!loadingDialog.isShowing()) {
            loadingDialog.show();
        }
    }

    @Override
    public void dismiss() {
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showTips(String content) {
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }
}
