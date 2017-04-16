package com.app.zes.gotoclass.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.activity.GpaReportActivity;
import com.zes.bundle.fragment.BaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zes on 17-3-5 22:15
 */
public class MineFragment extends BaseFragment {


    @Bind(R.id.tv_mine_user_name)
    TextView tvMineUserName;
    @Bind(R.id.ll_mine_score)
    LinearLayout llMineScore;
    @Bind(R.id.ll_mine_user_feedback)
    LinearLayout llMineUserFeedback;
    @Bind(R.id.ll_mine_setting)
    LinearLayout llMineSetting;

    @Override
    protected int getContentViewId() {
        return R.layout.fragement_mine;
    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {


    }

    @OnClick({R.id.ll_mine_score, R.id.ll_mine_setting, R.id.ll_mine_user_feedback})
    protected void click(View view) {

        switch (view.getId()) {
            case R.id.ll_mine_score:
                redirectActivity(getActivity(), GpaReportActivity.class);
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
