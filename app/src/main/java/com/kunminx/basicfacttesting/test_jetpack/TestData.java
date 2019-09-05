package com.kunminx.basicfacttesting.test_jetpack;

/**
 * Create by KunMinX at 19/9/5
 */
public class TestData {
    private String name;
    private int age;
    private boolean visible;
    private String msg;

    public TestData(String name, int age, boolean visible) {
        this.name = name;
        this.age = age;
        this.visible = visible;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
