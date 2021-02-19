package com.kunminx.basicfacttesting.jetpack_test;

import androidx.lifecycle.ViewModel;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 * <p>
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 * <p>
 * Create by KunMinX at 19/9/5
 */
@Deprecated
public class TestDataObservableViewModel extends ViewModel {

    private TestData mTestData = new TestData("test", 12, true);

    public TestData getTestData() {
        return mTestData;
    }
}
