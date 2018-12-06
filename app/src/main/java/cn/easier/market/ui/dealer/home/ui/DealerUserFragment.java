package cn.easier.market.ui.dealer.home.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.easier.baselibs.baseactivity.DHBaseFragment;
import cn.easier.baselibs.basemvp.IPresenter;
import cn.easier.market.R;
import cn.easier.market.widget.CircleImageView;

/**
 * 作者： 大海
 * 时间： 2018/12/6
 * 描述：
 */
public class DealerUserFragment extends DHBaseFragment {


    @BindView(R.id.avatar)
    CircleImageView avatar;
    @BindView(R.id.basic_info)
    TextView basicInfo;
    @BindView(R.id.order_count)
    TextView orderCount;
    @BindView(R.id.order)
    LinearLayout order;
    @BindView(R.id.balance)
    TextView balance;
    @BindView(R.id.balance_container)
    LinearLayout balanceContainer;
    @BindView(R.id.monthly_bill)
    TextView monthlyBill;
    @BindView(R.id.tv_after_sale)
    TextView tvAfterSale;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.order_amount)
    TextView orderAmount;
    @BindView(R.id.payee_amount)
    TextView payeeAmount;
    @BindView(R.id.order_quantity)
    TextView orderQuantity;
    @BindView(R.id.chart)
    LineChart chart;
    @BindView(R.id.linear_bottom)
    LinearLayout linearBottom;
    @BindView(R.id.setting)
    ImageView setting;
    @BindView(R.id.message)
    ImageView message;
    @BindView(R.id.toolbar)
    FrameLayout toolbar;
    Unbinder unbinder;

    @Override
    public IPresenter getPresenter() {
        return null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dealer_fragment_user, container, false);

        unbinder = ButterKnife.bind(this, view);


        return view;
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
