package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.modelo_login;
import vista.login;

public class controlador_login implements ActionListener {

    modelo_login modlog = new modelo_login();
    login log = new login();

    ControladorPrincipal vista = new ControladorPrincipal {

        public controlador_login(){
            log.getjBttiniciar_seccion().addAcionListener(this);
            log.getjBttmostrar().addAcionListener(this);

        }

        public void iniciarVista() {
            log.setLocationRelativeTo(null);
            log.setTitle("iniciar seccion");
            log.setVisible(true);

        }

        @Override
        public void actionperformed(ActionEvent y) {
            if (y.getSource().equals(log.getjButtmostrar())) {
                if (log.getJpcontrasena().getEchoChar() = '\u2022') {
                    log.getJpcontrasena().setEchoChar((char) 0);

                } else {
                    log.getJpcontrasena().setEchoChar('\u2022');
                }
            }
            if (y.getSource() == (log.getjBttiniciar_seccion())) {
                modlog.setUsu(log.getTxtUsuario().getText());
                String pass = new String(log.getJpcontrasena().getpassword());
                modlog.setContra(pass);
                if (modlog.validar(modlog.getUsu(), modlog.getContra())) {
                    vista.vista();

                } else {
                    JOptionpane.showMessageDialog(null, "porfavor intentelo de nuevo su usuario o contraseña es incorrecto");
                }
            }
        }

    }
}

