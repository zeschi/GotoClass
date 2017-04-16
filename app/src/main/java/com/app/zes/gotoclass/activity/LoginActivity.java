package com.app.zes.gotoclass.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
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
import com.zes.bundle.view.RoundImageViewByXfermode;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zes on 17-3-4 12:44
 */
public class LoginActivity extends BaseActivity {


    @Bind(R.id.login_iv_portrait)
    RoundImageViewByXfermode loginIvPortrait;
    @Bind(R.id.login_btn_login)
    Button loginBtnLogin;
    @Bind(R.id.login_btn_register)
    Button loginBtnRegister;
    @Bind(R.id.et_login_user_name)
    EditText etLoginUserName;
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

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login_btn_login, R.id.login_btn_register})
    protected void clcik(View view) {
        switch (view.getId()) {
            case R.id.login_btn_login:
                login();
                break;
            case R.id.login_btn_register:
                redictToActivity(LoginActivity.this, RegisterActivity.class);
                break;
        }

    }

    private void login() {
//        Log.e("sHA1", sHA1(this));

        User user = new User();
        String userName = etLoginUserName.getText().toString();
        String userPassword = etLoginUserPassword.getText().toString();
        if (TextUtils.isEmpty(userName)) {
            MKToast.showToast(this, "用户名不能为空");
            return;
        } else if (TextUtils.isEmpty(userPassword)) {
            MKToast.showToast(this, "密码不能为空");
            return;
        }
        user.setUsername(userName);
        user.setPassword(userPassword);

//        user.setUsername("13527805610");
//        user.setPassword("lucas");
        ApiFactory.login(user).subscribe(login -> {
            if (login != null && login.getResult().equals("success")) {
                redictToActivity(LoginActivity.this, MainActivity.class);
                Utils.getSpUtils().put("token", login.getToken());
            } else {
                MKToast.showToast(LoginActivity.this, login.getResult());
            }
        }, throwable -> {

        });

    }

    public static String sHA1(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), PackageManager.GET_SIGNATURES);
            byte[] cert = info.signatures[0].toByteArray();
            MessageDigest md = MessageDigest.getInstance("SHA1");
            byte[] publicKey = md.digest(cert);
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < publicKey.length; i++) {
                String appendString = Integer.toHexString(0xFF & publicKey[i])
                        .toUpperCase(Locale.US);
                if (appendString.length() == 1)
                    hexString.append("0");
                hexString.append(appendString);
                hexString.append(":");
            }
            String result = hexString.toString();
            return result.substring(0, result.length() - 1);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
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
