package com.app.zes.gotoclass.fragment;

import android.view.View;

import com.app.zes.gotoclass.R;
import com.zes.bundle.fragment.BaseFragment;

import butterknife.OnClick;

/**
 * Created by zes on 17-3-5 22:15
 */
public class MineFragment extends BaseFragment {


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

    @OnClick({R.id.ll_mine_leave_progress, R.id.ll_mine_score, R.id.ll_mine_setting, R.id.ll_mine_user_feedback})
    protected void click(View view) {

        switch (view.getId()) {

            case R.id.ll_mine_leave_progress:

                break;
        }


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
