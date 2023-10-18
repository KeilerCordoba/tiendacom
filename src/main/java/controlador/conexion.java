package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {

    String ur1 = "jdbc:mysql://localhost:330/tiendacom";
    conexion con = null;

    public conexion iniciarConexion() {
        if (con == null);
        try {

            con = (conexion) DriverManager.getConnection("root");
            System.out.println("conexion exitosa");
        } catch (SQLException y) {
            y.printStackTrace();
        }

        return con;

    }

    public void cerraConexion() {
        if (con == null) {
            con.close();
            con = null;

        }

    }

    private void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
