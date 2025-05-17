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
public class Personaje {
    private String nombre;
    private int vida = 10;
    private int exp = 0;
    private int ryos = 0;
    private boolean in_tokio;
    private boolean vivo = true;
    private ArrayList<Carta> cartas = null;

    public Personaje(String nombre, boolean in_tokio) {
        this.nombre = nombre;
        this.in_tokio = in_tokio;
    }
    
    public boolean isVivo() {
        return vivo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    public void ganar_vida(int vida)
    {
        if (this.vida < 10)
            this.vida += vida;
    }
    
    public void perder_vida(int vida)
    {
        this.vida -= vida;
    }
    
    public void ganar_exp(int exp)
    {
        this.exp += exp;
    }
    
    public void perder_exp(int exp)
    {
        this.exp -= exp;
    }
    
    public void ganar_ryos(int ryos)
    {
        this.ryos += ryos;
    }
    
    public void perder_ryos(int ryos)
    {
        this.ryos -= ryos;
    }
    
    public Personaje()
    {
        
    }
    
    @Override
    public String toString() {
        return "Personaje{ vida=" + vida + ", exp=" + exp + ", ryos=" + ryos + ", in_tokio=" + in_tokio + ", cartas=" + cartas + '}';
    }


    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setRyos(int ryos) {
        this.ryos = ryos;
    }

    public void setIn_tokio(boolean in_tokio) {
        this.in_tokio = in_tokio;
    }

    public int getVida() {
        return vida;
    }

    public int getExp() {
        return exp;
    }

    public int getRyos() {
        return ryos;
    }

    public boolean isIn_tokio() {
        return in_tokio;
    }

    public ArrayList getCartas() {
        return cartas;
    }
}
