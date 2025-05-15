/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kot;

import layout.Cargando;
import layout.Partida;
import java.util.List;
import clases.*;
import javax.swing.*;

/**
 *
 * @author marco
 */
public class Main {

    private static int turno = 1;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cargando cargar = new Cargando();

        cargar.cargar();
    }
    
    public static void siguiente_turno()
    {
        turno += 1;
    }
}
