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
    private int id_carta;
    private int vida;
    private int exp;
    private int ryos;
    private boolean in_tokio;
    private ArrayList<Carta> cartas;

    public void ganar_vida(int vida)
    {
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
    
    public Personaje(int id_carta, int vida, int exp, int ryos, boolean in_tokio, ArrayList<Carta> cartas) {
        this.id_carta = id_carta;
        this.vida = vida;
        this.exp = exp;
        this.ryos = ryos;
        this.in_tokio = in_tokio;
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        return "Personaje{" + "id_carta=" + id_carta + ", vida=" + vida + ", exp=" + exp + ", ryos=" + ryos + ", in_tokio=" + in_tokio + ", cartas=" + cartas + '}';
    }

    public void setId_carta(int id_carta) {
        this.id_carta = id_carta;
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

    public void setCartas(ArrayList cartas) {
        this.cartas = cartas;
    }

    public int getId_carta() {
        return id_carta;
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
