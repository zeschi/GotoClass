package com.app.zes.gotoclass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.DetailFragmentPagerAdapter;
import com.zes.bundle.activity.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-3-18 09:34
 */

public class ClassDetailActivity extends BaseActivity {
    @Bind(R.id.tb_class_detail)
    TabLayout tbClassDetail;
    @Bind(R.id.vp_class_detail)
    ViewPager vpClassDetail;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_detail_class_ask_for_leaving)
    TextView tvDetailClassAskForLeaving;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    private DetailFragmentPagerAdapter pagerAdapter;

    private int lessonId;
    private int courseId;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_class_detail;
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

        lessonId = getIntent().getIntExtra("lessonId", 0);
        courseId = getIntent().getIntExtra("courseId", 0);
        pagerAdapter = new DetailFragmentPagerAdapter(getSupportFragmentManager(), this, lessonId, courseId);
        vpClassDetail.setAdapter(pagerAdapter);
        tbClassDetail.setupWithViewPager(vpClassDetail);
        tbClassDetail.setTabMode(TabLayout.MODE_FIXED);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, AskLeavingActivity.class);
        intent.putExtra("courseId", courseId);
        intent.putExtra("lessonId", lessonId);
        tvDetailClassAskForLeaving.setOnClickListener(view -> {
            startActivity(intent);
        });
        ivBack.setOnClickListener(view -> finish());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
/**
 * 　　　　　　　　┏┓　　　┏┓
 * 　　　　　　　┏┛┻━━━┛┻┓
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃
 * 　　　　　　　┃　＞　　　＜　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃...　⌒　...　┃
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃   神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┗━━━┓
 * 　　　　　　　　　┃　　　　　　　┣┓
 * 　　　　　　　　　┃　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛
 */
