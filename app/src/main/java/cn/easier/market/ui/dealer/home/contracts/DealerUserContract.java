package cn.easier.market.ui.dealer.home.contracts;

import java.util.List;

import cn.easier.baselibs.basemvp.BaseView;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.market.beans.QryShopCountBean;
import cn.easier.market.beans.QryShopIncomeBean;
import cn.easier.market.beans.QryShopOrderNumBean;
import cn.easier.market.beans.QryShopSaleBean;

/**
 * 作者： 大海
 * 时间： 2018/12/6
 * 描述：
 */
public interface DealerUserContract {

    interface View extends BaseView {
        void queryShopSaleSuccess(List<QryShopSaleBean> list);
        void queryShopIncomesSuccess(List<QryShopIncomeBean> list);
        void queryShopOrderNumbersSuccess(List<QryShopOrderNumBean> list);
        void queryShopCountSuccess(QryShopCountBean data);
    }

    interface Presenter extends IPresenter {
        void queryShopSale(String startDate,String endDate);
        void queryShopIncomes(String startDate,String endDate);
        void queryShopOrderNumbers(String startDate,String endDate);
        void queryShopCount();
    }
}
