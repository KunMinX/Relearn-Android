package com.kunminx.basicfacttesting.lifecycle_test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kunminx.basicfacttesting.R;


/**
 * @author KunMinX
 * @date 2018/10/18
 */
public class OneFragment extends Fragment {

    private static final String TAG = "------OneFragment";

    
    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "Fragment--onAttach()");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment--onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment--onCreateView()");
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment--onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.btn_jump_frg).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .add(R.id.frg_container, new SecondFragment())
                        .hide(OneFragment.this)
                        .addToBackStack(null).commit();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment--onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "Fragment--onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "Fragment--onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "Fragment--onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "Fragment--onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "Fragment--onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "Fragment--onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "Fragment--onDetach()");
        super.onDetach();
    }

}
