package com.kunminx.basicfacttesting.test_jetpack.livedata_and_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kunminx.basicfacttesting.test_jetpack.DataRepository;

/**
 * Create by KunMinX at 19/9/24
 */
public class CallbackViewModel extends ViewModel {

    public final UnPeekLiveData<Boolean> closeCallback = new UnPeekLiveData<>();

    public void requestExpectDataByBus() {
        DataRepository.getInstance().requestExpectData(closeCallback);
    }

    public final MutableLiveData<Event<Boolean>> closeEvent = new MutableLiveData<>();

    public void requestExpectDataByEvent() {
        DataRepository.getInstance().requestExpectData(closeEvent);
    }
}
