/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import uk.ac.dundee.computing.aec.instagrim.lib.AeSimpleSHA1;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;

/**
 *
 * @author Administrator
 */
public class User {
    Cluster cluster;
    public User(){
        
    }
    
    public boolean RegisterUser(String firstname, String lastname, String username, String Password,String dateofbirth, String email){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
       if(Password.length() < 8 ){
            System.out.println("Please enter a password with at least 8 characters");
            return false;
      }else{
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("insert into userprofiles (login, password, first_name, last_name, dateofbirth, email) Values(?,?,?,?,?,?)");
       
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username,EncodedPassword,firstname, lastname, dateofbirth, email));
        //We are assuming this always works.  Also a transaction would be good here !
        return true;
       }
   
    }
    public boolean IsValidUser(String firstname, String lastname, String username, String Password,String dateofbirth, String email){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select password from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No Images returned");
            return false;
        } else {
            for (Row row : rs) {
               
                String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
            }
        }
   
    
    return false;  
    }
    
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }
       
       public java.util.UUID selectProfilePic(String username){
           
        java.util.UUID picid=null;
                
             Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select profilepic from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No Images returned");
         
        } else {
            for (Row row : rs) {
               
                picid = row.getUUID("profilepic");
               
            }
          
       }

     return picid;

       }
       
       public String UserFname(String username){
           
        String fname="";
                
             Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select first_name from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No First Name Returned");
         
        } else {
            for (Row row : rs) {
               
                fname = row.getString("first_name");
               
            }
          
       }

    return fname;

       }   
       
       public String UserLname(String username){
           
        String lname="";
                
             Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select last_name from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No First Name Returned");
         
        } else {
            for (Row row : rs) {
               
                lname = row.getString("last_name");
               
            }
          
       }

    return lname;

       }   
       public String UserEmail(String username){
           
        String emailid="";
                
             Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select email from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No First Name Returned");
         
        } else {
            for (Row row : rs) {
               
                emailid = row.getString("email");
               
            }
          
       }

    return emailid;

       }   
       
       
     public void UpdateUser(String username, String first_name, String last_name,String email, String password){
         Session session = cluster.connect("instagrim");
         PreparedStatement ps = session.prepare("Update userprofiles SET first_name =?, last_name =?, email =? where login =?");
         
         BoundStatement boundStatement = new BoundStatement(ps);
         session.execute(
         boundStatement.bind(
         first_name, last_name, email, username));
   }
 
      public boolean checkforexistinguser(String username){
           
        
                
             Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select login from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("user does not already exist");
            return false;
        } else {
            for (Row row : rs) {
                if(username == row.getString("login"))
               return true;
            }
          
       }

    return false;
       }
       
}