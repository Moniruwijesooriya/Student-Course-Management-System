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
public class SubjectDetailsTable extends AbstractTableModel {

    private static final String[] COLUMNS = {"Subject Code", "Subject Name", "No. of Credits", "Subject Fee", "Year", "Semester", "Selection"};

    private static ArrayList<Subject> sub_list;

    SubjectDetailsTable(ArrayList<Subject> subjectList) {
        sub_list = subjectList;
    }

    @Override
    public int getRowCount() {
        return sub_list.size();
    }
    
    public String getColumnName(int columnIndex){
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
                return sub_list.get(rowIndex).getSubject_code();
            case 1:
                return sub_list.get(rowIndex).getSubject_name();
            case 2:
                return sub_list.get(rowIndex).getSubject_credit();
            case 3:
                return sub_list.get(rowIndex).getSubject_fee();
            case 4:
                return sub_list.get(rowIndex).getYear();
            case 5:
                return sub_list.get(rowIndex).getSemester();
            case 6:
                return sub_list.get(rowIndex).getSelection();
            default:
                return "Error";

        }
    }

}
