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
public class StudentGradesCal {

    int mark;
    StudentGradesCal(int x){
    this.mark=x;
    }

    String[] StudentGrade() {
        if (mark >= 90) {
            String stuGrade[] = {"A+", "4.25"};
            return stuGrade;
        } else if (mark >= 80) {
            String stuGrade[] = {"A", "4"};
            return stuGrade;
        } else if (mark >= 75) {
            String stuGrade[] = {"A-", "3.75"};
            return stuGrade;
        } else if (mark >= 70) {
            String stuGrade[] = {"B+", "3.25"};
            return stuGrade;
        } else if (mark >= 65) {
            String stuGrade[] = {"B", "3"};
            return stuGrade;
        } else if (mark >= 60) {
            String stuGrade[] = {"B-", "2.75"};
            return stuGrade;
        } else if (mark >= 55) {
            String stuGrade[] = {"C+", "2.25"};
            return stuGrade;
        } else if (mark >= 50) {
            String stuGrade[] = {"C", "2"};
            return stuGrade;
        } else if (mark >= 45) {
            String stuGrade[] = {"C-", "1.75"};
            return stuGrade;
        } else if (mark >= 40) {
            String stuGrade[] = {"D+", "1.25"};
            return stuGrade;
        } else if (mark >= 30) {
            String stuGrade[] = {"D", "1"};
            return stuGrade;
        } else if (mark >= 20) {
            String stuGrade[] = {"D-", "0.75"};
            return stuGrade;
        } else if (mark >= 0) {
            String stuGrade[] = {"E", "0"};
            return stuGrade;
        } else {
            return null;
        }
    }
}
