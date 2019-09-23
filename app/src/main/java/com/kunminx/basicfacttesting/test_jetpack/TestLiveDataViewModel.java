package com.kunminx.basicfacttesting.test_jetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Create by KunMinX at 19/9/23
 */
public class TestLiveDataViewModel extends ViewModel {

    private MutableLiveData<Boolean> liveData = new MutableLiveData<>();

    public MutableLiveData<Boolean> getLiveData() {
        return liveData;
    }

    public void requestData() {
        DataRepository.getInstance().requestData(getLiveData());
    }


}
