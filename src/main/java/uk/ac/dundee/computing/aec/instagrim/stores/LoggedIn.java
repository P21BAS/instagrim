/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.stores;

/**
 *
 * @author Administrator
 */
public class LoggedIn {
    boolean logedin=false;
    String Username=null;
    private String firstname="";
    private String lastname="";
    private String email="";
    public void LogedIn(){
        
    }
    
    public void setUsername(String name){
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
    public void setLogedin(){
        logedin=true;
    }
    public void setLogedout(){
        logedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.logedin=logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }
    
        public void setUserFName(String firstname){
        this.firstname=firstname;
    }
    
    public String getUserFName(){
        return firstname;
    }
    
    public void setUserLName(String lastname){
        this.lastname=lastname;
    }
    
    public String getUserLName(){
        return lastname;
    }
    
     public void setUserEmail(String email){
        this.email=email;
    }
    
    public String getUserEmail(){
        return email;
    }
    
    public void update(String firstname, String lastname, String email){
        setUserFName(firstname);
        setUserLName(lastname);
        setUserEmail(email);
        
    }
}
