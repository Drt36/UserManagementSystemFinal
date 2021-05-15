/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User.Model;

/**
 *
 * @author HP Omen 15-dc0079tx
 */
public class User {
    String username;
    String first_name;
    String last_name;
    String email;
    public boolean is_admin;
    String phone_number;
    String address;
    String birthdate;
    String gender;
    String password1;

    public User(String username,String first_name, String last_name, String email, boolean is_admin, String phone_number, String address, String birthdate, String gender) {
       this.username=username;
       this.first_name=first_name;
       this.last_name=last_name;
       this.email=email;
       this.is_admin=is_admin;
       this.phone_number=phone_number;
       this.address=address;
       this.birthdate=birthdate;
       this.gender=gender;
    }

    public User() {
        
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

 
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    
    
}
