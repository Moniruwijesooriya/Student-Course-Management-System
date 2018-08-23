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
public class TeachingLecAllocationDetails extends AbstractTableModel {

    private static final String[] COLUMNS = {"Subject Code", "Subject Name", "Lecturer Name", "Year", "Semester", "Day", "Venue", "Time"};

    private static ArrayList<AcademicStaff> teaching_Lec_Allocation;

    TeachingLecAllocationDetails(ArrayList<AcademicStaff> subAllocationDetails) {
        teaching_Lec_Allocation = subAllocationDetails;
    }

    @Override
    public int getRowCount() {
        return teaching_Lec_Allocation.size();
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
                return teaching_Lec_Allocation.get(rowIndex).getSubject_code();
            case 1:
                return teaching_Lec_Allocation.get(rowIndex).getSubject();
            case 2:
                return teaching_Lec_Allocation.get(rowIndex).getName();
            case 3:
                return teaching_Lec_Allocation.get(rowIndex).getYear();
            case 4:
                return teaching_Lec_Allocation.get(rowIndex).getSemester();
            case 5:
                return teaching_Lec_Allocation.get(rowIndex).getDay();
            case 6:
                return teaching_Lec_Allocation.get(rowIndex).getVenue();
            case 7:
                return teaching_Lec_Allocation.get(rowIndex).getTime();
            default:
                return "Error";

        }
    }

}
