package pos;

public class Home extends javax.swing.JFrame {

    JpanelLoader JPanelContent = new JpanelLoader();

    public Home() {
        initComponents();
        this.setExtendedState(Home.MAXIMIZED_BOTH);
        this.setTitle("Pos System");
        this.setDefaultCloseOperation(Home.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        home_bnt_grp = new javax.swing.ButtonGroup();
        ButtonGroupPanel = new javax.swing.JPanel();
        CustomerPageButton = new javax.swing.JToggleButton();
        ProductPageButton = new javax.swing.JToggleButton();
        SalePageButton = new javax.swing.JToggleButton();
        InvoicePageButton = new javax.swing.JToggleButton();
        panel_load = new javax.swing.JPanel();
        TopPanel = new javax.swing.JPanel();
        TitleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ButtonGroupPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        home_bnt_grp.add(CustomerPageButton);
        CustomerPageButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CustomerPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/customer.png"))); // NOI18N
        CustomerPageButton.setText("Customers");
        CustomerPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerPageButtonActionPerformed(evt);
            }
        });

        home_bnt_grp.add(ProductPageButton);
        ProductPageButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ProductPageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/product.png"))); // NOI18N
        ProductPageButton.setText("Product");
        ProductPageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductPageButtonActionPerformed(evt);
            }
        });

        home_bnt_grp.add(SalePageButton);
        SalePageButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SalePageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/sales_menu.png"))); // NOI18N
        SalePageButton.setText("Sales");
        SalePageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalePageButtonActionPerformed(evt);
            }
        });

        home_bnt_grp.add(InvoicePageButton);
        InvoicePageButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        InvoicePageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pos/img/invo.png"))); // NOI18N
        InvoicePageButton.setText("Invoice");
        InvoicePageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvoicePageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ButtonGroupPanelLayout = new javax.swing.GroupLayout(ButtonGroupPanel);
        ButtonGroupPanel.setLayout(ButtonGroupPanelLayout);
        ButtonGroupPanelLayout.setHorizontalGroup(
            ButtonGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonGroupPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ButtonGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustomerPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProductPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalePageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InvoicePageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ButtonGroupPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {CustomerPageButton, InvoicePageButton, ProductPageButton, SalePageButton});

        ButtonGroupPanelLayout.setVerticalGroup(
            ButtonGroupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonGroupPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CustomerPageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProductPageButton)
                .addGap(18, 18, 18)
                .addComponent(SalePageButton)
                .addGap(18, 18, 18)
                .addComponent(InvoicePageButton)
                .addContainerGap(409, Short.MAX_VALUE))
        );

        ButtonGroupPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {CustomerPageButton, InvoicePageButton, ProductPageButton, SalePageButton});

        panel_load.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout panel_loadLayout = new javax.swing.GroupLayout(panel_load);
        panel_load.setLayout(panel_loadLayout);
        panel_loadLayout.setHorizontalGroup(
            panel_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        panel_loadLayout.setVerticalGroup(
            panel_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        TopPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        TitleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TitleLabel.setText("Pos System");

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ButtonGroupPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonGroupPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel_load, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Show the Customer Page
    private void CustomerPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerPageButtonActionPerformed
        CustomerUI cus = new CustomerUI();
        JPanelContent.jPanelLoader(panel_load, cus);
    }//GEN-LAST:event_CustomerPageButtonActionPerformed

    // Show the Product Page
    private void ProductPageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductPageButtonActionPerformed

        ProductUI pro = new ProductUI();
        JPanelContent.jPanelLoader(panel_load, pro);


    }//GEN-LAST:event_ProductPageButtonActionPerformed

    // Show the Sale page
    private void SalePageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalePageButtonActionPerformed

        SaleUI sl = new SaleUI();
        JPanelContent.jPanelLoader(panel_load, sl);


    }//GEN-LAST:event_SalePageButtonActionPerformed

    // Show the Invoice page
    private void InvoicePageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvoicePageButtonActionPerformed

        InvoiceUI inv = new InvoiceUI();
        JPanelContent.jPanelLoader(panel_load, inv);
    }//GEN-LAST:event_InvoicePageButtonActionPerformed

    
//    Call the main of HomeUi separately for testing
    
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Home().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ButtonGroupPanel;
    private javax.swing.JToggleButton CustomerPageButton;
    private javax.swing.JToggleButton InvoicePageButton;
    private javax.swing.JToggleButton ProductPageButton;
    private javax.swing.JToggleButton SalePageButton;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JPanel TopPanel;
    private javax.swing.ButtonGroup home_bnt_grp;
    private javax.swing.JPanel panel_load;
    // End of variables declaration//GEN-END:variables
}
