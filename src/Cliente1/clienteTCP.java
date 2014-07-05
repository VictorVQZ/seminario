package Cliente1;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clienteTCP extends Thread{
    
    String text, long_text;
    Socket Servicio;   
    ObjectInputStream input;
    ObjectOutputStream output;
    Thread hilo1 = new Thread(); 
    public clienteTCP() throws IOException {
       
    
    }
    void conectar() {
        try {
            Servicio = new Socket("localhost", 5001);
            start();
        } catch (UnknownHostException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void run(){
        while (true) {            
            System.out.println("Entro");
        }
    
    }
    
    public void recibir(){
        try {
            input = new  ObjectInputStream(Servicio.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(clienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviar(){
        try {
            output = new ObjectOutputStream(Servicio.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(clienteTCP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
