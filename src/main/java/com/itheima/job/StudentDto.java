package com.itheima.job;

public class StudentDto {
    private String name;
    private String studentNumber;
    private String dormitoryNumber;

    @Override
    public String toString() {
        return "{" + name + ',' +
                studentNumber + ',' +
                dormitoryNumber +
                '}';
    }

    public StudentDto(String name, String studentNumber, String dormitoryNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        this.dormitoryNumber = dormitoryNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getDormitoryNumber() {
        return dormitoryNumber;
    }

    public void setDormitoryNumber(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }
}
