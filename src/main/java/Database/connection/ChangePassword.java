/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.connection;

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
public class ChangePassword {
    boolean status=false;
    Hashing hash=new Hashing();
     //saving sent code in database
    public void saveCode(String useremail,String code) throws ClassNotFoundException{
           int result = 0;
                   
                    
                       String INSERT_USERS_SQL = "INSERT INTO resetsupport" +
                            "  (email,code) VALUES " +"(?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,useremail);
                            preparedStatement.setString(2,code);
                            
                            
                   
                            
                            System.out.println(preparedStatement);
                            // Step 3: update query
                            result = preparedStatement.executeUpdate();
                            
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
             

                   System.out.println(result);
        
       
       
       
       }
    
       //validate  entered code and database code
       public boolean validateCode(String useremail,String code) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from resetsupport where email = ? and code= ? ")) {
            preparedStatement.setString(1,useremail);
            preparedStatement.setString(2,code);
            ResultSet rs = preparedStatement.executeQuery(); 
            status = rs.next();
        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return status;
    }
       
       //seleting code from database
       public void deleteCode(String useremail) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from resetsupport where email = ?  ")) {
            preparedStatement.setString(1,useremail);
          
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        
    }
       
       
       
       
    
    
    //changing password 
    public void changeManually(String useremail,String password) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update users set password1 = ? where email= ? ")) {
            preparedStatement.setString(1,hash.getMd5(password));
            preparedStatement.setString(2,useremail);
           

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
    
}
