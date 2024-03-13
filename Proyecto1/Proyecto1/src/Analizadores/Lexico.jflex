package Analizadores;
import java_cup.runtime.*;
import java.util.ArrayList;  
import main.*;
%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line

%ignorecase
%function next_token

%{
    StringBuffer buffer = new StringBuffer();

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
%eofval{
    return new Symbol(ParserSym.EOF, -1, -1, null);
%eofval} 

// ------> Expresiones Regulares 

entero = [0-9]
cadena = (\"|"“")[^\"\n]*(\"|"”")
decimal = [0-9]+(\.[0-9]+)?
comentario = "!"~\n
comentariom="<""!"~"!"">"
id = {Letra}({Letra}|{entero}|"_"|"-")*
Letra  = [a-z]
idarreglo = "@"{id}


%%
// ------------  Reglas Lexicas -------------------
//   Palabras reservas
<YYINITIAL> {
"program"   { cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
              return new Symbol(ParserSym.RPROGRAM, yycolumn, yyline, yytext());}
"end"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.REND, yycolumn, yyline, yytext());}
"var"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RVAR, yycolumn, yyline, yytext());}
"char[]"    {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RCHAR, yycolumn, yyline, yytext());}
"double"    {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RDOUBLE, yycolumn, yyline, yytext());}
"arr"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RARR, yycolumn, yyline, yytext());}
"sum"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RSUM, yycolumn, yyline, yytext());}
"res"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RRES, yycolumn, yyline, yytext());}
"mul"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RMUL, yycolumn, yyline, yytext());}
"div"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RDIV, yycolumn, yyline, yytext());}
"mod"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RMOD, yycolumn, yyline, yytext());}
"media"     {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RMEDIA, yycolumn, yyline, yytext());}
"mediana"   {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RMEDIANA, yycolumn, yyline, yytext());}
"moda"      {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RMODA, yycolumn, yyline, yytext());}
"varianza"  {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RVARIANZA, yycolumn, yyline, yytext());}
"max"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RMAX, yycolumn, yyline, yytext());}
"min"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RMIN, yycolumn, yyline, yytext());}
"console"   {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RCONSOLE, yycolumn, yyline, yytext());}
"print"     {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RPRINT, yycolumn, yyline, yytext());}
"column"    {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RCOLUMN, yycolumn, yyline, yytext());}
"graphbar"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RBAR, yycolumn, yyline, yytext());}
"graphline"      {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RLINE, yycolumn, yyline, yytext());}
"graphpie"       {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RPIE, yycolumn, yyline, yytext());}
"histogram" {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
                return new Symbol(ParserSym.RHISTOGRAM, yycolumn, yyline, yytext());}
"titulo"    {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RTITULO, yycolumn, yyline, yytext());}
"ejex"      {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.REJEX, yycolumn, yyline, yytext());}
"ejey"      {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.REJEY, yycolumn, yyline, yytext());}
"titulox"   {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RTITULOX, yycolumn, yyline, yytext());}
"tituloy"   {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RTITULOY, yycolumn, yyline, yytext());}
"exec"      {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.REXEC, yycolumn, yyline, yytext());}
"values"    {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RVALUES, yycolumn, yyline, yytext());}
"label"     {cosaspublicas.tokens.add(new token(yytext(),"Palabra Reservada",yyline,yycolumn));
            return new Symbol(ParserSym.RLABEL, yycolumn, yyline, yytext());}


// Simbolos
"("         {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.PARIZQ, yycolumn, yyline, yytext());}
")"         {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.PARDER, yycolumn, yyline, yytext());}
","         {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.COMA, yycolumn, yyline, yytext());}
"="         {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.IGUAL, yycolumn, yyline, yytext());}
";"         {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.PYC, yycolumn, yyline, yytext());}
":"         {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.DOSP, yycolumn, yyline, yytext());}
"::"        {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.CUATROP, yycolumn, yyline, yytext());}
"<-"        {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.MENORQUE, yycolumn, yyline, yytext());}
"->"        {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.MAYORQUE, yycolumn, yyline, yytext());}
"["         {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.CORA, yycolumn, yyline, yytext());}
"]"         {cosaspublicas.tokens.add(new token(yytext(),"Simbolos",yyline,yycolumn));
            return new Symbol(ParserSym.CORC, yycolumn, yyline, yytext());}

// Operadores

// Expresiones
{decimal}    {cosaspublicas.tokens.add(new token(yytext(),"Double",yyline,yycolumn));
                return new Symbol(ParserSym.DECIMAL, yycolumn, yyline, yytext()); }
{cadena}    {cosaspublicas.tokens.add(new token(yytext(),"CHAR",yyline,yycolumn));
            return new Symbol(ParserSym.CADENA, yycolumn, yyline, yytext());}
{id}        {cosaspublicas.tokens.add(new token(yytext(),"ID",yyline,yycolumn));
            return new Symbol(ParserSym.ID, yycolumn, yyline, yytext());}
{idarreglo} {cosaspublicas.tokens.add(new token(yytext(),"Id",yyline,yycolumn));
                return new Symbol(ParserSym.IDARREGLO, yycolumn, yyline, yytext());}
{comentario} {}
{comentariom} {}
}


//------> Ingorados
<YYINITIAL> [ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
[^] { cosaspublicas.errores.add(new token("Lexico",yytext()+" no pertenece al lenguaje",yyline,yycolumn));
System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }