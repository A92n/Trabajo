/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssoftware.pracswing.controllers;


import com.ssoftware.pracswing.models.Person;

import com.ssoftware.pracswing.models.PersonsTableModel;
import com.wssoftware.pracswing.views.PersonFrame;
import com.wssoftware.pracswing.views.PersonListFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;


/**
 *
 * @author Amy Leiva
 */
public class tablecontroller implements ActionListener{
    
     private PersonFrame personframe;
    private JFileChooser dialog;
    private PersonListFrame listFrame;

    public tablecontroller(PersonFrame pf) {
       personframe = pf;
        dialog = new JFileChooser();
    }

    public tablecontroller(PersonListFrame listframe) {
        dialog = new JFileChooser();
        this.listFrame = listframe;
    }
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "open":
               showPersontable();
                break;
              
            case "newRow":
             listFrame.addRow();
                break;
            case "saveTableContent":
             saveTableContent();
                break;
            case "deleteRow":
              listFrame.removeRow();
                break;
            case "close":
               listFrame.dispose();
                break;
            
            
          
              
       
        
        } 
    } 
    
   
    
    
   private Person[] readPersonList(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
        Person[] person;
        try(FileInputStream in = new FileInputStream(file);
            ObjectInputStream s = new ObjectInputStream(in)) {
            person = (Person[]) s.readObject();
        }
        return person;
    } 
    
    
    private void showPersontable(){
    dialog.showOpenDialog(listFrame);
    File bl=dialog.getSelectedFile();
    if(bl!=null){
           listFrame.setPersonListFile(bl.getPath());                
            try {
                listFrame.setPersonTableModel(new PersonsTableModel(readPersonList(bl)));
           
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(tablecontroller.class.getName()).log(Level.SEVERE, null, ex);
            }           
        }  
    
    
    }
      private void saveTableContent() {
        dialog.showSaveDialog(listFrame);
        Person person[] = listFrame.getDataTable();
        try (ObjectOutputStream output
                = new ObjectOutputStream(new FileOutputStream(dialog.getSelectedFile()))) {
            output.writeObject(person);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(tablecontroller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(tablecontroller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------------
 
   /* @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "open":
                 showPersonsOnTable();
                break;
            case "newRow":
              //  listFrame.addRow();
                break;
            case "saveTableContent":
             //   saveTableContent();
                break;
            case "deleteRow":
               // listFrame.removeRow();
                break;
            case "close":
               listFrame.dispose();
                break;
            
            
          
              
       
        
        } 
    }   
    
   private Person[] readPersonList(File file){
   
   Person persons[]=null;
  
         try {
            ObjectInputStream  input = new ObjectInputStream(new FileInputStream(file));
          persons=(Person[]) input.readObject();
         
         } catch (FileNotFoundException ex) {
             Logger.getLogger(tablecontroller.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(tablecontroller.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(tablecontroller.class.getName()).log(Level.SEVERE, null, ex);
         }
   return persons;
   }
    private void showPersonsOnTable(){
    
    dialog.showOpenDialog(personframe);
    File file = dialog.getSelectedFile();
    if(file != null){
    listFrame.setPersonListFile(file.getPath());
   listFrame.setPersonTableModel(new PersonsTableModel(readPersonList(file)));
    
    
    }
    
    
    
    
    }
    
    */
}