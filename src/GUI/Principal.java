package GUI;

import Logic.CajaLogic;
import Logic.LoginLogic;
import Logic.PedidosLogic;
import Logic.PrincipalLogic;
import Logic.ProductosLogic;
import Logic.Utilidades;
import Persistencia.ConnectionMySQL;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Camilo
 */
public class Principal extends javax.swing.JFrame {
    
    int xx = 0;
    int xy = 0;
    
    int openBoxes;
    
    Pedidos p;
    Facturacion f;
    Caja c;
    Usuarios us;
    Productos pr;
    
    Utilidades u;
    
    ConnectionMySQL cmSQL;
    PrincipalLogic pl;
    LoginLogic lg;
    CajaLogic cl;
    PedidosLogic pdl;
    
    public Principal()  {
        initComponents();
        
        btn_opcClientes.setVisible(false);
        btn_opcUsuarios.setVisible(false);
        btn_opcProductos.setVisible(false);
        
        //INICIALIZACIONES
            p = new Pedidos();
            f = new Facturacion( );
            c = new Caja();
            us= new Usuarios();
            pr = new Productos();
            
            //Singleton
            cmSQL = ConnectionMySQL.getInstance();
            cl = CajaLogic.getInstance();
            pl = PrincipalLogic.getInstance();
            lg = LoginLogic.getInstance();
            u = Utilidades.getInstance();
            pdl = new PedidosLogic();
            
            setIconImage(new ImageIcon(getClass().getResource("../Multimedia/TurtleIcon.png")).getImage());
            this.setTitle("Workit App - "+u.getVersionApp());
            lbl_Version.setText("version "+u.getVersionApp());
            cl.setId_Ape(0);
            
        //SETS
        panelCarga.setViewportView(p);
        try {
            String nombre =  pl.getUserName(lg.getUser(), lg.getPass(), cmSQL.getDBConnection());
            lbl_Usuario.setText(lbl_Usuario.getText()+" "+nombre);
            
            if(pl.getRolUser(lg.getUser(), lg.getPass(), cmSQL.getDBConnection()).equals("ADMIN")){
                btn_opcClientes.setVisible(true);
                btn_opcUsuarios.setVisible(true);
                btn_opcProductos.setVisible(true);
            } else {
                if(pl.getRolUser(lg.getUser(), lg.getPass(), cmSQL.getDBConnection()).equals("OPERADOR")){
                    btn_opcClientes.setVisible(false);
                    btn_opcUsuarios.setVisible(false);
                    btn_opcProductos.setVisible(false);
                }
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        Shape form = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 10, 10);
        AWTUtilities.setWindowShape(this, form);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_SidePanel = new javax.swing.JPanel();
        btn_opcPedidos = new javax.swing.JPanel();
        lbl_IconPedidos = new javax.swing.JLabel();
        lbl_Pedidos = new javax.swing.JLabel();
        lbl_AppName = new javax.swing.JLabel();
        lbl_Icon = new javax.swing.JLabel();
        btn_opcUsuarios = new javax.swing.JPanel();
        lbl_IconUsuarios = new javax.swing.JLabel();
        lbl_Usuarios = new javax.swing.JLabel();
        btn_opcFacturar = new javax.swing.JPanel();
        lbl_IconFacturar = new javax.swing.JLabel();
        lbl_Facturar = new javax.swing.JLabel();
        btn_opcProductos = new javax.swing.JPanel();
        lbl_IconProductos = new javax.swing.JLabel();
        lbl_Productos = new javax.swing.JLabel();
        btn_opcClientes = new javax.swing.JPanel();
        lbl_IconClientes = new javax.swing.JLabel();
        lbl_Clientes = new javax.swing.JLabel();
        btn_opcCaja = new javax.swing.JPanel();
        lbl_IconCaja = new javax.swing.JLabel();
        lbl_Caja = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btn_opcSalir = new javax.swing.JPanel();
        lbl_IconClientes1 = new javax.swing.JLabel();
        lbl_Clientes1 = new javax.swing.JLabel();
        lbl_Version = new javax.swing.JLabel();
        lbl_Usuario = new javax.swing.JLabel();
        panelCarga = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_SidePanel.setBackground(new java.awt.Color(244, 67, 54));
        panel_SidePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panel_SidePanelMouseDragged(evt);
            }
        });
        panel_SidePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panel_SidePanelMousePressed(evt);
            }
        });
        panel_SidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_opcPedidos.setBackground(new java.awt.Color(254, 87, 34));
        btn_opcPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_opcPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_opcPedidosMouseClicked(evt);
            }
        });

        lbl_IconPedidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/ShoppingCart.png"))); // NOI18N

        lbl_Pedidos.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Pedidos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Pedidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Pedidos.setText("Pedidos");

        javax.swing.GroupLayout btn_opcPedidosLayout = new javax.swing.GroupLayout(btn_opcPedidos);
        btn_opcPedidos.setLayout(btn_opcPedidosLayout);
        btn_opcPedidosLayout.setHorizontalGroup(
            btn_opcPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcPedidosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_IconPedidos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btn_opcPedidosLayout.setVerticalGroup(
            btn_opcPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_opcPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_opcPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_IconPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_SidePanel.add(btn_opcPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 260, -1));

        lbl_AppName.setFont(lbl_AppName.getFont().deriveFont(lbl_AppName.getFont().getStyle() | java.awt.Font.BOLD, lbl_AppName.getFont().getSize()+35));
        lbl_AppName.setForeground(new java.awt.Color(255, 255, 255));
        lbl_AppName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_AppName.setText("WorkIt");
        panel_SidePanel.add(lbl_AppName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, -1));

        lbl_Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Turtle.png"))); // NOI18N
        panel_SidePanel.add(lbl_Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 100, 100));

        btn_opcUsuarios.setBackground(new java.awt.Color(211, 47, 47));
        btn_opcUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_opcUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_opcUsuariosMouseClicked(evt);
            }
        });

        lbl_IconUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/User.png"))); // NOI18N

        lbl_Usuarios.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Usuarios.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Usuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Usuarios.setText("Usuarios");

        javax.swing.GroupLayout btn_opcUsuariosLayout = new javax.swing.GroupLayout(btn_opcUsuarios);
        btn_opcUsuarios.setLayout(btn_opcUsuariosLayout);
        btn_opcUsuariosLayout.setHorizontalGroup(
            btn_opcUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcUsuariosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_IconUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btn_opcUsuariosLayout.setVerticalGroup(
            btn_opcUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_opcUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_opcUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_IconUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Usuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_SidePanel.add(btn_opcUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 260, -1));

        btn_opcFacturar.setBackground(new java.awt.Color(211, 47, 47));
        btn_opcFacturar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_opcFacturar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_opcFacturarMouseClicked(evt);
            }
        });

        lbl_IconFacturar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconFacturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Dollar.png"))); // NOI18N

        lbl_Facturar.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Facturar.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Facturar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Facturar.setText("Facturar");

        javax.swing.GroupLayout btn_opcFacturarLayout = new javax.swing.GroupLayout(btn_opcFacturar);
        btn_opcFacturar.setLayout(btn_opcFacturarLayout);
        btn_opcFacturarLayout.setHorizontalGroup(
            btn_opcFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcFacturarLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_IconFacturar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Facturar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btn_opcFacturarLayout.setVerticalGroup(
            btn_opcFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_opcFacturarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_opcFacturarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_IconFacturar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Facturar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_SidePanel.add(btn_opcFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, -1, -1));

        btn_opcProductos.setBackground(new java.awt.Color(211, 47, 47));
        btn_opcProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_opcProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_opcProductosMouseClicked(evt);
            }
        });

        lbl_IconProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Products.png"))); // NOI18N

        lbl_Productos.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Productos.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Productos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Productos.setText("Productos");

        javax.swing.GroupLayout btn_opcProductosLayout = new javax.swing.GroupLayout(btn_opcProductos);
        btn_opcProductos.setLayout(btn_opcProductosLayout);
        btn_opcProductosLayout.setHorizontalGroup(
            btn_opcProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcProductosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_IconProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btn_opcProductosLayout.setVerticalGroup(
            btn_opcProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_opcProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_opcProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_IconProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_SidePanel.add(btn_opcProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 260, -1));

        btn_opcClientes.setBackground(new java.awt.Color(211, 47, 47));
        btn_opcClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_opcClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_opcClientesMouseClicked(evt);
            }
        });

        lbl_IconClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/Client.png"))); // NOI18N

        lbl_Clientes.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Clientes.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Clientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Clientes.setText("Clientes");

        javax.swing.GroupLayout btn_opcClientesLayout = new javax.swing.GroupLayout(btn_opcClientes);
        btn_opcClientes.setLayout(btn_opcClientesLayout);
        btn_opcClientesLayout.setHorizontalGroup(
            btn_opcClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcClientesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_IconClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btn_opcClientesLayout.setVerticalGroup(
            btn_opcClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_opcClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_opcClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_IconClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_SidePanel.add(btn_opcClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 260, -1));

        btn_opcCaja.setBackground(new java.awt.Color(211, 47, 47));
        btn_opcCaja.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_opcCaja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_opcCajaMouseClicked(evt);
            }
        });

        lbl_IconCaja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/CashRegister.png"))); // NOI18N

        lbl_Caja.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Caja.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Caja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Caja.setText("Caja");

        javax.swing.GroupLayout btn_opcCajaLayout = new javax.swing.GroupLayout(btn_opcCaja);
        btn_opcCaja.setLayout(btn_opcCajaLayout);
        btn_opcCajaLayout.setHorizontalGroup(
            btn_opcCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcCajaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_IconCaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Caja, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        btn_opcCajaLayout.setVerticalGroup(
            btn_opcCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_opcCajaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_opcCajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_IconCaja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Caja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_SidePanel.add(btn_opcCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));
        panel_SidePanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 240, 10));
        panel_SidePanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 240, 10));

        btn_opcSalir.setBackground(new java.awt.Color(211, 47, 47));
        btn_opcSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_opcSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_opcSalirMouseClicked(evt);
            }
        });

        lbl_IconClientes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_IconClientes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Multimedia/ExitP.png"))); // NOI18N

        lbl_Clientes1.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Clientes1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Clientes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Clientes1.setText("Salir");

        javax.swing.GroupLayout btn_opcSalirLayout = new javax.swing.GroupLayout(btn_opcSalir);
        btn_opcSalir.setLayout(btn_opcSalirLayout);
        btn_opcSalirLayout.setHorizontalGroup(
            btn_opcSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_opcSalirLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbl_IconClientes1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_Clientes1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        btn_opcSalirLayout.setVerticalGroup(
            btn_opcSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_opcSalirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btn_opcSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_IconClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_Clientes1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panel_SidePanel.add(btn_opcSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 260, -1));

        lbl_Version.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Version.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Version.setText("v. ");
        panel_SidePanel.add(lbl_Version, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, -1, -1));

        lbl_Usuario.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lbl_Usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Usuario.setText("Bienvenid@ ");
        panel_SidePanel.add(lbl_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, -1, -1));

        getContentPane().add(panel_SidePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 730));

        panelCarga.setBackground(new java.awt.Color(255, 255, 255));
        panelCarga.setBorder(null);
        panelCarga.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelCargaMouseDragged(evt);
            }
        });
        panelCarga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelCargaMousePressed(evt);
            }
        });
        getContentPane().add(panelCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 560, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_opcPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_opcPedidosMouseClicked
        // TODO add your handling code here:
        setBackgroundColor(btn_opcPedidos);
        
        resetBackgroundColor(btn_opcFacturar);
        resetBackgroundColor(btn_opcUsuarios);
        resetBackgroundColor(btn_opcProductos);
        resetBackgroundColor(btn_opcClientes);
        resetBackgroundColor(btn_opcCaja);
        
        
        panelCarga.setViewportView(p);
        
        p.dfmTable = (DefaultTableModel) p.getTableProductos().getModel();
        p.ListProductos = pdl.GetProductos();
        p.dfmTable.setNumRows(0);
            
        for(int i = 0; i < p.ListProductos.size(); i++){
            Object [ ] row = {
                p.ListProductos.get(i).getIdProducto(),
                p.ListProductos.get(i).getNombreProducto(),
                p.ListProductos.get(i).getPrecioProducto()
            };
            p.dfmTable.addRow(row);
        }
    }//GEN-LAST:event_btn_opcPedidosMouseClicked

    private void btn_opcFacturarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_opcFacturarMouseClicked
        // TODO add your handling code here:
        setBackgroundColor(btn_opcFacturar);
        
        resetBackgroundColor(btn_opcPedidos);
        resetBackgroundColor(btn_opcUsuarios);
        resetBackgroundColor(btn_opcProductos);
        resetBackgroundColor(btn_opcClientes);
        resetBackgroundColor(btn_opcCaja);
        
        panelCarga.setViewportView(f);
    }//GEN-LAST:event_btn_opcFacturarMouseClicked

    private void btn_opcUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_opcUsuariosMouseClicked
        // TODO add your handling code here:
        setBackgroundColor(btn_opcUsuarios);
        
        resetBackgroundColor(btn_opcPedidos);
        resetBackgroundColor(btn_opcFacturar);
        resetBackgroundColor(btn_opcProductos);
        resetBackgroundColor(btn_opcClientes);
        resetBackgroundColor(btn_opcCaja);
        
        panelCarga.setViewportView(us);
    }//GEN-LAST:event_btn_opcUsuariosMouseClicked

    private void btn_opcProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_opcProductosMouseClicked
        // TODO add your handling code here:
        setBackgroundColor(btn_opcProductos);
        
        resetBackgroundColor(btn_opcPedidos);
        resetBackgroundColor(btn_opcFacturar);
        resetBackgroundColor(btn_opcUsuarios);
        resetBackgroundColor(btn_opcClientes);
        resetBackgroundColor(btn_opcCaja);
        
        panelCarga.setViewportView(pr);
    }//GEN-LAST:event_btn_opcProductosMouseClicked

    private void btn_opcClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_opcClientesMouseClicked
        // TODO add your handling code here:
        setBackgroundColor(btn_opcClientes);
        
        resetBackgroundColor(btn_opcPedidos);
        resetBackgroundColor(btn_opcFacturar);
        resetBackgroundColor(btn_opcUsuarios);
        resetBackgroundColor(btn_opcProductos);
        resetBackgroundColor(btn_opcCaja);
    }//GEN-LAST:event_btn_opcClientesMouseClicked

    private void btn_opcCajaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_opcCajaMouseClicked
        // TODO add your handling code here:
        setBackgroundColor(btn_opcCaja);
        
        resetBackgroundColor(btn_opcPedidos);
        resetBackgroundColor(btn_opcFacturar);
        resetBackgroundColor(btn_opcUsuarios);
        resetBackgroundColor(btn_opcProductos);
        resetBackgroundColor(btn_opcClientes);
        
        panelCarga.setViewportView(c);
        //CODIGO PARA CARGAR FACTURAS DE PEDIDOS YA VENDIDOS
        c.dfmTableFacVen = (DefaultTableModel) c.getTableFacturaVentas().getModel();
        c.ListFacVen = cl.getSales(cl.getId_Ape());
        c.dfmTableFacVen.setNumRows(0);
        
        for(int i = 0; i < c.ListFacVen.size(); i++){
            Object [ ] row = {
                c.ListFacVen.get(i).getId_FacVen(),
                c.ListFacVen.get(i).getVlrFacVen()
            };
            c.dfmTableFacVen.addRow(row);
        }
        
        //CODIGO PARA CARGAR PEDIDOS ABIERTOS DESDE BTN CAJA
        c.dfmTablePedAbiertos = (DefaultTableModel) c.getTablePedidosAbiertos().getModel();
        c.ListPedAbiertos = cl.getOpenOrders(cl.getId_Ape());
        c.dfmTablePedAbiertos.setNumRows(0);
        
        for(int j = 0; j < c.ListPedAbiertos.size(); j++){
            Object [ ] row = {
                c.ListPedAbiertos.get(j).getId_Ped(),
                c.ListPedAbiertos.get(j).getCantItems(),
                c.ListPedAbiertos.get(j).getMesa(),
                c.ListPedAbiertos.get(j).getVlrTotal()
            };
            c.dfmTablePedAbiertos.addRow(row);
        }
        
        c.getLabelPedidosAbiertos().setText(""+c.getTablePedidosAbiertos().getRowCount()); 
        c.getLabelVentas().setText(""+c.getTableFacturaVentas().getRowCount());
        c.getLabelTotalVentas().setText(""+cl.getTotalSales(cl.getId_Ape()));
        
    }//GEN-LAST:event_btn_opcCajaMouseClicked

    private void panel_SidePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_SidePanelMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_panel_SidePanelMousePressed

    private void panel_SidePanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel_SidePanelMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x + xx, y + xy);
    }//GEN-LAST:event_panel_SidePanelMouseDragged

    private void btn_opcSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_opcSalirMouseClicked
        int dialogOption = JOptionPane.YES_NO_OPTION;
        int result = 0;
        openBoxes = cl.checkOpenBox();
        
        System.out.println(openBoxes);
        
        if((openBoxes != 0)){
            JOptionPane.showMessageDialog(null, "Actualmente cuenta con una caja abierta, por favor antes de salir del sistema proceda con el cierre de esta", "Salir del sistema", JOptionPane.INFORMATION_MESSAGE);
        } else {
            result = JOptionPane.showConfirmDialog(null, "Desas salir?", "Salir del Sistema",dialogOption);
        
            if(result == 0){
                try {
                    cmSQL.closeDBConnection();
                    JOptionPane.showMessageDialog(null, "Adios", "Salir del sistema", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                    JOptionPane.showMessageDialog(null, "OK", "Salir del sistema", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_opcSalirMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void panelCargaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCargaMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_panelCargaMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x + xx, y + xy);
    }//GEN-LAST:event_formMouseDragged

    private void panelCargaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelCargaMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x + xx, y + xy);
    }//GEN-LAST:event_panelCargaMouseDragged

    void setBackgroundColor(JPanel p){
        p.setBackground(new Color(254,87,34));
    }
    
    void resetBackgroundColor(JPanel p){
        p.setBackground(new Color(211,47,47));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_opcCaja;
    private javax.swing.JPanel btn_opcClientes;
    private javax.swing.JPanel btn_opcFacturar;
    private javax.swing.JPanel btn_opcPedidos;
    private javax.swing.JPanel btn_opcProductos;
    private javax.swing.JPanel btn_opcSalir;
    private javax.swing.JPanel btn_opcUsuarios;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_AppName;
    private javax.swing.JLabel lbl_Caja;
    private javax.swing.JLabel lbl_Clientes;
    private javax.swing.JLabel lbl_Clientes1;
    private javax.swing.JLabel lbl_Facturar;
    private javax.swing.JLabel lbl_Icon;
    private javax.swing.JLabel lbl_IconCaja;
    private javax.swing.JLabel lbl_IconClientes;
    private javax.swing.JLabel lbl_IconClientes1;
    private javax.swing.JLabel lbl_IconFacturar;
    private javax.swing.JLabel lbl_IconPedidos;
    private javax.swing.JLabel lbl_IconProductos;
    private javax.swing.JLabel lbl_IconUsuarios;
    private javax.swing.JLabel lbl_Pedidos;
    private javax.swing.JLabel lbl_Productos;
    private javax.swing.JLabel lbl_Usuario;
    private javax.swing.JLabel lbl_Usuarios;
    private javax.swing.JLabel lbl_Version;
    private javax.swing.JScrollPane panelCarga;
    private javax.swing.JPanel panel_SidePanel;
    // End of variables declaration//GEN-END:variables
}
