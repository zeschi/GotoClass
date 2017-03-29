package com.app.zes.gotoclass.model;

/**
 * Created by zes on 17-3-19 23:01
 */
public class CourseByCode {


    /**
     * result : success
     * course : {"id":3,"name":"XML开发","teacher":"Mark","lessonName":"第一课时","lessonId":5,"classroom":"教506","time":"2017-3-22 10:00"}
     */

    private String result;
    /**
     * id : 3
     * name : XML开发
     * teacher : Mark
     * lessonName : 第一课时
     * lessonId : 5
     * classroom : 教506
     * time : 2017-3-22 10:00
     */

    private CourseEntity course;

    public void setResult(String result) {
        this.result = result;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }

    public String getResult() {
        return result;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public static class CourseEntity {
        private int id;
        private String name;
        private String teacher;
        private String lessonName;
        private int lessonId;
        private String classroom;
        private String time;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public void setLessonName(String lessonName) {
            this.lessonName = lessonName;
        }

        public void setLessonId(int lessonId) {
            this.lessonId = lessonId;
        }

        public void setClassroom(String classroom) {
            this.classroom = classroom;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getTeacher() {
            return teacher;
        }

        public String getLessonName() {
            return lessonName;
        }

        public int getLessonId() {
            return lessonId;
        }

        public String getClassroom() {
            return classroom;
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
