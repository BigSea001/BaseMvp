package cn.easier.market.ui.account.ui;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

import java.util.List;

import cn.easier.market.R;
import cn.easier.market.beans.HistoryAccount;
import cn.easier.market.contracts.SPContracts;

/**
 * 描述：
 * 时间：2018/10/22/022
 * 作者：xjh
 */
public class HistoryAccountAdapter extends BaseAdapter {

    private List<HistoryAccount> data;

    public HistoryAccountAdapter(@Nullable List<HistoryAccount> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public HistoryAccount getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view==null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_history_account,viewGroup,false);
            holder = new Holder();
            holder.tv = view.findViewById(R.id.tv_account);
            holder.detete = view.findViewById(R.id.iv_delete);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }

        holder.tv.setText(data.get(i).getName());
        holder.detete.setOnClickListener(view1 -> {
            delete(data.get(i).getName());
            data.remove(i);
            notifyDataSetChanged();
        });

        return view;
    }

    private void delete(String name) {
        List<HistoryAccount> account = Hawk.get(SPContracts.SP_NAME_HistoryAccount);
        if (account!=null) {
            for (HistoryAccount historyAccount : account) {
                if (TextUtils.equals(name,historyAccount.getName())) {
                    account.remove(historyAccount);
                    break;
                }
            }
        }
        Hawk.put(SPContracts.SP_NAME_HistoryAccount,account);
    }

    class Holder {
        TextView tv;
        ImageView detete;
    }
}
