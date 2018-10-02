package com.codecool.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceDAO {
    DataLoader dataLoader;
    final String SOURCE_FILE_NAME = "attendance.csv";
    final int STUDENT_NAME_INDEX = 0;

    public AttendanceDAO() {
        dataLoader = new DataLoader(SOURCE_FILE_NAME);
    }

    public Map<String, Map<String, Boolean>> loadAttendance() {
        Map<String, Map<String, Boolean>> attendance = new HashMap<>();
        String[][] fileContent = dataLoader.getFileContent();

        for (String[] row : fileContent) {

            if (!attendance.keySet().contains(row[STUDENT_NAME_INDEX])) {
                attendance.put(row[STUDENT_NAME_INDEX], new HashMap<String, Boolean>());
            }

            for (int dataIndexInRow = 1; dataIndexInRow < row.length; dataIndexInRow = +2) {
                attendance.get(row[STUDENT_NAME_INDEX]).put(row[dataIndexInRow],
                        Boolean.valueOf(row[dataIndexInRow + 1]));
            }
        }
        return attendance;
    }

    public void saveAttendance(Map<String, Map<String, Boolean>> attendance) {
        List<String[]> attendanceDataToSave = new ArrayList<>();

        for (String studentName : attendance.keySet()) {
            List<String> studentAttendanceData = new ArrayList<>();
            studentAttendanceData.add(studentName);
            for (String date: attendance.get(studentName).keySet()) {
                studentAttendanceData.add(date);
                studentAttendanceData.add(String.valueOf(attendance.get(studentName).get(date)));
            }
        }
        dataLoader.saveContentToFile(attendanceDataToSave.toArray(new String[][]{}));
    }
}
