package GUI;

import Logic.LoginLogic;
import Logic.UsuariosLogic;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Camilo
 */
public class Usuarios extends javax.swing.JPanel {
    
    DefaultTableModel dfmTableUsuarios;
    
    LinkedList<UsuariosLogic>ListUsuarios;
    
    UsuariosLogic us;
    LoginLogic log;

    public Usuarios() {
        initComponents();
        
        txt_IdUsuario.setEnabled(false);
        txt_NombreUsuario.setEnabled(false);
        txt_Nick.setEnabled(false);
        txt_ApellidoUsuario.setEnabled(false);
        txt_PasswordUsr1.setEnabled(false);
        txt_PasswordUsr2.setEnabled(false);
        
        cb_EstadoUsuario.setEnabled(false);
        cb_RolUsuario.setEnabled(false);
        
        btn_CrearUsuario.setEnabled(false);
        btn_ActualizarUsuario.setEnabled(false);
        
        lbl_Fec_Crea.setText("SIN DATOS");
        
        us = UsuariosLogic.getInstance();
        log = LoginLogic.getInstance();
        
        try {
            ListUsuarios = new LinkedList<UsuariosLogic>();
            dfmTableUsuarios = (DefaultTableModel) tbl_Usuarios.getModel();
            
            ListUsuarios = us.GetUsers();
            dfmTableUsuarios.setNumRows(0);
            
            for(int i = 0; i < ListUsuarios.size(); i++){
                
                String estado = "";
                
                if(ListUsuarios.get(i).getEstadoUser()){
                    estado = "ACTIVO";
                } else {
                    estado = "INACTIVO";
                }
                
                Object [ ] row = {
                    ListUsuarios.get(i).getIdUser(),
                    ListUsuarios.get(i).getNomUser()+" "+ListUsuarios.get(i).getApeUser(),
                    ListUsuarios.get(i).getNickUser(),
                    ListUsuarios.get(i).getRolUser(),
                    estado
                };
                dfmTableUsuarios.addRow(row);
            }
            
        } catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuOpciones = new javax.swing.JPopupMenu();
        menuActualizarUsuario = new javax.swing.JMenuItem();
        menuDesactivarUsuario = new javax.swing.JMenuItem();
        btn_BuscarUsuario = new javax.swing.JButton();
        txt_BuscarUsuario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Usuarios = new javax.swing.JTable();
        txt_IdUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_NombreUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txt_ApellidoUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_CrearUsuario = new javax.swing.JButton();
        btn_ActualizarUsuario = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_PasswordUsr1 = new javax.swing.JPasswordField();
        txt_PasswordUsr2 = new javax.swing.JPasswordField();
        cb_RolUsuario = new javax.swing.JComboBox<>();
        cb_EstadoUsuario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lbl_Fec_Crea = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_NuevoUsuario = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        txt_Nick = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        menuActualizarUsuario.setText("Actualizar Usuario");
        menuActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActualizarUsuarioActionPerformed(evt);
            }
        });
        menuOpciones.add(menuActualizarUsuario);

        menuDesactivarUsuario.setText("Desactivar Usuario");
        menuDesactivarUsuario.setToolTipText("");
        menuDesactivarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDesactivarUsuarioActionPerformed(evt);
            }
        });
        menuOpciones.add(menuDesactivarUsuario);

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(522, 550));
        setPreferredSize(new java.awt.Dimension(540, 550));

        btn_BuscarUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_BuscarUsuario.setText("Buscar");
        btn_BuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarUsuarioActionPerformed(evt);
            }
        });

        txt_BuscarUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_BuscarUsuarioKeyReleased(evt);
            }
        });

        tbl_Usuarios.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbl_Usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom. Usuario", "Nickname", "Rol Usuario", "Est. Usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        tbl_Usuarios.setComponentPopupMenu(menuOpciones);
        tbl_Usuarios.setSelectionBackground(new java.awt.Color(255, 102, 102));
        jScrollPane1.setViewportView(tbl_Usuarios);
        if (tbl_Usuarios.getColumnModel().getColumnCount() > 0) {
            tbl_Usuarios.getColumnModel().getColumn(0).setResizable(false);
            tbl_Usuarios.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_Usuarios.getColumnModel().getColumn(1).setResizable(false);
            tbl_Usuarios.getColumnModel().getColumn(1).setPreferredWidth(85);
            tbl_Usuarios.getColumnModel().getColumn(2).setResizable(false);
            tbl_Usuarios.getColumnModel().getColumn(2).setPreferredWidth(40);
            tbl_Usuarios.getColumnModel().getColumn(3).setResizable(false);
            tbl_Usuarios.getColumnModel().getColumn(3).setPreferredWidth(25);
            tbl_Usuarios.getColumnModel().getColumn(4).setResizable(false);
            tbl_Usuarios.getColumnModel().getColumn(4).setPreferredWidth(25);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("identificación:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Apellidos:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Clave:");

        btn_CrearUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_CrearUsuario.setText("Crear");

        btn_ActualizarUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_ActualizarUsuario.setText("Actualizar");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Conf. Clave:");

        cb_RolUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "ADMIN", "OPERADOR" }));

        cb_EstadoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONE", "ACTIVO", "INACTIVO" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fec. Creacion:");

        lbl_Fec_Crea.setText("jLabel7");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Rol Usuario:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Estado:");

        btn_NuevoUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_NuevoUsuario.setText("Nuevo Usuario");
        btn_NuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NuevoUsuarioActionPerformed(evt);
            }
        });

        btn_Cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nick:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(txt_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btn_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_IdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_Fec_Crea))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(txt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(txt_ApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(7, 7, 7)
                                .addComponent(cb_RolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel4)
                                        .addGap(14, 14, 14)
                                        .addComponent(txt_PasswordUsr1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(7, 7, 7)
                                        .addComponent(txt_PasswordUsr2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(34, 34, 34)
                                .addComponent(cb_EstadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_NuevoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_ActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_CrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txt_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_BuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_IdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel6)
                    .addComponent(lbl_Fec_Crea))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ApellidoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_RolUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_Nick, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cb_EstadoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9)))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_NuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_CrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_PasswordUsr1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_PasswordUsr2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NuevoUsuarioActionPerformed
        
        JOptionPane.showMessageDialog(null, "Creacion de NUEVO usuario. Todos los datos son OBLIGATORIOS", "Creacion Usuario", JOptionPane.INFORMATION_MESSAGE);
        //CAMPOS QUE SE DESHABILITAN
        tbl_Usuarios.setEnabled(false);
        
        btn_ActualizarUsuario.setEnabled(false);
        btn_BuscarUsuario.setEnabled(false);
        btn_NuevoUsuario.setEnabled(false);
        
        //CAMPOS QUE SE HABILITAN
        txt_IdUsuario.setEnabled(true);
        txt_NombreUsuario.setEnabled(true);
        txt_Nick.setEnabled(true);
        txt_ApellidoUsuario.setEnabled(true);
        txt_PasswordUsr1.setEnabled(true);
        txt_PasswordUsr2.setEnabled(true);
        
        cb_EstadoUsuario.setSelectedIndex(1);
        cb_EstadoUsuario.setEnabled(false);
        
        cb_RolUsuario.setEnabled(true);
        
        btn_CrearUsuario.setEnabled(true);
        
    }//GEN-LAST:event_btn_NuevoUsuarioActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed

        JOptionPane.showMessageDialog(null, "Operacion Cancelada", "Creacion Usuario", JOptionPane.INFORMATION_MESSAGE);

        tbl_Usuarios.setEnabled(true);
        btn_NuevoUsuario.setEnabled(true);
        btn_BuscarUsuario.setEnabled(true);

        txt_IdUsuario.setEnabled(false);
        txt_NombreUsuario.setEnabled(false);
        txt_Nick.setEnabled(false);
        txt_ApellidoUsuario.setEnabled(false);
        txt_PasswordUsr1.setEnabled(false);
        txt_PasswordUsr2.setEnabled(false);

        cb_EstadoUsuario.setEnabled(false);
        cb_RolUsuario.setEnabled(false);

        btn_CrearUsuario.setEnabled(false);
        btn_ActualizarUsuario.setEnabled(false);

        //REINICIO DATOS - CANCELACION PROCESO
        lbl_Fec_Crea.setText("SIN DATOS");
        txt_BuscarUsuario.setText("");
        txt_IdUsuario.setText("");
        txt_NombreUsuario.setText("");
        txt_Nick.setText("");
        txt_ApellidoUsuario.setText("");
        txt_PasswordUsr1.setText("");
        txt_PasswordUsr2.setText("");
        cb_EstadoUsuario.setSelectedIndex(0);
        cb_RolUsuario.setSelectedIndex(0);

    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void txt_BuscarUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_BuscarUsuarioKeyReleased
        us.userFilter(txt_BuscarUsuario.getText(), tbl_Usuarios);
    }//GEN-LAST:event_txt_BuscarUsuarioKeyReleased

    private void btn_BuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarUsuarioActionPerformed
        us.userFilter(txt_BuscarUsuario.getText(), tbl_Usuarios);
        dfmTableUsuarios = (DefaultTableModel) tbl_Usuarios.getModel();
    }//GEN-LAST:event_btn_BuscarUsuarioActionPerformed

    private void menuDesactivarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDesactivarUsuarioActionPerformed
        //LIMPIAR CAMPO BUSQUEDA
        txt_BuscarUsuario.setText("");
        
        JOptionPane.showMessageDialog(null, "ATENCION: Se procedera a DESACTIVAR el usuario "+tbl_Usuarios.getValueAt(tbl_Usuarios.getSelectedRow(), 2)+". Este ya NO PODRA ingresar al sistema", "Desactivacion Usuario", JOptionPane.ERROR_MESSAGE);
        
        if(log.getUserID() == (Integer) tbl_Usuarios.getValueAt(tbl_Usuarios.getSelectedRow(), 0)){
            JOptionPane.showMessageDialog(null, "No puede DESACTIVAR su propio usuario", "Desactivacion Usuario", JOptionPane.ERROR_MESSAGE);
        } else {
                if(tbl_Usuarios.getValueAt(tbl_Usuarios.getSelectedRow(), 4).equals("ACTIVO")){
                //CODIGO DESACTIVAR USUARIO
                us.disableUser((Integer) tbl_Usuarios.getValueAt(tbl_Usuarios.getSelectedRow(), 0));
                JOptionPane.showMessageDialog(null, "Usuario DESACTIVADO", "Desactivacion Usuario", JOptionPane.INFORMATION_MESSAGE);

                    try {
                    ListUsuarios = new LinkedList<UsuariosLogic>();
                    dfmTableUsuarios = (DefaultTableModel) tbl_Usuarios.getModel();

                    ListUsuarios = us.GetUsers();
                    dfmTableUsuarios.setNumRows(0);

                    for(int i = 0; i < ListUsuarios.size(); i++){

                        String estado = "";

                        if(ListUsuarios.get(i).getEstadoUser()){
                            estado = "ACTIVO";
                        } else {
                            estado = "INACTIVO";
                        }

                        Object [ ] row = {
                            ListUsuarios.get(i).getIdUser(),
                            ListUsuarios.get(i).getNomUser()+" "+ListUsuarios.get(i).getApeUser(),
                            ListUsuarios.get(i).getNickUser(),
                            ListUsuarios.get(i).getRolUser(),
                            estado
                        };
                        dfmTableUsuarios.addRow(row);
                    }

                } catch(Exception ex){
                    System.err.println(ex.getMessage());
                }
            }else {
                JOptionPane.showMessageDialog(null, "El usuario ya se encuentra DESACTIVADO", "Desactivacion Usuario", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuDesactivarUsuarioActionPerformed

    private void menuActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActualizarUsuarioActionPerformed
        //LIMPIAR CAMPO BUSQUEDA
        txt_BuscarUsuario.setText("");
        
        //HABILITAR - DESHABILITAR OTROS BOTONES
        btn_NuevoUsuario.setEnabled(false);
        btn_CrearUsuario.setEnabled(false);
        btn_ActualizarUsuario.setEnabled(true);
        
        JOptionPane.showMessageDialog(null, "ATENCION: Se procedera a actualizar los datos del usuario seleccionado, todos los datos son OBLIGATORIOS", "Actualizar Usuario", JOptionPane.INFORMATION_MESSAGE);
        
        us.searchUser((Integer) tbl_Usuarios.getValueAt(tbl_Usuarios.getSelectedRow(), 0));
        txt_IdUsuario.setText(""+us.getIdUser());
        txt_NombreUsuario.setText(us.getNomUser());
        txt_Nick.setText(us.getNickUser());
        txt_ApellidoUsuario.setText(us.getApeUser());
        lbl_Fec_Crea.setText(us.getFecCrea());
        
        if(us.getRolUser().equals("ADMIN")){
            cb_RolUsuario.setSelectedIndex(1);
        } else {
            if(us.getRolUser().equals("OPERADOR")){
                cb_RolUsuario.setSelectedIndex(2);
            }
        }
        
        if(us.getEstadoUser()){
            cb_EstadoUsuario.setSelectedIndex(1);
        } else {
            if(!us.getEstadoUser()){
                cb_EstadoUsuario.setSelectedIndex(2);
            }
        }
        
        txt_NombreUsuario.setEnabled(true);
        txt_ApellidoUsuario.setEnabled(true);
        txt_Nick.setEnabled(true);
        cb_EstadoUsuario.setEnabled(true);
        cb_RolUsuario.setEnabled(true);
        
    }//GEN-LAST:event_menuActualizarUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ActualizarUsuario;
    private javax.swing.JButton btn_BuscarUsuario;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_CrearUsuario;
    private javax.swing.JButton btn_NuevoUsuario;
    private javax.swing.JComboBox<String> cb_EstadoUsuario;
    private javax.swing.JComboBox<String> cb_RolUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl_Fec_Crea;
    private javax.swing.JMenuItem menuActualizarUsuario;
    private javax.swing.JMenuItem menuDesactivarUsuario;
    private javax.swing.JPopupMenu menuOpciones;
    private javax.swing.JTable tbl_Usuarios;
    private javax.swing.JTextField txt_ApellidoUsuario;
    private javax.swing.JTextField txt_BuscarUsuario;
    private javax.swing.JTextField txt_IdUsuario;
    private javax.swing.JTextField txt_Nick;
    private javax.swing.JTextField txt_NombreUsuario;
    private javax.swing.JPasswordField txt_PasswordUsr1;
    private javax.swing.JPasswordField txt_PasswordUsr2;
    // End of variables declaration//GEN-END:variables
}
