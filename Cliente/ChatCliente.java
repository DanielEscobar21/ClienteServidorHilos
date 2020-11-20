package Cliente;

import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class ChatCliente extends JFrame {

    public static String name;
    private static Socket cliente;
    private static String ip = "127.0.0.1";
    public JButton Enviar;
    public JSeparator Linea;
    public JTextField MensajeArea;
    public JTextArea Msj1;
    public JLabel NombreUser;
    public JPanel Panel;
    public JLabel UserImage;
    public JScrollPane ScrollConect;
    public JScrollPane ScrollMsj1;
    public JScrollPane ScrollMsj2;
    public JSeparator jSeparator1;
    public JTextArea Conexion;
    public JTextArea jTextArea2;

    public ChatCliente() {
        super("Cliente - " + name);
        jSeparator1 = new JSeparator();
        jTextArea2 = new JTextArea();
        Panel = new JPanel();
        MensajeArea = new JTextField();
        Enviar = new JButton();
        Linea = new JSeparator();
        UserImage = new JLabel();
        NombreUser = new JLabel(name);
        ScrollMsj1 = new JScrollPane();
        Msj1 = new JTextArea();
        ScrollMsj2 = new JScrollPane();
        ScrollConect = new JScrollPane();
        Conexion = new JTextArea();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        Panel.setBackground(new Color(255, 255, 255));
        Panel.setLayout(new AbsoluteLayout());

        MensajeArea.setBackground(new Color(255, 255, 255));
        MensajeArea.setForeground(new Color(0, 0, 0));
        MensajeArea.setBorder(null);
        Panel.add(MensajeArea, new AbsoluteConstraints(10, 500, 230, 20));
        Panel.add(Linea, new AbsoluteConstraints(10, 520, 240, 10));

        Enviar.setBackground(new Color(255, 255, 255));
        Enviar.setForeground(new Color(255, 255, 255));
        Enviar.setIcon(new ImageIcon("src/image/Enviar_OFF.png"));
        Enviar.setBorder(null);
        Enviar.setCursor(new Cursor(HAND_CURSOR));
        Enviar.setPressedIcon(new ImageIcon("src/image/Enviar_ON.png"));
        Enviar.setRolloverIcon(new ImageIcon("src/image/Enviar_ON.png"));
        Enviar.setRolloverSelectedIcon(new ImageIcon("src/image/Enviar_ON.png"));
        Enviar.setSelectedIcon(new ImageIcon("src/image/Enviar_ON.png"));
        Panel.add(Enviar, new AbsoluteConstraints(270, 490, 40, 40));

        UserImage.setIcon(new ImageIcon("src/image/User.png"));
        Panel.add(UserImage, new AbsoluteConstraints(10, 10, -1, -1));

        NombreUser.setFont(new Font("Franklin Gothic Demi", 1, 24));
        NombreUser.setForeground(new Color(2, 99, 175));
        Panel.add(NombreUser, new AbsoluteConstraints(70, 20, 220, -1));

        Msj1.setBackground(new Color(255, 255, 255));
        Msj1.setFont(new Font("Franklin Gothic Book", 0, 18)); // NOI18N
        Msj1.setForeground(new Color(0, 0, 0));
        Msj1.setLineWrap(true);
        Msj1.setAutoscrolls(false);
        ScrollMsj1.setViewportView(Msj1);
        Msj1.setEditable(false);
        Panel.add(ScrollMsj1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 310, 380));

        Conexion.setEditable(false);
        Conexion.setBackground(new Color(255, 255, 255));
        Conexion.setForeground(new Color(102, 102, 102));
        Conexion.setLineWrap(true);
        Conexion.setRows(2);
        ScrollConect.setViewportView(Conexion);
        Panel.add(ScrollConect, new AbsoluteConstraints(160, 50, 160, 50));

        getContentPane().add(Panel, new AbsoluteConstraints(0, 0, 330, 540));
        pack();

    }

    public void mostrarMensaje(String mensaje) {
        Msj1.append(mensaje + "\n");
    }

    public void EstadoConexion(String mensaje) {
        Conexion.append(mensaje + "\n");

    }

    public void habilitarTexto(boolean editable) {
        MensajeArea.setEditable(editable);
    }

    public static void main(String[] args) {
        name = JOptionPane.showInputDialog("Ingrese su Nombre de Usuario:");
        ChatCliente main = new ChatCliente();
        ExecutorService executor = Executors.newCachedThreadPool();
        main.setVisible(true);

        try {
            main.EstadoConexion("Buscando conexion con Servidor...");
            cliente = new Socket(InetAddress.getByName(ip), 11111);
            main.EstadoConexion("CONECTADO");
            main.habilitarTexto(true);
            executor.execute(new HiloReceptor(cliente, main));
            executor.execute(new HiloEnviador(cliente, main));

        } catch (IOException ex) {

            main.mostrarMensaje("Inicie el Servidor Primero");

        } finally {
            executor.shutdown();
        }
    }
}

