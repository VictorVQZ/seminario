/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cancha;
import java.io.IOException;


/**
 *
 * @author KatherinC
 */
public class cliente {


    public static void main(String[] args) throws IOException {
      ConexionCliente Conn = new ConexionCliente(20080);
      Conn.start();
      
    }
    
}
