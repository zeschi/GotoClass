package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.PublishAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.view.RefreshRecyclerView;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.utils.MKToast;
import com.zes.bundle.view.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-3-18 11:02
 */
public class ClassPublishActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_publish)
    RefreshRecyclerView rvPublish;
    @Bind(R.id.srl)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    private PublishAdapter adapter;

    private int couresId;
    private int currentPage = 2;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_class_publish;
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
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_green_light);

        couresId = getIntent().getIntExtra("courseId", 0);
        rvPublish.setLayoutManager(new LinearLayoutManager(this));
        rvPublish.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        rvPublish.setLoadMoreEnable(true);
        rvPublish.setFooterResource(R.layout.item_footer);
        ApiFactory.findCourseComment(couresId, 1, 10).subscribe(courseComments -> {
            if (courseComments != null) {
                adapter = new PublishAdapter(this, courseComments, R.layout.item_publish);
                rvPublish.setAdapter(adapter);
            }

        });
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        initListener();
        ivBack.setOnClickListener(view -> finish());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void initListener() {
        rvPublish.setOnLoadMoreListener(() -> ApiFactory.findCourseComment(couresId, currentPage, 5).subscribe(courseComments -> {
            currentPage++;
            if (courseComments != null) {
                if (courseComments.size() == 0) {
                    MKToast.showToast(this, "暂无更多数据");
                } else {
                    adapter.addAll(courseComments);
                }
                rvPublish.notifyData();
            }
        }));
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            ApiFactory.findCourseComment(couresId, 1, 5).subscribe(courseComments -> {
                if (courseComments != null) {
                    adapter.clear();
                    currentPage = 2;
                    adapter.setData(courseComments);
                    rvPublish.notifyData();
                }
            });
        });
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
