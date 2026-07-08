package com.scms.model;

import java.time.LocalDate;

public class Student {

    private int studentId;
    private String studentName;
    private String email;
    private String phone;
    private String gender;
    private LocalDate dob;
    private String address;
    private int departmentId;

    public Student() {
    }

    public Student(int studentId, String studentName, String email,
                   String phone, String gender,
                   LocalDate dob, String address,
                   int departmentId) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.departmentId = departmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Student [studentId=" + studentId +
                ", studentName=" + studentName +
                ", email=" + email +
                ", phone=" + phone +
                ", gender=" + gender +
                ", dob=" + dob +
                ", address=" + address +
                ", departmentId=" + departmentId + "]";
    }
}