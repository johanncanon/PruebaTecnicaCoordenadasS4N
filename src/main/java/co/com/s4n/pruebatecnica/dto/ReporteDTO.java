/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.s4n.pruebatecnica.dto;

/**
 *
 * @author johan.cañon
 */
public class ReporteDTO {
    
    private int x;
    private int y;
    private String direccion;
    private double grados;

    public ReporteDTO() {
    }

    public ReporteDTO(int x, int y, String direccion, double grados) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
        this.grados = grados;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    @Override
    public String toString() {
        return "ReporteDTO{" + "x=" + x + ", y=" + y + ", direccion=" 
                + direccion + ", grados=" + grados + '}';
    }
    
    
}
