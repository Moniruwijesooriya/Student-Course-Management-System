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

/**
 *
 * @author MONIRU CMY
 */
public class Dbos {

    String url = "jdbc:mysql://localhost:3306/nsbm";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet res = null;

    boolean addUser(User usr) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "INSERT INTO user VALUES (?,?,?,?)";
            pst = (PreparedStatement) con.prepareStatement(query);
            pst.setString(1, usr.getName());
            pst.setString(2, usr.getUsername());
            pst.setString(3, usr.getEmail());
            pst.setString(4, usr.getPassword());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.print(e);
            return false;
        }

    }

    int checkUsername(String username) {
        try {
            con = (Connection) DriverManager.getConnection(url, this.username, password);
            String query = "SELECT username from user";
            pst = (PreparedStatement) con.prepareStatement(query);
            res = pst.executeQuery();

            while (res.next()) {
                if (username.equals(res.getString(1))) {
                    return 0;
                }
            }

            return 1;

        } catch (Exception e) {
            System.out.print(e);
            return 2;
        }
    }

    int login(String usernm, String passwd) {
        try {
            con = (Connection) DriverManager.getConnection(url, this.username, this.password);
            Dbos db = new Dbos();
            int x = db.checkUsername(usernm);
            if (x == 0) {
                String query = "SELECT password from user WHERE username='" + usernm + "'";
                
                pst = (PreparedStatement) con.prepareStatement(query);
                res = pst.executeQuery();
                while(res.next()){
                    String pswd = res.getString(1);
                if (passwd.equals(pswd)) {
                    return 1;
                } else {
                    return 2;
                }
                }
            } else if (x == 1) {
                return 3;
            } else if (x == 2) {
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e);
            return 9;
        }
        return 8;
    }

}
