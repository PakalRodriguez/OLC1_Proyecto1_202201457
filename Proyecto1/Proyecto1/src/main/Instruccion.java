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
public class Instruccion {
    
    public void imprimirVariables(ArrayList<String> lista){
                //debe recibir un array list e imprimirlo puede tenner un solo elemento se separan por ,
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            sb.append(lista.get(i));
            if (i < lista.size() - 1) {
                sb.append(", "); // Agregar coma y espacio entre elementos
            }
        }
        System.out.println(sb.toString());
    }
}
