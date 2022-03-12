/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sait.lab6.models;

import java.io.Serializable;

/**
 *
 * @author peony
 * User Table
 */
public class User implements Serializable {
    private String email;
    private boolean active;
    private String fname;
    private String lname;
    private String pass;
    private Role role;
    
    
    public User(){
        
    }
    
    public User( String email, boolean active,String fname,String lname,String pass,Role role){
        
        this.email =email;
        this.active =active;
        this.fname =fname;
        this.lname=lname;
        this.pass =pass;
        this.role =role;
        
    }

    public User(String email, boolean active, String fname, String lname, String pass, int roleId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPass() {
        return pass;
    }

    public Role getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    
}
