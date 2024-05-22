
import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Function_File {
    
    GUI gui;
    String fileName, fileAddress;
    
    public Function_File(GUI gui){
        this.gui= gui;
    }
    
    public void newFile(){
        // create new file
        gui.textArea.setText("");
        gui.window.setTitle("New");
        fileName = null;
        fileAddress =  null;
    }
    
    public void open(){
        // open file
        FileDialog fd = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fd.setVisible(true);
        
        if(fd.getFile()!=null){
            fileName = fd.getFile();
            fileAddress =fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        
        //read file
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(fileAddress+ fileName)); // need address to read file
            gui.textArea.setText("");
            
            String line = null;
            
            //read line by line
            while((line = br.readLine()) != null){
                gui.textArea.append(line+ "\n");  //.apppends the given text to the end of the documet
            }
           br.close();
           
        } catch (Exception e) {
            System.out.println("File not opend!");
        }
      
    }
    
    public void save(){
        //save
        if(fileName == null){
        
            saveAs();
        }else{
        
            try {
                
                FileWriter fw = new FileWriter(fileAddress+ fileName);
                fw.write(gui.textArea.getText());
                fw.close();
                
            } catch (Exception e) {
                
                System.out.println("Something wrong!");
            }
        
        }
        
    }
    
    public void saveAs(){
        // save as
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);
        
        if(fd.getFile() != null){
            fileName = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(fileName);
        }
        
        try {
            
            FileWriter fw = new FileWriter(fileAddress+ fileName);
            fw.write(gui.textArea.getText());
            fw.close();
            
        } catch (Exception e) {
            System.out.println("Something wrong!");
        }
    }
    
    public void exit(){
        //exit
        System.exit(0);
    }
}

