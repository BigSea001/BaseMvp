package cn.easier.baselibs.basemvp;


public interface BaseView {
    /**
     * 展示加载对话框
     */
    void showDialog();

    /**
     * 取消对话框
     */
    void dismiss();

    /**
     * @param content  提示的内容
     */
    void showTips(String content);
}
