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
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class EmailSending {
    String faculty;

    int sendResults(EmailCenter ecr) {
        String host = "smtp.gmail.com";
        final String user = "nsbmuniversity@gmail.com"; //university email
        final String password = "javansbm123";

        String to =ecr.getEmail();//email of the student
        String header="NSBM Green University";
        faculty=ecr.getFaculty();
        
        String year=ecr.getYear();
        String semester=ecr.getSemester();
        String studentID=ecr.getStu_id();
        String studentName=ecr.getStu_name();
        String resultSheet=ecr.getSub1()+":\t\t"+ecr.getMark1()+"\n"+ecr.getSub2()+":\t\t"+ecr.getMark2()+"\n"+ecr.getSub3()+":\t\t"+ecr.getMark3()+"\n"+ecr.getSub4()+":\t\t"+ecr.getMark4()+"\n"+ecr.getSub5()+":\t\t"+ecr.getMark5()+"\n"+ecr.getSub6()+":\t\t"+ecr.getMark6();
        String emailbody = header+"\n\n" +faculty+"\n\n"+"Examination Results"+"\n\nYear:\t"+year+"\nSemester:\t"+semester+"\nStudent ID:\t"+studentID+"\nStudent Name:\t"+studentName+"\n\n\n"+resultSheet+"\n\n\tThank You!" ;

        Properties propert = new Properties();
        propert.put("mail.smtp.host", host);
        propert.put("mail.smtp.auth", "true");
        propert.put("mail.smtp.starttls.enable", "true");
        propert.put("mail.smtp.socketFactory.port", "465");
        propert.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(propert, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        //message composing  
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Examination Marks");
            message.setText(emailbody);

            Transport.send(message);

            System.out.println("Email sent successfully!");
            return 1;
        } catch (MessagingException e) {
            e.printStackTrace();
            return 0;

        }

    }

}
