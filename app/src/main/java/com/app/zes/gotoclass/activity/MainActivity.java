package com.app.zes.gotoclass.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.fragment.ClassFragment;
import com.app.zes.gotoclass.fragment.MineFragment;
import com.app.zes.gotoclass.fragment.SignFragment;
import com.app.zes.gotoclass.model.User;
import com.app.zes.gotoclass.utils.RxBus;
import com.app.zes.gotoclass.view.AddCourseDialog;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.fragment.BaseFragment;
import com.zes.bundle.utils.MKToast;
import com.zes.bundle.utils.Utils;
import com.zes.bundle.view.RoundImageViewByXfermode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @Nullable
    @Bind(R.id.layFrame)
    FrameLayout layFrame;
    @Nullable
    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;
    @Nullable
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    //-----------login---------
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

    private ArrayList<BaseFragment> fragments;

    private boolean isLogin = false;

    @Override
    protected int getContentViewId() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tokenTime = Utils.getSpUtils().getString("tokenTime");
        if (TextUtils.isEmpty(tokenTime)) {
            return R.layout.activity_login;
        } else {
            try {
                Date tokenDate = df.parse(tokenTime);
                Date curDate = new Date(System.currentTimeMillis());
                long days = (tokenDate.getTime() - curDate.getTime()) / (1000 * 60 * 60 * 24);
                Log.e("day", days + "");
                if (!TextUtils.isEmpty(Utils.getSpUtils().getString("token")) && days < 7) {
                    isLogin = true;
                    return R.layout.activity_main;
                } else {
                    return R.layout.activity_login;

                }
            } catch (ParseException e) {
                e.printStackTrace();
                return R.layout.activity_login;
            }
        }
    }

    /**
     * 初始化数据
     *
     * @param savedInstanceState
     */
    @Override
    protected void initData(Bundle savedInstanceState) {

    }

//    @OnClick({R.id.login_btn_login, R.id.login_btn_register})
//    protected void clcik(View view) {
//        switch (view.getId()) {
//            case R.id.login_btn_login:
//                login();
//                break;
//            case R.id.login_btn_register:
//                redictToActivity(MainActivity.this, RegisterActivity.class);
//                break;
//        }
//
//    }

    private void login() {
//        Log.e("sHA1", sHA1(this));
//
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
                Utils.getSpUtils().put("token", login.getToken());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date curDate = new Date(System.currentTimeMillis());
                String tokenTime = df.format(curDate);
                Utils.getSpUtils().put("tokenTime", tokenTime);
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            } else {
                MKToast.showToast(MainActivity.this, login.getResult());
            }
        }, throwable -> {

        });

    }

    /**
     * 初始化视图
     */
    @Override
    protected void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if (isLogin) {
            bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
            bottomNavigationBar
                    .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC
                    );
            bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_class, "上课").setActiveColorResource(R.color.colorPrimary))
                    .addItem(new BottomNavigationItem(R.drawable.ic_sign, "签到").setActiveColorResource(R.color.colorPrimary))
                    .addItem(new BottomNavigationItem(R.drawable.ic_user, "我的").setActiveColorResource(R.color.colorPrimary))
                    .setFirstSelectedPosition(0)
                    .initialise();

            fragments = getFragments();
            setDefaultFragment();
            bottomNavigationBar.setTabSelectedListener(this);
        } else {
            loginBtnLogin.setOnClickListener(view -> login());
            loginBtnRegister.setOnClickListener(view -> redictToActivity(MainActivity.this, RegisterActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.getItem(0).setOnMenuItemClickListener(menuItem -> {
            addCourse();
            return false;
        });

        return true;
    }

    /**
     * 添加课程
     */
    private void addCourse() {
        AddCourseDialog addCourseDialog = new AddCourseDialog(MainActivity.this);
//        addCourseDialog.setTitle("提示");
//        addCourseDialog.setMessage("确定退出应用?");
        addCourseDialog.setYesOnclickListener("确定", () -> {
//            Toast.makeText(MainActivity.this, "点击了--确定--按钮", Toast.LENGTH_LONG).show();
            String courseCode = addCourseDialog.getMessage();
            if (TextUtils.isEmpty(courseCode)) {
                MKToast.showToast(MainActivity.this, "邀请码不能为空");
                return;
            }
            ApiFactory.findCourseByCode(courseCode).subscribe(courseByCode -> {
//                RxBus.getInstance().post(1);
                if (courseByCode != null && courseByCode.getCourse() != null) {
                    int courseId = courseByCode.getCourse().getId();
                    ApiFactory.addCourse(courseId).subscribe(simpleResult -> {
                        if (simpleResult != null && simpleResult.getResult().equals("success")) {
                            MKToast.showToast(MainActivity.this, "添加成功");
                            addCourseDialog.dismiss();
                            RxBus.getInstance().post(1);
                        } else {
                            MKToast.showToast(MainActivity.this, "添加失败");
                            addCourseDialog.dismiss();
                        }
                    });
                } else {
                    MKToast.showToast(MainActivity.this, "添加失败");
                    addCourseDialog.dismiss();
                }
            });
        });
        addCourseDialog.setNoOnclickListener("取消", () -> {
            addCourseDialog.dismiss();
        });
        addCourseDialog.show();

    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.layFrame, new ClassFragment());
        transaction.commit();
    }

    private ArrayList<BaseFragment> getFragments() {
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new ClassFragment());
        fragments.add(new SignFragment());
        fragments.add(new MineFragment());
        return fragments;
    }

    /**
     * Called when a tab enters the selected state.
     *
     * @param position The position of the tab that was selected
     */
    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                BaseFragment fragment = fragments.get(position);
//                if (fragment.isAdded()) {
                ft.replace(R.id.layFrame, fragment);
                ft.show(fragment);
//                } else {
//                    ft.add(R.id.layFrame, fragment);
//                }
                ft.commitAllowingStateLoss();
            }
        }
    }

    /**
     * Called when a tab exits the selected state.
     *
     * @param position The position of the tab that was unselected
     */
    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                BaseFragment fragment = fragments.get(position);
                ft.hide(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    /**
     * Called when a tab that is already selected is chosen again by the user. Some applications
     * may use this action to return to the top level of a category.
     *
     * @param position The position of the tab that was reselected.
     */
    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        System.exit(0);

        long secondTime = System.currentTimeMillis();
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (secondTime - firstTime < 2000) {
                finish();
            } else {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
