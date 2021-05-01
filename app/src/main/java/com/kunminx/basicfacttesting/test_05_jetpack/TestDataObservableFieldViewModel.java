package com.kunminx.basicfacttesting.test_05_jetpack;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * Create by KunMinX at 19/9/5
 */
@Deprecated
public class TestDataObservableFieldViewModel extends ViewModel {


    private ObservableField<String> name = new ObservableField<>();
    private ObservableInt age = new ObservableInt();
    private ObservableBoolean visible = new ObservableBoolean();
    private ObservableField<String> msg = new ObservableField<>();

    {
        name.set("test");
        age.set(12);
        visible.set(true);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public ObservableInt getAge() {
        return age;
    }

    public ObservableBoolean getVisible() {
        return visible;
    }

    public ObservableField<String> getMsg() {
        return msg;
    }

}
