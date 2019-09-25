package com.kunminx.basicfacttesting.test_jetpack.livedata_and_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kunminx.basicfacttesting.test_jetpack.DataRepository;

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
