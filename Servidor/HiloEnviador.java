package Servidor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HiloEnviador implements Runnable {

    private final ChatServidor main;
    private ObjectOutputStream salida;
    private String mensaje;
    private Socket conexion;

    public HiloEnviador(Socket conexion, final ChatServidor main) {
        this.conexion = conexion;
        this.main = main;

        main.MensajeArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                mensaje = event.getActionCommand();
                enviarDatos(mensaje); 
                main.MensajeArea.setText("");
            }
        }
        );
        
        main.Enviar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                mensaje = main.MensajeArea.getText();
                enviarDatos(mensaje);
                main.MensajeArea.setText("");
                
            }
        });

    }

    private void enviarDatos(String mensaje) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Date date = new Date();
            
            salida.writeObject(main.name + ":\t\t" + dateFormat.format(date) + "\n " + mensaje + "\n");
            salida.flush(); //flush salida a cliente
            main.mostrarMensaje(main.name + ":\t\t" + dateFormat.format(date) + "\n " + mensaje + "\n");
        } //Fin try
        catch (IOException ioException) {
            main.mostrarMensaje("***CLIENTE DESCONECTADO***");
        } //Fin catch  

    }

    
    public void mostrarMensaje(String mensaje) {
        main.Msj1.append(mensaje);
    }

    public void run() {
        try {
            salida = new ObjectOutputStream(conexion.getOutputStream());
            salida.flush();
        } catch (SocketException ex) {
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (NullPointerException ex) {
        }
    }

}
