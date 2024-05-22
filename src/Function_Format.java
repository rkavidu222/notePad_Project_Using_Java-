
import java.awt.Font;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Function_Format {
    
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;
    
    public Function_Format(GUI gui){
    
        this.gui = gui;
        
    }
    
    public void wordWrap(){
    
        //warp text on
        if(gui.wordWrapOn == false){
            
            gui.wordWrapOn=true;
            gui.textArea.setLineWrap(true);  
            gui.textArea.setWrapStyleWord(true);
            gui.iWrap.setText("Word Wrap: On");
            
        }else if(gui.wordWrapOn == true){
            //warp text off
            gui.wordWrapOn=false;
            gui.textArea.setLineWrap(false);  
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: Off");
            
        }
    }
    
    public void createFont(int fontSize){
    
        // create font and size
         arial = new Font("Arial", Font.PLAIN, fontSize);
         comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
         timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
         
         setFont(selectedFont);
    }
    
    public void setFont(String font){
        
        //set font
        
        selectedFont = font;
        
        switch(selectedFont){
            
            case "Arial":
                gui.textArea.setFont(arial);
                break;
                
            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                break;
                
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
        }
    }
}
