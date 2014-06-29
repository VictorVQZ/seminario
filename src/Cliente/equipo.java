/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.util.ArrayList;

/**
 *
 * @author KatherinC
 */
public class equipo {

    int turno; //0 juego sin empezar, 1 juego iniciado turno jugador 1, 2 juego iniciado turno jugador 2, 3 Juego terminado
    String equipo; //Equipo que pertenece el mensaje 
    int puntuacion;
    ArrayList<jugador> jugador;

    public equipo() {
        this.turno = 0;
        this.equipo = "";
        this.puntuacion = 0;
        this.jugador = new ArrayList<jugador>();
    }

    public equipo(int turno, String equipo, int puntuacion, ArrayList<jugador> jugador) {
        this.turno = turno;
        this.equipo = equipo;
        this.puntuacion = puntuacion;
        this.jugador = jugador;
    }

}
