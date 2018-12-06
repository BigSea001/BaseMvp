package cn.easier.market.beans;

/**
 * 作者： 大海
 * 时间： 2018/12/6
 * 描述：
 */
public class HistoryAccount {
    private String name;
    private String password;

    public HistoryAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
