/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
/**
 *
 * @author marco
 */
public class Usuario {
    private int id_usuario;
    private String nombre;
    private ArrayList<Logro> logros;
    private int victorias;
    private int derrotas;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, ArrayList<Logro> logros, int victorias, int derrotas) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.logros = logros;
        this.victorias = victorias;
        this.derrotas = derrotas;
    }

    public void setLogros(ArrayList<Logro> logros) {
        this.logros = logros;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nombre=" + nombre + ", logros=" + logros + ", victorias=" + victorias + ", derrotas=" + derrotas + '}';
    }


    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList getLogros() {
        return logros;
    }
    
    
}
