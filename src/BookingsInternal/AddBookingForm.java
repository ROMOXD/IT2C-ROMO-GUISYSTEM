/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookingsInternal;

import Admin.AdminPage;
import static MainPage.RegistrationForm.email;
import User.UserPage;
import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Mark Kevin Romo
 */
public class AddBookingForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddBookingForm
     */
    public AddBookingForm() {
        initComponents();
         this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        loadVacantRooms();
        
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
    
    g_cng.setEditable(false);

    g_cs.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) {
            updateChange();
        }

        public void removeUpdate(DocumentEvent e) {
            updateChange();
        }

        public void changedUpdate(DocumentEvent e) {
            updateChange();
        }
    });
    
    

        
    }
    
     Color hovercolor = new Color(255,255,255);
     Color exitcolor = new Color(0,0,153);
     Color foregroundcolor = new Color(0,0,0);
     Color exitforegroundcolor = new Color(255,255,255);
    
    private boolean canSelectImage = true;
    
    public String destination= "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/UserImages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
    try {
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);
        
        if (image == null) {
            throw new IOException("The image could not be loaded.");
        }
    int originalWidth = image.getWidth();
    int originalHeight = image.getHeight();
        if (originalWidth == 0) {
            return -1;
        }
        int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
        return newHeight;
    } catch (IOException ex) {
        System.err.println("Error: " + ex.getMessage());
    }
    return -1;
}
    
     public ImageIcon ResizeImage(String imagePath, byte[] pic, JLabel label) {
    ImageIcon myImage = null;

    try {
        if (imagePath != null && !imagePath.isEmpty()) {
            myImage = new ImageIcon(imagePath);
        } else if (pic != null && pic.length > 0) {
            myImage = new ImageIcon(pic);
        } else {
            System.err.println("Error: No image source provided.");
            return null;
        }

        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();

        if (labelWidth == 0 || labelHeight == 0) {
            System.err.println("Error: Label dimensions are zero.");
            return null;
        }

        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);

    } catch (Exception ex) {
        ex.printStackTrace();
        return null;
    }
}
    
    public void loadVacantRooms() {
        try {
            dbConnector dbc = new dbConnector();
           String query = "SELECT room_id, r_type, r_price, r_status FROM tbl_room WHERE r_status = 'Vacant'";
ResultSet rs = dbc.getData(query);

roomComboBox.removeAllItems();

while (rs.next()) {
    String id = rs.getString("room_id");
    String type = rs.getString("r_type");
    String price = rs.getString("r_price");
    String status = rs.getString("r_status");
    String display = id + ": " + type + " - ₱" + price + " - " + status;
    roomComboBox.addItem(display);
}

            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error loading vacant rooms: " + ex.getMessage());
        }
    }
    
    public boolean duplicateCheck(){
    
    dbConnector dbc = new dbConnector();
    
    try{
    String query = "SELECT * FROM tbl_bookings WHERE g_email = '" +g_em.getText()+"'";
    ResultSet resultSet = dbc.getData(query);
    
    
    if(resultSet.next()){
    email=resultSet.getString("g_email");
    
    if(email.equals(g_em.getText())){
    JOptionPane.showMessageDialog(null, "Email Already Existed!");
    g_em.setText("");
    }
    
    return true;
    }else{
    return false;
    }
    
    }catch(SQLException ex){
        System.out.println(""+ex);
        return false;
    }
    
    
    }
    
    private boolean validateInputs() {
       if (g_fn.getText().isEmpty() || g_ln.getText().isEmpty() || g_ag.getText().isEmpty() ||
        g_em.getText().isEmpty() ||  g_cs.getText().isEmpty() ||
               c_cin.getDate() == null || c_cout.getDate() == null) {

        JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
        return false;
    }

    if (g_fn.getText().matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Guest first name should not contain numbers.");
        return false;
    }

    if (g_ln.getText().matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Guest last name should not contain numbers.");
        return false;
    }

    try {
        int age = Integer.parseInt(g_ag.getText());
        if (age <= 18) {
            JOptionPane.showMessageDialog(this, "Age must be greater or equal to 18.");
            return false;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Age must be a valid number.");
        return false;
    }

    try {
        double cash = Double.parseDouble(g_cs.getText());
        if (cash <= 0) {
            JOptionPane.showMessageDialog(this, "Cash must be greater than 0.");
            return false;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Cash must be a valid number.");
        return false;
    }

    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
    if (!g_em.getText().matches(emailRegex)) {
        JOptionPane.showMessageDialog(this, "Invalid email format.");
        return false;
    }
    
    if (duplicateCheck()) {
        System.out.println("Duplicate Exist");
        return false;
    }

    Date checkInDate = c_cin.getDate();
    Date checkOutDate = c_cout.getDate();
    if (checkOutDate.compareTo(checkInDate) <=0) {
        JOptionPane.showMessageDialog(this, "Check-Out date must be after Check-In date.");
        return false;
    }

    if (roomComboBox.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Please select a room.");
        return false;
    }

    return true;
    }
    
    private void updateChange() {
    try {
        String selectedItem = (String) roomComboBox.getSelectedItem();
        if (selectedItem == null || selectedItem.isEmpty()) {
            g_cng.setText("0.00");
            return;
        }

        String roomId = selectedItem.split(":")[0].trim();

        dbConnector dbc = new dbConnector();
        ResultSet rs = dbc.getData("SELECT r_price FROM tbl_room WHERE room_id = '" + roomId + "'");
        if (rs.next()) {
            double price = rs.getDouble("r_price");
            double cash = Double.parseDouble(g_cs.getText());
            double change = cash >= price ? cash - price : 0;
            g_cng.setText(String.format("%.2f", change));
        } else {
            g_cng.setText("0.00");
        }
        rs.close();
    } catch (Exception e) {
        g_cng.setText("0.00");
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
        add_button = new javax.swing.JLabel();
        c_all = new javax.swing.JLabel();
        roomComboBox = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        c_cout = new com.toedter.calendar.JCalendar();
        c_cin = new com.toedter.calendar.JCalendar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        i_select = new javax.swing.JLabel();
        i_remove = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Guest Age:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Guest Last Name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Guest First Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Guest Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cash:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Change:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, -1, -1));

        g_fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g_fnKeyTyped(evt);
            }
        });
        jPanel1.add(g_fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 160, 30));

        g_ln.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_lnActionPerformed(evt);
            }
        });
        g_ln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g_lnKeyTyped(evt);
            }
        });
        jPanel1.add(g_ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, 30));

        g_ag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_agActionPerformed(evt);
            }
        });
        g_ag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g_agKeyTyped(evt);
            }
        });
        jPanel1.add(g_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 110, 30));

        g_em.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(g_em, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 160, 30));

        g_cs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_cs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_csActionPerformed(evt);
            }
        });
        g_cs.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g_csKeyTyped(evt);
            }
        });
        jPanel1.add(g_cs, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 110, 30));

        g_cng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_cng.setEnabled(false);
        jPanel1.add(g_cng, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 110, 30));

        add_button.setBackground(new java.awt.Color(0, 0, 153));
        add_button.setForeground(new java.awt.Color(255, 255, 255));
        add_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add_button.setText("Add");
        add_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add_button.setOpaque(true);
        add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_buttonMouseExited(evt);
            }
        });
        jPanel1.add(add_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 110, 40));

        c_all.setBackground(new java.awt.Color(0, 0, 153));
        c_all.setForeground(new java.awt.Color(255, 255, 255));
        c_all.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        c_all.setText("Clear All");
        c_all.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        c_all.setOpaque(true);
        c_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_allMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                c_allMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                c_allMouseExited(evt);
            }
        });
        jPanel1.add(c_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 110, 40));

        roomComboBox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(roomComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 260, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        c_cout.setDate(new java.util.Date(1747793653000L));
        jPanel2.add(c_cout);
        c_cout.setBounds(270, 30, 200, 130);

        c_cin.setDate(new java.util.Date(1747793653000L));
        jPanel2.add(c_cin);
        c_cin.setBounds(30, 30, 200, 130);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Check-In:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(100, 10, 60, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Check-Out:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(340, 10, 71, 17);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 500, 170));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        image.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(image);
        image.setBounds(10, 10, 300, 290);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 320, 310));

        i_select.setBackground(new java.awt.Color(0, 0, 153));
        i_select.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        i_select.setForeground(new java.awt.Color(255, 255, 255));
        i_select.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        i_select.setText("Select");
        i_select.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        i_select.setOpaque(true);
        i_select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                i_selectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                i_selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                i_selectMouseExited(evt);
            }
        });
        jPanel1.add(i_select, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 140, 40));

        i_remove.setBackground(new java.awt.Color(0, 0, 153));
        i_remove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        i_remove.setForeground(new java.awt.Color(255, 255, 255));
        i_remove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        i_remove.setText("Remove");
        i_remove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        i_remove.setOpaque(true);
        i_remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                i_removeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                i_removeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                i_removeMouseExited(evt);
            }
        });
        jPanel1.add(i_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 140, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 910, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void g_agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g_agActionPerformed

    private void g_csActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_csActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g_csActionPerformed

    private void g_lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g_lnActionPerformed

    private void add_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseClicked
     if (!validateInputs()) {
    return;
}

try {
    dbConnector dbc = new dbConnector();

    String selectedItem = roomComboBox.getSelectedItem().toString();
    String selectedRoomId = selectedItem.split(":")[0].trim();

    ResultSet rs = dbc.getData("SELECT r_type, r_price FROM tbl_room WHERE room_id = '" + selectedRoomId + "'");
    if (!rs.next()) {
        JOptionPane.showMessageDialog(this, "Selected room is no longer available.");
        return;
    }

    String roomType = rs.getString("r_type");
        double roomPrice = rs.getDouble("r_price");
    rs.close();
        double cash = Double.parseDouble(g_cs.getText());
        double change = cash - roomPrice;
    if (change < 0) {
        JOptionPane.showMessageDialog(this, "Cash provided is not enough for the booking.");
        return;
    }

    g_cng.setText(String.valueOf(change));

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String checkInStr = sdf.format(c_cin.getDate());
    String checkOutStr = sdf.format(c_cout.getDate());
    
    String insertQuery = "INSERT INTO tbl_bookings (g_fname, g_lname, g_age, g_email, rm_id, rm_type, rm_status, b_cin, b_cout, time_in, b_cash, b_change, b_status, g_image) VALUES ('"
        + g_fn.getText() + "', '" + g_ln.getText() + "', '" + g_ag.getText() + "', '" + g_em.getText() + "', '"
        + selectedRoomId + "', '" + roomType + "', 'Booked', '" + checkInStr + "', '"
        + checkOutStr + "', 'Guest Not Yet Timed In', '" + cash + "', '" + change + "', 'Pending', '" + destination + "')";

    int newBookingId = dbc.insertDataWithGeneratedKey(insertQuery);
    

   if (newBookingId == -1) {
    JOptionPane.showMessageDialog(this, "Booking failed.");
    return;
}

    dbc.updateData("UPDATE tbl_room SET r_status = 'Booked' WHERE room_id = '" + selectedRoomId + "'");
    
    Session sess = Session.getInstance();
        String action = "Added Booking Record with ID of " + newBookingId;
        dbc.insertData("INSERT INTO tbl_logs (usr_id, l_actions, l_date) VALUES ('"
    + sess.getUid() + "', '" + action + "', '" + java.time.LocalDateTime.now() + "')");

    JOptionPane.showMessageDialog(this, "Booking added successfully!");
    loadVacantRooms();
    
    String type = sess.getType();

    if (type.equals("Admin")) {
        AdminPage hmp = new AdminPage();
        hmp.setVisible(true);
    } else if (type.equals("User")) {
        UserPage usp = new UserPage();
        usp.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Unknown account type: " + type);
        return;
    }

    Window window = SwingUtilities.getWindowAncestor(this);
    if (window != null) {
        window.dispose();
    }

} catch (SQLException e) {
    JOptionPane.showMessageDialog(this, "SQL Error: " + e.getMessage());
}
    }//GEN-LAST:event_add_buttonMouseClicked

    private void i_selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_selectMouseClicked
        if (!canSelectImage) return;

        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/UserImages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if (FileExistenceChecker(path) == 1) {
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path = "";
                } else {
                    image.setIcon(ResizeImage(path, null, image));
                    canSelectImage = false;
                    i_remove.setEnabled(true);
                    i_select.setEnabled(false);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_i_selectMouseClicked

    private void i_removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_removeMouseClicked
        i_remove.setEnabled(false);
        i_select.setEnabled(true);
        canSelectImage = true;
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_i_removeMouseClicked

    private void add_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseEntered
        add_button.setBackground(hovercolor);
        add_button.setForeground(foregroundcolor);
    }//GEN-LAST:event_add_buttonMouseEntered

    private void add_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseExited
        add_button.setBackground(exitcolor);
        add_button.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_add_buttonMouseExited

    private void i_removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_removeMouseEntered
        i_remove.setBackground(hovercolor);
        i_remove.setForeground(foregroundcolor);
    }//GEN-LAST:event_i_removeMouseEntered

    private void i_removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_removeMouseExited
        i_remove.setBackground(exitcolor);
        i_remove.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_i_removeMouseExited

    private void i_selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_selectMouseEntered
        i_select.setBackground(hovercolor);
        i_select.setForeground(foregroundcolor);
    }//GEN-LAST:event_i_selectMouseEntered

    private void i_selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_selectMouseExited
        i_select.setBackground(exitcolor);
        i_select.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_i_selectMouseExited

    private void g_fnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g_fnKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_g_fnKeyTyped

    private void g_lnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g_lnKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_g_lnKeyTyped

    private void g_agKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g_agKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_g_agKeyTyped

    private void g_csKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g_csKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_g_csKeyTyped

    private void c_allMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseExited
        c_all.setBackground(exitcolor);
        c_all.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_c_allMouseExited

    private void c_allMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseEntered
        c_all.setBackground(hovercolor);
        c_all.setForeground(foregroundcolor);
    }//GEN-LAST:event_c_allMouseEntered

    private void c_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseClicked
        g_fn.setText("");
        g_ln.setText("");
        g_ag.setText("");
        g_em.setText("");
        g_cs.setText("");
        g_cng.setText("");
    }//GEN-LAST:event_c_allMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add_button;
    private javax.swing.JLabel c_all;
    private com.toedter.calendar.JCalendar c_cin;
    private com.toedter.calendar.JCalendar c_cout;
    private javax.swing.JTextField g_ag;
    private javax.swing.JTextField g_cng;
    private javax.swing.JTextField g_cs;
    private javax.swing.JTextField g_em;
    private javax.swing.JTextField g_fn;
    private javax.swing.JTextField g_ln;
    public javax.swing.JLabel i_remove;
    public javax.swing.JLabel i_select;
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
    private javax.swing.JComboBox<String> roomComboBox;
    // End of variables declaration//GEN-END:variables
}
