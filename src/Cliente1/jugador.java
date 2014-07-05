package Cliente1;

import java.util.ArrayList;

public class jugador {
    private double posX;
    private double posY;
    private double posZ;
    private int Potencia, Velocidad, Salto, Precision, Resistencia;

       public jugador() {
        this.Potencia = 0;
        this.Velocidad = 0;
        this.Salto = 0;
        this.Precision = 0;
        this.Resistencia = 0;
        this.posX = 0;
        this.posY = 0;
        this.posZ = 0;
    }

    public jugador(double posX, double posY, double posZ, int Potencia, int Velocidad, int Salto, int Precision, int Resistencia) {
        this.posX = posX;
        this.posY = posY;
        this.posZ = posZ;
        this.Potencia = Potencia;
        this.Velocidad = Velocidad;
        this.Salto = Salto;
        this.Precision = Precision;
        this.Resistencia = Resistencia;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public void setPosY(double posY) {
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
    


    

}
