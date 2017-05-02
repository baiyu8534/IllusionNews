package com.example.showapp.bean;

/**
 * Created by baiyu on 2017/2/9.
 */
public class ShowDemoBean {
    private String title;
    private int imageId;

    public ShowDemoBean(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }
}
