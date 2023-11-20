package Controlador;

import Modelo.ModeloProveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.Principal;
import java.sql.Date;

import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import vista.NuevoProveedor;

public class ControladorProveedor implements ActionListener {

    NuevoProveedor provee = new NuevoProveedor();
    Principal prin = new Principal() {
        @Override
        public String getName() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    };
    ModeloProveedor modproveedor = new ModeloProveedor();

    public ControladorProveedor() {
        provee.getBtnGuardar().addActionListener(this);
        provee.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        provee.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princ = new ControladorPrincipal();
                princ.iniciarPrincipal(0);
            }
        });
    }

    public void controlProveedor() {
        prin.equals(false);
        provee.setLocationRelativeTo(null);
        provee.setTitle("Nuevo Proveedor");
        provee.setVisible(true);

        //lleno combo box sexo
        provee.getjComboBoxSexo().addItem("Seleccione...");
        Map<String, Integer> combosexo = modproveedor.llenarCombo("sexo");
        for (String sexo : combosexo.keySet()) {
            provee.getjComboBoxSexo().addItem(sexo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(provee.getBtnGuardar())) {
            //validar campos vacios
            if ((provee.getTextDocumento().getText().isEmpty()) ||(provee.getComboBoxTipoDocu().getSelectedItem().equals("Seleccione..."))|| (provee.getTxtNombre().getText().isEmpty()) || (provee.getTxtDirec().getText().isEmpty())
                    || (provee.getTxtCorreo().getText().isEmpty()) || (provee.getTxtTelefono().getText().isEmpty())|| (provee.getDateFecha().getDate() == null) 
                    || (provee.getjComboBoxTipoPerso().getSelectedItem().equals("Seleccione...")) ||(provee.getjComboBoxSexo().getSelectedItem().equals("Seleccione..."))) {
                JOptionPane.showMessageDialog(null, "Debe ingresar información en todos los campos");
            } else {
              //Convertimos el dato de los combox al que entiende sql
                String valorSexo = provee.getjComboBoxSexo().getSelectedItem().toString();
                int sexo = modproveedor.llenarCombo("sexo").get(valorSexo);
                
                // seleccion de fecha, cambia al formato de fecha al que entiende sql
                java.util.Date fec = provee.getDateFecha().getDate();
                long fe = fec.getTime();
                java.sql.Date fecha = new Date(fe);
                        
                modproveedor.setDoc(Integer.parseInt(provee.getComboBoxTipoDocu().getSelectedItem().toString()));
                modproveedor.setTipo_docu(provee.getComboBoxTipoDocu().getSelectedItem().toString());
                modproveedor.setNom(provee.getTxtNombre().getText());
                modproveedor.setDire(provee.getTxtDirec().getText());
                modproveedor.setTipo_per(provee.getjComboBoxTipoPerso().getSelectedItem().toString());
                modproveedor.setCorreo(provee.getTxtCorreo().getText());
                modproveedor.setTele(provee.getTxtTelefono().getText());
                modproveedor.setFec(fecha);
                modproveedor.setSex(sexo);
                modproveedor.insertarProveedor();
                modproveedor.limpiar(provee.getJPproveedor().getComponents());

            }
        }

    }

}
