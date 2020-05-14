/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.s4n.pruebatecnica.bussiness;

import co.com.s4n.pruebatecnica.dto.ReporteDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johan.cañon
 */
public class GenerateCoordinates {
    
    private Double conY = 0.0;
    private Double conX = 0.0;
    private double angulo = 90 ;
    private boolean switchX = false;
    private List<char[]> listCoordenadas;
    private String direccion = "";
    List<ReporteDTO> listaEnvios ;
    
    /**
     * 
     * @param coordenadas 
     */
    public List<ReporteDTO> generarCoordenadas( List<char[]> coordenadas ){
        
        listaEnvios = new ArrayList<>();
        listCoordenadas = coordenadas;
        
        for ( char[] arrString : listCoordenadas ) {
            
            //GENERACION EJE Y & X
            for (int i = 0; i < arrString.length; i++) {

                if ( angulo >= 360 ) { angulo = 0;   }
                if ( angulo == -90 ) { angulo = 270; }

                if ( arrString[i] == 'A' ) {
                    if ( switchX == true) {

                        if ( angulo >= 0 && angulo < 91   ) { conX = conX + 1; }
                        else if ( angulo > 91 && angulo < 181  ) { conX = conX - 1; }
                        else if ( angulo > 181 && angulo < 271 ) { conX = conX - 1; }
                        else if ( angulo > 271 && angulo < 361 ) { conX = conX + 1; }

                    } else {                  
                        if ( angulo >= 0 && angulo < 91   ) { conY = conY + 1; }
                        else if ( angulo > 91 && angulo < 181  ) { conY = conY + 1; }
                        else if ( angulo > 181 && angulo < 271 ) { conY = conY - 1; }
                        else if ( angulo > 271 && angulo < 361 ) { conY = conY - 1; }
                    }
                }
                if ( arrString[i] == 'I' ) {
                    if ( switchX == true ){ switchX = false; } else { switchX = true; }
                    angulo = angulo + 90;
                }
                if ( arrString[i] == 'D' ) {
                    if ( switchX == true ){ switchX = false; } else { switchX = true; }
                    angulo = angulo - 90;
                }             
            }
            generarDireccion( angulo );
            ReporteDTO reporte = new ReporteDTO( conX.intValue(), conY.intValue(), direccion, angulo );
            listaEnvios.add( reporte );
            
            //Limpieza de parametros
            switchX = false;
            angulo = 90;
            conX = 0.0;
            conY = 0.0;
        }
        return listaEnvios;
    }
    
    /**
     * 
     * @param anguloParam
     * @return anguloParam
     */
    private void generarDireccion ( double anguloParam ){
          //DEFINICION DIRECCION
        if ( anguloParam == 90  ) { direccion = "Norte.";     }
        if ( anguloParam == 180 ) { direccion = "Occidente."; }
        if ( anguloParam == 270 ) { direccion = "Sur.";       }
        if ( anguloParam == 0   ) { direccion = "Oriente.";   } 

    }
    
}
