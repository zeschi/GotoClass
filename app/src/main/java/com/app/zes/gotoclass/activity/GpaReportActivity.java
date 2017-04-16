package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.ScoreAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.model.CourseGPAReport;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.view.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-4-15 11:10
 */
public class GpaReportActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.gpa_report_rv)
    RecyclerView gpaReportRv;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    private List<String> mDatas;
    private ScoreAdapter adapter;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_gpa_report;
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

        ApiFactory.getCourseGPAReport().subscribe(courseGPAReport -> {
            if (courseGPAReport != null) {
                List<CourseGPAReport.ScoreEntity> scoreEntities = courseGPAReport.getScore();
                if (scoreEntities != null) {
                    mDatas.add("课程名称");
                    mDatas.add("考勤得分");
                    mDatas.add("互动得分");
                    mDatas.add("总分");
                    for (int i = 0; i < scoreEntities.size(); i++) {
                        mDatas.add(scoreEntities.get(i).getCourseName());
                        mDatas.add(scoreEntities.get(i).getAttendanceScore() + "");
                        mDatas.add(scoreEntities.get(i).getInteractScore() + "");
                        mDatas.add(scoreEntities.get(i).getTotalScore() + "");
                    }
                    adapter = new ScoreAdapter(this, mDatas, R.layout.item_score);
                    gpaReportRv.setLayoutManager(new GridLayoutManager(this, 4));
                    gpaReportRv.addItemDecoration(new DividerGridItemDecoration(this));
                    gpaReportRv.setAdapter(adapter);

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
