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
public class Dbos {

    String url = "jdbc:mysql://localhost:3306/nsbm";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet res = null;

    boolean addUser(User usr) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO user VALUES (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, usr.getName());
            pst.setString(2, usr.getUsername());
            pst.setString(3, usr.getEmail());
            pst.setString(4, usr.getPassword());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.print(e);
            return false;
        }

    }

    int checkUsername(String username) {
        try {
            con = (Connection) DriverManager.getConnection(url, this.username, password);
            String query = "SELECT username from user";
            pst = (PreparedStatement) con.prepareStatement(query);
            res = pst.executeQuery();

            while (res.next()) {
                if (username.equals(res.getString(1))) {
                    return 0;
                }
            }

            return 1;

        } catch (Exception e) {
            System.out.print(e);
            return 2;
        }
    }

    int login(String usernm, String passwd) {
        try {
            con = (Connection) DriverManager.getConnection(url, this.username, this.password);
            Dbos db = new Dbos();
            int x = db.checkUsername(usernm);
            if (x == 0) {
                String query = "SELECT password from user WHERE username='" + usernm + "'";

                pst = (PreparedStatement) con.prepareStatement(query);
                res = pst.executeQuery();
                while (res.next()) {
                    String pswd = res.getString(1);
                    if (passwd.equals(pswd)) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            } else if (x == 1) {
                return 3;
            } else if (x == 2) {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e);
            return 9;
        }
        return 8;
    }

    int addStudent(UgStudent stu) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_ug VALUES (?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu.getStu_id());
            pst.setString(2, stu.getFaculty());
            pst.setString(3, stu.getNic());
            pst.setString(4, stu.getStu_name());
            pst.setString(5, stu.getAddress());
            pst.setString(6, stu.getLandline_number());
            pst.setString(7, stu.getMobile_number());
            pst.setString(8, stu.getEmail());
            pst.setString(9, stu.getIntake_year());
            pst.setString(10, stu.getIntake_month());
            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }

    int addResult(UgStudent stu) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_al VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu.getStu_id());
            pst.setString(2, stu.getStream());
            pst.setString(3, stu.getSub1());
            pst.setString(4, stu.getSub2());
            pst.setString(5, stu.getSub3());
            pst.setString(6, stu.getEnglish_result());
            pst.setString(7, stu.getResult1());
            pst.setString(8, stu.getResult2());
            pst.setString(9, stu.getResult3());
            pst.setString(10, stu.getZscore());
            pst.setString(11, stu.getDis_rank());
            pst.setString(12, stu.getIsland_rank());
            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    int addSubjectUgBs(Subject sub) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO subject_ug_bs VALUES (?,?,?,?,?,?,?) ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, sub.getSubject_code());
            pst.setString(2, sub.getSubject_name());
            pst.setInt(3, sub.getSubject_credit());
            pst.setInt(4, sub.getSubject_fee());
            pst.setString(5, sub.getYear());
            pst.setString(6, sub.getSemester());
            pst.setString(7, sub.getSelection());

            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    int addSubjectUgEs(Subject sub) {//add a undergraduate subject of school of Engineering
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO subject_ug_es VALUES (?,?,?,?,?,?) ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, sub.getSubject_code());
            pst.setString(2, sub.getSubject_name());
            pst.setInt(3, sub.getSubject_credit());
            pst.setInt(4, sub.getSubject_fee());
            pst.setString(5, sub.getYear());
            pst.setString(6, sub.getSemester());

            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    String[] getCompulosorySubjectUgBs(String semester, String year) {
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT subject_name from subject_ug_bs WHERE semester=? AND year =? AND selection=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, semester);
            pst.setString(2, year);
            pst.setString(3, "compulsory");
            res = pst.executeQuery();
            String resultArray[] = new String[2];
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
    }

    int setStudentSubjects(StudentSubjects stu) {
        try {
            con=(Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_ug_subjects VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
            pst=(PreparedStatement) con.prepareStatement(query);
            pst.setString(1,stu.getStu_id());
            pst.setString(2,stu.getFaculty());
            pst.setString(3,stu.getSemester());
            pst.setString(4,stu.getYear());
            pst.setString(5,stu.getCom_sub1());
            pst.setString(6,stu.getCom_sub2());
            pst.setString(7,stu.getOpt_sub1());
            pst.setString(8,stu.getOpt_sub2());
            pst.setString(9,stu.getOpt_sub3());
            pst.setString(10,stu.getOpt_sub4());
            pst.setString(11,stu.getOpt_sub5());
            
            pst.executeUpdate();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

}
