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
public class EmployeeClass {
    
    private String  EmpId;
    private String  EmpName;
    private int Age;
    private String  Address;
    private String Deparment;
    private String Designation;
    
    
    FileSystem fileSystem = new FileSystem("Employee.txt");
    public EmployeeClass(){}

    public EmployeeClass(String EmpId, String EmpName, int Age, String Address, String Deparment, String Designation) {
        this.EmpId = EmpId;
        this.EmpName = EmpName;
        this.Age = Age;
        this.Address = Address;
        this.Deparment = Deparment;
        this.Designation = Designation;
    }

    public String getEmpId() {
        return EmpId;
    }

    public void setEmpId(String EmpId) {
        this.EmpId = EmpId;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String EmpName) {
        this.EmpName = EmpName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDeparment() {
        return Deparment;
    }

    public void setDeparment(String Deparment) {
        this.Deparment = Deparment;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }
    
    
       public boolean addEmployee() {
        
        if(!fileSystem.create_NewFile())
        {
String record = EmpId + " " + EmpName + " " + Age + " " + Address+" " +
        Deparment+" "+Designation;
System.err.println(EmpId + " " + EmpName + " " + Age + " " + Address+" " +
        Deparment+" "+Designation);
            return fileSystem.writeDataToFile(record);
        }
        return false;
    }
       
       
      public boolean searchEmployee(String keyword) //E001
      {
        boolean isFound = false;   
        try {
            String[] words = null;          
            BufferedReader bufferedReader = fileSystem.readAFile();
            String employee;       
            outerloop:
            while ((employee = bufferedReader.readLine()) != null) 
                
            {              
                words = employee.split(" ");          
                for (String word : words) 
                {
                    if (word.equals(keyword)) 
                    {
                        isFound = true;                      
                        this.setEmpId(words[0]);
                        this.setEmpName(words[1]);
                        this.setAge(Integer.parseInt(words[2]));
                        this.setAddress(words[3]);
                        this.setDeparment(words[4]);
                          this.setDesignation(words[5]);
                        break outerloop;
                    }
                }
            }
        } catch (Exception e) {
             System.err.println("Something went wrong searching Employee" + e);
        } 
        return isFound;
    }
       
    
    
}
