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
public class StudentExamResult extends StudentResults{

    /**
     * @return the sub_credit
     */
    public int getSub_credit() {
        return sub_credit;
    }

    /**
     * @param sub_credit the sub_credit to set
     */
    public void setSub_credit(int sub_credit) {
        this.sub_credit = sub_credit;
    }

    /**
     * @return the creditxgpv
     */
    public String getCreditxgpv() {
        return creditxgpv;
    }

    /**
     * @param creditxgpv the creditxgpv to set
     */
    public void setCreditxgpv(String creditxgpv) {
        this.creditxgpv = creditxgpv;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the gpv
     */
    public String getGpv() {
        return gpv;
    }

    /**
     * @param gpv the gpv to set
     */
    public void setGpv(String gpv) {
        this.gpv = gpv;
    }

    /**
     * @return the asg_mark
     */
    public int getAsg_mark() {
        return asg_mark;
    }

    /**
     * @param asg_mark the asg_mark to set
     */
    public void setAsg_mark(int asg_mark) {
        this.asg_mark = asg_mark;
    }

    /**
     * @return the exam_mark
     */
    public int getExam_mark() {
        return exam_mark;
    }

    /**
     * @param exam_mark the exam_mark to set
     */
    public void setExam_mark(int exam_mark) {
        this.exam_mark = exam_mark;
    }

    /**
     * @return the final_mark
     */
    public int getFinal_mark() {
        return final_mark;
    }

    /**
     * @param final_mark the final_mark to set
     */
    public void setFinal_mark(int final_mark) {
        this.final_mark = final_mark;
    }

   

    private int asg_mark,exam_mark,final_mark;
    private String grade;
    private String gpv;
    private String creditxgpv;
    private int sub_credit;
            
}
