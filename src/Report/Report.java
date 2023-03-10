/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.*;
import java.awt.print.*;
import java.io.File;
import javax.swing.JTable;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Wandana
 */
public class Report extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn = config.koneksidb.getKoneksi();
    JasperReport JasRep;
    JasperPrint JasPri;
    Map param = new HashMap();
    JasperDesign JasDes;
    /**
     * Creates new form Report
     */
    public Report() {
        initComponents(); 
        judul();
        tampilData();
        setLocationRelativeTo(null);
    }
    public void judul() {
        Object[] judul = {"NO FAKTUR", "TANGGAL", "ID CUSTOMER", "NAMA CUSTOMER", "NO PLAT", "NO RANGKA","TIPE MOTOR", "BIAYA"};
        tabModel = new DefaultTableModel(null, judul);
        TBservice.setModel(tabModel);
    }
    
        public void tampilData(){
        try {
            
           st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            rs = st.executeQuery("SELECT service.no_faktur, service.tgl_service, customer.id_customer, customer.nama, motor.no_plat, motor.no_rangka, motor.tipe, service.biaya FROM service JOIN customer ON service.id_customer = customer.id_customer JOIN motor ON service.no_plat = motor.no_plat");
            while (rs.next()) {
                Object[] data = {
                   rs.getString("service.no_faktur"),
                   rs.getString("service.tgl_service"),
                   rs.getString("customer.id_customer"),
                   rs.getString("customer.nama"),
                   rs.getString("motor.no_plat"),
                   rs.getString("motor.no_rangka"),
                   rs.getString("motor.tipe"),
                   rs.getString("service.biaya")
                };
                tabModel.addRow(data);
            }
        } catch (Exception e) {
          e.printStackTrace();  
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Bpreview = new javax.swing.JButton();
        Bcustomer = new javax.swing.JButton();
        Bmotor = new javax.swing.JButton();
        Bservice = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBservice = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel1.setText("LAPORAN HARIAN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 160, 40));

        Bpreview.setText("PREVIEW");
        Bpreview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BpreviewActionPerformed(evt);
            }
        });
        getContentPane().add(Bpreview, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 100, 30));

        Bcustomer.setText("DATA CUSTOMER");
        Bcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcustomerActionPerformed(evt);
            }
        });
        getContentPane().add(Bcustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 140, 30));

        Bmotor.setText("DATA MOTOR");
        Bmotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BmotorActionPerformed(evt);
            }
        });
        getContentPane().add(Bmotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 140, 30));

        Bservice.setText("DATA SERVICE");
        Bservice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BserviceActionPerformed(evt);
            }
        });
        getContentPane().add(Bservice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 140, 30));

        jLabel2.setFont(new java.awt.Font("Lucida Calligraphy", 0, 24)); // NOI18N
        jLabel2.setText("LAPORAN BENGKEL SERVICE MAGER GENG");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 630, 40));

        TBservice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TBservice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBserviceMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBservice);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 820, 340));

        jLabel3.setText("Tanggal");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 60, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BpreviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BpreviewActionPerformed
       try { 
        JasDes = JRXmlLoader.load(getClass().getResourceAsStream("reportParameterTanggal.jrxml"));
        param.put("tgl", new SimpleDateFormat("yyyy-MM-dd").format(DTtgl.getDate()));
        JasRep = JasperCompileManager.compileReport(JasDes);
        JasPri = JasperFillManager.fillReport(JasRep, param, cn);
        JasperViewer.viewReport(JasPri, false);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_BpreviewActionPerformed

    private void BcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcustomerActionPerformed
        try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportCustomer.jasper"), null, cn);
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_BcustomerActionPerformed

    private void BmotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BmotorActionPerformed
        try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportMotor.jasper"), null, cn);
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_BmotorActionPerformed

    private void BserviceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BserviceActionPerformed
       try {
        JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("reportService.jasper"), null, cn);
        JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_BserviceActionPerformed

    private void TBserviceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBserviceMouseClicked

    }//GEN-LAST:event_TBserviceMouseClicked

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
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcustomer;
    private javax.swing.JButton Bmotor;
    private javax.swing.JButton Bpreview;
    private javax.swing.JButton Bservice;
    private javax.swing.JTable TBservice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
