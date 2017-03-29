package com.app.zes.gotoclass.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.activity.ClassFeedbackActivity;
import com.app.zes.gotoclass.activity.ClassPreviewActivity;
import com.app.zes.gotoclass.activity.ClassPublishActivity;
import com.app.zes.gotoclass.activity.ClassScoreActivity;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.model.CourseLesson;
import com.zes.bundle.fragment.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zes on 17-3-18 09:45
 */
public class DetailFragment extends BaseFragment {


    @Bind(R.id.tv_detail_class_preview)
    TextView tvDetailClassPreview;
    @Bind(R.id.tv_detail_class_publish)
    TextView tvDetailClassPublish;
    @Bind(R.id.tv_detail_class_score)
    TextView tvDetailClassScore;
    @Bind(R.id.tv_detail_class_feedback)
    TextView tvDetailClassFeedback;
    @Bind(R.id.tv_detail_class_attendancePercent)
    TextView tvDetailClassAttendancePercent;
    @Bind(R.id.tv_detail_class_interactPercent)
    TextView tvDetailClassInteractPercent;

    private int lessonId;
    private int courseId;

    public static DetailFragment newInstance(int lessonId, int courseId) {
        DetailFragment f = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("lessonId", lessonId);
        args.putInt("courseId", courseId);
        f.setArguments(args);
        return f;
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_detail;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        lessonId = getArguments().getInt("lessonId");
        courseId = getArguments().getInt("courseId");
        ApiFactory.findCourseLesson(lessonId).subscribe(courseLesson -> {
            if (courseLesson != null) {
                CourseLesson.LessonDetailEntity lessonDetail = courseLesson.getLessonDetail();
                if (lessonDetail != null) {
                    if (lessonDetail.getOutline() != null && lessonDetail.getOutline().getOutlines() != null) {
                        StringBuffer sb = new StringBuffer();
                        for (int i = 0; i < lessonDetail.getOutline().getOutlines().size(); i++) {
                            sb.append(lessonDetail.getOutline().getOutlines().get(i).getSequence() + ": " + lessonDetail.getOutline().getOutlines().get(i).getContent() + "\n");
                        }
                        tvDetailClassPreview.setText(sb.toString());
                    }
                    String comment = lessonDetail.getComment().getContent();
                    if (!TextUtils.isEmpty(comment)) {
                        tvDetailClassPublish.setText(comment);
                    }
                    CourseLesson.LessonDetailEntity.GpaEntity gpa = lessonDetail.getGpa();
                    if (gpa != null) {
                        String score = gpa.getTotalScore();
                        if (!TextUtils.isEmpty(score)) {
                            tvDetailClassScore.setText("目前得分:" + score + "分");
                        }
                        String attendancePercent = gpa.getAttendancePrecent();
                        if (!TextUtils.isEmpty(attendancePercent)) {
                            tvDetailClassAttendancePercent.setText("考勤签到率:" + attendancePercent + "%");
                        }
                        String interactPercent = gpa.getInteractPrecent();
                        if (!TextUtils.isEmpty(interactPercent)) {
                            tvDetailClassInteractPercent.setText("互动完成率:" + attendancePercent + "%");
                        }
                    }
                }
            }
        });

    }

    @OnClick({R.id.tv_detail_class_preview, R.id.tv_detail_class_publish, R.id.tv_detail_class_score, R.id.tv_detail_class_feedback})
    protected void clcik(View view) {
        switch (view.getId()) {
            case R.id.tv_detail_class_preview:
                Intent intent = new Intent(getActivity(), ClassPreviewActivity.class);
                intent.putExtra("courseId", courseId);
                startActivity(intent);
//                redirectActivity();
                break;
            case R.id.tv_detail_class_publish:
                Intent commentIntent = new Intent(getActivity(), ClassPublishActivity.class);
                commentIntent.putExtra("courseId", courseId);
                startActivity(commentIntent);
                break;
            case R.id.tv_detail_class_score:
                redirectActivity(getActivity(), ClassScoreActivity.class);
                break;
            case R.id.tv_detail_class_feedback:
                redirectActivity(getActivity(), ClassFeedbackActivity.class);
                break;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
