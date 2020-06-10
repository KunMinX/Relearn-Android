package com.kunminx.basicfacttesting.test_jetpack;
/*
 * Copyright (c) 2018-2019. KunMinX
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.databinding.FragmentTestDatabindingObserveBinding;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * Create by KunMinX at 19/6/27
 */
@Deprecated
public class DatabindingObservaleFragment extends Fragment {

    private FragmentTestDatabindingObserveBinding mBinding;
    private TestDataObservableViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TestDataObservableViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_databinding_observe, container, false);
        mBinding = FragmentTestDatabindingObserveBinding.bind(view);
        mBinding.setLifecycleOwner(this);
        mBinding.setClickProxy(new ClickProxy());
        mBinding.setVm(mViewModel);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    public class ClickProxy {
        public void nameChange() {
            TestData testData = mViewModel.getTestData();
            testData.setName(String.valueOf(System.currentTimeMillis()));
        }

        public void ageChange() {
            TestData testData = mViewModel.getTestData();
            testData.setAge(mViewModel.getTestData().getAge() + 1);
        }

        public void showChange() {
            TestData testData = mViewModel.getTestData();
            testData.setVisible(!mViewModel.getTestData().isVisible());
        }

        public void showDoubleBindingResult() {
            //每次都能获取到最新的、由控件变化时自动推到状态变量的状态值
            Toast.makeText(getActivity().getApplicationContext(),
                    mViewModel.getTestData().getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

}
