package com.kunminx.basicfacttesting.test_05_jetpack.livedata_and_viewmodel;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * Create by KunMinX at 19/9/25
 */

public class Event<T> {

    private T content;

    public Event(T content) {
        this.content = content;
    }

    private boolean hasBeenHandled;

    T getContentIfNotHandled() {
        if (hasBeenHandled) {
            return null;
        } else {
            hasBeenHandled = true;
            return content;
        }
    }

    T peekContent() {
        return content;
    }
}
