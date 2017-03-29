package com.app.zes.gotoclass.model;

import java.util.List;

/**
 * Created by zes on 17-3-19 23:21
 */
public class CourseLeaving {

    /**
     * id : 1
     * lessonName : 第二课时
     * lessonId : 2
     * reason : ???
     * permission : W
     * time : 2017-03-12 09:23
     */

    private List<LeavesEntity> leaves;

    public void setLeaves(List<LeavesEntity> leaves) {
        this.leaves = leaves;
    }

    public List<LeavesEntity> getLeaves() {
        return leaves;
    }

    public static class LeavesEntity {
        private int id;
        private String lessonName;
        private int lessonId;
        private String reason;
        private String permission;
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

        public void setReason(String reason) {
            this.reason = reason;
        }

        public void setPermission(String permission) {
            this.permission = permission;
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

        public String getReason() {
            return reason;
        }

        public String getPermission() {
            return permission;
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
