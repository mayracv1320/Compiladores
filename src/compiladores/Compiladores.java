/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiladores;

import JFlex.Main;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ASUS
 */
public class Compiladores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String ruta1 = "D:/Multimedia/Documentos/NetBeansProjects/compiladores/src/compiladores/Lexico.flex";
        String ruta2 = "D:/Multimedia/Documentos/NetBeansProjects/compiladores/src/compiladores/LexerCup.flex";
        
        String[] rutas = {"-parser", "Sintax", "D:/Multimedia/Documentos/NetBeansProjects/compiladores/src/compiladores/Sintax.cup"};
        generar(ruta1, ruta2, rutas);
            try {
                // TODO code application logic here
                // un estilo al formulario
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                
            }

            inicio sistema = new inicio();
            // para abrirlo y maximizar
            sistema.setExtendedState(MAXIMIZED_BOTH);
            sistema.setVisible(true);
        }
        public static void generar(String ruta1 , String ruta2, String[] rutas) throws IOException, Exception{
            File archivo;
            archivo = new File(ruta1);
            JFlex.Main.generate(archivo);
            archivo = new File(ruta2);
            JFlex.Main.generate(archivo);
            java_cup.Main.main(rutas);
            
            Path rutaSym = Paths.get("D:/Multimedia/Documentos/NetBeansProjects/compiladores/src/compiladores/sym.java");
            if(Files.exists(rutaSym)){
                Files.delete(rutaSym);
            }
            Files.move(
                    Paths.get("D:/Multimedia/Documentos/NetBeansProjects/compiladores/sym.java"), 
                    Paths.get("D:/Multimedia/Documentos/NetBeansProjects/compiladores/src/compiladores/sym.java")
            );
            
            Path rutaSin = Paths.get("D:/Multimedia/Documentos/NetBeansProjects/compiladores/src/compiladores/Sintax.java");
            if(Files.exists(rutaSin)){
                Files.delete(rutaSin);
            }
            Files.move(
                    Paths.get("D:/Multimedia/Documentos/NetBeansProjects/compiladores/Sintax.java"), 
                    Paths.get("D:/Multimedia/Documentos/NetBeansProjects/compiladores/src/compiladores/Sintax.java")
            );
        }
    
}
