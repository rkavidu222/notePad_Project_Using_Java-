
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Key implements KeyListener{

    GUI gui;
    
    public Key(GUI gui){
        this.gui = gui;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_S){ //save
            gui.file.save(); 
        }if(e.isShiftDown() && e.getKeyCode()==KeyEvent.VK_S){ //save As
            gui.file.saveAs(); 
        }if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_O){ //save
            gui.file.open();
        }if(e.isControlDown() && e.getKeyCode()==KeyEvent.VK_N){ //save
            gui.file.newFile();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
