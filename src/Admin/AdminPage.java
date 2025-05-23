/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import BookingsInternal.AddBookingForm;
import BookingsInternal.DeleteBookingForm;
import BookingsInternal.ManageBookings;
import BookingsInternal.UpdateBookingForm;
import BookingsInternal.ViewBookingForm;
import config.Session;
import MainPage.LoginPage;
import RoomsInternal.AddRoomForm;
import RoomsInternal.DeleteRoomForm;
import RoomsInternal.ManageRooms;
import RoomsInternal.UpdateRoomForm;
import RoomsInternal.ViewRoomForm;
import SelectToPrint.ManagePrints;
import UsersInternal.AddUserForm;
import UsersInternal.DeleteUserForm;
import UsersInternal.ManageUsers;
import UsersInternal.UpdateUserForm;
import UsersInternal.ViewUserForm;
import config.dbConnector;
import java.awt.Color;
import java.io.File;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Mark Kevin Romo
 */
public class AdminPage extends javax.swing.JFrame {

    /**
     * Creates new form HMPage
     */
    public AdminPage() {
        initComponents();
        this.setResizable(false);
         l_usersMouseClicked(null);
    }
    
    private boolean isFirstClick = true;
    
        String currentAction = "";
        Color hovercolor = new Color(255,255,255);
        Color button_hovercolor = new Color(240,240,240);
        Color exitcolor = new Color(0,0,153);
        Color foregroundcolor = new Color(0,0,0);
        Color exitforegroundcolor = new Color(255,255,255);
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        checkOut = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        acc_uname = new javax.swing.JLabel();
        l_pendings = new javax.swing.JLabel();
        l_users = new javax.swing.JLabel();
        l_bookings = new javax.swing.JLabel();
        l_rooms = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        l_print = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();
        button_add = new javax.swing.JLabel();
        button_update = new javax.swing.JLabel();
        button_delete = new javax.swing.JLabel();
        button_view = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(971, 426));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 0, 153));
        jPanel2.setLayout(null);

        checkOut.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkOut.setForeground(new java.awt.Color(255, 255, 255));
        checkOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkOut.setText("CHECK-OUT");
        checkOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkOutMouseClicked(evt);
            }
        });
        jPanel2.add(checkOut);
        checkOut.setBounds(0, 387, 240, 50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("SETTINGS");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel13);
        jLabel13.setBounds(0, 450, 240, 20);

        acc_uname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        acc_uname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(acc_uname);
        acc_uname.setBounds(110, 40, 120, 26);

        l_pendings.setBackground(new java.awt.Color(0, 0, 153));
        l_pendings.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_pendings.setForeground(new java.awt.Color(255, 255, 255));
        l_pendings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_pendings.setText("PENDINGS");
        l_pendings.setOpaque(true);
        l_pendings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_pendingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_pendingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_pendingsMouseExited(evt);
            }
        });
        jPanel2.add(l_pendings);
        l_pendings.setBounds(0, 330, 240, 50);

        l_users.setBackground(new java.awt.Color(0, 0, 153));
        l_users.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_users.setForeground(new java.awt.Color(255, 255, 255));
        l_users.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_users.setText("USERS");
        l_users.setOpaque(true);
        l_users.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                l_usersMouseMoved(evt);
            }
        });
        l_users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_usersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_usersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_usersMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                l_usersMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                l_usersMouseReleased(evt);
            }
        });
        jPanel2.add(l_users);
        l_users.setBounds(0, 100, 240, 60);

        l_bookings.setBackground(new java.awt.Color(0, 0, 153));
        l_bookings.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_bookings.setForeground(new java.awt.Color(255, 255, 255));
        l_bookings.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_bookings.setText("BOOKING'S");
        l_bookings.setOpaque(true);
        l_bookings.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                l_bookingsMouseMoved(evt);
            }
        });
        l_bookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_bookingsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_bookingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_bookingsMouseExited(evt);
            }
        });
        jPanel2.add(l_bookings);
        l_bookings.setBounds(0, 160, 240, 60);

        l_rooms.setBackground(new java.awt.Color(0, 0, 153));
        l_rooms.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_rooms.setForeground(new java.awt.Color(255, 255, 255));
        l_rooms.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_rooms.setText("ROOM'S");
        l_rooms.setOpaque(true);
        l_rooms.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                l_roomsMouseMoved(evt);
            }
        });
        l_rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_roomsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_roomsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_roomsMouseExited(evt);
            }
        });
        jPanel2.add(l_rooms);
        l_rooms.setBounds(0, 220, 240, 60);

        jPanel4.setBackground(new java.awt.Color(0, 0, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 240, 240)));
        jPanel4.setLayout(null);

        profile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(profile);
        profile.setBounds(10, 10, 70, 60);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(10, 10, 90, 80);

        l_print.setBackground(new java.awt.Color(0, 0, 153));
        l_print.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        l_print.setForeground(new java.awt.Color(255, 255, 255));
        l_print.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_print.setText("PRINT");
        l_print.setOpaque(true);
        l_print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_printMouseExited(evt);
            }
        });
        jPanel2.add(l_print);
        l_print.setBounds(0, 280, 240, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("LOGOUT");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel3);
        jLabel3.setBounds(0, 490, 240, 17);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 520));

        jPanel3.setBackground(new java.awt.Color(0, 0, 255));
        jPanel3.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ADMIN DASHBOARD");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(12, 26, 172, 21);

        minimize.setBackground(new java.awt.Color(0, 0, 255));
        minimize.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        minimize.setForeground(new java.awt.Color(255, 255, 255));
        minimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize.setText("—");
        minimize.setOpaque(true);
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        jPanel3.add(minimize);
        minimize.setBounds(780, 10, 41, 30);

        exit.setBackground(new java.awt.Color(0, 0, 255));
        exit.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit.setText("X");
        exit.setOpaque(true);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        jPanel3.add(exit);
        exit.setBounds(820, 10, 40, 30);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 870, 60));

        DesktopPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DesktopPaneMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        jPanel1.add(DesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 870, 390));

        button_add.setBackground(new java.awt.Color(255, 255, 255));
        button_add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_add.setText("ADD");
        button_add.setOpaque(true);
        button_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_addMouseExited(evt);
            }
        });
        jPanel1.add(button_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 230, 60));

        button_update.setBackground(new java.awt.Color(255, 255, 255));
        button_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_update.setText("UPDATE");
        button_update.setOpaque(true);
        button_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_updateMouseExited(evt);
            }
        });
        jPanel1.add(button_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 220, 60));

        button_delete.setBackground(new java.awt.Color(255, 255, 255));
        button_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_delete.setText("DELETE");
        button_delete.setOpaque(true);
        button_delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_deleteMouseExited(evt);
            }
        });
        jPanel1.add(button_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 60, 210, 60));

        button_view.setBackground(new java.awt.Color(255, 255, 255));
        button_view.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        button_view.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        button_view.setText("VIEW");
        button_view.setOpaque(true);
        button_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button_viewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button_viewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button_viewMouseExited(evt);
            }
        });
        jPanel1.add(button_view, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 210, 60));

        jPanel5.setBackground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 870, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkOutMouseClicked
        CheckOutPendings cop = new CheckOutPendings();
        cop.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_checkOutMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();

    if (sess.getUid() != 0) {
        acc_uname.setText(sess.getUsername());
        String imagePath = sess.getU_image();
        if (imagePath != null && !imagePath.isEmpty()) {
            File file = new File(imagePath);
            if (file.exists()) {
                AddUserForm auf = new AddUserForm();
                profile.setIcon(auf.ResizeImage(imagePath, null, profile));
                profile.setText("");
            } else {
                System.out.println("Image file not found: " + imagePath);
                setNoProfileText();
            }
        } else {
            System.out.println("No image set in session.");
            setNoProfileText();
        }
    } else {
        JOptionPane.showMessageDialog(null, "No Shortcut Allowed! Login First!");
        LoginPage mpg = new LoginPage();
        mpg.setVisible(true);
        this.dispose();
    }
}

private void setNoProfileText() {
    profile.setText("NO PROFILE");
    profile.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 11));
    profile.setHorizontalAlignment(SwingConstants.CENTER);
    profile.setIcon(null);
    
    }//GEN-LAST:event_formWindowActivated

    private void DesktopPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DesktopPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DesktopPaneMouseClicked

    private void button_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_updateMouseClicked
       DesktopPane.removeAll();
        DesktopPane.repaint();

        switch (currentAction) {
            case "user":    
            UpdateUserForm uuf = new UpdateUserForm();
            DesktopPane.add(uuf).setVisible(true);
            uuf.setCanSelectImage(false);  
            break;
            case "room":
            UpdateRoomForm urf = new UpdateRoomForm();
            DesktopPane.add(urf).setVisible(true);
            break;
            case "bookings":
            UpdateBookingForm ubf = new UpdateBookingForm();
            DesktopPane.add(ubf).setVisible(true);
            break;
            default:
            JOptionPane.showMessageDialog(null, "Please select a panel first (User, Room, or Bookings).");
            break;
        }
    }//GEN-LAST:event_button_updateMouseClicked

    private void button_deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_deleteMouseClicked
       DesktopPane.removeAll();
        DesktopPane.repaint();

        switch (currentAction) {
            case "user":
            DeleteUserForm duf = new DeleteUserForm();
            DesktopPane.add(duf).setVisible(true);
            break;
            case "room":
            DeleteRoomForm drf = new DeleteRoomForm();
            DesktopPane.add(drf).setVisible(true);
            break;
            case "bookings":
            DeleteBookingForm dbf = new DeleteBookingForm();
            DesktopPane.add(dbf).setVisible(true);
            break;
            default:
            JOptionPane.showMessageDialog(null, "Please select a panel first (User, Room, or Bookings).");
            break;
        }
    }//GEN-LAST:event_button_deleteMouseClicked

    private void button_viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_viewMouseClicked
      DesktopPane.removeAll();
        DesktopPane.repaint();

        switch (currentAction) {
            case "user":
            ViewUserForm vuf = new ViewUserForm();
            DesktopPane.add(vuf).setVisible(true);
            break;
            case "room":
            ViewRoomForm vrf = new ViewRoomForm();
            DesktopPane.add(vrf).setVisible(true);
            break;
            case "bookings":
            ViewBookingForm vbf = new ViewBookingForm();
            DesktopPane.add(vbf).setVisible(true);
            break;
            default:
            JOptionPane.showMessageDialog(null, "Please select a panel first (User, Room, or Bookings).");
            break;
        }
    }//GEN-LAST:event_button_viewMouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        AccountDetails acd = new AccountDetails();
        acd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel13MouseClicked

    private void l_pendingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_pendingsMouseClicked
        UserPendings usp = new UserPendings();
        usp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_l_pendingsMouseClicked

    private void l_usersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_usersMouseExited
        
    }//GEN-LAST:event_l_usersMouseExited

    private void l_usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_usersMouseClicked
        
        l_users.setBackground(hovercolor);
        l_users.setForeground(foregroundcolor);
        l_bookings.setBackground(exitcolor);
        l_bookings.setForeground(exitforegroundcolor);
        l_rooms.setBackground(exitcolor);
        l_rooms.setForeground(exitforegroundcolor);
        l_print.setBackground(exitcolor);
        l_print.setForeground(exitforegroundcolor);
        l_pendings.setBackground(exitcolor);
        l_pendings.setForeground(exitforegroundcolor);
        
        DesktopPane.removeAll();
        ManageUsers mu = new ManageUsers();
        DesktopPane.add(mu).setVisible(true);
        currentAction = "user";
    }//GEN-LAST:event_l_usersMouseClicked

    private void l_usersMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_usersMouseMoved
      
    }//GEN-LAST:event_l_usersMouseMoved

    private void l_bookingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_bookingsMouseExited
        
    }//GEN-LAST:event_l_bookingsMouseExited

    private void l_bookingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_bookingsMouseClicked
        
        l_users.setBackground(exitcolor);
        l_users.setForeground(exitforegroundcolor);
        l_bookings.setBackground(hovercolor);
        l_bookings.setForeground(foregroundcolor);
        l_rooms.setBackground(exitcolor);
        l_rooms.setForeground(exitforegroundcolor);
        l_print.setBackground(exitcolor);
        l_print.setForeground(exitforegroundcolor);
        l_pendings.setBackground(exitcolor);
        l_pendings.setForeground(exitforegroundcolor);
        
        DesktopPane.removeAll();
        ManageBookings mb = new ManageBookings();
        DesktopPane.add(mb).setVisible(true);
        currentAction = "bookings";
    }//GEN-LAST:event_l_bookingsMouseClicked

    private void l_bookingsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_bookingsMouseMoved
        
    }//GEN-LAST:event_l_bookingsMouseMoved

    private void l_roomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_roomsMouseExited
        
    }//GEN-LAST:event_l_roomsMouseExited

    private void l_roomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_roomsMouseClicked
        
        l_users.setBackground(exitcolor);
        l_users.setForeground(exitforegroundcolor);
        l_bookings.setBackground(exitcolor);
        l_bookings.setForeground(exitforegroundcolor);
        l_rooms.setBackground(hovercolor);
        l_rooms.setForeground(foregroundcolor);
        l_print.setBackground(exitcolor);
        l_print.setForeground(exitforegroundcolor);
        l_pendings.setBackground(exitcolor);
        l_pendings.setForeground(exitforegroundcolor);
        
        DesktopPane.removeAll();
        ManageRooms mr = new ManageRooms();
        DesktopPane.add(mr).setVisible(true);
        currentAction = "room";
        
    }//GEN-LAST:event_l_roomsMouseClicked

    private void l_roomsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_roomsMouseMoved
        
    }//GEN-LAST:event_l_roomsMouseMoved

    private void l_usersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_usersMouseEntered
        
    }//GEN-LAST:event_l_usersMouseEntered

    private void button_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addMouseClicked

        DesktopPane.removeAll();
        DesktopPane.repaint();

        switch (currentAction) {
            case "user":
            AddUserForm auf = new AddUserForm();
            DesktopPane.add(auf).setVisible(true);
            auf.i_select.setEnabled(true);
            auf.i_remove.setEnabled(false);
            break;
            case "room":
            AddRoomForm arf = new AddRoomForm();
            DesktopPane.add(arf).setVisible(true);
            break;
            case "bookings":
            AddBookingForm abf = new AddBookingForm();
            DesktopPane.add(abf).setVisible(true);
            break;
            default:
            JOptionPane.showMessageDialog(null, "Please select a panel first (User, Room, or Bookings).");
            break;
        }
    }//GEN-LAST:event_button_addMouseClicked

    private void l_usersMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_usersMousePressed
        
    }//GEN-LAST:event_l_usersMousePressed

    private void l_usersMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_usersMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_l_usersMouseReleased

    private void button_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addMouseEntered
        button_add.setBackground(button_hovercolor);
        
    }//GEN-LAST:event_button_addMouseEntered

    private void button_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_addMouseExited
       button_add.setBackground(hovercolor);
       
    }//GEN-LAST:event_button_addMouseExited

    private void l_printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_printMouseClicked
        ManagePrints mp = new ManagePrints();
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_l_printMouseClicked

    private void button_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_updateMouseEntered
        button_update.setBackground(button_hovercolor);
    }//GEN-LAST:event_button_updateMouseEntered

    private void button_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_updateMouseExited
        button_update.setBackground(hovercolor);
    }//GEN-LAST:event_button_updateMouseExited

    private void button_deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_deleteMouseExited
        button_delete.setBackground(hovercolor);
    }//GEN-LAST:event_button_deleteMouseExited

    private void button_viewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_viewMouseExited
        button_view.setBackground(hovercolor);
    }//GEN-LAST:event_button_viewMouseExited

    private void button_deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_deleteMouseEntered
        button_delete.setBackground(button_hovercolor);
    }//GEN-LAST:event_button_deleteMouseEntered

    private void button_viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_viewMouseEntered
        button_view.setBackground(button_hovercolor);
    }//GEN-LAST:event_button_viewMouseEntered

    private void l_bookingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_bookingsMouseEntered
        
    }//GEN-LAST:event_l_bookingsMouseEntered

    private void l_roomsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_roomsMouseEntered
        
    }//GEN-LAST:event_l_roomsMouseEntered

    private void l_printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_printMouseEntered
        
    }//GEN-LAST:event_l_printMouseEntered

    private void l_pendingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_pendingsMouseEntered
        
    }//GEN-LAST:event_l_pendingsMouseEntered

    private void l_printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_printMouseExited
        
    }//GEN-LAST:event_l_printMouseExited

    private void l_pendingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_pendingsMouseExited
        
    }//GEN-LAST:event_l_pendingsMouseExited

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        dbConnector dbc = new dbConnector();
    Session sess = Session.getInstance();
    
    String action = "Logged Out from the System";
    dbc.insertData("INSERT INTO tbl_logs (usr_id, l_actions, l_date) VALUES ('"+sess.getUid()+"', '"+action+"', '"+LocalDateTime.now()+"' ) ");
        
        System.exit(0);                                
    }//GEN-LAST:event_exitMouseClicked

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseEntered
        exit.setBackground(new java.awt.Color(240,240,240));
        exit.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_exitMouseEntered

    private void exitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseExited
        exit.setBackground(new java.awt.Color(0,0,255));
        exit.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_exitMouseExited

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseEntered
        minimize.setBackground(new java.awt.Color(240,240,240));
        minimize.setForeground(new java.awt.Color(0,0,0));
        
    }//GEN-LAST:event_minimizeMouseEntered

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseExited
        minimize.setBackground(new java.awt.Color(0,0,255));
        minimize.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_minimizeMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        dbConnector dbc = new dbConnector();
         Session sess = Session.getInstance();
         
    String action = "Logged Out from the System";
    dbc.insertData("INSERT INTO tbl_logs (usr_id, l_actions, l_date) VALUES ('"+sess.getUid()+"', '"+action+"', '"+LocalDateTime.now()+"' ) ");
        
        LoginPage mpg = new LoginPage();
        mpg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JLabel acc_uname;
    private javax.swing.JLabel button_add;
    private javax.swing.JLabel button_delete;
    private javax.swing.JLabel button_update;
    private javax.swing.JLabel button_view;
    private javax.swing.JLabel checkOut;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel l_bookings;
    private javax.swing.JLabel l_pendings;
    private javax.swing.JLabel l_print;
    private javax.swing.JLabel l_rooms;
    private javax.swing.JLabel l_users;
    private javax.swing.JLabel minimize;
    public javax.swing.JLabel profile;
    // End of variables declaration//GEN-END:variables
}
