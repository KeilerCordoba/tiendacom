package modeloLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;

public class usuario_controlador implements ActionListener {

    Nuevo_usuario Nuevo = new Nuevo_usuario();
    principal prin = new principal();
    ModeloUsuario usu = new ModeloUsuario();

    public usuario_controlador() {

    }

    public void usu_contro() {
        nuevo.addWindowListener(new windowAdapter() {
            public void windowClosed(windowEvent ) {
                prin.setvisible(true);

            }
        }
        prin.setVisible(false);
        nuevo.setlocationRealativeTo(null);
        nuevo.setVisible(true);

        nuevo.getJcvsexo(.addItem("selecione");
        map<String, Integer> dato = usu.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            nuevo.getJcvsexo().addItem(sexo);
        }
        nuevo.getCbxCargo().addItem("selecione...");
        map<String rol
        :datos = usu.llenarCombo("rol");
        for (String rol : datos.keySet()) {
            nuevo.getCbxCargo().addItem(rol);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ) {

    }
}
