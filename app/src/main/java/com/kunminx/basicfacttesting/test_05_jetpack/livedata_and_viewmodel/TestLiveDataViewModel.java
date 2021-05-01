package com.kunminx.basicfacttesting.test_05_jetpack.livedata_and_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kunminx.basicfacttesting.test_05_jetpack.DataRepository;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * Create by KunMinX at 19/9/23
 */
@Deprecated
public class TestLiveDataViewModel extends ViewModel {

    private MutableLiveData<Boolean> liveData = new MutableLiveData<>();

    public MutableLiveData<Boolean> getLiveData() {
        return liveData;
    }

    public void requestData() {
        DataRepository.getInstance().requestData(getLiveData());
    }


}
