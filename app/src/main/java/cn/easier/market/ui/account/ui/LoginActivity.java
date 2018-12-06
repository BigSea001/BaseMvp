package cn.easier.market.ui.account.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.easier.baselibs.baseactivity.DHBaseActivity;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.market.ui.MainActivity;
import cn.easier.market.R;
import cn.easier.market.beans.HistoryAccount;
import cn.easier.market.beans.User;
import cn.easier.market.contracts.SPContracts;
import cn.easier.market.ui.account.contracts.LoginContract;
import cn.easier.market.ui.account.contracts.LoginPresenterImpl;
import cn.easier.market.utils.AppUtils;
import cn.easier.market.utils.SizeUtil;
import cn.easier.market.widget.LimitHeightListView;
import cn.easier.market.widget.popup.EasyPopup;
import cn.easier.market.widget.popup.HorizontalGravity;
import cn.easier.market.widget.popup.VerticalGravity;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public class LoginActivity extends DHBaseActivity implements LoginContract.View {

    @BindView(R.id.online_service)
    TextView onlineService;
    @BindView(R.id.mobile)
    EditText mobile;
    @BindView(R.id.iv_select)
    ImageView ivSelect;
    @BindView(R.id.lin)
    LinearLayout lin;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.forget)
    TextView forget;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.scan_register)
    TextView scanRegister;

    private EasyPopup easyPopup;

    private LoginPresenterImpl presenter;

    @Override
    public IPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mImmersionBar.statusBarColor(R.color.login_background_color).statusBarDarkFont(true, 0.2f).fitsSystemWindows(true);
        mImmersionBar.init();
        presenter = new LoginPresenterImpl(this, this);

        loadAccountHistory();
    }

    private void loadAccountHistory() {
        List<HistoryAccount> historyAccounts = Hawk.get(SPContracts.SP_NAME_HistoryAccount, new ArrayList<HistoryAccount>());
        if (historyAccounts.size()>0) {
            View popupView = LayoutInflater.from(this).inflate(R.layout.popup_common_list, null);
            LimitHeightListView listView = popupView.findViewById(R.id.listView);
            listView.setAdapter(new HistoryAccountAdapter(historyAccounts));
            easyPopup = new EasyPopup(this)
                    .setContentView(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    .setFocusAndOutsideEnable(true)
                    .setBackgroundDimEnable(false)
                    .setOnDismissListener(() -> {
                    }).createPopup();
            listView.setOnItemClickListener((parent, view, position, id) -> {
                HistoryAccount account = historyAccounts.get(position);
                mobile.setText(account.getName());
                mobile.setSelection(mobile.getText().length());
                password.setText(account.getPassword());
                password.setSelection(password.getText().length());
            });

            HistoryAccount account = historyAccounts.get(0);
            mobile.setText(account.getName());
            mobile.setSelection(mobile.getText().length());
            password.setText(account.getPassword());
            password.setSelection(password.getText().length());

        }
    }

    @Override
    public void loginSuccess(User user) {
        AppUtils.saveUser(user);

        String phone = this.mobile.getText().toString().trim();
        String password = this.password.getText().toString().trim();

        List<HistoryAccount> historyAccounts = Hawk.get(SPContracts.SP_NAME_HistoryAccount, new ArrayList<HistoryAccount>());
        for (HistoryAccount account : historyAccounts) {
            if (TextUtils.equals(account.getName(),phone)) {
                historyAccounts.remove(account);
                break;
            }
        }
        historyAccounts.add(0,new HistoryAccount(phone,password));
        Hawk.put(SPContracts.SP_NAME_HistoryAccount,historyAccounts);

        startAct(MainActivity.class);

        finish();
    }

    @Override
    public void loginFailed() {

    }

    @OnClick({R.id.online_service, R.id.iv_select, R.id.forget, R.id.login, R.id.register, R.id.scan_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.online_service:

                break;
            case R.id.iv_select:
                if (easyPopup!=null) {
                    easyPopup.setWidth(SizeUtil.getWidth(this) - SizeUtil.dp2px(this,80f));
                    easyPopup.showAtAnchorView(lin, VerticalGravity.BELOW, HorizontalGravity.CENTER, 0, 0);
                }
                break;
            case R.id.forget:
                break;
            case R.id.login:
                String phone = this.mobile.getText().toString().trim();
                String password = this.password.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    showTips("账号不能为空");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    showTips("密码不能为空");
                    return;
                }
                presenter.login(phone,password);
                break;
            case R.id.register:
                break;
            case R.id.scan_register:
                break;
        }
    }
}
