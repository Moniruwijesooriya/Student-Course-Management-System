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
public class DbMarks {

    String url = "jdbc:mysql://localhost:3306/nsbm";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet res = null;

    int setAssignmentMarks(StudentAssignmentResult sr) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_ug_assignment_res VALUES(?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, sr.getStu_id());
            pst.setString(2, sr.getSemester());
            pst.setString(3, sr.getYear());
            pst.setString(4, sr.getFaculty());
            pst.setString(5, sr.getSubject());
            pst.setInt(6, sr.getAsg_num());
            pst.setInt(7, sr.getAsg_marks());

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

    int setStudentUgresult0(StudentExamResult sr) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_ug_result VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, sr.getStu_id());
            pst.setString(2, sr.getYear());
            pst.setString(3, sr.getSemester());
            pst.setString(4, sr.getFaculty());
            pst.setString(5, sr.getSubject());
            pst.setInt(6, 0);
            pst.setInt(7,0);
            pst.setInt(8,0);
            pst.setString(9,"X");
            pst.setString(10,"0.00");
            pst.setString(11,"0.00");
            pst.setInt(12,0);


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

    int[] getSubjectAsgMark(String stuID, String subject) { //get only the mark of assignment marks of the subject for the final mark 
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT asg_mark from student_ug_result WHERE stu_id=? AND subject=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);
            pst.setString(2, subject);

            res = pst.executeQuery();

            int resultArray[] = new int[1];
            int i = 0;
            while (res.next()) {
                resultArray[i] = res.getInt(1);
                i++;
            }
            return resultArray;

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
    //
    
    int[] getSubjectExamMark(String stuID, String subject) { //get only the mark of exam marks of the subject for the final mark 
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT exam_mark from student_ug_result WHERE stu_id=? AND subject=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);
            pst.setString(2, subject);

            res = pst.executeQuery();

            int resultArray[] = new int[1];
            int i = 0;
            while (res.next()) {
                resultArray[i] = res.getInt(1);
                i++;
            }
            return resultArray;

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
    
    //
    int[] getSubjectFinalMark(String stuID, String subject) { //get only the final mark for the subject
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT final_mark from student_ug_result WHERE stu_id=? AND subject=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);
            pst.setString(2, subject);

            res = pst.executeQuery();

            int resultArray[] = new int[1];
            int i = 0;
            while (res.next()) {
                resultArray[i] = res.getInt(1);
                i++;
            }
            return resultArray;

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
    
    
    
    int UpdateStudentUgAsgResult(StudentExamResult ser) { // updating the assignmnet results in the database with asg mark and final mark(not exam mark column)
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_ug_result SET asg_mark=?,final_mark=? WHERE stu_id=? AND subject=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, ser.getAsg_mark());
            pst.setInt(2, ser.getFinal_mark());
            pst.setString(3, ser.getStu_id());
            pst.setString(4, ser.getSubject());
            
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
    
    //
    int UpdateStudentUgExamResult(StudentExamResult ser) { // updating the exam mark in the database with exam mark and final mark(not asg mark column)
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_ug_result SET exam_mark=?,final_mark=?,grade=?,gpv=?,creditxgpv=?,sub_credit=? WHERE stu_id=? AND subject=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setInt(1, ser.getExam_mark());
            pst.setInt(2, ser.getFinal_mark());
            pst.setString(3,ser.getGrade());
            pst.setString(4,ser.getGpv());
            pst.setString(5, ser.getCreditxgpv());
            pst.setInt(6,ser.getSub_credit());
            pst.setString(7, ser.getStu_id());
            pst.setString(8, ser.getSubject());
            
            
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
    
    String[] getSubjectGrade(String stuID, String subject) { //get only the final mark for the subject
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT grade from student_ug_result WHERE stu_id=? AND subject=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);
            pst.setString(2, subject);

            res = pst.executeQuery();

            String resultArray[] = new String[1];
            int i = 0;
            while (res.next()) {
                resultArray[i] = res.getString(1);
                i++;
            }
            return resultArray;

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

}
