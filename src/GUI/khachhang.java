/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import DTO.KhachHangDTO;
import GUI.add.addkhachhang;
import GUI.details.detailskhachhang;
import GUI.update.updatekhachhang;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class khachhang extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    ArrayList<KhachHangDTO> list = new ArrayList<>();
    KhachHangBUS khBUS = new KhachHangBUS();

    public khachhang() {
        initComponents();
        initTable();
        cbxAllDisplay();
        list = khBUS.khDAO.selectAll();
        loadDataToTable(list);
        jTable1.setDefaultEditor(Object.class, null);
    }
    
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Giới tính", "Số điện thoại", "Ngày tham gia"};
        tblModel.setColumnIdentifiers(headerTbl);
        jTable1.setModel(tblModel);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(5); // Mã khách hàng
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(40); // Tên khách hàng
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(300); // Địa chỉ
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(10); // Giới tính
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(10); // Số điện thoại
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(10);
    }
    
    public void cbxAllDisplay() {
        cbxAll.addItem("Tất cả");
        String[] headerTbl = new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Giới tính", "Số điện thoại", "Ngày tham gia"};
        for (String i : headerTbl)
            cbxAll.addItem("" + i);
    }

    public final void loadDataToTable(ArrayList<KhachHangDTO> kh) {
        try {
            tblModel.setRowCount(0);
            for (KhachHangDTO i : kh) {
                tblModel.addRow(new Object[]{
                    i.getMaKH(), i.getHoten(), i.getDiachi(), i.getGioitinh(), i.getSdt(), i.getNgaythamgia()
                });
            }
        } catch (Exception e) {
        }
    }

    public KhachHangDTO getKhachHangSelect() {
        int i_row = jTable1.getSelectedRow();
        KhachHangDTO kh = khBUS.khDAO.selectAll().get(i_row);
        return kh;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        jToolBar2 = new javax.swing.JToolBar();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnChitiet = new javax.swing.JButton();
        cbxAll = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1150, 500));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(176, 212, 235));
        jPanel1.setPreferredSize(new java.awt.Dimension(1150, 792));

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setRowHeight(50);
        jTable1.setSelectionBackground(new java.awt.Color(176, 212, 235));
        jTable1.setSelectionForeground(new java.awt.Color(10, 0, 0));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(1110, 90));

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        txtSearch.setText("Nhập nội dung tìm kiếm...");
        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSearchFocusGained(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setFocusable(false);
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jToolBar2.add(btnThem);

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/edit.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setFocusable(false);
        btnSua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSua.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                btnSuaFocusLost(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setFocusable(false);
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnXoa);

        btnChitiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        btnChitiet.setText("XEM CHI TIẾT");
        btnChitiet.setFocusable(false);
        btnChitiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChitiet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChitietActionPerformed(evt);
            }
        });
        jToolBar2.add(btnChitiet);

        cbxAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 440, Short.MAX_VALUE)
                .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1150, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnSuaFocusLost

    }//GEN-LAST:event_btnSuaFocusLost

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng muốn sửa");
        } else {
            updatekhachhang a = new updatekhachhang(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng muốn xoá");
        } else {
            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xoá khách hàng", "Xác nhận xoá khách hàng", JOptionPane.YES_NO_OPTION);
            if (output == JOptionPane.YES_OPTION) {
                khBUS.delete(getKhachHangSelect());
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
                loadDataToTable(khBUS.khDAO.selectAll());
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        addkhachhang a = new addkhachhang((JFrame) SwingUtilities.getWindowAncestor(this), true);
        a.setVisible(true);
        loadDataToTable(khBUS.khDAO.selectAll());
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtSearch.setText("Nhập nội dung tìm kiếm...");
        loadDataToTable(khBUS.khDAO.selectAll());
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btnChitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChitietActionPerformed
        if (jTable1.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng muốn xem");
        } else {
            detailskhachhang a = new detailskhachhang(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnChitietActionPerformed

    private boolean checkValueSearch(String a, String b) {
        boolean check = false;
        b = b.trim().toLowerCase();
        a = a.trim().toLowerCase();
        if(a.contains(b)) {
            check = true;
        }
        return check;
    }
    
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchContent = txtSearch.getText();
        ArrayList<KhachHangDTO> result = new ArrayList<>();
        int select = cbxAll.getSelectedIndex();
        if(select == 0) {
            for(KhachHangDTO x: list) {
                if(checkValueSearch(String.valueOf(x.getMaKH()), searchContent) ||
                    checkValueSearch(x.getHoten(), searchContent) || 
                    checkValueSearch(x.getDiachi(), searchContent) ||
                    checkValueSearch(x.getGioitinh(), searchContent) ||
                    checkValueSearch(x.getSdt(), searchContent) ||
                    checkValueSearch(String.valueOf(x.getNgaythamgia()), searchContent)) {
                    result.add(x);
                }
            }
        }else if(select == 1) {
            for(KhachHangDTO x: list) {
                if(checkValueSearch(String.valueOf(x.getMaKH()), searchContent)) {
                    result.add(x);
                }
            }
        }else if(select == 2) {
            for(KhachHangDTO x: list) {
                if(checkValueSearch(x.getHoten(), searchContent)) {
                    result.add(x);
                }
            }
        }else if(select == 3) {
            for(KhachHangDTO x: list) {
                if(checkValueSearch(x.getDiachi(), searchContent)) {
                    result.add(x);
                }
            }
        }else if(select == 4) {
            for(KhachHangDTO x: list) {
                if(checkValueSearch(x.getGioitinh(), searchContent)) {
                    result.add(x);
                }
            }
        }else if(select == 5) {
            for(KhachHangDTO x: list) {
                if(checkValueSearch(x.getSdt(), searchContent)) {
                    result.add(x);
                }
            }
        }else if(select == 6) {
            for(KhachHangDTO x: list) {
                if(checkValueSearch(String.valueOf(x.getNgaythamgia()), searchContent)) {
                    result.add(x);
                }
            }
        }

        loadDataToTable(result);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSearchFocusGained
        if (txtSearch.getText().equals("Nhập nội dung tìm kiếm...")) {
            txtSearch.setText("");
        }
    }//GEN-LAST:event_txtSearchFocusGained

    private void cbxAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChitiet;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxAll;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
