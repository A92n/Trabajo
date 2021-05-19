/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssoftware.pracswing.models;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author Amy Leiva
 */
public class FileTableModel extends AbstractTableModel {

     private String[][] data;
    private final Object columnNames[] = {"Nombre de archivo", "Ruta", "Fecha de creación"};

    public FileTableModel() {
        data = new String[][]{
            {null, null}
        };
    }
      public FileTableModel(String f[][]) {
        data = f;
    }

     public FileTableModel(File f) {
        File files[] = f.listFiles();
        String[][] xdata = new String[files.length][3];
        int c = 0;
        for (File file : files) {
            try {
                xdata[c][0] = file.getName();
                xdata[c][1] = file.getAbsolutePath();
                BasicFileAttributes attr = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
                xdata[c][0] = file.getName();
            } catch (IOException ex) {
                Logger.getLogger(FileTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setDataModel(xdata);
    }
     
      public void setDataModel(String f[][]) {
        data = f;
    }
  public TableModel getModel(){
      TableModel model = new DefaultTableModel(
            data,
            columnNames
        );
        return model;
    }
    
    
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
