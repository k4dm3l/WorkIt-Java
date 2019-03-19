package Logic;

import Persistencia.ConnectionMySQL;
import java.sql.Connection;
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
    
    public LinkedList<PedidosLogic>GetProductos() throws ClassNotFoundException{
        LinkedList<PedidosLogic> listadoProductos = new LinkedList<PedidosLogic>();
        String SSQL = "SELECT id_producto, nom_producto, precio_producto_und FROM Productos";
        
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConncetion();
            
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
    
    public void productFilter(String search, JTable table){
        DefaultTableModel dm;
        
        dm = (DefaultTableModel) table.getModel();
        TableRowSorter trs = new TableRowSorter(dm);
        
        table.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(search));
    }
    
}
