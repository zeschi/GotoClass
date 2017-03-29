package com.app.zes.gotoclass.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.app.zes.gotoclass.R;
import com.app.zes.gotoclass.api.ApiFactory;
import com.app.zes.gotoclass.model.User;
import com.zes.bundle.activity.BaseActivity;
import com.zes.bundle.utils.Utils;
import com.zes.bundle.view.RoundImageViewByXfermode;

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
        User user = new User();
        user.setUsername("13527805610");
        user.setPassword("lucas");
        ApiFactory.login(user).subscribe(login -> {
            if (login != null) {
                Utils.getSpUtils().put("token", login.getToken());
                redictToActivity(LoginActivity.this, MainActivity.class);

            }
        }, throwable -> {

        });
//        ApiFactory.findUserCourses(1, 6).subscribe(courses -> {
//            if (courses != null) {
//
//            }
//
//        });
//        ApiFactory.findCourseByCode("ZGq49").subscribe(courseByCode -> {
//            if (courseByCode != null) {
//
//            }
//        });

//        ApiFactory.addCourse(3).subscribe(addCourse -> {
//            if (addCourse != null) {
//
//            }
//        });

//        ApiFactory.findCourseLesson(1).subscribe(courseLesson -> {
//            if (courseLesson != null) {
//
//            }
//
//        });

//        ApiFactory.findCourseOutline(2, 1, 5).subscribe(courseOutline -> {
//            if (courseOutline != null) {
//
//            }
//        });
//        ApiFactory.findCourseFeedback(1, 1, 4).subscribe(courseFeedbacks -> {
//            if (courseFeedbacks != null) {
//
//            }
//        });

//        ApiFactory.findCourseAttendance(1, 1, 5).subscribe(courseLesson -> {
//
//            if (courseLesson != null) {
//
//            }
//        });

//        ApiFactory.findCourseLeaving(1,1,5).subscribe(courseLeaving -> {
//            if (courseLeaving != null) {
//
//            }
//        });

//        ApiFactory.findCourseComment(1, 1, 6).subscribe(courseComments -> {
//            if (courseComments != null) {
//
//            }
//
//        });

//        ApiFactory.fillInFeedback(1, "test", "N").subscribe(simpleResult -> {
//            if (simpleResult != null) {
//
//            }
//        });

//        ApiFactory.attendance("00101123").subscribe(simpleResult -> {
//            if (simpleResult != null) {
//
//            }
//        });

//        ApiFactory.askForLeave(1, 2, "test").subscribe(simpleResult -> {
//
//            if (simpleResult != null) {
//
//            }
//
//        });


//        Gson gson = new GsonBuilder().setLenient()
//                .create();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(C.BASE_URL)
//                        //增加返回值为Gson的支持(以实体类返回)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                        //增加返回值为Oservable<T>的支持
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();
//        ApiService apiService = retrofit.create(ApiService.class);
//        apiService.findUserCourses(Utils.getSpUtils().getString("token"), 1, 6).enqueue(new Callback<List<Course>>() {
//            @Override
//            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
//                if (response.body() != null) {
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Course>> call, Throwable t) {
//                t.toString();
//            }
//        });
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
