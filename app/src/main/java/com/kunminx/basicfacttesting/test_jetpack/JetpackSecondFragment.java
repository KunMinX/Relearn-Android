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

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.databinding.FragmentJetpackSecondBinding;

/**
 * Create by KunMinX at 19/6/27
 */
public class JetpackSecondFragment extends Fragment {

    private FragmentJetpackSecondBinding mBinding;

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
    }

}
