package GUI;

import Logic.CajaLogic;
import Logic.FacturacionLogic;
import Logic.Utilidades;
import java.text.DecimalFormat;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo
 */
public class Facturacion extends javax.swing.JPanel {
    
    DecimalFormat df;
    
    CajaLogic cl;
    FacturacionLogic fl;
    Utilidades ul;
    
    LinkedList<FacturacionLogic> ListFact;
    
    DefaultTableModel dfmTableFacVen;
    int total;
    
    public Facturacion() {
        initComponents();
        
        lbl_IdCliente.setText("SIN DATOS");
        lbl_IdPedido.setText("SIN DATOS");
        lbl_TotalVenta.setText("0");
        lbl_CantItems.setText("SIN DATOS");
        lbl_Cambio.setText("0");
        lbl_NombreCliente.setText("SIN DATOS");
        
        txt_DineroRecibido.setEnabled(false);
        btn_Facturar.setEnabled(false);
        
        df = new DecimalFormat("#,###");
        
        cl = CajaLogic.getInstance();
        fl = FacturacionLogic.getInstance();
        ul = Utilidades.getInstance();
        
        ListFact = new LinkedList<FacturacionLogic>();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_ConsultarPedido = new javax.swing.JTextField();
        btn_ConsultarPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ItemsPedido = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_IdPedido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_CantItems = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_TotalVenta = new javax.swing.JLabel();
        btn_Facturar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbl_NombreCliente = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_IdCliente = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txt_DineroRecibido = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_Cambio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        txt_ConsultarPedido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ConsultarPedidoKeyPressed(evt);
            }
        });

        btn_ConsultarPedido.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_ConsultarPedido.setText("Consultar Pedido");
        btn_ConsultarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultarPedidoActionPerformed(evt);
            }
        });

        tbl_ItemsPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Producto", "Prec. Unit.", "Cant.", "Sub. Total."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_ItemsPedido);
        if (tbl_ItemsPedido.getColumnModel().getColumnCount() > 0) {
            tbl_ItemsPedido.getColumnModel().getColumn(0).setResizable(false);
            tbl_ItemsPedido.getColumnModel().getColumn(0).setPreferredWidth(30);
            tbl_ItemsPedido.getColumnModel().getColumn(1).setResizable(false);
            tbl_ItemsPedido.getColumnModel().getColumn(1).setPreferredWidth(180);
            tbl_ItemsPedido.getColumnModel().getColumn(2).setResizable(false);
            tbl_ItemsPedido.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbl_ItemsPedido.getColumnModel().getColumn(3).setResizable(false);
            tbl_ItemsPedido.getColumnModel().getColumn(3).setPreferredWidth(30);
            tbl_ItemsPedido.getColumnModel().getColumn(4).setResizable(false);
            tbl_ItemsPedido.getColumnModel().getColumn(4).setPreferredWidth(40);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Pedido No:");

        lbl_IdPedido.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_IdPedido.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Items:");

        lbl_CantItems.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_CantItems.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Total: $");

        lbl_TotalVenta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_TotalVenta.setText("jLabel6");

        btn_Facturar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Facturar.setText("Facturar");
        btn_Facturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FacturarActionPerformed(evt);
            }
        });

        btn_Cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_Cancelar.setText("Cancelar");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Cliente:");

        lbl_NombreCliente.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_NombreCliente.setText("jLabel8");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Id Cliente:");

        lbl_IdCliente.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lbl_IdCliente.setText("jLabel10");

        txt_DineroRecibido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txt_DineroRecibido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_DineroRecibidoFocusLost(evt);
            }
        });
        txt_DineroRecibido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_DineroRecibidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_DineroRecibidoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_DineroRecibidoKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Dinero Recibido:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Devolucion: $");

        lbl_Cambio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_Cambio.setText("jLabel6");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Pedido:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(txt_ConsultarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_ConsultarPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_NombreCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_IdCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_IdPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_CantItems)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(4, 4, 4)
                        .addComponent(lbl_TotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(txt_DineroRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_Cambio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btn_Facturar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ConsultarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ConsultarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbl_TotalVenta))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_DineroRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lbl_IdPedido))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbl_CantItems))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbl_IdCliente))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbl_NombreCliente)
                    .addComponent(jLabel4)
                    .addComponent(lbl_Cambio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Facturar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txt_DineroRecibidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DineroRecibidoKeyTyped
        // TODO add your handling code here:
        char checkTyped = evt.getKeyChar();
        
        if(checkTyped < '0' || checkTyped > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_DineroRecibidoKeyTyped

    private void btn_ConsultarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultarPedidoActionPerformed
        // TODO add your handling code here:
        total = 0;
        
        if(txt_ConsultarPedido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo consulta pedido se encuentra vacio", "Error Facturacion", JOptionPane.ERROR_MESSAGE);
            txt_ConsultarPedido.requestFocus();
        } else {
            if(cl.getId_Ape() == 0){//(3 != 3)
                JOptionPane.showMessageDialog(null, "En este momento el sistema no se registra ninguna caja abierta", "Error Facturacion", JOptionPane.ERROR_MESSAGE);
                txt_ConsultarPedido.setText("");
                txt_ConsultarPedido.requestFocus();
            } else {
                int pedido = Integer.parseInt(txt_ConsultarPedido.getText());
                if(fl.orderIsOpen(cl.getId_Ape(), pedido) == 0){
                    JOptionPane.showMessageDialog(null, "El pedido que intenta consultar no existe, se encuentra facturado o pertenece a otra apertura de caja diferente. APERTURA DE CAJA: "+cl.getId_Ape(), "Error Facturacion", JOptionPane.ERROR_MESSAGE);
                    txt_ConsultarPedido.setText("");
                    txt_ConsultarPedido.requestFocus();
                } else {
                    dfmTableFacVen = (DefaultTableModel) tbl_ItemsPedido.getModel();
                    ListFact = fl.getOrder(cl.getId_Ape(), pedido);
                    dfmTableFacVen.setNumRows(0);

                    for(int i = 0; i < ListFact.size(); i++){
                        Object [ ] row = {
                            ListFact.get(i).getIdProd(),
                            ListFact.get(i).getNomProducto(),
                            ListFact.get(i).getPrecioProdUnd(),
                            ListFact.get(i).getCantProducto(),
                            ListFact.get(i).getVlrTotalProd()
                        };
                        dfmTableFacVen.addRow(row);
                    }

                    for(int i = 0; i < tbl_ItemsPedido.getRowCount(); i++){
                        total += (Integer)tbl_ItemsPedido.getValueAt(i, 4);
                    }

                    lbl_TotalVenta.setText(""+total);
                    lbl_IdPedido.setText(txt_ConsultarPedido.getText());
                    lbl_CantItems.setText(""+tbl_ItemsPedido.getRowCount());
                    lbl_IdCliente.setText(""+fl.getClient(9, 3).getIdCliente());
                    lbl_NombreCliente.setText(fl.getClient(9, 3).getNomCliente());

                    txt_ConsultarPedido.setText("");
                    txt_DineroRecibido.setEnabled(true);
                    btn_Facturar.setEnabled(true);
                    lbl_TotalVenta.setText(df.format(Integer.valueOf(lbl_TotalVenta.getText().replace(".", "").replace(",", ""))));

                    txt_ConsultarPedido.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btn_ConsultarPedidoActionPerformed

    private void txt_DineroRecibidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DineroRecibidoKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_DineroRecibidoKeyReleased

    private void txt_DineroRecibidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DineroRecibidoKeyPressed
        // TODO add your handling code here:
        if(evt.getExtendedKeyCode() == 10){
            if(txt_DineroRecibido.getText().equals("")){
                txt_DineroRecibido.setText("0");
            }
            int dev = Integer.parseInt(txt_DineroRecibido.getText()) - total;
            lbl_Cambio.setText(""+dev);
            lbl_Cambio.setText(df.format(Integer.valueOf(lbl_Cambio.getText().replace(".", "").replace(",", ""))));
        } 
    }//GEN-LAST:event_txt_DineroRecibidoKeyPressed

    private void txt_DineroRecibidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_DineroRecibidoFocusLost
        // TODO add your handling code here:
        if(txt_DineroRecibido.getText().equals("")){
            txt_DineroRecibido.setText("0");
            
            int dev = Integer.parseInt(txt_DineroRecibido.getText()) - total;
            lbl_Cambio.setText(""+dev);
            lbl_Cambio.setText(df.format(Integer.valueOf(lbl_Cambio.getText().replace(".", "").replace(",", ""))));
        } else {
            int dev = Integer.parseInt(txt_DineroRecibido.getText()) - total;
            lbl_Cambio.setText(""+dev);
            lbl_Cambio.setText(df.format(Integer.valueOf(lbl_Cambio.getText().replace(".", "").replace(",", ""))));
        }
    }//GEN-LAST:event_txt_DineroRecibidoFocusLost

    private void txt_ConsultarPedidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ConsultarPedidoKeyPressed
        // TODO add your handling code here:
        total = 0;
        
        if(evt.getExtendedKeyCode() == 10){
        
        if(txt_ConsultarPedido.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo consulta pedido se encuentra vacio", "Error Facturacion", JOptionPane.ERROR_MESSAGE);
            txt_ConsultarPedido.requestFocus();
        } else {
            if(cl.getId_Ape() == 0){
                JOptionPane.showMessageDialog(null, "En este momento el sistema no se registra ninguna caja abierta", "Error Facturacion", JOptionPane.ERROR_MESSAGE);
                txt_ConsultarPedido.setText("");
                txt_ConsultarPedido.requestFocus();
            } else {
                int pedido = Integer.parseInt(txt_ConsultarPedido.getText());
                if(fl.orderIsOpen(cl.getId_Ape(), pedido) == 0){
                    JOptionPane.showMessageDialog(null, "El pedido que intenta consultar no existe, se encuentra facturado o pertenece a otra apertura de caja diferente. APERTURA DE CAJA: "+cl.getId_Ape(), "Error Facturacion", JOptionPane.ERROR_MESSAGE);
                    txt_ConsultarPedido.setText("");
                    txt_ConsultarPedido.requestFocus();
                } else {
                    dfmTableFacVen = (DefaultTableModel) tbl_ItemsPedido.getModel();
                    ListFact = fl.getOrder(cl.getId_Ape(), pedido);
                    dfmTableFacVen.setNumRows(0);

                    for(int i = 0; i < ListFact.size(); i++){
                        Object [ ] row = {
                            ListFact.get(i).getIdProd(),
                            ListFact.get(i).getNomProducto(),
                            ListFact.get(i).getPrecioProdUnd(),
                            ListFact.get(i).getCantProducto(),
                            ListFact.get(i).getVlrTotalProd()
                        };
                        dfmTableFacVen.addRow(row);
                    }

                    for(int i = 0; i < tbl_ItemsPedido.getRowCount(); i++){
                        total += (Integer)tbl_ItemsPedido.getValueAt(i, 4);
                    }

                    lbl_TotalVenta.setText(""+total);
                    lbl_IdPedido.setText(txt_ConsultarPedido.getText());
                    lbl_CantItems.setText(""+tbl_ItemsPedido.getRowCount());
                    lbl_IdCliente.setText(""+fl.getClient(9, 3).getIdCliente());
                    lbl_NombreCliente.setText(fl.getClient(9, 3).getNomCliente());

                    txt_ConsultarPedido.setText("");
                    txt_DineroRecibido.setEnabled(true);
                    btn_Facturar.setEnabled(true);
                    lbl_TotalVenta.setText(df.format(Integer.valueOf(lbl_TotalVenta.getText().replace(".", "").replace(",", ""))));

                    txt_ConsultarPedido.requestFocus();
                }
            }
        }
        }
    }//GEN-LAST:event_txt_ConsultarPedidoKeyPressed

    private void btn_FacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FacturarActionPerformed
        // TODO add your handling code here:
        if(tbl_ItemsPedido.getRowCount() < 1){
            JOptionPane.showMessageDialog(null, "Debe consultar un pedido", "Error Facturacion", JOptionPane.ERROR_MESSAGE);
        }
        if(txt_DineroRecibido.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El campo DINERO RECIBIDO NO PUEDE estar VACIO.", "Error Facturacion", JOptionPane.ERROR_MESSAGE);
            txt_DineroRecibido.requestFocus();
        } else {
            int dineroRecibido = Integer.parseInt(txt_DineroRecibido.getText());
            
            if(dineroRecibido < total){
                JOptionPane.showMessageDialog(null, "El dinero ingresado como recibido es MENOR al valor del PEDIDO. Verifique por favor", "Error Facturacion", JOptionPane.ERROR_MESSAGE);
                txt_DineroRecibido.requestFocus();
            } else {
                fl.payBill(Integer.parseInt(lbl_IdPedido.getText()));
                
                System.out.println("PENDIENTE IMPRIMIR FACTURA DE VENTA");
                JOptionPane.showMessageDialog(null, "Pago Realizado EXITOSAMENTE \n Total: $"+total+"\n Recibido: $"+dineroRecibido+"\n Devuelta: $"+(dineroRecibido-total), "Exito Facturacion", JOptionPane.INFORMATION_MESSAGE);
                    
                    //LIMPIEZA DE TODOS LOS CAMPOS
                lbl_IdPedido.setText("SIN DATOS");
                lbl_CantItems.setText("SIN DATOS");
                lbl_IdCliente.setText("SIN DATOS");
                lbl_NombreCliente.setText("SIN DATOS");
                lbl_TotalVenta.setText("0");
                lbl_Cambio.setText("0");

                ul.cleanTable(tbl_ItemsPedido);
                total = 0;

                    //LIMPIEZA DE TODOS LOS CAMPOS
                lbl_IdPedido.setText("SIN DATOS");
                lbl_CantItems.setText("SIN DATOS");
                lbl_IdCliente.setText("SIN DATOS");
                lbl_NombreCliente.setText("SIN DATOS");
                lbl_TotalVenta.setText("0");
                lbl_Cambio.setText("0");

                ul.cleanTable(tbl_ItemsPedido);
                total = 0;
                    
                txt_DineroRecibido.setText("");
                    
                }
        }
    }//GEN-LAST:event_btn_FacturarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_ConsultarPedido;
    private javax.swing.JButton btn_Facturar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Cambio;
    private javax.swing.JLabel lbl_CantItems;
    private javax.swing.JLabel lbl_IdCliente;
    private javax.swing.JLabel lbl_IdPedido;
    private javax.swing.JLabel lbl_NombreCliente;
    private javax.swing.JLabel lbl_TotalVenta;
    private javax.swing.JTable tbl_ItemsPedido;
    private javax.swing.JTextField txt_ConsultarPedido;
    private javax.swing.JTextField txt_DineroRecibido;
    // End of variables declaration//GEN-END:variables
}
