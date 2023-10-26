package Controlador;

import Modelo.Modelo_Usuario;
import Vista.Nuevo_Usuario;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import modeloLogin.modelo_usuario;

public class ControladorPrincipal implements ActionListener {

    Principal prin = new Principal();//Instancia(Llama) la ventana principal
    Nuevo_Usuario nuevo = new Nuevo_Usuario();//Instanca (Llama) la ventana(vista) Nuevo usuario
    ModeloUsuario usu = new ModeloUsuario();//Instancia el modelo de usuario

    public ControladorPrincipal() {
        prin.getBtnNuevo().addActionListener(this);//Agrega el boton nuevo para que se escuche cuando se de clic
        nuevo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Desactiva la x que cierrar el programa para que permita abrir o volver a la ventana principal
    }

    public void iniciar() {
        prin.setLocationRelativeTo(null);//Centra la ventana
        prin.setTitle("Principal");//Le da titulo a la ventana
        prin.setExtendedState(JFrame.MAXIMIZED_BOTH);
        prin.setVisible(true);//Hace visible la ventana
        gestionPestanas();

    }

    public void gestionPestanas() {
        if (prin.getJtPrincipal().getSelectedindex() == 0) {

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(prin.getBtnNuevo())) {

            prin.setVisible(false);
            contUsua.control();
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        int seleccion = prin.getJtprincipal().getSelectedIndex();
        if (seleccion == 0) {
            gestionPestanas();
        }
        if (seleccion == 1) {
            modelo_usuario modUsu = new modelo_usuario();
            modelo_usuario.mostrarTablaUsuario(prin.getTusuario(), "");

            prin.getTxtBuscar().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e){
                    prin.getTxtBuscar().setText("");
                    prin.getTxtBuscar().setForeground(color.BLACK);
                    
                }
                
                
            });
            prin.getTxtBuscar().getDocument().addDocumentListener(new DocumentListener(){
                @Override
                public void inser
            }
        }
    }

}
