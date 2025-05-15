/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Dado 
{    
    public List<Integer> tirar_dados(int n)
    {
        List<Integer> dados = new ArrayList<>();
        while (n > 0)
        {
            int num = (int)(Math.random() * 6 + 1);
            dados.add(num);
            n--;
        }
        return (dados);
    }
    
    public static List<Integer> volver_a_tirar(List<Boolean> indices, List<Integer> dados)
	{
            int i = 0;
            while (i < 6)
            {
                    if (!indices.get(i))
                        dados.set(i, (int)(Math.random() * 6 + 1));
                    i++;
            }
            return (dados);
	}
}
