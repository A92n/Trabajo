/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssoftware.pracswing.controllers;

import com.ssoftware.pracswing.models.Person;
import com.wssoftware.pracswing.views.PersonFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Amy Leiva
 */
public class PersonController extends KeyAdapter implements ActionListener,FocusListener{
PersonFrame personFrame;

JFileChooser d;
Person person;



    public PersonController(PersonFrame f) {
        super();
        personFrame=f;
        d=new JFileChooser();
        person=new Person();
       
    }

    

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person b) {
       person = b;
    }
  public void setPerson(String filePath) {
      File f = new File(filePath);
    readPerson(f);
    }
  
@Override
  public void actionPerformed(ActionEvent e){
 
     
switch(e.getActionCommand()){
        case "save":
            save();
            break;
        case "select":
            select();

            break;
        case"clear":
            personFrame.clear();
            break;


    }

  
  } 
  
 
    private void save() {
        d.showSaveDialog(personFrame);
        if(d.getSelectedFile() !=null){
       person = personFrame.getPersonData();
       writePerson(d.getSelectedFile(),personFrame.getPersonData());
      }
    }

 
       
    private void select() {
        d.showOpenDialog(personFrame);
             person =readPerson(d.getSelectedFile());
              personFrame.setPersonData(person);
    }
  
  
  
             
private void writePerson(File file,Person person){
            
    try {
       ObjectOutputStream w = new ObjectOutputStream(new FileOutputStream(file));
    w.writeObject(person);
     w.flush();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
    }

        
    catch (IOException ex) {
        Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
    }

       
}


private Person readPerson(File file){
           person=null;


    try {
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
  person = (Person) ois.readObject();
    } catch(FileNotFoundException e){
            JOptionPane.showMessageDialog(personFrame, e.getMessage(),personFrame.getTitle(),JOptionPane.WARNING_MESSAGE);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(PersonController.class.getName()).log(Level.SEVERE, null, ex);
        }


return person;
}
 





    @Override
    public void focusGained(FocusEvent e) {
       //
    }

    @Override
    public void focusLost(FocusEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(e.getOppositeComponent().getClass().getName().endsWith("JTextField"))
    {
     switch(((javax.swing.JTextField) e.getSource()).getName()){
                case "idTextField":
                    System.out.println("Evento capturarado desde: idTextField" + ", valor: " +((javax.swing.JTextField) e.getSource()).getText());
                    break;
                default:
                    System.out.println("Evento captudarado desde: " + ((javax.swing.JTextField) e.getSource()).getName());
                    break;
            }
    
    
    
    
    }
    
    
    }
    
@Override
 public void keyTyped(KeyEvent event) {
     JTextField input =(JTextField)event.getSource();
       
        switch (input.getName()) {
             case "firstName":
                char e=event.getKeyChar();
                if (Character.isDigit(e)) {
                    event.consume();
                }
                break;
             case "secondName":
                char a=event.getKeyChar();
                if (Character.isDigit(a)) {
                    event.consume();
                }
                break;
                
                
                 case "lastName1":
                char b=event.getKeyChar();
                if (Character.isDigit(b)) {
                    event.consume();
                }
                break;
                 case "lastName2":
                char f=event.getKeyChar();
                if (Character.isDigit(f)) {
                    event.consume();
                }
                break;
                
                
            case "id":
                char c= event.getKeyChar();
        if(!(Character.isDigit(c)||Character.isLetter(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_ENTER)){
                event.consume();
        }
              /* char c = event.getKeyChar();
                if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE 
                        || c == KeyEvent.VK_ENTER || c == KeyEvent.VK_PERIOD)) {
                    event.consume();
                }
           */
       
                
                break;
            case "gender":
                   char g=event.getKeyChar();
                //  if (input.getText().length()>=1   ) {
                  if(Character.isDigit(g)){    
                          event.consume();
                      
                   
                }
                    break;
           
        }
    }
  
  
  
  
}
