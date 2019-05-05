package GUI;

/**
 *
 * @author Camilo
 */
public class Productos extends javax.swing.JPanel {

    public Productos() {
        initComponents();
        
        ta_DescProducto.setLineWrap(true);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_Productos.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 31, 487, 230));

        btn_NuevoProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_NuevoProducto.setText("Nuevo Producto");
        add(btn_NuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, 40));

        btn_CrearProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_CrearProducto.setText("Crear");
        add(btn_CrearProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 540, 120, 40));

        btn_CancelarOperacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_CancelarOperacion.setText("Cancelar");
        add(btn_CancelarOperacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 120, 40));
        add(txt_IdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 70, 30));
        add(txt_NombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 189, 30));
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
        cb_CatProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
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
        add(btn_ActualizarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 116, 40));
    }// </editor-fold>//GEN-END:initComponents


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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Fec_Creacion;
    private javax.swing.JTextArea ta_DescProducto;
    private javax.swing.JTable tbl_Productos;
    private javax.swing.JTextField txt_IdProducto;
    private javax.swing.JTextField txt_NombreProducto;
    private javax.swing.JTextField txt_PrecioProducto;
    // End of variables declaration//GEN-END:variables
}
