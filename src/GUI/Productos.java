package GUI;

import Logic.ProductosLogic;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo
 */
public class Productos extends javax.swing.JPanel {
    
    LinkedList<ProductosLogic> ListProductos;
    
    DefaultTableModel dfmTable;
    
    ProductosLogic p;

    public Productos() {
        initComponents();
        
        ta_DescProducto.setLineWrap(true); //Ajuste de texto en el ancho del TextArea
        
        txt_IdProducto.setEnabled(false);
        txt_NombreProducto.setEnabled(false);
        txt_PrecioProducto.setEnabled(false);
        cb_CatProductos.setEnabled(false);
        ta_DescProducto.setEnabled(false);
        
        btn_ActualizarProducto.setEnabled(false);
        btn_CrearProducto.setEnabled(false);
        
        lbl_Fec_Creacion.setText("SIN DATOS");
        
        p = ProductosLogic.getInstance();
        
        try {
            ListProductos = new LinkedList<ProductosLogic>();
            dfmTable = (DefaultTableModel) tbl_Productos.getModel();
            
            ListProductos = p.GetProductos();
            dfmTable.setNumRows(0);
            
            for(int i = 0; i < ListProductos.size(); i++){
                Object [ ] row = {
                  ListProductos.get(i).getIdProducto(),
                  ListProductos.get(i).getNombreProducto(),
                  ListProductos.get(i).getDescProducto(),
                  ListProductos.get(i).getPrecioProducto(),
                  ListProductos.get(i).getFec_Crea(),
                  ListProductos.get(i).getIdCat()
                };
                dfmTable.addRow(row);
            }
        } catch (ClassNotFoundException ex){
            System.out.println(ex.toString());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Productos = new javax.swing.JTable();
        btn_NuevoProducto = new javax.swing.JButton();
        btn_CrearProducto = new javax.swing.JButton();
        btn_CancelarOperacion = new javax.swing.JButton();
        txt_IdProducto = new javax.swing.JTextField();
        txt_NombreProducto = new javax.swing.JTextField();
        txt_PrecioProducto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_DescProducto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cb_CatProductos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        lbl_Fec_Creacion = new javax.swing.JLabel();
        btn_ActualizarProducto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_BuscarProducto = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Productos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOM. PROD", "DESC.", "PRECIO", "FEC.CRE", "CATE."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Productos.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Productos.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tbl_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Productos);
        if (tbl_Productos.getColumnModel().getColumnCount() > 0) {
            tbl_Productos.getColumnModel().getColumn(0).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(0).setPreferredWidth(8);
            tbl_Productos.getColumnModel().getColumn(1).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(1).setPreferredWidth(90);
            tbl_Productos.getColumnModel().getColumn(2).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(2).setPreferredWidth(110);
            tbl_Productos.getColumnModel().getColumn(3).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tbl_Productos.getColumnModel().getColumn(4).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(4).setPreferredWidth(40);
            tbl_Productos.getColumnModel().getColumn(5).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 81, 487, 180));

        btn_NuevoProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_NuevoProducto.setText("Nuevo Producto");
        add(btn_NuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, 40));

        btn_CrearProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_CrearProducto.setText("Crear");
        add(btn_CrearProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, 120, 40));

        btn_CancelarOperacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_CancelarOperacion.setText("Cancelar");
        btn_CancelarOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarOperacionActionPerformed(evt);
            }
        });
        add(btn_CancelarOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 120, 40));
        add(txt_IdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 70, 30));
        add(txt_NombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 310, 210, 30));
        add(txt_PrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 115, 30));

        ta_DescProducto.setColumns(20);
        ta_DescProducto.setRows(5);
        jScrollPane2.setViewportView(ta_DescProducto);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 240, 130));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Precio:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Descripcion Producto:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Id Prod:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre Prod:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, -1));

        cb_CatProductos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cb_CatProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "AREPAS", "CHULETAS", "SALCHIPAPAS", "PICADAS", "CHUZOZ Y CHORIZO", "ASADOS", "MAIZITOS", "COMBOS Y ADICIONALES" }));
        add(cb_CatProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 150, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Categoria:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 526, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fecha Creacion:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        lbl_Fec_Creacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_Fec_Creacion.setText("jLabel7");
        add(lbl_Fec_Creacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        btn_ActualizarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_ActualizarProducto.setText("Actualizar");
        btn_ActualizarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarProductoActionPerformed(evt);
            }
        });
        add(btn_ActualizarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 116, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Buscar Producto:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        txt_BuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarProductoKeyReleased(evt);
            }
        });
        add(txt_BuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 380, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_BuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarProductoKeyReleased
        p.productFilter(txt_BuscarProducto.getText(), tbl_Productos);
    }//GEN-LAST:event_txt_BuscarProductoKeyReleased

    private void tbl_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProductosMouseClicked
        int rowSelected;
        
        if(evt.getClickCount() == 2){
            if(tbl_Productos.getSelectedRow() != -1){
                rowSelected = tbl_Productos.rowAtPoint(evt.getPoint());
                
                JOptionPane.showMessageDialog(null, "Se procedera a actualizar el producto seleccionado", "Actualizacion Producto", JOptionPane.INFORMATION_MESSAGE);
                
                btn_ActualizarProducto.setEnabled(true);
                btn_NuevoProducto.setEnabled(false);
                
                txt_NombreProducto.setEnabled(true);
                txt_PrecioProducto.setEnabled(true);
                cb_CatProductos.setEnabled(true);
                ta_DescProducto.setEnabled(true);
                
                txt_IdProducto.setText(tbl_Productos.getValueAt(rowSelected, 0).toString());
                txt_NombreProducto.setText(tbl_Productos.getValueAt(rowSelected, 1).toString());
                ta_DescProducto.setText(tbl_Productos.getValueAt(rowSelected, 2).toString());
                txt_PrecioProducto.setText(tbl_Productos.getValueAt(rowSelected, 3).toString());
                lbl_Fec_Creacion.setText(tbl_Productos.getValueAt(rowSelected, 4).toString());
                cb_CatProductos.setSelectedIndex((Integer) tbl_Productos.getValueAt(rowSelected, 5));
            }
        }
    }//GEN-LAST:event_tbl_ProductosMouseClicked

    private void btn_CancelarOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarOperacionActionPerformed
        
        JOptionPane.showMessageDialog(null, "Operacion Cancelada", "Actualizacion Producto", JOptionPane.INFORMATION_MESSAGE);
        
        txt_BuscarProducto.setText("");
        txt_IdProducto.setText("");
        txt_NombreProducto.setText("");
        txt_PrecioProducto.setText("");
        cb_CatProductos.setSelectedIndex(0);
        ta_DescProducto.setText("");
        
        lbl_Fec_Creacion.setText("SIN DATOS");
        
        txt_IdProducto.setEnabled(false);
        txt_NombreProducto.setEnabled(false);
        txt_PrecioProducto.setEnabled(false);
        cb_CatProductos.setEnabled(false);
        ta_DescProducto.setEnabled(false);
        tbl_Productos.setEnabled(true);
        
        btn_NuevoProducto.setEnabled(true);
        btn_ActualizarProducto.setEnabled(false);
        btn_CrearProducto.setEnabled(false);
        
        txt_BuscarProducto.requestFocus();
        
    }//GEN-LAST:event_btn_CancelarOperacionActionPerformed

    private void btn_ActualizarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarProductoActionPerformed
        
        if(txt_NombreProducto.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "El campo NOMBRE PRODUCTO es obligatorio", "Actualizacion Producto", JOptionPane.ERROR_MESSAGE);
            txt_NombreProducto.requestFocus();
        } else {
            if(txt_PrecioProducto.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "El campo PRECIO PRODUCTO es obligatorio", "Actualizacion Producto", JOptionPane.ERROR_MESSAGE);
                txt_PrecioProducto.requestFocus();
            } else {
                if(cb_CatProductos.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar una CATEGORIA de PRODUCTO. Es obligatorio", "Actualizacion Producto", JOptionPane.ERROR_MESSAGE);
                    cb_CatProductos.requestFocus();
                } else {
                    p.updateProduct(Integer.parseInt(txt_IdProducto.getText()), txt_NombreProducto.getText(), ta_DescProducto.getText(), Integer.parseInt(txt_PrecioProducto.getText()), cb_CatProductos.getSelectedIndex());
                    JOptionPane.showMessageDialog(null, "Producto Actualizado Exitosamente", "Actualizacion Producto", JOptionPane.INFORMATION_MESSAGE);
                    
                    txt_IdProducto.setText("");
                    txt_NombreProducto.setText("");
                    txt_PrecioProducto.setText("");
                    cb_CatProductos.setSelectedIndex(0);
                    ta_DescProducto.setText("");                    
                    
                    try {
                        ListProductos = new LinkedList<ProductosLogic>();
                        dfmTable = (DefaultTableModel) tbl_Productos.getModel();

                        ListProductos = p.GetProductos();
                        dfmTable.setNumRows(0);

                        for(int i = 0; i < ListProductos.size(); i++){
                            Object [ ] row = {
                              ListProductos.get(i).getIdProducto(),
                              ListProductos.get(i).getNombreProducto(),
                              ListProductos.get(i).getDescProducto(),
                              ListProductos.get(i).getPrecioProducto(),
                              ListProductos.get(i).getFec_Crea(),
                              ListProductos.get(i).getIdCat()
                            };
                            dfmTable.addRow(row);
                        }
                    } catch (ClassNotFoundException ex){
                        System.out.println(ex.toString());
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_ActualizarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ActualizarProducto;
    private javax.swing.JButton btn_CancelarOperacion;
    private javax.swing.JButton btn_CrearProducto;
    private javax.swing.JButton btn_NuevoProducto;
    private javax.swing.JComboBox<String> cb_CatProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Fec_Creacion;
    private javax.swing.JTextArea ta_DescProducto;
    private javax.swing.JTable tbl_Productos;
    private javax.swing.JTextField txt_BuscarProducto;
    private javax.swing.JTextField txt_IdProducto;
    private javax.swing.JTextField txt_NombreProducto;
    private javax.swing.JTextField txt_PrecioProducto;
    // End of variables declaration//GEN-END:variables
}
