
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class GUI implements ActionListener{
    
    JFrame window;          //j frame
    JTextArea textArea;     //text area
    boolean wordWrapOn = false;  // word wrap on
    JScrollPane scrollPane; // scroll bar
    JMenuBar menuBar;       //menu bar
    JMenu menuFile, menuEdit, menuFormat, menuColor;  //top menu
    JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;  //file menu item
    
    //format menu
    JMenuItem iWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28 ;
    JMenu menuFont, menuFontSize;
    
    //color menu
    JMenuItem iColor1, iColor2, iColor3;
    
    //edit menu
    JMenuItem iUndo, iRedo;
    
    
    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    UndoManager um = new UndoManager();  // undo
    Function_Edit edit = new Function_Edit(this);
    
    Key keys = new Key(this);
    
    public GUI(){
       // constructor
       createWindow(); 
       createTextArea();
       createMenuBar();
       createFileMenu();
       editMenu();
       createFormatMenu();
       
       format.selectedFont = "Arial";
       format.createFont(16);
       format.wordWrap();
       color.changeColor("white");
       createColorMenu();
       window.setVisible(true);
    }
    
    public void createWindow(){
        //method for create window
        window = new JFrame("NotePad  by  Rashmika");
        window.setSize(600,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    public void createTextArea(){
        //method for create text area
        textArea = new JTextArea();
        textArea.setFont(format.arial);
        
        textArea.addKeyListener(keys);
        
        //undo and redo
        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e){
                        um.addEdit(e.getEdit());
                    }
                }
        );
        
        
        // this is for create scroll bar
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    
    public void createMenuBar(){
        //method for create menu bar
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        
        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        
        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
       
    }
    
    public void createFileMenu(){
        //items in file menu
        
        itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        itemNew.setActionCommand("New");
        menuFile.add(itemNew);
        
        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");
        menuFile.add(itemOpen);
        
        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("Save");
        menuFile.add(itemSave);
        
        itemSaveAs = new JMenuItem("Save As");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("Save As");
        menuFile.add(itemSaveAs);
        
        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("Exit");
        menuFile.add(itemExit);
    }
    
    public void editMenu(){
    
        // edit menu - undo, redo
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);
        
        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
    }
    
    public void createFormatMenu(){
    
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);
        
        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);
        
        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);
        
        iFontCSMS= new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);
        
        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);
        
        
        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);
        
        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);
        
        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);
        
        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);
        
        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);
        
        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);
        
        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);
    }
    
    public void createColorMenu(){
    
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);
        
        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);
        
        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
        
    }
    
    
    
    
    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String command = e.getActionCommand();
        switch(command){
            case "New": file.newFile();break;
            case "Open": file.open();break;
            case "Save": file.save();break;
            case "Save As": file.saveAs();break;
            case "Exit": file.exit();break;
            case "Undo": edit.undo();break;
            case "Redo": edit.redo();break;
            case "Word Wrap": format.wordWrap();break;
            case "Arial": format.setFont(command);break;
            case "Comic Sans MS": format.setFont(command);break;
            case "Times New Roman": format.setFont(command);break;
            case "size8": format.createFont(8); break;
            case "size12": format.createFont(12); break;
            case "size16": format.createFont(16); break;
            case "size20": format.createFont(20); break;
            case "size24": format.createFont(24); break;
            case "size28": format.createFont(28); break;
            case "White":color.changeColor(command);break;
            case "Black":color.changeColor(command);break;
            case "Blue":color.changeColor(command);break;
            
        }
    }
  
}
