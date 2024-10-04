package GUI;

import Controler.SearchTK;
import BUS.TaiKhoanBUS;
import DAO.TaiKhoanDAO;
import DTO.TaiKhoanDTO;
import GUI.login;
import GUI.add.addTaiKhoan;
import GUI.update.updateTaiKhoan;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class taikhoan extends javax.swing.JPanel {

    private DefaultTableModel tblModel;
    private ArrayList<TaiKhoanDTO> accounts = new ArrayList<TaiKhoanDTO>();

    private TaiKhoanBUS tkbus = new TaiKhoanBUS();

    public taikhoan() {
        initComponents();
        
        initTable();
        loadDataToTableWithDifferentAccount();
        loadDataToTable(accounts);
        tblTaiKhoan.setDefaultEditor(Object.class, null);
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[] { "MANV", "Nhóm quyền", "Trạng thái" };
        tblModel.setColumnIdentifiers(headerTbl);

        tblTaiKhoan.setModel(tblModel);
        tblTaiKhoan.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblTaiKhoan.getColumnModel().getColumn(1).setPreferredWidth(20);
        tblTaiKhoan.getColumnModel().getColumn(2).setPreferredWidth(10);
    }

    public void loadDataToTable(ArrayList<TaiKhoanDTO> list) {
        tblModel.setRowCount(0);
        for (TaiKhoanDTO taiKhoanDTO : list) {
            int tt = taiKhoanDTO.getTrangthai();
            String trangthaiString = "";
            switch (tt) {
                case 1 -> {
                    trangthaiString = "Hoạt động";
                }
                case 0 -> {
                    trangthaiString = "Ngưng hoạt động";
                }
            }
            tblModel.addRow(new Object[] {
                    taiKhoanDTO.getManv(),
                    tkbus.getNhomQuyenDTO(taiKhoanDTO.getManhomquyen()).getTennhomquyen(), 
                    trangthaiString
            });
        }
    }
    public void loadDataToTable() {
        tblModel.setRowCount(0);
        for (TaiKhoanDTO taiKhoanDTO : accounts) {
            int tt = taiKhoanDTO.getTrangthai();
            String trangthaiString = "";
            switch (tt) {
                case 1 -> {
                    trangthaiString = "Hoạt động";
                }
                case 0 -> {
                    trangthaiString = "Ngưng hoạt động";
                }
            }
            tblModel.addRow(new Object[] {
                    taiKhoanDTO.getManv(),
                    tkbus.getNhomQuyenDTO(taiKhoanDTO.getManhomquyen()).getTennhomquyen(), 
                    trangthaiString
            });
        }
    }
    
    public void loadDataToTableWithDifferentAccount() {
        if (login.t.getManhomquyenaccount() == 1 || login.t.getManhomquyenaccount() == 4)
            accounts = TaiKhoanDAO.getInstance().selectAll();
        else {
            accounts = new ArrayList<TaiKhoanDTO>();
            accounts.add(TaiKhoanDAO.getInstance().selectById(String.valueOf(login.t.getManv())));
        }
    }

    public TaiKhoanDTO getAccountSelect() {
        int i_row = tblTaiKhoan.getSelectedRow();
        TaiKhoanDTO tk = TaiKhoanDAO.getInstance().selectById((tblTaiKhoan.getValueAt(i_row, 0)).toString());
        return tk;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        cbxLuachon = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1110, 500));

        jPanel1.setBackground(new java.awt.Color(176, 212, 235));
        jPanel1.setPreferredSize(new java.awt.Dimension(1110, 792));

        tblTaiKhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Mật khẩu", "Mã nhóm quyền", "Tên đăng nhập", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTaiKhoan.setRowHeight(50);
        tblTaiKhoan.setSelectionBackground(new java.awt.Color(176, 212, 235));
        tblTaiKhoan.setSelectionForeground(new java.awt.Color(10, 0, 0));
        jScrollPane1.setViewportView(tblTaiKhoan);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setPreferredSize(new java.awt.Dimension(1110, 90));

        jToolBar2.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btnThem.setText("THÊM");
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
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnSua);

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jToolBar2.add(btnXoa);

        cbxLuachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất Cả", "Mã nhân viên", "Mã nhóm quyền", " " }));
        cbxLuachon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLuachonActionPerformed(evt);
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

        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 459, Short.MAX_VALUE)
                .addComponent(cbxLuachon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxLuachon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        txtSearch.setText("Nhập nội dung tìm kiếm...");
        loadDataToTableWithDifferentAccount();
        loadDataToTable(accounts);
    }//GEN-LAST:event_btnResetActionPerformed
    private void btnLost(java.awt.event.FocusEvent evt) {                                   
        // TODO add yoSuaFocusur handling code here:
    }  
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (login.t.getManhomquyenaccount() == 1) {
            if (tblTaiKhoan.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản cần xóa!");
            } else {
                TaiKhoanDTO select = getAccountSelect();
                if (select.getManhomquyen() == 1) {
                    JOptionPane.showMessageDialog(this, "Không thể xóa tài khoản admin!");
                } else {
                    int checkVl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa tài khoản này?",
                            "Xác nhận xóa tài khoản", JOptionPane.YES_NO_OPTION);
                    if (checkVl == JOptionPane.YES_OPTION) {
                        try {
                            // Gọi phương thức xóa tài khoản từ BUS
                            if (tkbus.delete(select)) {
                                JOptionPane.showMessageDialog(this, "Xóa thành công tài khoản!");
                                loadDataToTableWithDifferentAccount();
                                loadDataToTable(accounts);
                            } else {
                                JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Xóa thất bại: " + e.getMessage());
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không đủ quyền hạn để sử dụng chức năng!");
        }
    }

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {
        String luachon = (String) cbxLuachon.getSelectedItem();
        String searchContent = txtSearch.getText();
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        switch (luachon) {
            case "Tất cả":
                result = SearchTK.getInstance().searchTatCaAcc(searchContent);
                break;
            case "Mã nhân viên":
                int manv = Integer.parseInt(searchContent);
                result = SearchTK.getInstance().searchmanv(manv);
                break;
            case "Mã nhóm quyền":
                int manq = Integer.parseInt(searchContent);
                result = SearchTK.getInstance().searchManhomquyen(manq);
                break;
        }
        loadDataToTable(result);

    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {
        addTaiKhoan a = new addTaiKhoan((JFrame) SwingUtilities.getWindowAncestor(this), true);
        a.setVisible(true);

        loadDataToTableWithDifferentAccount();
        loadDataToTable(accounts);
    }

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton20ActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtSearchActionPerformed

    }// GEN-LAST:event_txtSearchActionPerformed

    private void cbxLuachonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cbxLuachonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_cbxLuachonActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if (tblTaiKhoan.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn tài khoản muốn sửa");
        } else {

            updateTaiKhoan up = new updateTaiKhoan(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            up.setVisible(true);
        }

    }// GEN-LAST:event_btnSuaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbxLuachon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

}