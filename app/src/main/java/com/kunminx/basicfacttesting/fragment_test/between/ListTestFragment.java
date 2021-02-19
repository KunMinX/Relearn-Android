package com.kunminx.basicfacttesting.fragment_test.between;
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

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.fragment_test.BaseFragment;
import com.kunminx.basicfacttesting.fragment_test.between.adapter.NewsAdapter;
import com.kunminx.basicfacttesting.fragment_test.between.bean.News;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by KunMinX at 19/6/27
 */
public class ListTestFragment extends BaseFragment {

    private ListTestListener mListener;
    private RecyclerView mRv;
    private NewsAdapter mAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_test_list;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRv = view.findViewById(R.id.rv);
        mRv.setAdapter(mAdapter = new NewsAdapter());
        mAdapter.setListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, News news) {
                if (mListener != null) {
                    mListener.onItemClick(position, news);
                }
            }
        });
        mAdapter.setList(getTestData());
    }

    private List<News> getTestData() {
        List<News> news = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            news.add(new News("Title " + i, "Content " + i));
        }
        return news;
    }

    public void setListener(ListTestListener listener) {
        this.mListener = listener;
    }

    public interface ListTestListener {
        void onItemClick(int position, News news);
    }
}
