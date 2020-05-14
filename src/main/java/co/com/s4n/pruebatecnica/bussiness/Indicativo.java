/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.s4n.pruebatecnica.bussiness;

/**
 *
 * @author johan.cañon
 */
public class Indicativo {
    
    public String getNumero( String nombreArchivo ){
        
        char nombreDiv[] = nombreArchivo.toCharArray();
        String indicativo = "";
        for (int i = 0; i < nombreDiv.length; i++) {
            if ( Character.isDigit( nombreDiv[i] ) ) {
                indicativo += nombreDiv[i];
            }
        }
        return indicativo;
    }
    
}
