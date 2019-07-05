package com.kunminx.basicfacttesting.test04_fragment_test.between;
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


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.test04_fragment_test.BaseFragment;
import com.kunminx.basicfacttesting.test04_fragment_test.between.bean.News;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Create by KunMinX at 19/6/27
 */
public class DetailTestFragment extends BaseFragment {

    private TextView mTvTitle, mTvContent;
    private static final String INIT_DATA = "INIT_DATA";
//    private News mNews;

    /*public static DetailTestFragment newInstance(News news) {
        Bundle args = new Bundle();
        args.putSerializable(INIT_DATA, news);
        DetailTestFragment fragment = new DetailTestFragment();
        fragment.setArguments(args);
        return fragment;
    }*/

    /*@Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            mNews = (News) getArguments().get(INIT_DATA);
        }
    }*/

    @Override
    protected int getLayout() {
        return R.layout.fragment_test_detail;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.tv_title);
        mTvContent = view.findViewById(R.id.tv_content);


    }

    public void refreshContent(News news) {
        if (news != null) {
            mTvTitle.setText(news.getTitle());
            mTvContent.setText(news.getContent());
        }
    }

}
