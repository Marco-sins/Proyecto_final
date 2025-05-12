/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author marco
 */
public class Bot {
    private int id_bot;
    private String nombre;
    
    

    public Bot(int id_bot, String nombre) {
        this.id_bot = id_bot;
        this.nombre = nombre;
    }

    public Bot() {
    }

    public int getId_bot() {
        return id_bot;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId_bot(int id_bot) {
        this.id_bot = id_bot;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Bot{" + "id_bot=" + id_bot + ", nombre=" + nombre + '}';
    }
    
    
}
