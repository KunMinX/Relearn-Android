package com.kunminx.basicfacttesting.test_jetpack;

import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Create by KunMinX at 19/9/5
 */
public class TestDataLiveDataViewModel extends ViewModel {

    private MutableLiveData<TestData> mData;

    public MutableLiveData<TestData> getTestData() {
        if (mData == null) {
            mData = new MutableLiveData<>();
            TestData testData = new TestData("test", 12, true);
            mData.setValue(testData);
        }
        return mData;
    }
}
