package com.kunminx.basicfacttesting.test_jetpack;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * Create by KunMinX at 19/9/5
 */
@Deprecated
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
