package com.kunminx.basicfacttesting.jetpack_test;
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
import com.kunminx.basicfacttesting.jetpack_test.lifecycler.JetpackFirstFragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 * <p>
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 * <p>
 * Create by KunMinX at 19/6/27
 */
@Deprecated
public class JetpackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jetpack);

        FragmentNavigator.getInstance().init(this, R.id.fragment_container);

        FragmentNavigator.getInstance().loadRootFragment(new JetpackFirstFragment());

    }
}
