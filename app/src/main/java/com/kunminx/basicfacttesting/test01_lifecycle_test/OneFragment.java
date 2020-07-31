package com.kunminx.basicfacttesting.test01_lifecycle_test;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/18
 */
public class OneFragment extends BaseLifeCycleFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_lifecycler_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_jump_frag).setOnClickListener(v -> getFragmentManager().beginTransaction()
                .add(R.id.frg_container, new SecondFragment(() -> {

                }))
                .hide(OneFragment.this)
                .addToBackStack(null).commit());
    }

}
