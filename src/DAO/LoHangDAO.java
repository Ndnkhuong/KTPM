/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.LoHangDTO;
import static GUI.login.t;
import java.sql.ResultSet;
import config.JDBC;
import static config.JDBC.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class LoHangDAO implements DAOinterface<LoHangDTO> {

    public static LoHangDAO getInstance() {
        return new LoHangDAO();
    }

    @Override
    public int insert(LoHangDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `losanpham`(`maphieunhap`, `masp`, `soluong`, `gianhap`, `giaban`) VALUES (?,?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieunhap());
            pst.setInt(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setInt(4, t.getDongia());
            pst.setInt(5, t.getGiaban());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(LoHangDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }

//    @Override
//    public int delete(LoHangDTO t) {
//        int result = 0;
//        try {
//            Connection con = (Connection) JDBC.getConnection();
//            String sql = "DELETE FROM ctphieunhap WHERE maphieunhap = ?";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setInt(1, t.getMaphieunhap());
//            result = pst.executeUpdate();
//            JDBC.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(LoHangDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
    
    public int delete(int maphieunhap) {
    int ketQua = 0;
    try {
        java.sql.Connection con = JDBC.getConnection();
        String sql = "DELETE FROM losanpham WHERE maphieunhap = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, maphieunhap);
        ketQua = pst.executeUpdate();
        JDBC.closeConnection(con);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return ketQua;
}

    
    @Override
    public int update(LoHangDTO t) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE losanpham SET soluong = ? WHERE maphieunhap = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setInt(1, t.getMaphieunhap());
            pst.setInt(2, t.getSoluong());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return ketQua;
    }
    
    @Override
    public ArrayList<LoHangDTO> selectAll() {
        ArrayList<LoHangDTO> result = new ArrayList<>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM losanpham";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int maphieu = rs.getInt("maphieunhap");
                int masp = rs.getInt("masp");
                int gianhap = rs.getInt("gianhap");
                int soluong = rs.getInt("soluong");
                int giaban = rs.getInt("giaban");
                LoHangDTO lh = new LoHangDTO(maphieu, masp, soluong, gianhap, giaban);
                result.add(lh);
            }
            JDBC.closeConnection(con);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    @Override
    public LoHangDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void updateQuantity(int maphieunhap, int soluong) {
        // Tạo câu lệnh SQL để cập nhật số lượng
        String query = "UPDATE losanpham SET soluong = ? WHERE maphieunhap = ?";

        try {
            // Chuẩn bị kết nối và thực hiện cập nhật
            PreparedStatement ps = getConnection().prepareStatement(query);
            ps.setInt(1, soluong);
            ps.setInt(2, maphieunhap);

            // Thực hiện cập nhật
            int rowsUpdated = ps.executeUpdate();
//            if (rowsUpdated > 0) {
//                System.out.println("Cập nhật thành công số lượng cho mã phiếu nhập: " + maphieunhap);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Có lỗi xảy ra khi cập nhật số lượng cho mã phiếu nhập: " + maphieunhap);
        }
    }

    public int updateLosanpham(LoHangDTO t, int minMaPhieuNhap) {
        int ketQua = 0;
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "UPDATE losanpham SET soluong = ? WHERE masp = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, t.getSoluong());
            pst.setInt(2, t.getMasp());
            ketQua = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public ArrayList<Integer> getMaPhieuNhapByMaSP(int masp) {
        ArrayList<Integer> listMaPhieuNhap = new ArrayList<>();
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT maphieunhap FROM losanpham WHERE masp = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, masp);
            ResultSet rs = (ResultSet) pst.executeQuery();

            while (rs.next()) {
                listMaPhieuNhap.add(rs.getInt("maphieunhap"));
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMaPhieuNhap;
    }

    public int getSoluongByMaPhieuNhap(int maphieunhap) {
        int soluong = 0; // Khởi tạo số lượng là 0
        try {
            java.sql.Connection con = JDBC.getConnection();
            String sql = "SELECT soluong FROM losanpham WHERE maphieunhap = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, maphieunhap);
            ResultSet rs = (ResultSet) pst.executeQuery();

            if (rs.next()) {
                soluong = rs.getInt("soluong"); // Lấy số lượng từ kết quả
            }
            JDBC.closeConnection(con); // Đóng kết nối
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soluong; // Trả về số lượng
    }

    public void deleteSanPham(int maPhieuNhap) {
        String sql = "DELETE FROM losanpham WHERE maphieunhap = ?";

        try (Connection connection = getConnection(); 
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, maPhieuNhap);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<LoHangDTO> getSanPhamsByProductId(int masp) {
        ArrayList<LoHangDTO> lh = new ArrayList<>();
        String sql = "SELECT * FROM losanpham WHERE masp = ?";

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
             
            statement.setInt(1, masp);
            ResultSet resultSet = (ResultSet) statement.executeQuery();

            while (resultSet.next()) {
                LoHangDTO sp = new LoHangDTO();
                sp.setMaphieunhap(resultSet.getInt("maphieunhap"));
                sp.setSoluong(resultSet.getInt("soluong"));
                // Thêm các thuộc tính khác nếu cần
                lh.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lh;
    }

    @Override
    public int delete(LoHangDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
