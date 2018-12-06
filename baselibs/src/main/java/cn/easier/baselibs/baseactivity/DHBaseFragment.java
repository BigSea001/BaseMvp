package cn.easier.baselibs.baseactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import cn.easier.baselibs.basemvp.BaseView;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.baselibs.widget.dialog.LoadingDialog;


/**
 * fragment基类
 *
 * @author zhuxian
 * @time 2016/10/9 18:22
 */
public abstract class DHBaseFragment extends Fragment implements BaseView {
	private LoadingDialog waitDialog;
	public static final int standard = 1;//标准启动模式
	public static final int singleTask = 2;//单例模式

	public abstract IPresenter getPresenter();

	/**
	 * fragment启动模式，singleTask和standard两种启动模式
	 */
	public int registStartMode() {
		return standard;
	}

    /**
     * @param cla 要开车去的地方
     */
    public void startAtv(Class cla) {
    	Intent intent = new Intent(getContext(),cla);
        startActivity(intent);
	}
	/**
	 * @param cla 要开车去的地方
	 */
	public void startAtv(Class cla,Bundle bundle) {
		Intent intent = new Intent(getContext(),cla);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	public void startAtvForResult(Class cla,Bundle bundle, int code) {
		Intent intent = new Intent(getContext(),cla);
		intent.putExtras(bundle);
		startActivityForResult(intent,code,bundle);
	}

	public void startAtvForResult(Class cla,int code) {
		Intent intent = new Intent(getContext(),cla);
		FragmentActivity activity = getActivity();
		if (activity!=null) {
			activity.startActivityForResult(intent,code);
		}
	}

	// 显示加载动画
	public void showWaitDialog() {
		if (waitDialog == null && getContext()!=null) {
			waitDialog = new LoadingDialog(getContext());
		}
		if (!waitDialog.isShowing()) {
			waitDialog.show();
		}
	}

	// 影藏动画
	public void dismissWaitDialog() {
		if (waitDialog != null && waitDialog.isShowing()) {
			waitDialog.dismiss();
		}
	}

	public void showToast(String msg) {
		Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();
	}


	@Override
	public void showDialog() {
		showWaitDialog();
	}

	@Override
	public void dismiss() {
		dismissWaitDialog();
	}

	@Override
	public void showTips(String content) {
		showToast(content);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		if (getPresenter() != null) {
			getPresenter().destroy();
		}
	}
}
