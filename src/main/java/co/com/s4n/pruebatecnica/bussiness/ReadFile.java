/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.s4n.pruebatecnica.bussiness;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author johan.cañon
 */
public class ReadFile {
    
    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private char[] charLectura;
    private List<char[]> listLines;
    
    /**
     * LECTURA DE ARCHIVO CON COORDENADAS
     * 
     * @param ruta
     * @return 
     */
    public List<char[]> leerArchivo( String ruta ) {         
        try {
            listLines = new ArrayList<>();            
            archivo   = new File( ruta );
            fr = new FileReader( archivo );
            br = new BufferedReader( fr );
            String linea;
            while ( ( linea = br.readLine() ) != null ) {
                charLectura = linea.toCharArray();
                listLines.add( charLectura );
                System.out.println("LECTURA DESDE EL ARCHIVO: " + linea);
            }
        } catch ( Exception e ) { e.printStackTrace(); return new ArrayList<>(); } 
        finally {
            try { if ( null != fr ) { fr.close(); } } 
            catch ( Exception e2 ) { e2.printStackTrace(); return new ArrayList<>(); }
        }

        return listLines;
    }

}
