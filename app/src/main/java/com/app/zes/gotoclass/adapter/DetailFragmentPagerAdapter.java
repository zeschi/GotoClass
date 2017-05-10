package com.app.zes.gotoclass.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.app.zes.gotoclass.fragment.DetailFragment;
import com.app.zes.gotoclass.fragment.InteractFragment;
import com.zes.bundle.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/30.
 */
public class DetailFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"详情", "互动"};
    private Context context;

    private List<BaseFragment> list;

    private int mLessonId;
    private int mCourseId;

    public DetailFragmentPagerAdapter(FragmentManager fm, Context context, int lessonId, int courseId) {
        super(fm);
        this.context = context;
        this.mLessonId = lessonId;
        this.mCourseId = courseId;
        initList();
    }

    private void initList() {
        list = new ArrayList<>();
        list.add(DetailFragment.newInstance(mLessonId, mCourseId));
        list.add(InteractFragment.newInstance(mLessonId, mCourseId));
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}