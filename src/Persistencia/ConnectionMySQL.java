package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Camilo
 */
public class ConnectionMySQL {
    
    public String drive = "com.mysql.jdbc.Driver";
    public String host = "localhost";
    public String port = "3306";
    public String database = "LAUD_DB";
    
    public String username = "root";
    public String password = "whateverpass";
    
    public String url = "jdbc:mysql://" + host + ":" + port + "/" + database ;
    
    private Connection dbConnection = null;    
    private static ConnectionMySQL connectionDB;
    
    private ConnectionMySQL(){
        
    }
    
    public static ConnectionMySQL getInstance( ){
        if(connectionDB == null){
            connectionDB = new ConnectionMySQL();
        }
        return connectionDB;
    }
    
    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        if(dbConnection == null){
            try{
                Class.forName(drive);
                dbConnection = DriverManager.getConnection(url, username, password);
                System.out.println("ConnectionMySQL DB: "+database);
            } catch(SQLException ex){
                JOptionPane.showMessageDialog(null, "Error de Conexion a la base de datos: Por favor verifique que el servidor de la base de datos, se este ejecutando. Comuniquese con soporte tecnico a ignitedevsoft@gmail.com", "Error Base de Datos", JOptionPane.ERROR_MESSAGE);
                throw new SQLException(ex);
            } catch(ClassNotFoundException ex){
                System.out.println("NO CONNECTION  2");
                throw new ClassCastException(ex.getMessage());
            }
        }
        return dbConnection;
    }
    
    public void closeDBConnection() throws SQLException{
        if(dbConnection != null){
            try{
                dbConnection.close();
            } catch(SQLException ex){
                throw new SQLException(ex.getMessage());
            }
        }
    }
    
}
