package com.kunminx.basicfacttesting.test_jetpack.lifecycler;
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
import com.kunminx.basicfacttesting.databinding.FragmentJetpackFirstBinding;
import com.kunminx.basicfacttesting.test_jetpack.FragmentNavigator;
import com.kunminx.basicfacttesting.test_jetpack.livedata_and_viewmodel.JetpackSecondFragment;
import com.kunminx.basicfacttesting.test_jetpack.livedata_and_viewmodel.TestLiveDataViewModel;

/**
 * 这个 fragment 用于 LifeCycler 的示例，
 * 可以直观地看到，LifeCycler 加持的 lifeGpsManager 解决了生命周期管理的一致性问题。
 * <p>
 * Create by KunMinX at 19/6/27
 */
public class JetpackFirstFragment extends Fragment {

    private FragmentJetpackFirstBinding mBinding;
    private TestLiveDataViewModel mTestLiveDataViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(LifeGpsManager.getInstance());
        mTestLiveDataViewModel = ViewModelProviders.of(getActivity()).get(TestLiveDataViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jetpack_first, container, false);
        mBinding = FragmentJetpackFirstBinding.bind(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.tvTag.setText(JetpackFirstFragment.class.getSimpleName());
        mBinding.btnJump.setText(getString(R.string.jump_to_fragment_two));

        mBinding.btnJump.setOnClickListener(v -> {
            FragmentNavigator.getInstance().navigate(JetpackFirstFragment.this, new JetpackSecondFragment());
        });

        mBinding.btnBack.setOnClickListener(v -> getActivity().finish());

    }

    /*@Override
    public void onResume() {
        super.onResume();
        mGpsManager.onResume();
        mGpsManager.setActive(true);
    }

    @Override
    public void onPause() {
        mGpsManager.setActive(false);
        mGpsManager.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mGpsManager.onDestroy();
        super.onDestroy();
    }*/
}
