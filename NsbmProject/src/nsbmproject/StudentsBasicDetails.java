/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbmproject;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MONIRU CMY
 */
public class StudentsBasicDetails extends AbstractTableModel {

    private static final String[] COLUMNS = {"Student ID", "Student Name", "NIC", "DOB", "Gender", "Intake Year", "Intake Month", "Current Year", "Current Semester"};

    private static ArrayList<Student> stu_list;

    StudentsBasicDetails(ArrayList<Student> studentList) {
        stu_list = studentList;
    }

    @Override
    public int getRowCount() {
        return stu_list.size();
    }

    public String getColumnName(int columnIndex) {
        return COLUMNS[columnIndex];
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return stu_list.get(rowIndex).getStu_id();
            case 1:
                return stu_list.get(rowIndex).getStu_name();
            case 2:
                return stu_list.get(rowIndex).getNic();
            case 3:
                return stu_list.get(rowIndex).getDob();
            case 4:
                return stu_list.get(rowIndex).getGender();
            case 5:
                return stu_list.get(rowIndex).getIntake_year();
            case 6:
                return stu_list.get(rowIndex).getIntake_month();
            case 7:
                return stu_list.get(rowIndex).getCur_year();
            case 8:
                return stu_list.get(rowIndex).getCur_semester();
            default:
                return "Error";

        }
    }

}
