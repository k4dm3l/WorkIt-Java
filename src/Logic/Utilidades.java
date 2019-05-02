package Logic;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo
 */
public class Utilidades {
    
    private static String VERSION_APP = "1.8.19";
    private static Utilidades utilidades;
    
    private Utilidades(){
        
    }
    
    public String getVersionApp(){
        return this.VERSION_APP;
    }
    
    public static Utilidades getInstance(){
        if(utilidades == null){
            utilidades = new Utilidades();
        }
        return utilidades;
    }
    
    //LIMPIAR REGISTRO DE TABLA
    public void cleanRegTable(JTable t, int indexT){
        DefaultTableModel dbt = (DefaultTableModel) t.getModel();
        for(int i = 0; i < dbt.getRowCount(); i++){
            for(int j = 0; j < dbt.getColumnCount(); j++){
                if(dbt.getValueAt(i, j).equals(indexT)){
                    dbt.removeRow(i);
                    break;
                }
            }
        }
    }
    
    //LIMPIAR TABLA
    public void cleanTable(JTable t){
        try{
            DefaultTableModel dbt = (DefaultTableModel) t.getModel();
            int filas = dbt.getRowCount();
            for(int i = 0; filas > i; i++){
                dbt.removeRow(0);
            }
        } catch (Exception e){
            System.out.println("Error Metodo");
        }
    }
    
    public String getSysDate(){
        String fecha;
        
        Date objD = new Date( );
        SimpleDateFormat smp = new SimpleDateFormat("dd/MM/yyyy");
        fecha = smp.format(objD);
        
        return fecha;
    }
    
}
