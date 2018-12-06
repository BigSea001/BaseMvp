package cn.easier.market.ui.dealer.home;

import cn.easier.baselibs.basemvp.BaseView;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.market.beans.QtyAlertAdvert;
import cn.easier.market.beans.SysConfigBean;

/**
 * 作者： 大海
 * 时间： 2018/12/6
 * 描述：
 */
public interface MainContract {

    interface View extends BaseView {
        void getSysConfigSuccess(SysConfigBean data);
    }

    interface Presenter extends IPresenter {
        void qtyStartAdvert(String tokenid);
        void qryPayConfig(String tokenid);
        void getSysConfig();
    }
}
