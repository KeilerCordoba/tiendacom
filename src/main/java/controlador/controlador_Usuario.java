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
}
