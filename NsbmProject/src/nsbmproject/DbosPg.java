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
import java.util.ArrayList;

/**
 *
 * @author MONIRU CMY
 */
public class DbosPg {

    String url = "jdbc:mysql://localhost:3306/nsbm";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet res = null;


    int addStudent(Student stu) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_pg VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu.getStu_id());
            pst.setString(2, stu.getFaculty());
            pst.setString(3, stu.getNic());
            pst.setString(4, stu.getStu_name());
            pst.setString(5, stu.getStu_full_name());
            pst.setString(6, stu.getAddress());
            pst.setString(7, stu.getDob());
            pst.setString(8, stu.getLandline_number());
            pst.setString(9, stu.getMobile_number());
            pst.setString(10, stu.getEmail());
            pst.setString(11, stu.getIntake_year());
            pst.setString(12, stu.getIntake_month());
            pst.setString(13, stu.getGender());
            pst.setString(14, stu.getCur_year());
            pst.setString(15, stu.getCur_semester());
            pst.setString(16, stu.getGpa());
            pst.setString(17, stu.getCredits());
            
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

    int addQualification(Student stu,String qualification) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_al VALUES(?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu.getStu_id());
            pst.setString(2, stu.getFaculty());
            pst.setString(3,qualification );

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

    int addSubjectUg(Subject sub) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO subject_ug VALUES (?,?,?,?,?,?,?,?) ";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, sub.getFaculty());
            pst.setString(2, sub.getSubject_code());
            pst.setString(3, sub.getSubject_name());
            pst.setInt(4, sub.getSubject_credit());
            pst.setInt(5, sub.getSubject_fee());
            pst.setString(6, sub.getYear());
            pst.setString(7, sub.getSemester());
            pst.setString(8, sub.getSelection());

            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {

            }
        }
    }

    ArrayList<Subject> getSubjectsUg(String facu) {

        try {
            ArrayList<Subject> subList = new ArrayList<Subject>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT subject_code,subject_name,credit,subject_fee,year,semester,selection FROM subject_ug WHERE faculty=?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareCall(query);
            pst.setString(1, facu);

            res = pst.executeQuery();

            while (res.next()) {
                Subject sub = new Subject();
                sub.setSubject_code(res.getString(1));
                sub.setSubject_name(res.getString(2));
                sub.setSubject_credit(res.getInt(3));
                sub.setSubject_fee(res.getInt(4));
                sub.setYear(res.getString(5));
                sub.setSemester(res.getString(6));
                sub.setSelection(res.getString(7));
                subList.add(sub);

            }
            return subList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {

            }
        }
    }

    ArrayList<Student> getStudentsUg(String fac) {

        try {
            ArrayList<Student> stuList = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT stu_id,stu_name,nic,dob,intake_year,intake_month,gender,cur_year,cur_semester FROM student_ug WHERE faculty=?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareCall(query);
            pst.setString(1, fac);

            res = pst.executeQuery();

            while (res.next()) {
                Student stu = new Student();
                stu.setStu_id(res.getString(1));
                stu.setStu_name(res.getString(2));
                stu.setNic(res.getString(3));
                stu.setDob(res.getString(4));
                stu.setIntake_year(res.getString(5));
                stu.setIntake_month(res.getString(6));
                stu.setGender(res.getString(7));
                stu.setCur_year(res.getString(8));
                stu.setCur_semester(res.getString(9));

                stuList.add(stu);

            }
            return stuList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {

            }
        }
    }

    ArrayList<Student> getStudentsContactUg(String fac) { //contact details

        try {
            ArrayList<Student> stuList = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT stu_id,stu_name,address,landline_number,mobile_number,email FROM student_ug WHERE faculty=?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareCall(query);
            pst.setString(1, fac);

            res = pst.executeQuery();

            while (res.next()) {
                Student stu = new Student();
                stu.setStu_id(res.getString(1));
                stu.setStu_name(res.getString(2));
                stu.setAddress(res.getString(3));
                stu.setLandline_number(res.getString(4));
                stu.setMobile_number(res.getString(5));
                stu.setEmail(res.getString(6));

                stuList.add(stu);

            }
            return stuList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {

            }
        }
    }

    ArrayList<StudentSubjects> getStudentsSubjectUg(String fac) { //contact details

        try {
            ArrayList<StudentSubjects> stuList = new ArrayList<StudentSubjects>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT stu_id,semester,year,com_sub1,com_sub2,com_sub3,opt_sub1,opt_sub2 FROM student_ug_subjects WHERE faculty=?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareCall(query);
            pst.setString(1, fac);

            res = pst.executeQuery();

            while (res.next()) {
                StudentSubjects stu = new StudentSubjects();
                stu.setStu_id(res.getString(1));
                stu.setSemester(res.getString(2));
                stu.setYear(res.getString(3));
                stu.setCom_sub1(res.getString(4));
                stu.setCom_sub2(res.getString(5));
                stu.setCom_sub3(res.getString(6));
                stu.setOpt_sub1(res.getString(7));
                stu.setOpt_sub2(res.getString(8));

                stuList.add(stu);
            }
            return stuList;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {

            }
        }
    }

    String[] getCompulosorySubjectUg(String semester, String year, String faculty) {
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT subject_name from subject_ug WHERE semester=? AND year =? AND selection=? AND faculty=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, semester);
            pst.setString(2, year);
            pst.setString(3, "compulsory");
            pst.setString(4, faculty);
            res = pst.executeQuery();
            String resultArray[] = new String[4];
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

    int setStudentUgSubjects(StudentSubjects stu) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_ug_subjects VALUES (?,?,?,?,?,?,?,?,?,?) ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu.getStu_id());
            pst.setString(2, stu.getFaculty());
            pst.setString(3, stu.getSemester());
            pst.setString(4, stu.getYear());
            pst.setString(5, stu.getCom_sub1());
            pst.setString(6, stu.getCom_sub2());
            pst.setString(7, stu.getCom_sub3());
            pst.setString(8, stu.getCom_sub4());
            pst.setString(9, stu.getOpt_sub1());
            pst.setString(10, stu.getOpt_sub2());

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

    String[] getStudentCurrentYear(String stuID) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT cur_year from student_ug WHERE stu_id=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);

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

    String[] getStudentCurrentSemester(String stuID) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT cur_semester from student_ug WHERE stu_id=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);

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

    String[] getStudentName(String stuID) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT stu_name from student_ug WHERE stu_id=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);

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

    String[] getStudentFaculty(String stuID) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT faculty FROM student_ug WHERE stu_id=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);

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
    
    String[] getStudentEmail(String stuID) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT email from student_ug WHERE stu_id=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);

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

    int setGpa0(String stuId, String fac,String fourth_years,String intake,String year) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_ug_gpa VALUES (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuId);
            pst.setString(2, fac);
            pst.setString(3, "0");
            pst.setString(4,"0");
            pst.setString(5, fourth_years);
            pst.setString(6, intake);
            pst.setString(7, year);

            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.print(e);
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
    
    int insertTopassOutTable(Student stu) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_ug_pass_out VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu.getStu_id());
            pst.setString(2, stu.getFaculty());
            pst.setString(3, stu.getNic());
            pst.setString(4, stu.getStu_name());
            pst.setString(5, stu.getStu_full_name());
            pst.setString(6, stu.getAddress());
            pst.setString(7, stu.getDob());
            pst.setString(8, stu.getLandline_number());
            pst.setString(9, stu.getMobile_number());
            pst.setString(10, stu.getEmail());
            pst.setString(11, stu.getIntake_year());
            pst.setString(12, stu.getIntake_month());
            pst.setString(13, stu.getGender());
            pst.setString(14, stu.getCur_year());
            pst.setString(15, stu.getCur_semester());
            pst.setString(16, stu.getGpa());
            pst.setString(17, stu.getCredits());
            pst.setString(18, stu.getFourth_year());

            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.print(e);
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
    
    String[] getEmail(String stuID) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT email FROM student_ug WHERE stu_id=? AND faculty=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);

            String resultArray[] = new String[1];

            while (res.next()) {
                System.out.println(res.getString(1));
                resultArray[0] = res.getString(1); //
    
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

    String[] getStudent(String stuID) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT nic,stu_name,stu_full_name,address,dob,landline_number,mobile_number,email,gender from student_ug WHERE stu_id=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);

            res = pst.executeQuery();

            String resultArray[] = new String[9];
            while (res.next()) {
                resultArray[0] = res.getString(1);
                resultArray[1] = res.getString(2);
                resultArray[2] = res.getString(3);
                resultArray[3] = res.getString(4);
                resultArray[4] = res.getString(5);
                resultArray[5] = res.getString(6);
                resultArray[6] = res.getString(7);
                resultArray[7] = res.getString(8);
                resultArray[8] = res.getString(9);
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
    
    String[] getStudentAL(String stuID) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT stream,sub1,sub2,sub3,english_result,result1,result2,result3,zscore,dis_rank,island_rank from student_al WHERE stu_id=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stuID);

            res = pst.executeQuery();

            String resultArray[] = new String[11];
            while (res.next()) {
                resultArray[0] = res.getString(1);
                resultArray[1] = res.getString(2);
                resultArray[2] = res.getString(3);
                resultArray[3] = res.getString(4);
                resultArray[4] = res.getString(5);
                resultArray[5] = res.getString(6);
                resultArray[6] = res.getString(7);
                resultArray[7] = res.getString(8);
                resultArray[8] = res.getString(9);
                resultArray[9] = res.getString(10);
                resultArray[10] = res.getString(11);
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
    
    int UpdateStudent(Student stu) { // updating the student details
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_ug SET nic=?,stu_name=?,stu_full_name=?,address=?,dob=?,landline_number=?,mobile_number=?,email=?,gender=? WHERE stu_id=?";
            pst = (PreparedStatement) con.prepareStatement(query);

            pst.setString(1, stu.getNic());
            pst.setString(2, stu.getStu_name());
            pst.setString(3, stu.getStu_full_name());
            pst.setString(4, stu.getAddress());
            pst.setString(5, stu.getDob());
            pst.setString(6, stu.getLandline_number());
            pst.setString(7, stu.getMobile_number());
            pst.setString(8, stu.getEmail());
            pst.setString(9,stu.getGender());
            pst.setString(10,stu.getStu_id());

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