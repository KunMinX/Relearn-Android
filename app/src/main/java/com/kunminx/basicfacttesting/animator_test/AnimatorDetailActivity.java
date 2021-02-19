package com.kunminx.basicfacttesting.animator_test;
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


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kunminx.basicfacttesting.R;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;

/**
 * Create by KunMinX at 19/6/27
 */
public class AnimatorDetailActivity extends AppCompatActivity {

    private TextView mTv;
    private AppCompatImageView mIv;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        getWindow().setExitTransition(new ChangeImageTransform());
        setContentView(R.layout.activity_animator_detail);

        mTv = findViewById(R.id.tv_title);
        mIv = findViewById(R.id.iv_detail);
        ViewCompat.setTransitionName(mTv, "tv");
        ViewCompat.setTransitionName(mIv, "iv");

        Intent intent = getIntent();
        AnimatorItem item = (AnimatorItem) intent.getSerializableExtra("data");
        mTv.setText(item.getTitle());
        Glide.with(mIv.getContext()).load(item.getUrl()).into(mIv);
    }


}
