package com.kunminx.basicfacttesting.animator_test;

import java.io.Serializable;

/**
 * Create by KunMinX at 19/7/1
 */
public class AnimatorItem implements Serializable {

    private String title;
    private String url;

    public AnimatorItem(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
