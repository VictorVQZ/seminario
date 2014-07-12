package cancha;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author oscarzz
 */
public class Main {

    static int fil = 31, col = 20, i, j;
    static ImageIcon piso = new ImageIcon("piso.gif");
    static ImageIcon malla = new ImageIcon("malla.gif");
    static ImageIcon jugador1 = new ImageIcon("jugador1.png");
    static ImageIcon jugador2 = new ImageIcon("jugador2.png");
    static ImageIcon pelota = new ImageIcon("ball.png");
    public static JLabel[][] lbl = new JLabel[fil][col];
    public static int[][] log = new int[fil][col];
    static JLabel score1 = new JLabel("Equipo 1:  0");
    static JLabel score2 = new JLabel("Equipo 2:  0");
    jugador[] Equipo1 = new jugador[6];
    jugador[] Equipo2 = new jugador[6];
    final JFrame f = new JFrame(" ********   Voleyball   *********  ");

    public void Pintar_Cancha() {
        f.getContentPane().setLayout(null);                                  /////frame juego
        f.getContentPane().setBackground(Color.gray);
        f.setBounds(150, 50, 1000, 700);

        JButton Iniciar = new JButton("Iniciar");
        Iniciar.setBounds(450, 30, 100, 50);
        Iniciar.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                IniciarJuego();
            }
        });
        f.add(Iniciar);
        /*inicializacion de matriz logica y label*/
        for (i = 3; i < fil; i++) {
            for (j = 3; j < col; j++) {
                log[i][j] = 0;                         ////////inicializo matriz log en 0;
                if (i == 16) {
                    log[i][j] = 8;               ///// numero 8 es la malla
                }
            }
        }
        /////////////jugadores equipo 1
        log[5][5] = 1;
        Equipo1[0] = new jugador(5, 5, 0, 0, 0, 0, 0, 0, "Defensa", 0, 1);
        log[5][11] = 1;
        Equipo1[1] = new jugador(5, 11, 0, 0, 0, 0, 0, 0, "Armador", 0, 1);
        log[5][17] = 1;
        Equipo1[2] = new jugador(5, 17, 0, 0, 0, 0, 0, 0, "Defensa", 1, 1);
        /////posiciones estaticas iniciales equipo 1
        log[12][5] = 1;
        Equipo1[3] = new jugador(12, 5, 0, 0, 0, 0, 0, 0, "Atacante", 0, 1);
        log[12][11] = 1;
        Equipo1[4] = new jugador(12, 11, 0, 0, 0, 0, 0, 0, "Armador", 0, 1);
        log[12][17] = 1;
        Equipo1[5] = new jugador(12, 17, 0, 0, 0, 0, 0, 0, "Atacante", 0, 1);

        ////////////jugadores equipo 2        
        log[20][5] = 2;
        Equipo2[0] = new jugador(20, 5, 0, 0, 0, 0, 0, 0, "Atacante", 0, 2);
        log[20][11] = 2;
        Equipo2[1] = new jugador(20, 11, 0, 0, 0, 0, 0, 0, "Armador", 0, 2);
        log[20][17] = 2;
        Equipo2[2] = new jugador(20, 11, 0, 0, 0, 0, 0, 0, "Atacante", 0, 2);
        ////// posiciones estaticas iniciales equipo 2
        log[27][5] = 2;
        Equipo2[3] = new jugador(27, 5, 0, 0, 0, 0, 0, 0, "Defensa", 1, 2);
        log[27][11] = 2;
        Equipo2[4] = new jugador(27, 11, 0, 0, 0, 0, 0, 0, "Armador", 0, 2);
        log[27][17] = 2;
        Equipo2[5] = new jugador(27, 17, 0, 0, 0, 0, 0, 0, "Defensa", 0, 2);        

        for (i = 2; i < 3; i++) {
            for (j = 3; j < col; j++) {
                lbl[i][j] = new JLabel();
                lbl[i][j].setBounds(i * 30, j * 30, 32, 31);
                f.add(lbl[i][j]);
            }            
        }
        for (i = 30; i < 31; i++) {
            for (j = 3; j < col; j++) {
                lbl[i][j] = new JLabel();
                lbl[i][j].setBounds(i * 30, j * 30, 32, 31);
                f.add(lbl[i][j]);
            }            
        }
        for (i = 3; i < fil-1; i++) {
            for (j = 3; j < col; j++) {
                lbl[i][j] = new JLabel(piso);
                lbl[i][j].setBounds(i * 30, j * 30, 32, 31);     /////inicializar matriz label
                if (log[i][j] == 8) {
                    lbl[i][j].setIcon(malla);
                }
                if (log[i][j] == 1) {
                    lbl[i][j].setIcon(jugador1);
                }
                if (log[i][j] == 2) {
                    lbl[i][j].setIcon(jugador2);
                }
                f.add(lbl[i][j]);
            }
        }
        Image img = pelota.getImage();
        Image newimg = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(newimg);
        JLabel balon = new JLabel(icon);
        balon.setBounds(10, 10, 30, 30);
        f.add(balon);

        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void IniciarJuego() {
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = 1 + (int)(Math.random() * ((2 - 1) + 1));
        System.out.println(randomNum);
        jugador j = Servicio(randomNum);
        j.HacerSaque(this);
    }

    public jugador Servicio(int equipo) {
        jugador[] jugadores;
        jugador j = new jugador();
        if (equipo == 1) {
            jugadores = Equipo1;
        } else {
            jugadores = Equipo2;
        }
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i].getSaque() == 1) {
                j = jugadores[i];
                break;
            }
        }
        return j;
    }
    public static void main(String[] args) {

        Main obj = new Main();
        obj.Pintar_Cancha();
        ConexionServidor Conn = new ConexionServidor(20080);
        Conn.start();
        
    }

}
