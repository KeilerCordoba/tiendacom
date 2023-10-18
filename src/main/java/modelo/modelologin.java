package modeloLogin;

import vista.login;
import java.sql.connetion;
import vista.nuevo_usuario;

public class modelologin{
    
    conexion conect = new conexion();
    connetion cn = conect.iniciarConexion();
    
    String usu, contra;
    nuevo_usuario lg = new nuevo_usuario();
    
    public modelologin(){
    }
    
    public String getUsu(){
        return usu;
    }
    
    public void setUsu(String usu){
        this.usu = usu;
    }
    public String getContra(){
        return contra;
    }
    public void setContra(String contra){
        this.contra=contra;
    }
    
    public boolean validar(String usuario, String pass){
       boolean result=false;
       String sql="call login(?,?)";
       preparedStatement ps = cn.preparedStatement(sql);
       ps.setString(1, usuario);
       ps.setString(2, pass);
       resultset rs = ps.executeQuery();
       while (rs.next()){
           ;
       }
       cn.close();
       conect.cerrarConexion();
    }
} 




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
