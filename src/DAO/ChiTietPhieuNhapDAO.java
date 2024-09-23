package DAO;

import DTO.ChiTietPhieuNhapDTO;
import config.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class ChiTietPhieuNhapDAO implements DAOinterface<ChiTietPhieuNhapDTO> {

    public static ChiTietPhieuNhapDAO getInstance() {
        return new ChiTietPhieuNhapDAO();
    }

    @Override
    public int insert(ChiTietPhieuNhapDTO t) {
        int result = 0;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `ctphieunhap`(`maphieunhap`, `masp`, `soluong`, `gianhap`) VALUES (?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getMaphieunhap());
            pst.setInt(2, t.getMasp());
            pst.setInt(3, t.getSoluong());
            pst.setInt(4, t.getDongia());
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return result;
    }

//    @Override
//    public int delete(ChiTietPhieuNhapDTO t) {
//        int result = 0;
//        try {
//            Connection con = (Connection) JDBC.getConnection();
//            String sql = "DELETE FROM ctphieunhap WHERE maphieunhap = ?";
//            PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, t);
//            result = pst.executeUpdate();
//            JDBC.closeConnection(con);
//        } catch (SQLException ex) {
//            Logger.getLogger(ChiTietPhieuNhapDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
//    }
//    @Override
//    public int update(ChiTietPhieuNhapDTO t, String pk) {
//        int result = this.delete(pk);
//        if (result != 0) {
//            result = this.insert(t);
//        }
//        return result;
//    }
//    @Override
//    public ArrayList<ChiTietPhieuNhapDTO> selectAll() {
//        ArrayList<ChiTietPhieuNhapDTO> result = new ArrayList<>();
//        try {
//            Connection con = (Connection) JDBC.getConnection();
//            String sql = "SELECT * FROM ctphieunhap WHERE maphieunhap = ?";
//            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
//            pst.setString(1, t);
//            ResultSet rs = (ResultSet) pst.executeQuery();
//            while (rs.next()) {
//                int maphieu = rs.getInt("maphieunhap");
//                int masp = rs.getInt("masp");
//                String tensp = rs.getString("tensp");
//                int dongia = rs.getInt("dongia");
//                int soluong = rs.getInt("soluong");
//                ChiTietPhieuNhapDTO ctphieu = new ChiTietPhieuNhapDTO(maphieu, masp, tensp, soluong, dongia);
//                result.add(ctphieu);
//            }
//            JDBC.closeConnection(con);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//        return result;
//    }
    @Override
    public int update(ChiTietPhieuNhapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChiTietPhieuNhapDTO selectById(String t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getAutoIncrement() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(ChiTietPhieuNhapDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ChiTietPhieuNhapDTO> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
