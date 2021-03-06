/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banksoal;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java.io.*;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Alice002
 */
public class TambahSoal extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement stat;
    Statement stmt;
    ResultSet rs;
    int count;
    String num;
    JDesktopPane desktop;
    String jname;        
    
    public TambahSoal(int Count, String ID, JDesktopPane desktop, String jname) {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
                
        initComponents();
        
        this.count = Count;
        this.num = ID;
        this.desktop = desktop;
        this.jname = jname; 
                       
        //System.out.println(num);
        update.setText(jname);
        
        
        
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://ALICE004;"
            + "databaseName=BankSoal_db;user=sa;password=root");            
            stmt = con.createStatement();
        } catch(SQLException x) {
            System.out.println(x.toString());
        }        
        
        if (update.getText() == "Update") {
            hapus_bt.setEnabled(true);
            int id = Integer.parseInt(num);
            cancel_bt.setVisible(true);
            try {         
                stmt = con.createStatement();  
                stat = con.prepareStatement("SELECT Soal,Jawaban,Salah1,Salah2,Salah3,Kategori FROM dbo.Soal WHERE ID=?");                        
                stat.setInt(1, id);
                rs = stat.executeQuery();            
            
                while(rs.next()) {
                    soal_text.setText(rs.getString("Soal"));
                    jawaban_text.setText(rs.getString("Jawaban"));
                    salah1_text.setText(rs.getString("Salah1"));
                    salah2_text.setText(rs.getString("Salah2"));
                    salah3_text.setText(rs.getString("Salah3"));
                    kategori_cb.setSelectedItem("Kategori");
                }
                rs.close();
            
            } catch(SQLException x) {
                System.out.println(x.toString());
            }                      
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

        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        soal_text = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jawaban_text = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        salah1_text = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        salah2_text = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        salah3_text = new javax.swing.JTextArea();
        update = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        kategori_cb = new javax.swing.JComboBox();
        cancel_bt = new javax.swing.JButton();
        hapus_bt = new javax.swing.JToggleButton();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(800, 550));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Soal :");

        soal_text.setColumns(20);
        soal_text.setRows(5);
        jScrollPane1.setViewportView(soal_text);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Jawaban :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Salah 1 :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Salah 2 :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Salah 3 :");

        jawaban_text.setColumns(20);
        jawaban_text.setRows(5);
        jScrollPane2.setViewportView(jawaban_text);

        salah1_text.setColumns(20);
        salah1_text.setRows(5);
        jScrollPane3.setViewportView(salah1_text);

        salah2_text.setColumns(20);
        salah2_text.setRows(5);
        jScrollPane4.setViewportView(salah2_text);

        salah3_text.setColumns(20);
        salah3_text.setRows(5);
        jScrollPane5.setViewportView(salah3_text);

        update.setText("Tambah Soal");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        update.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                updatePropertyChange(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Kategori :");

        kategori_cb.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        kategori_cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tes Wawasan Kebangsaan", "Tes Intelegensi Umum", "Tes Karakteristik Pribadi", "Tes Psikotes" }));
        kategori_cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kategori_cbActionPerformed(evt);
            }
        });

        cancel_bt.setText("Cancel");
        cancel_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btActionPerformed(evt);
            }
        });

        hapus_bt.setText("Hapus");
        hapus_bt.setEnabled(false);
        hapus_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus_btActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(760, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(cancel_bt))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(kategori_cb, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hapus_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hapus_bt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kategori_cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(97, 97, 97)
                .addComponent(cancel_bt)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        
            if (soal_text.getText().isEmpty() == false 
                && jawaban_text.getText().isEmpty() == false
                && salah1_text.getText().isEmpty() == false
                && salah2_text.getText().isEmpty() == false
                && salah3_text.getText().isEmpty() == false) {
                if (update.getText() == "Tambah Soal") {
                    Insert();
                }
                else if (update.getText() == "Update") {                        
                    Update();            
                }     
                
                SoalJawaban soja = new SoalJawaban(desktop);
                desktop.add(soja);
                this.dispose();
                soja.setVisible(true); 
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Field tidak boleh kosong!");
            }
        
         
        
        
    }//GEN-LAST:event_updateActionPerformed

    private void kategori_cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kategori_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kategori_cbActionPerformed

    private void cancel_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btActionPerformed
        SoalJawaban soja = new SoalJawaban(desktop);
        desktop.add(soja);
        this.dispose();
        soja.setVisible(true); 
    }//GEN-LAST:event_cancel_btActionPerformed

    private void updatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_updatePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_updatePropertyChange

    private void hapus_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus_btActionPerformed
        Delete();
        
        SoalJawaban soja = new SoalJawaban(desktop);
        desktop.add(soja);
        this.dispose();
        soja.setVisible(true); 
    }//GEN-LAST:event_hapus_btActionPerformed

    public void Insert(){
        try {
            stat = con.prepareStatement("INSERT INTO " 
                    + "dbo.Soal(ID,Soal,Jawaban,Salah1,Salah2,Salah3,Kategori)" 
                    + "VALUES(?,?,?,?,?,?,?)");
            
            stat.setInt(1, count + 1);
            stat.setString(2,soal_text.getText());
            stat.setString(3,jawaban_text.getText());
            stat.setString(4,salah1_text.getText());
            stat.setString(5,salah2_text.getText());
            stat.setString(6,salah3_text.getText());
            stat.setString(7,kategori_cb.getSelectedItem().toString());
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(rootPane, "Data berhasil dimasukkan");
        } catch (Exception x) {
            System.out.println(x.toString());
            JOptionPane.showMessageDialog(rootPane, "Data tidak dapat dimasukkan");
        }
    }    
    
    public void Update() {
        try {
            int id = Integer.parseInt(num);
            stat = con.prepareStatement("UPDATE dbo.Soal SET  Soal=?, Jawaban=?, Salah1=?, Salah2=?, Salah3=?, Kategori=? WHERE ID=?");
            stmt = con.createStatement();                                            
            
            stat.setString(1,soal_text.getText());
            stat.setString(2,jawaban_text.getText());
            stat.setString(3,salah1_text.getText());
            stat.setString(4,salah2_text.getText());
            stat.setString(5,salah3_text.getText());
            stat.setString(6,kategori_cb.getSelectedItem().toString());
            stat.setInt(7,id);
            
            stat.executeUpdate();
            
            JOptionPane.showMessageDialog(rootPane, "Data berhasil diupdate");
        } catch (SQLException x) {
            System.out.println(x.toString());
            JOptionPane.showMessageDialog(rootPane, "Data tidak dapat diupdate");
        }    
    }
    
    void Delete() {
        try
        {
            int id = Integer.parseInt(num);
            stat = con.prepareStatement("DELETE FROM dbo.Soal WHERE id=?");            
            stat.setInt(1, id);
            stat.executeUpdate();            
            
            JOptionPane.showMessageDialog(rootPane,"Data berhasil dihapus");
        }
        catch(SQLException x){
            System.out.println(x.toString());
            JOptionPane.showMessageDialog(rootPane, "Data tdak dapat dihapus");
        }                
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel_bt;
    private javax.swing.JToggleButton hapus_bt;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jawaban_text;
    private javax.swing.JComboBox kategori_cb;
    private javax.swing.JTextArea salah1_text;
    private javax.swing.JTextArea salah2_text;
    private javax.swing.JTextArea salah3_text;
    private javax.swing.JTextArea soal_text;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
