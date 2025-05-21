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
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.table.TableColumnModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Mark Kevin Romo
 */
public class UpdateUserForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form UpdateUserForm
     */
    
    private boolean canSelectImage = false;
        
    String destination = "";
    File selectedFile;
    String path = "";
    String oldpath = "";
    
     Color hovercolor = new Color(255,255,255);
     Color exitcolor = new Color(0,0,153);
     Color foregroundcolor = new Color(0,0,0);
     Color exitforegroundcolor = new Color(255,255,255);
    
    public UpdateUserForm() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    
    displayData();
    
    Border line = BorderFactory.createLineBorder(Color.BLACK);
    Border margin = BorderFactory.createEmptyBorder(5, 10, 5, 10); 
    Border compound = BorderFactory.createCompoundBorder(line, margin);

    user_id.setBorder(compound);
    fn.setBorder(compound);
    ln.setBorder(compound);
    em.setBorder(compound);
    gd.setBorder(compound);
    cn.setBorder(compound);
    un.setBorder(compound);
    ag.setBorder(compound);
    at.setBorder(compound);
    
    i_select.setEnabled(false);
    i_remove.setEnabled(false);
    setCanSelectImage(false);
    
    TableColumnModel columnModel = usersTable.getColumnModel();
       
        columnModel.getColumn(0).setHeaderValue("ID");
        columnModel.getColumn(1).setHeaderValue("FIRSTNAME");
        columnModel.getColumn(2).setHeaderValue("USERNAME");

    usersTable.getTableHeader().repaint();
    
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = usersTable.getSelectedRow();
        String tableClick = (usersTable.getModel().getValueAt(row, 0).toString());

        try {
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT * FROM tbl_user WHERE u_id = '" + tableClick + "'");
            if (rs.next()) {
                
                AddUserForm auf = new AddUserForm();
                user_id.setText(rs.getString("u_id"));
                fn.setText(rs.getString("u_fname"));
                ln.setText(rs.getString("u_lname"));
                em.setText(rs.getString("u_email"));
                cn.setText(rs.getString("u_cnum"));
                un.setText(rs.getString("u_usern"));
                gd.setSelectedItem(rs.getString("u_gen"));
                ag.setText(rs.getString("u_age"));
                at.setSelectedItem(rs.getString("u_type"));
                image.setIcon(auf.ResizeImage(rs.getString("u_image"),null, image));
                oldpath = rs.getString("u_image");
                path = rs.getString("u_image");
                destination = rs.getString("u_image");
                
                    setCanSelectImage(false);
                    i_select.setEnabled(false);
                    i_remove.setEnabled(true);
                
                
                if (!rs.getString("u_image").isEmpty()) {
    i_remove.setEnabled(true);
    i_select.setEnabled(false);
}
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving data: " + ex.getMessage());
        }
    }
});
    }
    
    
    
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
            ResultSet rs = dbc.getData("SELECT u_id, u_fname, u_usern FROM tbl_user");
            usersTable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

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
    
    public boolean updateCheck(){
    
    dbConnector dbc = new dbConnector();
    
    try{
    String query = "SELECT * FROM tbl_user WHERE (u_usern = '" +un.getText()+ "' OR u_email = '" +em.getText()+"') AND u_id != '"+user_id.getText()+"' ";
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

        jPanel3 = new javax.swing.JPanel();
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
        jLabel9 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        user_id = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        i_select = new javax.swing.JLabel();
        i_remove = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        c_all = new javax.swing.JLabel();
        u_button = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Acc Type:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 70, 30));

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
        jPanel3.add(ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 170, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lastname:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        em.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        em.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emKeyTyped(evt);
            }
        });
        jPanel3.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 170, 30));

        un.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel3.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 170, 30));

        ln.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnKeyTyped(evt);
            }
        });
        jPanel3.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 170, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("C Number:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Firstname:");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Username:");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, -1, 30));

        gd.setBackground(new java.awt.Color(0, 0, 0));
        gd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gdActionPerformed(evt);
            }
        });
        jPanel3.add(gd, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 170, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Age:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, -1, 30));

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
        jPanel3.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 170, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Email:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        at.setBackground(new java.awt.Color(0, 0, 0));
        at.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        at.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        jPanel3.add(at, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 170, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Gender:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnKeyTyped(evt);
            }
        });
        jPanel3.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 170, 30));

        user_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        user_id.setEnabled(false);
        user_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_idActionPerformed(evt);
            }
        });
        jPanel3.add(user_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 170, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("User ID:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(usersTable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 260, 120));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);
        jPanel1.add(image);
        image.setBounds(10, 10, 240, 130);

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 260, 150));

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
        jPanel3.add(i_select, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 340, 120, 40));

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
        jPanel3.add(i_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 340, 120, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ADD/UPDATE PROFILE");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

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
        jPanel3.add(c_all, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 150, 40));

        u_button.setBackground(new java.awt.Color(0, 0, 153));
        u_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        u_button.setForeground(new java.awt.Color(255, 255, 255));
        u_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        u_button.setText("Update");
        u_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        u_button.setOpaque(true);
        u_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                u_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                u_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                u_buttonMouseExited(evt);
            }
        });
        jPanel3.add(u_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 150, 40));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 520));

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

    private void fnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_fnKeyTyped

    private void user_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_user_idActionPerformed

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

    private void c_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseClicked
        fn.setText("");
        ln.setText("");
        fn.setText("");
        em.setText("");
        cn.setText("");
        un.setText("");
        ag.setText("");
    }//GEN-LAST:event_c_allMouseClicked

    private void u_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_u_buttonMouseClicked
    
    dbConnector dbc = new dbConnector();
    
    int row = usersTable.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(null, "Choose a user to update in the table");
        return;
    }

    if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() ||
        cn.getText().isEmpty() || un.getText().isEmpty() || ag.getText().isEmpty()) {

        JOptionPane.showMessageDialog(null, "All fields are required!");
        return;
    }
    
    if (fn.getText().matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Guest first name should not contain numbers.");
        return;
    }

    if (ln.getText().matches(".*\\d.*")) {
        JOptionPane.showMessageDialog(this, "Guest last name should not contain numbers.");
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

    String email = em.getText();
    String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    if (!email.matches(emailRegex)) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
        return;
    }

    if (updateCheck()) {
        System.out.println("Duplicate Exist");
        return;
    }
    
    String accountType = (String) at.getSelectedItem();
    
    if (!"Admin".equals(accountType) && !"User".equals(accountType)) {
            JOptionPane.showMessageDialog(null, "Invalid account type selected.");
            return;
        }

    String query = "UPDATE tbl_user SET " +
    "u_fname = '" + fn.getText() + "', " +
    "u_lname = '" + ln.getText() + "', " +
    "u_email = '" + em.getText() + "', " +
    "u_cnum = '" + cn.getText() + "', " +
    "u_usern = '" + un.getText() + "', " +
    "u_gen = '" + gd.getSelectedItem() + "', " +
    "u_age = '" + ag.getText() + "', " +
    "u_type = '" + at.getSelectedItem() + "', " +
    "u_image = '" + destination + "' " +
    "WHERE u_id = '" + user_id.getText() + "'";
    
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
    
    Session sess = Session.getInstance();
        String action = "Updated User Record with ID of " + user_id.getText();
        dbc.insertData("INSERT INTO tbl_logs (usr_id, l_actions, l_date) VALUES ('"
    + sess.getUid() + "', '" + action + "', '" + java.time.LocalDateTime.now() + "')");


    if (dbc.updateData(query)) {
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
        
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
        
    } else {
        JOptionPane.showMessageDialog(null, "Updating User Failed. Please try again.");
    }
    }//GEN-LAST:event_u_buttonMouseClicked

    private void c_allMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseEntered
        c_all.setBackground(hovercolor);
        c_all.setForeground(foregroundcolor);
    }//GEN-LAST:event_c_allMouseEntered

    private void u_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_u_buttonMouseEntered
        u_button.setBackground(hovercolor);
        u_button.setForeground(foregroundcolor);
    }//GEN-LAST:event_u_buttonMouseEntered

    private void c_allMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_allMouseExited
        c_all.setBackground(exitcolor);
        c_all.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_c_allMouseExited

    private void u_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_u_buttonMouseExited
        u_button.setBackground(exitcolor);
        u_button.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_u_buttonMouseExited

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField ag;
    public javax.swing.JComboBox<String> at;
    public javax.swing.JLabel c_all;
    public javax.swing.JTextField cn;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JComboBox<String> gd;
    public javax.swing.JLabel i_remove;
    public javax.swing.JLabel i_select;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField ln;
    public javax.swing.JLabel u_button;
    public javax.swing.JTextField un;
    public javax.swing.JTextField user_id;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
