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
public class StudentSubjectDetails extends AbstractTableModel {

    private static final String[] COLUMNS = {"Student ID", "Semester", "Year", "Compulsory Subject 1", "Compulsory Subject 3", "Compulsory Subject 3", "Optional Subject 1", "Optional Subject 2"};

    private static ArrayList<StudentSubjects> stu_list;

    StudentSubjectDetails(ArrayList<StudentSubjects> studentList) {
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
                return stu_list.get(rowIndex).getSemester();
            case 2:
                return stu_list.get(rowIndex).getYear();
            case 3:
                return stu_list.get(rowIndex).getCom_sub1();
            case 4:
                return stu_list.get(rowIndex).getCom_sub2();
            case 5:
                return stu_list.get(rowIndex).getCom_sub3();
            case 6:
                return stu_list.get(rowIndex).getOpt_sub1();
            case 7:
                return stu_list.get(rowIndex).getOpt_sub2();
            default:
                return "Error";

        }
    }

}
