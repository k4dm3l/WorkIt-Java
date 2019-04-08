package Logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo
 */
public class PrincipalLogic {
    
    private static PrincipalLogic principal;
    
    //Constructor
    private PrincipalLogic(){
        
    }
    
    public static PrincipalLogic getInstance(){
        if(principal == null){
            principal = new PrincipalLogic();
        }
        return principal;
    }
    
    public String getUserName(String user, String password, Connection conDB) throws SQLException{
        String nom_usuario = "";
        String SSQL = "SELECT nom_usuario FROM usuarios WHERE nick_usuario = '"+user+"' AND clave_usuario=sha1('"+password+"')";
        
        try{
                Statement st =  (Statement) conDB.createStatement();
                ResultSet rs = st.executeQuery(SSQL);

                if(rs.next()){
                    nom_usuario = rs.getString(1);
                }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        } 
        return nom_usuario;
    }
    
    public String getRolUser(String user, String password, Connection conDB) throws SQLException{
        String rol_usuario = "";
        String SSQL = "SELECT rol_usuario FROM usuarios WHERE nick_usuario = '"+user+"' AND clave_usuario=sha1('"+password+"')";
        
        try{
                Statement st =  (Statement) conDB.createStatement();
                ResultSet rs = st.executeQuery(SSQL);

                if(rs.next()){
                    rol_usuario = rs.getString(1);
                } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        } 
        return rol_usuario;
    }
    
}
