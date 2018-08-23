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
public class CalculateGpa {
    double gpv;
    int subjectCredit;
    double productGpv;
    
    double Gpa(double gpvArray[],int creditArray[]){
        double totalGpvProduct=0;
        int totalCredits=0;
        for(int i=0;i<creditArray.length;i++){
            gpv=gpvArray[i];
            subjectCredit=creditArray[i];
            productGpv=gpv*subjectCredit;
            totalGpvProduct+=productGpv;
            totalCredits+=subjectCredit;
            
        }
        
        double gpa;
        gpa=totalGpvProduct/totalCredits;
        return gpa;
        
    }
}
