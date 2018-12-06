package cn.easier.market.beans;

/**
 * 作者： 大海
 * 时间： 2018/12/6
 * 描述：
 */
public class QryShopCountBean {
    private int orderNum;
    private float accountAmount;
    private String day;

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public float getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(float accountAmount) {
        this.accountAmount = accountAmount;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
