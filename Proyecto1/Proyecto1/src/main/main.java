/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package main;
import java.io.StringReader;



public class main {
    public static void main(String[] args) {
        System.out.println("Hola MUNDO");
        analizadores("src/Analizadores/", "Lexico.jflex", "Parser.cup");

        String entrada = """
                         PROGRAM
                         var : double :: valio5 <- 30 end ;
                         var : char[] :: nombre <- "Maria" end ;
                         arr:char[]:: @jfk <- ["mando","mio","helado"] end;
                         END PROGRAM
                         """;

        analizar(entrada);
        System.out.println("Termino");
    }
    
    public static void analizadores(String ruta, String jflexFile, String cupFile) {
        try {
            String opcionesJflex[] = {ruta + jflexFile, "-d", ruta};
            jflex.Main.generate(opcionesJflex);
            System.out.println("Inicio cup");
            String opcionesCup[] = {"-destdir", ruta, "-parser", "Parser", ruta + cupFile};
            java_cup.Main.main(opcionesCup);
            
        } catch (Exception e) {
            System.out.println("No se ha podido generar los analizadores");
            System.out.println(e);
        }
    }

    // Realizar Analisis
    public static void analizar(String entrada) {
        try {
            Analizadores.Lexer lexer = new Analizadores.Lexer(new StringReader(entrada)); //para llamar import o llamamo asi
            Analizadores.Parser parser = new Analizadores.Parser(lexer);
            parser.parse();
        } catch (Exception e) {
            System.out.println("Error fatal en compilación de entrada.");
            System.out.println(e);
        }
   }
    

}
