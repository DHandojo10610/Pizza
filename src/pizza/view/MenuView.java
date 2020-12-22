package pizza.view;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import pizza.database.Menu;
import pizza.database.Cart;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;

public class MenuView extends javax.swing.JFrame {
    private ArrayList<String[]> dataMenu = new ArrayList<>();

    MenuView() {
        initComponents();
        numberCheckout.setEditable(false);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        numberCheckout.setColumns(2);
    }

    void setEmail(String email){
        emailLabel.setText(email);
        getStock();
    }

    private void getStock(){
        dataMenu = Menu.getMenu();
    }

    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        comboMenu = new javax.swing.JComboBox<>();
        displayImage = new javax.swing.JLabel();
        numberCheckout = new javax.swing.JTextField();
        bIncrement = new javax.swing.JButton();
        bDecrement = new javax.swing.JButton();
        bAddToCart = new javax.swing.JButton();
        stockLabel = new javax.swing.JLabel();
        numberStock = new javax.swing.JLabel();
        loggedLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        aLogout = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        numberPrice = new javax.swing.JLabel();
        bGoToCart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        comboMenu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Menu",
                "Meatlover", "American Favourite", "Great Sausage", "Mac and Cheese", "Hawaiian", "Chicken Alfredo", "California Style", "Lemon Tea", "Alpukat Juice", "Vanila Milkshake" }));
        comboMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMenuActionPerformed(evt);
            }
        });

        displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/preview" +
                ".png"))); // NOI18N

        numberCheckout.setText("10");

        bIncrement.setText("+");
        bIncrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIncrementActionPerformed(evt);
            }
        });

        bDecrement.setText("-");
        bDecrement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDecrementActionPerformed(evt);
            }
        });

        bAddToCart.setText("Add to cart");
        bAddToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddToCartActionPerformed(evt);
            }
        });

        stockLabel.setText("Stock : ");

        numberStock.setText("-");

        loggedLabel.setForeground(new java.awt.Color(0, 0, 0));
        loggedLabel.setText("Logged as :");

        emailLabel.setForeground(new java.awt.Color(0, 0, 0));
        emailLabel.setText("anonymous@gmail.com");

        aLogout.setBackground(new java.awt.Color(255, 0, 0));
        aLogout.setForeground(new java.awt.Color(255, 0, 0));
        aLogout.setText("Logout");
        aLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aLogoutMouseClicked(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(0, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Select Menu");

        priceLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceLabel.setText("Harga :");

        numberPrice.setForeground(new java.awt.Color(0, 0, 0));
        numberPrice.setText("Rp. 0,00");

        bGoToCart.setText("My Cart");
        bGoToCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGoToCartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(emailLabel)
                                                        .addComponent(loggedLabel))
                                                .addContainerGap(392, Short.MAX_VALUE))
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(aLogout)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                                                        .addGap(49, 49, 49)
                                                                        .addComponent(stockLabel)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(numberStock)
                                                                        .addGap(65, 65, 65))
                                                                .addComponent(displayImage))
                                                        .addComponent(bAddToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(74, 74, 74))))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bGoToCart, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(comboMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(priceLabel)
                                                .addComponent(numberPrice))
                                        .addGap(122, 122, 122)
                                        .addComponent(bDecrement, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(numberCheckout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(95, Short.MAX_VALUE)))
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bGoToCart)
                                        .addComponent(titleLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                .addComponent(displayImage)
                                .addGap(4, 4, 4)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(stockLabel)
                                        .addComponent(numberStock))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(loggedLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(emailLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(aLogout)
                                        .addComponent(bAddToCart))
                                .addGap(13, 13, 13))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGap(106, 106, 106)
                                        .addComponent(comboMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(priceLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(numberPrice)
                                        .addGap(81, 81, 81)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                                .addComponent(numberCheckout)
                                                .addComponent(bDecrement, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addComponent(bIncrement, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addContainerGap(53, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }

    private void aLogoutMouseClicked(java.awt.event.MouseEvent evt) {
        new LandingView().setVisible(true);
        this.setVisible(false);
    }

    private void comboMenuActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedMenu = Objects.requireNonNull(comboMenu.getSelectedItem()).toString();
        int price;
        switch(selectedMenu){
            case "Alpukat Juice":
                price = 45000;
                numberStock.setText(dataMenu.get(0)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/alpukat.png")));
                break;
            case "American Favourite":
                price = 150000;
                numberStock.setText(dataMenu.get(1)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/american.png")));
                break;
            case "California Style":
                price = 120000;
                numberStock.setText(dataMenu.get(2)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/california.png")));
                break;
            case "Chicken Alfredo":
                price = 130000;
                numberStock.setText(dataMenu.get(3)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/chicken_alfredo.png")));
                break;
            case "Great Sausage":
                price = 140000;
                numberStock.setText(dataMenu.get(4)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/sausages.png")));
                break;
            case "Hawaiian":
                price = 135000;
                numberStock.setText(dataMenu.get(5)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/hawaiian.png")));
                break;
            case "Lemon Tea":
                price = 30000;
                numberStock.setText(dataMenu.get(6)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/lemontea.png")));
                break;
            case "Mac and Cheese":
                price = 160000;
                numberStock.setText(dataMenu.get(7)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/macncheese.png")));
                break;
            case "Meatlover":
                price = 125000;
                numberStock.setText(dataMenu.get(8)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/meatlover.png")));
                break;
            case "Vanila Milkshake":
                price = 50000;
                numberStock.setText(dataMenu.get(9)[1]);
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/vanilla.png")));
                break;
            default:
                price = 0;
                numberStock.setText("-");
                displayImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pizza/img/preview.png")));
        }
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        numberPrice.setText(kursIndonesia.format(price));
    }

    private void bIncrementActionPerformed(java.awt.event.ActionEvent evt) {
        int displayQty = Integer.parseInt(numberCheckout.getText()) + 1;
        numberCheckout.setText("" + displayQty);
    }

    private void bDecrementActionPerformed(java.awt.event.ActionEvent evt) {
        int displayQty = Integer.parseInt(numberCheckout.getText());
        if(displayQty > 1)
            displayQty--;
        numberCheckout.setText("" + displayQty);
    }

    private void bGoToCartActionPerformed(java.awt.event.ActionEvent evt) {
        CartView cartView = new CartView();
        cartView.setVisible(true);
        cartView.setEmail(emailLabel.getText());
        this.setVisible(false);
    }

    private void bAddToCartActionPerformed(java.awt.event.ActionEvent evt) {
        String menu = Objects.requireNonNull(comboMenu.getSelectedItem()).toString();
        if(menu.equalsIgnoreCase("Select Menu")){
            JOptionPane.showMessageDialog(null, "Invalid Menu!");
        }else {
            String email = emailLabel.getText();
            int qty = Integer.parseInt(numberCheckout.getText());
            int stock = Integer.parseInt(numberStock.getText());

            if(qty > stock){
                JOptionPane.showMessageDialog(null, "Not enough stock!", "Alert", JOptionPane.ERROR_MESSAGE);
            }else {
                int rowAffected = Cart.addCart(email, menu, stock, qty);

                if (rowAffected > 0) {
                    getStock();
                    for(String[] cariMenu : dataMenu){
                        if(cariMenu[0].equalsIgnoreCase(menu)){
                            numberStock.setText(cariMenu[1]);
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Success add to cart!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed add to cart!", "Alert", JOptionPane.ERROR_MESSAGE);
                }
            }
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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel aLogout;
    private javax.swing.JButton bAddToCart;
    private javax.swing.JButton bDecrement;
    private javax.swing.JButton bGoToCart;
    private javax.swing.JButton bIncrement;
    private javax.swing.JComboBox<String> comboMenu;
    private javax.swing.JLabel displayImage;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel loggedLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField numberCheckout;
    private javax.swing.JLabel numberPrice;
    private javax.swing.JLabel numberStock;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JLabel titleLabel;
}