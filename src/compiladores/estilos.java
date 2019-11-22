/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores;

import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class estilos {
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","valor"};
       
       String [] registro =new String [2];
       modelo = new DefaultTableModel(null,titulos);
       
       try {
           ArrayList lista = new ArrayList();
           ArrayList datos = new ArrayList();
           lista.add("   id1");lista.add("   id2");lista.add("   id3");lista.add("   id4");lista.add("   id5");
           lista.add("   id6");lista.add("   id7");lista.add("   id8");lista.add("   id9");lista.add("   id10");
           lista.add("   id11");lista.add("   id12");lista.add("   id13");lista.add("   id14");lista.add("   id15");
           lista.add("   id16");lista.add("   id17");lista.add("   id18");lista.add("   id19");lista.add("   id20");
           lista.add("   id21");lista.add("   id22");lista.add("   id23");lista.add("   id24");lista.add("   id25");
           lista.add("   id26");
           /*
           lista.add("   ELLIPSIS");lista.add("   COLONCOLON");lista.add("   DOTSTAR");lista.add("   ADDEQ");
           lista.add("   SUBEQ");lista.add("   MULEQ");lista.add("   DIVEQ");lista.add("   MODEQ");
           lista.add("   XOREQ");lista.add("   ANDEQ");lista.add("   OREQ");lista.add("   SL");
           lista.add("   SR");lista.add("   SLEQ");lista.add("   SREQ");lista.add("   EQ");
           lista.add("   NOTEQ");lista.add("   LTEQ");lista.add("   GTEQ");lista.add("   ANDAND");
           lista.add("   OROR");lista.add("   PLUSPLUS");lista.add("   MINUSMINUS");lista.add("   ARROWSTAR");
           lista.add("   ARROW");lista.add("   ASM");lista.add("   AUTO");lista.add("   BOOL");
           lista.add("   BREAK");lista.add("   CASE");lista.add("   CATCH");lista.add("   CHAR");
           lista.add("   CLASS");lista.add("   CONST");lista.add("   CONST_CAST");lista.add("   CONTINUE");
           lista.add("   DEFAULT");lista.add("   DELETE");lista.add("   DO");lista.add("   DOUBLE");
           lista.add("   DYNAMIC_CAST");lista.add("   ELSE");lista.add("   ENUM");lista.add("   EXPLICIT");
           lista.add("   EXPORT");lista.add("   EXTERN");lista.add("   FALSE");lista.add("   FLOAT");
           lista.add("   FOR");lista.add("   FRIEND");lista.add("   GOTO");lista.add("   IF");
           lista.add("   INLINE");lista.add("   INT");lista.add("   LONG");lista.add("   MUTABLE");
           lista.add("   NAMESPACE");lista.add("   NEW");lista.add("   OPERATOR");lista.add("   PRIVATE");
           lista.add("   PROTECTED");lista.add("   PUBLIC");lista.add("   REGISTER");lista.add("   REINTERPRET_CAST");
           lista.add("   RETURN");lista.add("   SHORT");lista.add("   SIGNED");lista.add("   SIZEOF");
           lista.add("   STATIC");lista.add("   STATIC_CAST");lista.add("   STRUCT");lista.add("   SWITCH");
           lista.add("   TEMPLATE");lista.add("   THIS");lista.add("   THROW");lista.add("   TRUE");
           lista.add("   TRY");lista.add("   TYPEDEF");lista.add("   TYPEID");lista.add("   TYPENAME");
           lista.add("   UNION");lista.add("   UNSIGNED");lista.add("   USING");lista.add("   VIRTUAL");
           lista.add("   VOID");lista.add("   VOLATILE");lista.add("   WCHAR_T");lista.add("   WHILE");
           lista.add("   ident");lista.add("   numero");
           */
           datos.add("{          <%");datos.add("}           %>");datos.add("[           <:");datos.add("]           :>");
           datos.add("(");datos.add(" )");datos.add(";");datos.add(":");
           datos.add("?");datos.add(" .");datos.add("+");datos.add("-");
           datos.add("*");datos.add(" /");datos.add("%");datos.add("^            xor");
           datos.add("&");datos.add(" bitand");datos.add("|          bitor");datos.add("~         compl");
           datos.add("!         not");datos.add("=");datos.add("<");datos.add(">");
           datos.add(",");datos.add("#");
           
           
           for(int x=0;x<lista.size();x++) {
               registro [0]=(String) lista.get(x);
               registro [1]=(String) datos.get(x);
               modelo.addRow(registro);
           }
               
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
       
       
   }
    
   public void mostrarLexico(String buscar, JTextArea jTextArea2)throws IOException{
       DefaultTableModel modelo;
        File archivo = new File("archivo.txt");
        PrintWriter escribir;
        try {
            escribir = new PrintWriter(archivo);
            escribir.print(buscar);
            escribir.close();
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File archivo2 = new File("archivo.cpp");
        PrintWriter escribir2;
        try {
            escribir2 = new PrintWriter(archivo2);
            escribir2.print(buscar);
            escribir2.close();
        } catch (FileNotFoundException ex) {
            // Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
        }
            int con = 1;
            Lexer lexer = new Lexer(new StringReader(buscar));
            String resultado = "LINEA " + con + "\t\tSIMBOLO\n";
            while(true){
                Tokens token = lexer.yylex();
                if(token == null){
                    jTextArea2.setText(resultado);
                    return;
                }
                switch(token){
                    case Linea:
                        con++;
                        resultado += "LINEA " + con + "\n";
                        break;
                    case INT:
                        resultado += "<Reservada int>\t" + lexer.lexeme + "\n";
                        break;
                    case LONG:
                        resultado += "<Reservada long>\t" + lexer.lexeme + "\n";
                        break;
                    case CHAR:
                        resultado += "<Reservada char>\t" + lexer.lexeme + "\n";
                        break;    
                }
            }
   }
}
