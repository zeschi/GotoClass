package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.FrameLayout;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.fragment.ClassFragment;
import com.app.zes.gotoclass.fragment.MineFragment;
import com.app.zes.gotoclass.fragment.SignFragment;
import com.app.zes.gotoclass.utils.RxBus;
import com.app.zes.gotoclass.view.AddCourseDialog;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.fragment.BaseFragment;
import com.zes.bundle.utils.MKToast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {


    @Bind(R.id.layFrame)
    FrameLayout layFrame;
    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    private ArrayList<BaseFragment> fragments;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                );
        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_class, "上课").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_sign, "签到").setActiveColorResource(R.color.colorPrimary))
                .addItem(new BottomNavigationItem(R.drawable.ic_user, "我的").setActiveColorResource(R.color.colorPrimary))
                .setFirstSelectedPosition(0)
                .initialise();

        fragments = getFragments();
        setDefaultFragment();
        bottomNavigationBar.setTabSelectedListener(this);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.getItem(0).setOnMenuItemClickListener(menuItem -> {
            addCourse();
            return false;
        });

        return true;
    }

    /**
     * 添加课程
     */
    private void addCourse() {
        AddCourseDialog addCourseDialog = new AddCourseDialog(MainActivity.this);
//        addCourseDialog.setTitle("提示");
//        addCourseDialog.setMessage("确定退出应用?");
        addCourseDialog.setYesOnclickListener("确定", () -> {
//            Toast.makeText(MainActivity.this, "点击了--确定--按钮", Toast.LENGTH_LONG).show();
            String courseCode = addCourseDialog.getMessage();
            ApiFactory.findCourseByCode(courseCode).subscribe(courseByCode -> {
//                RxBus.getInstance().post(1);
                if (courseByCode != null && courseByCode.getCourse() != null) {
                    int courseId = courseByCode.getCourse().getId();
                    ApiFactory.addCourse(courseId).subscribe(simpleResult -> {
                        if (simpleResult != null && simpleResult.getResult().equals("success")) {
                            MKToast.showToast(MainActivity.this, "添加成功");
                            addCourseDialog.dismiss();
                            RxBus.getInstance().post(1);
                        } else {
                            MKToast.showToast(MainActivity.this, "添加失败");
                            addCourseDialog.dismiss();
                        }
                    });
                } else {
                    MKToast.showToast(MainActivity.this, "添加失败");
                    addCourseDialog.dismiss();
                }
            });
        });
        addCourseDialog.setNoOnclickListener("取消", () -> {
            addCourseDialog.dismiss();
        });
        addCourseDialog.show();

    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, new ClassFragment());
        transaction.commit();
    }

    private ArrayList<BaseFragment> getFragments() {
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new ClassFragment());
        fragments.add(new SignFragment());
        fragments.add(new MineFragment());
        return fragments;
    }

    /**
     * Called when a tab enters the selected state.
     *
     * @param position The position of the tab that was selected
     */
    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                BaseFragment fragment = fragments.get(position);
//                if (fragment.isAdded()) {
                ft.replace(R.id.layFrame, fragment);
                ft.show(fragment);
//                } else {
//                    ft.add(R.id.layFrame, fragment);
//                }
                ft.commitAllowingStateLoss();
            }
        }
    }

    /**
     * Called when a tab exits the selected state.
     *
     * @param position The position of the tab that was unselected
     */
    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                BaseFragment fragment = fragments.get(position);
                ft.hide(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    /**
     * Called when a tab that is already selected is chosen again by the user. Some applications
     * may use this action to return to the top level of a category.
     *
     * @param position The position of the tab that was reselected.
     */
    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
