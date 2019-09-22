package com.kunminx.basicfacttesting.test_jetpack;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

/**
 * Create by KunMinX at 19/9/5
 */
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
