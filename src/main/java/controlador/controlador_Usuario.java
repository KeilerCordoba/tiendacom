package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import modelo.modelo_Usuario;
import vista.principal;
import vista.usuario;

public class controlador_Usuario implements ActionListener {

    Usuarios usu = new Usuarios();
    principal pri = new principal();
    modelo_Usuario mode_usu = new modelo_Usuario();

    public void controUsuario() {

        usu.addWindowListener(new WindowAdapter() {
            public void WindowClosed(WindowEvent y) {
                pri.setVisible(true);

            }

        });

        pri.setVisible(false);
        usu.setLocationRelativeTo(null);
        usu.setVisible(true);

        usu.getjcbBoxselec_sexo().addItem("seleccione...");
        map<String, Integer> datos = mode_usu.llenarCombo("sexo");
        for (String sexo : dato.keyset()) {
            usu.getjcbBoxselec_sexo().addItem(sexo);

        }

        usu.getjComboBoxcargo().addItem("seleccione...");
        map<String, Integer> datos = mode_usu.llenarCombo("cargo")
        for (String rol : datos.keySet()) {
            usu.getjComboBoxcargo().addItem(rol);

        }

    }

    public controlador_Usuario() {
        usu.getjButtoguardar().addActionListener(this);

    }

    @Override

    public void actionperformed(ActionEvent y) {
        if (y.getSource().equals(usu.getjButtoguardar())) {
            if (((usu.getjTextinsert_usuario.getText().isEmpty()) || (usu.getjTextier_nombre().getText().isEmpty)
                    || (usu.getjTextinsert_telefono().getText().isEmpty())
                    || (usu.getjcbBoxselec_sexo().getSelectedItem().equals("selecione..."))
                    || (usu.getjTextinser_direcion().getTex().isEmpaty())
                    || (usu.getjDateChooserFecha_nacimiento().getDate() == null)
                    || (usu.getjComboBoxcargo().getSelectedItem().equals("selecione")
                    || (usu.getjTextinsert_login().getText().isEmoty())
                    || (usu.getjTextinsert_correo().getTex().isempty())
                    || (usu.getjpasinsert_clave().getpassword() == null)))) {
                System.out.println("falta informacion");

            }
        } else {
            String valorSexo = usu.getjCbBoxselec_sexo().getSelectedItem().toString();
            String valorCargo = usu.getjComboBoxcargo().getSelectedItem().toString();

            int sexo = mode_usu.llenarCombo("sexo").get(varlorSexo);
            int cargo = mode_usu.llenarCombo("cargo").get(valorCargo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Valida los eventos
        if (e.getSource().equals(prin.getBtnNuevo())) {//Se crea al acción cuando le damos clic en el boton nuevo de la vista princial

            /*Al cerrar la ventana nuevo no cierra el programa sino que abre la ventana principal*/
            nuevo.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    prin.setVisible(true);
                }
            });
            prin.setVisible(false);//Cierra la ventana principal para a que solo se visualice la ventana de nuevo usuario
            nuevo.setLocationRelativeTo(null);
            nuevo.setVisible(true);

            //Lleno el combobox de sexo
            nuevo.getJcvsexo().addItem("Seleccione...");
            Map<String, Integer> dato = usu.llenarCombo("sexo");
            for (String sexo : dato.keySet()) {
                nuevo.getJcvsexo().addItem(sexo);
            }
            //Lleno el combobox de rol
            nuevo.getCbxCargo().addItem("Seleccione...");
            Map<String, Integer> datos = usu.llenarCombo("rol");
            for (String rol : datos.keySet()) {
                nuevo.getCbxCargo().addItem(rol);
            }
        }

    }

}

