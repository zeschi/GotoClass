package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.view.View;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.model.User;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.utils.Utils;

import butterknife.OnClick;

/**
 * Created by zes on 17-3-4 13:16
 */
public class RegisterActivity extends BaseActivity {
    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
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

    }

    @OnClick({R.id.btn_register})
    protected void click(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                register();
                break;
        }

    }

    private void register() {
        User user = new User();
        user.setUsername("13570432086");
        user.setPassword("12345");
        user.setPhone("13570432086");
        ApiFactory.register(user).subscribe(register -> {
            if (register != null && register.getResult().equals("success")) {
                Utils.getSpUtils().put("token", register.getResult());
            }
        }, throwable -> {
            throwable.toString();
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
