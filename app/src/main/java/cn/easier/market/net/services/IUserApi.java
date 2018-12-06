package cn.easier.market.net.services;

import java.util.List;

import cn.easier.baselibs.net.bean.BaseBean;
import cn.easier.market.beans.PayConfigBean;
import cn.easier.market.beans.QryShopIncomeBean;
import cn.easier.market.beans.QryShopOrderNumBean;
import cn.easier.market.beans.QryShopSaleBean;
import cn.easier.market.beans.QtyAlertAdvert;
import cn.easier.market.beans.SysConfigBean;
import cn.easier.market.beans.User;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public interface IUserApi {

    // 获取配置
    @GET("sysInfo.getSysConfig.action")
    Observable<BaseBean<SysConfigBean>> getSysConfig(@Query("param")String param);

    // 登录
    @GET("member.login.action")
    Observable<BaseBean<User>> login(@Query("param") String param);

    // 启动广告
    @GET("advert.qtyStartAdvert.action")
    Observable<BaseBean<QtyAlertAdvert>> qtyStartAdvert(@Query("param")String param);

    // 支付的配置信息
    @GET("pay.qryPayConfig.action")
    Observable<BaseBean<PayConfigBean>> qryPayConfig(@Query("param")String param);

    // 查询经销商订单金额统计信息接口(经销商端*)
    @GET("shopInfo.qryShopSale.action")
    Observable<BaseBean<List<QryShopSaleBean>>> queryShopSale(@Query("param")String param);

    // 查询经销商收款金额统计信息接口(经销商端*)
    @GET("shopInfo.qryShopIncome.action")
    Observable<BaseBean<List<QryShopIncomeBean>>> qryShopIncome(@Query("param")String param);

    // 查询经销商订单量统计信息接口(经销商端*)
    @GET("shopInfo.qryShopOrderNum.action")
    Observable<BaseBean<List<QryShopOrderNumBean>>> qryShopOrderNum(@Query("param")String param);
}
