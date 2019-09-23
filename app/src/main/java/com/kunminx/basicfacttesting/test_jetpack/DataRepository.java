package com.kunminx.basicfacttesting.test_jetpack;

import androidx.lifecycle.MutableLiveData;

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

    public void requestExpectData(ExpectedLiveData<Boolean> liveData){
        liveData.setValue(true);
    }
}
