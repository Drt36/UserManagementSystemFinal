/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.connection;

import User.Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class Action {
    //Delete user through admin
    public void deleteUser(String username) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from users where username = ?  ")) {
            preparedStatement.setString(1,username);
          
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
    }
    
    //select a user
    public static User getUser(String username) throws ClassNotFoundException, SQLException {  
        User user=null;  
        
        try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from users where username = ?  ")) {
            preparedStatement.setString(1,username);
            
            ResultSet rs=preparedStatement.executeQuery();  
             
            if(rs.next()){  
                user=new User();  
                user.setUsername(rs.getString("username"));
                user.setFirst_name(rs.getString("first_name"));  
                user.setLast_name(rs.getString("last_name"));  
                user.setEmail(rs.getString("email"));  
                user.setIs_admin(rs.getBoolean("is_admin"));  
                user.setPhone_number(rs.getString("phone_number")); 
                user.setAddress(rs.getString("address"));
                user.setBirthdate(rs.getString("birthdate"));
                user.setGender(rs.getString("gender"));
            }  
        
        }catch(Exception ex){ex.printStackTrace();}  
          
        return user;  
    }  
    
     //update the user details
     public void updateUser(String username,String first_name,String last_name,boolean is_admin,String phone_number,String address,String birthdate,String gender) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Update users set first_name = ?,last_name=?, is_admin=? ,phone_number=?,address=?,birthdate=?,gender=? where username= ? ")) {
            preparedStatement.setString(1,first_name);
            preparedStatement.setString(2,last_name);
            preparedStatement.setBoolean(3,is_admin);
            preparedStatement.setString(4,phone_number);
            preparedStatement.setString(5,address);
            preparedStatement.setString(6,birthdate);
            preparedStatement.setString(7,gender);
            preparedStatement.setString(8,username);
           

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
         
    }
     
     
     
     
     //Delete history
    public void deleteHistory(String useremail) throws ClassNotFoundException, SQLException {
        
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from history where email= ?  ")) {
            preparedStatement.setString(1,useremail);
          
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
    }
    }
    
