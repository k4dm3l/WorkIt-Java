package Logic;

import Persistencia.ConnectionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo
 */
public class ClientesLogic {
    
    static int id_doc_cliente;
    static String nom_cliente;
    
    private static ClientesLogic clienteslogic;
    
    private  ClientesLogic(){
        
    }
    
    private ClientesLogic(int id, String nombre){
        this.id_doc_cliente = id;
        this.nom_cliente = nombre;
    }
    
    public static ClientesLogic getInstance(){
        if(clienteslogic == null){
            clienteslogic = new ClientesLogic(id_doc_cliente, nom_cliente);
        }
        return clienteslogic;
    }
    
    public void searchClient(int id){
        String SSQL = "SELECT id_doc_cliente, nom_cliente FROM clientes WHERE id_doc_cliente = "+id;
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
                while(rs.next()){
                    this.id_doc_cliente = rs.getInt(1);
                    this.nom_cliente = rs.getString(2);
                }
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientesLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getId_Cliente(){
        return this.id_doc_cliente;
    }
    
    public String getNomCliente(){
        return this.nom_cliente;
    }
    
}
