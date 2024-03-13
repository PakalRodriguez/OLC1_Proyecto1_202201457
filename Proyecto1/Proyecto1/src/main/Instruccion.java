/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
    public static void imprimirHashMap(HashMap<String, sim> hashMap) {
        System.out.println("Contenido del HashMap:");

        for (Map.Entry<String, sim> entry : hashMap.entrySet()) {
            String clave = entry.getKey();
            sim valor = entry.getValue();
            System.out.println("Clave: " + clave  + valor.toString());
            if (valor.getArreglo() != null) {
                System.out.println("qArreglo: " + valor.getArreglo());
            } else {
                System.out.println(valor.toString());
            }
        }
    }

    
    public static float media(ArrayList<String> arreglo) {
    // Convertir elementos a float
        ArrayList<Float> elementos = new ArrayList<>();
        for (String elemento : arreglo) {
            try {
                elementos.add(Float.valueOf(elemento));
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir elemento a float: " + e.getMessage());
            }
        }

        // Calcular media
        float suma = 0;
        for (float numero : elementos) {
            suma += numero;
        }
        return suma / elementos.size();
    }

public static float moda(ArrayList<String> arreglo) {
    // Convertir elementos a float
    ArrayList<Float> elementos = new ArrayList<>();
    for (String elemento : arreglo) {
        try {
            elementos.add(Float.valueOf(elemento));
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir elemento a float: " + e.getMessage());
        }
    }

    // Calcular moda
    float moda = 0;
    int maximo = 0;
    for (int i = 0; i < elementos.size(); i++) {
        int contador = 0;
        for (int j = 0; j < elementos.size(); j++) {
            if (elementos.get(j).equals(elementos.get(i))) { // Usar equals para comparar Floats
                contador++;
            }
        }
        if (contador > maximo) {
            moda = elementos.get(i);
            maximo = contador;
        }
    }
    return moda;
}


    public static float mediana(ArrayList<String> arreglo) {
        // Convertir elementos a float
        ArrayList<Float> elementos = new ArrayList<>();
        for (String elemento : arreglo) {
            try {
                elementos.add(Float.valueOf(elemento));
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir elemento a float: " + e.getMessage());
            }
        }

        // Calcular mediana
        Collections.sort(elementos);
        int n = elementos.size();
        if (n % 2 == 0) {
            return (elementos.get(n / 2) + elementos.get(n / 2 - 1)) / 2;
        } else {
            return elementos.get(n / 2);
        }
    }
public static float varianza(ArrayList<String> arreglo) {
    // Convertir elementos a double
    ArrayList<Double> elementos = new ArrayList<>();
    for (String elemento : arreglo) {
        try {
            elementos.add(Double.valueOf(elemento));
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir elemento a double: " + e.getMessage());
        }
    }

    // Calcular media
    double suma = 0;
    for (Double num : elementos) {
        suma += num;
    }
    double media = suma / elementos.size();

    // Calcular varianza
    double sumatoria = 0;
    for (Double num : elementos) {
        sumatoria += Math.pow(num - media, 2);
    }
    double varianza = sumatoria / elementos.size();

    return (float) varianza; // Convertir varianza a float si es necesario
}


    public static float maximo(ArrayList<String> arreglo) {
        // Convertir elementos a float
        ArrayList<Float> elementos = new ArrayList<>();
        for (String elemento : arreglo) {
            try {
                elementos.add(Float.parseFloat(elemento));
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir elemento a float: " + e.getMessage());
            }
        }

        // Calcular máximo
        float max = Float.MIN_VALUE;
        for (float numero : elementos) {
            if (numero > max) {
                max = numero;
            }
        }
        return max;
    }

    public static float minimo(ArrayList<String> arreglo) {
        // Convertir elementos a float
        ArrayList<Float> elementos = new ArrayList<>();
        for (String elemento : arreglo) {
            try {
                elementos.add(Float.parseFloat(elemento));
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir elemento a float: " + e.getMessage());
            }
        }

        // Calcular mínimo
        float min = Float.MAX_VALUE;
        for (float numero : elementos) {
            if (numero < min) {
                min = numero;
            }
        }
        return min;
    }

    
}
