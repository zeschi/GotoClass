package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.PreviewAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.view.DividerItemDecoration;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-3-18 10:36
 */
public class ClassPreviewActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.preview_rv)
    RecyclerView previewRv;

    private PreviewAdapter adapter;

    private List<String> mDatas;

    private int couresId;

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

        couresId = getIntent().getIntExtra("courseId", 0);

//        mDatas = new ArrayList<>();
//        for (int i = 'A'; i < 'z'; i++) {
//            mDatas.add("" + (char) i);
//        }
        ApiFactory.findCourseOutline(couresId, 1, 10).subscribe(courseOutlines -> {
            if (courseOutlines != null) {
                adapter = new PreviewAdapter(this, courseOutlines, R.layout.item_prieview);
                previewRv.setAdapter(adapter);
            }
        });

        previewRv.setLayoutManager(new LinearLayoutManager(this));
        previewRv.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
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