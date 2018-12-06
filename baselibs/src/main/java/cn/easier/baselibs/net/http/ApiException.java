package cn.easier.baselibs.net.http;

/**
 * -----------------------------------------------------------------
 * 广州购翠网科技有限公司
 * -----------------------------------------------------------------
 * <p>
 * File: ApiException.java
 * 作者: 大海
 * 版本: v-2.0
 * 创建日期: 2018/5/4 0004 10:59
 * <p>
 * 修改日期: 2018/5/4 0004 10:59
 * -----------------------------------------------------------------
 * 2018/5/4 0004: Create ApiException.java (Administrator);
 * -----------------------------------------------------------------
 */
public class ApiException extends RuntimeException {
    private int code;
    private String msg;

    public ApiException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
