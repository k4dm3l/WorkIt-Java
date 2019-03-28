package GUI;

import Logic.CajaLogic;
import Logic.ClientesLogic;
import Logic.LoginLogic;
import Logic.PedidosLogic;
import Logic.Utilidades;
import Persistencia.ConnectionMySQL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo
 */
public class Pedidos extends javax.swing.JPanel {
    DecimalFormat df;
    
    DefaultTableModel dfmTablePedido;
    DefaultTableModel dfmTable;
    
    LinkedList<PedidosLogic> ListProductos;
    LinkedList<PedidosLogic>ListPedido;
    
    ConnectionMySQL cms;
    ClientesLogic cl;
    CajaLogic clg;
    Utilidades ul;
    PedidosLogic p;
    LoginLogic log;
    
    int idCliente;
    int totalPedido = 0;
    int rowPedidoSelected = 0;
    int vlrResta;
    
    public Pedidos() {
        initComponents();
        tbl_Pedido.setShowGrid(false);
        tbl_Productos.setShowGrid(false);
        
        lbl_CantItems.setText("0");
        lbl_TotalPedido.setText("0");
        lbl_nomCliente.setText("SIN DATOS");
        
        clg = CajaLogic.getInstance();
        clg.setId_Ape(0);
        
        df = new DecimalFormat("#,###");
        
        try {
                p = new PedidosLogic();
                ListProductos = new LinkedList<PedidosLogic>();
                dfmTable = (DefaultTableModel) tbl_Productos.getModel();
        
                ListProductos = p.GetProductos();
                dfmTable.setNumRows(0);
                
                for(int i = 0; i < ListProductos.size(); i++){
                    Object [ ] row = {
                        ListProductos.get(i).getIdProducto(), 
                        ListProductos.get(i).getNombreProducto(), 
                        ListProductos.get(i).getPrecioProducto()
                    };
                    dfmTable.addRow(row);
                }
             } catch (ClassNotFoundException ex) {
                System.out.println(ex.toString());
            }     
               
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuOpciones = new javax.swing.JPopupMenu();
        mnuOp_EliminarItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Productos = new javax.swing.JTable();
        txt_Buscar = new javax.swing.JTextField();
        btn_BuscarProducto = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Pedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_CantItems = new javax.swing.JLabel();
        btn_crearPedido = new javax.swing.JButton();
        btn_CancelarPedido = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbl_TotalPedido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_BuscarId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbl_nomCliente = new javax.swing.JLabel();
        btn_BuscarCliente = new javax.swing.JButton();

        mnuOp_EliminarItem.setText("Eliminar Item");
        mnuOp_EliminarItem.setToolTipText("");
        mnuOp_EliminarItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuOp_EliminarItemMouseClicked(evt);
            }
        });
        mnuOp_EliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuOp_EliminarItemActionPerformed(evt);
            }
        });
        menuOpciones.add(mnuOp_EliminarItem);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(540, 570));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        tbl_Productos.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tbl_Productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Producto", "Precio U."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Productos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_Productos.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tbl_Productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ProductosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_ProductosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Productos);
        if (tbl_Productos.getColumnModel().getColumnCount() > 0) {
            tbl_Productos.getColumnModel().getColumn(0).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_Productos.getColumnModel().getColumn(1).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(1).setPreferredWidth(180);
            tbl_Productos.getColumnModel().getColumn(2).setResizable(false);
            tbl_Productos.getColumnModel().getColumn(2).setPreferredWidth(60);
        }

        txt_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_BuscarKeyTyped(evt);
            }
        });

        btn_BuscarProducto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_BuscarProducto.setText("Buscar");
        btn_BuscarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_BuscarProductoMouseClicked(evt);
            }
        });

        tbl_Pedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Producto", "Precio U.", "Cantidad", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Pedido.setComponentPopupMenu(menuOpciones);
        tbl_Pedido.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tbl_Pedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_PedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Pedido);
        if (tbl_Pedido.getColumnModel().getColumnCount() > 0) {
            tbl_Pedido.getColumnModel().getColumn(0).setResizable(false);
            tbl_Pedido.getColumnModel().getColumn(0).setPreferredWidth(15);
            tbl_Pedido.getColumnModel().getColumn(1).setResizable(false);
            tbl_Pedido.getColumnModel().getColumn(1).setPreferredWidth(160);
            tbl_Pedido.getColumnModel().getColumn(2).setResizable(false);
            tbl_Pedido.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbl_Pedido.getColumnModel().getColumn(3).setResizable(false);
            tbl_Pedido.getColumnModel().getColumn(3).setPreferredWidth(40);
            tbl_Pedido.getColumnModel().getColumn(4).setResizable(false);
            tbl_Pedido.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Id Cliente:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Items:");

        lbl_CantItems.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_CantItems.setText("jLabel4");

        btn_crearPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_crearPedido.setText("Crear Pedido");
        btn_crearPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearPedidoActionPerformed(evt);
            }
        });

        btn_CancelarPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_CancelarPedido.setText("Cancelar Pedido");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Total $:");

        lbl_TotalPedido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_TotalPedido.setText("jLabel4");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Buscar Producto");

        txt_BuscarId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_BuscarIdKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_BuscarIdKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Cliente:");

        lbl_nomCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_nomCliente.setText("jLabel6");

        btn_BuscarCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_BuscarCliente.setText("Buscar Cliente");
        btn_BuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_BuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btn_BuscarCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_CancelarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(btn_crearPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_TotalPedido))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_CantItems)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_nomCliente)
                                    .addComponent(jLabel4))
                                .addGap(158, 158, 158)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_BuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_crearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_BuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(btn_CancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_BuscarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_CantItems)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nomCliente)
                    .addComponent(jLabel5)
                    .addComponent(lbl_TotalPedido))
                .addGap(21, 21, 21))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearPedidoActionPerformed
        // TODO add your handling code here:
        int idAper;
        clg = CajaLogic.getInstance();
        
        idAper = clg.getId_Ape();
        
        if(tbl_Pedido.getRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "No se ha agregado ningun item para este pedido", "Error Creacion Pedido", JOptionPane.ERROR_MESSAGE);
        } else {
                if(idCliente <= 0){
                    JOptionPane.showMessageDialog(null, "Debes asignar un cliente existente", "Error Creacion Pedido", JOptionPane.ERROR_MESSAGE);
                    txt_BuscarId.requestFocus();
                } else {
                    if(idAper < 1){
                        JOptionPane.showMessageDialog(null, "No existe caja abierta. Proceda a abrir una caja", "Error Creacion Pedido", JOptionPane.ERROR_MESSAGE);
                    } else {
                    int idFact = 0;
                    p.createOrderBill(tbl_Pedido.getRowCount(), totalPedido);
                    //Aqui se debe capturar el ID de la ultima factura generada
                    idFact = p.getLastBill();
                    /*
                        Aqui se realiza la toma de los elementos a insertar dentro de PEDIDOS y dentro del ciclo FOR
                        Se debe realizar el respectivo INSERT para cada uno de los items
                    */
                    int idprod = 0;
                    int precioUnitario = 0;
                    int cantprod = 0;
                    int totalProd = 0;
                    log = LoginLogic.getInstance();
                    
                    for(int i = 0; i < tbl_Pedido.getRowCount(); i++){
                     idprod  = (Integer) tbl_Pedido.getValueAt(i, 0);
                     precioUnitario = (Integer) tbl_Pedido.getValueAt(i, 2);
                     cantprod = (Integer) tbl_Pedido.getValueAt(i, 3);
                     totalProd = (Integer) tbl_Pedido.getValueAt(i, 4);
                     /*       
                     System.out.print("\nINSERT \n"
                        + "Pedido: "+idFact+"\n"
                        + "Id Factura: "+idFact+"\n"
                        + "Id Producto: "+idprod+"\n"
                        + "Doc User:"+log.getUserID()+" \n"//Requiere DOC USUARIO
                        + "Doc Client:"+cl.getId_Cliente()+" \n"
                        + "Id AperCaja: "+clg.getId_Ape()+"\n"
                        + "Precio Unitario Producto: "+precioUnitario+"\n"
                        + "Cantidad Producto: "+cantprod+"\n"
                        + "Total Producto: "+totalProd+"\n"
                      );
                     */
                     p.createOrder(idFact, idFact, idprod, log.getUserID(), cl.getId_Cliente(), clg.getId_Ape(), precioUnitario, cantprod, totalProd);
                     
                    }
                    //Aqui codigo para imprimir RECIBO DE PEDIDO
                    System.out.println("PENDIENTE IMPRIMIR RECIBO DE PEDIDO");
                    
                    ul = Utilidades.getInstance();
                    
                    idCliente = 0;
                    totalPedido = 0;
                    
                    ul.cleanTable(tbl_Pedido);
                    lbl_TotalPedido.setText(""+totalPedido);
                    lbl_CantItems.setText(""+tbl_Pedido.getRowCount());
                    lbl_nomCliente.setText("SIN DATOS");
                    
                    lbl_TotalPedido.setText(df.format(Integer.valueOf(lbl_TotalPedido.getText().replace(".", "").replace(",", ""))));
                    
                    JOptionPane.showMessageDialog(null, "Pedido creado exitosamente", "Creacion Pedido", JOptionPane.INFORMATION_MESSAGE);
                    
                    }
                }
        }
    }//GEN-LAST:event_btn_crearPedidoActionPerformed

    private void txt_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarKeyReleased
        // TODO add your handling code here:
        p.productFilter(txt_Buscar.getText(), tbl_Productos);
    }//GEN-LAST:event_txt_BuscarKeyReleased

    private void txt_BuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarKeyTyped
        // TODO add your handling code here:
        char keyChar = evt.getKeyChar();
        if(Character.isLowerCase(keyChar)){
            evt.setKeyChar(Character.toUpperCase(keyChar));
        }
    }//GEN-LAST:event_txt_BuscarKeyTyped

    private void btn_BuscarProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BuscarProductoMouseClicked
        // TODO add your handling code here:
        p.productFilter(txt_Buscar.getText(), tbl_Productos);
        dfmTable = (DefaultTableModel) tbl_Productos.getModel();
    }//GEN-LAST:event_btn_BuscarProductoMouseClicked

    private void tbl_ProductosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProductosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_ProductosMousePressed

    private void mnuOp_EliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuOp_EliminarItemActionPerformed
        // TODO add your handling code here:;
            dfmTablePedido = (DefaultTableModel) this.tbl_Pedido.getModel();
            dfmTablePedido.removeRow(this.tbl_Pedido.getSelectedRow());
            
            if(tbl_Pedido.getRowCount() == 0){
                totalPedido = 0;
                lbl_TotalPedido.setText(""+totalPedido);
                
                lbl_TotalPedido.setText(df.format(Integer.valueOf(lbl_TotalPedido.getText().replace(".", "").replace(",", ""))));
            } else {
                totalPedido = totalPedido - vlrResta;
                lbl_TotalPedido.setText(""+totalPedido);
                
                lbl_TotalPedido.setText(df.format(Integer.valueOf(lbl_TotalPedido.getText().replace(".", "").replace(",", ""))));
            }
            
            lbl_CantItems.setText(""+tbl_Pedido.getRowCount());
    }//GEN-LAST:event_mnuOp_EliminarItemActionPerformed

    private void tbl_ProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProductosMouseClicked
        // TODO add your handling code here:
        boolean check_data = false;
        int rowSelected;
        
        int id = 0;
        String nom_prod = "";
        int vlr_U = 0;
        int cantidad = 0;
        int total = 0;
        
        if(evt.getClickCount() == 2){
            if(tbl_Productos.getSelectedRow() != -1){
                
                while(check_data == false){
                    check_data = true;
                    String aux = JOptionPane.showInputDialog("Ingresa la cantidad de este producto");
                    try{
                        rowSelected = tbl_Productos.rowAtPoint(evt.getPoint());
                        
                        id = (Integer) tbl_Productos.getValueAt(rowSelected, 0);
                        nom_prod = (String) tbl_Productos.getValueAt(rowSelected, 1);
                        vlr_U = (Integer) tbl_Productos.getValueAt(rowSelected, 2);
                        
                        cantidad = Integer.parseInt(aux);
                        total = cantidad * vlr_U;
                        
                    } catch(Exception e){
                        JOptionPane.showMessageDialog(null, "El valor de cantidad debe ser numerico", "Error en datos", JOptionPane.ERROR_MESSAGE);
                        check_data = false;
                        continue;
                    }
                    if(cantidad <= 0){
                        JOptionPane.showMessageDialog(null, "El valor de cantidad debe MAYOR a 0 (cero)", "Error en datos", JOptionPane.ERROR_MESSAGE);
                        check_data = false;
                    }
                }
                
                dfmTablePedido = (DefaultTableModel) tbl_Pedido.getModel(); 
                
                Object [] fila = new Object [5];
                    fila[0] = id;
                    fila[1] = nom_prod;
                    fila[2] = vlr_U;
                    fila[3] = cantidad;
                    fila[4] = total;
                
                dfmTablePedido.addRow(fila);
                
                lbl_CantItems.setText(""+tbl_Pedido.getRowCount());
                totalPedido = totalPedido + ((Integer)dfmTablePedido.getValueAt(tbl_Pedido.getRowCount()-1, 4));
                lbl_TotalPedido.setText(""+totalPedido);
                
                lbl_TotalPedido.setText(df.format(Integer.valueOf(lbl_TotalPedido.getText().replace(".", "").replace(",", ""))));
                
        } else {
            System.out.println("Error selecciona fila");
        }
        }
    }//GEN-LAST:event_tbl_ProductosMouseClicked

    private void mnuOp_EliminarItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuOp_EliminarItemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_mnuOp_EliminarItemMouseClicked

    private void tbl_PedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_PedidoMouseClicked
        // TODO add your handling code here:
        rowPedidoSelected = tbl_Pedido.rowAtPoint(evt.getPoint());
        vlrResta = (Integer)(tbl_Pedido.getValueAt(rowPedidoSelected, 4));
    }//GEN-LAST:event_tbl_PedidoMouseClicked

    private void btn_BuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarClienteActionPerformed
        // TODO add your handling code here:
        
        if(txt_BuscarId.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un numero de identificacion del cliente", "Error datos", JOptionPane.ERROR_MESSAGE);
        } else {
            cl = ClientesLogic.getInstance();
            cl.searchClient(Integer.parseInt(txt_BuscarId.getText()));
            
            if(cl.getId_Cliente() == 0 || cl.getNomCliente() == null){
                JOptionPane.showMessageDialog(null, "El cliente no existe", "Error datos", JOptionPane.ERROR_MESSAGE);
                txt_BuscarId.requestFocus();
                txt_BuscarId.setText("");
                
                lbl_nomCliente.setText("SIN DATOS");
                idCliente = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente Encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                txt_BuscarId.requestFocus();
                txt_BuscarId.setText("");
                
                lbl_nomCliente.setText(cl.getNomCliente());
                idCliente = cl.getId_Cliente();
            }
        }
    }//GEN-LAST:event_btn_BuscarClienteActionPerformed

    private void txt_BuscarIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarIdKeyTyped
        // TODO add your handling code here:
        char checkTyped = evt.getKeyChar();
        
        if(checkTyped < '0' || checkTyped > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_BuscarIdKeyTyped

    private void txt_BuscarIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarIdKeyPressed
        // TODO add your handling code here:
        if(evt.getExtendedKeyCode() == 10){
            cl = ClientesLogic.getInstance();
            cl.searchClient(Integer.parseInt(txt_BuscarId.getText()));
            
            if(cl.getId_Cliente() == 0 || cl.getNomCliente() == null){
                JOptionPane.showMessageDialog(null, "El cliente no existe", "Error datos", JOptionPane.ERROR_MESSAGE);
                txt_BuscarId.requestFocus();
                txt_BuscarId.setText("");
                
                lbl_nomCliente.setText("SIN DATOS");
                idCliente = 0;
            } else {
                JOptionPane.showMessageDialog(null, "Cliente Encontrado", "Exito", JOptionPane.INFORMATION_MESSAGE);
                txt_BuscarId.requestFocus();
                txt_BuscarId.setText("");
                
                lbl_nomCliente.setText(cl.getNomCliente());
                idCliente = cl.getId_Cliente();
            }
        }
    }//GEN-LAST:event_txt_BuscarIdKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_BuscarCliente;
    private javax.swing.JButton btn_BuscarProducto;
    private javax.swing.JButton btn_CancelarPedido;
    private javax.swing.JButton btn_crearPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_CantItems;
    private javax.swing.JLabel lbl_TotalPedido;
    private javax.swing.JLabel lbl_nomCliente;
    private javax.swing.JPopupMenu menuOpciones;
    private javax.swing.JMenuItem mnuOp_EliminarItem;
    private javax.swing.JTable tbl_Pedido;
    private javax.swing.JTable tbl_Productos;
    private javax.swing.JTextField txt_Buscar;
    private javax.swing.JTextField txt_BuscarId;
    // End of variables declaration//GEN-END:variables
}
