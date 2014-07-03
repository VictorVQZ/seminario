package cancha;

import java.util.Random;
import javax.swing.ImageIcon;

public class jugador {

    private int posX;
    private int posY;
    private double posZ;
    private int Potencia, Velocidad, Salto, Precision, Resistencia;
    private String funcion;
    private int saque;
    private int equipo;

    public jugador() {
        Random r = new Random();
        this.Potencia = r.nextInt(100);
        this.Velocidad = r.nextInt(100);
        this.Salto = r.nextInt(100);
        this.Precision = r.nextInt(100);
        this.Resistencia = r.nextInt(100);
        this.posX = 0;
        this.posY = 0;
        this.posZ = 0;
        this.equipo = 0;
    }

    public jugador(int posX, int posY, double posZ, int Potencia, int Velocidad, int Salto, int Precision, int Resistencia, String funcion, int saque, int equipo) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.Potencia = Potencia;
        this.Velocidad = Velocidad;
        this.Salto = Salto;
        this.Precision = Precision;
        this.Resistencia = Resistencia;
        this.funcion = funcion;
        this.saque = saque;
        this.equipo = equipo;
    }

    /**
     *
     * @return los atributos en forma de array.
     */
    public int[] obtenerAtributos() {
        int[] atributos = {
            Potencia,
            Precision,
            Resistencia,
            Salto,
            Velocidad
        };
        return atributos;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosZ(double posZ) {
        this.posZ = posZ;
    }

    public void setPotencia(int Potencia) {
        this.Potencia = Potencia;
    }

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }

    public void setSalto(int Salto) {
        this.Salto = Salto;
    }

    public void setPrecision(int Precision) {
        this.Precision = Precision;
    }

    public void setResistencia(int Resistencia) {
        this.Resistencia = Resistencia;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getPosZ() {
        return posZ;
    }

    public int getPotencia() {
        return Potencia;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public int getSalto() {
        return Salto;
    }

    public int getPrecision() {
        return Precision;
    }

    public int getResistencia() {
        return Resistencia;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public int getSaque() {
        return saque;
    }

    public void setSaque(int saque) {
        this.saque = saque;
    }

    public void HacerSaque(Main m) {
        int x = 0;
        int y = 0;
        if (this.equipo == 1) {
            x = 2;
            y = 17;
        } else {
            x = 30;
            y = 5;
        }
        m.log[this.posX][this.posY] = 0;
        m.log[x][y] = this.equipo;

        ImageIcon piso = new ImageIcon("piso.gif");
        m.lbl[this.posX][this.posY].setIcon(piso);
        ImageIcon icon;
        if (this.equipo == 1) {
            icon = new ImageIcon("jugador1.png");
        } else {
            icon = new ImageIcon("jugador2.png");
        }
        m.lbl[x][y].setIcon(icon);
    }
}
