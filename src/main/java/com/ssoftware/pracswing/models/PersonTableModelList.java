/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ssoftware.pracswing.models;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Amy Leiva
 */
public class PersonTableModelList extends AbstractTableModel implements Serializable{
      private List<Object[]> personData;

    /**
     * Arreglo que contiene el nombre de cada columna
     */
    private String columnNames[];

    /**
     * Variable contador para ir asignando un id diferente
     */
    private static int personId = 1;

    /**
     * El constructor por defecto se encarga de llenar el arreglo columnNames[]
     * el cual contiene el nombre de las columnas de la tabla e instancia la
     * lista productsData
     */
    public PersonTableModelList() {
        loadColumnNames();
        personData = new ArrayList<>();
    }

    /**
     * Este constructor nos permite pasarle un indefinido numero de parametros de
     * tipo Producto separados por coma cada una de las instancias o bien puede
     * ser un arreglo de productos y en base a esto crear nuesto modelo de datos.
     * 
     * *****Ejemplo 1*****
     * 
     * Product p1 = new Product();
     * Product p2 = new Product();
     * Product p3 = new Product();
     * 
     * Constructor:
     * new ProductTableModelList(p1, p2, p3); // y asi sucesivamente...
     * 
     * *****Ejemplo 2:*****
     * 
     * Product products[] = new Product[5]; // arreglo con 5 o N elementos no importa
     *
     * Constructor:
     * new ProductTableModelList(products);
     * 
     * Esta es una forma mas felxible de crear un modelo de datos para nuestra
     * tabla, aparte lo que hace este constructor es cargar nuestro arreglo
     * columnNames con el nombre de cada columna.
     * 
     * @param indefinido numero de instancias o un arreglo de Product
     */
    public PersonTableModelList(Person... person) {
        loadColumnNames();
        createModelFromArray(person);
    }

    /**
     * Este constructor nos permite pasarle de una sola vez una lista de
     * arreglos de tipo Object (asi como productsData) que corresponderia a los
     * datos que queremos mostrar en la tabla, tambien se encarga de llenar el
     * arreglo columnNames[] que contiene el nombre de cada columna de la tabla.
     *
     * @param una lista de arreglos de tipo Object
     */
    public PersonTableModelList(List<Object[]> person) {
        loadColumnNames();
        createModelFromList(person);
    }

    /**
     * Este metodo nos permite pasarle un indefinido numero de parametros de
     * tipo Producto separados por coma cada una de las instancias o bien puede
     * ser un arreglo de productos y en base a esto crear nuesto modelo de datos.
     * 
     * *****Ejemplo 1*****
     * 
     * Product p1 = new Product();
     * Product p2 = new Product();
     * Product p3 = new Product();
     * 
     * Metodo:
     * setDataModel(p1, p2, p3); // y asi sucesivamente...
     * 
     * *****Ejemplo 2:*****
     * 
     * Product products[] = new Product[5]; // arreglo con 5 o N elementos no importa
     *
     * Metodo:
     * setDataModel(products);
     * 
     * Luego este metodo crea nuestro modelo de datos apartir del numero de 
     * instancias que se le pasaron por parametros o del arreglo de Productos
     * que se le paso.
     * 
     * NOTA: El metodo que esta abajo setDataModel(List<Object[]> products)
     * sirve para lo mismo, para crear un modelo apartir de los datos que
     * se le pasen por parametro, se hizo de esta forma para mostrar las diferentes
     * opciones que tenemos a la hora de hacer esto.
     * 
     * @param indefinido numero de instancias o un arreglo de Product
     */
    public void setDataModel(Person... person) {
        createModelFromArray(person);
    }
    
    /**
     * Este metodo nos permite pasarle una lista de arreglos de tipo Object el
     * cual debe contener los datos que deseamos mostrar en la tabla.
     *
     * NOTA: El metodo anterior hace lo mismo, pero como se explico
     * anteriormente nos permite pasarle un arreglo de productos o instancias
     * indefinidas separadas por coma para crear el modelo de datos que se
     * mostraran en la tabla.
     *
     * Ambos sirven para lo mismo, se hizo asi a proposito para mostrar las
     * diferentes formas que hay para crear un modelo.
     *
     * @param una lista de arreglos de tipo Object
     */
    public void setDataModel(List<Object[]> person) {
        createModelFromList(person);
    }

    /**
     * Este metodo lo que hace es devolvernos todos los datos de la tabla en una
     * lista de Productos.
     * 
     * Lo que hacemos primero es asignarle a nuestra lista de productos a devolver, 
     * el numero posiciones que tendra en base al numero de filas de productsData 
     * 
     * List<Product> products = new ArrayList<>(productsData.size());
     * 
     * y luego recorremos cada una de las posiciones de productsData, 
     * (recuerde que cada elemento de productsData es un arreglo de Object[]),
     * entonces conforme vamos recorriendo lo que hacemos es tomar el elemento
     * en el que vamos (Object[]) y transformarlo en un objeto de tipo Product
     * para agregarlo a la lista y asi hasta transformar todas las filas en un
     * Producto.
     * 
     * Una vez transformamos cada elemento (Object[]) de productsData en un objeto
     * de tipo Producto y lo agregamos a nuestra lista de productos, la devolvemos.
     * 
     * Sintaxis despues de Java 8:
     * 
     * productsData.forEach((row) -> {
     *   products.add(convertToProduct(row));
     * });
     *
     * Esto puede ser reemplazado por sintaxis antes de Java 8:
     * 
     * for (Object[] row: productsData) {
     *    products.add(convertToProduct(row));
     * }
     * 
     * @return
     */
    public List<Person> getDataModel() {
        List<Person> person = new ArrayList<>(personData.size());
        personData.forEach((row) -> {
            person.add(convertToProduct(row));
        });
        return person;
    }

    /**
     * Devuelve el numero de total de filas de la tabla
     *
     * @return un entero
     */
    @Override
    public int getRowCount() {
        return personData.size();
    }

    /**
     * Devuelve el numero total de columnas de la tabla
     *
     * @return un entero
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * Este metodo esta hecho para que siempre retorne true, lo que significa
     * que podremos editar cualquier celda de cualquier fila y columna que
     * deseemos.
     *
     * @param indice de la fila
     * @param indice de la columna
     * @return true
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    /**
     * Devuelve la clase a la que pertenece el valor que se encuentra en la
     * columna que le indiquemos como parametro, para esto se apoya en el metodo
     * que sobreescribimos anteriormente getValueAt
     *
     * @param indice de la columna
     * @return la clase a la que pertence
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    /**
     * Devuelve el nombre de la columna, en base al indice de la columna que le
     * pasemos por parametro
     *
     * @param el indice de la columna
     * @return una String que representa el nombre de la columna
     */
    @Override
    public String getColumnName(int column) {
        if (column < 0 || column > columnNames.length) {
            return null;
        }
        return columnNames[column];
    }

    /**
     * Devuelve el valor de la fila y columna que le indiquemos, al crear un
     * modelo desde cero es importante sobreescribir este metodo.
     *
     * Antes debemos verificar que productsData no este vacia y que el indice de
     * la fila y columna que se paso por parametro esten dentro del rango, de lo
     * contrario obtendremos una excepcion.
     *
     * @param indice de la fila
     * @param indice de la columna
     * @return el objeto que se encuentra en la fila y columna seleccionada
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (personData.isEmpty()) {
            return null;
        } else if (rowIndex < 0 || rowIndex > personData.size()) {
            return null;
        } else if (columnIndex < 0 || columnIndex > columnNames.length) {
            return null;
        }
        return personData.get(rowIndex)[columnIndex];
    }

    /**
     * Establece el nuevo valor en la fila y columna que le indiquemos, al crear
     * un modelo desde cero, tambien es importante sobreescribir este metodo ya
     * que este es el que nos permite modificar los valores que estamos
     * mostrando e internamente este metodo se manda a llamar para poder editar
     * celdas
     *
     * NOTA: Recordemos siempre que se actualice un dato en una celda llamar al
     * metodo fireTableCellUpdated para que se reflejen los cambios en la tabla.
     *
     * @param el nuevo valor
     * @param indice de la fila
     * @param indice de la columna
     */
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (personData.isEmpty()) {
            return;
        } else if (rowIndex < 0 || rowIndex > personData.size()) {
            return;
        } else if (columnIndex < 0 || columnIndex > columnNames.length) {
            return;
        }
       personData.get(rowIndex)[columnIndex] = value;
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    /**
     * Este metodo nos devuelve un arreglo, en el que en cada posicion del
     * arreglo contiene el valor o contenido de cada atributo de la instancia de
     * Producto y despues este arreglo es introducido al final de la matriz,
     * pasando a formar una nueva fila
     *
     * @return un arreglo de Object
     */
    private Object[] getDefaultProduct() {
        Person person = new Person();
       person.setId(String.valueOf(personId));
       person.setFirstName(String.valueOf(personId));
      person.setSecondName(String.valueOf(personId));
      
      
      
        return new Object[]{person.getId(),person.getFirstName(),person.getSecondName()};
    }

    /**
     * Este metodo se encarga de agregar una nueva fila con los datos por
     * defecto, se apoya en el metodo addRow que esta mas abajo y de el metodo
     * getDefaultProduct que nos devuelve una fila por defecto para poder crear
     * esta nueva fila.
     *
     * NOTA: Si se quiere agregar una nueva fila pero no con los datos por
     * defecto, revisar el metodo addRow(Object[] product) que esta mas abajo.
     */
    public void addRow() {
        addRow(getDefaultProduct());
    }

    /**
     * Este metodo agrega una nueva fila con los datos del arreglo de object que
     * se le pasaron por parametro
     *
     * NOTA: No olvidemos llamar al metodo fireTableRowsInserted un vez que
     * agreguemos la nueva fila de lo contrario no se reflejaran los cambios en
     * la tabla
     *
     * @param un arreglo de Object
     */
    public void addRow(Object[] product) {
        if (product != null && product.length > 0) {
          personData.add(product);
            fireTableRowsInserted(personData.size() - 1,personData.size() - 1);
        }
    }

    /**
     * Este metodo se encarga de eliminar una fila, esto lo hace en base al
     * indice de la fila que le pasemos por parametro, para ello antes
     * verificamos que el indice se encuentre dentro del rango de lo contrario
     * obtendremos una excepcion
     *
     * NOTA: No olvidar llamar al final el metodo fireTableRowsDeleted de lo
     * contrario no se veran reflejados los cambios en la tabla
     *
     * @param la fila seleccionada
     */
    public void removeRow(int selectedRow) {
        if (selectedRow >= 0 && selectedRow <personData.size()) {
            personData.remove(selectedRow);
            fireTableRowsDeleted(selectedRow, selectedRow);
        }
    }

    /**
     * Este metodo obtiene el nombre de todos los campos de la clase Product y
     * almacena cada uno de ellos en el arreglo columnNames.
     *
     * Según la API el metodo fireTableStructureChanged() debe de llamarse
     * cuando la estructura de la tabla a cambiado y tenga que volverse a
     * dibujar de otra forma, como en este caso cuando se agregan las columnas
     *
     */
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
     * Este metodo lo que hace es crear el modelo de datos a partir de un
     * arreglo de Product que se le pase por parametros, para ello primero
     * verificamos que el arreglo no sea null y que contenga datos.
     *
     * Esta sintaxis (A partir de JAVA 8)
     *
     * Stream.of(productsArray).forEach((p) -> {
     * productsData.add(convertToArray(p)); });
     *
     * Puede ser reemplazada por esto:
     *
     * for (Product p : productsArray) { productsData.add(convertToArray(p)); }
     *
     * Y es exactamente lo mismo, lo que hace es recorrer el arreglo que se paso
     * por parametros e ir transformando cada elemento (cada Producto) de ese
     * arreglo en una fila (arreglo de Object con cada uno de sus datos) para
     * agregarlo a nuestra lista productsData.
     *
     * NOTA: Finalmente debemos llamar al metodo fireTableDataChanged(); para
     * asegurarnos de que los cambios se reflejen en nuestra tabla.
     *
     * @param productsArray
     */
    private void createModelFromArray(Person[] personArray) {
        if (personArray != null && personArray.length > 0) {
            personData = new ArrayList<>(personArray.length);
            Stream.of(personArray).forEach((p) -> {
                personData.add(convertToArray(p));
            });
            fireTableDataChanged();
        } else {
            personData = new ArrayList<>();
            fireTableDataChanged();
        }
    }

    /**
     * Este metodo se encarga de convertir una instancia de Producto en un
     * arreglo de Object[] el cual contiene en cada posicion el valor de cada
     * atributo de la instancia.
     *
     * Lo que hacemos es obtener el numero total de campos o atributos de la
     * clase Product en un arreglo de tipo Field[] despues vamos recorriendo
     * cada posicion de este arreglo y obtenemos el contenido de cada campo o
     * atributo para posteriormente almacenarlo en el arreglo de Object[].
     *
     * NOTA: ES IMPORTANTE LA LINEA f.setAccessible(true);
     *
     * Ya que si no la ponemos no nos dejara obtener al contenido de ese
     * atributo y nos lanzara una excepcion.
     *
     * Finalmente vamos obteniendo el contenido de cada campo y lo agregamos en
     * una nueva posicion del arreglo Object[] para retornarlo
     *
     * @param un objeto de tipo Producto
     * @return un arreglo de Object, con todos los datos del Producto
     */
    private Object[] convertToArray(Person p) {
        Field fields[] = Person.class.getDeclaredFields();
        Object[] row = new Object[fields.length];
        int index = 0;
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                row[index++] = f.get(p);
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(PersonTableModelList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return row;
    }

    /**
     * Este metodo lo que hace es crear el modelo de datos a partir de una lista
     * de arreglos de tipo Object, para ello primero comprobamos que la lista
     * que se la pasa por parametros no sea null y que no este vacia.
     *
     * NOTA: Es importante llamar al metodo fireTableDataChanged() para
     * asegurarnos de que los cambios se reflejen en nuestra tabla.
     *
     * @param una lista de arreglos de tipo Object
     */
    private void createModelFromList(List<Object[]> personList) {
        if (personList != null && !personList.isEmpty()) {
            personData = new ArrayList<>(personList);
            fireTableDataChanged();
        } else {
            personData = new ArrayList<>();
            fireTableDataChanged();
        }
    }

    /**
     * Este metodo lo que hace es recibir como parametro una fila o arreglo de
     * tipo Object, va obteniendo el valor/dato de cada posicion del arreglo y
     * lo va asignando a travez de los setters a una instancia de Producto, para
     * posterioemente devolvernos esa instancia de Producto con los datos del
     * arreglo que se pasaron como parametro.
     *
     * @param un arreglo de Ovject, en otras palabras una fila
     * @return un objeto de tipo Producto
     */
    private Person convertToProduct(Object[] row) {
      Person temp = new Person();
      temp.setPersonId(Integer.parseInt(row[0].toString()));
      temp.setFirstName(String.valueOf(row[1]));
     temp.setSecondName(String.valueOf(row[2]));
      
      
        return temp;
    }

}
