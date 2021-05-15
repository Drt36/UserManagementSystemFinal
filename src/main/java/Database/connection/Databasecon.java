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
import java.sql.SQLException;
import otherfunction.EmailSender;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class Databasecon {
    public void registerUserTest(User user) throws ClassNotFoundException{
           int result = 0;
                 
                    
                       String INSERT_USERS_SQL = "INSERT INTO users" +
                            "  (username,first_name,last_name,email,is_admin,phone_number,address,birthdate,gender,password1) VALUES " +"(?,?,?,?,?,?,?,?,?,?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,user.getUsername());
                            preparedStatement.setString(2,user.getFirst_name());
                            preparedStatement.setString(3,user.getLast_name());
                            preparedStatement.setString(4,user.getEmail());
                            preparedStatement.setBoolean(5,user.isIs_admin());
                            preparedStatement.setString(6,user.getPhone_number());
                            preparedStatement.setString(7,user.getAddress());
                            preparedStatement.setString(8,user.getBirthdate());
                            preparedStatement.setString(9,user.getGender());
                            preparedStatement.setString(10,user.getPassword1());
                            
                   
                            
                            System.out.println(preparedStatement);
                            // Step 3: Execute the query or update query0
                            result = preparedStatement.executeUpdate();
                            //sending welcome email
                             EmailSender es=new EmailSender();
                            es.welcomeEmailSender(user.getEmail(),user.getFirst_name());
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
             

                   System.out.println(result);
        
       
       
       
       }
    
}
