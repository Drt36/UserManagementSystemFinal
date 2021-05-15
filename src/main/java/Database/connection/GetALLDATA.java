/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.connection;

import User.Model.History;
import User.Model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class GetALLDATA {
    
    public User getAllDataofuser(String useremail)throws ClassNotFoundException, SQLException {
         User user=null;
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where  email= ? ")) {
            preparedStatement.setString(1,useremail);
            

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
             while (rs.next()) {
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

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return user;
    }
    
    
    //list all user
        public List < User > selectAllUsers() {

            // using try-with-resources to avoid closing resources (boiler plate code)
            List < User > users = new ArrayList < > ();
            // Step 1: Establishing a Connection
            try(Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("select * from users ")) {



                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                  while (rs.next()) {
                    
                    String username= rs.getString("username");
                    String first_name = rs.getString("first_name");
                    String last_name = rs.getString("last_name");
                    String email = rs.getString("email");
                    boolean is_admin=rs.getBoolean("is_admin");
                    String phone_number=rs.getString("phone_number");
                    String address= rs.getString("address");
                    String birthdate= rs.getString("birthdate");
                    String gender= rs.getString("gender");
                    users.add(new User(username,first_name,last_name, email,is_admin,phone_number,address,birthdate,gender));
                }

            } catch (SQLException e) {
                // process sql exception
                System.out.println(e);
            }

            return users;
    }
    
    //getting history
    public List<History> getHistory(String useremail)throws ClassNotFoundException, SQLException {
      
            List < History > history= new ArrayList < > ();

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select * from history where  email= ? ")) {
            preparedStatement.setString(1,useremail);
            

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
              while (rs.next()) {
                    String email= rs.getString("email");
                    String task= rs.getString("task");
                    String time1 = rs.getString("time1");
                    history.add(new History(email,task,time1));
                }


        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return history;
    }
    
}
