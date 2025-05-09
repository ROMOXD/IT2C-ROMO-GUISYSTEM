/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPage;

import config.HashPass;
import config.dbConnector;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *
 * @author Mark Kevin Romo
 */
public class RegistrationForm extends javax.swing.JFrame {

    /**
     * Creates new form RegistrationForm
     */
    public RegistrationForm() {
        initComponents();
        this.setResizable(false);
        Border line = BorderFactory.createLineBorder(Color.BLACK);
        Border margin = BorderFactory.createEmptyBorder(5, 10, 5, 10);
        Border compound = BorderFactory.createCompoundBorder(line, margin);

fn.setBorder(compound);
ln.setBorder(compound);
em.setBorder(compound);
cn.setBorder(compound);
un.setBorder(compound);
ps.setBorder(compound);
ag.setBorder(compound);
    }
    
    private boolean canSelectImage = true;
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
     Color hovercolor = new Color(255,255,255);
     Color exitcolor = new Color(0,0,153);
     Color foregroundcolor = new Color(0,0,0);
     Color exitforegroundcolor = new Color(255,255,255);
     
    
    public static String email, username;
    
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

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
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
        r_button = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        minimize1 = new javax.swing.JLabel();
        exit1 = new javax.swing.JLabel();
        b_button = new javax.swing.JLabel();
        s_pass = new javax.swing.JCheckBox();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Account Type:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 443, 100, 30));

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
        jPanel1.add(ag, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, 130, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Lastname:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 133, -1, 30));

        em.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        em.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emKeyTyped(evt);
            }
        });
        jPanel1.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 173, 320, 30));

        un.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 253, 320, 30));

        ln.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ln.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lnKeyTyped(evt);
            }
        });
        jPanel1.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 133, 320, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("C Number:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 213, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Firstname:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 93, -1, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Username:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 253, -1, 30));

        gd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gdActionPerformed(evt);
            }
        });
        jPanel1.add(gd, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Age:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, 30));

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
        jPanel1.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 213, 320, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Email:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 173, -1, 30));

        at.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        at.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "User" }));
        jPanel1.add(at, new org.netbeans.lib.awtextra.AbsoluteConstraints(253, 443, 180, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 293, -1, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Gender:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, 30));

        ps.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        jPanel1.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 293, 320, 30));

        fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fnKeyTyped(evt);
            }
        });
        jPanel1.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 93, 320, 30));

        r_button.setBackground(new java.awt.Color(0, 0, 153));
        r_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        r_button.setForeground(new java.awt.Color(255, 255, 255));
        r_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        r_button.setText("Register");
        r_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        r_button.setOpaque(true);
        r_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                r_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                r_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                r_buttonMouseExited(evt);
            }
        });
        jPanel1.add(r_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 390, 150, 40));

        jPanel3.setBackground(new java.awt.Color(0, 0, 153));
        jPanel3.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REGISTRATION FORM");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(10, 10, 230, 40);

        minimize1.setBackground(new java.awt.Color(0, 0, 153));
        minimize1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        minimize1.setForeground(new java.awt.Color(255, 255, 255));
        minimize1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimize1.setText("—");
        minimize1.setOpaque(true);
        minimize1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimize1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimize1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimize1MouseExited(evt);
            }
        });
        jPanel3.add(minimize1);
        minimize1.setBounds(650, 10, 40, 30);

        exit1.setBackground(new java.awt.Color(0, 0, 153));
        exit1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        exit1.setForeground(new java.awt.Color(255, 255, 255));
        exit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit1.setText("X");
        exit1.setOpaque(true);
        exit1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit1MouseExited(evt);
            }
        });
        jPanel3.add(exit1);
        exit1.setBounds(690, 10, 40, 30);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 60));

        b_button.setBackground(new java.awt.Color(0, 0, 153));
        b_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        b_button.setForeground(new java.awt.Color(255, 255, 255));
        b_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        b_button.setText("Back");
        b_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_button.setOpaque(true);
        b_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_buttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_buttonMouseExited(evt);
            }
        });
        jPanel1.add(b_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 150, 40));

        s_pass.setBackground(new java.awt.Color(255, 255, 255));
        s_pass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        s_pass.setText("Show Password");
        s_pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s_passActionPerformed(evt);
            }
        });
        jPanel1.add(s_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 325, 320, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gdActionPerformed

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnActionPerformed

    private void fnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnKeyTyped
        char c = evt.getKeyChar();
    if (Character.isDigit(c)) {
        evt.consume(); 
        }
    }//GEN-LAST:event_fnKeyTyped

    private void lnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnKeyTyped
        char c = evt.getKeyChar();
    if (Character.isDigit(c)) {
        evt.consume(); 
        }
    }//GEN-LAST:event_lnKeyTyped

    private void emKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emKeyTyped
          // TODO add your handling code here:
    }//GEN-LAST:event_emKeyTyped

    private void cnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnKeyTyped
        char c = evt.getKeyChar();
    if (!Character.isDigit(c)) { 
        evt.consume(); 
         
        } 
    }//GEN-LAST:event_cnKeyTyped

    private void agKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_agKeyTyped
         char c = evt.getKeyChar();
    if (!Character.isDigit(c)) { 
        evt.consume(); 
         
        } 
    }//GEN-LAST:event_agKeyTyped

    private void agActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
  
    }//GEN-LAST:event_formWindowActivated

    private void r_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r_buttonMouseClicked
            dbConnector dbc = new dbConnector();    

    if (fn.getText().isEmpty() || ln.getText().isEmpty() || em.getText().isEmpty() || 
        cn.getText().isEmpty() || un.getText().isEmpty() || ps.getPassword().length == 0 || 
        ag.getText().isEmpty()) {
        
        JOptionPane.showMessageDialog(null, "All fields are required!");
        return; 
    }
    
if (!fn.getText().matches("^[a-zA-Z\\s]+$")) {
    JOptionPane.showMessageDialog(null, "First name must not contain numbers or special characters.");
        return;
    }

if (!ln.getText().matches("^[a-zA-Z\\s]+$")) {
        JOptionPane.showMessageDialog(null, "Last name must not contain numbers or special characters.");
        return;
    }

if (!cn.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Contact number must contain digits only.");
        return;
    }

if (!ag.getText().matches("\\d+")) {
        JOptionPane.showMessageDialog(null, "Age must contain digits only.");
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
    Pattern pattern = Pattern.compile(emailRegex);
    Matcher matcher = pattern.matcher(email);

    if (!matcher.matches()) {
        JOptionPane.showMessageDialog(null, "Please enter a valid email address.");
        return;
    }

    if (duplicateCheck()) {
        System.out.println("Duplicate Exist");
        return;
    }

    try {
        
        String pass = HashPass.hashPassword(new String(ps.getPassword()));
        String userImagePath = "";
        
        if (selectedFile != null) { 
            userImagePath = destination;
        }
        
        boolean inserted = dbc.insertData("INSERT INTO tbl_user (u_fname, u_lname, u_email, u_cnum, u_usern, u_pass, u_gen, u_age, u_type, u_status, u_image) "
                + "VALUES ('" + fn.getText() + "', '" + ln.getText() + "', '" + email + "', '" + cn.getText() + "', '"
                + un.getText() + "', '" + pass + "', '" + gd.getSelectedItem() + "', '" + ag.getText() + "', '"
                + at.getSelectedItem() + "', 'Inactive', '" + userImagePath + "')");

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

        
        if (inserted) {
            JOptionPane.showMessageDialog(null, "Registered Successfully!");
            LoginPage mp = new LoginPage();
            mp.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Registration Failed. Please try again.");
        }

    } catch (NoSuchAlgorithmException ex) {
        System.out.println("" + ex);
    }
    }//GEN-LAST:event_r_buttonMouseClicked

    private void r_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r_buttonMouseEntered
        r_button.setBackground(hovercolor);
        r_button.setForeground(foregroundcolor);
    }//GEN-LAST:event_r_buttonMouseEntered

    private void r_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_r_buttonMouseExited
        r_button.setBackground(exitcolor);
        r_button.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_r_buttonMouseExited

    private void b_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_buttonMouseClicked
        LoginPage mp = new LoginPage();
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_b_buttonMouseClicked

    private void b_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_buttonMouseEntered
        b_button.setBackground(hovercolor);
        b_button.setForeground(foregroundcolor);
    }//GEN-LAST:event_b_buttonMouseEntered

    private void b_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_buttonMouseExited
        b_button.setBackground(exitcolor);
        b_button.setForeground(exitforegroundcolor);
    }//GEN-LAST:event_b_buttonMouseExited

    private void s_passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s_passActionPerformed
        if(s_pass.isSelected()){
            ps.setEchoChar((char)0);
        }  else {
            ps.setEchoChar('●');
        }
    }//GEN-LAST:event_s_passActionPerformed

    private void minimize1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize1MouseClicked
        setState(ICONIFIED);
    }//GEN-LAST:event_minimize1MouseClicked

    private void minimize1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize1MouseEntered
        minimize1.setBackground(new java.awt.Color(240,240,240));
        minimize1.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_minimize1MouseEntered

    private void minimize1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimize1MouseExited
        minimize1.setBackground(new java.awt.Color(0,0,153));
        minimize1.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_minimize1MouseExited

    private void exit1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_exit1MouseClicked

    private void exit1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MouseEntered
        exit1.setBackground(new java.awt.Color(240,240,240));
        exit1.setForeground(new java.awt.Color(0,0,0));
    }//GEN-LAST:event_exit1MouseEntered

    private void exit1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit1MouseExited
        exit1.setBackground(new java.awt.Color(0,0,153));
        exit1.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_exit1MouseExited

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
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrationForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrationForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ag;
    private javax.swing.JComboBox<String> at;
    private javax.swing.JLabel b_button;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField em;
    private javax.swing.JLabel exit1;
    private javax.swing.JTextField fn;
    private javax.swing.JComboBox<String> gd;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField ln;
    private javax.swing.JLabel minimize1;
    private javax.swing.JPasswordField ps;
    private javax.swing.JLabel r_button;
    private javax.swing.JCheckBox s_pass;
    private javax.swing.JTextField un;
    // End of variables declaration//GEN-END:variables
}
