package cn.easier.baselibs.net.bean;

/**
 * 描述：
 * <p>
 * 由 大海 于 2017/10/18 创建
 */

public class BaseBean<T> {

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
