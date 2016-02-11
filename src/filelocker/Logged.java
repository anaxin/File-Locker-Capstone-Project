package filelocker;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * The interface for logged in users.
 *
 * @author xint
 */
public class Logged extends javax.swing.JFrame {

    /**
     * Creates new form Logged
     *
     * @param userStatus 0 for user, 1 for administrators
     * @param wasOTP true if password entered was OTP, false if it wasn't
     */
    public Logged(int userStatus, boolean wasOTP) {
        initComponents();
        ImageIcon logo = new ImageIcon("logo.jpg");
        this.setIconImage(logo.getImage());
        // hides admin tab when user is user
        if (userStatus == 0) {
            Logged.jTabbedPane1.removeTabAt(3);
        }
        if (wasOTP) {
            Logged.jLabel24.setForeground(Color.red);
            Logged.jLabel24.setText("Please change your account password before you log out!");
        }
        // sets informational fields with user data
        jTextField1.setText(MyData.getUsername());
        jTextField3.setText(MyData.getEmail());
        jLabel9.setText("Logged in as " + MyData.getUsername());
        Logged.jComboBox1.removeAllItems();
        Logged.jComboBox2.removeAllItems();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPasswordField4 = new javax.swing.JPasswordField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPasswordField5 = new javax.swing.JPasswordField();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPasswordField6 = new javax.swing.JPasswordField();
        jButton14 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton17 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("File Locker");

        jTabbedPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter password to Encrypt file"));

        jLabel2.setText("Enter Password");

        jLabel3.setText("Confirm Password");

        jPasswordField1.setMaximumSize(new java.awt.Dimension(118, 20));
        jPasswordField1.setMinimumSize(new java.awt.Dimension(118, 20));

        jPasswordField2.setMaximumSize(new java.awt.Dimension(118, 20));
        jPasswordField2.setMinimumSize(new java.awt.Dimension(118, 20));

        jButton1.setText("Encrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setText("Select File");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(373, 373, 373))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1))
                .addGap(20, 20, 20)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jButton2))
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Encrypt", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Enter password to Decrypt file"));

        jLabel6.setText("Enter Password");

        jPasswordField3.setMaximumSize(new java.awt.Dimension(118, 20));
        jPasswordField3.setMinimumSize(new java.awt.Dimension(118, 20));
        jPasswordField3.setName(""); // NOI18N

        jButton3.setText("Decrypt");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Select File");

        jButton4.setText("Browse");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextField10.setEditable(false);
        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))
                            .addComponent(jTextField10))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 266, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jButton4)
                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Decrypt", jPanel2);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPasswordField4.setBackground(new java.awt.Color(240, 240, 240));
        jPasswordField4.setMaximumSize(new java.awt.Dimension(165, 20));
        jPasswordField4.setMinimumSize(new java.awt.Dimension(165, 20));

        jButton7.setText("Change");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Change");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel7.setText("Password");

        jLabel5.setText("Email");

        jTextField1.setEditable(false);
        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField1.setMaximumSize(new java.awt.Dimension(165, 20));
        jTextField1.setMinimumSize(new java.awt.Dimension(165, 20));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(240, 240, 240));
        jTextField3.setMaximumSize(new java.awt.Dimension(165, 20));
        jTextField3.setMinimumSize(new java.awt.Dimension(165, 20));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(jButton8)))
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton7, jButton8, jLabel1});

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPasswordField4, jTextField1, jTextField3});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton7, jButton8, jLabel1, jPasswordField4, jTextField1, jTextField3});

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(504, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("My Account", jPanel3);

        jPasswordField5.setBackground(new java.awt.Color(240, 240, 240));
        jPasswordField5.setMaximumSize(new java.awt.Dimension(111, 20));
        jPasswordField5.setMinimumSize(new java.awt.Dimension(111, 20));
        jPasswordField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField5ActionPerformed(evt);
            }
        });

        jButton9.setText("Change");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Change");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel13.setText("Username");

        jLabel14.setText("Password");

        jLabel15.setText("Email");

        jTextField2.setBackground(new java.awt.Color(240, 240, 240));
        jTextField2.setMaximumSize(new java.awt.Dimension(111, 20));
        jTextField2.setMinimumSize(new java.awt.Dimension(111, 20));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField4.setBackground(new java.awt.Color(240, 240, 240));
        jTextField4.setMaximumSize(new java.awt.Dimension(111, 20));
        jTextField4.setMinimumSize(new java.awt.Dimension(111, 20));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButton11.setText("Change");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jPasswordField6.setBackground(new java.awt.Color(240, 240, 240));
        jPasswordField6.setMaximumSize(new java.awt.Dimension(111, 20));
        jPasswordField6.setMinimumSize(new java.awt.Dimension(111, 20));
        jPasswordField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField6ActionPerformed(evt);
            }
        });

        jButton14.setText("Change");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel18.setText("File Name");

        jLabel19.setText("File Password");

        jTextField6.setBackground(new java.awt.Color(240, 240, 240));
        jTextField6.setMaximumSize(new java.awt.Dimension(111, 20));
        jTextField6.setMinimumSize(new java.awt.Dimension(111, 20));
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jButton16.setText("Change");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField6, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14))
                .addGap(52, 52, 52))
        );

        jTextField8.setEditable(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jButton18.setText("Change");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabel28.setText("Status");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPasswordField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel15, jLabel28});

        jPanel8Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jTextField4, jTextField8});

        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton10))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton18)
                            .addComponent(jLabel28))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel15, jLabel28});

        jPanel8Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jTextField4, jTextField8});

        jTextField5.setMaximumSize(new java.awt.Dimension(150, 20));
        jTextField5.setMinimumSize(new java.awt.Dimension(150, 20));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton6.setText("Search User");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Select File");

        jButton12.setText("Get Files");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Edit Info");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButton15.setText("Edit Info");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel20))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox1, 0, 150, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel17, jLabel20});

        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jButton12))
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13)
                    .addComponent(jButton15))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel17, jLabel20});

        jTabbedPane1.addTab("Administrator", jPanel7);

        jLabel21.setText("Subject");

        jTextField7.setMaximumSize(new java.awt.Dimension(250, 20));
        jTextField7.setMinimumSize(new java.awt.Dimension(250, 20));

        jLabel22.setText("Message");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jButton17.setText("Send");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton17)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(605, Short.MAX_VALUE))
        );

        jPanel10Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel21, jLabel22});

        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton17)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Support", jPanel10);

        jLabel9.setText("Logged in as");

        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("About");

        jMenuItem2.setText("About Us");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        jMenuItem3.setText("User Manual");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jButton5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// Logs the user out and returns to main interface
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?",
                "Logout", JOptionPane.YES_NO_OPTION);
        if (msg == 0) {
            this.dispose();
            MyData.setUsername(null);
            JFrame MyGui = new MyGui();
            MyGui.setLocationRelativeTo(null);
            MyGui.setVisible(true);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed
    // Changes the users email in DB from My Account tab
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your email?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (msg == 0) {
            String username = MyData.getUsername();
            String email = jTextField3.getText();
            try {
                DatabaseConnection.changeEmail(username, email);
                Logged.jLabel12.setForeground(Color.green);
                Logged.jLabel12.setText("Your email has been changed succesfully");
            } catch (Exception e) {
                Logged.jLabel12.setForeground(Color.red);
                Logged.jLabel12.setText("Your email was not changed");
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed
    // changes user's password in DB from My Account tab
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to change your password?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (msg == 0) {
            String username = MyData.getUsername();
            String password = new String(jPasswordField4.getPassword());
            byte[] salt = Encrypt.salt();
            String pass = Encrypt.hash(password, salt);
            try {
                DatabaseConnection.changeAccountPassword(username, pass, salt);
                Logged.jLabel12.setForeground(Color.green);
                Logged.jLabel12.setText("Your password has been changed succesfully");
                if (jLabel24.getText().equals("Please change your account password before you log out!")) {
                    jLabel24.setText("");
                }
            } catch (Exception e) {
                Logged.jLabel12.setForeground(Color.red);
                Logged.jLabel12.setText("Your password has not been changed");
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed
    // opens a new file chooser and sets according data in MyData
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("File Locker");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String f = chooser.getSelectedFile().getName();
            System.out.println(f);
            String filepath = chooser.getSelectedFile().getAbsolutePath();
            MyData.setFile_path(filepath);
            MyData.setFile_name(f);
            Logged.jTextField10.setText(filepath);
            MyData.setFile_dir(chooser.getCurrentDirectory().toString());
        }
    }//GEN-LAST:event_jButton4ActionPerformed
    // Decrypts file, procedure for lock similar to user login, refer to MyGui method submitData
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jLabel27.setIcon(new ImageIcon("ajax-loader.gif"));
        jLabel27.setText("Loading...");
        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected void done() {
                jLabel27.setIcon(null);
                jLabel27.setText("");
                jPasswordField3.setText("");
                jTextField10.setText("");
            }

            @Override
            protected Void doInBackground() {
//get file name and password
                String password = new String(jPasswordField3.getPassword());
                String filename = MyData.getFile_name();
                //checks DB for file name
                if (DatabaseConnection.checkFileName(filename)) {
                    // checks DB for the counter of the file
                    if (DatabaseConnection.getFileCounter(filename) >= 3) {
                        DatabaseConnection.resetFileCounter(filename); // resets counter
                        String otp = UUID.randomUUID().toString(); // generates OTP
                        byte[] salt = Encrypt.salt(); //generate salt
                        String pass = Encrypt.hash(otp, salt);// hashes password and salt
                        try {
                            // change file password in DB to new password(OTP) and new salt
                            DatabaseConnection.changeFilePassword(filename, pass, salt);
                            // sends the user an email containing the OTP
                            Mail.sendMail(DatabaseConnection.getEmail(MyData.getUsername()), otp, 1);
                        } catch (Exception e) {
                        }
                        jLabel11.setForeground(Color.red);
                        jLabel11.setText("Your file has been locked. Please check your email");
                    } else {
                        // gets salt for file and checks password and salt hashed against DB data
                        byte[] salt = DatabaseConnection.getSaltFile(filename);
                        byte[] keyBytes = DatabaseConnection.getKeyBytes(filename);
                        boolean isUser = DatabaseConnection.checkFilePassword(filename, password, salt);
                        if (!isUser) {
                            jLabel11.setForeground(Color.red);
                            jLabel11.setText("Invalid Password. Please try again.");
                        } else {
                            try {
                                //removes encrypted file name tag from end of string name
                                String filenameDec = MyData.getFile_name();
                                filenameDec = filenameDec.substring(0, filenameDec.length() - 3);
                                //opens input and output streams for decryption
                                FileInputStream input = new FileInputStream(MyData.getFile_path());
                                FileOutputStream output = new FileOutputStream(MyData.getFile_dir() + "\\" + filenameDec);
                                // decrypts the file, refer to Encrypt class for more information
                                Encrypt.decryptFile(password, input, output, salt, keyBytes);
                                // deletes encrypted file entry in DB
                                DatabaseConnection.deleteFile(filename);
                                try {
                                    // deletes the encrypted file from storage
                                    File file = new File(MyData.getFile_path());
                                    file.delete();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                jLabel11.setForeground(Color.green);
                                jLabel11.setText("File: " + filenameDec + " Decrypted!");
                            } catch (Exception e) {
                            }
                        }
                    }
                } else {
                    jLabel11.setForeground(Color.red);
                    jLabel11.setText("No such file in the database");
                }
                return null;
            }
        };
        mySwingWorker.execute();
    }//GEN-LAST:event_jButton3ActionPerformed
    // opens a new file chooser for user to select file and sets data in MyData object
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("File Locker");
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String f = chooser.getSelectedFile().getName();
            String filepath = chooser.getSelectedFile().getAbsolutePath();
            MyData.setFile_path(filepath);
            MyData.setFile_name(f);
            MyData.setFile_dir(chooser.getCurrentDirectory().toString());
            if ("".equals(jTextArea1.getText())) {
                Logged.jTextArea1.setText(filepath);
            } else {
                Logged.jTextArea1.append("\n" + filepath);
            }
            ArrayList<String> temp = new ArrayList<>();
            temp.add(f);
            temp.add(filepath);
            temp.add(chooser.getCurrentDirectory().toString());
            MyData.getFilesToEnc().add(temp);
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    // encrypts the selected file with inputed password
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabel26.setIcon(new ImageIcon("ajax-loader.gif"));
        jLabel26.setText("Loading...");

        SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected void done() {
                jLabel26.setIcon(null);
                jLabel26.setText("");
                jPasswordField1.setText("");
                jPasswordField2.setText("");
                jTextArea1.setText("");
            }

            @Override
            protected Void doInBackground() {

                String password = new String(jPasswordField1.getPassword()); // gets password
                String password2 = new String(jPasswordField2.getPassword()); // gets password confirmation
                if (password.equals(password2) && !password.equals("")) { // checks if inputed passwords match
                    ArrayList<ArrayList<String>> files = MyData.getFilesToEnc();
                    for (ArrayList<String> fileInfo : files) {
                        String fname = fileInfo.get(0);
                        String fpath = fileInfo.get(1);
                        String fdir = fileInfo.get(2);
                        MyData.setFile_name(fname);
                        MyData.setFile_path(fpath);
                        MyData.setFile_dir(fdir);
//                        System.out.println(fname + "  " + fpath + "  " + fdir);
                        String newFilename = null;
                        try {
                            // checks if filename + standard name tag already exists in DB
                            Boolean fileExists = DatabaseConnection.checkFileName(MyData.getFile_name() + "FL0");
                            // if file exists the index of the tag is incremented until there is no such entry in DB
                            // tags increment as FL0, FL1, FL2 etc.
                            if (fileExists) {
                                int i = 1;
                                while (fileExists) {
                                    newFilename = MyData.getFile_name() + "FL" + i;
                                    fileExists = DatabaseConnection.checkFileName(newFilename);
                                    i++;
                                }
                            } else {
                                newFilename = MyData.getFile_name() + "FL0";
                            }
                            // input and output streams opened for encryption
                            FileInputStream input = new FileInputStream(MyData.getFile_path());
                            FileOutputStream output = new FileOutputStream(MyData.getFile_dir() + "\\" + newFilename);
                            byte[] salt = Encrypt.salt();// generates new salt
                            // encrypts file, refer to Encrypt class for more information
                            byte[] keyBytes = Encrypt.encryptFile(password, input, output, salt);
                            Integer user_id = DatabaseConnection.getUserId(); // gets current user's id
                            String pass = Encrypt.hash(password, salt); // hashes password and salt
                            // inserts the new file name and all its info into DB
                            DatabaseConnection.insertFile(newFilename, user_id, pass, salt, keyBytes);
                            try {
                                // deletes original file from storage
                                File file = new File(MyData.getFile_path());
                                file.delete();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            jLabel10.setForeground(Color.green);
                            jLabel10.setText("File: " + MyData.getFile_name() + " succesfully protected");
                        } catch (FileNotFoundException ex) {

                        }
                    }
                    jLabel10.setForeground(Color.green);
                    jLabel10.setText("All files have been succesfully encrypted");
                } else {
                    jLabel10.setForeground(Color.red);
                    jLabel10.setText("Passwords Mismatch. Please try again.");
                }
                return null;
            }

        };
        mySwingWorker.execute();

    }//GEN-LAST:event_jButton1ActionPerformed
    // Administrator's change password function for users
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the password?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (msg == 0) {
            String username = jComboBox1.getSelectedItem().toString(); // gets username from combobox
            String password = new String(jPasswordField5.getPassword());// gets new password from admin input
            byte[] salt = Encrypt.salt(); // generates new salt
            String pass = Encrypt.hash(password, salt); // hashes password and salt
            try {
                // changes password for given user's account
                DatabaseConnection.changeAccountPassword(username, pass, salt);
                Logged.jLabel17.setForeground(Color.green);
                Logged.jLabel17.setText("Password has been changed succesfully");
            } catch (Exception e) {
                Logged.jLabel17.setForeground(Color.red);
                Logged.jLabel17.setText("Password has not been changed");
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed
    // administrator's change email for user
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the email?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (msg == 0) {
            String username = jComboBox1.getSelectedItem().toString();// gets username from combobox
            String email = jTextField4.getText();// gets new email input from admin
            try {
                //changes user's email to admin input
                DatabaseConnection.changeEmail(username, email);
                jTextField4.setText(DatabaseConnection.getEmail(username));
                Logged.jLabel17.setForeground(Color.green);
                Logged.jLabel17.setText("Email has been changed succesfully");
                jTextField4.setText(email);
            } catch (Exception e) {
                Logged.jLabel17.setForeground(Color.red);
                Logged.jLabel17.setText("Email has not been changed");
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed
    // administrator's change username for users
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the username?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (msg == 0) {
            String usernameOLD = jComboBox1.getSelectedItem().toString();// get old username
            String usernameNEW = jTextField2.getText();// get new username from input
            try {
                // changes the username in the DB to the new username
                DatabaseConnection.changeUsername(usernameNEW, usernameOLD);
                jComboBox1.addItem(usernameNEW);
                jComboBox1.removeItem(usernameOLD);
                jComboBox1.setSelectedItem(usernameNEW);
                jTextField2.setText(usernameNEW);
                Logged.jLabel17.setForeground(Color.green);
                Logged.jLabel17.setText("Username has been changed succesfully");
                jTextField2.setText(usernameNEW);
            } catch (Exception e) {
                Logged.jLabel17.setForeground(Color.red);
                Logged.jLabel17.setText("Username has not been changed");
            }
        }
    }//GEN-LAST:event_jButton11ActionPerformed
    // administrator's search for users
    // input string
    // output list to combobox
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jComboBox1.removeAllItems();
        DatabaseConnection.searchUsers(jTextField5.getText());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed

    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed

    }//GEN-LAST:event_jComboBox2ActionPerformed
    // administrator's search for user files
    // input selected item in combobox1
    // output list to combobox2
    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        jComboBox2.removeAllItems();
        String username = jComboBox1.getSelectedItem().toString();
        DatabaseConnection.searchFiles(username);
        if (jComboBox2.getItemCount() == 0) {
            jLabel25.setForeground(Color.red);
            jLabel25.setText("User has no files in database");
        }
    }//GEN-LAST:event_jButton12ActionPerformed
    // sets user information to be edited by administrator in appropriete fields
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        String username = jComboBox1.getSelectedItem().toString();
        if (username.equals("")) {
            jLabel25.setForeground(Color.red);
            jLabel25.setText("Please search and select a user");
        } else {
            int status = DatabaseConnection.getUserStatus(username);
            String stat;
            if (status == 0) {
                stat = "User";
            } else {
                stat = "Administrator";
            }
            jTextField2.setText(username);
            jTextField8.setText(stat);
            jTextField4.setText(DatabaseConnection.getEmail(username));
    }//GEN-LAST:event_jButton13ActionPerformed
    }
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed

    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jPasswordField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField5ActionPerformed

    }//GEN-LAST:event_jPasswordField5ActionPerformed

    private void jPasswordField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField6ActionPerformed

    }//GEN-LAST:event_jPasswordField6ActionPerformed
    // changes file password for user by administrator
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the file password?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (msg == 0) {
            String filename = jComboBox2.getSelectedItem().toString();// gets filename from combobox
            String password = new String(jPasswordField6.getPassword());// gets new password from admin input
            byte[] salt = Encrypt.salt();// generates new salt
            String pass = Encrypt.hash(password, salt);// hashes password and salt
            try {
                // changes file password in DB
                DatabaseConnection.changeFilePassword(filename, pass, salt);
                Logged.jLabel20.setForeground(Color.green);
                Logged.jLabel20.setText("Password has been changed succesfully");
            } catch (Exception e) {
                Logged.jLabel20.setForeground(Color.red);
                Logged.jLabel20.setText("Password has not been changed");
            }
    }//GEN-LAST:event_jButton14ActionPerformed
    }
    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed

    }//GEN-LAST:event_jTextField6ActionPerformed
    // administrator's change file name for user file
    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to change the file name?",
                "Confirmation", JOptionPane.YES_NO_OPTION);
        if (msg == 0) {
            String filenameOLD = jComboBox2.getSelectedItem().toString();//gets current file name
            String filenameNEW = jTextField6.getText();// gets new file name from admin input
            try {
                // changes file name from old to new
                DatabaseConnection.changeFilename(filenameNEW, filenameOLD);
                jComboBox2.addItem(filenameNEW);
                jComboBox2.removeItem(filenameOLD);
                jComboBox2.setSelectedItem(filenameNEW);
                jTextField6.setText(filenameNEW);
                Logged.jLabel20.setForeground(Color.green);
                Logged.jLabel20.setText("File Name has been changed succesfully");
            } catch (Exception e) {
                Logged.jLabel20.setForeground(Color.red);
                Logged.jLabel20.setText("File Name has not been changed");
            }
        }
    }//GEN-LAST:event_jButton16ActionPerformed
    //sets information about files to field for view and change
    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String filename = jComboBox2.getSelectedItem().toString();
        if (filename.equals("")) {
            jLabel25.setForeground(Color.red);
            jLabel25.setText("Please press get files button and select a file");
        } else {
            jTextField6.setText(filename);

        }
    }//GEN-LAST:event_jButton15ActionPerformed
    // User submit message that sends email to administrator.
    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        String subject = jTextField7.getText();// gets subject text
        String message = jTextArea3.getText();// gets actual message
        String sender = MyData.getUsername(); // gets username of the sender
        try {
            // sends an email via SMTP to administrator using JavaMail API
            Mail.contactUs(sender, subject, message);
            jLabel23.setForeground(Color.green);
            jLabel23.setText("Your message has been sent succesfully");
        } catch (Exception e) {
            jLabel23.setForeground(Color.red);
            jLabel23.setText("There was an error sending your msg. Please check your internet connection");
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        String username = jComboBox1.getSelectedItem().toString();
        if (DatabaseConnection.getUserStatus(username) == 0) {
            int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want to grant this user administrator privileges?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
            if (msg == 0) {
                try {
                    DatabaseConnection.setUserStatus(username, 1);
                    Logged.jLabel17.setForeground(Color.green);
                    Logged.jLabel17.setText("User has been granted administrator privileges");
                    jTextField8.setText("Administrator");
                } catch (Exception e) {
                    Logged.jLabel17.setForeground(Color.red);
                    Logged.jLabel17.setText("User has NOT been granted administrator privileges");
                }
            }
        } else {
            int msg = JOptionPane.showConfirmDialog(null, "Are you sure you want remove this user's administrator privileges?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
            if (msg == 0) {
                try {
                    DatabaseConnection.setUserStatus(username, 0);
                    Logged.jLabel17.setForeground(Color.green);
                    Logged.jLabel17.setText("Administrator has been demoted to user");
                    jTextField8.setText("User");
                } catch (Exception e) {
                    Logged.jLabel17.setForeground(Color.red);
                    Logged.jLabel17.setText("Administrator has NOT been demoted to user");
                }
            }
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField10ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        JFrame AboutUs = new AboutUs();
        AboutUs.setLocationRelativeTo(null);
        AboutUs.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        JFrame UserManual = new UserManual();
        UserManual.setLocationRelativeTo(null);
        UserManual.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton10;
    public static javax.swing.JButton jButton11;
    public static javax.swing.JButton jButton12;
    public static javax.swing.JButton jButton13;
    public static javax.swing.JButton jButton14;
    public static javax.swing.JButton jButton15;
    public static javax.swing.JButton jButton16;
    public static javax.swing.JButton jButton17;
    public static javax.swing.JButton jButton18;
    public static javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    public static javax.swing.JButton jButton7;
    public static javax.swing.JButton jButton8;
    public static javax.swing.JButton jButton9;
    public static javax.swing.JComboBox jComboBox1;
    public static javax.swing.JComboBox jComboBox2;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel12;
    public static javax.swing.JLabel jLabel13;
    public static javax.swing.JLabel jLabel14;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    public static javax.swing.JLabel jLabel18;
    public static javax.swing.JLabel jLabel19;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel20;
    public static javax.swing.JLabel jLabel21;
    public static javax.swing.JLabel jLabel22;
    public static javax.swing.JLabel jLabel23;
    public static javax.swing.JLabel jLabel24;
    public static javax.swing.JLabel jLabel25;
    public static javax.swing.JLabel jLabel26;
    public static javax.swing.JLabel jLabel27;
    public static javax.swing.JLabel jLabel28;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JMenu jMenu1;
    public static javax.swing.JMenu jMenu2;
    public static javax.swing.JMenu jMenu3;
    public static javax.swing.JMenuBar jMenuBar1;
    public static javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem2;
    public static javax.swing.JMenuItem jMenuItem3;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel10;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    public static javax.swing.JPanel jPanel6;
    public static javax.swing.JPanel jPanel7;
    public static javax.swing.JPanel jPanel8;
    public static javax.swing.JPanel jPanel9;
    public static javax.swing.JPasswordField jPasswordField1;
    public static javax.swing.JPasswordField jPasswordField2;
    public static javax.swing.JPasswordField jPasswordField3;
    public static javax.swing.JPasswordField jPasswordField4;
    public static javax.swing.JPasswordField jPasswordField5;
    public static javax.swing.JPasswordField jPasswordField6;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea3;
    public static javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField jTextField10;
    public static javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
