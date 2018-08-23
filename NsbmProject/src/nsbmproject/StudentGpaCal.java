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
import java.text.DecimalFormat;

public class StudentGpaCal {

    float gpv;
    float gpa;
    float sum = 0; // the sum of the gpv and the credit product
    int totalCredits = 0;

    String[] gpacal(String stu_id,String fac) {
        String str_array[] = new String[2];
        DbAcademic dba = new DbAcademic();
        float creditxgpv[] = dba.getStudentUgCreditxgpv(stu_id, fac);
        int k = (int) creditxgpv[48];
        for (int i = 0; i < k; i++) {
            sum += creditxgpv[i];
        }
        int credit[] = dba.getStudentUgCredit(stu_id, fac);
        for (int i = 0; i < k; i++) {
            totalCredits += credit[i];
        }
        gpa = sum / totalCredits;
        DecimalFormat df = new DecimalFormat(".####");
        String strgpa = df.format(gpa);
        str_array[0] = strgpa;
        str_array[1] = Integer.toString(totalCredits);
        return str_array;
    }
}
