package Logic;

import Persistencia.ConnectionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Camilo
 */
public class UsuariosLogic {
    
    static UsuariosLogic ul;
    
    int id_doc_usuario;
    String nom_usuario;
    String ape_usuario;
    String nick_usuario;
    String clave_usuario;
    String rol_usuario;
    boolean estado_usuario; //TRUE - ACTIVO - DEFAULT EN CREACION
    String fec_creacion_usuario;
    
    //CONSTRUCTOR 1
    private UsuariosLogic(){
        
    }
    
    //CONSTRUCTOR 2
    private UsuariosLogic(int id, String nom, String ape, String nick, String rol, boolean estado){
        this.id_doc_usuario = id;
        this.nom_usuario = nom;
        this.ape_usuario = ape;
        this.nick_usuario = nick;
        this.rol_usuario = rol;
        this.estado_usuario = estado;
    }
    
    //SINGLETON
    public static UsuariosLogic getInstance(){
        if(ul == null){
            ul = new UsuariosLogic();
        }
        return ul;
    }
    
    //GETTERS & SETTERS
    public int getIdUser(){
        return this.id_doc_usuario;
    }
    
    public String getNomUser(){
        return this.nom_usuario;
    }
    
    public String getApeUser(){
        return this.ape_usuario;
    }
    
    public String getNickUser(){
        return this.nick_usuario;
    }
    
    public String getClaveUser(){
        return this.clave_usuario;
    }
    
    public String getRolUser(){
        return this.rol_usuario;
    }
    
    public String getFecCrea(){
        return this.fec_creacion_usuario;
    }
    
    public boolean getEstadoUser(){
        return this.estado_usuario;
    }
    
    public String getNomCompleto(){
        return nom_usuario+ape_usuario;
    }
    
    //METODOS
    public LinkedList<UsuariosLogic> GetUsers(){
        LinkedList<UsuariosLogic> listadoUsuarios = new LinkedList<UsuariosLogic>();
        String SSQL = "SELECT id_doc_usuario, nom_usuario, ape_usuario, nick_usuario, rol_usuario, estado_usuario FROM usuarios";
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                id_doc_usuario = rs.getInt(1);
                nom_usuario = rs.getString(2);
                ape_usuario = rs.getString(3);
                nick_usuario = rs.getString(4);
                rol_usuario = rs.getString(5);
                estado_usuario = rs.getBoolean(6);
                
                UsuariosLogic u = new UsuariosLogic(id_doc_usuario, nom_usuario, ape_usuario, nick_usuario, rol_usuario, estado_usuario);
                listadoUsuarios.add(u);
            }
            
        } catch(SQLException ex){
            System.err.println(ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.err.println(ex.getMessage());
        }
        
        return listadoUsuarios;
    }
    
    public void userFilter(String search, JTable table){
        DefaultTableModel dm;
        
        dm = (DefaultTableModel) table.getModel();
        TableRowSorter trs = new TableRowSorter(dm);
        
        table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));
    }
    
    public void searchUser(int idUser){
        String SSQL = "SELECT id_doc_usuario, nom_usuario, ape_usuario, nick_usuario, rol_usuario, estado_usuario, fec_crea_usuario"
                + " FROM usuarios"
                + " WHERE id_doc_usuario = "+idUser;
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                id_doc_usuario = rs.getInt(1);
                nom_usuario = rs.getString(2);
                ape_usuario = rs.getString(3);
                nick_usuario = rs.getString(4);
                rol_usuario = rs.getString(5);
                estado_usuario = rs.getBoolean(6);
                fec_creacion_usuario = rs.getString(7);
            }
            
        } catch(SQLException ex){
            System.err.println(ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void disableUser(int idUser){
        String SSQL = "UPDATE usuarios SET estado_usuario = false"
                + " WHERE"
                + " id_doc_usuario = ?";
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            PreparedStatement pst = conDB.prepareStatement(SSQL);
            pst.setInt(1, idUser);
            
            pst.executeUpdate();
            
        } catch (SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateUser(int idU, String nomU, String apeU, String nickU, String rolU, boolean estU){
        String SSQL = "UPDATE usuarios SET "
                + " nom_usuario = ?"
                + " ,ape_usuario = ?"
                + " ,nick_usuario = ?"
                + " ,rol_usuario = ?"
                + " ,estado_usuario = ?"
                + " WHERE"
                + " id_doc_usuario = "+idU;
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            PreparedStatement pst = conDB.prepareStatement(SSQL);
            
            pst.setString(1, nomU);
            pst.setString(2, apeU);
            pst.setString(3, nickU);
            pst.setString(4, rolU);
            pst.setBoolean(5, estU);
            
            pst.executeUpdate();
            
        } catch (SQLException ex){
            
        } catch(ClassNotFoundException ex){
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
