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
public class UsernameTest {
    Validate val;
    boolean result111=false;
    boolean result222=false;
    boolean result333=false;
    
    public UsernameTest() {
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
    public void testUsername1(){
        try {
            //data set
            String username="dharmarajthanait25";
           result111=val.validateUsername(username);
            assertTrue(result111);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
     @Test
    public void testUsername2(){
        try {
            //data set
            String username=" ";
           result222=val.validateUsername(username);
            assertFalse(result222);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
     @Test
    public void testUsername3(){
        try {
            //data set
            String username="sdszgxdhfxhxfghf ";
           result333=val.validateUsername(username);
            assertFalse(result333);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EmailTest.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }
}
