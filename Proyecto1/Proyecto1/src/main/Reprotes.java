/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author evams
 */
public class Reprotes {
    
    public static void generateHTML() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reporte de Tokens.html"))) {
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>TABLA DE TOKEN</title>\n");
            writer.write("<style>\n");
            writer.write("table {\n");
            writer.write("    width: 100%;\n");
            writer.write("    border-collapse: collapse;\n");
            writer.write("}\n");
            writer.write("table, th, td {\n");
            writer.write("    border: 1px solid black;\n");
            writer.write("}\n");
            writer.write("th, td {\n");
            writer.write("    padding: 10px;\n");
            writer.write("    text-align: left;\n");
            writer.write("}\n");
            writer.write("th {\n");
            writer.write("    background-color: #f2f2f2;\n");
            writer.write("}\n");
            writer.write("</style>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h2>TABLA DE TOKEN</h2>\n");
            writer.write("<table>\n");
            writer.write("<tr>\n");
            writer.write("<th>Token</th>\n");
            writer.write("<th>Tipo</th>\n");
            writer.write("<th>Fila</th>\n");
            writer.write("<th>Columna</th>\n");
            writer.write("</tr>\n");
            for (token token : cosaspublicas.tokens) {
                writer.write("<tr>\n");
                writer.write("<td>" + token.getToken() + "</td>\n");
                writer.write("<td>" + token.getTipo() + "</td>\n");
                writer.write("<td>" + token.getFila() + "</td>\n");
                writer.write("<td>" + token.getColumna() + "</td>\n");
                writer.write("</tr>\n");
            }
            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.write("</html>\n");
  
            Desktop.getDesktop().browse(new File("Reporte de Tokens.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void generateHTMLERRORES() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Reporte de Errores.html"))) {
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html>\n");
            writer.write("<head>\n");
            writer.write("<title>TABLA DE ERRORES</title>\n");
            writer.write("<style>\n");
            writer.write("table {\n");
            writer.write("    width: 100%;\n");
            writer.write("    border-collapse: collapse;\n");
            writer.write("}\n");
            writer.write("table, th, td {\n");
            writer.write("    border: 1px solid black;\n");
            writer.write("}\n");
            writer.write("th, td {\n");
            writer.write("    padding: 10px;\n");
            writer.write("    text-align: left;\n");
            writer.write("}\n");
            writer.write("th {\n");
            writer.write("    background-color: #f2f2f2;\n");
            writer.write("}\n");
            writer.write("</style>\n");
            writer.write("</head>\n");
            writer.write("<body>\n");
            writer.write("<h2>TABLA DE ERRORES</h2>\n");
            writer.write("<table>\n");
            writer.write("<tr>\n");
            writer.write("<th>Tipo</th>\n");
            writer.write("<th>Descripcion</th>\n");
            writer.write("<th>Fila</th>\n");
            writer.write("<th>Columna</th>\n");
            writer.write("</tr>\n");
            for (token token : cosaspublicas.errores) {
                writer.write("<tr>\n");
                writer.write("<td>" + token.getToken() + "</td>\n");
                writer.write("<td>" + token.getTipo() + "</td>\n");
                writer.write("<td>" + token.getFila() + "</td>\n");
                writer.write("<td>" + token.getColumna() + "</td>\n");
                writer.write("</tr>\n");
            }
            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.write("</html>\n");
  
            Desktop.getDesktop().browse(new File("Reporte de Errores.html").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
