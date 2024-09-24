/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import BUS.KhachHangBUS;
import BUS.NhanVienBUS;
import BUS.PhieuNhapBUS;
import BUS.PhieuXuatBUS;
import BUS.CTPhieuXuatBUS;
import BUS.SanPhamBUS;
import DAO.PhieuNhapDAO;
import DAO.PhieuXuatDAO;
import DTO.DoanhThuDTO;
import DTO.KhachHangDTO;
import DTO.PhieuNhapDTO;
import DTO.PhieuXuatDTO;
import DTO.ChiTietPhieuXuatDTO;
import DTO.SanPhamDTO;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public final class ThongKe extends javax.swing.JPanel {

    PhieuNhapBUS pnBus = new PhieuNhapBUS();
    PhieuXuatBUS pxBus = new PhieuXuatBUS();
    CTPhieuXuatBUS ctpxBus = new CTPhieuXuatBUS();
    SanPhamBUS spBus = new SanPhamBUS();
    KhachHangBUS khBus = new KhachHangBUS();
    NhanVienBUS nvBus = new NhanVienBUS();
    private DefaultTableModel tblModeldt;
    private DefaultTableModel tblModelpn;
    private DefaultTableModel tblModelpx;
    private DefaultTableModel tblModelsp;
    private DefaultTableModel tblModelkh;

    ArrayList<DoanhThuDTO> dt = new ArrayList<DoanhThuDTO>();
    ArrayList<PhieuNhapDTO> pn = new ArrayList<PhieuNhapDTO>();
    ArrayList<PhieuXuatDTO> px = new ArrayList<PhieuXuatDTO>();
    ArrayList<ChiTietPhieuXuatDTO> ctpx = new ArrayList<ChiTietPhieuXuatDTO>();
    ArrayList<SanPhamDTO> sp = new ArrayList<SanPhamDTO>();
    ArrayList<KhachHangDTO> kh = new ArrayList<KhachHangDTO>();

    /**
     * Creates new form ThongKe
     */
    public ThongKe() {
        initComponents();
//        tblphieunhap.setDefaultEditor(Object.class, null);
//        tblphieuxuat.setDefaultEditor(Object.class, null);
        initTableDt();
        initTablePn();
        initTablePx();
        initTableSp();
        initTableKh();
        pn = pnBus.getAll();
        px = pxBus.getAll();
        ctpx = ctpxBus.getAll();
        sp = spBus.spDAO.selectAll();
        kh = khBus.getAll();
        loadDataToTableDoanhThu(pn, px, sp, kh);
        loadDataToTablePhieuNhap(pn);
        loadDataToTablePhieuXuat(px);
        loadDataToTableSanPham(sp);
        loadDataToTableKhachHang(kh);
        setInfolabel();
        
        jTextFieldSp.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(!jTextFieldSp.getText().equals("")){
                    SearchSp(jTextFieldSp.getText());
                }
                else {
                    loadDataToTableSanPham(sp);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(!jTextFieldSp.getText().equals("")){
                    SearchSp(jTextFieldSp.getText());
                }else {
                    loadDataToTableSanPham(sp);
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if(!jTextFieldSp.getText().equals("")){
                    SearchSp(jTextFieldSp.getText());
                }else {
                    loadDataToTableSanPham(sp);
                }
            }
        });
        jTextFieldKh.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(!jTextFieldKh.getText().equals("")){
                    SearchKh(jTextFieldKh.getText());
                }else {
                    loadDataToTableKhachHang(kh);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(!jTextFieldKh.getText().equals("")){
                    SearchKh(jTextFieldKh.getText());
                }else {
                    loadDataToTableKhachHang(kh);
                }
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                if(!jTextFieldKh.getText().equals("")){
                    SearchKh(jTextFieldKh.getText());
                }else {
                    loadDataToTableKhachHang(kh);
                }
            }
        });
    }
    
    public final void initTableDt() {
        tblModeldt = new DefaultTableModel();
        String[] headerTbl = new String[]{"Tên sản phẩm", "Giá bán", "Giá nhập", "Số lượng bán", "Doanh thu", "Lợi nhuận", "Thời gian"};
        tblModeldt.setColumnIdentifiers(headerTbl);
        tblDoanhThu.setModel(tblModeldt);

    }

    public final void initTablePn() {
        tblModelpn = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã phiếu nhập ", "Tên Nhân Viên Nhập", "Thời gian", "Tổng Tiền"};
        tblModelpn.setColumnIdentifiers(headerTbl);
        tblphieunhap.setModel(tblModelpn);

    }

    public final void initTablePx() {
        tblModelpx = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã phiếu xuất ", "Tên Khách Hàng", "Thời gian", "Tổng Tiền"};
        tblModelpx.setColumnIdentifiers(headerTbl);
        tblphieuxuat.setModel(tblModelpx);

    }

    public final void initTableSp() {
        tblModelsp = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã Sản Phẩm ", "Tên Sản Phẩm", "Số lượng tồn", "Giá tiền"};
        tblModelsp.setColumnIdentifiers(headerTbl);
        tbsanpham.setModel(tblModelsp);

    }

    public final void initTableKh() {
        tblModelkh = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã khách hàng", "Tên khách hàng", "Địa chỉ", "Số điện thoại"};
        tblModelkh.setColumnIdentifiers(headerTbl);
        tblkhachhang.setModel(tblModelkh);

    }

    public void loadDataToTableDoanhThu(ArrayList<PhieuNhapDTO> pn, ArrayList<PhieuXuatDTO> px, 
            ArrayList<SanPhamDTO> sp, ArrayList<KhachHangDTO> kh) {
        try {
            int tienDoanhThu = 0;
            int tienChi = 0;
            int tienLoiNhuan;
            
            for(PhieuXuatDTO x: px) {
                String ngayXuat = x.getThoigian().toString();
                for(ChiTietPhieuXuatDTO y: ctpx) {
                    if(y.getMaphieuxuat() == x.getMaphieuxuat()) {
                        DoanhThuDTO ctdt = new DoanhThuDTO();
                        ctdt.setThoigian(ngayXuat);
                        ctdt.setSoluongban(y.getSoluong());
                        ctdt.setGiaban(y.getDongia());
                        for(SanPhamDTO z: sp) {
                            if(z.getMasp() == y.getMasp()) {
                                ctdt.setTensp(z.getTensp());
                                ctdt.setGianhap(z.getGia());
                                break;
                            } 
                        }
                        ctdt.setDoanhthu();
                        ctdt.setLoinhuan();
                        dt.add(ctdt);
                    }
                }
            }    
            
            tblModeldt.setRowCount(0);
            for(DoanhThuDTO x: dt){
                tblModeldt.addRow(new Object[] {
                    x.getTensp(), x.getGiaban(), x.getGianhap(), x.getSoluongban(), x.getDoanhthu(),
                    x.getLoinhuan(), x.getThoigian()
                });
                tienChi += x.getGianhap() * x.getSoluongban();
                tienDoanhThu += x.getDoanhthu();
            }
            tienLoiNhuan = tienDoanhThu - tienChi;
            jLabelDoanhThu.setText(formatPrice(tienDoanhThu));
            jLabelLoiNhuan.setText(formatPrice(tienLoiNhuan));
            lbdoanhthu.setText(formatPrice(tienDoanhThu));

            
        } catch(Exception e) {
                
            }
    }
    
    public void loadDataToTablePhieuNhap(ArrayList<PhieuNhapDTO> pn) {
        try {
            tblModelpn.setRowCount(0);
            for (int i = 0; i < pn.size(); i++) {
                tblModelpn.addRow(new Object[]{
                    pn.get(i).getMaphieunhap(), pn.get(i).getTennvnhap(), (pn.get(i).getThoigian().toString()), (pn.get(i).getTongtien())
                });
            }
        } catch (Exception e) {

        }
    }

    public void loadDataToTablePhieuXuat(ArrayList<PhieuXuatDTO> px) {
        try {
            tblModelpx.setRowCount(0);
            for (int i = 0; i < px.size(); i++) {
                tblModelpx.addRow(new Object[]{
                    px.get(i).getMaphieuxuat(), px.get(i).getTenkhachhang(), (px.get(i).getThoigian().toString()), (px.get(i).getTongtien())
                });
            }
        } catch (Exception e) {

        }
    }

    public void loadDataToTableSanPham(ArrayList<SanPhamDTO> sp) {
        try {
            tblModelsp.setRowCount(0);
            for (SanPhamDTO i : sp) {
                tblModelsp.addRow(new Object[]{
                    i.getMasp(), i.getTensp(), i.getSoluongton(), i.getGia()
                });
            }
        } catch (Exception e) {

        }
    }

    public void loadDataToTableKhachHang(ArrayList<KhachHangDTO> kh) {
        try {
            tblModelkh.setRowCount(0);
            for (KhachHangDTO i : kh) {
                tblModelkh.addRow(new Object[]{
                    i.getMaKH(), i.getHoten(), i.getDiachi(), i.getSdt()
                });
            }
        } catch (Exception e) {

        }
    }

    public void setInfolabel() {
        lbtongphieunhap.setText(" " + pn.size());
        lbtongtiennhap.setText(formatPrice(tongtiennhap()));
        lbtongtienxuat.setText(formatPrice(tongtienxuat()));
        lbtongphieuxuat.setText(" " + px.size());
        lbtongchi.setText(formatPrice(tongtiennhap()));

        lbsp.setText(" " + sp.size());
        lbkh.setText(" " + kh.size());
    }

    public long tongtiennhap() {
        long tong = 0;
        for (PhieuNhapDTO i : pn) {
            tong += i.getTongtien();
        }
        return tong;
    }

    public long tongtienxuat() {
        long tong = 0;
        for (PhieuXuatDTO i : px) {
            tong += i.getTongtien();
        }
        return tong;
    }
    
    public int checkDateJDateChoser(Date ngayBatDau, Date ngayKetThuc, Date hienTai) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if((hienTai.after(ngayBatDau) || dateFormat.format(hienTai).equals(dateFormat.format(ngayBatDau))) && 
                        (hienTai.before(ngayKetThuc) || dateFormat.format(hienTai).equals(dateFormat.format(ngayKetThuc)))) {
            return 1;
        }
        return 0;
    }
    
    public int checkName(String a, String b) {
        if (b.contains(a)) {
            return 1;
        }
        return 0;
    }

    public void searchDoanhThu(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<DoanhThuDTO> dt = new ArrayList<DoanhThuDTO>();
        try {
            int tienDoanhThu = 0;
            int tienChi = 0;
            int tienLoiNhuan;
            
            
            for(PhieuXuatDTO x: px) {
                if(checkDateJDateChoser(ngayBatDau, ngayKetThuc, x.getThoigian()) == 1) {
                    String ngayXuat = x.getThoigian().toString();
                    for(ChiTietPhieuXuatDTO y: ctpx) {
                        if(y.getMaphieuxuat() == x.getMaphieuxuat()) {
                            DoanhThuDTO ctdt = new DoanhThuDTO();
                            ctdt.setThoigian(ngayXuat);
                            ctdt.setSoluongban(y.getSoluong());
                            ctdt.setGiaban(y.getDongia());
                            for(SanPhamDTO z: sp) {
                                if(z.getMasp() == y.getMasp()) {
                                    ctdt.setTensp(z.getTensp());
                                    ctdt.setGianhap(z.getGia());
                                    break;
                                } 
                            }
                            ctdt.setDoanhthu();
                            ctdt.setLoinhuan();
                            dt.add(ctdt);
                        }
                    }
                }
            }
            
            tblModeldt.setRowCount(0);
            for(DoanhThuDTO x: dt){
                tblModeldt.addRow(new Object[] {
                    x.getTensp(), x.getGiaban(), x.getGianhap(), x.getSoluongban(), x.getDoanhthu(),
                    x.getLoinhuan(), x.getThoigian()
                });
                tienChi += x.getGianhap() * x.getSoluongban();
                tienDoanhThu += x.getDoanhthu();
            }
            tienLoiNhuan = tienDoanhThu - tienChi;
            jLabelDoanhThu.setText(formatPrice(tienDoanhThu));
            jLabelLoiNhuan.setText(formatPrice(tienLoiNhuan));
        } catch(Exception e) {
                
            }
    }
    
    public void searchPn(Date ngayBatDau, Date ngayKetThuc) {
        try {
            int tongPn = 0;
            long tongTien = 0;
            tblModelpn.setRowCount(0);
            for (int i = 0; i < pn.size(); i++) {
                if(checkDateJDateChoser(ngayBatDau, ngayKetThuc, pn.get(i).getThoigian()) == 1) {
                    tongPn++;
                    tongTien += pn.get(i).getTongtien();
                    tblModelpn.addRow(new Object[]{
                        pn.get(i).getMaphieunhap(), pn.get(i).getTennvnhap(), (pn.get(i).getThoigian().toString()), (pn.get(i).getTongtien())
                    });
                }
            }
            lbtongphieunhap.setText("" + tongPn);
            lbtongtiennhap.setText(formatPrice(tongTien));
        } catch (Exception e) {

        }
    }
    
    public void searchPx(Date ngayBatDau, Date ngayKetThuc) {
        try {
            tblModelpx.setRowCount(0);
            int tongPx = 0;
            long tongTien = 0;
            for (int i = 0; i < px.size(); i++) {
                if(checkDateJDateChoser(ngayBatDau, ngayKetThuc, pn.get(i).getThoigian()) == 1) {
                    tongPx ++;
                    tongTien += px.get(i).getTongtien();
                    tblModelpx.addRow(new Object[]{
                    px.get(i).getMaphieuxuat(), px.get(i).getTenkhachhang(), (px.get(i).getThoigian().toString()), (px.get(i).getTongtien())
                    });
                }
            }
            lbtongphieuxuat.setText("" + tongPx);
            lbtongtienxuat.setText(formatPrice(tongTien));
        } catch (Exception e) {

        }
    }
    
    public void SearchSp(String value) {
        try {
            tblModelsp.setRowCount(0);
            for (SanPhamDTO i : sp) {
                if(checkName(value, i.getTensp()) == 1) {
                   tblModelsp.addRow(new Object[]{
                        i.getMasp(), i.getTensp(), i.getSoluongton(), i.getGia()
                    }); 
                }
                
            }
        } catch (Exception e) {

        }
    }
    
    public void SearchKh(String value) {
        try {
            tblModelkh.setRowCount(0);
            for (KhachHangDTO i : kh) {
                if(checkName(value, i.getHoten()) == 1) {
                    tblModelkh.addRow(new Object[]{
                        i.getMaKH(), i.getHoten(), i.getDiachi(), i.getSdt()
                    });
                }
            }
        } catch (Exception e) {

        }
    }
    
    public String formatPrice(long price) {
        String amountStr = String.format("%,.0f", (double)price);
        return amountStr + "đ"; 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked") // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbdoanhthu = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbsp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lbkh = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lbtongchi = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelThongKeDoanhThu = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jDateChoserStartDt = new com.toedter.calendar.JDateChooser();
        jLabel31 = new javax.swing.JLabel();
        jDateChoserEndDt = new com.toedter.calendar.JDateChooser();
        jButtonThongKeDoanhThu = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jLabelDoanhThu = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabelLoiNhuan = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jDateChooserStartPn = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jDateChooserEndPn = new com.toedter.calendar.JDateChooser();
        jButtonSearchPn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblphieunhap = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        lbtongphieunhap = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbtongtiennhap = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jDateChoserEndPx = new com.toedter.calendar.JDateChooser();
        jDateChoserStartPx = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButtonSearchPx = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblphieuxuat = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        lbtongphieuxuat = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbtongtienxuat = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jTextFieldSp = new javax.swing.JTextField();
        jButtonFreshSp = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbsanpham = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldKh = new javax.swing.JTextField();
        jButtonFreshKh1 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblkhachhang = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tổng Doanh Thu");

        lbdoanhthu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doanhthu.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lbdoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbdoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Sản Phẩm");

        lbsp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/sanpham.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsp, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbsp, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Khách Hàng");

        lbkh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/khachhang.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(lbkh, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbkh, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Tổng Chi");

        lbtongchi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tienchi.jpg"))); // NOI18N
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(lbtongchi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbtongchi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel14)
                        .addGap(62, 62, 62))))
        );

        jTabbedPane2.setPreferredSize(new java.awt.Dimension(150, 150));

        jPanelThongKeDoanhThu.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel29.setText("Từ ngày");

        jLabel31.setText("Đến ngày");

        jButtonThongKeDoanhThu.setText("Thống kê");
        jButtonThongKeDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThongKeDoanhThuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jDateChoserStartDt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jDateChoserEndDt, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButtonThongKeDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonThongKeDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jDateChoserEndDt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChoserStartDt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
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
        tblDoanhThu.setRowHeight(50);
        jScrollPane5.setViewportView(tblDoanhThu);

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setText("Doanh thu: ");

        jLabelDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setText("Lợi nhuận: ");

        jLabelLoiNhuan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1128, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLoiNhuan, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(jLabelLoiNhuan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelThongKeDoanhThuLayout = new javax.swing.GroupLayout(jPanelThongKeDoanhThu);
        jPanelThongKeDoanhThu.setLayout(jPanelThongKeDoanhThuLayout);
        jPanelThongKeDoanhThuLayout.setHorizontalGroup(
            jPanelThongKeDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelThongKeDoanhThuLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelThongKeDoanhThuLayout.setVerticalGroup(
            jPanelThongKeDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelThongKeDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Doanh Thu", jPanelThongKeDoanhThu);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel13.setText("Từ ngày");

        jLabel15.setText("Đến ngày");

        jButtonSearchPn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search.png"))); // NOI18N
        jButtonSearchPn.setText("Tìm kiếm");
        jButtonSearchPn.setActionCommand("Thống kê");
        jButtonSearchPn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchPnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jDateChooserStartPn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jDateChooserEndPn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButtonSearchPn)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSearchPn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jDateChooserEndPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooserStartPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jButtonSearchPn.getAccessibleContext().setAccessibleName("Thống kê");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblphieunhap.setModel(new javax.swing.table.DefaultTableModel(
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
        tblphieunhap.setRowHeight(50);
        jScrollPane1.setViewportView(tblphieunhap);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setText("Tổng Phiếu:");

        lbtongphieunhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setText("Tổng Tiền:");

        lbtongtiennhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(lbtongphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 466, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbtongtiennhap, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(lbtongphieunhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbtongtiennhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Phiếu Nhập", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel38.setText("Từ ngày");

        jLabel39.setText("Đến ngày");

        jButtonSearchPx.setText("Thống kê");
        jButtonSearchPx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchPxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jDateChoserStartPx, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jDateChoserEndPx, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButtonSearchPx, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSearchPx, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(jDateChoserEndPx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChoserStartPx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblphieuxuat.setModel(new javax.swing.table.DefaultTableModel(
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
        tblphieuxuat.setRowHeight(50);
        jScrollPane2.setViewportView(tblphieuxuat);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setText("Tổng Phiếu: ");

        lbtongphieuxuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Tổng tiền: ");

        lbtongtienxuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbtongphieuxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 492, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbtongtienxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbtongtienxuat, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(lbtongphieuxuat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Phiếu Xuất", jPanel6);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jButtonFreshSp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jButtonFreshSp.setText("Làm mới");
        jButtonFreshSp.setActionCommand("Thống kê");
        jButtonFreshSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFreshSpActionPerformed(evt);
            }
        });

        jLabel2.setText("Nhập tên sản phẩm:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(1010, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jTextFieldSp, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFreshSp)
                        .addGap(100, 100, 100))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFreshSp, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbsanpham.setModel(new javax.swing.table.DefaultTableModel(
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
        tbsanpham.setRowHeight(50);
        jScrollPane3.setViewportView(tbsanpham);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sản Phẩm", jPanel9);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jLabel5.setText("Nhập tên khách hàng:");

        jButtonFreshKh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        jButtonFreshKh1.setText("Làm mới");
        jButtonFreshKh1.setActionCommand("Thống kê");
        jButtonFreshKh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFreshKh1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(1002, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jTextFieldKh, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonFreshKh1)
                        .addGap(100, 100, 100))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldKh, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFreshKh1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblkhachhang.setRowHeight(50);
        jScrollPane4.setViewportView(tblkhachhang);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Khách Hàng", jPanel12);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonThongKeDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThongKeDoanhThuActionPerformed
        // TODO add your handling code here:
        Date ngayBatDau = jDateChoserStartDt.getDate();
        Date ngayKetThuc = jDateChoserEndDt.getDate();
        if(ngayBatDau == null || ngayKetThuc == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày để thống kê");
            return;
        }
        searchDoanhThu(ngayBatDau, ngayKetThuc);
    }//GEN-LAST:event_jButtonThongKeDoanhThuActionPerformed

    private void jButtonSearchPnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchPnActionPerformed
        // TODO add your handling code here:
        Date ngayBatDau = jDateChooserStartPn.getDate();
        Date ngayKetThuc = jDateChooserEndPn.getDate();
        if(ngayBatDau == null || ngayKetThuc == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày để thống kê");
            return;
        }
        searchPn(ngayBatDau, ngayKetThuc);
        
    }//GEN-LAST:event_jButtonSearchPnActionPerformed

    private void jButtonSearchPxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchPxActionPerformed
        // TODO add your handling code here:
        Date ngayBatDau = jDateChoserStartPx.getDate();
        Date ngayKetThuc = jDateChoserEndPx.getDate();
        if(ngayBatDau == null || ngayKetThuc == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày để thống kê");
            return;
        }
        searchPx(ngayBatDau, ngayKetThuc);
    }//GEN-LAST:event_jButtonSearchPxActionPerformed

    private void jButtonFreshSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFreshSpActionPerformed
        // TODO add your handling code here:
        sp = spBus.spDAO.selectAll();
        loadDataToTableSanPham(sp);
    }//GEN-LAST:event_jButtonFreshSpActionPerformed

    private void jButtonFreshKh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFreshKh1ActionPerformed
        // TODO add your handling code here:
        kh = khBus.getAll();
        loadDataToTableKhachHang(kh);
    }//GEN-LAST:event_jButtonFreshKh1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFreshKh1;
    private javax.swing.JButton jButtonFreshSp;
    private javax.swing.JButton jButtonSearchPn;
    private javax.swing.JButton jButtonSearchPx;
    private javax.swing.JButton jButtonThongKeDoanhThu;
    private com.toedter.calendar.JDateChooser jDateChooserEndPn;
    private com.toedter.calendar.JDateChooser jDateChooserStartPn;
    private com.toedter.calendar.JDateChooser jDateChoserEndDt;
    private com.toedter.calendar.JDateChooser jDateChoserEndPx;
    private com.toedter.calendar.JDateChooser jDateChoserStartDt;
    private com.toedter.calendar.JDateChooser jDateChoserStartPx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDoanhThu;
    private javax.swing.JLabel jLabelLoiNhuan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelThongKeDoanhThu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextFieldKh;
    private javax.swing.JTextField jTextFieldSp;
    private javax.swing.JLabel lbdoanhthu;
    private javax.swing.JLabel lbkh;
    private javax.swing.JLabel lbsp;
    private javax.swing.JLabel lbtongchi;
    private javax.swing.JLabel lbtongphieunhap;
    private javax.swing.JLabel lbtongphieuxuat;
    private javax.swing.JLabel lbtongtiennhap;
    private javax.swing.JLabel lbtongtienxuat;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblkhachhang;
    private javax.swing.JTable tblphieunhap;
    private javax.swing.JTable tblphieuxuat;
    private javax.swing.JTable tbsanpham;
    // End of variables declaration//GEN-END:variables
}
