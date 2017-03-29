package com.app.zes.gotoclass.model;

import java.util.List;

/**
 * Created by zes on 17-3-19 23:14
 */
public class CourseOutline {


    /**
     * outline : [{"id":4,"sequence":1,"content":"第一步"},{"id":5,"sequence":2,"content":"第二步"},{"id":6,"sequence":3,"content":"第三步"},{"id":7,"sequence":4,"content":"第四步"}]
     * lessonName : 第一课时
     */

    private String lessonName;
    /**
     * id : 4
     * sequence : 1
     * content : 第一步
     */

    private List<OutlineEntity> outline;

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public void setOutline(List<OutlineEntity> outline) {
        this.outline = outline;
    }

    public String getLessonName() {
        return lessonName;
    }

    public List<OutlineEntity> getOutline() {
        return outline;
    }

    public static class OutlineEntity {
        private int id;
        private int sequence;
        private String content;

        public void setId(int id) {
            this.id = id;
        }

        public void setSequence(int sequence) {
            this.sequence = sequence;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public int getSequence() {
            return sequence;
        }

        public String getContent() {
            return content;
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
