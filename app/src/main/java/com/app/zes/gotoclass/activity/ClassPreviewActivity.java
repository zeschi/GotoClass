package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.PreviewAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.view.RefreshRecyclerView;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.utils.MKToast;
import com.zes.bundle.view.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-3-18 10:36
 */
public class ClassPreviewActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.preview_rv)
    RefreshRecyclerView previewRv;
    @Bind(R.id.srl)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    private PreviewAdapter adapter;


    private int couresId;
    private int currentPage = 2;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_class_preview;
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
        previewRv.setLayoutManager(new LinearLayoutManager(this));
        previewRv.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        previewRv.setLoadMoreEnable(true);
        previewRv.setFooterResource(R.layout.item_footer);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ApiFactory.findCourseOutline(couresId, 1, 10).subscribe(courseOutlines -> {
            if (courseOutlines != null) {
                adapter = new PreviewAdapter(this, courseOutlines, R.layout.item_prieview);
                previewRv.setAdapter(adapter);
            }
        });
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
        previewRv.setOnLoadMoreListener(() -> ApiFactory.findCourseOutline(couresId, currentPage, 10).subscribe(courseOutlines -> {
            currentPage++;
            if (courseOutlines != null) {
                if (courseOutlines.size() == 0) {
                    MKToast.showToast(this, "暂无更多数据");
                } else {
                    adapter.addAll(courseOutlines);
                }
                previewRv.notifyData();
            }
        }));
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            ApiFactory.findCourseOutline(couresId, 1, 10).subscribe(courseOutlines -> {
                if (courseOutlines != null) {
                    adapter.clear();
                    currentPage = 2;
                    adapter.setData(courseOutlines);
                    previewRv.notifyData();
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
