/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class Storer {
    //store removed user
    public void storeRemovedUser(String username) throws ClassNotFoundException{
        
           int result = 0;
                    
                    
                       String INSERT_USERS_SQL = "INSERT INTO removeduser" +
                            "  (username) VALUES " +"(?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setString(1,username);
                      
                           
                            
                   
                            
                            System.out.println(preparedStatement);
                            // Step 3: Execute the query or update query0
                            result = preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
             

                   System.out.println(result);
        
       
       
       
       }
    //count removed users
    public void storeRemovedcount(Date date1) throws ClassNotFoundException{
        
           int result = 0;
                    
                    
                       String INSERT_USERS_SQL = "INSERT INTO removed" +
                            "  (date1) VALUES " +"(?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setDate(1,date1);
                      
                           
                            
                   
                            
                            System.out.println(preparedStatement);
                            // Step 3: Execute the query or update query0
                            result = preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
             

                   System.out.println(result);
        
       
       
       
       }
    //store added user count
    public void storeAddedcount(Date date1) throws ClassNotFoundException{
        
           int result = 0;
                    
                    
                       String INSERT_USERS_SQL = "INSERT INTO added" +
                            "  (date1) VALUES " +"(?);";

                    
                        Class.forName("com.mysql.cj.jdbc.Driver");

                        try(
                            Connection connection = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

                            // Step 2:Create a statement using connection object
                            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
                            preparedStatement.setDate(1,date1);
                      
                           
                            
                   
                            
                            System.out.println(preparedStatement);
                            // Step 3: Execute the query or update query0
                            result = preparedStatement.executeUpdate();
                       
                        } catch (SQLException e) {
                            System.out.println(e);
                            
                        }
             

                   System.out.println(result);
        
       
       
       
       }
    
}
