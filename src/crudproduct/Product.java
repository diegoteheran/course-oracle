/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crudproduct;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Academico
 */
public class Product extends javax.swing.JFrame {

    /**
     * Creates new form Product
     */
    public Product() {
        initComponents();
        mostrarProduct();
    }
    public void mostrarProduct(){
        try{
            Conexion cn = new Conexion();
            
            Statement statement = cn.conectar().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Product");
            
            DefaultTableModel modelo = (DefaultTableModel)tblProduct.getModel();
            modelo.setColumnCount(0);
            modelo.setRowCount(0);
            String[] columns = {"ProductId", "ProductName", "SupplierId", "CategoryId", "QuantityPerUnit", "UnitPrice", "UnitsInStock", "UnitsOnOrder", "ReorderLevel", "Discontinued"};
            
            for(String column: columns){
                modelo.addColumn(column);
            }
            
            while(resultSet.next()){
                String[] row = {
                    String.valueOf(resultSet.getInt("ProductId")),
                    resultSet.getString("ProductName"),
                    resultSet.getString("SupplierId"),
                    resultSet.getString("CategoryId"),
                    resultSet.getString("QuantityPerUnit"),
                    resultSet.getString("UnitPrice"),
                    resultSet.getString("UnitsInStock"),
                    resultSet.getString("UnitsOnOrder"),
                    resultSet.getString("ReorderLevel"),
                    resultSet.getString("Discontinued")
                };
                modelo.addRow(row);
        }
        tblProduct.setModel(modelo);
        } catch(SQLException e){
            e.printStackTrace();           
        }
    }
    
    public void eliminarProduct(){
        try{
            int id;
            id = Integer.parseInt(txtProductId.getText());        
            Conexion cn = new Conexion();
        
            PreparedStatement preparedStatement = cn.conectar().prepareStatement("DELETE FROM Product WHERE ProductId = ?");
            preparedStatement.setInt(1, id); 
        
            int rows = preparedStatement.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Delete row succesfull");
                mostrarProduct();
            } else {
                JOptionPane.showMessageDialog(null, "Delete row fail");
        }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void insertarProduct(){
        try{
            int id = Integer.parseInt(txtProductId.getText());
            String product = txtProductName.getText();
            int supplier = Integer.parseInt(txtSupplierId.getText());
            int category = Integer.parseInt(txtCategoryId.getText());
            String quantity = txtQuantity.getText();
            int unitprice = Integer.parseInt(txtUnitPrice.getText());
            String unitsinstock = txtUnitsInStock.getText();
            String unitsinorder = txtUnitsOnOrder.getText();
            String reorder = txtReorderLevel.getText();
            int discontinued = Integer.parseInt(txtDiscontinued.getText());
            
            Conexion cn = new Conexion();
            
            PreparedStatement ps = 
                     cn.conectar().prepareStatement("INSERT INTO Product VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1,id);
            ps.setString(2,product);
            ps.setInt(3,supplier);
            ps.setInt(4,category);
            ps.setString(5,quantity);
            ps.setInt(6,unitprice);
            ps.setString(7,unitsinstock);
            ps.setString(8,unitsinorder);
            ps.setString(9,reorder);
            ps.setInt(10,discontinued);
             
            int rows = ps.executeUpdate();
            if(rows > 0){
                JOptionPane.showMessageDialog(null, "Insert row succesfull");
                mostrarProduct();
            } else {
                JOptionPane.showMessageDialog(null, "Insert row fail");
        } 
        } catch(SQLException e){
            e.printStackTrace();
}
    }
    public void actualizarProduct() {
    try {
            int id = Integer.parseInt(txtProductId.getText());
            String product = txtProductName.getText();
            int supplier = Integer.parseInt(txtSupplierId.getText());
            int category = Integer.parseInt(txtCategoryId.getText());
            String quantity = txtQuantity.getText();
            int unitprice = Integer.parseInt(txtUnitPrice.getText());
            String unitsinstock = txtUnitsInStock.getText();
            String unitsinorder = txtUnitsOnOrder.getText();
            String reorder = txtReorderLevel.getText();
            int discontinued = Integer.parseInt(txtDiscontinued.getText());
            
            Conexion cn = new Conexion();
            Connection connection = cn.conectar();
        
            PreparedStatement ps = 
                     cn.conectar().prepareStatement("UPDATE Product SET ProductName = ?, SupplierId = ?, CategoryId = ?, QuantityPerUnit = ?, UnitPrice = ?, UnitsInStock = ?, UnitsOnOrder = ?, ReorderLevel = ?, Discontinued = ? WHERE ProductId = ?");
        
            ps.setString(1,product);
            ps.setInt(2,supplier);
            ps.setInt(3,category);
            ps.setString(4,quantity);
            ps.setInt(5,unitprice);
            ps.setString(6,unitsinstock);
            ps.setString(7,unitsinorder);
            ps.setString(8,reorder);
            ps.setInt(9,discontinued);
            ps.setInt(10,id);
        
        int rows = ps.executeUpdate();
        
        if (rows > 0) {
            JOptionPane.showMessageDialog(null, "Update row succesfull");
            mostrarProduct();
        } else {
            JOptionPane.showMessageDialog(null, "Update row succesfull");
        }
        
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProductId = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        txtSupplierId = new javax.swing.JTextField();
        txtCategoryId = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        txtUnitsInStock = new javax.swing.JTextField();
        txtUnitsOnOrder = new javax.swing.JTextField();
        txtReorderLevel = new javax.swing.JTextField();
        txtDiscontinued = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 5, 5));
        jLabel1.setText("Crud de Product");

        jLabel2.setText("Product Id:");

        jLabel3.setText("ProductName:");

        jLabel4.setText("Supplier Id:");

        jLabel5.setText("Category Id:");

        txtCategoryId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoryIdActionPerformed(evt);
            }
        });

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel6.setText("Quantity Per Unit:");

        jLabel7.setText("Unit Price:");

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProduct.setToolTipText("");
        jScrollPane2.setViewportView(tblProduct);

        jLabel8.setText("Units In Stock:");

        jLabel9.setText("Units On Order:");

        jLabel11.setText("Reorder Level:");

        jLabel12.setText("Discontinued:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jLabel5)))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addComponent(jLabel12))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUnitPrice)
                            .addComponent(txtSupplierId)
                            .addComponent(txtCategoryId)
                            .addComponent(txtProductName)
                            .addComponent(txtQuantity)
                            .addComponent(txtUnitsInStock)
                            .addComponent(txtUnitsOnOrder)
                            .addComponent(txtReorderLevel)
                            .addComponent(txtDiscontinued, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsertar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar)
                        .addGap(115, 115, 115)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtProductId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSupplierId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtUnitPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txtUnitsInStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtUnitsOnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtReorderLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDiscontinued, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(350, 390, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnInsertar)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCategoryIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoryIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryIdActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        insertarProduct();
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        actualizarProduct();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarProduct();
    }//GEN-LAST:event_btnEliminarActionPerformed
        private void tblProductMouseClicked(java.awt.event.MouseEvent evt){
        int columns = tblProduct.getSelectedColumn();
        int row = tblProduct.getSelectedRow();
        
        tblProduct.getModel().getValueAt(row, 1);
        tblProduct.getModel().getValueAt(row, 2);
        tblProduct.getModel().getValueAt(row, 3);
        tblProduct.getModel().getValueAt(row, 4);
        tblProduct.getModel().getValueAt(row, 5);
        tblProduct.getModel().getValueAt(row, 6);
        tblProduct.getModel().getValueAt(row, 7);
        tblProduct.getModel().getValueAt(row, 8);
        tblProduct.getModel().getValueAt(row, 9);
        tblProduct.getModel().getValueAt(row, 10);
        
        txtProductId.setText(String.valueOf(tblProduct.getModel().getValueAt(row, 0)));
        txtProductName.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 1)));
        txtSupplierId.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 2)));
        txtCategoryId.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 3)));
        txtQuantity.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 4)));
        txtUnitPrice.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 5)));
        txtUnitsInStock.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 6)));
        txtUnitsOnOrder.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 7)));
        txtReorderLevel.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 8)));
        txtDiscontinued.setText(String.valueOf(tblProduct.getModel().getValueAt(row+1, 9)));
    }

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblProduct;
    private javax.swing.JTextField txtCategoryId;
    private javax.swing.JTextField txtDiscontinued;
    private javax.swing.JTextField txtProductId;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtReorderLevel;
    private javax.swing.JTextField txtSupplierId;
    private javax.swing.JTextField txtUnitPrice;
    private javax.swing.JTextField txtUnitsInStock;
    private javax.swing.JTextField txtUnitsOnOrder;
    // End of variables declaration//GEN-END:variables
}
