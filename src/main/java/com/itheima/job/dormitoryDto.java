package com.itheima.job;

public class dormitoryDto {
    private String name;
    private String studentNumber;
    private String SeatNumber;

    public dormitoryDto(String name, String studentNumber, String seatNumber) {
        this.name = name;
        this.studentNumber = studentNumber;
        SeatNumber = seatNumber;
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

    public String getSeatNumber() {
        return SeatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        SeatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "{" +
                name +
                "," + studentNumber +
                "," + SeatNumber +
                '}';
    }
}
