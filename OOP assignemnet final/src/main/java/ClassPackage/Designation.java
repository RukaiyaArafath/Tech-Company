/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPackage;

/**
 *
 * @author User
 */
public class Designation {
    
   
            private String DesignationName;
    private String DesignationId;
    FileSystem fileSystem = new FileSystem("Desigantion.txt");

        public Designation(String DesignationName, String DesignationId) {
            this.DesignationName = DesignationName;
            this.DesignationId = DesignationId;
        }

        public String getDesignationName() {
            return DesignationName;
        }

        public void setDesignationName(String DesignationName) {
            this.DesignationName = DesignationName;
        }

        public String getDesignationId() {
            return DesignationId;
        }

        public void setDesignationId(String DesignationId) {
            this.DesignationId = DesignationId;
        }
    
    
       public boolean addDesignation() {
        
        if(!fileSystem.create_NewFile())
        {
String record = DesignationId+" "+DesignationName;
System.err.println(DesignationId + " " + DesignationName );
            return fileSystem.writeDataToFile(record);
        }
        return false;
    }
       
}
