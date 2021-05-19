/*
 * Licencia GPL.
 * Desarrollado por: William Sánchez
 * El software se proporciona "TAL CUAL", sin garantía de ningún tipo,
 * expresa o implícita, incluyendo pero no limitado a las garantías de
 * comerciabilidad y adecuación para un particular son rechazadas.
 * En ningún caso el autor será responsable por cualquier reclamo,
 * daño u otra responsabilidad, ya sea en una acción de contrato,
 * agravio o cualquier otro motivo, de o en relación con el software
 * o el uso u otros tratos en el software.
 * 
 */
package com.ssoftware.pracswing.misc;

/**
 *
 * @author William Sanchez
 */
public class Validator {
    public static boolean isNicaraguanNumberId(String idNumber){
        //la longitud debe ser exactamente de 14 caracteres
        if(idNumber.length()!= 14){
            return false;
        }
        //El último caracter debe ser letra
        if(!Character.isLetter(idNumber.charAt(13))){
            return false;
        }
        //El resto de caracteres deben ser numeros
        if(!(Character.isDigit(idNumber.charAt(0))&&Character.isDigit(idNumber.charAt(1))&&
           Character.isDigit(idNumber.charAt(2))&&Character.isDigit(idNumber.charAt(3))&&     
           Character.isDigit(idNumber.charAt(4))&&Character.isDigit(idNumber.charAt(5))&&
           Character.isDigit(idNumber.charAt(6))&&Character.isDigit(idNumber.charAt(7))&&     
           Character.isDigit(idNumber.charAt(8))&&Character.isDigit(idNumber.charAt(9))&&
           Character.isDigit(idNumber.charAt(10))&&Character.isDigit(idNumber.charAt(11))&&
           Character.isDigit(idNumber.charAt(12)))){
           return false;
        }

        //Los seis caracteres del centro deben conformar una fecha válida
        String birthDate = idNumber.substring(3,9);
        if (!DateOperator.isDate(birthDate,"ddMMyy")) {
            return false;
        }   
        return DateOperator.getAge(DateOperator.stringToDate(getBirthDateFromId(idNumber),"dd-mm-yyyy"))>=16;
    }
    public static String getBirthDateFromId(String idNumber){
        String day = idNumber.substring(3, 5);
        String month = idNumber.substring(5, 7);
        String year = idNumber.substring(7, 9);
        int y = Integer.parseInt(year);

        if (y >= 0 && y <= 29) {
            y += 2000;
        } else {
            y += 1900;
        }
        String date= String.valueOf(y)+"-"+month+ "-" + day;
        return date;    
    }
}
