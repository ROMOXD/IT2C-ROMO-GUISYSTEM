/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookingsInternal;

import Admin.AdminPage;
import static MainPage.RegistrationForm.email;
import User.UserPage;
import UsersInternal.AddUserForm;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mark Kevin Romo
 */
public class UpdateBookingForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form UpdateBookingForm
     */
    
    private boolean canSelectImage = false;
        
    String destination = "";
    File selectedFile;
    String path = "";
    String oldpath = "";
    
    public UpdateBookingForm() {
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
    
    i_select.setEnabled(false);
    i_remove.setEnabled(false);
    setCanSelectImage(false);
    
    
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
                            
                             setCanSelectImage(false);
                    i_select.setEnabled(false);
                    i_remove.setEnabled(true);
                
                
                if (!rs.getString("g_image").isEmpty()) {
    i_remove.setEnabled(true);
    i_select.setEnabled(false);
}
                        }
                        rs.close();
                    } catch (SQLException ex) {
                        System.out.println("Error retrieving booking data: " + ex.getMessage());
                    }
                }
            }
        });
    
    }
     
     Color hovercolor = new Color(255,255,255);
     Color exitcolor = new Color(0,0,153);
     Color foregroundcolor = new Color(0,0,0);
     Color exitforegroundcolor = new Color(255,255,255);
    
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
            
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
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
    
    private String getSelectedBookingId() {
        int selectedRow = bkTable.getSelectedRow();
        if (selectedRow >= 0) {
            return bkTable.getValueAt(selectedRow, 0).toString();
        }
        return null;
    }
    
    private String getPreviousRoomId() {
        int selectedRow = bkTable.getSelectedRow();
        if (selectedRow >= 0) {
            String selectedBookingId = bkTable.getValueAt(selectedRow, 0).toString();
            try {
                dbConnector dbc = new dbConnector();
                ResultSet rs = dbc.getData("SELECT rm_id FROM tbl_bookings WHERE b_id = " + selectedBookingId);
                if (rs.next()) {
                    return rs.getString("rm_id");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Error fetching previous room ID: " + e.getMessage());
            }
        }
        return null;
        
    }
    
    private void loadVacantRooms() {
        try {
        dbConnector dbc = new dbConnector();       
        ResultSet rs = dbc.getData("SELECT room_id, r_type, r_price, r_status FROM tbl_room WHERE r_status = 'Vacant'");
        roomComboBox.removeAllItems();
        
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
        JOptionPane.showMessageDialog(this, "Error loading vacant rooms: " + e.getMessage());
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
    
    public boolean updateCheck(){
    
    dbConnector dbc = new dbConnector();
    
    try{
    String query = "SELECT * FROM tbl_booking WHERE (g_email = '" +g_em.getText()+"') AND b_id != '"+booking_id.getText()+"' ";
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
        if (g_fn.getText().isEmpty() || g_ln.getText().isEmpty() || g_ag.getText().isEmpty() || g_em.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields.");
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
    
    if (updateCheck()) {
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
    
    public void setCanSelectImage(boolean value) {
    this.canSelectImage = value;
    i_select.setEnabled(value);
    i_remove.setEnabled(value);
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
        b_update = new javax.swing.JLabel();
        c_all = new javax.swing.JLabel();
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
        i_remove = new javax.swing.JLabel();
        i_select = new javax.swing.JLabel();
        booking_id = new javax.swing.JLabel();

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
        jPanel1.add(g_ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 120, 30));

        g_em.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                g_emActionPerformed(evt);
            }
        });
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
        jPanel1.add(g_cs, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 120, 30));

        g_cng.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        g_cng.setEnabled(false);
        jPanel1.add(g_cng, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 120, 30));

        b_update.setBackground(new java.awt.Color(0, 0, 153));
        b_update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_update.setForeground(new java.awt.Color(255, 255, 255));
        b_update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_update.setText("Update");
        b_update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_update.setOpaque(true);
        b_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_updateMouseExited(evt);
            }
        });
        jPanel1.add(b_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 110, 40));

        c_all.setBackground(new java.awt.Color(0, 0, 153));
        c_all.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jPanel1.add(c_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 120, 40));

        roomComboBox.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jPanel1.add(roomComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 260, 40));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        c_cin.setDate(new java.util.Date(1744981158000L));
        jPanel2.add(c_cin);
        c_cin.setBounds(20, 30, 200, 130);
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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 510, 170));

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
        jPanel1.add(i_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 130, 40));

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
        jPanel1.add(i_select, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 130, 40));

        booking_id.setForeground(new java.awt.Color(255, 255, 255));
        booking_id.setText("jLabel9");
        jPanel1.add(booking_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

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

    private void b_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_updateMouseClicked
         if (!validateInputs()) {
        return;
    }

    try {
        dbConnector dbc = new dbConnector();

        String selectedBookingId = getSelectedBookingId();
        if (selectedBookingId == null) {
            JOptionPane.showMessageDialog(this, "No booking selected.");
            return;
        }

        String previousRoomId = getPreviousRoomId();
        if (previousRoomId == null) {
            JOptionPane.showMessageDialog(this, "No previous room selected.");
            return;
        }

        String selectedItem = roomComboBox.getSelectedItem().toString();
        selectedItem = selectedItem.replace(" (Current Room)", "");
        String selectedRoomId = selectedItem.split(":")[0].trim();

        ResultSet rs = dbc.getData("SELECT r_type, r_price FROM tbl_room WHERE room_id = '" + selectedRoomId + "'");
        if (!rs.next()) {
            JOptionPane.showMessageDialog(this, "Selected room is no longer available.");
            return;
        }

        String roomType = rs.getString("r_type");
        double roomPrice = rs.getDouble("r_price");
        rs.close();

        if (!previousRoomId.equals(selectedRoomId)) {
            dbc.updateData("UPDATE tbl_room SET r_status = 'Vacant' WHERE room_id = '" + previousRoomId + "'");
            dbc.updateData("UPDATE tbl_room SET r_status = 'Booked' WHERE room_id = '" + selectedRoomId + "'");
        }

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

        boolean updated = dbc.updateData(
            "UPDATE tbl_bookings SET g_fname = '" + g_fn.getText() + "', g_lname = '" + g_ln.getText() + "', g_age = '" + g_ag.getText() + "', " +
            "g_email = '" + g_em.getText() + "', rm_id = '" + selectedRoomId + "', rm_type = '" + roomType + "', " +
            "b_cin = '" + checkInStr + "', b_cout = '" + checkOutStr + "', b_cash = '" + cash + "', b_change = '" + change + "', " +
            "g_image = '" + destination + "' WHERE b_id = '" + selectedBookingId + "'"
        );

        if (!updated) {
            JOptionPane.showMessageDialog(this, "Booking update failed.");
            return;
        }
        
        if(destination.isEmpty()){
    File existingFile = new File(oldpath);
        if(existingFile.exists()){
            existingFile.delete();
            
        }
    }else{
        if(!(oldpath.equals(path))){
            imageUpdater(oldpath, path);
        }
    
    }

        JOptionPane.showMessageDialog(this, "Booking updated successfully!");
        loadVacantRooms();
        
    Session sess = Session.getInstance();
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
    }//GEN-LAST:event_b_updateMouseClicked

    private void c_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseClicked
        g_fn.setText("");
        g_ln.setText("");
        g_ag.setText("");
        g_em.setText("");
        g_cs.setText("");
        g_cng.setText("");
    }//GEN-LAST:event_c_allMouseClicked

    private void i_removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_removeMouseClicked
        i_remove.setEnabled(false);
        i_select.setEnabled(true);
        canSelectImage = true;
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_i_removeMouseClicked

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

    private void c_allMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseEntered
        c_all.setBackground(hovercolor);
        c_all.setForeground(foregroundcolor);
    }//GEN-LAST:event_c_allMouseEntered

    private void c_allMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseExited
        c_all.setBackground(exitcolor);
        c_all.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_c_allMouseExited

    private void b_updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_updateMouseEntered
        b_update.setBackground(hovercolor);
        b_update.setForeground(foregroundcolor);
    }//GEN-LAST:event_b_updateMouseEntered

    private void b_updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_updateMouseExited
        b_update.setBackground(exitcolor);
        b_update.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_b_updateMouseExited

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

    private void g_emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_g_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_g_emActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_update;
    private javax.swing.JTable bkTable;
    private javax.swing.JLabel booking_id;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> roomComboBox;
    // End of variables declaration//GEN-END:variables
}
