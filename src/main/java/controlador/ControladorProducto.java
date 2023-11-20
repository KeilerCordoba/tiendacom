
package Controlador;

import Modelo.ModeloProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;
import vista.Nuevo_Producto;
import vista.Principal;

public class ControladorProducto implements ActionListener {

    Nuevo_Producto pro = new Nuevo_Producto();
    Principal prin = new Principal();
    ModeloProducto modproduc = new ModeloProducto();

    public ControladorProducto() {
        pro.getBtnBuscar().addActionListener(this);
        pro.getBtnGuardar().addActionListener(this);
        pro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pro.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                ControladorPrincipal princ = new ControladorPrincipal();
                princ.iniciarPrincipal(0);
            }
        });
    }

    public void controlProducto() {
        prin.setVisible(false);
        pro.setLocationRelativeTo(null);
        pro.setTitle("Nuevo Producto");
        pro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(pro.getBtnBuscar())){
            modproduc.buscarImagen();
            File file= new File(modproduc.getRuta());
            String archivo= file.getName();//obtiene solo el nombre de la ruta
            pro.getTxtImagen().setText(archivo);
        }
        if(e.getSource().equals(pro.getBtnGuardar())){
            modproduc.setNom(pro.getTxtNombre().getText());
            modproduc.setDescri(pro.getTxtDescrip().getText());
            modproduc.setImagen(modproduc.convertirImagen(modproduc.getRuta()));
            modproduc.insertarProducto();
            modproduc.limpiar(pro.getJPproveedor().getComponents());
        }

    }

}