package cn.easier.market.utils;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.orhanobut.hawk.Hawk;

import cn.easier.market.beans.Member;
import cn.easier.market.beans.User;
import cn.easier.market.contracts.SPContracts;

/**
 * File: AppUtils.java
 * 作者: 大海
 * 创建日期: 2018/7/31 0031 19:04
 * 描述：
 */
public class AppUtils {

    /**
     * 经销商
     */
    public static final String DEALER = "02";
    public static final String RETAILER = "03";
    public static final String DEFAULT = "01";

    public static void saveUser(User user) {
        if (user!=null)
        Hawk.put(SPContracts.SP_NAME_USERINFO,new Gson().toJson(user));
    }

    public static void deleteUser() {
        Hawk.put(SPContracts.SP_NAME_USERINFO,"");
    }

    public static User getUser() {
        String userInfo = Hawk.get(SPContracts.SP_NAME_USERINFO);
        if (TextUtils.isEmpty(userInfo)) {
            return null;
        } else {
            User user = new Gson().fromJson(userInfo, User.class);
            if (user!=null) {
                return user;
            }
        }

        return null;
    }

    public static Member getMember() {
        String userInfo = Hawk.get(SPContracts.SP_NAME_USERINFO);
        if (TextUtils.isEmpty(userInfo)) {
            return null;
        } else {
            User user = new Gson().fromJson(userInfo, User.class);
            if (user!=null&&user.getMember()!=null) {
                return user.getMember();
            }
        }
        return null;
    }

    public static String getTokenId() {
        User member = getUser();
        if (member!=null) {
            return member.getTokenId();
        }
        return "";
    }

    public static String getShopId() {
        Member member = getMember();
        if (member!=null) {
            return member.getShopId();
        }
        return "";
    }

    public static String getUserName() {
        Member member = getMember();
        if (member!=null) {
            return member.getNickname();
        }
        return "";
    }

    public static String getUserPhone() {
        Member member = getMember();
        if (member!=null) {
            return member.getMobile();
        }
        return "";
    }

    public static String getProvinceId() {
        Member member = getMember();
        if (member!=null) {
            return member.getProvinceId();
        }
        return "";
    }

    public static String getCityId() {
        Member member = getMember();
        if (member!=null) {
            return member.getCityId();
        }
        return "";
    }
    public static String getCountyId() {
        Member member = getMember();
        if (member!=null) {
            return member.getCountyId();
        }
        return "";
    }

    public static String getUserHeader() {
        Member member = getMember();
        if (member!=null) {
            return member.getAvatar();
        }
        return "";
    }
}
