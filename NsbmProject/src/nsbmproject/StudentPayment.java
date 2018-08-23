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
public class StudentPayment {

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
     * @return the stu_id
     */
    public String getStu_id() {
        return stu_id;
    }

    /**
     * @param stu_id the stu_id to set
     */
    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }

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
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * @param semester the semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * @return the payment_success
     */
    public String getPayment_success() {
        return payment_success;
    }

    /**
     * @param payment_success the payment_success to set
     */
    public void setPayment_success(String payment_success) {
        this.payment_success = payment_success;
    }
    private String stu_id;
    private String faculty;
    private String year;
    private String semester;
    private String amount;
    private String payment_success;
    private String course_type;
}
