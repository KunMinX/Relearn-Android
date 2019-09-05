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

import com.kunminx.basicfacttesting.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Create by KunMinX at 19/6/27
 */
public class JetpackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetpack);

        loadFirstFragment();
    }

    private void loadFirstFragment() {
        JetpackFirstFragment fragment = new JetpackFirstFragment();
        fragment.setListener(new JetpackFirstFragment.OneTestListener() {
            @Override
            public void loadTwoTest() {
                loadSecondFragment();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment,
                        JetpackFirstFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    private void loadSecondFragment() {
        JetpackSecondFragment fragment = new JetpackSecondFragment();
        fragment.setListener(new JetpackSecondFragment.TwoTestListener() {
            @Override
            public void loadTwoTest() {
                loadThirdFragment();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment,
                        JetpackSecondFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }

    private void loadThirdFragment() {
        JetpackThirdFragment fragment = new JetpackThirdFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment,
                        JetpackThirdFragment.class.getSimpleName())
                .addToBackStack(null)
                .commit();
    }
}
