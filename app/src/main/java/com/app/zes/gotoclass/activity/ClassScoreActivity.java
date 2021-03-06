package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.ScoreAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.model.GPAReport;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.view.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-3-18 11:02
 */
public class ClassScoreActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.score_rv)
    RecyclerView scoreRv;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private List<String> mDatas;

    private ScoreAdapter adapter;
    private int couresId;

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
//        for (int i = 'A'; i < 'z'; i++) {
//            mDatas.add("" + (char) i);
//        }
//        ApiFactory.getGPAReport()
        couresId = getIntent().getIntExtra("courseId", 0);
        ApiFactory.getGPAReport(couresId).subscribe(gpaReport -> {
            if (gpaReport != null) {
                List<GPAReport.DetailEntity> detail = gpaReport.getDetail();
                if (detail != null) {
                    mDatas.add("课时");
                    mDatas.add("考勤");
                    mDatas.add("互动");
                    for (int i = 0; i < detail.size(); i++) {
                        mDatas.add(detail.get(i).getLessonName());
                        mDatas.add(detail.get(i).getAttendance());
                        mDatas.add(detail.get(i).getInteract() + "");
                    }
                    adapter = new ScoreAdapter(this, mDatas, R.layout.item_score);
                    scoreRv.setLayoutManager(new GridLayoutManager(this, 3));
                    scoreRv.addItemDecoration(new DividerGridItemDecoration(this));
                    scoreRv.setAdapter(adapter);
                }
            }
        }, throwable -> {
            throwable.toString();
        });
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
