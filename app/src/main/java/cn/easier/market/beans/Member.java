package cn.easier.market.beans;

import com.google.gson.annotations.SerializedName;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public class Member {
    @SerializedName("authcode")
    private String code;
    private String password;
    @SerializedName("linkor")
    private String linkman;
    @SerializedName("linktel")
    private String linkTelephone;
    private String areaName;
    private String countyId;
    // 01:普通会员、02:经销商、03:零售商
    @SerializedName("utype")
    private String type;
    private String nickname;
    @SerializedName("avatarPath")
    private String avatar;
    private String shopName;
    private String shopId;
    @SerializedName("mobileno")
    private String mobile;
    private String cityId;
    @SerializedName("addr")
    private String address;
    private String provinceId;
    private String account;
    @SerializedName("isSetPayPwd")
    private int setPayPassword;
    private String descp;
    // 0：普通 1：代理
    private String agencyType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getLinkTelephone() {
        return linkTelephone;
    }

    public void setLinkTelephone(String linkTelephone) {
        this.linkTelephone = linkTelephone;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getSetPayPassword() {
        return setPayPassword;
    }

    public void setSetPayPassword(int setPayPassword) {
        this.setPayPassword = setPayPassword;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getAgencyType() {
        return agencyType;
    }

    public void setAgencyType(String agencyType) {
        this.agencyType = agencyType;
    }
}
