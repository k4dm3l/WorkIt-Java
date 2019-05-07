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
public class ProductosLogic {
    
    private static ProductosLogic productoslogic;
    
    int id_producto;
    String nom_producto;
    String desc_producto;
    int precio_producto_und;
    int id_cat_prod;
    String fec_Crea_prod;
    
    //Constructor1
    private ProductosLogic(){
        
    }
    
    //Constructor2
    private ProductosLogic(int ID, String Nombre, String desc, int Precio, int Categ, String fec_Crea_prod){
        this.id_producto = ID;
        this.nom_producto = Nombre;
        this.desc_producto = desc;
        this.precio_producto_und = Precio;
        this.id_cat_prod = Categ;
        this.fec_Crea_prod = fec_Crea_prod;
    }
    
    //Constructor3
    ProductosLogic(int ID, String Nombre, int Precio){
         this.id_producto = ID;
         this.nom_producto = Nombre;
         this.precio_producto_und = Precio;
    }
    
    public static ProductosLogic getInstance(){
        if(productoslogic == null){
            productoslogic = new ProductosLogic();
        }
        return productoslogic;
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
    
    public String getFec_Crea(){
        return fec_Crea_prod;
    }
    
    public LinkedList<ProductosLogic>GetProductos() throws ClassNotFoundException{
        LinkedList<ProductosLogic> listadoProductos = new LinkedList<ProductosLogic>();
        String SSQL = "SELECT id_producto, nom_producto, desc_producto, precio_producto_und, FK_id_cat_prod, fec_crea_producto FROM Productos";
                
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                id_producto = rs.getInt(1);
                nom_producto = rs.getString(2);
                desc_producto = rs.getString(3);
                precio_producto_und = rs.getInt(4);
                id_cat_prod = rs.getInt(5);
                fec_Crea_prod = rs.getString(6);
                ProductosLogic p = new ProductosLogic(id_producto, nom_producto, desc_producto, precio_producto_und, id_cat_prod, fec_Crea_prod);
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
    
    public void updateProduct(int idP, String nomP, String descP, int precioP, int catP){
        String SSQL = "UPDATE productos SET "
                + " nom_producto = ?"
                + " ,desc_producto = ?"
                + " ,precio_producto_und = ?"
                + ", FK_id_cat_prod = ?"
                + " WHERE"
                + " id_producto = "+idP;
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            PreparedStatement pst = conDB.prepareStatement(SSQL);
            
            pst.setString(1, nomP);
            pst.setString(2, descP);
            pst.setInt(3, precioP);
            pst.setInt(4, catP);
            
            pst.executeUpdate();
            
        } catch (SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
