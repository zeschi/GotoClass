package com.app.zes.gotoclass.model;

import java.util.List;

/**
 * Created by zes on 17-4-15 10:30
 */
public class CourseGPAReport {


    /**
     * result : success
     * score : [{"interactCount":0,"courseName":"WEB开发","attendanceCount":1,"attendanceScore":10,"interactScore":0,"totalScore":10},{"interactCount":4,"courseName":"JAVA开发","attendanceCount":2,"attendanceScore":20,"interactScore":12.5,"totalScore":32.5},{"interactCount":0,"courseName":"XML开发","attendanceCount":1,"attendanceScore":10,"interactScore":0,"totalScore":10},{"interactCount":0,"courseName":"JAVASCRIPT","attendanceCount":2,"attendanceScore":13.333333333333334,"interactScore":0,"totalScore":13.333333333333334},{"interactCount":0,"courseName":"HTML开发","attendanceCount":0,"attendanceScore":0,"interactScore":0,"totalScore":0}]
     */

    private String result;
    /**
     * interactCount : 0
     * courseName : WEB开发
     * attendanceCount : 1
     * attendanceScore : 10
     * interactScore : 0
     * totalScore : 10
     */

    private List<ScoreEntity> score;

    public void setResult(String result) {
        this.result = result;
    }

    public void setScore(List<ScoreEntity> score) {
        this.score = score;
    }

    public String getResult() {
        return result;
    }

    public List<ScoreEntity> getScore() {
        return score;
    }

    public static class ScoreEntity {
        private int interactCount;
        private String courseName;
        private int attendanceCount;
        private double attendanceScore;
        private double interactScore;
        private double totalScore;

        public void setInteractCount(int interactCount) {
            this.interactCount = interactCount;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public void setAttendanceCount(int attendanceCount) {
            this.attendanceCount = attendanceCount;
        }

        public void setAttendanceScore(double attendanceScore) {
            this.attendanceScore = attendanceScore;
        }

        public void setInteractScore(double interactScore) {
            this.interactScore = interactScore;
        }

        public void setTotalScore(double totalScore) {
            this.totalScore = totalScore;
        }

        public int getInteractCount() {
            return interactCount;
        }

        public String getCourseName() {
            return courseName;
        }

        public int getAttendanceCount() {
            return attendanceCount;
        }

        public double getAttendanceScore() {
            return attendanceScore;
        }

        public double getInteractScore() {
            return interactScore;
        }

        public double getTotalScore() {
            return totalScore;
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
