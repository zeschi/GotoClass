package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.api.ApiFactory;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.view.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-3-29 08:55
 */
public class LeaveProgressActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_leave_progress)
    RecyclerView rvLeaveProgress;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_leave_progress;
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
        ApiFactory.findCourseLeaving(1, 1, 10).subscribe(courseLeaving -> {
            if (courseLeaving != null) {

            }

        });

        rvLeaveProgress.setLayoutManager(new LinearLayoutManager(this));
        rvLeaveProgress.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
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
