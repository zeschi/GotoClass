package com.app.zes.gotoclass.model;

import java.util.List;

/**
 * Created by zes on 17-3-19 23:20
 */
public class CourseAttendance {


    /**
     * id : 1
     * lessonName : 第一课时
     * lessonId : 1
     * time : 2017-03-12 09:27
     */

    private List<AttendancesEntity> attendances;

    public void setAttendances(List<AttendancesEntity> attendances) {
        this.attendances = attendances;
    }

    public List<AttendancesEntity> getAttendances() {
        return attendances;
    }

    public static class AttendancesEntity {
        private int id;
        private String lessonName;
        private int lessonId;
        private String time;

        public void setId(int id) {
            this.id = id;
        }

        public void setLessonName(String lessonName) {
            this.lessonName = lessonName;
        }

        public void setLessonId(int lessonId) {
            this.lessonId = lessonId;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public String getLessonName() {
            return lessonName;
        }

        public int getLessonId() {
            return lessonId;
        }

        public String getTime() {
            return time;
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
