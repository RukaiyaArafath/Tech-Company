/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPackage;

/**
 *
 * @author User
 */
public class roledesig {

   private String DepartmentId;
    private String DepartmentName;
    
    FileSystem fileSystem = new FileSystem("Department.txt");

    public roledesig(String DepartmentId, String DepartmentName) {
        this.DepartmentId = DepartmentId;
        this.DepartmentName = DepartmentName;
    }

    public String getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(String DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }
  
    
       public boolean addDepartment() {
        
        if(!fileSystem.create_NewFile())
        {
String record = DepartmentName+" /"+DepartmentId;
System.err.println(DepartmentId + "/ " + DepartmentName );
            return fileSystem.writeDataToFile(record);
        }
        return false;
    }
}
