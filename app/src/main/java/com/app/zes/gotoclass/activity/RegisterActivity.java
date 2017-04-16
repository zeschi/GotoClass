package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.model.User;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.utils.MKToast;
import com.zes.bundle.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zes on 17-3-4 13:16
 */
public class RegisterActivity extends BaseActivity {
    @Bind(R.id.et_register_user_name)
    EditText etRegisterUserName;
    @Bind(R.id.et_register_password)
    EditText etRegisterPassword;
    @Bind(R.id.et_register_phone)
    EditText etRegisterPhone;
    @Bind(R.id.et_register_no)
    EditText etRegisterNo;
    @Bind(R.id.btn_register)
    Button btnRegister;

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
        String userName = etRegisterUserName.getText().toString();
        String password = etRegisterPassword.getText().toString();
        String phone = etRegisterPhone.getText().toString();
        String no = etRegisterNo.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            MKToast.showToast(this, "请输入用户名");
            return;
        } else if (TextUtils.isEmpty(password)) {
            MKToast.showToast(this, "请输入密码");
            return;
        } else if (TextUtils.isEmpty(phone)) {
            MKToast.showToast(this, "请输入手机号");
            return;
        } else if (TextUtils.isEmpty(no)) {
            MKToast.showToast(this, "请输入学号");
            return;
        }
        user.setUsername(userName);
        user.setPassword(password);
        user.setPhone(phone);
        user.setNo(no);
        ApiFactory.register(user).subscribe(register -> {
            if (register != null && register.getResult().equals("success")) {
                Utils.getSpUtils().put("token", register.getResult());
                MKToast.showToast(RegisterActivity.this, "注册成功");
//                redictToActivity(RegisterActivity.this, MainActivity.class);

            }
        }, throwable -> {
            throwable.toString();
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
