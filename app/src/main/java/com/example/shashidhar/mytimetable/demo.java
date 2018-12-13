package com.example.shashidhar.mytimetable;

public class demo {
    private String subject;
    private String start;
    private String end;
    private String teacher;
    private String classroom;

    public demo(String subject, String start, String end, String teacher, String classroom) {
        this.subject = subject;
        this.start = start;
        this.end = end;
        this.teacher = teacher;
        this.classroom = classroom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
