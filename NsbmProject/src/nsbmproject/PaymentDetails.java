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

public class PaymentDetails extends AbstractTableModel {

    private static final String[] COLUMNS = {"Student ID", "Year", "Semester", "Total Fee"};

    private static ArrayList<StudentPayment> pay_list;

    PaymentDetails(ArrayList<StudentPayment> payList) {
        pay_list = payList;
    }

    @Override
    public int getRowCount() {
        return pay_list.size();
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
                return pay_list.get(rowIndex).getStu_id();
            case 1:
                return pay_list.get(rowIndex).getYear();
            case 2:
                return pay_list.get(rowIndex).getSemester();
            case 3:
                return pay_list.get(rowIndex).getAmount();
            default:
                return "Error";

        }
    }

}