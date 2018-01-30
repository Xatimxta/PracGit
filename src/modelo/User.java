/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author RenzoHypeBeast
 */
public class User {
    private String username;
    private String password;
    private int stucoins;
    private int level;
    private String place;
    private int points;
    ArrayList<Contact> usercontact;
    ArrayList<Inventory> userinventory;

    public User(String username, String password, String place) {
        this.username = username;
        this.password = password;
        this.stucoins = 100;
        this.level = 0;
        this.place = place;
        this.points = 0;
        usercontact = new ArrayList<>();
        userinventory = new ArrayList<>();
    }
    
    public User() {
    }

    public User(String username) {
        this.username = username;
    }
    
    

    public ArrayList<Contact> getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(ArrayList<Contact> usercontact) {
        this.usercontact = usercontact;
    }

    public ArrayList<Inventory> getUserinventory() {
        return userinventory;
    }

    public void setUserinventory(ArrayList<Inventory> userinventory) {
        this.userinventory = userinventory;
    }  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStucoins() {
        return stucoins;
    }

    public void setStucoins(int stucoins) {
        this.stucoins = stucoins;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }   

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", stucoins=" + stucoins + ", level=" + level + ", place=" + place + ", points=" + points + ", usercontact=" + usercontact + ", userinventory=" + userinventory + '}';
    }
    
    
}
