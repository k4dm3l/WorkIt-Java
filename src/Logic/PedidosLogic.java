package Logic;

import Persistencia.ConnectionMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Camilo
 */
public class PedidosLogic {
    
    int id_producto;
    String nom_producto;
    String desc_producto;
    int precio_producto_und;
    int id_cat_prod;
    int cantidad;
    int total;
    int totalPedido;
    int cantidadItemas;
    
    LinkedList<PedidosLogic>orderList;
    
    //Constructor1
    public PedidosLogic(int ID, String Nombre, String Desc, int Precio, int Cat){
        this.id_producto = ID;
        this.nom_producto = Nombre;
        this.desc_producto = Desc;
        this.precio_producto_und = Precio;
        this.id_cat_prod = Cat;
    }
    
    //Constructor2
    public PedidosLogic(int ID, String Nombre, int Precio){
        this.id_producto = ID;
        this.nom_producto = Nombre;
        this.precio_producto_und = Precio;
    }
    
    //Constructor3
    public PedidosLogic(int ID, String Nombre, int Precio, int Cant, int Total){
        this.id_producto = ID;
        this.nom_producto = Nombre;
        this.precio_producto_und = Precio;
        this.cantidad = Cant;
        this.total = Total;
    }
    
    //Constructor4
    public PedidosLogic(){
        
    }
    
    public int getIdProducto(){
        return id_producto;
    }
    
    public String getNombreProducto(){
        return nom_producto;
    }
    
    public String getDescProducto(){
        return desc_producto;
    }
    
    public int getPrecioProducto(){
        return precio_producto_und;
    }
    
    public int getIdCat(){
        return id_cat_prod;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public int getTotal(){
        return total;
    }
    
    /**
    public LinkedList<PedidosLogic>getUpdatedProducts() throws ClassNotFoundException{
        LinkedList<PedidosLogic> listadoProductos = new LinkedList<PedidosLogic>();
        String SSQL = "SELECT id_producto, nom_producto, precio_producto_und FROM Productos";
                
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                id_producto = rs.getInt(1);
                nom_producto = rs.getString(2);
                precio_producto_und = rs.getInt(3);
                PedidosLogic p = new PedidosLogic(id_producto, nom_producto, precio_producto_und);
                listadoProductos.add(p);
            }
            
        } catch (SQLException ex){
            System.err.println(ex);
        }
        
        return listadoProductos;
    }
    **/
    
    public LinkedList<PedidosLogic>GetProductos() {
        LinkedList<PedidosLogic> listadoProductos = new LinkedList<PedidosLogic>();
        String SSQL = "SELECT id_producto, nom_producto, precio_producto_und FROM Productos";
                
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                id_producto = rs.getInt(1);
                nom_producto = rs.getString(2);
                precio_producto_und = rs.getInt(3);
                PedidosLogic p = new PedidosLogic(id_producto, nom_producto, precio_producto_und);
                listadoProductos.add(p);
            }
            
        } catch (SQLException ex){
            System.err.println(ex);
        } catch(ClassNotFoundException ex){
            
        }
        
        return listadoProductos;
    }
    
    public void productFilter(String search, JTable table){
        DefaultTableModel dm;
        
        dm = (DefaultTableModel) table.getModel();
        TableRowSorter trs = new TableRowSorter(dm);
        
        table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));
    }
    
    //Creacion Factura Venta - Creacion Pedido
    public void createOrderBill(int cantItems, int totalPedido){
        String SSQL = "INSERT INTO factura_ventas (cantidad_items, vlr_total_fv) VALUES ("+cantItems+", "+totalPedido+")";
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            Statement st = conDB.createStatement();
            st.execute(SSQL);
        } catch(SQLException ex){
            System.out.println("Exception: "+ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception: "+ex);
        }
    }
    
    //Creacion registro de Pedido x Producto
    public void createOrder(int idP, int idF, int idProd, int idUs, int idC, int idAp, int idM, int pp, int cp, int vlrp, String descP) {
        String SSQL = "INSERT INTO pedidos "
                + "(id_pedido, FK_id_fact_v, FK_id_producto, FK_id_doc_usuario, FK_id_doc_cliente, FK_aper_caja, FK_id_mesa, precio_producto_und, cantidad_producto, vlr_total_producto, observacion_pedido)"
                + " VALUES"
                + " ("+idP+", "+ idF+", "+ idProd+", "+ idUs+", "+ idC+", "+ idAp+", "+idM+", "+ pp+", "+ cp+", "+ vlrp+", '"+descP+"')";
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            Statement st = conDB.createStatement();
            st.execute(SSQL);
        } catch(SQLException ex){
            System.out.println("Exception: "+ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception: "+ex);
        }
        
    }
    
    //Obtener la ultima factura generada
    public int getLastBill(){
        int idFact = 0;
        String SSQL = "SELECT  max(id_fact_v) FROM factura_ventas";
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                idFact = rs.getInt(1);
            }
            
        } catch (SQLException ex){
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return idFact;
    }
    
    public void loadComboBoxMesas(JComboBox jc){
        String SSQL = "SELECT nombre_mesa FROM mesas";
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            jc.addItem("Seleccione Mesa");
            
            while(rs.next()){
                jc.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex){
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        }
    }
    
}
