package com.kunminx.basicfacttesting.test_jetpack.livedata_and_viewmodel;

/**
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
