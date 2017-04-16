package com.app.zes.gotoclass.model;

import java.util.List;

/**
 * Created by zes on 17-4-13 18:00
 */
public class GPAReport {

    /**
     * interactCount : 4
     * attendanceCount : 2
     * attendanceScore : 20
     * interactScore : 12.5
     * detail : [{"interact":25,"attendance":"Y","lessonName":"第一课时"},{"interact":25,"attendance":"P","lessonName":"第二课时"}]
     */

    private int interactCount;
    private int attendanceCount;
    private int attendanceScore;
    private double interactScore;
    /**
     * interact : 25
     * attendance : Y Y 为出勤，P为请假 E为异常
     * lessonName : 第一课时
     */

    private List<DetailEntity> detail;

    public void setInteractCount(int interactCount) {
        this.interactCount = interactCount;
    }

    public void setAttendanceCount(int attendanceCount) {
        this.attendanceCount = attendanceCount;
    }

    public void setAttendanceScore(int attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public void setInteractScore(double interactScore) {
        this.interactScore = interactScore;
    }

    public void setDetail(List<DetailEntity> detail) {
        this.detail = detail;
    }

    public int getInteractCount() {
        return interactCount;
    }

    public int getAttendanceCount() {
        return attendanceCount;
    }

    public int getAttendanceScore() {
        return attendanceScore;
    }

    public double getInteractScore() {
        return interactScore;
    }

    public List<DetailEntity> getDetail() {
        return detail;
    }

    public static class DetailEntity {
        private int interact;
        private String attendance;
        private String lessonName;

        public void setInteract(int interact) {
            this.interact = interact;
        }

        public void setAttendance(String attendance) {
            this.attendance = attendance;
        }

        public void setLessonName(String lessonName) {
            this.lessonName = lessonName;
        }

        public int getInteract() {
            return interact;
        }

        public String getAttendance() {
            return attendance;
        }

        public String getLessonName() {
            return lessonName;
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
