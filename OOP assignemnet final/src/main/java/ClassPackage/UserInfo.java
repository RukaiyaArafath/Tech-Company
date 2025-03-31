/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPackage;

import java.io.BufferedReader;
/**
 *
 * @author User
 */
public class UserInfo {
    
      
private String UserName;
private String Password;
private String JobRole;


FileSystem fileSystem = new FileSystem("NewUser.txt");

    public UserInfo(String UserName, String Password, String JobRole) {
        this.UserName = UserName;
        this.Password = Password;
        this.JobRole = JobRole;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getJobRole() {
        return JobRole;
    }

    public void setJobRole(String JobRole) {
        this.JobRole = JobRole;
    }
 public boolean addNewUser()
 {
        if(!fileSystem.create_NewFile()){
            String record = UserName + " " + Password+ " " + JobRole ;   
                            
            return fileSystem.writeDataToFile(record);
        }
        return false;
    }
 

    public boolean validateLogin() {
        try {
            String[] words = null;
            
            BufferedReader bufferedReader = fileSystem.readAFile();
            String user;
            while ((user = bufferedReader.readLine()) != null) {              
                words = user.split(" ");
                if (words[0].equals(UserName) && words[1].equals(Password) && words[2].equals(JobRole))
                {
                    this.setUserName(words[0]);
                    this.setPassword(words[1]);
                    this.setJobRole(words[2]);
                    return true;
                }
            }
        } catch (Exception e) {
       System.err.println("Something went wrong validating login" + e);
       return false;
        }      
        return false;
    }

    
}
