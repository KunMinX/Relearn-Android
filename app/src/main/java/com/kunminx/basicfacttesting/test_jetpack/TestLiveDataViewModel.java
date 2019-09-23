package com.kunminx.basicfacttesting.test_jetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Create by KunMinX at 19/9/23
 */
public class TestLiveDataViewModel extends ViewModel {

    private MutableLiveData<Boolean> liveData = new MutableLiveData<>();
    private ExpectedLiveData<Boolean> mExpectedLiveData = new ExpectedLiveData<>();

    public MutableLiveData<Boolean> getLiveData() {
        return liveData;
    }

    public ExpectedLiveData<Boolean> getExpectedLiveData() {
        return mExpectedLiveData;
    }

    public void requestData() {
        DataRepository.getInstance().requestData(getLiveData());
    }

    public void requestExpectData() {
        DataRepository.getInstance().requestExpectData(getExpectedLiveData());
    }
}
