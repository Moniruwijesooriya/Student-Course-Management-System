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
public class StudentAssignmentResult extends StudentResults {

    /**
     * @return the asg_num
     */
    public int getAsg_num() {
        return asg_num;
    }

    /**
     * @param asg_num the asg_num to set
     */
    public void setAsg_num(int asg_num) {
        this.asg_num = asg_num;
    }

    /**
     * @return the asg_marks
     */
    public int getAsg_marks() {
        return asg_marks;
    }

    /**
     * @param asg_marks the asg_marks to set
     */
    public void setAsg_marks(int asg_marks) {
        this.asg_marks = asg_marks;
    }
    private int asg_num;
    private int asg_marks;
}
