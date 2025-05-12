/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author marco
 */
public class Logro {
    private int id_logro;
    private String descripcion;
    private boolean completado;

    public Logro() {
    }

    public Logro(int id_logro, String descripcion, boolean completado) {
        this.id_logro = id_logro;
        this.descripcion = descripcion;
        this.completado = completado;
    }

    public int getId_logro() {
        return id_logro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setId_logro(int id_logro) {
        this.id_logro = id_logro;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }

    @Override
    public String toString() {
        return "Logro{" + "id_logro=" + id_logro + ", descripcion=" + descripcion + ", completado=" + completado + '}';
    }
    
}
