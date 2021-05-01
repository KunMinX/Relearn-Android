package com.kunminx.basicfacttesting.test_05_jetpack;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * TODO：Jetpack 相关内容请移步查阅 持续维护的《Jetpack MVVM 最佳实践》项目的深度解析
 *
 * https://github.com/KunMinX/Jetpack-MVVM-Best-Practice
 *
 * Create by KunMinX at 19/7/14
 */
@Deprecated
public class FragmentNavigator {

    private int mFragmentContainerResId;
    private FragmentManager mFragmentManager;

    private static FragmentNavigator sFragmentNavigator = new FragmentNavigator();

    public static FragmentNavigator getInstance() {
        return sFragmentNavigator;
    }

    private FragmentNavigator() {
    }

    public void init(AppCompatActivity mainActivity, int fragmentContainerResId) {
        this.mFragmentManager = mainActivity.getSupportFragmentManager();
        this.mFragmentContainerResId = fragmentContainerResId;
    }

    /**
     *
     * <p>
     * add hide fragment
     *
     * @param last
     * @param dest
     */
    public void navigate(Fragment last, Fragment dest) {
        FragmentTransaction t = mFragmentManager.beginTransaction();
        t.add(mFragmentContainerResId, dest, dest.getClass().getSimpleName());
        t.hide(last);
        t.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        t.addToBackStack(null);
        t.commit();
    }

    public void navigate(Fragment last, Fragment dest, Bundle bundle, int... customAnim) {
        dest.setArguments(bundle);
        FragmentTransaction t = mFragmentManager.beginTransaction();
        t.add(mFragmentContainerResId, dest, dest.getClass().getSimpleName());
        t.hide(last);
        t.setCustomAnimations(customAnim[0], customAnim[1], customAnim[2], customAnim[3]);
        t.addToBackStack(null);
        t.commit();
    }

    /**
     * replace fragment
     *
     * @param dest
     */
    public void navigate(Fragment dest) {
        FragmentTransaction t = mFragmentManager.beginTransaction();
        t.replace(mFragmentContainerResId, dest, dest.getClass().getSimpleName());
        t.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        t.addToBackStack(null);
        t.commit();
    }

    /**
     * add root fragment
     *
     * @param root
     */
    public void loadRootFragment(Fragment root) {
        FragmentTransaction t = mFragmentManager.beginTransaction();
        if (mFragmentManager.getFragments().size() > 0) {
            t.replace(mFragmentContainerResId, root, root.getClass().getSimpleName());
        } else {
            t.add(mFragmentContainerResId, root, root.getClass().getSimpleName());
        }
        t.commit();
    }

    /**
     * navigate up
     */
    public void navigateUp() {
        //屏幕旋转后可能发生 Can not perform this action after onSaveInstanceState
        mFragmentManager.popBackStack();
    }

    /**
     * pop all behind fragmentName, and replace to dest
     *
     * @param lastRootFragmentName
     * @param dest
     */
    public void navigateAfterPop(String lastRootFragmentName, Fragment dest) {
        //注意，rootFragment 并不在栈中（因为没有添加到回退栈），所以此处的出栈，出的是 root 之上的其他 frgament
        //所以 replace 不好用的话，那这里我就用 remove
        mFragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FragmentTransaction t = mFragmentManager.beginTransaction();
        Fragment from = mFragmentManager.findFragmentByTag(lastRootFragmentName);
        if (from != null) {
            t.remove(from);
        }
        t.add(mFragmentContainerResId, dest, dest.getClass().getSimpleName());
        t.commit();
    }

    public void navigateFromLastFragment(Fragment dest) {
        Fragment last = mFragmentManager.getFragments().get(mFragmentManager.getFragments().size() - 1);
        FragmentTransaction t = mFragmentManager.beginTransaction();
        t.add(mFragmentContainerResId, dest, dest.getClass().getSimpleName());
        t.hide(last);
        t.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        t.addToBackStack(null);
        t.commit();
    }

    public Fragment getFragmentByTag(String tag) {
        return mFragmentManager.findFragmentByTag(tag);
    }


}
