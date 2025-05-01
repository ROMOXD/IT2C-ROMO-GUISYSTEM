/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsersInternal;

import Admin.AdminPage;
import static MainPage.RegistrationForm.email;
import static MainPage.RegistrationForm.username;
import User.UserPage;
import config.HashPass;
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
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


/**
 *
 * @author Mark Kevin Romo
 */
public class AddUserForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form AddUserForm
     */
    public AddUserForm() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    
    Border line = BorderFactory.createLineBorder(Color.BLACK);
    Border margin = BorderFactory.createEmptyBorder(5, 10, 5, 10); 
    Border compound = BorderFactory.createCompoundBorder(line, margin);

    fn.setBorder(compound);
    ln.setBorder(compound);
    em.setBorder(compound);
    gd.setBorder(compound);
    cn.setBorder(compound);
    un.setBorder(compound);
    ps.setBorder(compound);
    ag.setBorder(compound);
    at.setBorder(compound);

    }
    
     Color hovercolor = new Color(255,255,255);
     Color exitcolor = new Color(0,0,153);
     Color foregroundcolor = new Color(0,0,0);
     Color exitforegroundcolor = new Color(255,255,255);
    
    private boolean canSelectImage = true;
    
    public String destination = "";
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

    
    
    public boolean duplicateCheck(){
    
    dbConnector dbc = new dbConnector();
    
    try{
    String query = "SELECT * FROM tbl_user WHERE u_usern = '" +un.getText()+ "' OR u_email = '" +em.getText()+"'";
    ResultSet resultSet = dbc.getData(query);
    
    
    if(resultSet.next()){
    email=resultSet.getString("u_email");
    
    if(email.equals(em.getText())){
    JOptionPane.showMessageDialog(null, "Email Already Existed!");
    em.setText("");
    }
    
    username=resultSet.getString("u_usern");
    
    if(username.equals(un.getText())){
    JOptionPane.showMessageDialog(null, "Username Already Existed!");
    un.setText("");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ag = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        gd = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cn = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        at = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ps = new javax.swing.JPasswordField();
        fn = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        c_all = new javax.swing.JLabel();
        i_select = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        i_remove = new javax.swing.JLabel();
        reg = new javax.swing.JLabel();
        s_pass = new javax.swing.JCheckBox();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JPanel1.setBackground(new java.awt.Color(255, 255, 255));
        JPanel1.setForeground(new java.awt.Color(255, 255, 255));
        JPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Account Type:");
        JPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 100, 30));

        ag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agActionPerformed(evt);
            }
        });
        ag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                agKeyTyped(evt);
            }
        });
        JPanel1.add(ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 140, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lastname:");
        JPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 30));

        em.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        em.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emKeyTyped(evt);
            }
        });
        JPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, 30));

        un.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        JPanel1.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 180, 30));

        ln.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnKeyTyped(evt);
            }
        });
        JPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("C Number:");
        JPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Firstname:");
        JPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Username:");
        JPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, 30));

        gd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gdActionPerformed(evt);
            }
        });
        JPanel1.add(gd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Age:");
        JPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 80, 30));

        cn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        cn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cnKeyTyped(evt);
            }
        });
        JPanel1.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 180, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Email:");
        JPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        at.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        at.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        JPanel1.add(at, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 180, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password:");
        JPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Gender:");
        JPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 30));

        ps.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        JPanel1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 180, 30));

        fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnKeyTyped(evt);
            }
        });
        JPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 180, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);
        jPanel2.add(image);
        image.setBounds(10, 10, 220, 180);

        JPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 240, 200));

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
        JPanel1.add(c_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 150, 40));

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
        JPanel1.add(i_select, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 120, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("ADD PROFILE");
        JPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 30, -1, -1));

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
        JPanel1.add(i_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 110, 40));

        reg.setBackground(new java.awt.Color(0, 0, 153));
        reg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reg.setForeground(new java.awt.Color(255, 255, 255));
        reg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reg.setText("Register");
        reg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        reg.setOpaque(true);
        reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regMouseExited(evt);
            }
        });
        JPanel1.add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 150, 40));

        s_pass.setBackground(new java.awt.Color(255, 255, 255));
        s_pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        s_pass.setText("Show Password");
        s_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_passActionPerformed(evt);
            }
        });
        JPanel1.add(s_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 180, 30));

        getContentPane().add(JPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agActionPerformed

    private void agKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();

        }
    }//GEN-LAST:event_agKeyTyped

    private void emKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_emKeyTyped

    private void lnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_lnKeyTyped

    private void gdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gdActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnActionPerformed

    private void cnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();

        }
    }//GEN-LAST:event_cnKeyTyped

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psActionPerformed

    private void fnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_fnKeyTyped

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

    private void c_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseClicked
        fn.setText("");
        ln.setText("");
        fn.setText("");
        em.setText("");
        cn.setText("");
        un.setText("");
        ps.setText("");
        ag.setText("");
    }//GEN-LAST:event_c_allMouseClicked

    private void i_removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_i_removeMouseClicked
    i_remove.setEnabled(false);
    i_select.setEnabled(true);
    canSelectImage = true;
    image.setIcon(null);
    destination = "";
    path = "";
    }//GEN-LAST:event_i_removeMouseClicked

    private void regMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseClicked
         dbConnector dbc = new dbConnector();

    if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() ||
        cn.getText().isEmpty() || un.getText().isEmpty() || ps.getPassword().length == 0 ||
        ag.getText().isEmpty()) {

        JOptionPane.showMessageDialog(null, "All fields are required!");
        return;
    }

if (fn.getText().matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Guest first name should not contain numbers.");
        return;
    }

    if (ln.getText().matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Guest last name should\n" +
" not contain numbers.");
        return;
    }

    try {
        int age = Integer.parseInt(ag.getText());
        if (age <= 18) {
            JOptionPane.showMessageDialog(this, "Age must be greater or equal to 18.");
            return;
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Age must be a valid number.");
        return;
    }    

    String password = new String(ps.getPassword());

if (password.length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long!");
        ps.setText("");
        return;
    }

    String email = em.getText();
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
if (!email.matches(emailRegex)) {
        JOptionPane.showMessageDialog(null, "Email must be a valid email address.");
        return;
    }

if (duplicateCheck()) {
        System.out.println("Duplicate Exist");
        return;
    }

    try {
        String pass = HashPass.hashPassword(password);
        String accountType = (String) at.getSelectedItem();
        
    if (!"Admin".equals(accountType) && !"User".equals(accountType)) {
            JOptionPane.showMessageDialog(null, "Invalid account type selected.");
            return;
        }

        String userImagePath = "";
     if (selectedFile != null) {
            userImagePath = destination;
        }

        boolean inserted = dbc.insertData("INSERT INTO tbl_user (u_fname, u_lname, u_email, u_cnum, u_usern, u_pass, u_gen, u_age, u_type, u_status, u_image) "
            + "VALUES ('" + fn.getText() + "', '" + ln.getText() + "', '" + email + "', '" + cn.getText() + "', '"
            + un.getText() + "', '" + pass + "', '" + gd.getSelectedItem() + "', '" + ag.getText() + "', '"
            + accountType + "', 'Inactive', '" + userImagePath + "')");

        if (!inserted) {
            JOptionPane.showMessageDialog(null, "Registration Failed. Please try again.");
            return;
        }

        if (selectedFile != null) {
            try {
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                System.out.println("Failed to copy image file: " + ex);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Registered Successfully!");
        
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
        
    } catch (NoSuchAlgorithmException ex) {
        System.out.println(ex);
    }
    }//GEN-LAST:event_regMouseClicked

    private void c_allMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseEntered
        c_all.setBackground(hovercolor);
        c_all.setForeground(foregroundcolor);
    }//GEN-LAST:event_c_allMouseEntered

    private void c_allMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseExited
        c_all.setBackground(exitcolor);
        c_all.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_c_allMouseExited

    private void regMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseEntered
        reg.setBackground(hovercolor);
        reg.setForeground(foregroundcolor);
    }//GEN-LAST:event_regMouseEntered

    private void regMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseExited
        reg.setBackground(exitcolor);
        reg.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_regMouseExited

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

    private void s_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_passActionPerformed
        if(s_pass.isSelected()){
            ps.setEchoChar((char)0);
        }  else {
            ps.setEchoChar('●');
        }
    }//GEN-LAST:event_s_passActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel1;
    private javax.swing.JTextField ag;
    private javax.swing.JComboBox<String> at;
    public javax.swing.JLabel c_all;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField em;
    private javax.swing.JTextField fn;
    private javax.swing.JComboBox<String> gd;
    public javax.swing.JLabel i_remove;
    public javax.swing.JLabel i_select;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField ln;
    private javax.swing.JPasswordField ps;
    public javax.swing.JLabel reg;
    private javax.swing.JCheckBox s_pass;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
