/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author marco
 */
public class Carta_evolucion {
    private int id_personaje;
    private int id_carta;
    private String nombre;
    private String descripcion;
    private String tipo;

    public Carta_evolucion(int id_personaje, int id_carta, String nombre, String descripcion, String tipo) {
        this.id_personaje = id_personaje;
        this.id_carta = id_carta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Carta_evolucion() {
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getId_personaje() {
        return id_personaje;
    }

    public int getId_carta() {
        return id_carta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId_personaje(int id_personaje) {
        this.id_personaje = id_personaje;
    }

    public void setId_carta(int id_carta) {
        this.id_carta = id_carta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Carta_evolucion{" + "id_personaje=" + id_personaje + ", id_carta=" + id_carta + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + '}';
    }
    
    
}
