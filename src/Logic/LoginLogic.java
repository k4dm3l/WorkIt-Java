package Logic;

import Persistencia.ConnectionMySQL;
import com.sun.istack.internal.Pool;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo
 */
public class LoginLogic {
    
    private static LoginLogic loginlogic;
    
    private static int user_ID;
    private static String userN;
    private static String pass;
    
//Singleton
    private LoginLogic (){
        
    }
    
    public static LoginLogic getInstance(){
        if(loginlogic == null){
            loginlogic = new LoginLogic();
        }
        return loginlogic;
    }
    
    public int checkLogin(String user, String password, Connection conDB) throws SQLException{
        int result = 0;
        String SSQL = "SELECT nom_usuario, id_doc_usuario FROM usuarios WHERE nick_usuario = '"+user+"' AND clave_usuario=sha1('"+password+"') AND estado_usuario = TRUE";
        
        try{
                Statement st =  (Statement) conDB.createStatement();
                ResultSet rs = st.executeQuery(SSQL);
                
                if(rs.next()){
                    result = 1 + result;
                    JOptionPane.showMessageDialog(null, "Bienvenido "+rs.getString(1), "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
                    user_ID = rs.getInt(2);
                    userN = rs.getString(1);
                }  else {
                    //conDB.close();
                }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        } 
        return result;
    }
    
    public void setUser(String user){
        LoginLogic.userN = user;
    }
    
    public String getUser(){
        return userN;
    }
    
   public void setPass(String pass){
        LoginLogic.pass = pass;
        
    }
    
    public String getPass(){
        return pass;
    }
    
    public int getUserID(){
        return user_ID;
    }
    
    public void setUserID(int id){
        LoginLogic.user_ID = id;
    }
    
}
