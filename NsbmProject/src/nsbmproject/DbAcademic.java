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
public class DbAcademic {

    String url = "jdbc:mysql://localhost:3306/nsbm";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet res = null;

    String[] getStudentUgSubjects(String stu_id, String semester, String year, String fac) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT com_sub1,com_sub2,com_sub3,com_sub4,opt_sub1,opt_sub2 FROM student_ug_subjects WHERE stu_id=? AND faculty=? AND semester=? AND Year=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu_id);
            pst.setString(2, fac);
            pst.setString(3, semester);
            pst.setString(4, year);

            res = pst.executeQuery();

            String subjectArray[] = new String[6];
            while (res.next()) {
                subjectArray[0] = res.getString(1);
                subjectArray[1] = res.getString(2);
                subjectArray[2] = res.getString(3);
                subjectArray[3] = res.getString(4);
                subjectArray[4] = res.getString(5);
                subjectArray[5] = res.getString(6);

            }
            return subjectArray;

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

    int[] getSubjectUgCredit(String subject, String fac) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT credit FROM subject_ug WHERE subject_name=? AND faculty=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, subject);
            pst.setString(2, fac);

            res = pst.executeQuery();

            int subjectCredit[] = new int[1];
            while (res.next()) {
                subjectCredit[0] = res.getInt(1);
            }
            return subjectCredit;

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

    float[] getStudentUgCreditxgpv(String stu_id, String fac) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT creditxgpv FROM student_ug_result WHERE stu_id=? AND faculty=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu_id);
            pst.setString(2, fac);

            res = pst.executeQuery();

            float credit[] = new float[49];
            int i = 0;
            while (res.next()) {
                credit[i] = Float.parseFloat(res.getString(1));
                i++;
            }
            credit[48] = i;
            return credit;

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

    int[] getStudentUgCredit(String stu_id, String fac) { //get credits for subjects for relevant academic period
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT sub_credit FROM student_ug_result WHERE stu_id=? AND faculty=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu_id);
            pst.setString(2, fac);

            res = pst.executeQuery();

            int credit[] = new int[48];
            int i = 0;
            while (res.next()) {
                credit[i] = res.getInt(1);
                i++;
            }
            return credit;

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

    int UpdateStudentGpa(String stu_id, String fac, String gpa, String credits) { // updating the assignmnet results in the database with asg mark and final mark(not exam mark column)
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_ug SET gpa=?,credits=? WHERE stu_id=? AND faculty=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, gpa);
            pst.setString(2, credits);
            pst.setString(3, stu_id);
            pst.setString(4, fac);

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

    int AddVenue(Venue v) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO university_halls VALUES (?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, v.getFaculty());
            pst.setString(2, v.getVenue());
            pst.setString(3, v.getType());

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

    ArrayList<AcademicStaff> getTeachingAllocationUg(String post, String type, String fac) {

        try {
            ArrayList<AcademicStaff> subAllocation = new ArrayList<AcademicStaff>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT subject_code,subject,name,year,semester,day,venue,time FROM academic_staff_subjects WHERE post=? AND course_type=? AND faculty=?";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareCall(query);
            pst.setString(1, post);
            pst.setString(2, type);
            pst.setString(3, fac);

            res = pst.executeQuery();

            while (res.next()) {
                AcademicStaff stf = new AcademicStaff();
                stf.setSubject_code(res.getString(1));
                stf.setSubject(res.getString(2));
                stf.setName(res.getString(3));
                stf.setYear(res.getString(4));
                stf.setSemester(res.getString(5));
                stf.setDay(res.getString(6));
                stf.setVenue(res.getString(7));
                stf.setTime(res.getString(8));
                subAllocation.add(stf);

            }
            return subAllocation;
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

    ArrayList<Student> getStudentSemNYear(String year, String fac, String intak,String course_tp) {

        try {
            ArrayList<Student> students = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT stu_id FROM student_ug WHERE intake_month=? AND cur_year=? AND faculty=? AND course_type=? ";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareCall(query);
            pst.setString(1, intak);
            pst.setString(2, year);
            pst.setString(3, fac);
            pst.setString(4, course_tp);

            res = pst.executeQuery();

            while (res.next()) {
                Student stu = new Student();
                stu.setStu_id(res.getString(1));

                students.add(stu);

            }
            return students;
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

    int addAcademicYearNSem(AcademicSemNYear acs) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO academic_sem_year VALUES (?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, acs.getFaculty());
            pst.setString(2, acs.getCourse_type());
            pst.setString(3, acs.getCur_year());
            pst.setString(4, acs.getCur_semester());
            pst.setString(5, acs.getIntake());

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

    int UpdateAcademicYearNSem(AcademicSemNYear acs) { // updating the student next semester and year
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE academic_sem_year SET cur_semester=? WHERE faculty=? AND cur_year=? AND intake=? AND course_type=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, acs.getCur_semester());
            pst.setString(2, acs.getFaculty());
            pst.setString(3, acs.getCur_year());
            pst.setString(4, acs.getIntake());
            pst.setString(5, acs.getCourse_type());

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

    String[] getAcademicSemNYear(String year, String fac,String course_tp) {

        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT cur_semester FROM academic_sem_year WHERE cur_year=? AND faculty=? AND course_type=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, year);
            pst.setString(2, fac);
            pst.setString(3, course_tp);
            res = pst.executeQuery();

            String array[] = new String[1];
            while (res.next()) {
                array[0] = res.getString(1);

            }
            //System.out.println("DbAcademic / line 260++ "+array[0]);
            return array;
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

    int UpdateStudentSemNYear(Student stu) { // updating the student next semester and year
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_ug SET cur_year=?,cur_semester=? WHERE stu_id=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, stu.getCur_year());
            pst.setString(2, stu.getCur_semester());
            pst.setString(3, stu.getStu_id());

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

    ArrayList<Student> getStudentsOrderedByGpa(String fac, String intak,String course_tp) {

        try {
            ArrayList<Student> students = new ArrayList<Student>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT stu_id FROM student_ug WHERE intake_month=? AND cur_year=? AND faculty=? AND course_type=? ORDER BY gpa DESC  ";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareCall(query);
            pst.setString(1, intak);
            pst.setString(2, "2");
            pst.setString(3, fac);
            pst.setString(4, course_tp);

            res = pst.executeQuery();

            while (res.next()) {
                Student stu = new Student();
                stu.setStu_id(res.getString(1));

                students.add(stu);

            }
            return students;
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
    
    ArrayList<StudentPayment> getPayments(String fac,String course_tp) {

        try {
            ArrayList<StudentPayment> payments= new ArrayList<StudentPayment>();
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT stu_id,year,semester,amount FROM student_ug_payment WHERE faculty=? AND course_type=? ";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareCall(query);
            pst.setString(1, fac);
            pst.setString(2, course_tp);

            res = pst.executeQuery();

            while (res.next()) {
                StudentPayment stu = new StudentPayment();
                stu.setStu_id(res.getString(1));
                stu.setSemester(res.getString(2));
                stu.setYear(res.getString(3));
                stu.setAmount(res.getString(4));
                
                payments.add(stu);

            }
            return payments;
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

    int updateFourthYears(String fourthYears) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_ug SET fourth_year=? WHERE stu_id=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,"Yes");
            pst.setString(2,fourthYears);

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

    int[] getStudentUgSubjectFee(String subject, String facult) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT subject_fee FROM subject_ug WHERE subject_name=? AND faculty=?";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, subject);
            pst.setString(2, facult);

            res = pst.executeQuery();

            int resArray[] = new int[1];
            while (res.next()) {
                resArray[0] = res.getInt(1);

            }
            return resArray;

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

    int setStudentPaymentUg(StudentPayment sp) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO student_ug_payment VALUES (?,?,?,?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, sp.getStu_id());
            pst.setString(2, sp.getFaculty());
            pst.setString(3, sp.getYear());
            pst.setString(4, sp.getSemester());
            pst.setString(5, sp.getAmount());
            pst.setString(6, sp.getPayment_success());
            pst.setString(7, sp.getCourse_type());

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
    
    String[] getStudentOptSub(String stuID, String year, String semester) {
        try {

            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT opt_sub1,opt_sub2 from student_ug_subjects WHERE semester=? AND year =? AND stu_id=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, semester);
            pst.setString(2, year);
            pst.setString(3, stuID);
            res = pst.executeQuery();
            String resultArray[] = new String[2];

            while (res.next()) {
                resultArray[0] = res.getString(1);
                resultArray[1] = res.getString(2);

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
    
    int updateStudentSubjects(String stu_id,String sub1,String sub2,String year,String semester) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE student_ug_subjects SET opt_sub1=?,opt_sub2=? WHERE stu_id=? AND year=? AND semester=? ";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1,sub1);
            pst.setString(2,sub2);
            pst.setString(3,stu_id);
            pst.setString(4,year);
            pst.setString(5,semester);

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
    
    

}
