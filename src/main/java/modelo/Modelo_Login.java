package modelo;

import controlador.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Modelo_Login {

    private String lo, co,usu;

    public String getUsu() {
        return usu;
    }

    public void setUsu(String usu) {
        this.usu = usu;
    }

    public Modelo_Login() {
    }

    public String getLo() {
        return lo;
    }

    public void setLo(String lo) {
        this.lo = lo;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public boolean verificar(String usu, String contra) {
        Conexion cone = new Conexion();
        Connection cn = (Connection) cone.iniciarConexion();
        boolean resultado = false;
        String sql = "Call login(?,?)";
        try {
             PreparedStatement ps = cn.prepareStatement(sql);
             ps.setString(1,usu);
             ps.setString(2,contra);
             
             ResultSet rs = ps.executeQuery();
             
             while(rs.next()){
                 resultado = true;
                
             }
             if (resultado == true){
                 cn.close();
                 cone.cerraConexion();
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return resultado;
    }

}
