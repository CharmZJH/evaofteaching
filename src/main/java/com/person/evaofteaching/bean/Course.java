package com.person.evaofteaching.bean;


public class Course {
    private int ID;
    private String CourseName;
    private String TeacherName;
    private String Department;
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public String getCourseName() {
        return CourseName;
    }
    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
    public String getTeacherName() {
        return TeacherName;
    }
    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }
    public String getDepartment() {
        return Department;
    }
    public void setDepartment(String department) {
        Department = department;
    }

}
