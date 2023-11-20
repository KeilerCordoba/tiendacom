package Controlador;

import Modelo.ModeloUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import vista.NuevoUsuario;
import vista.Principal;

public class ControladorUsuario implements ActionListener {

    NuevoUsuario usu = new NuevoUsuario();
    Principal prin = new Principal();
    ModeloUsuario modusuario = new ModeloUsuario();

    //constructor
    public ControladorUsuario() {
        usu.getBtnGuardar().addActionListener(this);
        usu.getBtnCancelar().addActionListener(this);
        usu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        usu.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princ = new ControladorPrincipal();
                princ.iniciarPrincipal(0);
            }
        });
    }

    public void controlUsuario() {
        prin.setVisible(false);
        usu.setLocationRelativeTo(null);
        usu.setTitle("Nuevo Usuario");
        usu.setVisible(true);

        //lleno combo box sexo
        usu.getComboBoxSexo().addItem("Seleccione...");
        Map<String, Integer> combosexo = modusuario.llenarCombo("sexo");
        for (String sexo : combosexo.keySet()) {
            usu.getComboBoxSexo().addItem(sexo);
        }
        //lleno combo box rol
        usu.getComboBoxCargo().addItem("Seleccione...");
        Map<String, Integer> comborol = modusuario.llenarCombo("rol");
        for (String rol : comborol.keySet()) {
            usu.getComboBoxCargo().addItem(rol);
        }
    }

    //Metodo adstracto
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(usu.getBtnGuardar())) {

            if (usu.getJPClave().getEchoChar() == '\u2022') {
                usu.getJPClave().setEchoChar((char) 0);
                usu.getBtnGuardar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo-cruzado.png")));
            } else {
                usu.getJPClave().setEchoChar('\u2022');
                usu.getBtnGuardar().setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ojo.png")));
            }
        }
        if (e.getSource().equals(usu.getBtnGuardar())) {
            //validar campos vacios
            if ( (usu.getComboBoxTipoDocu().getSelectedItem().equals("Seleccione...")) || (usu.getTxtNombre().getText().isEmpty()) || (usu.getTxtDireccion().getText().isEmpty())
                    || (usu.getTxtCorreo().getText().isEmpty()) || (usu.getTxtLogin().getText().isEmpty()) || (usu.getTxtTelefono().getText().isEmpty())
                    || (usu.getJPClave().getPassword() == null) || (usu.getFecha().getDate() == null) || (usu.getComboBoxCargo().getSelectedItem().equals("Seleccione..."))
                    || (usu.getComboBoxCargo().getSelectedItem().equals("Seleccione..."))) {
                JOptionPane.showMessageDialog(null, "Debe ingresar información en todos los campos");
            } else {
                //Convertimos el dato de los combox al que entiende sql
                String valorSexo = usu.getComboBoxSexo().getSelectedItem().toString();
                int sexo = modusuario.llenarCombo("sexo").get(valorSexo);
                String valorRol = usu.getComboBoxCargo().getSelectedItem().toString();
                int rol = modusuario.llenarCombo("rol").get(valorRol);

                // seleccion de fecha, cambia al formato de fecha al que entiende sql
                java.util.Date fec = usu.getFecha().getDate();
                long fe = fec.getTime();
                java.sql.Date fecha = new Date(fe);

                //Contraseña
                char[] contra = usu.getJPClave().getPassword();
                String contrasena = String.valueOf(contra);

                modusuario.setTipo_doc(usu.getComboBoxTipoDocu().getSelectedItem().toString());
                modusuario.setNom(usu.getTxtNombre().getText());
                modusuario.setDire(usu.getTxtDireccion().getText());
                modusuario.setCorreo(usu.getTxtCorreo().getText());
                modusuario.setTele(usu.getTxtTelefono().getText());
                modusuario.setLog(usu.getTxtLogin().getText());
                modusuario.setFec(fecha);
                modusuario.setContra(contrasena);
                modusuario.setSex(sexo);
                modusuario.setRol(rol);

                if (usu.getBtnGuardar().getText().equals("Guardar")) {
                    modusuario.insertarUsuario();
                    modusuario.limpiar(usu.getUsuario().getComponents());
                } else {
                    modusuario.actualizarUsuario();
                    usu.setVisible(false);
                    prin.dispose();
                }

            }
        }

    }
//Actualizar Usuario

    void actualizarUsuario(int doc) {
        modusuario.buscarUsuario(doc);
        usu.getComboBoxTipoDocu().setEnabled(false);
        usu.getTxtLogin().setEnabled(false);
        usu.getComboBoxTipoDocu().setEnabled(false);
        usu.getComboBoxTipoDocu().setSelectedItem(String.valueOf(doc));
         usu.getTxtCorreo().setText(modusuario.getCorreo());
        usu.getTxtDireccion().setText(modusuario.getDire());
        usu.getTxtLogin().setText(modusuario.getLog());
        usu.getJPClave().setText(modusuario.getContra());
        usu.getFecha().setDate(modusuario.getFec());

        //llenar Sexo
        Map<String, Integer> info = modusuario.llenarCombo("sexo");
        for (String sexo : info.keySet()) {
            usu.getComboBoxSexo().addItem(sexo);
        }
        //obtener el valor de la base de datos
        String valoSexo = modusuario.obtenerSeleccion(info, modusuario.getSex());
        usu.getComboBoxSexo().setSelectedItem(valoSexo);

        //llenar Rol
        Map<String, Integer> info2 = modusuario.llenarCombo("rol");
        for (String rol : info2.keySet()) {
            usu.getComboBoxCargo().addItem(rol);
        }

        //obtener el valor de la base de datos
        String valoRol = modusuario.obtenerSeleccion(info, modusuario.getRol());
        usu.getComboBoxCargo().setSelectedItem(valoRol);

        
        //Llenar tipo de documento
        usu.getComboBoxTipoDocu().setSelectedItem(modusuario.getTipo_doc());

        //Cambiar Titulo
        Border borde = BorderFactory.createTitledBorder(null, "Actualizar Usuario",
                javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new java.awt.Font("Yu Gothic UI", 1, 36),
                new java.awt.Color(204, 0, 204));
        usu.getUsuario().setBorder(borde);
        prin.setVisible(false);
        usu.setLocationRelativeTo(null);
        usu.getBtnGuardar().setText("Actualizar");
        usu.setVisible(true);

    }
//Eliminar Usuario

    void eliminarUsuario(int doc) {
        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar al usuario? \n" + doc,
                 "Eliminar Usuario", JOptionPane.YES_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            modusuario.setDoc(doc);
            modusuario.eliminarUsuario();
        }
     }

}

