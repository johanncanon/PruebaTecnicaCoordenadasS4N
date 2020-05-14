/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.s4n.pruebatecnica;

import co.com.s4n.pruebatecnica.bussiness.GenerateCoordinates;
import co.com.s4n.pruebatecnica.bussiness.Indicativo;
import co.com.s4n.pruebatecnica.bussiness.WriteFile;
import co.com.s4n.pruebatecnica.bussiness.ReadFile;
import co.com.s4n.pruebatecnica.dto.ReporteDTO;
import java.util.List;

/**
 *
 * @author johan.cañon
 */
public class Main {

    public static void main(String[] args) {

        ReadFile leerArchivo = new ReadFile();
        Indicativo indicativo = new Indicativo();
        
        String ruta = "D:\\in010.txt";            
        /**
         * Genera las listas de parametros segun la lectura del archivo en dicha ruta
         */
        List<char[]> listCoordenadas = leerArchivo.leerArchivo( ruta );        
        /**
         * Se generan las coordenadas apartir de la lectura del archivo
         */
        GenerateCoordinates coordObj = new GenerateCoordinates();
        List<ReporteDTO> listadoReportes = coordObj.generarCoordenadas( listCoordenadas );        
        /**
         * Se imprime el archivo con las coordenadas generadas anteriormente
         */
        WriteFile imprimirReposrtes = new WriteFile();       
        imprimirReposrtes.imprimirArchivo( listadoReportes , indicativo.getNumero(ruta) );
        
    }
}
