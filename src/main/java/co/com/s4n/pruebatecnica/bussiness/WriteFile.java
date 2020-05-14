/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.s4n.pruebatecnica.bussiness;

import co.com.s4n.pruebatecnica.dto.ReporteDTO;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author johan.cañon
 */
public class WriteFile {

    private FileWriter fichero = null;
    private PrintWriter pw = null;
    private List<ReporteDTO> listLinesReport;
    
    /**
     * GENERACION DE REPORTES
     * @param listaParams 
     */
    public void imprimirArchivo( List<ReporteDTO> listaParams , String indicativo ) {
        
        try {
            listLinesReport = listaParams;
            fichero = new FileWriter( "D:/out" + indicativo + ".txt" );
            pw = new PrintWriter( fichero );

            for ( ReporteDTO reporteDTO : listLinesReport ) {
                pw.println();
                pw.println("== Reporte de entrega ==");
                pw.println("( " + reporteDTO.getX() + ", " 
                                + reporteDTO.getY() + " ) " 
                                + reporteDTO.getDireccion() );

            }
            System.out.println("FICHERO IMPRESO EN RUTA: " + fichero.toString() );
        } 
        catch ( Exception e ) { e.printStackTrace(); } 
        finally {
            try { if ( null != fichero ) { fichero.close(); } } 
            catch ( Exception e2 ) { e2.printStackTrace(); }
        }

    }

}
