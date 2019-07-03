package com.kunminx.basicfacttesting.test_animator;
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
import android.view.View;
import android.view.Window;

import com.kunminx.basicfacttesting.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Create by KunMinX at 19/6/27
 */
public class AnimatorListActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private AnimatorAdapter mAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_animator_list);

        mRv = findViewById(R.id.rv);
        ((GridLayoutManager) mRv.getLayoutManager()).setSpanCount(2);
        mAdapter = new AnimatorAdapter();
        mRv.setAdapter(mAdapter);
        mRv.addItemDecoration(new SpaceItemDecoration(10));
        mAdapter.setItemClickListener(new AnimatorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(AnimatorAdapter.AnimatorViewHolder holder, AnimatorItem item) {
                Intent intent = new Intent(AnimatorListActivity.this, AnimatorDetailActivity.class);
                intent.putExtra("data", item);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        AnimatorListActivity.this,
                        new Pair<View, String>(holder.iv, "iv"),
                        new Pair<View, String>(holder.tv, "tv"));
                ActivityCompat.startActivity(AnimatorListActivity.this, intent, options.toBundle());
            }
        });

        List<AnimatorItem> items = new ArrayList<>();
//        items.add(new AnimatorItem("xx", "https://i.loli.net/2019/07/01/5d199966334c334479.jpg"));
//        items.add(new AnimatorItem("xx", "https://i.loli.net/2019/07/01/5d1999665bb7140353.jpg"));
//        items.add(new AnimatorItem("xx", "https://i.loli.net/2019/07/01/5d19996683a6a83050.jpg"));
//        items.add(new AnimatorItem("xx", "https://i.loli.net/2019/07/01/5d1999668413c64964.jpg"));
        items.add(new AnimatorItem("xxxxx1", "https://upload-images.jianshu.io/upload_images/57036-9fec94786f14a7c0.jpg"));
        items.add(new AnimatorItem("xxxxx2", "https://upload-images.jianshu.io/upload_images/57036-9fec94786f14a7c0.jpg"));
        items.add(new AnimatorItem("xxxxx3", "https://upload-images.jianshu.io/upload_images/57036-9fec94786f14a7c0.jpg"));
        items.add(new AnimatorItem("xxxxx4", "https://upload-images.jianshu.io/upload_images/57036-9fec94786f14a7c0.jpg"));

        mAdapter.refreshList(items);
    }


}
