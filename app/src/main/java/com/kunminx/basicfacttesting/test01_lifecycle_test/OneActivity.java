package com.kunminx.basicfacttesting.test01_lifecycle_test;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

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
    private Button mBtnJumpAty, mBtnJumpFrg, mBtnShowDlg, mBtnPage1, mBtnPage2, mBtnPage3;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mBtnJumpAty = (Button) findViewById(R.id.btn_jump_aty);
        mBtnJumpFrg = (Button) findViewById(R.id.btn_jump_frg);
        mBtnShowDlg = (Button) findViewById(R.id.btn_show_dlg);

        mBtnPage1 = (Button) findViewById(R.id.btn_page1);
        mBtnPage2 = (Button) findViewById(R.id.btn_page2);
        mBtnPage3 = (Button) findViewById(R.id.btn_page3);

        mBtnJumpAty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OneActivity.this, SecondActivity.class));
            }
        });
        mBtnJumpFrg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(TAG_OF_FRAGMENT)) {
                    mOneFragment = new OneFragment();
                    TAG_OF_FRAGMENT = OneFragment.class.getSimpleName();
                } else {
                    mOneFragment = (OneFragment) getSupportFragmentManager()
                            .getFragment(savedInstanceState, TAG_OF_FRAGMENT);
                }
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.frg_container, mOneFragment, TAG_OF_FRAGMENT)
                        .addToBackStack(null)
                        .commitAllowingStateLoss();
            }
        });
        mBtnShowDlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        if (savedInstanceState != null) {
           /* TAG_OF_AUTO_FRAGMENT = savedInstanceState.getString(STATE_OF_AUTO_FRAGMENT);
            mAutoFragment = getSupportFragmentManager().findFragmentByTag(TAG_OF_AUTO_FRAGMENT);
            getSupportFragmentManager().beginTransaction().show(mAutoFragment).commitAllowingStateLoss();

            TAG_OF_FRAGMENT = savedInstanceState.getString(STATE_OF_FRAGMENT);
            if (!TextUtils.isEmpty(TAG_OF_FRAGMENT)) {
                mOneFragment = (OneFragment) getSupportFragmentManager().findFragmentByTag(TAG_OF_FRAGMENT);
                getSupportFragmentManager().beginTransaction().show(mOneFragment).commitAllowingStateLoss();
            }*/

            TAG_OF_AUTO_FRAGMENT = savedInstanceState.getString(STATE_OF_AUTO_FRAGMENT);
            mAutoFragment = getSupportFragmentManager().findFragmentByTag(TAG_OF_AUTO_FRAGMENT);
            ((OneAutoFragment) mAutoFragment).setIOneAutoFragment(new IOneAutoFragment() {
                @Override
                public void onJumpToSecondFragment() {
                    jumpToSecondFragment();
                }
            });

        } else if (mAutoFragment == null && TextUtils.isEmpty(TAG_OF_AUTO_FRAGMENT)) {
            mAutoFragment = new OneAutoFragment();
            ((OneAutoFragment) mAutoFragment).setIOneAutoFragment(new IOneAutoFragment() {
                @Override
                public void onJumpToSecondFragment() {
                    jumpToSecondFragment();
                }
            });
            TAG_OF_AUTO_FRAGMENT = OneAutoFragment.class.getSimpleName();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frg_container_1, mAutoFragment, TAG_OF_AUTO_FRAGMENT)
//                    .addToBackStack(null)
                    .commitAllowingStateLoss();
        }


       /* mBtnPage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHideFragment(OneAutoFragment.class.getSimpleName(),
                        "com.kunminx.basicfacttesting.test01_lifecycle_test.OneAutoFragment");
            }
        });

        mBtnPage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHideFragment(SecondFragment.class.getSimpleName(),
                        "com.kunminx.basicfacttesting.test01_lifecycle_test.SecondFragment");
            }
        });

        mBtnPage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHideFragment(ThirdFragment.class.getSimpleName(),
                        "com.kunminx.basicfacttesting.test01_lifecycle_test.ThirdFragment");
            }
        });*/

    }

    //TODO not good
    public void showHideFragment(String tag, String fragmentClass) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (fragment == null) {
            try {
                fragment = (Fragment) Class.forName(fragmentClass).newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frg_container_1, fragment, tag);
            if (mAutoFragment != null) {
                transaction.hide(mAutoFragment);
            }
//            transaction.addToBackStack(null)
            transaction.commitAllowingStateLoss();
        } else if (fragment.isHidden()) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.show(fragment);
            if (mAutoFragment != null) {
                transaction.hide(mAutoFragment);
            }
            transaction.commitAllowingStateLoss();
        }
    }

    public void jumpToSecondFragment() {
        STATE_OF_AUTO_FRAGMENT = SecondFragment.class.getSimpleName();
        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.frg_container_1, new SecondFragment(), STATE_OF_AUTO_FRAGMENT)
                .add(R.id.frg_container_1, new SecondFragment())
                .hide(mAutoFragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
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

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

}
