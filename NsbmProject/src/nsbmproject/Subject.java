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
public class Subject {

    /**
     * @return the selection
     */
    public String getSelection() {
        return selection;
    }

    /**
     * @param selection the selection to set
     */
    public void setSelection(String selection) {
        this.selection = selection;
    }
    
    /**
     * @return the subject_code
     */
    public String getSubject_code() {
        return subject_code;
    }

    /**
     * @param subject_code the subject_code to set
     */
    public void setSubject_code(String subject_code) {
        this.subject_code = subject_code;
    }

    /**
     * @return the subject_name
     */
    public String getSubject_name() {
        return subject_name;
    }

    /**
     * @param subject_name the subject_name to set
     */
    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    /**
     * @return the subject_credit
     */
    public int getSubject_credit() {
        return subject_credit;
    }

    /**
     * @param subject_credit the subject_credit to set
     */
    public void setSubject_credit(int subject_credit) {
        this.subject_credit = subject_credit;
    }

    /**
     * @return the subject_fee
     */
    public int getSubject_fee() {
        return subject_fee;
    }

    /**
     * @param subject_fee the subject_fee to set
     */
    public void setSubject_fee(int subject_fee) {
        this.subject_fee = subject_fee;
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
    private String subject_code;
    private String subject_name;
    private int subject_credit;
    private int subject_fee;
    private String semester;
    private String year;
    private String selection;
    
}
