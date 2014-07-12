

package cancha;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KatherinC
 */
public class ConexionServidor extends Thread {
    
    Socket socket;
    ArrayList<Socket> sockEquipos;
    ArrayList<equipo> ListaEquipo;
    ServerSocket Puerto;
    InputStream Entrada;
    OutputStream Salida;
    ObjectInputStream Entrada_serializada;
    ObjectOutputStream Salida_serializada;
    pelota Pelota;
    int cont;
    
    public ConexionServidor(int puerto) {
        try {
            ListaEquipo = new ArrayList<equipo>();
            sockEquipos = new ArrayList<Socket>();
            Puerto = new ServerSocket(20080);
            Pelota = new pelota();
            cont = 0;
        } catch (IOException ex) {
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void conexion(){
        try {
            
            socket = Puerto.accept();
            sockEquipos.add(socket);
            System.out.println("Conexión establecida");
        } catch (IOException ex) {
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void run(){
        while(cont<2){
            conexion();
            ListaEquipo.add(Entrada_objeto(cont));
            cont++;
        }
        while (true) {
            for (int i = 0; i < 2; i++) {
                Salida_obj_pelota(i, Pelota);
            }
            
        }
    }
    public equipo Entrada_objeto(int posEquipo){
        cancha.equipo equipo_entrante = null;
        try {
            Entrada=sockEquipos.get(posEquipo).getInputStream();
            Entrada_serializada = new ObjectInputStream(Entrada);
            equipo_entrante = (cancha.equipo) Entrada_serializada.readObject();
            System.out.println("Nombre equipo" + equipo_entrante.equipo);
        } catch (IOException ex) {
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipo_entrante;
    }
       
         
    
    public void Salida_obj_pelota(int posEquipo, pelota Pelota){
        try {
            Salida = sockEquipos.get(posEquipo).getOutputStream();
            Salida_serializada = new ObjectOutputStream(Salida);
            Pelota = new pelota();
            Salida_serializada.writeObject(Pelota);
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void Salida_obj_eequipoContrario(int posEquipo, pelota Pelota){
        try {
            Salida = sockEquipos.get(posEquipo).getOutputStream();
            Salida_serializada = new ObjectOutputStream(Salida);
            Pelota = new pelota();
            Salida_serializada.writeObject(Pelota);
            
        } catch (IOException ex) {
            Logger.getLogger(ConexionServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
