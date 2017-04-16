package com.app.zes.gotoclass.api;

import com.app.zes.gotoclass.model.Course;
import com.app.zes.gotoclass.model.CourseAttendance;
import com.app.zes.gotoclass.model.CourseByCode;
import com.app.zes.gotoclass.model.CourseComment;
import com.app.zes.gotoclass.model.CourseFeedback;
import com.app.zes.gotoclass.model.CourseGPAReport;
import com.app.zes.gotoclass.model.CourseLeaving;
import com.app.zes.gotoclass.model.CourseLesson;
import com.app.zes.gotoclass.model.CourseOutline;
import com.app.zes.gotoclass.model.GPAReport;
import com.app.zes.gotoclass.model.Login;
import com.app.zes.gotoclass.model.Phone;
import com.app.zes.gotoclass.model.SimpleResult;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zes on 17-3-18 21:28
 */
public interface ApiService {

//    @POST("login")
//    Call<Login> login(@Body RequestBody requestBody);

    @GET("get")
    Call<Phone> phone(@Query("phone") String phone, @Query("key") String key);

    /**
     * 登录
     *
     * @param requestBody
     * @return
     */
    @POST("login")
    Observable<Login> login(@Body RequestBody requestBody);

    /**
     * 注册
     *
     * @param requestBody
     * @return
     */
    @POST("register")
    Observable<Login> register(@Body RequestBody requestBody);

    /**
     * 查询用户所有的课程
     *
     * @param token
     * @param page
     * @param pageSize
     * @return
     */
    @GET("findUserCourses")
    Observable<List<Course>> findUserCourses(@Header("Authorization") String token, @Query("page") int page, @Query("pageSize") int pageSize);

    /**
     * 根据课程码查找课程
     *
     * @param token
     * @param coursecode
     * @return
     */
    @GET("findCourseByCode")
    Observable<CourseByCode> findCourseByCode(@Header("Authorization") String token, @Query("coursecode") String coursecode);

    /**
     * 根据查询得到的课程id添加课程
     *
     * @param token
     * @param courseId
     * @return
     */
    @GET("addCourse")
    Observable<SimpleResult> addCourse(@Header("Authorization") String token, @Query("courseId") int courseId);

    /**
     * 查看课堂小节
     *
     * @param token
     * @param lessonId
     * @return
     */
    @GET("findCourseLesson")
    Observable<CourseLesson> findCourseLesson(@Header("Authorization") String token, @Query("lessonId") int lessonId);

    /**
     * 查看课程预备(大纲)
     *
     * @param token
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    @GET("findCourseOutline")
    Observable<List<CourseOutline>> findCourseOutline(@Header("Authorization") String token, @Query("courseId") int courseId, @Query("page") int page, @Query("pageSize") int pageSize);

    /**
     * 查看课堂公告
     *
     * @param token
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    @GET("findCourseComment")
    Observable<List<CourseComment>> findCourseComment(@Header("Authorization") String token, @Query("courseId") int courseId, @Query("page") int page, @Query("pageSize") int pageSize);

    /**
     * 查看反馈
     *
     * @param token
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    @GET("findCourseFeedback")
    Observable<List<CourseFeedback>> findCourseFeedback(@Header("Authorization") String token, @Query("courseId") int courseId, @Query("page") int page, @Query("pageSize") int pageSize);

    /**
     * 查看课程签到
     *
     * @param token
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    @GET("findCourseAttendance")
    Observable<CourseAttendance> findCourseAttendance(@Header("Authorization") String token, @Query("courseId") int courseId, @Query("page") int page, @Query("pageSize") int pageSize);

    /**
     * 查看请假
     *
     * @param token
     * @param courseId
     * @param page
     * @param pageSize
     * @return
     */
    @GET("findCourseLeaving")
    Observable<CourseLeaving> findCourseLeaving(@Header("Authorization") String token, @Query("courseId") int courseId, @Query("page") int page, @Query("pageSize") int pageSize);


    /**
     * 填写反馈
     *
     * @param token
     * @param courseId
     * @param content
     * @param anonymous
     * @return
     */
    @GET("fillInFeedback")
    Observable<SimpleResult> fillInFeedback(@Header("Authorization") String token, @Query("courseId") int courseId, @Query("content") String content, @Query("anonymous") String anonymous);


    /**
     * 签到
     *
     * @param token
     * @param code
     * @return
     */
    @GET("attendance")
    Observable<SimpleResult> attendance(@Header("Authorization") String token, @Query("code") String code, @Query("longitude") String longitude, @Query("latitude") String latitude);

    /**
     * 请假
     *
     * @param token
     * @param courseId
     * @param lessonId
     * @param reason
     * @return
     */
    @GET("askForLeave")
    Observable<SimpleResult> askForLeave(@Header("Authorization") String token, @Query("courseId") int courseId, @Query("lessonId") int lessonId, @Query("reason") String reason);

    /**
     * 查看平时分
     *
     * @param token
     * @param courseId
     * @return
     */
    @GET("student/getGPAReport")
    Observable<GPAReport> getGPAReport(@Header("Authorization") String token, @Query("courseId") int courseId);

    /**
     * 查看平时成绩总览
     *
     * @param token
     * @return
     */
    @GET("student/getCourseGPAReport")
    Observable<CourseGPAReport> getCourseGPAReport(@Header("Authorization") String token);


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
