package GUI;

import Logic.CajaLogic;
import Logic.TicketsPrint;
import Logic.Utilidades;
import java.text.DecimalFormat;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Camilo
 */
public class Caja extends javax.swing.JPanel {
    
    DecimalFormat df;
    
    CajaLogic cl;
    Utilidades ul;
    TicketsPrint tp;
    
    DefaultTableModel dfmTableAperCaja;
    DefaultTableModel dfmTablePedAbiertos;
    DefaultTableModel dfmTableFacVen;
    
    LinkedList<CajaLogic> ListAperCaja;
    LinkedList<CajaLogic> ListPedAbiertos;
    LinkedList<CajaLogic> ListFacVen;
    
    public Caja() {
        initComponents();
        
        lbl_IdApertura.setText("-");
        lbl_FecApertura.setText("-");
        lbl_SaldoApertura.setText("-");
        lbl_PedidosAbiertos.setText("-");
        lbl_VentasRealizadas.setText("-");
        lbl_TotalVentas.setText("-");
        
        txt_idRetoma.setEnabled(false);
        btn_RetomarCaja.setEnabled(false);
        
        df = new DecimalFormat("#,###");
        
        cl = CajaLogic.getInstance();
        tp = TicketsPrint.getInstance();
        
        ListAperCaja = new LinkedList<CajaLogic>();
        ListPedAbiertos = new LinkedList<CajaLogic>();
        ListFacVen = new LinkedList<CajaLogic>();
        
        dfmTableAperCaja = (DefaultTableModel) tbl_EstadosCaja.getModel();
        dfmTablePedAbiertos = (DefaultTableModel) tbl_PedidosAbiertos.getModel();
        dfmTableFacVen = (DefaultTableModel) tbl_Ventas.getModel();
        
        ListAperCaja = cl.getOpenBoxes();
        ListPedAbiertos = cl.getOpenOrders(cl.getId_Ape());
        ListFacVen = cl.getSales(cl.getId_Ape());
        
        dfmTableAperCaja.setNumRows(0);
        dfmTablePedAbiertos.setNumRows(0);
        dfmTableFacVen.setNumRows(0);
        
        for(int i = 0; i < ListAperCaja.size(); i++){            
            Object [ ] row = {
                ListAperCaja.get(i).getId_Ape(),
                ListAperCaja.get(i).getSaldo_Ape(),
                ListAperCaja.get(i).getFecha_Ape()
            };
            dfmTableAperCaja.addRow(row);
        }
        
        for(int j = 0; j < ListPedAbiertos.size(); j++){
            Object [ ] row = {
                ListPedAbiertos.get(j).getId_Ped(),
                ListPedAbiertos.get(j).getCantItems(),
                ListPedAbiertos.get(j).getMesa(),
                ListPedAbiertos.get(j).getVlrTotal()
            };
            dfmTablePedAbiertos.addRow(row);
        }
        
        for(int k = 0; k < ListFacVen.size(); k++){
            Object [ ] row = {
                ListFacVen.get(k).getId_FacVen(),
                ListFacVen.get(k).getVlrFacVen()
            };
            dfmTableFacVen.addRow(row);
        }
    }
    
    public JTable getTablePedidosAbiertos(){
        return this.tbl_PedidosAbiertos;
    }
    
    public JTable getTableFacturaVentas(){
        return this.tbl_Ventas;
    }
    
    public JLabel getLabelVentas(){
        return this.lbl_VentasRealizadas;
    }
    
    public JLabel getLabelTotalVentas(){
        return this.lbl_TotalVentas;
    }
    
    public JLabel getLabelPedidosAbiertos(){
        return this.lbl_PedidosAbiertos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_PedidosAbiertos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Ventas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_IdApertura = new javax.swing.JLabel();
        lbl_FecApertura = new javax.swing.JLabel();
        lbl_SaldoApertura = new javax.swing.JLabel();
        lbl_PedidosAbiertos = new javax.swing.JLabel();
        lbl_VentasRealizadas = new javax.swing.JLabel();
        lbl_TotalVentas = new javax.swing.JLabel();
        btn_FinalizarJornada = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_saldoApertura = new javax.swing.JTextField();
        btn_AperturaCaja = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txt_IdApertura = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_EstadosCaja = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_idRetoma = new javax.swing.JTextField();
        btn_RetomarCaja = new javax.swing.JButton();
        chk_HabilitarCampos = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(513, 665));

        tbl_PedidosAbiertos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id. Pedido", "Cant. Items", "Mesa", "Total Pedido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_PedidosAbiertos.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jScrollPane1.setViewportView(tbl_PedidosAbiertos);
        if (tbl_PedidosAbiertos.getColumnModel().getColumnCount() > 0) {
            tbl_PedidosAbiertos.getColumnModel().getColumn(0).setResizable(false);
            tbl_PedidosAbiertos.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_PedidosAbiertos.getColumnModel().getColumn(1).setResizable(false);
            tbl_PedidosAbiertos.getColumnModel().getColumn(1).setPreferredWidth(80);
            tbl_PedidosAbiertos.getColumnModel().getColumn(2).setResizable(false);
            tbl_PedidosAbiertos.getColumnModel().getColumn(3).setResizable(false);
            tbl_PedidosAbiertos.getColumnModel().getColumn(3).setPreferredWidth(120);
        }

        tbl_Ventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id. Fact", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Ventas.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Ventas.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jScrollPane2.setViewportView(tbl_Ventas);
        if (tbl_Ventas.getColumnModel().getColumnCount() > 0) {
            tbl_Ventas.getColumnModel().getColumn(0).setPreferredWidth(90);
            tbl_Ventas.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Pedido Abiertos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Ventas");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Resumen Movimientos");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ventas Realizadas:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Total Ventas: $");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Pedidos Abiertos:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Id Apertura Caja:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Fecha Apertura:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Saldo Apertura: $");

        lbl_IdApertura.setText("jLabel10");

        lbl_FecApertura.setText("jLabel11");

        lbl_SaldoApertura.setText("jLabel12");

        lbl_PedidosAbiertos.setText("jLabel13");

        lbl_VentasRealizadas.setText("jLabel14");

        lbl_TotalVentas.setText("jLabel15");

        btn_FinalizarJornada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_FinalizarJornada.setText("Finalizar Jornada");
        btn_FinalizarJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FinalizarJornadaActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Aperturar Caja");
        jLabel16.setToolTipText("");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Saldo Apertura: $");

        txt_saldoApertura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_saldoAperturaKeyTyped(evt);
            }
        });

        btn_AperturaCaja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_AperturaCaja.setText("Abrir Caja");
        btn_AperturaCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AperturaCajaActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Cierre Caja");

        tbl_EstadosCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id. Apertura", "Saldo Apertura", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
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
        tbl_EstadosCaja.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jScrollPane3.setViewportView(tbl_EstadosCaja);
        if (tbl_EstadosCaja.getColumnModel().getColumnCount() > 0) {
            tbl_EstadosCaja.getColumnModel().getColumn(0).setResizable(false);
            tbl_EstadosCaja.getColumnModel().getColumn(0).setPreferredWidth(80);
            tbl_EstadosCaja.getColumnModel().getColumn(1).setResizable(false);
            tbl_EstadosCaja.getColumnModel().getColumn(1).setPreferredWidth(120);
            tbl_EstadosCaja.getColumnModel().getColumn(2).setResizable(false);
            tbl_EstadosCaja.getColumnModel().getColumn(2).setPreferredWidth(110);
        }

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Aperturas Caja");

        txt_idRetoma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_idRetomaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_idRetomaKeyTyped(evt);
            }
        });

        btn_RetomarCaja.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_RetomarCaja.setText("Retomar Caja");
        btn_RetomarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RetomarCajaActionPerformed(evt);
            }
        });

        chk_HabilitarCampos.setText("Retomar Caja");
        chk_HabilitarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_HabilitarCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_FinalizarJornada, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                        .addComponent(txt_IdApertura))
                                    .addComponent(jLabel18))
                                .addGap(12, 12, 12))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel9))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_IdApertura)
                                            .addComponent(lbl_FecApertura)
                                            .addComponent(lbl_SaldoApertura)
                                            .addComponent(lbl_PedidosAbiertos))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chk_HabilitarCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_AperturaCaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_saldoApertura, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel17))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btn_RetomarCaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_idRetoma, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(lbl_VentasRealizadas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(40, 40, 40)
                                .addComponent(lbl_TotalVentas)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_saldoApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_AperturaCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chk_HabilitarCampos)
                        .addGap(7, 7, 7)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txt_idRetoma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_RetomarCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_IdApertura)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_FecApertura)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_SaldoApertura)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lbl_PedidosAbiertos))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_VentasRealizadas)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbl_TotalVentas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_IdApertura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_FinalizarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AperturaCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AperturaCajaActionPerformed
        // TODO add your handling code here:
        int result;
        
        if(txt_saldoApertura.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El campo saldo no debe estar vacio. Si la caja se apertura sin dinero, ingresar cero (0)", "Error Apertura caja", JOptionPane.ERROR_MESSAGE);
            txt_saldoApertura.requestFocus();
        } else {
            if(cl.checkOpenBox() > 0){
                JOptionPane.showMessageDialog(null, "Actualmente tiene una caja abierta. Retomarla o cierra dicha caja y abra una nueva", "Error Apertura caja", JOptionPane.ERROR_MESSAGE);
                txt_saldoApertura.setText("");
                txt_saldoApertura.requestFocus();
            } else {
                int saldoApertura = Integer.parseInt(txt_saldoApertura.getText());
                result = cl.openBox(saldoApertura);
                
                if(result > 0){
                    JOptionPane.showMessageDialog(null, "Apertura de caja realizada exitosamente", "Exito Apertura caja", JOptionPane.INFORMATION_MESSAGE);
                    
                    ListAperCaja = new LinkedList<CajaLogic>();
                    ListPedAbiertos = new LinkedList<CajaLogic>();
                    ListFacVen = new LinkedList<CajaLogic>();
                    
                    dfmTableAperCaja = (DefaultTableModel) tbl_EstadosCaja.getModel();
                    dfmTablePedAbiertos = (DefaultTableModel) tbl_PedidosAbiertos.getModel();
                    dfmTableFacVen = (DefaultTableModel) tbl_Ventas.getModel();

                    ListAperCaja = cl.getOpenBoxes();
                    ListPedAbiertos = cl.getOpenOrders(cl.getId_Ape());
                    ListFacVen = cl.getSales(cl.getId_Ape());
                    
                    dfmTableAperCaja.setNumRows(0);
                    dfmTablePedAbiertos.setNumRows(0);
                    dfmTableFacVen.setNumRows(0);

                    for(int i = 0; i < ListAperCaja.size(); i++){            
                        Object [ ] row = {
                            ListAperCaja.get(i).getId_Ape(),
                            ListAperCaja.get(i).getSaldo_Ape(),
                            ListAperCaja.get(i).getFecha_Ape()
                        };
                        dfmTableAperCaja.addRow(row);
                    }
                    
                    for(int j = 0; j < ListPedAbiertos.size(); j++){
                        Object [ ] row = {
                            ListPedAbiertos.get(j).getId_Ped(),
                            ListPedAbiertos.get(j).getCantItems(),
                            ListPedAbiertos.get(j).getMesa(),
                            ListPedAbiertos.get(j).getVlrTotal()
                        };
                        dfmTablePedAbiertos.addRow(row);
                    }
                    
                    for(int k = 0; k < ListFacVen.size(); k++){
                        Object [ ] row = {
                            ListFacVen.get(k).getId_FacVen(),
                            ListFacVen.get(k).getVlrFacVen()
                        };
                        dfmTableFacVen.addRow(row);
                    }
                    
                    lbl_IdApertura.setText(""+cl.getId_Ape());
                    lbl_FecApertura.setText(cl.getFecha_Ape());
                    lbl_SaldoApertura.setText(""+cl.getSaldo_Ape());
                    lbl_PedidosAbiertos.setText("0");
                    lbl_VentasRealizadas.setText("0");
                    lbl_TotalVentas.setText("0");
                    
                    lbl_SaldoApertura.setText(df.format(Integer.valueOf(lbl_SaldoApertura.getText().replace(".", "").replace(".", ""))));
                    lbl_TotalVentas.setText(df.format(Integer.valueOf(lbl_TotalVentas.getText().replace(".", "").replace(".", ""))));
                    
                    txt_saldoApertura.setText("");
                    System.out.println("IMPRESION RECIBO DE APERTURA");
                    tp.printOpenBoxTicket(tbl_EstadosCaja);
                    
                }
            }
        }
    }//GEN-LAST:event_btn_AperturaCajaActionPerformed

    private void txt_saldoAperturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_saldoAperturaKeyTyped
        // TODO add your handling code here:
        char checkTyped = evt.getKeyChar();
        
        if(checkTyped < '0' || checkTyped > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_saldoAperturaKeyTyped

    private void txt_idRetomaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idRetomaKeyTyped
        // TODO add your handling code here:
        char checkTyped = evt.getKeyChar();
        
        if(checkTyped < '0' || checkTyped > '9'){
            evt.consume();
        }
    }//GEN-LAST:event_txt_idRetomaKeyTyped

    private void btn_RetomarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RetomarCajaActionPerformed
        // TODO add your handling code here:
        int idCampo;
        int restore;
        
        if(txt_idRetoma.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Es campo no puede estar vacio, debe ingresar el id de caja que desea retomar", "Error Datos", JOptionPane.ERROR_MESSAGE);
            txt_idRetoma.requestFocus();
        } else {
            idCampo = Integer.parseInt(txt_idRetoma.getText());
            restore = cl.restoreBox();
            
            if(idCampo == cl.restoreBox()){
                cl.setId_Ape(cl.restoreBox());
                JOptionPane.showMessageDialog(null, "Se retoma la caja con ID de apertura: "+cl.restoreBox(), "Retoma Exitosa", JOptionPane.INFORMATION_MESSAGE);
                txt_idRetoma.setText("");
                
                ListPedAbiertos = new LinkedList<CajaLogic>();
                ListFacVen = new LinkedList<CajaLogic>();

                dfmTablePedAbiertos = (DefaultTableModel) tbl_PedidosAbiertos.getModel();
                dfmTableFacVen = (DefaultTableModel) tbl_Ventas.getModel();

                ListPedAbiertos = cl.getOpenOrders(cl.getId_Ape());
                ListFacVen = cl.getSales(cl.getId_Ape());
                
                dfmTablePedAbiertos.setNumRows(0);
                dfmTableFacVen.setNumRows(0);
                
                for(int j = 0; j < ListPedAbiertos.size(); j++){
                    Object [ ] row = {
                        ListPedAbiertos.get(j).getId_Ped(),
                        ListPedAbiertos.get(j).getCantItems(),
                        ListPedAbiertos.get(j).getMesa(),
                        ListPedAbiertos.get(j).getVlrTotal()
                    };
                    dfmTablePedAbiertos.addRow(row);
                }
                
                for(int k = 0; k < ListFacVen.size(); k++){
                    Object [ ] row = {
                        ListFacVen.get(k).getId_FacVen(),
                        ListFacVen.get(k).getVlrFacVen()
                    };
                    dfmTableFacVen.addRow(row);
                }
                
                //Envio informacion a los LABELS
                lbl_IdApertura.setText(""+cl.getId_Ape());
                lbl_FecApertura.setText(cl.getFecha_Ape());
                lbl_SaldoApertura.setText(""+cl.getSaldo_Ape());
                lbl_PedidosAbiertos.setText(""+tbl_PedidosAbiertos.getRowCount());
                lbl_VentasRealizadas.setText(""+tbl_Ventas.getRowCount());
                lbl_TotalVentas.setText(""+cl.getTotalSales(cl.getId_Ape()));
                
                lbl_TotalVentas.setText(df.format(Integer.valueOf(lbl_TotalVentas.getText().replace(".", "").replace(".", ""))));
                lbl_SaldoApertura.setText(df.format(Integer.valueOf(lbl_SaldoApertura.getText().replace(".", "").replace(".", ""))));
                
            } else {
                JOptionPane.showMessageDialog(null, "La caja que intenta RETOMAR no existe. Valide por favor o comuniquese con su proveedor", "Error Datos", JOptionPane.ERROR_MESSAGE);
                txt_idRetoma.setText("");
                txt_idRetoma.requestFocus();
            }
        }
    }//GEN-LAST:event_btn_RetomarCajaActionPerformed

    private void chk_HabilitarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_HabilitarCamposActionPerformed
        // TODO add your handling code here:
        if(chk_HabilitarCampos.isSelected() == true){
            JOptionPane.showMessageDialog(null, "Por favor ingrese el id de la caja que desea retomar", "Retomar Caja", JOptionPane.INFORMATION_MESSAGE);
            txt_idRetoma.requestFocus();
            txt_idRetoma.setEnabled(true);
            btn_RetomarCaja.setEnabled(true);
            
            txt_saldoApertura.setEditable(false);
            btn_AperturaCaja.setEnabled(false);
        } else {
            if(chk_HabilitarCampos.isSelected() == false){
                JOptionPane.showMessageDialog(null, "Por favor ingrese el saldo para aperturar la caja", "Apertura Caja", JOptionPane.INFORMATION_MESSAGE);
                txt_saldoApertura.setEditable(true);
                btn_AperturaCaja.setEnabled(true);
                txt_saldoApertura.requestFocus();
                
                txt_idRetoma.setEnabled(false);
                btn_RetomarCaja.setEnabled(false);
            }
        }
    }//GEN-LAST:event_chk_HabilitarCamposActionPerformed

    private void txt_idRetomaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_idRetomaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idRetomaKeyPressed

    private void btn_FinalizarJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FinalizarJornadaActionPerformed
        // TODO add your handling code here:
        int idCierre;
        int saldoCierre;
        CajaLogic cl;
        
        if(txt_IdApertura.getText().equals("")){
            JOptionPane.showMessageDialog(null, "El campo del id de apertura no debe estar en blanco, porque favor ingrese el id de apertura de caja que desea cerrar", "Error cierre caja", JOptionPane.ERROR_MESSAGE);
            txt_IdApertura.requestFocus();
        } else {
            
            cl = CajaLogic.getInstance();
            idCierre = Integer.parseInt(txt_IdApertura.getText());
            
            if(tbl_PedidosAbiertos.getRowCount() > 0){
                JOptionPane.showMessageDialog(null, "Cuenta con pedidos ABIERTOS. Por favor proceda a cerrarlos y nuevamente intente cerrar la CAJA", "Error cierre caja", JOptionPane.ERROR_MESSAGE);
                txt_IdApertura.setText("");
                txt_IdApertura.requestFocus();
            } else {
                if(cl.getId_Ape() == idCierre) {
                    ul = Utilidades.getInstance();

                    saldoCierre = cl.getTotalSales(cl.getId_Ape())+cl.getSaldo_Ape();
                    ul.cleanRegTable(tbl_EstadosCaja, idCierre);
                    ul.cleanTable(tbl_PedidosAbiertos);
                    ul.cleanTable(tbl_Ventas);
                    
                    System.out.println("IMPRESION RECIBO DE CIERRE");
                    tp.printCloseBoxTicket(lbl_IdApertura.getText(), 
                                                            lbl_FecApertura.getText(), 
                                                            lbl_SaldoApertura.getText(), 
                                                            lbl_PedidosAbiertos.getText(), 
                                                            lbl_VentasRealizadas.getText(), 
                                                            lbl_TotalVentas.getText(), 
                                                            String.valueOf(saldoCierre), 
                                                            ul.getSysDate());

                    System.out.println("Voy a cerrar la cajaX: "+cl.getId_Ape());
                    System.out.println("Total Ventas (BD): "+cl.getTotalSales(cl.getId_Ape()));
                    System.out.println("Saldo Apertura (CLASE): "+cl.getSaldo_Ape());
                    System.out.println("Total Saldo Cierre: "+ saldoCierre);

                    cl.closeBox(saldoCierre, cl.getId_Ape());
                    cl.setId_Ape(0);

                    lbl_IdApertura.setText("-");
                    lbl_FecApertura.setText("-");
                    lbl_SaldoApertura.setText("-");
                    lbl_PedidosAbiertos.setText("-");
                    lbl_VentasRealizadas.setText("-");
                    lbl_TotalVentas.setText("-");

                    JOptionPane.showMessageDialog(null, "Cierre de caja realizado exitosamente", "Exito cierre caja", JOptionPane.INFORMATION_MESSAGE);
                     txt_IdApertura.setText("");

                } else {
                    System.out.println("Id Apertura: "+cl.getId_Ape());
                    JOptionPane.showMessageDialog(null, "El id de apertura de caja que ingreso no existe, ya se encuentra CERRADO o la caja se encuentra ABIERTA pero no RETOMADA. Valide por favor", "Error cierre caja", JOptionPane.ERROR_MESSAGE);
                    txt_IdApertura.setText("");
                    txt_IdApertura.requestFocus();
                }
            }
        }
    }//GEN-LAST:event_btn_FinalizarJornadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_AperturaCaja;
    private javax.swing.JButton btn_FinalizarJornada;
    private javax.swing.JButton btn_RetomarCaja;
    private javax.swing.JCheckBox chk_HabilitarCampos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_FecApertura;
    private javax.swing.JLabel lbl_IdApertura;
    private javax.swing.JLabel lbl_PedidosAbiertos;
    private javax.swing.JLabel lbl_SaldoApertura;
    private javax.swing.JLabel lbl_TotalVentas;
    private javax.swing.JLabel lbl_VentasRealizadas;
    private javax.swing.JTable tbl_EstadosCaja;
    private javax.swing.JTable tbl_PedidosAbiertos;
    private javax.swing.JTable tbl_Ventas;
    private javax.swing.JTextField txt_IdApertura;
    private javax.swing.JTextField txt_idRetoma;
    private javax.swing.JTextField txt_saldoApertura;
    // End of variables declaration//GEN-END:variables
}
