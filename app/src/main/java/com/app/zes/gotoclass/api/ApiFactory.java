package com.app.zes.gotoclass.api;

import com.app.zes.gotoclass.model.Course;
import com.app.zes.gotoclass.model.CourseAttendance;
import com.app.zes.gotoclass.model.CourseByCode;
import com.app.zes.gotoclass.model.CourseComment;
import com.app.zes.gotoclass.model.CourseFeedback;
import com.app.zes.gotoclass.model.CourseLeaving;
import com.app.zes.gotoclass.model.CourseLesson;
import com.app.zes.gotoclass.model.CourseOutline;
import com.app.zes.gotoclass.model.Login;
import com.app.zes.gotoclass.model.SimpleResult;
import com.app.zes.gotoclass.model.User;
import com.app.zes.gotoclass.utils.RxSchedulers;
import com.zes.bundle.utils.GsonUtil;
import com.zes.bundle.utils.Utils;

import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observable;

/**
 * Created by zes on 17-3-19 11:04
 */
public class ApiFactory {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public static Observable<Login> login(User user) {
        return Api.getInstance().service.login(getBody(user)).compose(RxSchedulers.io_main());
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    public static Observable<Login> register(User user) {
        return Api.getInstance().service.register(getBody(user)).compose(RxSchedulers.io_main());
    }

    /**
     * 查询用户所有的课程
     *
     * @param page
     * @param pageSize
     * @return
     */
    public static Observable<List<Course>> findUserCourses(int page, int pageSize) {
        return Api.getInstance().service.findUserCourses(Utils.getSpUtils().getString("token"), page, pageSize).compose(RxSchedulers.io_main());
    }

    /**
     * 根据课程码查找课程
     *
     * @param coursecode
     * @return
     */
    public static Observable<CourseByCode> findCourseByCode(String coursecode) {
        return Api.getInstance().service.findCourseByCode(Utils.getSpUtils().getString("token"), coursecode).compose(RxSchedulers.io_main());
    }

    /**
     * 根据查询得到的课程id添加课程
     *
     * @param courseId
     * @return
     */
    public static Observable<SimpleResult> addCourse(int courseId) {
        return Api.getInstance().service.addCourse(Utils.getSpUtils().getString("token"), courseId).compose(RxSchedulers.io_main());
    }

    /**
     * 查看课堂小节
     *
     * @param lessonId
     * @return
     */
    public static Observable<CourseLesson> findCourseLesson(int lessonId) {
        return Api.getInstance().service.findCourseLesson(Utils.getSpUtils().getString("token"), lessonId).compose(RxSchedulers.io_main());
    }

    /**
     * 查看课程预备(大纲)
     *
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    public static Observable<List<CourseOutline>> findCourseOutline(int courseId, int page, int pageSize) {
        return Api.getInstance().service.findCourseOutline(Utils.getSpUtils().getString("token"), courseId, page, pageSize).compose(RxSchedulers.io_main());
    }

    /**
     * 查看课堂公告
     *
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    public static Observable<List<CourseComment>> findCourseComment(int courseId, int page, int pageSize) {
        return Api.getInstance().service.findCourseComment(Utils.getSpUtils().getString("token"), courseId, page, pageSize).compose(RxSchedulers.io_main());
    }

    /**
     * 查看反馈
     *
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    public static Observable<List<CourseFeedback>> findCourseFeedback(int courseId, int page, int pageSize) {
        return Api.getInstance().service.findCourseFeedback(Utils.getSpUtils().getString("token"), courseId, page, pageSize).compose(RxSchedulers.io_main());
    }

    /**
     * 查看课程签到
     *
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    public static Observable<CourseAttendance> findCourseAttendance(int courseId, int page, int pageSize) {
        return Api.getInstance().service.findCourseAttendance(Utils.getSpUtils().getString("token"), courseId, page, pageSize).compose(RxSchedulers.io_main());
    }

    /**
     * 查看请假
     *
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    public static Observable<CourseLeaving> findCourseLeaving(int courseId, int page, int pageSize) {
        return Api.getInstance().service.findCourseLeaving(Utils.getSpUtils().getString("token"), courseId, page, pageSize).compose(RxSchedulers.io_main());
    }

    /**
     * 填写反馈
     *
     * @param courseId
     * @param content
     * @param anonymous
     * @return
     */
    public static Observable<SimpleResult> fillInFeedback(int courseId, String content, String anonymous) {
        return Api.getInstance().service.fillInFeedback(Utils.getSpUtils().getString("token"), courseId, content, anonymous).compose(RxSchedulers.io_main());
    }

    /**
     * 签到
     *
     * @param code
     * @return
     */
    public static Observable<SimpleResult> attendance(String code) {
        return Api.getInstance().service.attendance(Utils.getSpUtils().getString("token"), code).compose(RxSchedulers.io_main());
    }

    /**
     * 请假
     *
     * @param courseId
     * @param lessonId
     * @param reason
     * @return
     */
    public static Observable<SimpleResult> askForLeave(int courseId, int lessonId, String reason) {
        return Api.getInstance().service.askForLeave(Utils.getSpUtils().getString("token"), courseId, lessonId, reason).compose(RxSchedulers.io_main());
    }

    private static RequestBody getBody(Object t) {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), GsonUtil.getGson().toJson(t));
        return body;
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
