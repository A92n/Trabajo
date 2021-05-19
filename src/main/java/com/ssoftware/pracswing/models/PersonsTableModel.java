/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssoftware.pracswing.models;

import com.wssoftware.pracswing.views.PersonFrame;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.table.AbstractTableModel;






/**
 *
 * @author Amy Leiva
 */
public class PersonsTableModel extends AbstractTableModel implements Serializable{
 
 
 
 
 
 
    
    
    private Object rowData[][];

    
    private String columnNames[];

    private static int personid = 1;

 
    public PersonsTableModel() {
        loadColumnNames();
        rowData = new Object[0][0];
    }

  
    public PersonsTableModel(Person[] person) {
        loadColumnNames();
        loadDataModel(person);
    }

   
    public void setDataModel(Person[] person) {
        loadDataModel(person);
    }

    
    public Person[] getDataModel() {
        Person[] products = new Person[rowData.length];
        for (int i = 0; i < rowData.length; i++) {
            Object[] row = rowData[i];
            products[i] = convertToProduct(row);
        }
        return products;
    }

    
    private Person convertToProduct(Object[] row) {
        Person temp = new Person();
        temp.setPersonId(Integer.parseInt(row[0].toString()));
 temp.setId(String.valueOf(row[1]));
 temp.setFirstName(String.valueOf(row[2]));
 temp.setSecondName(String.valueOf(row[3]));
 temp.setLastName1(String.valueOf(row[4]));
 temp.setLastName2(String.valueOf(row[5]));
 temp.setBirthDate((Date)row[6]);
 temp.setAge((short)row[7]);
 temp.setGender((char)row[8]);
 temp.setDepartment(String.valueOf(row[9]));
 temp.setMunicip(String.valueOf(row[10]));
        return temp;
    }

    /**
     * Devuelve el arreglo que contiene el nombre de las columnas
     *
     * @return un arreglo de String
     */
    public String[] getColumnNames() {
        return columnNames;
    }

    /**
     * Este metodo nos devuelve un arreglo, en el que en cada posicion del
     * arreglo contiene el valor o contenido de cada atributo de la instancia de
     * Producto y despues este arreglo es introducido al final de la matriz,
     * pasando a formar una nueva fila
     *
     * @return un arreglo de Object
     */
    public static Object[] getDefaultRowData() {
        Person p = new Person();
        p.setPersonId(personid);
    p.setId(String.valueOf(personid));
    p.setFirstName(String.valueOf("Primer Nombre "+personid));
    p.setSecondName(String.valueOf("Segundo Nombre "+personid));
   p.setLastName1(String.valueOf("Primer Apellido "+personid));
    p.setLastName2(String.valueOf("Segundo Apellido "+personid));
    p.setBirthDate(new Date());
    p.setAge((short)(personid));
      p.setGender((char)personid);
        p.setDepartment(String.valueOf("Departamento"+personid));
        p.setMunicip(String.valueOf("Municipio"+personid));
        personid++;
     
        return new Object[]{p.getPersonId(),p.getId(),p.getFirstName(),p.getSecondName(),
            p.getLastName1(),p.getLastName2(),p.getBirthDate(),p.getAge(),p.getGender(),p.getDepartment()
                ,p.getMunicip()
        
        
        
        };
    }

   
    @Override
    public int getRowCount() {
        return rowData == null ? 0 : rowData.length;
    }

    /**
     * Devuelve el numero total de columnas de la tabla de productos
     *
     * @return un entero
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex > rowData.length) {
            return null;
        } else if (columnIndex < 0 || columnIndex > columnNames.length) {
            return null;
        }
        return rowData[rowIndex][columnIndex];
    }

 
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex > rowData.length) {
            return;
        } else if (columnIndex < 0 || columnIndex > columnNames.length) {
            return;
        }
        rowData[rowIndex][columnIndex] = value;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

  
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    
    @Override
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

  
    @Override
    public String getColumnName(int column) {
        if (column < 0 || column > columnNames.length) {
            return null;
        }
        return columnNames[column];
    }

   
    public void addRow(Object[] defaultRowData) {
        if (defaultRowData != null && defaultRowData.length > 0) {
            rowData = Arrays.copyOf(rowData, rowData.length + 1);
            rowData[rowData.length - 1] = defaultRowData;
            fireTableRowsInserted(rowData.length - 1, rowData.length - 1);
        }
    }

   
    public void removeRow(int selectedRow) {
        if (selectedRow >= 0 && selectedRow < rowData.length) {
            final int length = rowData.length;
            Object[][] tempMatrix = new Object[length - 1][rowData[0].length];
            for (int i = 0, j = 0; i < length; i++) {
                if (i != selectedRow) {
                    System.arraycopy(rowData[i], 0, tempMatrix[j], 0, rowData[i].length);
                    j++;
                }
            }
            rowData = tempMatrix;
            fireTableRowsDeleted(selectedRow, selectedRow);
        }
    }

   
    private void loadColumnNames() {
        Field fields[] = Person.class.getDeclaredFields();
        columnNames = new String[fields.length];
        int index = 0;
        for (Field field : fields) {
            columnNames[index++] = field.getName();
        }
        fireTableStructureChanged();
    }

    /**
     * Este metodo se encarga de convertir el arreglo de productos en filas de
     * la matriz rowData, para ello hacemos las validaciones correspondientes y
     * convertimos cada Producto del arreglo en una fila y lo vamos agregando.
     *
     * Según la API se debe de llamar el metodo fireTableDataChanged() cuando
     * todo el contenido de la tabla ha cambiado.
     *
     * @param el arreglo de Productos a mostrar en la tabla
     */
    private void loadDataModel(Person[] person) {
        if (person != null && person.length > 0) {
            rowData = new Object[person.length][columnNames.length];
            int index = 0;
            for (Person a : person) {
                rowData[index++] = convertToArray(a);
            }
            fireTableDataChanged();
        } else {
            rowData = new Object[0][columnNames.length];
            fireTableDataChanged();
        }
    }

    private Object[] convertToArray(Person person) {
        Field fields[] = Person.class.getDeclaredFields();
        Object[] row = new Object[fields.length];
        int index = 0;
        for (Field f : fields) {
            f.setAccessible(true); // para acceder al contenido de cada atributo
            try {
                row[index++] = f.get(person); // obtenemos su contenido y lo agregamos
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(PersonsTableModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }


















     
     
     
    
    
   



}