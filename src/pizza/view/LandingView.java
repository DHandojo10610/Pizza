package pizza.view;

import pizza.database.User;

import javax.swing.*;

public class LandingView extends javax.swing.JFrame {

    LandingView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        iconPizza = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        underlineLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        bLogin = new javax.swing.JButton();
        bRegister = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Landing");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setForeground(new java.awt.Color(255, 255, 255));

        iconPizza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/pizza-bg" +
                ".png"))); // NOI18N

        titleLabel.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(225, 83, 86));
        titleLabel.setText("PIZZA");

        underlineLabel.setForeground(new java.awt.Color(225, 83, 86));
        underlineLabel.setText("____________________________");

        emailLabel.setText("Email");

        passwordLabel.setText("Password");

        bLogin.setText("Login");
        bLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoginActionPerformed(evt);
            }
        });

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

}

    private javax.swing.JButton bLogin;
    private javax.swing.JButton bRegister;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel iconPizza;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel underlineLabel;
}