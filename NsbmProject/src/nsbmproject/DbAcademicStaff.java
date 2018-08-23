/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbmproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author MONIRU CMY
 */
public class DbAcademicStaff {

    String url = "jdbc:mysql://localhost:3306/nsbm";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet res = null;

    int addStaff(AcademicStaff staff) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO academic_staff(full_name,name,nic,gender,dob,address,landline_number,mobile_number,email,post,bs,cs,es) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, staff.getFull_name());
            pst.setString(2, staff.getName());
            pst.setString(3, staff.getNic());
            pst.setString(4, staff.getGender());
            pst.setString(5, staff.getDob());
            pst.setString(6, staff.getAddress());
            pst.setString(7, staff.getLandline_number());
            pst.setString(8, staff.getMobile_number());
            pst.setString(9, staff.getEmail());
            pst.setString(10, staff.getPost());
            pst.setString(11, staff.getBs());
            pst.setString(12, staff.getCs());
            pst.setString(13, staff.getBs());

            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        finally{
            try{
                if(pst!=null){
                    pst.close();
                }
                if(con !=null){
                    con.close();
                }
            } catch(Exception e){
            
            }
        }

    }

    int[] getStaffID(String nam) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT staff_id FROM academic_staff WHERE name=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, nam);

            res = pst.executeQuery();

            int subjectCredit[] = new int[1];
            while (res.next()) {
                subjectCredit[0] = res.getInt(1);
            }
            return subjectCredit;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        finally{
            try{
                if(pst!=null){
                    pst.close();
                }
                if(con !=null){
                    con.close();
                }
            } catch(Exception e){
            
            }
        }
    }

    int addStaffSubjects(AcademicStaff staff) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO academic_staff_subjects VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, staff.getStaff_id());
            pst.setString(2, staff.getName());
            pst.setString(3, staff.getPost());
            pst.setString(4, staff.getFaculty());
            pst.setString(5, staff.getYear());
            pst.setString(6, staff.getSemester());
            pst.setString(7, staff.getSubject_code());
            pst.setString(8, staff.getSubject());
            pst.setString(9, staff.getCourse_type());
            pst.setString(10, staff.getDay());
            pst.setString(11, staff.getVenue());
            pst.setString(12, staff.getTime());

            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        finally{
            try{
                if(pst!=null){
                    pst.close();
                }
                if(con !=null){
                    con.close();
                }
            } catch(Exception e){
            
            }
        }

    }
    
    

}
