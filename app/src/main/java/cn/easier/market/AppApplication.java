package cn.easier.market;

import cn.easier.baselibs.BaseApplication;
import cn.easier.market.net.ApiFactory;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public class AppApplication extends BaseApplication {


    @Override
    public void onCreate() {
        super.onCreate();

        ApiFactory.init(this);
    }
}
