package cn.easier.market.ui.dealer.home.contracts;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import cn.easier.baselibs.basemvp.BasePresenterImpl;
import cn.easier.market.net.ApiFactory;
import cn.easier.market.net.services.IUserApi;
import cn.easier.market.utils.AppUtils;

/**
 * 作者： 大海
 * 时间： 2018/12/6
 * 描述：
 */
public class DealerUserPresenterImpl extends BasePresenterImpl<DealerUserContract.View> implements DealerUserContract.Presenter {

    private IUserApi mUserApi = ApiFactory.getInstance().getUserApi();

    public DealerUserPresenterImpl(Context context, DealerUserContract.View view) {
        super(context, view);
    }

    @Override
    public void queryShopSale(String startDate, String endDate) {
        Map<String,String> map = new HashMap<>();
        map.put("shopId",AppUtils.getShopId());
        map.put("startDate",startDate);
        map.put("endDate",endDate);

    }

    @Override
    public void queryShopIncomes(String startDate, String endDate) {

    }

    @Override
    public void queryShopOrderNumbers(String startDate, String endDate) {

    }

    @Override
    public void queryShopCount() {

    }
}
