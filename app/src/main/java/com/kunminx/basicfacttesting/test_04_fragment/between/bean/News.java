package com.kunminx.basicfacttesting.test_04_fragment.between.bean;

import java.io.Serializable;

/**
 * Create by KunMinX at 19/7/4
 */
public class News implements Serializable {

    private String title;
    private String content;

    public News() {
    }

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
