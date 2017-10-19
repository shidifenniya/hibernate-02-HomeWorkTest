package com.lanou.domain;

/**
 * Created by dllo on 17/10/18.
 */
public class StudentNexus {

    private int id;

    private String studentName;

    private Grade grade;

    public StudentNexus() {
    }

    public StudentNexus(String studentName) {
        this.studentName = studentName;
    }

    public StudentNexus(int id, String studentName, Grade grade) {
        this.id = id;
        this.studentName = studentName;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentNexus{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", grade=" + grade +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
