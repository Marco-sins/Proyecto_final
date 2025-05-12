/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author marco
 */
public class Carta {
    private int id_carta;
    private int coste;
    private boolean permanente;
    private String nombre;
    private String tipo;
    private boolean disfraz;
    
    public void ejecutar_carta()
    {
        
    }

    public Carta()
    {
        
    }
    
    public Carta(int id_carta, int coste, boolean permanente, String nombre, String tipo, boolean disfraz) {
        this.id_carta = id_carta;
        this.coste = coste;
        this.permanente = permanente;
        this.nombre = nombre;
        this.tipo = tipo;
        this.disfraz = disfraz;
    }

    @Override
    public String toString() {
        return "Carta{" + "id_carta=" + id_carta + ", coste=" + coste + ", permanente=" + permanente + ", nombre=" + nombre + ", tipo=" + tipo + ", disfraz=" + disfraz + '}';
    }

    public void setId_carta(int id_carta) {
        this.id_carta = id_carta;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public void setPermanente(boolean permanente) {
        this.permanente = permanente;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDisfraz(boolean disfraz) {
        this.disfraz = disfraz;
    }

    public int getId_carta() {
        return id_carta;
    }

    public int getCoste() {
        return coste;
    }

    public boolean isPermanente() {
        return permanente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisfraz() {
        return disfraz;
    }
    
}
