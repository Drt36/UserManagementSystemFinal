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
public class History {
    String email;
    String task;
    String time1;

    public History(String email, String task, String time1) {
        this.email=email;
        this.task=task;
        this.time1=time1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }
    
    
}
