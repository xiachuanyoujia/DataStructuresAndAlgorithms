package com.itheima.job;

import java.util.List;

public class DormitoryDto {
    private String dormitoryNumber;
    private List<String> studentNumberList;

    @Override
    public String toString() {
        return "{" + dormitoryNumber +
                ',' +
                studentNumberList +
                '}';
    }

    public DormitoryDto(String dormitoryNumber, List<String> studentNumberList) {
        this.dormitoryNumber = dormitoryNumber;
        this.studentNumberList = studentNumberList;
    }

    public String getDormitoryNumber() {
        return dormitoryNumber;
    }

    public void setDormitoryNumber(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber;
    }

    public List<String> getStudentNumberList() {
        return studentNumberList;
    }

    public void setStudentNumberList(List<String> studentNumberList) {
        this.studentNumberList = studentNumberList;
    }
}
