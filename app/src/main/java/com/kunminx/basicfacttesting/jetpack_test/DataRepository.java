package com.kunminx.basicfacttesting.jetpack_test;

import androidx.lifecycle.MutableLiveData;

import com.kunminx.basicfacttesting.jetpack_test.livedata_and_viewmodel.Event;
import com.kunminx.basicfacttesting.jetpack_test.livedata_and_viewmodel.UnPeekLiveData;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * Create by KunMinX at 19/9/23
 */
@Deprecated
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
