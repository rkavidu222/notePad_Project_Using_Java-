
import java.awt.Color;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Function_Color {
    GUI gui;
    
    public  Function_Color(GUI gui){
    
        this.gui = gui;
    }
    
    public void changeColor(String color){
    
        switch(color){
        
            case "White":
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
                break;
                
            case "Black":
                gui.window.getContentPane().setBackground(Color.black);   
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
                break;
                
            case "Blue":
                gui.window.getContentPane().setBackground(Color.blue);
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(Color.white);
                break;
        }
    }
}
