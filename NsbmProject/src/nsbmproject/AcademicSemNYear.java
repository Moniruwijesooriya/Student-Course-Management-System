/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbmproject;

/**
 *
 * @author MONIRU CMY
 */
public class AcademicSemNYear {

    /**
     * @return the faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the course_type
     */
    public String getCourse_type() {
        return course_type;
    }

    /**
     * @param course_type the course_type to set
     */
    public void setCourse_type(String course_type) {
        this.course_type = course_type;
    }

    /**
     * @return the cur_year
     */
    public String getCur_year() {
        return cur_year;
    }

    /**
     * @param cur_year the cur_year to set
     */
    public void setCur_year(String cur_year) {
        this.cur_year = cur_year;
    }

    /**
     * @return the cur_semester
     */
    public String getCur_semester() {
        return cur_semester;
    }

    /**
     * @param cur_semester the cur_semester to set
     */
    public void setCur_semester(String cur_semester) {
        this.cur_semester = cur_semester;
    }

    /**
     * @return the intake
     */
    public String getIntake() {
        return intake;
    }

    /**
     * @param intake the intake to set
     */
    public void setIntake(String intake) {
        this.intake = intake;
    }
    private String faculty;
    private String course_type;
    private String cur_year;
    private String cur_semester;
    private String intake;
}
