package com.kunminx.basicfacttesting.test_jetpack;

import androidx.lifecycle.MutableLiveData;

import com.kunminx.basicfacttesting.test_jetpack.livedata_and_viewmodel.Event;
import com.kunminx.basicfacttesting.test_jetpack.livedata_and_viewmodel.UnPeekLiveData;

/**
 * Create by KunMinX at 19/9/23
 */
public class DataRepository {


    private static DataRepository sRepository = new DataRepository();

    public static DataRepository getInstance() {
        return sRepository;
    }

    private DataRepository() {
    }

    public void requestData(MutableLiveData<Boolean> liveData) {
        liveData.setValue(true);
    }

    public void requestExpectData(UnPeekLiveData<Boolean> liveData) {
        liveData.setValue(true);
    }

    public void requestExpectData(MutableLiveData<Event<Boolean>> liveData) {
        liveData.setValue(new Event<>(true));
    }
}
