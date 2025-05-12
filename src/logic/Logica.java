/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import layout.Partida;

/**
 *
 * @author marco
 */
public class Logica 
{
    public static void empezar_partida(int players)
    {
        if (players <= 4 && players >= 2)
        {
            Partida partida = new Partida(players);
        }
        else
        {
            
        }
    }
}
