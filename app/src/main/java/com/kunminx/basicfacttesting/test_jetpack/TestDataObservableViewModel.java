package com.kunminx.basicfacttesting.test_jetpack;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

/**
 * Create by KunMinX at 19/9/5
 */
public class TestDataObservableViewModel extends ViewModel {

    private TestData mTestData = new TestData("test", 12, true);

    private ObservableField<TestData> mField = new ObservableField<>();

    public ObservableField<TestData> getTestData() {
        if (mField.get() == null) {
            mField.set(mTestData);
        }
        return mField;
    }
}
