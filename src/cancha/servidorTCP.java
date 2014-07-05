package cancha;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class servidorTCP extends Thread {

    ArrayList<Socket> clientes;
    ObjectInputStream input;
    ObjectOutputStream output;
    Socket Servicio;
    ServerSocket Puerto;
    int cont;

    public servidorTCP() throws IOException {
        this.Puerto = new ServerSocket(5001);
        this.clientes = new ArrayList<Socket>();
        this.cont = 0;
    }

    public void Conexion() {
        try {
            Servicio = Puerto.accept();
            clientes.add(Servicio);
            cont++;
        } catch (IOException ex) {
            Logger.getLogger(servidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void IniHilo() {
        start();
    }

    @Override
    public void run() {
        while (cont <= 2) {
            Conexion();
            System.out.println("Servidor " + cont + " Listo");
        }

    }

    public void recibir() {
        try {
            input = new ObjectInputStream(Servicio.getInputStream());

        } catch (IOException ex) {
            Logger.getLogger(servidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviar() {
        try {
            output = new ObjectOutputStream(Servicio.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(servidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
