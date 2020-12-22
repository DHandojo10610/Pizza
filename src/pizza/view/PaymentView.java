package pizza.view;

import pizza.database.Cart;
import pizza.database.Transaction;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PaymentView extends javax.swing.JFrame {
    private String email = "anonymous@gmail.com";
    private ArrayList<Object[]> cart = new ArrayList<>();

    PaymentView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    void setEmail(String email){
        this.email = email;
        renderCartUser();
    }

    private void renderCartUser(){
        DefaultTableModel model = (DefaultTableModel) tableCart.getModel();
        model.setRowCount(0);

        ArrayList<Object[]> data = Cart.getCartUser(email);
        comboItem.removeAllItems();
        cart.clear();

        if (data != null) {
            for (Object[] cartData : data) {
                cart.add(cartData);
                comboItem.addItem(cartData[0].toString());
                Object[] dataTable = {cartData[0], cartData[1]};
                model.addRow(dataTable);
            }
        }
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        scrollPaneTable = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        comboItem = new javax.swing.JComboBox<>();
        removeLabel = new javax.swing.JLabel();
        bRemove = new javax.swing.JButton();
        bOrder = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        bBack = new javax.swing.JButton();
        paymentLabel = new javax.swing.JLabel();
        comboPayment = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cart");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Menu", "Qty"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPaneTable.setViewportView(tableCart);
        if (tableCart.getColumnModel().getColumnCount() > 0) {
            tableCart.getColumnModel().getColumn(0).setResizable(false);
            tableCart.getColumnModel().getColumn(1).setResizable(false);
        }

        removeLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        removeLabel.setForeground(new java.awt.Color(0, 0, 0));
        removeLabel.setText("Remove from cart");

        bRemove.setText("Remove");
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });

        bOrder.setText("Order now");
        bOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrderActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setText("My Cart");

        bBack.setText("Back");
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });

        paymentLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        paymentLabel.setForeground(new java.awt.Color(0, 0, 0));
        paymentLabel.setText("Select Payment");

        comboPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BRI", "BNI", "MANDIRI", "BCA", "OVO", "GOPAY" }));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(bBack, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(scrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGap(146, 146, 146)
                                                .addComponent(titleLabel)))
                                .addGap(54, 54, 54)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(removeLabel)
                                        .addComponent(bRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(paymentLabel))
                                .addContainerGap(89, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(bBack)
                                .addGap(18, 18, 18)
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(removeLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bRemove)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                                .addComponent(paymentLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(comboPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bOrder))
                                        .addComponent(scrollPaneTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(44, 44, 44))
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

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {
        MenuView menu = new MenuView();
        menu.setVisible(true);
        menu.setEmail(email);
        this.setVisible(false);
    }

    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        String menu = Objects.requireNonNull(comboItem.getSelectedItem()).toString();

        int rowAffected = Cart.removeItemCart(email, menu);

        if (rowAffected > 0) {
            JOptionPane.showMessageDialog(null, "Success remove " + menu +" from cart!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Failed remove menu from cart!", "Alert", JOptionPane.ERROR_MESSAGE);
        }
        renderCartUser();
    }

    private void bOrderActionPerformed(java.awt.event.ActionEvent evt) {
        if(cart.isEmpty()){
            JOptionPane.showMessageDialog(null, "Cart Empty!");
        }else {
            Date date = new Date();
            String trx = "TRX-" + date.getTime();
            for(Object[] menu : cart){
                String menuUser = menu[0].toString();
                int qtyUser = Integer.parseInt(menu[1].toString());
                Transaction.addTransaction(trx, email, menuUser, qtyUser);
            }

            String paymentMethod = Objects.requireNonNull(comboPayment.getSelectedItem()).toString();
            PaymentView payment = new PaymentView();
            payment.setVisible(true);
            payment.setEmail(email);
            payment.setTrx(trx);
            payment.setCode(paymentMethod);
            payment.setPaymentNumber();
            this.setVisible(false);
        }
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
            java.util.logging.Logger.getLogger(CartView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CartView().setVisible(true);
            }
        });
    }

    private javax.swing.JButton bBack;
    private javax.swing.JButton bOrder;
    private javax.swing.JButton bRemove;
    private javax.swing.JComboBox<String> comboItem;
    private javax.swing.JComboBox<String> comboPayment;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel paymentLabel;
    private javax.swing.JLabel removeLabel;
    private javax.swing.JScrollPane scrollPaneTable;
    private javax.swing.JTable tableCart;
    private javax.swing.JLabel titleLabel;
}