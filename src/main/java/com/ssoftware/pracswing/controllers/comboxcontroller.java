/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssoftware.pracswing.controllers;

import com.wssoftware.pracswing.views.PersonFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Amy Leiva
 */
public class comboxcontroller implements ActionListener{
PersonFrame pf;

    public comboxcontroller(PersonFrame pf) {
        this.pf = pf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    switch(e.getActionCommand()){
            
            case "dBoxChanged":
             JComboBox cbo=((JComboBox) e.getSource());
             setupdata(cbo);
            // showSelectedData();
               break;
             
                case"mBoxChanged":
                    
                    break;
                case"okbutton":
                    break;
             case"exit":
            System.exit(0);
            break;
        
        
        
        }      
   
   
   
   
  
    
    
    
    
    }
    
    public void setupdata(JComboBox cbo){
     String title =cbo.getSelectedItem().toString();
              int index=cbo.getSelectedIndex();
              DefaultComboBoxModel model =new DefaultComboBoxModel();
              switch(index){
                  case 0://managua
                      model.addElement("Ciudad Sandino");
                       model.addElement("El Crucero");
                       model.addElement("Mateare");
                       model.addElement("San Francisco Libre");
                       model.addElement("San Rafael del Sur");
                       model.addElement("Ticuantepe");
                       model.addElement("Tipitapa");
                     model.addElement("Managua");
                     model.addElement("Villa El Carmen");
                       
                       
                      break;
              case 1://masaya
                   model.addElement("Masaya");
                   model.addElement("Nindiri");
                   model.addElement("Catarina");
                   model.addElement("Masatepe");
                   model.addElement("La Concepcion");
                   model.addElement("Tisma");
                   model.addElement("Nandasmo");
                   model.addElement("San Juan de Oriente");
                      model.addElement("Niquinohomo");
                      
                   break;
              case 2://granada
                   model.addElement("Granada");
                   model.addElement("Diriomo");
                   model.addElement("Diria");
                   model.addElement("Nandaime");
                      break;
                  case 3://leon
                   model.addElement("Leon");
                   model.addElement("Achuapa");
                   model.addElement("El Jicaral");
                   model.addElement("La Paz Centro");
                   model.addElement("Larreynaga");
                   model.addElement("Nagarote");
                   model.addElement("Quezalguaque");
                   model.addElement("El Sauce");
                   model.addElement("Santa Rosa del Peñon");
                   model.addElement("Telica");
                   
                      break;    
                  case 4://Rivas
                   model.addElement("Rivas");
                   model.addElement("Altagracia");
                   model.addElement("Belen");
                   model.addElement("Buenos Aires");
                   model.addElement("Cardenas");
                   model.addElement("Moyogalpa");
                   model.addElement("Potosi");
                   model.addElement("San Jorge");
                    model.addElement("San Juan del Sur");
                   model.addElement("Tola");
                      break;
                       case 5://Boaco
                   model.addElement("Boaco");
                   model.addElement("Camoapa");
                   model.addElement("San Jose de los Remates");
                   model.addElement("San Lorenzo");
                   model.addElement("Santa Lucia");
                   model.addElement("Teustepe");
                  
                   break;
                  case 6://CARAZO
                       model.addElement("Diriamba");
                   model.addElement("Dolores");
                   model.addElement("El Rosario");
                   model.addElement("Jinotepe");
                   model.addElement("La Conquista");
                   model.addElement("La Paz de Oriente");
                   model.addElement("San Marcos");
                   model.addElement("Santa Teresa");
                 
                   break;
                    case 7://CHINANDEGA
                   model.addElement("Chichigalpa");
                   model.addElement("Chinandega");
                   model.addElement("Cinco Pinos");
                   model.addElement("Corinto");
                   model.addElement("El Realejo");
                   model.addElement("El Viejo");
                   model.addElement("Posoltega");
                   model.addElement("Puerto Morazan");
                   model.addElement("San Francisco del Norte");
                   model.addElement("San Pedro del Norte");
                   model.addElement("Santo Tomas del Norte");
                   model.addElement("Somotillo");
                   model.addElement("Villa Nueva");
                  
                   
                   
                   
                   
                   break;
                    case 8://CHONTALES
                   model.addElement("Acoyapa");
                   model.addElement("Comalapa");
                   model.addElement("Cuapa");
                   model.addElement("El Coral");
                   model.addElement("Juigalpa");
                   model.addElement("La Libertad");
                   model.addElement("San Pedro de Lovago");
                   model.addElement("Santo Domingo");
                   model.addElement("Santo Tomas");
                   model.addElement("Villa Sandino");
                   
                   
                   
                   break;
                 
              case 9://ESTELI
                   model.addElement("Condega");
                   model.addElement("Esteli");
                   model.addElement("La Trinidad");
                   model.addElement("Pueblo Nuevo");
                   model.addElement("San Juen de Limay");
                   model.addElement("San Nicolas");
                 
                   
                   
                   
                      break;
                  case 10://JINOTEGA
                   model.addElement("El cua");
                   model.addElement("Jinotega");
                   model.addElement("La Concordia");
                   model.addElement("San Jose de Bocay");
                   model.addElement("San Rafael del Norte");
                   model.addElement("San Sebastian de Yali");
                   model.addElement("Santa Maria de Pantasma");
                    model.addElement("Wiwili de Jinotega");
                  
                   
                   
                  
                      break;    
                  case 11://MADRIZ
                   model.addElement("Las Sabanas");
                   model.addElement("Palacagüina");
                   model.addElement("San Jose de Cusmapa");
                   model.addElement("San Juan de Rio Coco");
                   model.addElement("San Lucas");
                   model.addElement("Somoto");
                   model.addElement("Telpaneca");
                   model.addElement("Totogalpa");
                   model.addElement("Yalagüina");
                   
                      break;
                       case 12://MATAGALPA
                   model.addElement("Ciudad Dario");
                   model.addElement("El Tuma-La Dalia");
                   model.addElement("Esquipulas");
                   model.addElement("Matagalpa");
                   model.addElement("Matiguas");
                   model.addElement("Muy Muy");
                    model.addElement("Rancho Grande");
                   model.addElement("Rio Blanco");
                   model.addElement("San Dionisio");
                   model.addElement("San Isidro");
                   model.addElement("San Ramon");
                   model.addElement("Sebaco");
                   model.addElement("Terrabona");
                   
                   
                   
                  
                   break;
                  case 13://NUEVA SEGOVIA
                       model.addElement("Ciudad Antigua");
                   model.addElement("Dipilto");
                   model.addElement("El Jicaro");
                   model.addElement("Jalapa");
                   model.addElement("Macuelizo");
                   model.addElement("Mozonte");
                   model.addElement("Murra");
                   model.addElement("Ocotal");
                   model.addElement("Quilali");
                   model.addElement("San Fernando");
                   model.addElement("Santa Maria");
                   model.addElement("Wiwili");
                   
                   
                   break;
                    case 14://RIO SAN JIAN
                   model.addElement("El Almendro");
                   model.addElement("El Castillo");
                   model.addElement("Morrito");
                   model.addElement("San Carlos");
                   model.addElement("San Juan del Norte");
                   model.addElement("San Miguelito");
                 
                   break;
                   
                      case 15://COSTA N
                   model.addElement("Bonanza");
                   model.addElement("Mulukuku");
                   model.addElement("Prinzapolka");
                   model.addElement("Puerto Cabezas");
                   model.addElement("Rosita");
                   model.addElement("Siuna");
                   model.addElement("Waslala");
                   model.addElement("Waspan");
                   break;
                     case 16://COSTA SUR
                   model.addElement("Bluefields");
                   model.addElement("Desembocadura de Rio Grande");
                   model.addElement("El Ayote");
                   model.addElement("El Rama");
                   model.addElement("El Tortuguero");
                   model.addElement("Islas de Maiz");
                   model.addElement("Kukra Hill");
                   model.addElement("La Cruz de Rio Grande");
                   model.addElement("Laguna de Perlas");
                   model.addElement("Muelle de los Bueyes");
                   model.addElement("Nueva Guinea");
                  model.addElement("Paiwas");
                           
                      
                   break;
                   
              }
  pf.setupData(model);
   
    
    }
     
    
}
