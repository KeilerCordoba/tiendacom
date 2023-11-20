package Controlador;

import Modelo.ModeloCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.Principal;
import java.sql.Date;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.Nuevo_Cliente;
import vista.Principal;

/**
 *
 * @author HuevosFundidos
 */
public class ControladorCliente implements ActionListener{
    Nuevo_Cliente vistacliente = new Nuevo_Cliente();
    Principal prin = new Principal();
    ModeloCliente modelocliente = new ModeloCliente();
    
    public ControladorCliente() {
        vistacliente.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vistacliente.getBtnGuardar().addActionListener(this);

    }
    
    public void Contro_clien() {

        vistacliente.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princ = new ControladorPrincipal();
                prin.iniciarPrincipal(1);
                // prin.iniciar(1);
            }
        });

        prin.setVisible(false);
        vistacliente.setLocationRelativeTo(null);
        vistacliente.setVisible(true);

        vistacliente.getComboBoxSexo().addItem("Seleccione...");
        Map<String, Integer> dato = modelocliente.llenarCombo("sexo");
        for (String sexo : dato.keySet()) {
            vistacliente.getComboBoxSexo().addItem(sexo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistacliente.getBtnGuardar())) {
            if (vistacliente.getTxtDocumento().getText().isEmpty() || vistacliente.getTxtNombre().getText().isEmpty() || vistacliente.getTxtCorreo().getText().isEmpty()
                    || vistacliente.getTxtDiereccion().getText().isEmpty() || vistacliente.getTxtTelefono().getText().isEmpty()
                    || vistacliente.getComboBoxSexo().getSelectedItem().equals("Seleccione...")
                    || vistacliente.getDate().getDate() == null) {
                JOptionPane.showMessageDialog(null, "Debe completar los campos requeridos...");
            } else {
                String valorSexo = vistacliente.getComboBoxSexo().getSelectedItem().toString();
                int sexo = modelocliente.llenarCombo("sexo").get(valorSexo);
                
                java.util.Date fec = vistacliente.getDate().getDate();
                long fe = fec.getTime();
                java.sql.Date fecha = new Date(fe);

                modelocliente.setDoc(Integer.parseInt(vistacliente.getTxtDocumento().getText()));
                modelocliente.setNom(vistacliente.getTxtNombre().getText());
                modelocliente.setFec(fecha);
                modelocliente.setDire(vistacliente.getTxtDiereccion().getText());
                modelocliente.setTele(vistacliente.getTxtTelefono().getText());
                modelocliente.setCorreo(vistacliente.getTxtCorreo().getText());
                modelocliente.setSex(sexo);
                
                modelocliente.insertarCliente();
                modelocliente.limpiar(vistacliente.getJPNuevoCliente().getComponents());
            }
        }

    }
}
