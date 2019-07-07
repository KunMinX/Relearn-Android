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
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.test04_fragment_test.BaseFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Create by KunMinX at 19/6/27
 */
public class JetpackFirstFragment extends BaseJetpackFragment {

    private TextView mTvTitle;
    private MaterialButton mJump, mBack;
    private OneTestListener mListener;

    @Override
    protected int getLayout() {
        return R.layout.fragment_test_add;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_tag);
        mJump = view.findViewById(R.id.btn_jump);
        mBack = view.findViewById(R.id.btn_back);

        mTvTitle.setText(JetpackFirstFragment.class.getSimpleName());
        mJump.setText(getString(R.string.jump_to_fragment_two));

        mJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.loadTwoTest();
                }
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.getSupportFragmentManager().popBackStack();
            }
        });
    }

    public void setListener(OneTestListener listener) {
        this.mListener = listener;
    }

    public interface OneTestListener {
        void loadTwoTest();
    }

    private GpsManager1 mGpsManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGpsManager = new GpsManager1();
        getLifecycle().addObserver(mGpsManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getLifecycle().removeObserver(mGpsManager);
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
