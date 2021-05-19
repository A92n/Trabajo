/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wssoftware.pracswing.views;

import com.ssoftware.pracswing.controllers.PersonController;
import com.ssoftware.pracswing.controllers.comboxcontroller;
import com.ssoftware.pracswing.misc.DateOperator;

import com.ssoftware.pracswing.misc.Validator;
import com.ssoftware.pracswing.models.Person;
import java.awt.event.KeyEvent;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Amy Leiva
 */
public class PersonFrame extends javax.swing.JInternalFrame {
PersonController pc;
comboxcontroller cb;
private static int counter = 0;
    /**
     * Creates new form PersonFrame
     */
    public PersonFrame() {
        initComponents();
    setController();
   
   
    }
 
    
    public void setController(){
  pc=new PersonController(this);
  cb=new comboxcontroller(this);
  this.departmentComboBox.addActionListener(cb);
  this.municipalityComboBox.addActionListener(cb);
  this.departmentComboBox.addActionListener(pc);
    this.municipalityComboBox.addActionListener(pc);
       this.selectButton.addActionListener(pc);
    this.clearButton.addActionListener(pc);
    this.saveButton.addActionListener(pc);
   
   this.idTextField.addFocusListener(pc);
   
      idTextField.addKeyListener(pc);
       firstNameTextField.addKeyListener(pc);
       genderTextField.addKeyListener(pc);
   
    }
    private void idTextFieldFocusLost(java.awt.event.FocusEvent evt){
    if(Validator.isNicaraguanNumberId(idTextField.getText()))
    {
    String birthDate = Validator.getBirthDateFromId(idTextField.getText());
    birthDateTextField.setText(birthDate);
    Date bd = DateOperator.stringToDate(birthDate, "yyyy-MM-dd");
    ageTextField.setText(String.valueOf(DateOperator.getAge(bd)));
    
    }else{
    JOptionPane.showMessageDialog(this, "El no.de cedula proporcionado no es valido ", this.getTitle(), JOptionPane.WARNING_MESSAGE);
    idTextField.requestFocus();
    idTextField.selectAll();
    }
    
    
    
    }
    public void setPersonData(Person p){
personidTextField.setText(String.valueOf(p.getPersonId())); 
idTextField.setText(p.getId());
firstNameTextField.setText(p.getFirstName());
secondNameTextField.setText(p.getSecondName());
lastName1TextField.setText(p.getLastName1());
lastName2TextField.setText(p.getLastName2());
birthDateTextField.setText(DateOperator.dateToString(p.getBirthDate(), "yyyy-MM-dd"));
ageTextField.setText(Short.toString(p.getAge()));
genderTextField.setText(String.valueOf(p.getGender()));
Object a=p.getDepartment();
departmentComboBox.setSelectedItem(a);
Object b=p.getMunicip();
municipalityComboBox.setSelectedItem(b);
    
    }
    
   public void setupData(DefaultComboBoxModel model){
//jLabel9.setText(title);
municipalityComboBox.setModel(model);
}
   

    
    
    
    
    public Person getPersonData(){
   counter++;
    Person p =new Person();
p.setPersonId(counter);
p.setId(idTextField.getText());
p.setFirstName(firstNameTextField.getText());

p.setSecondName(secondNameTextField.getText());
p.setLastName1(lastName1TextField.getText());
p.setLastName2(lastName2TextField.getText());
String birthDate = Validator.getBirthDateFromId(idTextField.getText());
birthDateTextField.setText(birthDate);
p.setBirthDate(DateOperator.stringToDate(birthDateTextField.getText(), "yyyy-MM-dd"));
Date bd = DateOperator.stringToDate(birthDate, "yyyy-MM-dd");
ageTextField.setText(String.valueOf(DateOperator.getAge(bd)));
p.setAge(Short.valueOf(ageTextField.getText()));
String s = genderTextField.getText();
p.setGender(s.charAt(0));
String listName=departmentComboBox.getSelectedItem().toString();
p.setDepartment(listName);
String item=municipalityComboBox.getSelectedItem().toString();
p.setMunicip(item);

 return p;
    }
   
    
    
    
    
   
    public void clear(){
    
    firstNameTextField.setText("");
    secondNameTextField.setText("");
   lastName1TextField.setText("");
    lastName2TextField.setText("");
    idTextField.setText("");
    birthDateTextField.setText("");
    ageTextField.setText("");
    genderTextField.setText("");
    personidTextField.setText("0");
    
 
    }
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastName1TextField = new javax.swing.JTextField();
        secondNameTextField = new javax.swing.JTextField();
        lastName2TextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        idTextField = new javax.swing.JTextField();
        birthDateTextField = new javax.swing.JTextField();
        ageTextField = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        departmentComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        municipalityComboBox = new javax.swing.JComboBox<>();
        jSeparator3 = new javax.swing.JSeparator();
        selectButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        personidTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        genderTextField = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Registro");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconfinder_user_people_person_users_man_5340287 (1).png"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(533, 366));

        jLabel1.setText("Primer nombre");

        jLabel2.setText("Primer apellido");

        jLabel3.setText("Segundo nombre");

        jLabel4.setText("Segundo apellido");

        firstNameTextField.setName("firstName"); // NOI18N

        lastName1TextField.setName("lastName1"); // NOI18N

        secondNameTextField.setName("secondName"); // NOI18N

        lastName2TextField.setName("lastName2"); // NOI18N

        jLabel5.setText("# de cedula");

        jLabel6.setText("Fecha de nacimiento");

        jLabel7.setText("Edad");

        idTextField.setName("id"); // NOI18N

        jLabel8.setText("Departamento");

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Managua", "Masaya", "Granada", "Leon", "Rivas", "Boaco", "Carazo", "Chinandega", "Chontales", "Esteli", "Jinotega", "Madriz", "Matagalpa", "Nueva Segovia", "Rio San Juan", "Costa Caribe Norte", "Costa Caribe Sur" }));
        departmentComboBox.setActionCommand("dBoxChanged");

        jLabel9.setText("Municipio");

        municipalityComboBox.setActionCommand("mBoxChanged");

        selectButton.setText("Seleccionar");
        selectButton.setActionCommand("select");

        clearButton.setText("Limpiar");
        clearButton.setActionCommand("clear");

        saveButton.setText("Guardar");
        saveButton.setActionCommand("save");

        jLabel10.setText("Person id");

        jLabel11.setText("Gender");

        genderTextField.setName("gender"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2))
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(genderTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ageTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(lastName1TextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idTextField, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lastName2TextField)
                            .addComponent(birthDateTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(personidTextField)
                            .addComponent(secondNameTextField))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(municipalityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(selectButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addComponent(clearButton)
                .addGap(156, 156, 156)
                .addComponent(saveButton)
                .addGap(65, 65, 65))
            .addComponent(jSeparator3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secondNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(lastName1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastName2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(birthDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(personidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(municipalityComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearButton)
                    .addComponent(selectButton)
                    .addComponent(saveButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ageTextField;
    private javax.swing.JTextField birthDateTextField;
    private javax.swing.JButton clearButton;
    private javax.swing.JComboBox<String> departmentComboBox;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JTextField genderTextField;
    private javax.swing.JTextField idTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField lastName1TextField;
    private javax.swing.JTextField lastName2TextField;
    private javax.swing.JComboBox<String> municipalityComboBox;
    private javax.swing.JTextField personidTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField secondNameTextField;
    private javax.swing.JButton selectButton;
    // End of variables declaration//GEN-END:variables

    
}
