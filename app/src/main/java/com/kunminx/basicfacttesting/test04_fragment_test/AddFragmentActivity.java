package com.kunminx.basicfacttesting.test04_fragment_test;
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

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.kunminx.basicfacttesting.R;

/**
 * Create by KunMinX at 19/6/27
 */
public class AddFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment_add);

        if (savedInstanceState == null) {
            loadFirstFragment();
        }
    }

    private void loadFirstFragment() {
        OneTestFragment fragment = new OneTestFragment();
        fragment.setListener(new OneTestFragment.OneTestListener() {
            @Override
            public void loadTwoTest() {
                loadSecondFragment();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment,
                        OneTestFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    private void loadSecondFragment() {
        TwoTestFragment fragment = new TwoTestFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment,
                        TwoTestFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }
}
