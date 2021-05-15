/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import otherfunction.Hashing;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class Validate {
    boolean status = false;
       Hashing hash=new Hashing();
       
        boolean status1=false;
        boolean status2=false;
        
        //validate email exist or not in database
        public boolean validateEmail(String useremail) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ? ")) {
            preparedStatement.setString(1,useremail);
            

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status2 = rs.next();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return status2;
    }
         //validate username exist or not in database
     public boolean validateUsername(String username) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where username = ? ")) {
            preparedStatement.setString(1,username);
            

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status1 = rs.next();

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return status1;
    }
    
     //validate email and password for login  to give access in system
    public boolean validateUser(String email,String password) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ? and password1 = ? ")) {
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,hash.getMd5(password));
            ResultSet rs = preparedStatement.executeQuery(); 
            status = rs.next();
        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        }
        return status;
    }

    
}
