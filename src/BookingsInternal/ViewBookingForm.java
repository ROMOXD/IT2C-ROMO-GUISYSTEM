/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookingsInternal;

import UsersInternal.AddUserForm;
import config.dbConnector;
import java.awt.Color;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mark Kevin Romo
 */
public class ViewBookingForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewBookingForm
     */
    
    String destination = "";
    File selectedFile;
    String path = "";
    String oldpath = "";
     public ViewBookingForm() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        displayData();
        
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        Border margin = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        Border compound = BorderFactory.createCompoundBorder(line, margin);

    g_fn.setBorder(compound);
    g_ln.setBorder(compound);
    g_em.setBorder(compound);
    g_ag.setBorder(compound);
    g_cs.setBorder(compound);
    g_cng.setBorder(compound);
    roomComboBox.setBorder(compound);
        
        bkTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = bkTable.getSelectedRow();
                if (row >= 0) {
                    try {
                        String selectedID = bkTable.getValueAt(row, 0).toString();
                        dbConnector dbc = new dbConnector();
                        ResultSet rs = dbc.getData("SELECT * FROM tbl_bookings WHERE b_id = " + selectedID);
                        
                        AddUserForm auf = new AddUserForm();
                        if (rs.next()) {
                            g_fn.setText(rs.getString("g_fname"));
                            g_ln.setText(rs.getString("g_lname"));
                            g_em.setText(rs.getString("g_email"));
                            g_ag.setText(rs.getString("g_age"));
                            g_cs.setText(rs.getString("b_cash"));
                            g_cng.setText(rs.getString("b_change"));
                            image.setIcon(auf.ResizeImage(rs.getString("g_image"),null, image));
                            oldpath = rs.getString("g_image");
                            path = rs.getString("g_image");
                            destination = rs.getString("g_image");

                        String currentRoomId = rs.getString("rm_id");
                        loadRoomOptions(currentRoomId);

                            java.util.Date cinDate = rs.getDate("b_cin");
                            java.util.Date coutDate = rs.getDate("b_cout");
                            c_cin.setDate(cinDate);
                            c_cout.setDate(coutDate);
                        }
                        rs.close();
                    } catch (SQLException ex) {
                        System.out.println("Error retrieving booking data: " + ex.getMessage());
                    }
                }
            }
        });
    }

    
    public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT b_id, g_fname, rm_type FROM tbl_bookings");
            bkTable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

        }

    }
    
    private void loadRoomOptions(String currentRoomId) {
        try {
            dbConnector dbc = new dbConnector();
            roomComboBox.removeAllItems();

            ResultSet currentRs = dbc.getData("SELECT room_id, r_type, r_price, r_status FROM tbl_room WHERE room_id = '" + currentRoomId + "'");
            if (currentRs.next()) {
                String roomId = currentRs.getString("room_id");
                String roomType = currentRs.getString("r_type");
                double roomPrice = currentRs.getDouble("r_price");
                String roomStatus = currentRs.getString("r_status");

                String currentItem = roomId + ": " + roomType + " - ₱" + roomPrice + " - " + roomStatus + " (Current Room)";
                roomComboBox.addItem(currentItem);
                roomComboBox.setSelectedItem(currentItem);
            }
            currentRs.close();

            ResultSet rs = dbc.getData("SELECT room_id, r_type, r_price, r_status FROM tbl_room WHERE r_status = 'Vacant' AND room_id != '" + currentRoomId + "'");
            while (rs.next()) {
                String roomId = rs.getString("room_id");
                String roomType = rs.getString("r_type");
                double roomPrice = rs.getDouble("r_price");
                String roomStatus = rs.getString("r_status");

                String item = roomId + ": " + roomType + " - ₱" + roomPrice + " - " + roomStatus;
                roomComboBox.addItem(item);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading rooms: " + e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        g_fn = new javax.swing.JTextField();
        g_ln = new javax.swing.JTextField();
        g_ag = new javax.swing.JTextField();
        g_em = new javax.swing.JTextField();
        g_cs = new javax.swing.JTextField();
        g_cng = new javax.swing.JTextField();
        roomComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        c_cin = new com.toedter.calendar.JCalendar();
        c_cout = new com.toedter.calendar.JCalendar();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bkTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Guest Age:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Guest Last Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Guest First Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Guest Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cash:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Change:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        g_fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_fn.setEnabled(false);
        jPanel1.add(g_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 160, 30));

        g_ln.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_ln.setEnabled(false);
        g_ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_lnActionPerformed(evt);
            }
        });
        jPanel1.add(g_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 160, 30));

        g_ag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_ag.setEnabled(false);
        g_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_agActionPerformed(evt);
            }
        });
        jPanel1.add(g_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 120, 30));

        g_em.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_em.setEnabled(false);
        jPanel1.add(g_em, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 160, 30));

        g_cs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_cs.setEnabled(false);
        g_cs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_csActionPerformed(evt);
            }
        });
        jPanel1.add(g_cs, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 120, 30));

        g_cng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_cng.setEnabled(false);
        jPanel1.add(g_cng, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 120, 30));

        roomComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        roomComboBox.setEnabled(false);
        jPanel1.add(roomComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 380, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        c_cin.setDate(new java.util.Date(1744981158000L));
        c_cin.setEnabled(false);
        jPanel2.add(c_cin);
        c_cin.setBounds(20, 30, 200, 130);

        c_cout.setEnabled(false);
        jPanel2.add(c_cout);
        c_cout.setBounds(290, 30, 200, 130);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Check-Out:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(360, 10, 71, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Check-In:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(90, 10, 60, 17);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 510, 170));

        bkTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(bkTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 21, 300, 130));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        image.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(image);
        image.setBounds(10, 10, 280, 150);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 300, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1000, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void g_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g_lnActionPerformed

    private void g_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g_agActionPerformed

    private void g_csActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_csActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g_csActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bkTable;
    private com.toedter.calendar.JCalendar c_cin;
    private com.toedter.calendar.JCalendar c_cout;
    private javax.swing.JTextField g_ag;
    private javax.swing.JTextField g_cng;
    private javax.swing.JTextField g_cs;
    private javax.swing.JTextField g_em;
    private javax.swing.JTextField g_fn;
    private javax.swing.JTextField g_ln;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> roomComboBox;
    // End of variables declaration//GEN-END:variables
}
