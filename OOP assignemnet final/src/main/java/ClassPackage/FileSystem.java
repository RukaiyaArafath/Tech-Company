/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClassPackage;

import java.io.*;

/**
 *
 * @author User
 */
public class FileSystem {
    
     private static String FILE_PATH = "D:\\Desktop\\file";

    File file;
    private String fileName;
    
    public FileSystem(String fileName)
    {
        this.fileName = fileName;  
        create_NewFile();
    }
    public boolean create_NewFile() {
        try {
            file = new File(FILE_PATH + fileName);
            if (file.createNewFile()){
                System.out.println("File Created: " + file.getName());
                return true;
            }   
            else
            {
            System.out.println("File Already Exisit !");
            return false;
            }
        } catch(IOException e) {
            System.err.println("Something went wrong with creating file" + e);
            return false;
        }
    }
    
     public boolean writeDataToFile(String record) 
     {
        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(record);
            bufferedWriter.newLine();
            bufferedWriter.close();
            fileWriter.close();

            return true;
        } catch (IOException e) {
            System.err.println("Something went wrong with writing" + e);
            return false;
        }
    }
    
     public BufferedReader readAFile() {
        if(!create_NewFile())
        {
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                return bufferedReader;
            } catch (IOException e) {
                System.err.println("Something went wrong with Reading the file" + e);
            }
        }     
        return null;
    }
}


