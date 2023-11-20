package Controlador;

import Modelo.ModeloUsuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import modeloLogin.modelo_usuario;
import vista.NuevoUsuario;
import vista.Principal;

public class ControladorPrincipal implements ActionListener {
    Principal prin = new Principal();//Instancia(Llama) la ventana Principal
    NuevoUsuario nuevo = new NuevoUsuario();//Instanca (Llama) la ventana(vista) Nuevo usuario
    ModeloUsuario usu = new ModeloUsuario();//Instancia el modelo de usuario
    ControladorUsuario ControUsu = new ControladorUsuario();

    public ControladorPrincipal() {
        prin.getBtnNuevaFactura().addActionListener(this);//Agrega el boton nuevo para que se escuche cuando se de clic
        nuevo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Desactiva la x que cierrar el programa para que permita abrir o volver a la ventana Principal
    }

    public void iniciar() {
        prin.setLocationRelativeTo(null);//Centra la ventana
        prin.setTitle("Principal");//Le da titulo a la ventana
        prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        prin.setVisible(true);//Hace visible la ventana
        gestionPestanas();

    }

    public void gestionPestanas() {
        if (prin.getPrincipal().getSelectedIndex()== 0) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(prin.getBtnNuevaFactura())) {

            prin.setVisible(false);
            ControUsu.controlUsuario();
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int seleccion = prin.getPreferredSize().getSelectedIndex();
        if (seleccion == 0) {
            gestionPestanas();
        }
        if (seleccion == 1) {
            ModeloUsuario ModUsu = new ModeloUsuario();
            ModeloUsuario.mostrarTablaUsuario(prin.getJ, "");

            prin.getTxtBuscar().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    prin.getBtnNuevaFactura().setText("");
                    prin.getBtnNuevaFactura().setForeground(color.BLACK);
                    
                }
                
                
            });
            prin.getTxtBuscar().getDocument().addDocumentListener(new DocumentListener(){
                @Override
                public void inser
            }
        }
    }

}
