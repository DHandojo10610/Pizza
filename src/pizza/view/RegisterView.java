package pizza.view;

import pizza.database.User;

import javax.swing.*;

public class RegisterView extends javax.swing.JFrame {

    RegisterView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void initComponents() {
        mainPanel = new javax.swing.JPanel();
        registerLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        bRegister = new javax.swing.JButton();
        aLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Register");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        registerLabel.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(0, 0, 0));
        registerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel.setText("Register new account");

        emailLabel.setText("Email");

        passwordLabel.setText("Password");

        bRegister.setText("Register");
        bRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegisterActionPerformed(evt);
            }
        });

        aLogin.setBackground(new java.awt.Color(0, 0, 0));
        aLogin.setForeground(new java.awt.Color(0, 0, 0));
        aLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aLogin.setText("Back to login");
        aLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aLoginMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(registerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(passwordLabel)
                                                        .addComponent(emailLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                                        .addComponent(tfPassword)))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(157, 157, 157)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(bRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(aLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(105, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(registerLabel)
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(emailLabel)
                                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordLabel)
                                        .addComponent(tfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(bRegister)
                                .addGap(18, 18, 18)
                                .addComponent(aLogin)
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }


    private void aLoginMouseClicked(java.awt.event.MouseEvent evt) {
        new LandingView().setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    private void bRegisterActionPerformed(java.awt.event.ActionEvent evt) {
        String emailField = tfEmail.getText();

        int result = User.getAccountByEmail(emailField);

        if (result == 1) {
            JOptionPane.showMessageDialog(null, "Email has been registered!", "Alert",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            StringBuilder passwordField = new StringBuilder();
            for (char code : tfPassword.getPassword()) {
                passwordField.append(code);
            }

            int rowAffected = User.addUser(emailField, passwordField.toString());

            if (rowAffected > 0) {
                JOptionPane.showMessageDialog(null, "Registration success!", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to register!", "Alert",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private javax.swing.JLabel aLogin;
    private javax.swing.JButton bRegister;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JPasswordField tfPassword;
}