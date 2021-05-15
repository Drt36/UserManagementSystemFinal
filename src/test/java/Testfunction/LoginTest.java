/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testfunction;

import Authentication.Validate;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class LoginTest {
    Validate val;
    boolean result1=false;
    boolean result2=false;
    boolean result3=false;
    boolean result4=false;
    boolean result5=false;
    public LoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
        val=new Validate();
    }
    
    @AfterEach
    public void tearDown() {
    }
    @Test
    public void testLogin1(){
        try {
            //test data
            String email="dharmarajthanait25@gmail.com";
            String password="11111111";
            
            result1=val.validateUser(email,password);
           
           assertTrue(result1);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    @Test
      public void testLogin2(){
        try {
            //test data
            String email="dharmarajthanait25@gmail.com";
            String password="111111111111";
            
            result2=val.validateUser(email,password);
           
           assertFalse(result2);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
}
      @Test
      public void testLogin3(){
        try {
            //test data
            String email="";
            String password="";
            
            result3=val.validateUser(email,password);
           
           assertFalse(result3);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
}
      @Test
      public void testLogin4(){
        try {
            //test data
            String email="gdgasg@gmail.com";
            String password="ghvvgdgvhvh";
            
            result4=val.validateUser(email,password);
           
           assertFalse(result4);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
}
      @Test
      public void testLogin5(){
        try {
            //test data
            String email="gdgasg@gmail.com";
            String password="";
            
            result5=val.validateUser(email,password);
           
           assertFalse(result5);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
}
}