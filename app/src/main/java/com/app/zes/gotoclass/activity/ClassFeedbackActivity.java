package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.adapter.FeedbackAdapter;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.view.RefreshRecyclerView;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.utils.MKToast;
import com.zes.bundle.view.DividerItemDecoration;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zes on 17-3-18 11:03
 */
public class ClassFeedbackActivity extends BaseActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_feedback)
    RefreshRecyclerView rvFeedback;
    @Bind(R.id.btn_feedback_send)
    Button btnFeedbackSend;
    @Bind(R.id.et_feedback_content)
    EditText etFeedbackContent;
    @Bind(R.id.cb_feedback_anonymous)
    CheckBox cbFeedbackAnonymous;
    @Bind(R.id.srl)
    SwipeRefreshLayout swipeRefreshLayout;
    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.ll_send_feedback)
    LinearLayout llSendFeedback;
    private int couresId;
    private FeedbackAdapter feedbackAdapter;
    private int currentPage = 2;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_class_feedback;
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
        rvFeedback.setLayoutManager(new LinearLayoutManager(this));
        rvFeedback.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        rvFeedback.setLoadMoreEnable(true);
        rvFeedback.setFooterResource(R.layout.item_footer);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ApiFactory.findCourseFeedback(couresId, 1, 10).subscribe(courseFeedbacks -> {
            if (courseFeedbacks != null) {
                feedbackAdapter = new FeedbackAdapter(this, courseFeedbacks, R.layout.item_feedback);
                rvFeedback.setAdapter(feedbackAdapter);
            }
        });
        btnFeedbackSend.setOnClickListener(view -> {
            sendFeedBack();
        });
        initListener();
        ivBack.setOnClickListener(view -> finish());

    }

    /**
     * 提交反馈
     */
    private void sendFeedBack() {

        String anonymous = "N";
        if (!cbFeedbackAnonymous.isChecked()) {
            anonymous = "Y";
        }
        String content;
        content = etFeedbackContent.getText().toString();
        if (TextUtils.isEmpty(content)) {
            MKToast.showToast(this, "请输入您的意见");
            return;
        }
        ApiFactory.fillInFeedback(couresId, content, anonymous).subscribe(simpleResult -> {
            if (simpleResult != null) {
                ApiFactory.findCourseFeedback(couresId, 1, 10).subscribe(courseFeedbacks -> {
                    if (courseFeedbacks != null && feedbackAdapter != null) {
                        feedbackAdapter.setData(courseFeedbacks);
                        rvFeedback.notifyData();
                    }
                });
            }
        });
    }

    private void initListener() {
        rvFeedback.setOnLoadMoreListener(() -> ApiFactory.findCourseFeedback(couresId, currentPage, 10).subscribe(courseFeedbacks -> {
            currentPage++;
            if (courseFeedbacks != null) {
                if (courseFeedbacks.size() == 0) {
                    MKToast.showToast(this, "暂无更多数据");
                } else {
                    feedbackAdapter.addAll(courseFeedbacks);
                }
                rvFeedback.notifyData();
            }
        }));
        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(false);
            ApiFactory.findCourseFeedback(couresId, 1, 10).subscribe(courseFeedbacks -> {
                if (courseFeedbacks != null) {
                    feedbackAdapter.clear();
                    currentPage = 2;
                    feedbackAdapter.setData(courseFeedbacks);
                    rvFeedback.notifyData();
                }
            });
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
