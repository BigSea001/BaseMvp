package cn.easier.market.beans;

import com.google.gson.annotations.SerializedName;

/**
 * 作者： 大海
 * 时间： 2018/12/4
 * 描述：
 */
public class User {

    private String rongToken;
    @SerializedName("tokenid")
    private String tokenId;
    private String passId;
    private Member member;

    public String getRongToken() {
        return rongToken;
    }

    public void setRongToken(String rongToken) {
        this.rongToken = rongToken;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
