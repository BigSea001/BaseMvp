package cn.easier.market.beans;

/**
 * File: PayConfigBean.java
 * 作者: 大海
 * 创建日期: 2018/6/27 0027 18:35
 * 描述：
 */
public class PayConfigBean {

    /**
     * weixin_pay : {"partner":"1507852111","partner_key":"XiongmaoShangcheng12351GouWuWang","notify_url":"http://47.104.178.80/guobao/api/weixinPay.nofity.action","app_id":"wx49b6b15c811d87ec","app_secret":"ad173a446fdd460bb7acb81a13b20399"}
     * ali_pay : {"zfb_account":"273826391@qq.com","partner":"2088131060542163","appid":"2018062360356949","private_key":"genvlh916b909jrk42s4xrtn4bvpbg8h","notify_url":"http://47.104.178.80/guobao/api/aliPay.nofity.action","ali_public_key":"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB","private_key_rsa":"MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJPSWfSOetFsIeqxA9C+GUUDub/YAJ3haxUfVO1iz8zxlDHkciQiaWXtnOMJSntmWvDef7PcGjtyZGKX+bn9E+/oz5WiWRWnNlGIIE6+gKR7fS7Bb1uKnMyz/A0B5CVFW7RMprhCBx0+dUFpZmscBbby2TYpkiBrpT0j3AITfWKvAgMBAAECgYEAg4TDHlBqO8vOfWYTM/T+vKWs7WA8ZDv8LyXaRP8GTZyesqlDWJz5U4POcz1/9DzEKsx7qEXrXPrRD9uRh4YA5qzR6dnyD0eSoKATYjeO2As5OSgtaW1uNQuxJUHo5xbkpJ+w8/blKzR+Jihi0E3fD9G504E+E4u/eeb4++Q+SkECQQD6pFg4G7gpS3YPTCCR9HuScj4vC+XjnmnFSjsDaQoIGMOCW3AtQ5dSM+h+PR4P/qQrn9Th0iBaG2nFT3YjkzBhAkEAlvtQ0joO6N9XJYQ5t3Wm5sNQIs7t+fTTkrFgiFs8iXnFIo1DFeMaVUkKdbI8DrjDWjUlii27BFu5PFXJJaytDwJBAMYf9TBdEQVrhiZveeuGA8xujCMqV43HIjr3A5EdjfV6hclcuF6/aDVtnOF1NHdWRbXKQUBElphDxSdYOb3DUuECQF1Hg9V+fTuu0L6jBK2uCKHFxbrbsfeeJSEaaZOVGr+s9fi04d+h4eETMV0p8yT9TeRrtXe7bTHyIW1/arjWCE0CQALXdNH+6Vy9dkgLMi1B+GDN1CMt1N2II3wQCtif0inYNJ0cJfiG/WkAqJyEOVOkzzNGdnYlANBe9B8OhC/k6xk="}
     */

    private WeixinPayBean weixin_pay;
    private AliPayBean ali_pay;

    public WeixinPayBean getWeixin_pay() {
        return weixin_pay;
    }

    public void setWeixin_pay(WeixinPayBean weixin_pay) {
        this.weixin_pay = weixin_pay;
    }

    public AliPayBean getAli_pay() {
        return ali_pay;
    }

    public void setAli_pay(AliPayBean ali_pay) {
        this.ali_pay = ali_pay;
    }

    public static class WeixinPayBean {
        /**
         * partner : 1507852111
         * partner_key : XiongmaoShangcheng12351GouWuWang
         * notify_url : http://47.104.178.80/guobao/api/weixinPay.nofity.action
         * app_id : wx49b6b15c811d87ec
         * app_secret : ad173a446fdd460bb7acb81a13b20399
         */

        private String partner;
        private String partner_key;
        private String notify_url;
        private String app_id;
        private String app_secret;

        public String getPartner() {
            return partner;
        }

        public void setPartner(String partner) {
            this.partner = partner;
        }

        public String getPartner_key() {
            return partner_key;
        }

        public void setPartner_key(String partner_key) {
            this.partner_key = partner_key;
        }

        public String getNotify_url() {
            return notify_url;
        }

        public void setNotify_url(String notify_url) {
            this.notify_url = notify_url;
        }

        public String getApp_id() {
            return app_id;
        }

        public void setApp_id(String app_id) {
            this.app_id = app_id;
        }

        public String getApp_secret() {
            return app_secret;
        }

        public void setApp_secret(String app_secret) {
            this.app_secret = app_secret;
        }

        @Override
        public String toString() {
            return "WeixinPayBean{" +
                    "partner='" + partner + '\'' +
                    ", partner_key='" + partner_key + '\'' +
                    ", notify_url='" + notify_url + '\'' +
                    ", app_id='" + app_id + '\'' +
                    ", app_secret='" + app_secret + '\'' +
                    '}';
        }
    }

    public static class AliPayBean {
        /**
         * zfb_account : 273826391@qq.com
         * partner : 2088131060542163
         * appid : 2018062360356949
         * private_key : genvlh916b909jrk42s4xrtn4bvpbg8h
         * notify_url : http://47.104.178.80/guobao/api/aliPay.nofity.action
         * ali_public_key : MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB
         * private_key_rsa : MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJPSWfSOetFsIeqxA9C+GUUDub/YAJ3haxUfVO1iz8zxlDHkciQiaWXtnOMJSntmWvDef7PcGjtyZGKX+bn9E+/oz5WiWRWnNlGIIE6+gKR7fS7Bb1uKnMyz/A0B5CVFW7RMprhCBx0+dUFpZmscBbby2TYpkiBrpT0j3AITfWKvAgMBAAECgYEAg4TDHlBqO8vOfWYTM/T+vKWs7WA8ZDv8LyXaRP8GTZyesqlDWJz5U4POcz1/9DzEKsx7qEXrXPrRD9uRh4YA5qzR6dnyD0eSoKATYjeO2As5OSgtaW1uNQuxJUHo5xbkpJ+w8/blKzR+Jihi0E3fD9G504E+E4u/eeb4++Q+SkECQQD6pFg4G7gpS3YPTCCR9HuScj4vC+XjnmnFSjsDaQoIGMOCW3AtQ5dSM+h+PR4P/qQrn9Th0iBaG2nFT3YjkzBhAkEAlvtQ0joO6N9XJYQ5t3Wm5sNQIs7t+fTTkrFgiFs8iXnFIo1DFeMaVUkKdbI8DrjDWjUlii27BFu5PFXJJaytDwJBAMYf9TBdEQVrhiZveeuGA8xujCMqV43HIjr3A5EdjfV6hclcuF6/aDVtnOF1NHdWRbXKQUBElphDxSdYOb3DUuECQF1Hg9V+fTuu0L6jBK2uCKHFxbrbsfeeJSEaaZOVGr+s9fi04d+h4eETMV0p8yT9TeRrtXe7bTHyIW1/arjWCE0CQALXdNH+6Vy9dkgLMi1B+GDN1CMt1N2II3wQCtif0inYNJ0cJfiG/WkAqJyEOVOkzzNGdnYlANBe9B8OhC/k6xk=
         */

        private String zfb_account;
        private String partner;
        private String appid;
        private String private_key;
        private String notify_url;
        private String ali_public_key;
        private String private_key_rsa;

        public String getZfb_account() {
            return zfb_account;
        }

        public void setZfb_account(String zfb_account) {
            this.zfb_account = zfb_account;
        }

        public String getPartner() {
            return partner;
        }

        public void setPartner(String partner) {
            this.partner = partner;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPrivate_key() {
            return private_key;
        }

        public void setPrivate_key(String private_key) {
            this.private_key = private_key;
        }

        public String getNotify_url() {
            return notify_url;
        }

        public void setNotify_url(String notify_url) {
            this.notify_url = notify_url;
        }

        public String getAli_public_key() {
            return ali_public_key;
        }

        public void setAli_public_key(String ali_public_key) {
            this.ali_public_key = ali_public_key;
        }

        public String getPrivate_key_rsa() {
            return private_key_rsa;
        }

        public void setPrivate_key_rsa(String private_key_rsa) {
            this.private_key_rsa = private_key_rsa;
        }

        @Override
        public String toString() {
            return "AliPayBean{" +
                    "zfb_account='" + zfb_account + '\'' +
                    ", partner='" + partner + '\'' +
                    ", appid='" + appid + '\'' +
                    ", private_key='" + private_key + '\'' +
                    ", notify_url='" + notify_url + '\'' +
                    ", ali_public_key='" + ali_public_key + '\'' +
                    ", private_key_rsa='" + private_key_rsa + '\'' +
                    '}';
        }
    }
}
