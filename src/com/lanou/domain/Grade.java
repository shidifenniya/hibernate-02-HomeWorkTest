package com.lanou.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by dllo on 17/10/18.
 */
public class Grade {

    private int id;

    private String className;

    private Set<StudentNexus> studentNexusSet = new HashSet<>();


    public Grade() {
    }

    public Grade(String className) {
        this.className = className;
    }

    public Grade(int id, String className, Set<StudentNexus> studentNexusSet) {
        this.id = id;
        this.className = className;
        this.studentNexusSet = studentNexusSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<StudentNexus> getStudentNexusSet() {
        return studentNexusSet;
    }

    public void setStudentNexusSet(Set<StudentNexus> studentNexusSet) {
        this.studentNexusSet = studentNexusSet;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", className='" + className + '\'' + '}';
    }
}
