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

/**
 *
 * @author Camilo
 */
public class FacturacionLogic {
    
    private static FacturacionLogic facturacionlogic;
    
    int idPedido;
    int idCliente;
    String nomCliente;
    String nomProducto;
    int precioProdUnd;
    int cantProducto;
    int vlrTotalProd;
    
    //Constructor 1
    private FacturacionLogic(){
        
    }
    
    //Constructor 2
    private FacturacionLogic(int pedido, String nombre, int precio, int cantidad, int valor){
        this.idPedido = pedido;
        this.nomProducto = nombre;
        this.precioProdUnd = precio;
        this.cantProducto = cantidad;
        this.vlrTotalProd = valor;
    }
    
    //Contructor 3
    private FacturacionLogic(int idCliente, String nomCliente){
        this.idCliente = idCliente;
        this.nomCliente = nomCliente;
    }
    
    public static FacturacionLogic getInstance(){
        if(facturacionlogic == null){
            facturacionlogic = new FacturacionLogic();
        }
        return facturacionlogic;
    }
    
    //GETTERS & SETTERS
    public int getIdProd(){
        return idPedido;
    }
    
    public int getIdCliente(){
        return idCliente;
    }
    
    public String getNomCliente(){
        return nomCliente;
    }
    
    public String getNomProducto(){
        return nomProducto;
    }
    
    public int getPrecioProdUnd(){
        return precioProdUnd;
    }
    
    public int getCantProducto(){
        return cantProducto;
    }
    
    public int getVlrTotalProd(){
        return vlrTotalProd;
    }
    
    public void payBill(int order){
        String SSQL = "UPDATE factura_ventas SET estado_fv = true"
                + " WHERE"
                + " id_fact_v = ?";
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            PreparedStatement pst = conDB.prepareStatement(SSQL);
            pst.setInt(1, order);
            
            pst.executeUpdate();
            
        } catch (SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int orderIsOpen(int id_Ape, int idPed){
        int result = 0;
        String SSQL = "SELECT pr.id_producto, pr.nom_producto, p.precio_producto_und, p.cantidad_producto, p.vlr_total_producto"
                + " FROM factura_ventas fv, aper_caja ap, pedidos p, productos pr"
                + " WHERE"
                + " fv.id_fact_v = p.FK_id_fact_v and"
                + " ap.id_caja = p.FK_aper_caja and"
                + " pr.id_producto = p.FK_id_producto and"
                + " fv.estado_fv = false and"
                + " ap.id_caja = "+id_Ape+" and"
                + " p.id_pedido ="+idPed;
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            if(rs.next()){
                result +=1;
            } else {
                result = 0;
            }
        } catch (SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public FacturacionLogic getClient(int id_Ape, int idPed){
        FacturacionLogic f = null;
        String SSQL = "SELECT DISTINCT c.id_doc_cliente, c.nom_cliente"
                + " FROM clientes c, pedidos p"
                + " WHERE"
                + " p.FK_id_doc_cliente = c.id_doc_cliente and"
                + " p.id_pedido ="+idPed+" and"
                + " p.FK_aper_caja ="+id_Ape;
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            if(rs.next()){
                this.idCliente = rs.getInt(1);
                this.nomCliente = rs.getString(2);
                
                f = new FacturacionLogic(idCliente, nomCliente);
            } else {
                f = null;
            }
            
        } catch (SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
    
    public LinkedList<FacturacionLogic>getOrder(int id_Ape, int idPed){
        LinkedList<FacturacionLogic> listadoItemsPedido = new LinkedList<>();
        String SSQL = "SELECT pr.id_producto, pr.nom_producto, p.precio_producto_und, p.cantidad_producto, p.vlr_total_producto"
                + " FROM factura_ventas fv, aper_caja ap, pedidos p, productos pr"
                + " WHERE"
                + " fv.id_fact_v = p.FK_id_fact_v and"
                + " ap.id_caja = p.FK_aper_caja and"
                + " pr.id_producto = p.FK_id_producto and"
                + " fv.estado_fv = false and"
                + " ap.id_caja = "+id_Ape+" and"
                + " p.id_pedido ="+idPed;
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                this.idPedido = rs.getInt(1);
                this.nomProducto = rs.getString(2);
                this.precioProdUnd = rs.getInt(3);
                this.cantProducto = rs.getInt(4);
                this.vlrTotalProd = rs.getInt(5);
                
                FacturacionLogic fl = new FacturacionLogic(idPedido, nomProducto, precioProdUnd, cantProducto, vlrTotalProd);
                listadoItemsPedido.add(fl);
            }
            
        } catch (SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoItemsPedido;
    }
    
}
