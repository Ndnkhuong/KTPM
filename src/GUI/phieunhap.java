/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Controler.SearchPhieuNhap;
import BUS.PhieuNhapBUS;
import DAO.PhieuNhapDAO;
import DTO.PhieuNhapDTO;
import GUI.add.addphieunhap;
import GUI.details.cancelphieunhap;
import GUI.details.detailsphieunhap;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import BUS.SanPhamBUS;
import BUS.ThuongHieuBUS;
import BUS.XuatXuBUS;
import BUS.LoaiSanPhamBUS;
import Controler.SearchSanPham;
import javax.swing.table.DefaultTableModel;
import DTO.SanPhamDTO;
import GUI.add.addsanpham;
import GUI.update.updatesanpham;
import GUI.details.dtsanpham;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author NeON
 */
public class phieunhap extends javax.swing.JPanel {

    ArrayList<PhieuNhapDTO> list = new ArrayList<PhieuNhapDTO>();
    JpanelLoader jp = new JpanelLoader();
    PhieuNhapBUS pnBUS = new PhieuNhapBUS();
    int current = 0;
    private int quyen;

    public phieunhap(int quyen) {
        initComponents();
        cbxAllDisplay();
        cbNccDisplay();
        cbHotenDisplay();
        searchDate();
        list = pnBUS.phieunhapDAO.selectAll();
        displaytoTable(list);
        tblphieunhap.setDefaultEditor(Object.class, null);
        this.quyen = quyen;
    }

    public void cbxAllDisplay() {
        cbxAll.addItem("Tất cả");
        int count = tblphieunhap.getColumnCount();
        for (int i = 1; i < count; i++) {
            cbxAll.addItem("" + tblphieunhap.getColumnName(i));
        }
    }

    public void cbNccDisplay() {
        cbncc.addItem("Tất cả");
        ArrayList<String> listncc = pnBUS.phieunhapDAO.selectAllNcc();
        int count = listncc.size();
        for (int i = 0; i < count; i++) {
            cbncc.addItem("" + listncc.get(i));
        }
    }

    public void cbHotenDisplay() {
        cbnvien.addItem("Tất cả");
        ArrayList<String> listhoten = pnBUS.phieunhapDAO.selectAllHoten();
        int count = listhoten.size();
        for (int i = 0; i < count; i++) {
            cbnvien.addItem("" + listhoten.get(i));
        }
    }

    public void displaytoTable(ArrayList<PhieuNhapDTO> list) {
        try {
            DefaultTableModel dt = (DefaultTableModel) tblphieunhap.getModel();
            dt.setRowCount(0);
            for (PhieuNhapDTO i : list) {
                dt.addRow(new Object[]{
                    i.getMaphieunhap(), i.getTenncc(), i.getTennvnhap(), i.getThoigian(), i.getTongtien()
                });
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public PhieuNhapDTO getPhieuNhapSelect() {
        int i_row = tblphieunhap.getSelectedRow();
        PhieuNhapDTO nv = pnBUS.phieunhapDAO.selectAll().get(i_row);
        return nv;
    }

    private boolean checkDate(Date dateToCheck, Date fromDate, Date toDate) {
        return !dateToCheck.before(fromDate) && !dateToCheck.after(toDate);
    }

    public ArrayList<PhieuNhapDTO> searchDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        Date from = DateFrom.getDate();
        Date to = DateTo.getDate();

        if (from != null && to != null) {
            ArrayList<PhieuNhapDTO> allPhieuNhap = pnBUS.phieunhapDAO.selectAll();
            for (PhieuNhapDTO phieu : allPhieuNhap) {
                if (checkDate(phieu.getThoigian(), from, to)) {
                    result.add(phieu);
                }
            }
        }

        return result;
    }

    public ArrayList<PhieuNhapDTO> searchTien(long fromMoney, long toMoney) {
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        ArrayList<PhieuNhapDTO> armt = PhieuNhapDAO.getInstance().selectAll();
        for (var pn : armt) {
            long money = (long) pn.getTongtien();

            if (money >= fromMoney && money <= toMoney) {
                result.add(pn);
            }

        }
        return result;
    }

    // Hàm hiển thị tất cả các phiếu nhập
    public void displayAllPhieuNhap() {
        ArrayList<PhieuNhapDTO> allPhieuNhap = pnBUS.phieunhapDAO.selectAll();
        displaytoTable(allPhieuNhap);
    }
    
    public JButton getBtnHuy() {
        return btnHuy;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jButton23 = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        cbxAll = new javax.swing.JComboBox<>();
        jToolBar3 = new javax.swing.JToolBar();
        btnThem = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbncc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbnvien = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtfromMoney = new javax.swing.JTextField();
        txttoMoney = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        DateFrom = new com.toedter.calendar.JDateChooser();
        DateTo = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblphieunhap = new javax.swing.JTable();

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel5.setPreferredSize(new java.awt.Dimension(1110, 90));

        jButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jButton23.setText("Làm mới");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        txttimkiem.setText("Nhập nội dung tìm kiếm...");
        txttimkiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttimkiemFocusGained(evt);
            }
        });
        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });
        txttimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimkiemKeyReleased(evt);
            }
        });

        cbxAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxAllActionPerformed(evt);
            }
        });

        jToolBar3.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar3.setBorder(null);
        jToolBar3.setRollover(true);

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
        jToolBar3.add(btnThem);

        btnChiTiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChiTiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/detail.png"))); // NOI18N
        btnChiTiet.setText("XEM CHI TIẾT");
        btnChiTiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnChiTiet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });
        jToolBar3.add(btnChiTiet);

        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cancel.png"))); // NOI18N
        btnHuy.setText("HỦY PHIẾU");
        btnHuy.setFocusable(false);
        btnHuy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHuy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jToolBar3.add(btnHuy);
        jToolBar3.add(jSeparator3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton23)
                .addGap(22, 22, 22))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAll, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nhà cung cấp");

        cbncc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbnccItemStateChanged(evt);
            }
        });

        jLabel2.setText("Nhân viên nhập");

        cbnvien.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbnvienItemStateChanged(evt);
            }
        });

        jLabel3.setText("Từ ngày");

        jLabel4.setText("Đến ngày");

        jLabel5.setText("Từ số tiền (VND)");

        txtfromMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfromMoneyActionPerformed(evt);
            }
        });
        txtfromMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtfromMoneyKeyReleased(evt);
            }
        });

        txttoMoney.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttoMoneyKeyReleased(evt);
            }
        });

        jLabel6.setText("Đến số tiền (VND)");

        DateFrom.setDateFormatString("yyyy-MM-dd");

        DateTo.setDateFormatString("yyyy-MM-dd");

        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbncc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbnvien, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(DateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(DateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtfromMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txttoMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbncc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbnvien)
                            .addComponent(txtfromMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                            .addComponent(txttoMoney, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblphieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Nhà cung cấp", "Nhân viên nhập", "Thời gian", "Tổng tiền"
            }
        ));
        tblphieunhap.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblphieunhap.setRowHeight(50);
        tblphieunhap.setSelectionBackground(new java.awt.Color(176, 212, 235));
        tblphieunhap.setSelectionForeground(new java.awt.Color(10, 0, 0));
        jScrollPane2.setViewportView(tblphieunhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1155, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxAllActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAllActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        addphieunhap apn = new addphieunhap();
        if(quyen == 1) {
            jp.jPanelLoader(admin.panel_load, apn);
        } else if (quyen == 2) {
            jp.jPanelLoader(nvnhaphang.panel_load, apn);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txttimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkiemKeyReleased
        // TODO add your handling code here:
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        String text = txttimkiem.getText();
        String choose = (String) cbxAll.getSelectedItem();
        switch (choose) {
            case "Tất cả":
                result = SearchPhieuNhap.getInstance().searchTatCa(text);
                break;
            case "Mã phiếu nhập":
                result = SearchPhieuNhap.getInstance().searchMaphieunhap(text);
                break;
            case "Tên nhà cung cấp":
                result = SearchPhieuNhap.getInstance().searchTenNCC(text);
                break;
            case "Nhân viên nhập":
                result = SearchPhieuNhap.getInstance().searchTennvnhap(text);
                break;
            case "Thời gian":
                result = SearchPhieuNhap.getInstance().searchThoigian(text);
                break;
            case "Tổng tiền":
                result = SearchPhieuNhap.getInstance().searchTongtien(text);
        }
        displaytoTable(result);
    }//GEN-LAST:event_txttimkiemKeyReleased

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        if (tblphieunhap.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập muốn hủy");
        } else {
            cancelphieunhap a = new cancelphieunhap(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            a.setVisible(true);
//            int output = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn hủy phiếu nhập", "Xác nhận hủy phiếu nhập", JOptionPane.YES_NO_OPTION);
//            if (output == JOptionPane.YES_OPTION) {
//                pnBUS.delete(getPhieuNhapSelect(), tblphieunhap.getSelectedRow());
//                JOptionPane.showMessageDialog(this, "Xóa thành công !");
//                displaytoTable(pnBUS.phieunhapDAO.selectAll());
//            }
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void cbnccItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbnccItemStateChanged
        // TODO add your handling code here:
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        String choose = (String) cbncc.getSelectedItem();
        if (choose.equals("Tất cả")) {
            result = pnBUS.phieunhapDAO.selectAll();
        } else {
            result = SearchPhieuNhap.getInstance().searchTenNCC(choose);
        }
        displaytoTable(result);
    }//GEN-LAST:event_cbnccItemStateChanged

    private void cbnvienItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbnvienItemStateChanged
        // TODO add your handling code here:
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        String choose = (String) cbnvien.getSelectedItem();
        if (choose.equals("Tất cả")) {
            result = pnBUS.phieunhapDAO.selectAll();
        } else {
            result = SearchPhieuNhap.getInstance().searchTennvnhap(choose);
        }
        displaytoTable(result);
    }//GEN-LAST:event_cbnvienItemStateChanged

    private void txttoMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttoMoneyKeyReleased
        // TODO add your handling code here:
        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
        long from = Long.parseLong(txtfromMoney.getText());
        long to = Long.parseLong(txttoMoney.getText());
        if (txtfromMoney.getText().isEmpty() || txttoMoney.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống 1 trong 2 ô nhập số tiền !");
        } else if (txtfromMoney.getText().isEmpty() && txttoMoney.getText().isEmpty()) {
            result = pnBUS.phieunhapDAO.selectAll();
        } else {
            result = searchTien(from, to);
        }
        displaytoTable(result);
    }//GEN-LAST:event_txttoMoneyKeyReleased

    private void txtfromMoneyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfromMoneyKeyReleased
        // TODO add your handling code here:
//        ArrayList<PhieuNhapDTO> result = new ArrayList<>();
//        long from = Long.parseLong(txtfromMoney.getText());
//        long to = Long.parseLong(txttoMoney.getText());
//        if (txtfromMoney.getText().isEmpty() || txttoMoney.getText().isEmpty()) {
//            result = pnBUS.phieunhapDAO.selectAll();
//            JOptionPane.showMessageDialog(this, "Không được để trống 1 trong 2 ô nhập số tiền !");
//        } else if (txtfromMoney.getText().isEmpty() && txttoMoney.getText().isEmpty()) {
//            result = pnBUS.phieunhapDAO.selectAll();
//        } else {
//            result = searchTien(from, to);
//        }
//        displaytoTable(result);
    }//GEN-LAST:event_txtfromMoneyKeyReleased

    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        // TODO add your handling code here:
        if (tblphieunhap.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn phiếu nhập để xem");
        } else {
            detailsphieunhap a = new detailsphieunhap(this, (JFrame) SwingUtilities.getWindowAncestor(this), true);
            a.setVisible(true);
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        txttimkiem.setText("Nhập nội dung tìm kiếm...");
        displaytoTable(pnBUS.phieunhapDAO.selectAll());
        cbxAll.setSelectedIndex(0);
        cbncc.setSelectedIndex(0);
        cbnvien.setSelectedIndex(0);
        txtfromMoney.setText("");
        txttoMoney.setText("");
        DateFrom.setDate(null);
        DateTo.setDate(null);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void txttimkiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttimkiemFocusGained
        if (txttimkiem.getText().equals("Nhập nội dung tìm kiếm...")) {
            txttimkiem.setText("");
        }
    }//GEN-LAST:event_txttimkiemFocusGained

    private void txtfromMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfromMoneyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfromMoneyActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Gọi hàm searchDate() để tìm kiếm các phiếu nhập trong khoảng thời gian đã chọn
        ArrayList<PhieuNhapDTO> searchResult = searchDate();

        // Hiển thị kết quả tìm kiếm trên bảng
        displaytoTable(searchResult);
        long from = Long.parseLong(txtfromMoney.getText());
        long to = Long.parseLong(txttoMoney.getText());
        if (from < 0) {
            JOptionPane.showMessageDialog(this, "Khoảng tiền không được âm");
            txtfromMoney.setText("");
        }else if (to < 0) {
            JOptionPane.showMessageDialog(this, "Khoảng tiền không được âm");
            txttoMoney.setText("");
        }else if (from > to) {
            JOptionPane.showMessageDialog(this, "Khoảng tiền không hợp lệ");
        }else if (txtfromMoney.getText().isEmpty() || txttoMoney.getText().isEmpty()) {
            searchResult = pnBUS.phieunhapDAO.selectAll();
            JOptionPane.showMessageDialog(this, "Không được để trống 1 trong 2 ô nhập số tiền !");
        } else if (txtfromMoney.getText().isEmpty() && txttoMoney.getText().isEmpty()) {
            searchResult = pnBUS.phieunhapDAO.selectAll();
        } else {
            searchResult = searchTien(from, to);
        }
        displaytoTable(searchResult);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateFrom;
    private com.toedter.calendar.JDateChooser DateTo;
    private javax.swing.JButton btnChiTiet;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbncc;
    private javax.swing.JComboBox<String> cbnvien;
    private javax.swing.JComboBox<String> cbxAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton23;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JTable tblphieunhap;
    private javax.swing.JTextField txtfromMoney;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txttoMoney;
    // End of variables declaration//GEN-END:variables
}
