package com.app.zes.gotoclass.model;

import java.util.List;

/**
 * Created by zes on 17-3-19 23:13
 */
public class CourseLesson {

    /**
     * result : success
     * lessonDetail : {"id":2,"name":"第二课时","outline":{"outlines":[{"id":1,"sequence":1,"content":"什么是JAVA"},{"id":2,"sequence":2,"content":"数据的基本类型"},{"id":3,"sequence":3,"content":"数组的应用"}]},"comment":{"id":1,"title":"明天不用上课","content":"明天不用上课,老师请假了","time":null},"gpa":{"id":1,"attendancePrecent":"10.0","interactPrecent":null,"totalScore":"10.0"}}
     */

    private String result;
    /**
     * id : 2
     * name : 第二课时
     * outline : {"outlines":[{"id":1,"sequence":1,"content":"什么是JAVA"},{"id":2,"sequence":2,"content":"数据的基本类型"},{"id":3,"sequence":3,"content":"数组的应用"}]}
     * comment : {"id":1,"title":"明天不用上课","content":"明天不用上课,老师请假了","time":null}
     * gpa : {"id":1,"attendancePrecent":"10.0","interactPrecent":null,"totalScore":"10.0"}
     */

    private LessonDetailEntity lessonDetail;

    public void setResult(String result) {
        this.result = result;
    }

    public void setLessonDetail(LessonDetailEntity lessonDetail) {
        this.lessonDetail = lessonDetail;
    }

    public String getResult() {
        return result;
    }

    public LessonDetailEntity getLessonDetail() {
        return lessonDetail;
    }

    public static class LessonDetailEntity {
        private int id;
        private String name;
        private OutlineEntity outline;
        /**
         * id : 1
         * title : 明天不用上课
         * content : 明天不用上课,老师请假了
         * time : null
         */

        private CommentEntity comment;
        /**
         * id : 1
         * attendancePrecent : 10.0
         * interactPrecent : null
         * totalScore : 10.0
         */

        private GpaEntity gpa;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setOutline(OutlineEntity outline) {
            this.outline = outline;
        }

        public void setComment(CommentEntity comment) {
            this.comment = comment;
        }

        public void setGpa(GpaEntity gpa) {
            this.gpa = gpa;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public OutlineEntity getOutline() {
            return outline;
        }

        public CommentEntity getComment() {
            return comment;
        }

        public GpaEntity getGpa() {
            return gpa;
        }

        public static class OutlineEntity {
            /**
             * id : 1
             * sequence : 1
             * content : 什么是JAVA
             */

            private List<OutlinesEntity> outlines;

            public void setOutlines(List<OutlinesEntity> outlines) {
                this.outlines = outlines;
            }

            public List<OutlinesEntity> getOutlines() {
                return outlines;
            }

            public static class OutlinesEntity {
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

        public static class CommentEntity {
            private int id;
            private String title;
            private String content;
            private Object time;

            public void setId(int id) {
                this.id = id;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setTime(Object time) {
                this.time = time;
            }

            public int getId() {
                return id;
            }

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }

            public Object getTime() {
                return time;
            }
        }

        public static class GpaEntity {
            private int id;
            private String attendancePrecent;
            private String interactPrecent;
            private String totalScore;

            public void setId(int id) {
                this.id = id;
            }

            public void setAttendancePrecent(String attendancePrecent) {
                this.attendancePrecent = attendancePrecent;
            }

            public void setInteractPrecent(String interactPrecent) {
                this.interactPrecent = interactPrecent;
            }

            public void setTotalScore(String totalScore) {
                this.totalScore = totalScore;
            }

            public int getId() {
                return id;
            }

            public String getAttendancePrecent() {
                return attendancePrecent;
            }

            public String getInteractPrecent() {
                return interactPrecent;
            }

            public String getTotalScore() {
                return totalScore;
            }
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
