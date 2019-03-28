package Logic;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo
 */
public class Utilidades {
    
    private static Utilidades utilidades;
    
    private Utilidades(){
        
    }
    
    public static Utilidades getInstance(){
        if(utilidades == null){
            utilidades = new Utilidades();
        }
        return utilidades;
    }
    
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
    
}
