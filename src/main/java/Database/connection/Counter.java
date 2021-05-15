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

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class Counter {
    int totaluser=0;
    int removedusers=0;
    int removedcount=0;
    int  addedcount=0;
    int logincount=0;
    int activitycount=0;
    //count total users
    public int countTotalUser()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(user_id)AS totaluser from users ")) {
         

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
           totaluser = rs.getInt("totaluser");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return totaluser;
    }
    
    //count removed users
    
     public int countBlockedUser()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(remove_id)AS removeduser from removeduser ")) {
         

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            removedusers = rs.getInt("removeduser");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return removedusers;
    }
     //count login
      public int countLogin(String email)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(history_id) AS logincount from history where email= ? and task=? ")) {
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,"Login into System");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            logincount = rs.getInt("logincount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return logincount;
    }
    
      //count total activity
      public int countActivity(String email)throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(history_id) AS activitycount from history where email= ?" )) {
            preparedStatement.setString(1,email);
           
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            activitycount = rs.getInt("activitycount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return activitycount;
    }
      
      //count removed users in date range
     public int countRemovedInDaterange()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(remove_id)AS removedcount from removed where date1 between '2020-01-01' AND '2020-12-31'")){
         

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            removedcount = rs.getInt("removedcount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return removedcount;
    }
     //count removed users in date range
     public int countRemovedInDaterange1()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(remove_id)AS removedcount from removed where date1 between '2021-01-01' AND '2021-12-31'")){
         

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            removedcount = rs.getInt("removedcount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return removedcount;
    }
     
    //count added users in date range
    public int countaddedInDaterange()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(add_id)AS addedcount from added where date1 between '2020-01-01' AND '2020-12-31'")){
         

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            addedcount = rs.getInt("addedcount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return addedcount;
    }
    //count added users in date range
    public int countaddedInDaterange1()throws ClassNotFoundException, SQLException {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            try(Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/umscw", "root", "");

            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement("select COUNT(add_id)AS addedcount from added where date1 between '2021-01-01' AND '2021-12-31'")){
         

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            addedcount = rs.getInt("addedcount");

        } catch (SQLException e) {
            // process sql exception
            System.out.println(e);
        }
        return addedcount;
    }
    
    
}
