/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Cliente;

import java.io.IOException;


/**
 *
 * @author KatherinC
 */
public class cliente {
    clienteTCP conn;

    public cliente() throws IOException {
        this.conn = new clienteTCP();
    }
    public static void main(String[] args) throws IOException {
        cliente obj = new cliente();
        obj.conn.conectar();
        
    }
    
}
