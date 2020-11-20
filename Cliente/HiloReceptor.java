package Cliente;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HiloReceptor implements Runnable {

    private final ChatCliente main;
    private String mensaje;
    private ObjectInputStream entrada;
    private Socket cliente;

    public HiloReceptor(Socket cliente, ChatCliente main) {
        this.cliente = cliente;
        this.main = main;
    }

    public void mostrarMensaje(String mensaje) {
        main.Msj1.append(mensaje);
    }

    public void run() {
        try {
            entrada = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(HiloReceptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        do {
            try {
                mensaje = (String) entrada.readObject();
                main.mostrarMensaje(mensaje);
            }
            catch (SocketException ex) {
            } catch (EOFException eofException) {
                main.mostrarMensaje("Fin de la conexion");
                break;
            }
            catch (IOException ex) {
                Logger.getLogger(HiloReceptor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException classNotFoundException) {
                main.mostrarMensaje("Objeto desconocido");
            }             

        } while (!mensaje.equals("***CLIENTE DESCONECTADO***"));

        try {
            entrada.close();
            cliente.close();
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        } 
        main.mostrarMensaje("Fin de la conexión");
        System.exit(0);
    }
}

