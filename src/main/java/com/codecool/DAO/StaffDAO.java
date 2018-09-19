package com.codecool.DAO;

import com.codecool.model.staff.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffDAO {
    private final String SOURCE_FILE_NAME = "staff.csv";
    private final int ID_INDEX = 0;
    private final int NAME_INDEX = 1;
    private final int SURNAME_INDEX = 2;
    private final int EMAIL_INDEX = 3;
    private final int TYPE_INDEX = 4;

    private DataLoader dataLoader;

    public StaffDAO() {
        dataLoader = new DataLoader(SOURCE_FILE_NAME);
    }

    public List<Staff> loadStaff() {
        List<Staff> staff = new ArrayList<>();
        String[][] fileContent = dataLoader.getFileContent();

        for (String[] row: fileContent) {
            staff.add(new Staff(row[ID_INDEX], row[NAME_INDEX], row[SURNAME_INDEX], row[EMAIL_INDEX], row[TYPE_INDEX]));
        }
        return staff;
    }

    public List<Staff> getStaffByType(String type) {
        List<Staff> allStaff = loadStaff();
        List<Staff> staffOfWantedType = new ArrayList<>();

        for (Staff staff: allStaff) {
            if (staff.getType().equals(type)) staffOfWantedType.add(staff);
        }
        return staffOfWantedType;
    }

    public void addStaff(String id, String name, String surname, String email, String type) {
        List<Staff> staffList = loadStaff();
        staffList.add(new Staff(id, name, surname, email, type));
        saveStaff(staffList);
    }

    public void removeStaff(String staffId) {
        //TODO
    }

    private void saveStaff(List<Staff> staffList) {
        List<String[]> staffDataToSave = new ArrayList<>();
        for (Staff staff: staffList) {
            String[] staffData = {staff.getId(), staff.getName(), staff.getSurname(), staff.getEmail(), staff.getType()};
            staffDataToSave.add(staffData);
        }
        dataLoader.saveContentToFile(staffDataToSave.toArray(new String[][]{}));
    }
}
