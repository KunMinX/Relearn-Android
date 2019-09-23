package com.kunminx.basicfacttesting.test_jetpack;

import androidx.lifecycle.ViewModel;

/**
 * Create by KunMinX at 19/9/24
 */
public class BusViewModel extends ViewModel {

    public final BusLiveData<Boolean> closeCallback = new BusLiveData<>();

    public void requestExpectData() {
        DataRepository.getInstance().requestExpectData(closeCallback);
    }
}
