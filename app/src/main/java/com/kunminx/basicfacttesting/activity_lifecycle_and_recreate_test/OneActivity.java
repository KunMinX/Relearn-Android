package com.kunminx.basicfacttesting.activity_lifecycle_and_recreate_test;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.kunminx.basicfacttesting.R;


/**
 * Create by KunMinX at 2018/10/18
 */
public class OneActivity extends BaseLifeCycleActivity {

    private String TAG_OF_AUTO_FRAGMENT = "";
    private String TAG_OF_FRAGMENT = "";
    private static String STATE_OF_AUTO_FRAGMENT = "STATE_OF_AUTO_FRAGMENT";
    private static String STATE_OF_FRAGMENT = "STATE_OF_FRAGMENT";

    private OneFragment mOneFragment;
    private Fragment mAutoFragment;
    private Button mBtnJumpAty, mBtnJumpFrg, mBtnShowDlg;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mBtnJumpAty = (Button) findViewById(R.id.btn_jump_aty);
        mBtnJumpFrg = (Button) findViewById(R.id.btn_jump_frg);
        mBtnShowDlg = (Button) findViewById(R.id.btn_show_dlg);

        mBtnJumpAty.setOnClickListener(v -> {
            startActivity(new Intent(OneActivity.this, SecondActivity.class));
        });

        mBtnJumpFrg.setOnClickListener(v -> {
            jumpToOneFragment();
        });
        mBtnShowDlg.setOnClickListener(v -> {
            showDialog();
        });

        //TODO ：此处可打开旋转屏幕开关，允许旋屏，来测试。
        // 此处的设计是用于，在 Activity 旋屏重建后，fragment 实例可通过 tag 拿到并恢复，
        // 无需再次创建新的和添加入栈，不然栈中可能被重复加入多个同样的 fragment

        if (savedInstanceState != null) {
            TAG_OF_FRAGMENT = savedInstanceState.getString(STATE_OF_FRAGMENT);
            if (!TextUtils.isEmpty(TAG_OF_FRAGMENT)) {
                mOneFragment = (OneFragment) getSupportFragmentManager().findFragmentByTag(TAG_OF_FRAGMENT);
                if (mOneFragment != null) {
                    getSupportFragmentManager().beginTransaction().show(mOneFragment).commitAllowingStateLoss();
                }
            }

            TAG_OF_AUTO_FRAGMENT = savedInstanceState.getString(STATE_OF_AUTO_FRAGMENT);
            mAutoFragment = getSupportFragmentManager().findFragmentByTag(TAG_OF_AUTO_FRAGMENT);
            if (mAutoFragment != null) {
                if (mAutoFragment instanceof OneAutoFragment) {
                    ((OneAutoFragment) mAutoFragment).setIOneAutoFragment(() -> {
                        jumpToSecondFragment();
                    });
                }
                getSupportFragmentManager().beginTransaction().show(mAutoFragment).commitAllowingStateLoss();
            }

        } else if (mAutoFragment == null && TextUtils.isEmpty(TAG_OF_AUTO_FRAGMENT)) {
            mAutoFragment = new OneAutoFragment();
            ((OneAutoFragment) mAutoFragment).setIOneAutoFragment(() -> {
                jumpToSecondFragment();
            });
            TAG_OF_AUTO_FRAGMENT = OneAutoFragment.class.getSimpleName();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frg_container_1, mAutoFragment, TAG_OF_AUTO_FRAGMENT)
//                    .addToBackStack(null) //此处留着测试用，可以测测看，当 autoFragment 也入栈的情况下，返回键点击的效果
                    .commitAllowingStateLoss();
        }

    }

    public void jumpToOneFragment() {
        if (TextUtils.isEmpty(TAG_OF_FRAGMENT)) {
            TAG_OF_FRAGMENT = OneFragment.class.getSimpleName();
        } else {
            mOneFragment = (OneFragment) getSupportFragmentManager().findFragmentByTag(TAG_OF_FRAGMENT);
        }

        if (mOneFragment == null) {
            mOneFragment = new OneFragment();
        }

        if (!mOneFragment.isAdded()) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frg_container, mOneFragment, TAG_OF_FRAGMENT)
                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        }
    }

    public void jumpToSecondFragment() {
        TAG_OF_AUTO_FRAGMENT = SecondFragment.class.getSimpleName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.frg_container_1, new SecondFragment(() -> {
            TAG_OF_AUTO_FRAGMENT = OneAutoFragment.class.getSimpleName();
        }));
        ft.hide(mAutoFragment);
        ft.addToBackStack(null);
        ft.commitAllowingStateLoss();
    }

    public void showDialog() {
        new AlertDialog.Builder(this).setTitle("xxx").create().show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_OF_AUTO_FRAGMENT, TAG_OF_AUTO_FRAGMENT);
        outState.putString(STATE_OF_FRAGMENT, TAG_OF_FRAGMENT);
    }

}
