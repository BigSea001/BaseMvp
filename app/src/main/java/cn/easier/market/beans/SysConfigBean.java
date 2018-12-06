package cn.easier.market.beans;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public class SysConfigBean {
    private String serviceTel;
    private String introductionUrl;
    private VersionInfoBean versionInfo;

    public String getServiceTel() {
        return serviceTel;
    }

    public void setServiceTel(String serviceTel) {
        this.serviceTel = serviceTel;
    }

    public String getIntroductionUrl() {
        return introductionUrl;
    }

    public void setIntroductionUrl(String introductionUrl) {
        this.introductionUrl = introductionUrl;
    }

    public VersionInfoBean getVersionInfo() {
        return versionInfo;
    }

    public void setVersionInfo(VersionInfoBean versionInfo) {
        this.versionInfo = versionInfo;
    }

    public static class VersionInfoBean {
        private String isNew;
        private String version;
        private String downloadUrl;
        private String versionDescp;

        public String getIsNew() {
            return isNew;
        }

        public void setIsNew(String isNew) {
            this.isNew = isNew;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getVersionDescp() {
            return versionDescp;
        }

        public void setVersionDescp(String versionDescp) {
            this.versionDescp = versionDescp;
        }
    }
}
