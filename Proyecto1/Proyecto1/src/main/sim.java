/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;

/**
 *
 * @author pakal
 */
public class sim {
    
    private String simbolo;
    private String tipo;
    ArrayList<String> arreglo; 
    
    public sim(String simbolo, String tipo, ArrayList<String> arreglo) {
        this.simbolo = simbolo;
        this.tipo = tipo;
        this.arreglo = arreglo;
    }

    public ArrayList<String> getArreglo() {
        return arreglo;
    }

    public void setArreglo(ArrayList<String> arreglo) {
        this.arreglo = arreglo;
    }

    
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    @Override
    public String toString() {
        if (arreglo != null) {
            return "Isimbolo: " + simbolo + ", Tipo: " + tipo + ", arreglo: " + arreglo;
        } else {
            return "Isimbolo: " + simbolo + ", Tipo: " + tipo;
        }
    }
    public String obtenerValorNoNulo() {
        if (simbolo != null) {
            return simbolo;
        } else if (arreglo != null) {
            // Si el símbolo es nulo pero el arreglo no lo es,
            // se imprime el arreglo como una cadena
            return arreglo.toString();
        } else {
            // Si tanto el símbolo como el arreglo son nulos,
            // se devuelve una cadena vacía
            return "";
        }
    }

}
