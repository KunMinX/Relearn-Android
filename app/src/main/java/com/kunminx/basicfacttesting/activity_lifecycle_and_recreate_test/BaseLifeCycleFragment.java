package com.kunminx.basicfacttesting.activity_lifecycle_and_recreate_test;

import android.animation.Animator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * Create by KunMinX at 2018/10/18
 */
public class BaseLifeCycleFragment extends Fragment {

    protected String className = getClass().getSimpleName();
    protected static final String TAG = "info";

    @Nullable
    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        Log.d(TAG, className + "--onCreateAnimation()");
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Nullable
    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        Log.d(TAG, className + "--onCreateAnimator()");
        return super.onCreateAnimator(transit, enter, nextAnim);
    }

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, className + "--onAttach()");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, className + "--onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, className + "--onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, className + "--onViewCreated()");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, className + "--onActivityCreated()");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, className + "--onStart()");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, className + "--onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, className + "--onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, className + "--onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, className + "--onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, className + "--onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, className + "--onDetach()");
        super.onDetach();
    }

}
