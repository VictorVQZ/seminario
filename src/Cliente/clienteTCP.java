package Cliente;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class clienteTCP {
    
    String text, long_text;
    Socket Servicio;   
    ObjectInputStream input;
    ObjectOutputStream output;
    Thread hilo1 = new Thread(); 
    public clienteTCP() throws IOException {
        this.input = new  ObjectInputStream(Servicio.getInputStream());
        this.output = new ObjectOutputStream(Servicio.getOutputStream());
    }
    void conectar() {
        try {
            Servicio = new Socket("localhost", 5001);
            hilo1.start();
        } catch (UnknownHostException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void run(){
    
    }
    
}
