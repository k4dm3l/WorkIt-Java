package Logic;
/**
 *
 * @author Camilo
 */

import br.com.adilson.util.Extenso;
import br.com.adilson.util.PrinterMatrix;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TicketsPrint {
    
    public static TicketsPrint tp;
    
    private TicketsPrint(){
        
    }
    
    public static TicketsPrint getInstance(){
        if(tp == null){
            tp = new TicketsPrint();
        }
        return tp;
    }
    
    public void printCloseBoxTicket(String idApertura, String fecApertura, String saldoApertura, String pedAbiertos, String ventasRealizadas, String totalVentas, String totalCierre, String fechaCierre){
        try{
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();
            DecimalFormat formatNumber = new DecimalFormat("#.###");
            
            e.setNumber(20.30);
            int tamano = 41;
            printer.setOutSize(tamano, 80);
            
            printer.printTextWrap(0, 1, 5, 80, "===================================================================");
            printer.printTextWrap(1, 1, 35, 80, "CARNIVOROS"); //Nombre establecimiento
            printer.printTextWrap(3, 1, 31, 80, "Barrio Bellavista"); //Barrio
            printer.printTextWrap(4, 1, 37, 80, "Clle 47"); //Direccion
            printer.printTextWrap(5, 1, 38, 80, "12345"); //Codigo Postal
            
            String ia = printer.alinharADireita(10, idApertura);
            printer.printTextWrap(7, 1, 5, 80, "Id Apertura Caja: ");
            printer.printTextWrap(7, 1, 35, 80, ia);
            
            String fa = printer.alinharADireita(10, fecApertura);
            printer.printTextWrap(8, 1, 5, 80, "Fecha Apertura Caja: ");
            printer.printTextWrap(8, 1, 35, 80, fa);
                        
            String pa = printer.alinharADireita(10, pedAbiertos);
            printer.printTextWrap(9, 1, 5, 80, "Pedidos Abiertos: ");
            printer.printTextWrap(9, 1, 35, 80, pa);
            
            String vr = printer.alinharADireita(10, ventasRealizadas);
            printer.printTextWrap(10, 1, 5, 80, "Ventas Realizadas: ");
            printer.printTextWrap(10, 1, 35, 80, vr);
            
            String cc = printer.alinharADireita(10, idApertura);
            printer.printTextWrap(11, 1, 5, 80, "Id Cierre Caja: ");
            printer.printTextWrap(11, 1, 35, 80, cc);
            
            String sa = printer.alinharADireita(10, saldoApertura);
            printer.printTextWrap(12, 1, 5, 80, "Saldo Apertura Caja: ");
            printer.printTextWrap(12, 1, 35, 80, "$ "+sa);
            
            String tv = printer.alinharADireita(10, totalVentas);
            printer.printTextWrap(13, 1, 5, 80, "Total Ventas: ");
            printer.printTextWrap(13, 1, 35, 80, "$ "+tv);
            
            String tc = printer.alinharADireita(10, totalCierre);
            printer.printTextWrap(14, 1, 5, 80, "Total Cierre: ");
            printer.printTextWrap(14, 1, 35, 80, "$ "+tc);
            
            String fc = printer.alinharADireita(10, fechaCierre);
            printer.printTextWrap(15, 1, 5, 80, "Fecha Cierre Caja: ");
            printer.printTextWrap(15, 1, 35, 80, fc);
            
            printer.printTextWrap(16, 1, 5, 80, "——————————–——————————–——————————–——————————–——–———–——–—–———–——–———");
            printer.printTextWrap(17, 1, 26,80, "!Gracias por su preferencia!");
            printer.printTextWrap(18, 1, 30, 80, "WorkIt App - v1.2.9");
            printer.printTextWrap(19, 1, 31, 80, "Software a Medida");
            printer.printTextWrap(20, 1, 23, 80, "Contacto: ignitedevsoft@gmail.com");
            printer.printTextWrap(21, 1, 5,80, "===================================================================");
            
            printer.toFile("src/CierresCaja/CierreCaja_"+idApertura+".txt");
            FileInputStream inputStream = null;
            
            try{
                inputStream = new FileInputStream("src/CierresCaja/CierreCaja_"+idApertura+".txt");
            } catch(FileNotFoundException fe){
                fe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: "+fe.getMessage(), "Error Almacenamiento Archivo", JOptionPane.ERROR_MESSAGE);
            }
            
            if(inputStream == null){
                return;
            }
            
            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            
            if(defaultPrintService != null){
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try{
                    printJob.print(document, attributeSet);
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna impresora instalada", "Error Impresion Ticket", JOptionPane.ERROR_MESSAGE);
            }
            
            inputStream.close();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error Impresion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void printOpenBoxTicket(JTable tbl_AperCaja){
        try{
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();
            DecimalFormat formatNumber = new DecimalFormat("#.###");
            
            e.setNumber(20.30);
            
            int tamano = 41;
            printer.setOutSize(tamano, 80);
            
            printer.printTextWrap(0, 1, 5, 80, "===================================================================");
            printer.printTextWrap(1, 1, 35, 80, "CARNIVOROS"); //Nombre establecimiento
            printer.printTextWrap(3, 1, 31, 80, "Barrio Bellavista"); //Barrio
            printer.printTextWrap(4, 1, 37, 80, "Clle 47"); //Direccion
            printer.printTextWrap(5, 1, 38, 80, "12345"); //Codigo Postal
            printer.printTextWrap(6, 1, 10, 30, "Id Apertura: "+tbl_AperCaja.getValueAt(0, 0).toString()); //Aqui va la fecha de recibo
            printer.printTextWrap(6, 1, 33, 59, "Saldo Apertura: $"+tbl_AperCaja.getValueAt(0, 1).toString()); //Aqui va la hora de recibo
            printer.printTextWrap(6, 1, 63, 80, "Fecha Apertura: "+tbl_AperCaja.getValueAt(0, 1).toString()); //Aqui va la hora de recibo
            
            printer.printTextWrap(8, 1, 5, 80, "——————————–——————————–——————————–——————————–——–———–——–—–———–——–———");
            printer.printTextWrap(9, 1, 26,80, "!Gracias por su preferencia!");
            printer.printTextWrap(10, 1, 30, 80, "WorkIt App - v1.2.9");
            printer.printTextWrap(11, 1, 31, 80, "Software a Medida");
            printer.printTextWrap(12, 1, 23, 80, "Contacto: ignitedevsoft@gmail.com");
            printer.printTextWrap(13, 1, 5,80, "===================================================================");
            
            printer.toFile("src/AperturasCaja/AperturaCaja_"+tbl_AperCaja.getValueAt(0, 0).toString()+".txt");
            FileInputStream inputStream = null;
            
            try{
                inputStream = new FileInputStream("src/AperturasCaja/AperturaCaja_"+tbl_AperCaja.getValueAt(0, 0).toString()+".txt");
            } catch(FileNotFoundException fe){
                fe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: "+fe.getMessage(), "Error Almacenamiento Archivo", JOptionPane.ERROR_MESSAGE);
            }
            
            if(inputStream == null){
                return;
            }
            
            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            
            if(defaultPrintService != null){
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try{
                    printJob.print(document, attributeSet);
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna impresora instalada", "Error Impresion Ticket", JOptionPane.ERROR_MESSAGE);
            }
            
            inputStream.close();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error Impresion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void printBillTicket(JTable tbl_Pedido, String idPedido, String fechaPedido, String nomCajero, String idCliente, String nomCliente, String items, String totalPedido, String dineroRec, String dineroDev){
        try{
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();
            DecimalFormat formatNumber = new DecimalFormat("#.###");
            
            e.setNumber(20.30);
            
            int filas = tbl_Pedido.getRowCount();
            int tamano = filas+40;
            printer.setOutSize(tamano, 80);
            
            printer.printTextWrap(0, 1, 5, 80, "===================================================================");
            printer.printTextWrap(1, 1, 35, 80, "CARNIVOROS"); //Nombre establecimiento
            printer.printTextWrap(3, 1, 31, 80, "Barrio Bellavista"); //Barrio
            printer.printTextWrap(4, 1, 37, 80, "Clle 47"); //Direccion
            printer.printTextWrap(5, 1, 38, 80, "12345"); //Codigo Postal
            printer.printTextWrap(6, 1, 10, 41, "Fecha: "+fechaPedido); //Aqui va la fecha de recibo
            printer.printTextWrap(6, 1, 38, 80, "Items: "+items); //Aqui va la hora de recibo
            printer.printTextWrap(7, 1, 3, 40, "Numero Pedido: "+idPedido); //Numero del recibo - PEDIDO
            printer.printTextWrap(7, 1, 42, 80, "Numero Factura: 000"+idPedido); //Numero del recibo - PEDIDO
            printer.printTextWrap(8, 1, 3, 80, "Atiende: "+nomCajero); //Nombre Cajero
            printer.printTextWrap(9, 1, 3, 40, "Cliente: "+nomCliente);//Nombre del Cliente
            printer.printTextWrap(9, 1, 42, 80, "Id Cliente: "+idCliente);//Identificacion del Cliente
            printer.printTextWrap(10,1, 5, 80, "——————————–——————————–——————————–——————————–——–———–——–—–———–——–———");
            printer.printTextWrap(11,1, 7, 80, "ID   DESCRIPCION            PRECIO UND           CANT        TOTAL");
            printer.printTextWrap(12,1, 0, 80, " ");
            
            for(int i = 0; i < filas; i++){
                int p = 13+i;
                
                printer.printTextWrap(p, 1, 7, 10, tbl_Pedido.getValueAt(i, 0).toString());
                printer.printTextWrap(p, 1, 12, 35, tbl_Pedido.getValueAt(i, 1).toString());
                printer.printTextWrap(p, 1, 39, 46, tbl_Pedido.getValueAt(i, 2).toString());
                printer.printTextWrap(p, 1, 57, 61, tbl_Pedido.getValueAt(i, 3).toString());
                
                String pre = printer.alinharADireita(10, tbl_Pedido.getValueAt(i, 4).toString());
                printer.printTextWrap(p, 1, 63, 80, pre);
            }
            
            String dr = printer.alinharADireita(10, dineroRec);
            printer.printTextWrap(filas+17, 1, 5, 80, "Dinero Recibido: $");
            printer.printTextWrap(filas+17, 1, 25, 80, dr);
            
            String tp = printer.alinharADireita(10, totalPedido);
            printer.printTextWrap(filas+18, 1, 5, 80, "Total Pedido: $");
            printer.printTextWrap(filas+18, 1, 25, 80, tp);
            
            String dd = printer.alinharADireita(10, dineroDev);
            printer.printTextWrap(filas+19, 1, 5, 80, "Devuelta: $");
            printer.printTextWrap(filas+19, 1, 25, 80, dd);
            
            printer.printTextWrap(filas+21, 1, 5, 80, "——————————–——————————–——————————–——————————–——–———–——–—–———–——–———");
            printer.printTextWrap(filas+22, 1, 26,80, "!Gracias por su preferencia!");
            printer.printTextWrap(filas+23, 1, 30, 80, "WorkIt App - v1.2.9");
            printer.printTextWrap(filas+24, 1, 31, 80, "Software a Medida");
            printer.printTextWrap(filas+25, 1, 23, 80, "Contacto: ignitedevsoft@gmail.com");
            printer.printTextWrap(filas+26, 1, 5,80, "===================================================================");
            
            printer.toFile("src/FacturasVentas/Factura_000"+idPedido+".txt");
            FileInputStream inputStream = null;
            
            try{
                inputStream = new FileInputStream("src/FacturasVentas/Factura_000"+idPedido+".txt");
            } catch(FileNotFoundException fe){
                fe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: "+fe.getMessage(), "Error Almacenamiento Archivo", JOptionPane.ERROR_MESSAGE);
            }
            
            if(inputStream == null){
                return;
            }
            
            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            
            if(defaultPrintService != null){
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try{
                    printJob.print(document, attributeSet);
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna impresora instalada", "Error Impresion Ticket", JOptionPane.ERROR_MESSAGE);
            }
            
            inputStream.close();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error Impresion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void printOrderTicket(JTable tbl_Pedido, String idPedido, String fechaPedido, String nomCajero, String nomCliente, String items, String totalPedido){
        try{
            PrinterMatrix printer = new PrinterMatrix();
            Extenso e = new Extenso();
            DecimalFormat formatNumber = new DecimalFormat("#.###");
            
            e.setNumber(20.30);
            
            int filas = tbl_Pedido.getRowCount();
            int tamano = filas+40;
            printer.setOutSize(tamano, 80);
            
            printer.printTextWrap(0, 1, 5, 80, "===================================================================");
            printer.printTextWrap(1, 1, 35, 80, "CARNIVOROS"); //Nombre establecimiento
            printer.printTextWrap(3, 1, 31, 80, "Barrio Bellavista"); //Barrio
            printer.printTextWrap(4, 1, 37, 80, "Clle 47"); //Direccion
            printer.printTextWrap(5, 1, 38, 80, "12345"); //Codigo Postal
            printer.printTextWrap(6, 1, 10, 41, "Fecha: "+fechaPedido); //Aqui va la fecha de recibo
            printer.printTextWrap(6, 1, 38, 80, "Items: "+items); //Aqui va la hora de recibo
            printer.printTextWrap(7, 1, 3, 80, "Numero Pedido: "+idPedido); //Numero del recibo - FACTURA O PEDIDO
            printer.printTextWrap(8, 1, 3, 80, "Atiende: "+nomCajero); //Nombre Cajero
            printer.printTextWrap(9, 1, 3, 80, "Cliente: "+nomCliente);//Nombre del Cliente
            printer.printTextWrap(10,1, 5, 80, "——————————–——————————–——————————–——————————–——–———–——–—–———–——–———");
            printer.printTextWrap(11,1, 7, 80, "ID   DESCRIPCION            PRECIO UND           CANT        TOTAL");
            printer.printTextWrap(12,1, 0, 80, " ");
            
            for(int i = 0; i < filas; i++){
                int p = 13+i;
                
                printer.printTextWrap(p, 1, 7, 10, tbl_Pedido.getValueAt(i, 0).toString());
                printer.printTextWrap(p, 1, 12, 35, tbl_Pedido.getValueAt(i, 1).toString());
                printer.printTextWrap(p, 1, 39, 46, tbl_Pedido.getValueAt(i, 2).toString());
                printer.printTextWrap(p, 1, 57, 61, tbl_Pedido.getValueAt(i, 3).toString());
                
                String pre = printer.alinharADireita(10, tbl_Pedido.getValueAt(i, 4).toString());
                printer.printTextWrap(p, 1, 63, 80, pre);
            }
            
            String tp = printer.alinharADireita(10, totalPedido);
            printer.printTextWrap(filas+17, 1, 5, 80, "Total Pedido: ");
            printer.printTextWrap(filas+17, 1, 20, 80, tp);
            
            printer.printTextWrap(filas+21, 1, 5, 80, "——————————–——————————–——————————–——————————–——–———–——–—–———–——–———");
            printer.printTextWrap(filas+22, 1, 26,80, "!Gracias por su preferencia!");
            printer.printTextWrap(filas+23, 1, 30, 80, "WorkIt App - v1.2.9");
            printer.printTextWrap(filas+24, 1, 31, 80, "Software a Medida");
            printer.printTextWrap(filas+25, 1, 23, 80, "Contacto: ignitedevsoft@gmail.com");
            printer.printTextWrap(filas+26, 1, 5,80, "===================================================================");
            
            printer.toFile("src/Pedidos/Pedido_"+idPedido+".txt");
            FileInputStream inputStream = null;
            
            try{
                inputStream = new FileInputStream("src/Pedidos/Pedido_"+idPedido+".txt");
            } catch(FileNotFoundException fe){
                fe.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: "+fe.getMessage(), "Error Almacenamiento Archivo", JOptionPane.ERROR_MESSAGE);
            }
            
            if(inputStream == null){
                return;
            }
            
            DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
            Doc document = new SimpleDoc(inputStream, docFormat, null);
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();
            
            if(defaultPrintService != null){
                DocPrintJob printJob = defaultPrintService.createPrintJob();
                try{
                    printJob.print(document, attributeSet);
                } catch(Exception ex){
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna impresora instalada", "Error Impresion Ticket", JOptionPane.ERROR_MESSAGE);
            }
            
            inputStream.close();
            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage(), "Error Impresion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
