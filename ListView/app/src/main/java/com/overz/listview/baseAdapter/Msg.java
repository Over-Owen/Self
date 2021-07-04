package com.overz.listview.baseAdapter;

public class Msg {
    private int avatar;
    private String nickName;
    private String date;
    private String content;
    private boolean isLike;

    public Msg(int avatar, String nickName, String date, String content, boolean isLike) {
        this.avatar = avatar;
        this.nickName = nickName;
        this.date = date;
        this.content = content;
        this.isLike = isLike;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }
}
