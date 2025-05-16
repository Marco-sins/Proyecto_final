/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package layout;

import javax.swing.*;
import java.util.List;
import clases.Personaje;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author marco
 */
public class Partida extends javax.swing.JFrame {
    /**
     * Creates new form Partida
     */
    private int turno = 0;
    private boolean estan_dados = false;
    private List<Personaje> personajes = new ArrayList<>();
    private List<JComboBox> bicho_elegido = new ArrayList<>();
    private List<JTextField> campos = new ArrayList<>();
    private List<JComboBox> ia_o_humano = new ArrayList<>();
    private Dados dado = null;
    private int players;

    public Partida(int players, List<JTextField> list, List<JComboBox> bicho, List<JComboBox> ia) {
        this.bicho_elegido = bicho;
        this.campos = list;
        this.ia_o_humano = ia;
        this.players = players;
        initComponents();
        iniciar_todo();
        set_menus();
        colocar_paneles(players);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    private void iniciar_todo()
    {   
        Personaje pj1 = new Personaje(campos.get(0).getText(), true);
        personajes.add(0, pj1);
        Personaje pj2 = new Personaje(campos.get(1).getText(), false);
        personajes.add(1, pj2);
        if (players >= 3)
        {
            Personaje pj3 = new Personaje(campos.get(2).getText(), false);
            personajes.add(2, pj3);
        }
        if (players >= 4)
        {
            Personaje pj4 = new Personaje(campos.get(3).getText(), false);
            personajes.add(3, pj4);
        }
    }
    
    private void set_menus()
    {
        //Player1 
        nombre.setText("Nombre: " + (campos.get(0).getText()));
        vida.setText("Vida: " + (personajes.get(0).getVida()));
        exp.setText("Exp: " + (personajes.get(0).getExp()));
        rayos.setText("Rayos: " + (personajes.get(0).getRyos()));
        
        //Player2
        nombre2.setText("Nombre: " + (campos.get(1).getText()));
        vida2.setText("Vida: " + (personajes.get(1).getVida()));
        exp2.setText("Exp: " + (personajes.get(1).getExp()));
        rayos2.setText("Rayos: " + (personajes.get(1).getRyos()));
        
        //Player3
        if (players >= 3)
        {
            nombre3.setText("Nombre: " + (campos.get(2).getText()));
            vida3.setText("Vida: " + (personajes.get(2).getVida()));
            exp3.setText("Exp: " + (personajes.get(2).getExp()));
            rayos3.setText("Rayos: " + (personajes.get(2).getRyos()));
        }
        
        //Player4
        if (players >= 4)
        {
            nombre4.setText("Nombre: " + (campos.get(3).getText()));
            vida4.setText("Vida: " + (personajes.get(3).getVida()));
            exp4.setText("Exp: " + (personajes.get(3).getExp()));
            rayos4.setText("Rayos: " + (personajes.get(3).getRyos()));
        }
        Iterator<Personaje> it = personajes.iterator();
        String str;
        while (it.hasNext())
        {
            Personaje p = it.next();
            if (p.isIn_tokio())
                en_tokio.setText("En tokio: " + p.getNombre());
        }
        
        if (turno % players == 0)
        {
            Personaje p = personajes.get(0);
            turno_de.setText("Turno de: " + p.getNombre());
        }
        else if (turno % players == 1)
        {
            Personaje p = personajes.get(1);
            turno_de.setText("Turno de: " + p.getNombre());
        }
        else if (turno % players == 2)
        {
           Personaje p = personajes.get(2);
           turno_de.setText("Turno de: " + p.getNombre());
        }
        else if (turno % players == 3)
        {
           Personaje p = personajes.get(3);
           turno_de.setText("Turno de: " + p.getNombre());
        }
        this.revalidate();
        this.repaint();
    }
    
    public void colocar_paneles(int players)
    {
        if (players == 2)
        {
            jPanel2.remove(jugador3_panel);
            jPanel2.remove(jugador4_panel);
        }
        else if (players == 3)
        {
            jPanel2.remove(jugador4_panel);
        }
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    
    private void solve_dados()
    {
        List<Integer> list_dado = dado.getResult();
        Personaje p = null;
        
        if ((turno - 1) % players == 0)
        {
             p = personajes.get(0);
        }
        else if ((turno - 1) % players == 1)
        {
            p = personajes.get(1);
        }
        else if ((turno - 1) % players == 2)
        {
            p = personajes.get(2);
        }
        else if ((turno - 1) % players == 3)
        {
            p = personajes.get(3);
        }
        
        if (p.isIn_tokio() && turno != 0)
            p.ganar_exp(1);
        solve_dados2(p, list_dado);
    }
    
    private void solve_dados2(Personaje p, List<Integer> dados)
    {
        int uno = 0;
        int dos = 0;
        int tres = 0;
        boolean b = false;
        boolean dialogo = false;
        Iterator<Integer> it = dados.iterator();
        while (it.hasNext())
        {
            int n = it.next();
            if (n == 1)
                uno++;
            else if (n == 2)
                dos++;
            else if (n == 3)
                tres++;
            else if (n == 4)
            {
                if (!p.isIn_tokio())
                    p.ganar_vida(1);
            }
            else if (n == 5)
            {
                Iterator<Personaje> it2 = personajes.iterator();
                if (p.isIn_tokio())
                {
                    while (it2.hasNext())
                    {
                        Personaje pj = it2.next();
                        if (pj != p)
                            pj.perder_vida(1);
                    }
                }
                else
                {
                    while (it2.hasNext())
                    {
                        Personaje pj = it2.next();
                        if (pj != p)
                        {
                            if (pj.isIn_tokio())
                            {
                                pj.perder_vida(1);
                                if (!dialogo)
                                {
                                    Salir_de_tokio s = new Salir_de_tokio(this, true);
                                    b = s.get_salir();
                                    dialogo = true;
                                }
                            }
                        }
                    }
                }
            }
            else if (n == 6)
            {
                p.ganar_ryos(1);
            }
        }
        solve_dados3(uno, dos, tres, p, b);
    }
    
    private void solve_dados3(int a, int b, int c, Personaje p, boolean bb)
    {
        if (a == 3)
            p.ganar_exp(1);
        else if (a == 4)
            p.ganar_exp(2);
        else if (a == 5)
            p.ganar_exp(3);
        else if (a == 6)
            p.ganar_exp(4);
        
        if (b == 3)
            p.ganar_exp(2);
        else if (b == 4)
            p.ganar_exp(3);
        else if (b == 5)
            p.ganar_exp(4);
        else if (b == 6)
            p.ganar_exp(5);
        
        if (c == 3)
            p.ganar_exp(3);
        else if (c == 4)
            p.ganar_exp(4);
        else if (c == 5)
            p.ganar_exp(5);
        else if (c == 6)
            p.ganar_exp(6);
        solve_dados4(p, bb);
    }
    
    private void solve_dados4(Personaje p, boolean b)
    {
        if (p.isIn_tokio() && turno != 0)
            p.ganar_exp(1);
        if (b)
        {
            Iterator<Personaje> it = personajes.iterator();
            while (it.hasNext())
            {
                Personaje pj = it.next();
                if (pj.isIn_tokio())
                    pj.setIn_tokio(false);
            }
            p.setIn_tokio(true);
        }
        
        Iterator<Personaje> it2 = personajes.iterator();
        while (it2.hasNext())
        {
            Personaje pj = it2.next();
            if (pj.getVida() <= 0)
            {
                pj.setVivo(false);
                personajes.remove(pj);
                players--;
            }
        }
        if (personajes.size() == 1)
        {
            
        }
            
        set_menus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        vida = new javax.swing.JLabel();
        exp = new javax.swing.JLabel();
        rayos = new javax.swing.JLabel();
        cartas = new javax.swing.JButton();
        tablero = new javax.swing.JLabel();
        listo = new javax.swing.JButton();
        tienda = new javax.swing.JButton();
        dados = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jugador2_panel = new javax.swing.JPanel();
        nombre2 = new javax.swing.JLabel();
        vida2 = new javax.swing.JLabel();
        exp2 = new javax.swing.JLabel();
        rayos2 = new javax.swing.JLabel();
        cartas2 = new javax.swing.JButton();
        jugador4_panel = new javax.swing.JPanel();
        nombre4 = new javax.swing.JLabel();
        vida4 = new javax.swing.JLabel();
        exp4 = new javax.swing.JLabel();
        rayos4 = new javax.swing.JLabel();
        cartas4 = new javax.swing.JButton();
        jugador3_panel = new javax.swing.JPanel();
        nombre3 = new javax.swing.JLabel();
        vida3 = new javax.swing.JLabel();
        exp3 = new javax.swing.JLabel();
        rayos3 = new javax.swing.JLabel();
        cartas3 = new javax.swing.JButton();
        en_tokio = new javax.swing.JLabel();
        turno_de = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("King of Tokio");

        nombre.setText("Nombre: ");

        vida.setText("Vida:");

        exp.setText("Exp:");

        rayos.setText("Rayos:");

        cartas.setText("Cartas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vida, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(exp, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rayos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 380, Short.MAX_VALUE)
                .addComponent(cartas, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rayos, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(vida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(cartas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tablero.jpg"))); // NOI18N

        listo.setText("Listo");
        listo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listoActionPerformed(evt);
            }
        });

        tienda.setText("Tienda");

        dados.setText("Tirar dados");
        dados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadosActionPerformed(evt);
            }
        });

        nombre2.setText("Nombre:");

        vida2.setText("Vida:");

        exp2.setText("Exp:");

        rayos2.setText("Rayos:");

        cartas2.setText("Cartas");

        javax.swing.GroupLayout jugador2_panelLayout = new javax.swing.GroupLayout(jugador2_panel);
        jugador2_panel.setLayout(jugador2_panelLayout);
        jugador2_panelLayout.setHorizontalGroup(
            jugador2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugador2_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jugador2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jugador2_panelLayout.createSequentialGroup()
                        .addComponent(vida2)
                        .addGap(53, 53, 53)
                        .addComponent(exp2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(rayos2)
                        .addGap(43, 43, 43))
                    .addGroup(jugador2_panelLayout.createSequentialGroup()
                        .addComponent(nombre2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cartas2)
                        .addGap(27, 27, 27))))
        );
        jugador2_panelLayout.setVerticalGroup(
            jugador2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugador2_panelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jugador2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre2)
                    .addComponent(cartas2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jugador2_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vida2)
                    .addComponent(exp2)
                    .addComponent(rayos2))
                .addGap(15, 15, 15))
        );

        nombre4.setText("Nombre:");

        vida4.setText("Vida:");

        exp4.setText("Exp:");

        rayos4.setText("Rayos:");

        cartas4.setText("Cartas");
        cartas4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cartas4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jugador4_panelLayout = new javax.swing.GroupLayout(jugador4_panel);
        jugador4_panel.setLayout(jugador4_panelLayout);
        jugador4_panelLayout.setHorizontalGroup(
            jugador4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugador4_panelLayout.createSequentialGroup()
                .addGroup(jugador4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jugador4_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(nombre4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cartas4))
                    .addGroup(jugador4_panelLayout.createSequentialGroup()
                        .addComponent(vida4)
                        .addGap(42, 42, 42)
                        .addComponent(exp4)
                        .addGap(53, 53, 53)
                        .addComponent(rayos4)))
                .addGap(0, 67, Short.MAX_VALUE))
        );
        jugador4_panelLayout.setVerticalGroup(
            jugador4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugador4_panelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jugador4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre4)
                    .addComponent(cartas4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jugador4_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vida4)
                    .addComponent(exp4)
                    .addComponent(rayos4))
                .addGap(18, 18, 18))
        );

        nombre3.setText("Nombre:");

        vida3.setText("Vida:");

        exp3.setText("Exp:");

        rayos3.setText("Rayos:");

        cartas3.setText("Cartas");

        javax.swing.GroupLayout jugador3_panelLayout = new javax.swing.GroupLayout(jugador3_panel);
        jugador3_panel.setLayout(jugador3_panelLayout);
        jugador3_panelLayout.setHorizontalGroup(
            jugador3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugador3_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jugador3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jugador3_panelLayout.createSequentialGroup()
                        .addComponent(nombre3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cartas3))
                    .addGroup(jugador3_panelLayout.createSequentialGroup()
                        .addComponent(vida3)
                        .addGap(56, 56, 56)
                        .addComponent(exp3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(rayos3)))
                .addGap(35, 35, 35))
        );
        jugador3_panelLayout.setVerticalGroup(
            jugador3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jugador3_panelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jugador3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre3)
                    .addComponent(cartas3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jugador3_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vida3)
                    .addComponent(exp3)
                    .addComponent(rayos3))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jugador2_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jugador3_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jugador4_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jugador3_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jugador4_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jugador2_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        en_tokio.setText("jLabel1");

        turno_de.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dados, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(listo, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(en_tokio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(turno_de, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(en_tokio, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(turno_de, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(tablero, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(listo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(142, 142, 142))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dados, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(tienda, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)))))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listoActionPerformed
        // TODO add your handling code here:
        if (estan_dados)
        {
            estan_dados = false;
            turno++;
            solve_dados();
        }
    }//GEN-LAST:event_listoActionPerformed

    private void cartas4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cartas4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cartas4ActionPerformed

    private void dadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadosActionPerformed
        // TODO add your handling code here:
        if (!estan_dados)
        {
            dado = new Dados();
            estan_dados = true;
        }  
    }//GEN-LAST:event_dadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cartas;
    private javax.swing.JButton cartas2;
    private javax.swing.JButton cartas3;
    private javax.swing.JButton cartas4;
    private javax.swing.JButton dados;
    private javax.swing.JLabel en_tokio;
    private javax.swing.JLabel exp;
    private javax.swing.JLabel exp2;
    private javax.swing.JLabel exp3;
    private javax.swing.JLabel exp4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jugador2_panel;
    private javax.swing.JPanel jugador3_panel;
    private javax.swing.JPanel jugador4_panel;
    private javax.swing.JButton listo;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre2;
    private javax.swing.JLabel nombre3;
    private javax.swing.JLabel nombre4;
    private javax.swing.JLabel rayos;
    private javax.swing.JLabel rayos2;
    private javax.swing.JLabel rayos3;
    private javax.swing.JLabel rayos4;
    private javax.swing.JLabel tablero;
    private javax.swing.JButton tienda;
    private javax.swing.JLabel turno_de;
    private javax.swing.JLabel vida;
    private javax.swing.JLabel vida2;
    private javax.swing.JLabel vida3;
    private javax.swing.JLabel vida4;
    // End of variables declaration//GEN-END:variables
}
