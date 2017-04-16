package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.LeaveProgressAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.view.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-3-30 22:41
 */
public class AskLeavingActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_ask_leaving_text)
    TextView tvAskLeavingText;
    @Bind(R.id.sp_ask_leaving_reason)
    Spinner spAskLeavingReason;
    @Bind(R.id.et_ask_leaving_tip)
    EditText etAskLeavingTip;
    @Bind(R.id.ll_ask_leaving)
    RelativeLayout llAskLeaving;
    @Bind(R.id.rv_ask_leaving)
    RecyclerView rvAskLeaving;
    @Bind(R.id.btn_ask_leaving)
    Button btnAskLeaving;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    private LeaveProgressAdapter leaveProgressAdapter;

    private int couresId;
    private int lessonId;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_ask_leaving;
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
        lessonId = getIntent().getIntExtra("lessonId", 0);
        ApiFactory.findCourseLeaving(couresId, 1, 10).subscribe(courseLeaving -> {
            if (courseLeaving != null && courseLeaving.getLeaves() != null) {
                leaveProgressAdapter = new LeaveProgressAdapter(this, courseLeaving.getLeaves(), R.layout.item_leave_progress);
                rvAskLeaving.setAdapter(leaveProgressAdapter);
            }

        });
        rvAskLeaving.setLayoutManager(new LinearLayoutManager(this));
        rvAskLeaving.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        btnAskLeaving.setOnClickListener(view -> askForLeaving());
        ivBack.setOnClickListener(view -> finish());

    }

    private void askForLeaving() {
        String reason = etAskLeavingTip.getText().toString();
        ApiFactory.askForLeave(couresId, lessonId, reason).subscribe(simpleResult -> {
            if (simpleResult != null) {
                ApiFactory.findCourseLeaving(couresId, 1, 10).subscribe(courseLeaving -> {
                    if (courseLeaving != null && courseLeaving.getLeaves() != null) {
                        if (leaveProgressAdapter != null) {
                            leaveProgressAdapter.setData(courseLeaving.getLeaves());
                        }
                    }
                });
            }
        });
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
