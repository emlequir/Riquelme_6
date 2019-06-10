/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContextoProblema;

/**
 *
 * @author licho
 */
public class Celular {
    private String modelo;
    private double pantalla;

    public Celular(String modelo, double pantalla) {
        this.modelo = modelo;
        this.pantalla = pantalla;
    }

    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPantalla() {
        return pantalla;
    }

    public void setPantalla(double pantalla) {
        this.pantalla = pantalla;
    }

    @Override
    public String toString() {
        return  "Modelo: " + modelo +"\n"+ "Pantalla: " + pantalla;
    }
    
    
}
