package com.kunminx.basicfacttesting.test_05_jetpack.livedata_and_viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kunminx.basicfacttesting.test_05_jetpack.DataRepository;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * Create by KunMinX at 19/9/24
 */
@Deprecated
public class SharedViewModel extends ViewModel {

    public final UnPeekLiveData<Boolean> closeCallback = new UnPeekLiveData<>();

    public void requestExpectDataByBus() {
        DataRepository.getInstance().requestExpectData(closeCallback);
    }

    public final MutableLiveData<Event<Boolean>> closeEvent = new MutableLiveData<>();

    public void requestExpectDataByEvent() {
        DataRepository.getInstance().requestExpectData(closeEvent);
    }
}
