package com.kunminx.basicfacttesting.test_jetpack.livedata_and_viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * 非粘性 LiveData，仅分发 owner observe 后新拿到的数据
 * <p>
 * Create by KunMinX at 19/9/23
 */
@Deprecated
public class UnPeekLiveData<T> extends MutableLiveData<T> {

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {

        // 有网友提出，为什么不直接在 super.observe 前 setValue(null)，而非要反射的方式去修改 lastVersion 呢？
        // 问得好。
        // 因为 UnPeek-LiveData 是为了跨页面通信而存在的，它可能已被多个页面 observe，
        // 那么在新页面 observe 前 setValue(null) 一次，容易造成 其他已观察页面 遭受容易被疏忽的 被迫推送，而产生不可预期的错误。

        // 同时你会发现，我并不采用美团的纯粹 LiveDataBus，而是将 UnPeek-LiveData 作为普通的 LiveData 托管给独立的 SharedViewModel。
        // 这么做是为了遵循 唯一可信源分发状态 的编程理念，以避免难以追溯、难以排查、不可预期的问题。

        super.observe(owner, observer);
        hook(observer);
    }

    private void hook(Observer<? super T> observer) {
        Class<LiveData> liveDataClass = LiveData.class;
        try {
            //获取field private SafeIterableMap<Observer<T>, ObserverWrapper> mObservers
            Field mObservers = liveDataClass.getDeclaredField("mObservers");
            mObservers.setAccessible(true);
            //获取SafeIterableMap集合mObservers
            Object observers = mObservers.get(this);
            Class<?> observersClass = observers.getClass();
            //获取SafeIterableMap的get(Object obj)方法
            Method methodGet = observersClass.getDeclaredMethod("get", Object.class);
            methodGet.setAccessible(true);
            //获取到observer在集合中对应的ObserverWrapper对象
            Object objectWrapperEntry = methodGet.invoke(observers, observer);
            Object objectWrapper = null;
            if (objectWrapperEntry instanceof Map.Entry) {
                objectWrapper = ((Map.Entry) objectWrapperEntry).getValue();
            }
            if (objectWrapper == null) {
                throw new NullPointerException("ObserverWrapper can not be null");
            }
            //获取ObserverWrapper的Class对象  LifecycleBoundObserver extends ObserverWrapper
            Class<?> wrapperClass = objectWrapper.getClass().getSuperclass();
            //获取ObserverWrapper的field mLastVersion
            Field mLastVersion = wrapperClass.getDeclaredField("mLastVersion");
            mLastVersion.setAccessible(true);
            //获取liveData的field mVersion
            Field mVersion = liveDataClass.getDeclaredField("mVersion");
            mVersion.setAccessible(true);
            Object mV = mVersion.get(this);
            //把当前ListData的mVersion赋值给 ObserverWrapper的field mLastVersion
            mLastVersion.set(objectWrapper, mV);

            mObservers.setAccessible(false);
            methodGet.setAccessible(false);
            mLastVersion.setAccessible(false);
            mVersion.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
