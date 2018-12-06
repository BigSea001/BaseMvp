package cn.easier.market.ui.account.contracts;

import cn.easier.baselibs.basemvp.BaseView;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.market.beans.User;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public interface LoginContract {

    interface View extends BaseView {
        void loginSuccess(User user);
        void loginFailed();
    }

    interface Presenter extends IPresenter {
        void getSysConfig();
        void login(String phone,String password);
    }
}
