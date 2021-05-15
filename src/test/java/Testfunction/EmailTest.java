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
public class EmailTest {
    Validate val;
    boolean result11=false;
    boolean result22=false;
    boolean result33=false;
    public EmailTest() {
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
    public void testEmail1(){
        try {
            //data set
            String email="dharmarajthanait25@gmail.com";
           result11=val.validateEmail(email);
            assertTrue(result11);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }
    @Test
    public void testEmail2(){
        try {
            //data set
            String email=" ";
           result22=val.validateEmail(email);
            assertFalse(result22);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }
    @Test
    public void testEmail3(){
        try {
            //data set
            String email="vcxzcxvvz";
           result33=val.validateEmail(email);
            assertFalse(result33);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }
}
