package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.ScoreAdapter;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.view.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by zes on 17-3-18 11:02
 */
public class ClassScoreActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.score_rv)
    RecyclerView scoreRv;
    private List<String> mDatas;

    private ScoreAdapter adapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_class_score;
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
        mDatas = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
        adapter = new ScoreAdapter(this, mDatas, R.layout.item_score);
        scoreRv.setLayoutManager(new GridLayoutManager(this, 3));
        scoreRv.addItemDecoration(new DividerGridItemDecoration(this));
        scoreRv.setAdapter(adapter);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
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
