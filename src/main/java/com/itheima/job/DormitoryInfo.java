package com.itheima.job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DormitoryInfo {
    private final Map<String, StudentDto> studentMap = new HashMap<>();
    private final Map<String, DormitoryDto> dormitoryMap = new HashMap<>();

    public boolean add(StudentDto student) {
        if (student == null || studentMap.containsKey(student.getStudentNumber())) {
            return false;
        }
        DormitoryDto dormitory = addStudentToDormitory(student);

        if (dormitory.getStudentNumberList().size() >= 4) {
            return false;
        }

        dormitory.getStudentNumberList().add(student.getStudentNumber());
        studentMap.put(student.getStudentNumber(), student);

        return true;
    }

    public boolean remove(String studentNumber) {
        StudentDto student = studentMap.get(studentNumber);
        if (student == null) {
            return false;
        }

        DormitoryDto dormitory = dormitoryMap.get(student.getDormitoryNumber());
        if (dormitory != null) {
            dormitory.getStudentNumberList().remove(studentNumber);
        }

        studentMap.remove(studentNumber);
        return true;
    }

    public boolean update(StudentDto student) {
        if (student == null || !studentMap.containsKey(student.getStudentNumber())) {
            return false;
        }

        StudentDto oldStudent = studentMap.get(student.getStudentNumber());
        DormitoryDto oldDormitory = dormitoryMap.get(oldStudent.getDormitoryNumber());
        if (oldDormitory != null) {
            oldDormitory.getStudentNumberList().remove(oldStudent.getStudentNumber());
        }

        DormitoryDto newDormitory = addStudentToDormitory(student);
        if (newDormitory.getStudentNumberList().size() >= 4) {
            return false;
        }

        newDormitory.getStudentNumberList().add(student.getStudentNumber());
        studentMap.put(student.getStudentNumber(), student);

        return true;
    }

    private DormitoryDto addStudentToDormitory(StudentDto student) {
        DormitoryDto newDormitory = dormitoryMap.computeIfAbsent(student.getDormitoryNumber(), k -> new DormitoryDto(k, new ArrayList<>()));
        return newDormitory;
    }

    public StudentDto selectStudentNumber(String studentNumber) {
        if (!studentMap.containsKey(studentNumber)) {
            return null;
        }
        return studentMap.get(studentNumber);
    }

    public static void main(String[] args) {
        DormitoryInfo dormitoryInfo = new DormitoryInfo();
        StudentDto student1 = new StudentDto("张三", "216130001", "贤A001");
        StudentDto student2 = new StudentDto("张四", "216130002", "贤A001");
        StudentDto student3 = new StudentDto("张五", "216130003", "贤A001");
        StudentDto student4 = new StudentDto("张六", "216130004", "贤A001");
        StudentDto student5 = new StudentDto("张七", "216130005", "贤A001");

        dormitoryInfo.add(student1);
        dormitoryInfo.add(student2);
        dormitoryInfo.add(student3);
        dormitoryInfo.add(student4);
        dormitoryInfo.add(student5);
        System.out.println("添加学生 studentMap 结果: " + dormitoryInfo.studentMap);
        System.out.println("添加学生 dormitoryMap 结果: " + dormitoryInfo.dormitoryMap);

        System.out.println(dormitoryInfo.selectStudentNumber("216130003"));
        System.out.println(dormitoryInfo.selectStudentNumber("216130005"));

        dormitoryInfo.remove("216130003");
        System.out.println("删除学生 studentMap 结果: " + dormitoryInfo.studentMap);
        System.out.println("删除学生 dormitoryMap 结果: " + dormitoryInfo.dormitoryMap);

        StudentDto student6 = new StudentDto("张八", "216130006", "贤A001");
        StudentDto student7 = new StudentDto("张四更新", "216130002", "贤A002");
        dormitoryInfo.update(student6);
        dormitoryInfo.update(student7);
        System.out.println("更新学生 studentMap 结果: " + dormitoryInfo.studentMap);
        System.out.println("更新学生 dormitoryMap 结果: " + dormitoryInfo.dormitoryMap);

        dormitoryInfo.add(student6);
        System.out.println("添加张八进贤A001 studentMap: " + dormitoryInfo.studentMap);
        System.out.println("添加张八进贤A001 dormitoryMap: " + dormitoryInfo.dormitoryMap);
    }
}
