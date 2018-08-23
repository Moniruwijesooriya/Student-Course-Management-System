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
public class StudentContactDetails extends AbstractTableModel {

    private static final String[] COLUMNS = {"Student ID", "Student Name", "Address", "LandLine Number", "Mobile Number", "Email"};

    private static ArrayList<Student> stu_list;

    StudentContactDetails(ArrayList<Student> studentList) {
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
                return stu_list.get(rowIndex).getAddress();
            case 3:
                return stu_list.get(rowIndex).getLandline_number();
            case 4:
                return stu_list.get(rowIndex).getMobile_number();
            case 5:
                return stu_list.get(rowIndex).getEmail();
            default:
                return "Error";

        }
    }

}
