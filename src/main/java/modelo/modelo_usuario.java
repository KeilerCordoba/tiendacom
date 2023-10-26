
package modeloLogin;

import controlador.conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class modelo_usuario {
    
    private int idusuario, rang, tele, sex;
    private String nom, correo, dire, log, contra;
    private Date fecha_nacimiento;
    
    

    public modelo_usuario() {
        
    }

    public conexion getConect() {
        return conect;
    }

    public void setConect(conexion conect) {
        this.conect = conect;
    }

    public connection getCn() {
        return cn;
    }

    public void setCn(connection cn) {
        this.cn = cn;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDire() {
        return dire;
    }

    public void setDire(String dire) {
        this.dire = dire;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getContra() {
        return contra;      
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }
                          
    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
    public Map<String,Integer> llenarCombo(String valor){
    conexion conect = new conexion();
    Connection cn = conect.iniciarConexion();
    String sql = "select * from mostrar"+ valor;
    
    Map<String, Integer> llenar_Combo = new HasMap<>();
    try {
        Statement st = cn.createStatement();
        Resultset rs = st.execute(sql);
        while (rs.nex()){
            llenar_Combo.put(rs.getString,(2), rs.getInt,(1));
            
        }
        
    }catch (SQLException e){
        e.printStackTrace();
    }
    return llenar_Combo;
        
    }
    
    public void insertarUsuario() throws SQLException{
        conexion conect = new conexion();
        Connection cn = (Connection) conect.iniciarConexion();
        String sql = "call new_Usua (?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, getDoc());
            ps.setString(3, getNom());
            ps.setString(2, getTipodoc());
            ps.setInt(4, getSex());
            ps.setInt(5, getRol());
            ps.setString(6, getTel());
            ps.setString(7, getCor());
            ps.setString(8, getDir());
            ps.setString(9, getLo());
            ps.setString(10, getCl());
            ps.setDate(11, (java.sql.Date) getFec());
            ps.executeUpdate();
            JOptionpane.showMessageDialog(null, "registro almacenamiento", "registro");
            cn.close();
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        conect.cerraConexion();
        
    }
    public void limpiar(component[] panel){
        for (object control : panel) {
            if
        }
        
    }

    private int getRol() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getLo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getCor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getTel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private int getDoc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getTipodoc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String getDir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}   
