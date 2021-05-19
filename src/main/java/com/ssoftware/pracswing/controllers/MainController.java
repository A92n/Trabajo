/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssoftware.pracswing.controllers;

import com.wssoftware.pracswing.views.MainFrame;
import com.wssoftware.pracswing.views.PersonFrame;

import com.wssoftware.pracswing.views.PersonListFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 *
 * @author Amy Leiva
 */
public class MainController implements ActionListener{
MainFrame mainframe;
public MainController(MainFrame mainframe){
this.mainframe=mainframe;


}
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            
            case "person":
                showPersonFrame();
               break;
              case"table":
                showtable();
                break;
                
                
             case"exit":
            System.exit(0);
            break;
        
        
        
        }      
    }
    
    public void showPersonFrame(){
      PersonFrame personf=new PersonFrame();
      mainframe.showChild(personf, false);
        }
   
    
    public void showtable(){
       PersonListFrame t = new PersonListFrame();
       mainframe.showChild(t, false);
        
        }
    
    
}
