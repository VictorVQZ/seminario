package cancha;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KatherinC
 */
public class ConexionCliente extends Thread {

    Socket sock;
    InputStream Entrada;
    OutputStream Salida;
    ObjectInputStream Entrada_serializada;
    ObjectOutputStream Salida_serializada;
    pelota Pelota;

    public ConexionCliente(int Puerto) {
        try {
            sock = new Socket("localhost", Puerto);
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public pelota Entrada_objeto() {
        pelota pelota_actual = null;
        try {
            Entrada = sock.getInputStream();
            Entrada_serializada = new ObjectInputStream(Entrada);
            pelota_actual = (pelota) Entrada_serializada.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pelota_actual;
    }

    public void Salida_Obj_Equipo(cancha.equipo objE) {
        try {
            Salida = sock.getOutputStream();
            Salida_serializada = new ObjectOutputStream(Salida);
            Salida_serializada.writeObject(objE);
        } catch (IOException ex) {
            Logger.getLogger(ConexionCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (true) {
            cancha.equipo equipo = new cancha.equipo();
            Salida_Obj_Equipo(equipo);
            Pelota = Entrada_objeto();
        }

    }
}
