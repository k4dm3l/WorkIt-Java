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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo
 */
public class CajaLogic {
    
    int id_Ape;
    int saldo_Ape;
    String fecha_Ape;
    
    int idPed;
    int cantItemPed;
    int vlrTotalPed;
    
    int idFacVen;
    int vlrTotalFacVen;
    
    int totalVentas; //Variable para almacenar total de ventas por apertura de caja
    
    private static CajaLogic cajalogic;
    
    //Contructor 1
    private CajaLogic() {
    
    }
    
    //Constructor 2
    private CajaLogic(int id_Ape, int saldo_Ape, String fecha_Ape){
        this.id_Ape = id_Ape;
        this.saldo_Ape = saldo_Ape;
        this.fecha_Ape = fecha_Ape;
    }
    
    //Constructor 3
    private CajaLogic(int idPed, int cantItems, int vlrTotal){
        this.idPed = idPed;
        this.cantItemPed = cantItems;
        this.vlrTotalPed = vlrTotal;
    }
    
    //Constructor 4
    private CajaLogic(int idFac, int vlrFac){
        this.idFacVen = idFac;
        this.vlrTotalFacVen = vlrFac;
    }
    
    public static CajaLogic getInstance(){
        if(cajalogic == null){
            cajalogic = new CajaLogic();
        }
        return cajalogic;
    }
    //GETTERS & SETTERS    
    public int getVlrFacVen(){
        return vlrTotalFacVen;
    }
    
    public int getId_FacVen(){
        return idFacVen;
    }
    
    public int getVlrTotal(){
        return vlrTotalPed;
    }
    
    public int getCantItems(){
        return cantItemPed;
    }
    
    public int getId_Ped(){
        return idPed;
    }
    
    public int getId_Ape(){
        return id_Ape;
    }
    
    public int getSaldo_Ape(){
        return saldo_Ape;
    }
    
    public String getFecha_Ape(){
        return fecha_Ape;
    }
    
    public void setId_Ape(int idCaja){
        id_Ape = idCaja;
    }
    
    public int getTotalSales(int id_Ape){
        String SSQL = "SELECT sum(p.vlr_total_producto)"
                + " FROM aper_caja ac, factura_ventas fv, pedidos p"
                + " WHERE"
                + " ac.id_caja = p.FK_aper_caja and"
                + " fv.id_fact_v = p.FK_id_fact_v and"
                + " ac.id_caja ="+id_Ape;
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                totalVentas = rs.getInt(1);
            }
            
        } catch(SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalVentas;
    }
    
    public LinkedList<CajaLogic>getSales(int id_Ape){
        LinkedList<CajaLogic> listadoFactVen = new LinkedList<>();
        String SSQL = "SELECT DISTINCT fv.id_fact_v, fv.vlr_total_fv"
                + " FROM factura_ventas fv, aper_caja ap, pedidos p"
                + " WHERE"
                + " ap.id_caja = p.FK_aper_caja and"
                + " fv.id_fact_v = p.FK_id_fact_v and"
                + " fv.estado_fv = true and"
                + " ap.id_caja = "+id_Ape;
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                idFacVen = rs.getInt(1);
                vlrTotalFacVen = rs.getInt(2);
                
                CajaLogic cl = new CajaLogic(idFacVen, vlrTotalFacVen);
                listadoFactVen.add(cl);
            }
            
        } catch (SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoFactVen;
    }
    
    public LinkedList<CajaLogic>getOpenOrders(int id_Ape){
        LinkedList<CajaLogic>listadoPedAbiertos = new LinkedList<>();
        String SSQL = "SELECT DISTINCT fv.id_fact_v, fv.cantidad_items, fv.vlr_total_fv"
                + " FROM factura_ventas fv, aper_caja ap, pedidos p"
                + " WHERE"
                + " ap.id_caja = p.FK_aper_caja and"
                + " fv.id_fact_v = p.FK_id_fact_v and"
                + " fv.estado_fv = false and"
                + " ap.id_caja = "+id_Ape;
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                idPed = rs.getInt(1);
                cantItemPed = rs.getInt(2);
                vlrTotalPed = rs.getInt(3);
                
                CajaLogic cl = new CajaLogic(idPed, cantItemPed, vlrTotalPed);
                listadoPedAbiertos.add(cl);
            }
            
        } catch (SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoPedAbiertos;
    }
    
    public int checkOpenBox(){
        int result = 0;        
        String SSQL = "SELECT ac.id_caja, ac.saldo_ape, ac.fec_ape_caja FROM aper_caja ac WHERE NOT EXISTS (SELECT NULL FROM cierre_caja cc WHERE cc.FK_id_caja = ac.id_caja);";
        
        try{
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);

           if(rs.next()){
                this.id_Ape = rs.getInt(1);
                result = 1 + result;
                } else {
                this.id_Ape = 0;
                result = 0;
           }
            
        } catch (SQLException ex) {
            System.out.println("1. "+ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("2. "+ex.getMessage());
        }
        return result;
    }
    //CORREGIR ESTE METODO - SOLO DEBE MOSTRAR LAS CAJAS SIN REGISTROS DE CIERRE
    public LinkedList<CajaLogic> getOpenBoxes(){
        LinkedList<CajaLogic> listadoAperCaja = new LinkedList<CajaLogic>();
        String SSQL = "SELECT ac.id_caja, ac.saldo_ape, ac.fec_ape_caja FROM aper_caja ac WHERE NOT EXISTS (SELECT NULL FROM cierre_caja cc WHERE cc.FK_id_caja = ac.id_caja);";
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                id_Ape = rs.getInt(1);
                saldo_Ape = rs.getInt(2);
                fecha_Ape = rs.getDate(3).toString();
                
                CajaLogic cl = new CajaLogic(id_Ape, saldo_Ape, fecha_Ape);
                listadoAperCaja.add(cl);
            }
        } catch (SQLException ex){
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listadoAperCaja;
    }
    
    public int restoreBox(){
        int result = 0;
        String SSQL = "SELECT ac.id_caja, ac.saldo_ape, ac.fec_ape_caja FROM aper_caja ac WHERE NOT EXISTS (SELECT NULL FROM cierre_caja cc WHERE cc.FK_id_caja = ac.id_caja)";
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            Statement st = (Statement) conDB.createStatement();
            ResultSet rs = st.executeQuery(SSQL);
            
            while(rs.next()){
                result = rs.getInt(1);
                
                id_Ape = rs.getInt(1);
                saldo_Ape = rs.getInt(2);
                fecha_Ape = rs.getDate(3).toString();
            }
        } catch (SQLException ex) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int openBox(int saldoApertura){
        int result = 0;
        String SSQL = "INSERT INTO aper_caja (saldo_ape) VALUES ("+saldoApertura+")";
        
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            Statement st = conDB.createStatement();
            st.execute(SSQL);
            
            result++;
        } catch(SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean closeBox(int saldoCierre, int id){
        boolean result = false;
        
        String SSQL = "INSERT INTO cierre_caja (saldo_cierre, FK_id_caja) VALUES ("+saldoCierre+", "+id+")";
        try {
            Connection conDB = ConnectionMySQL.getInstance().getDBConnection();
            Statement st = conDB.createStatement();
            st.execute(SSQL);
            
            result = true;
            
        } catch(SQLException ex){
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CajaLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
}
