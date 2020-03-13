package com.kunminx.basicfacttesting.test04_fragment_test.jump;
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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.test04_fragment_test.BaseFragment;
import com.kunminx.basicfacttesting.test04_fragment_test.between.adapter.NewsAdapter;
import com.kunminx.basicfacttesting.test04_fragment_test.between.bean.News;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by KunMinX at 19/6/27
 */
public class OneTestFragment extends BaseFragment {

    private TextView mTvTitle;
    private MaterialButton mJump, mBack;
    private RecyclerView mRv;
    private TextView mTextView;
    private EditText mEditText;
    private NewsAdapter mAdapter;
    private OneTestListener mListener;

    @Override
    protected int getLayout() {
        return R.layout.fragment_test_add;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        Log.d("TAG", "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_tag);
        mJump = view.findViewById(R.id.btn_jump);
        mBack = view.findViewById(R.id.btn_back);

        mTvTitle.setText(OneTestFragment.class.getSimpleName());
        mJump.setText(getString(R.string.jump_to_fragment_two));

        mJump.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.loadTwoTest();
            }
        });

        mBack.setOnClickListener(v -> mActivity.getSupportFragmentManager().popBackStack());

        mRv = view.findViewById(R.id.rv);
        mRv.setAdapter(mAdapter = new NewsAdapter());
        mAdapter.setList(getTestData());
        mAdapter.notifyDataSetChanged();

        mTextView = view.findViewById(R.id.tv_text);
        mEditText = view.findViewById(R.id.et_text);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mTextView.setText(mEditText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private List<News> getTestData() {
        List<News> news = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            news.add(new News("Title " + i, "Content " + i));
        }
        return news;
    }

    public void setListener(OneTestListener listener) {
        this.mListener = listener;
    }

    public interface OneTestListener {
        void loadTwoTest();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG", "onDestroyView");
    }
}
