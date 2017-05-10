package com.app.zes.gotoclass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.model.User;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.utils.MKToast;
import com.zes.bundle.utils.Utils;
import com.zes.bundle.view.RoundImageViewByXfermode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by zes on 17-3-4 12:44
 */
public class LoginActivity extends BaseActivity {

    @Nullable
    @Bind(R.id.login_iv_portrait)
    RoundImageViewByXfermode loginIvPortrait;
    @Nullable
    @Bind(R.id.login_btn_login)
    Button loginBtnLogin;
    @Nullable
    @Bind(R.id.login_btn_register)
    Button loginBtnRegister;
    @Nullable
    @Bind(R.id.et_login_user_name)
    EditText etLoginUserName;
    @Nullable
    @Bind(R.id.et_login_user_password)
    EditText etLoginUserPassword;

    @Override
    protected int getContentViewId() {

        return R.layout.activity_login;
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
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tokenTime = Utils.getSpUtils().getString("tokenTime");
        if (TextUtils.isEmpty(tokenTime)) {
            return;
        } else {
            try {
                Date tokenDate = df.parse(tokenTime);
                Date curDate = new Date(System.currentTimeMillis());
                long days = (tokenDate.getTime() - curDate.getTime()) / (1000 * 60 * 60 * 24);
                Log.e("day", days + "");
                if (!TextUtils.isEmpty(Utils.getSpUtils().getString("token")) && days < 7) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            } catch (ParseException e) {
                e.printStackTrace();
                return;
            }
        }


    }

    @OnClick({R.id.login_btn_login, R.id.login_btn_register})
    protected void clcik(View view) {
        switch (view.getId()) {
            case R.id.login_btn_login:
                break;
            case R.id.login_btn_register:

                break;
        }

    }

    private void login() {
//        Log.e("sHA1", sHA1(this));
//
        User user = new User();
//        String userName = etLoginUserName.getText().toString();
//        String userPassword = etLoginUserPassword.getText().toString();
//        if (TextUtils.isEmpty(userName)) {
//            MKToast.showToast(this, "用户名不能为空");
//            return;
//        } else if (TextUtils.isEmpty(userPassword)) {
//            MKToast.showToast(this, "密码不能为空");
//            return;
//        }
//        user.setUsername(userName);
//        user.setPassword(userPassword);

        user.setUsername("13527805610");
        user.setPassword("lucas");
        ApiFactory.login(user).subscribe(login -> {
            if (login != null && login.getResult().equals("success")) {
                Utils.getSpUtils().put("token", login.getToken());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date curDate = new Date(System.currentTimeMillis());
                String tokenTime = df.format(curDate);
                Utils.getSpUtils().put("tokenTime", tokenTime);

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                MKToast.showToast(LoginActivity.this, login.getResult());
            }
        }, throwable -> {

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
