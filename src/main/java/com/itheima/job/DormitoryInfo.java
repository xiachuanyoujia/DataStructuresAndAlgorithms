package com.itheima.job;

import java.util.HashMap;
import java.util.Map;

public class DormitoryInfo {
    private Map<String, dormitoryDto> map = new HashMap<>();

    public boolean add(dormitoryDto dto) {
        if (map.containsKey(dto.getStudentNumber())) {
            return false;
        }
        map.put(dto.getStudentNumber(), dto);
        return true;
    }

    public boolean removeByStudentNumber(String studentNumber) {
        return map.remove(studentNumber) != null;
    }

    public boolean updateStudent(String studentNumber, String newName, String newSeatNumber) {
        dormitoryDto dto = map.get(studentNumber);
        if (dto == null) {
            return false;
        }
        dto.setName(newName);
        dto.setSeatNumber(newSeatNumber);
        return true;
    }

    public dormitoryDto queryStudent(String studentNumber) {
        return map.get(studentNumber);
    }

    @Override
    public String toString() {
        return map.values().toString();
    }

    public static void main(String[] args) {
        DormitoryInfo list = new DormitoryInfo();
        list.add(new dormitoryDto("张1","2161300001","A1"));
        list.add(new dormitoryDto("张2","2161300002","A2"));
        list.add(new dormitoryDto("张3","2161300003","A3"));
        list.add(new dormitoryDto("张4","2161300004","A4"));
        System.out.println(list);
        list.removeByStudentNumber("2161300001");
        System.out.println(list);
        list.updateStudent("2161300003", "张3更新", "A3更新");
        System.out.println(list);
        dormitoryDto queriedStudent = list.queryStudent("2161300002");
        System.out.println(queriedStudent);
    }
}
