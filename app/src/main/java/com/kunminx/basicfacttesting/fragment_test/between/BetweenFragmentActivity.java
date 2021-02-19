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

import com.kunminx.basicfacttesting.R;
import com.kunminx.basicfacttesting.fragment_test.between.bean.News;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Create by KunMinX at 19/6/27
 */
public class BetweenFragmentActivity extends AppCompatActivity {

    private ListTestFragment mListTestFragment;
    private DetailTestFragment mDetailTestFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment_between);

        if (savedInstanceState == null) {
            loadFirstFragment();
            loadSecondFragment();
        } else {
            mListTestFragment = (ListTestFragment) getSupportFragmentManager().
                    findFragmentByTag(ListTestFragment.class.getSimpleName());
            mDetailTestFragment = (DetailTestFragment) getSupportFragmentManager().
                    findFragmentByTag(DetailTestFragment.class.getSimpleName());
        }
    }

    private void loadFirstFragment() {
        mListTestFragment = new ListTestFragment();
        mListTestFragment.setListener(new ListTestFragment.ListTestListener() {
            @Override
            public void onItemClick(int position, News news) {
                mDetailTestFragment.refreshContent(news);
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_left, mListTestFragment,
                        ListTestFragment.class.getSimpleName())
                .commit();
    }

    private void loadSecondFragment() {
        mDetailTestFragment = new DetailTestFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container_right, mDetailTestFragment,
                        DetailTestFragment.class.getSimpleName())
                .commit();
    }
}
