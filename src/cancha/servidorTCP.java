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

    public servidorTCP() throws IOException {
        this.Puerto = new ServerSocket(5001);
        this.clientes = new ArrayList<Socket>();
        this.input = new  ObjectInputStream(Servicio.getInputStream());
        this.output = new ObjectOutputStream(Servicio.getOutputStream());
    }

    public void Conexion() {
        try {
            Servicio = Puerto.accept();
            clientes.add(Servicio);
        } catch (IOException ex) {
            Logger.getLogger(servidorTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void IniHilo() {
        start();
    }
    
    @Override
    public void run() {
        while (true) {
            Conexion();
            System.out.println("Servidor Listo...");
            if(clientes.size()==2){
                stop();
            }
        }
    }
    Thread hilo1 = new Thread();  
    
    public void data_recibido(){
        hilo1.start();
 
    }
}
