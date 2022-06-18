package com.example.smash;

import java.util.Date;

public class GetSetNotice {

    private int profile_image;
    private String nickname;
    private String title;
    private Date write_data;
    private String content;

    public int getProfile_image() {
        return profile_image;
    }
    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Date getWrite_data() {
        return write_data;
    }
    public void setWrite_data(Date write_data) {
        this.write_data = write_data;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public GetSetNotice(int profile_image, String nickname, String title, Date write_data, String content){
        this.profile_image = profile_image;
        this.nickname = nickname;
        this.title = title;
        this.write_data = write_data;
        this.content = content;
    }
}
