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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.databinding.FragmentJetpackSecondBinding;

/**
 * Create by KunMinX at 19/6/27
 */
public class JetpackSecondFragment extends Fragment {

    private FragmentJetpackSecondBinding mBinding;
    private TestLiveDataViewModel mTestLiveDataViewModel;
    private BusViewModel mBusViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTestLiveDataViewModel = ViewModelProviders.of(getActivity()).get(TestLiveDataViewModel.class);
        mBusViewModel = ViewModelProviders.of(getActivity()).get(BusViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jetpack_second, container, false);
        mBinding = FragmentJetpackSecondBinding.bind(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.tvTag.setText(JetpackSecondFragment.class.getSimpleName());

        mBinding.btnJump1.setOnClickListener(v ->
                FragmentNavigator.getInstance().navigate(JetpackSecondFragment.this, new DatabindingLiveDataFragment())
        );

        mBinding.btnJump2.setOnClickListener(v ->
                FragmentNavigator.getInstance().navigate(JetpackSecondFragment.this, new DatabindingObservaleFieldFragment())
        );

        mBinding.btnJump3.setOnClickListener(v ->
                FragmentNavigator.getInstance().navigate(JetpackSecondFragment.this, new DatabindingObservaleFragment())
        );

        mBinding.btnBack.setOnClickListener(v ->
                FragmentNavigator.getInstance().navigateUp()
        );

        mBinding.btnLivedata.setOnClickListener(v -> {
            mTestLiveDataViewModel.requestData();
        });

        // 正常情况下，应该是从别的页面发起了回调的请求，然后本页面观察到并处理
        // 这里为了直观，而把 request 方法用在了本页面
        mBinding.btnExpLivedata.setOnClickListener(v -> {
            mBusViewModel.requestExpectData();
        });

        // LiveData 的一个 bug，当使用共享 ViewModel 时，下次进入该页面，会倒灌旧数据。
        // 如果你不停地关闭页面，可清掉进程再进入该项目。
        // 目前查出的原因是，observe.lastVersion == -1 而 version == 0，导致的进入页面 observe 时会受到一次推送，
        // 所以找到的解决办法是，通过 hook 来在 liveData 创建时为 lastVersion 赋值
        mTestLiveDataViewModel.getLiveData().observe(this, aBoolean -> {
            if (aBoolean) {
                FragmentNavigator.getInstance().navigateUp();
//                Toast.makeText(getContext(), "xxx", Toast.LENGTH_SHORT).show();
            }
        });

        // 感谢这位仁兄提供的解决方案：
        // https://blog.csdn.net/geyuecang/article/details/89028283
        mBusViewModel.closeCallback.observe(this, aBoolean -> {
            if (aBoolean) {
                FragmentNavigator.getInstance().navigateUp();
            }
        });

//        if (savedInstanceState == null) {
//            mTestLiveDataViewModel.requestData();
//        }
    }

}
