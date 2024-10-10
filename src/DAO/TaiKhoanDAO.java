package DAO;


import config.JDBC;
import DTO.TaiKhoanDTO;
import GUI.taikhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TaiKhoanDAO implements DAOinterface<TaiKhoanDTO>{
    
    public static TaiKhoanDAO getInstance(){
        return new TaiKhoanDAO();
    }


   
    @Override
    public int insert(TaiKhoanDTO t) {
        int result = 0 ;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "INSERT INTO `taikhoan`(`manv`,`matkhau`,`manhomquyen`,`trangthai`) VALUES (?,?,?,?)";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, t.getManv());
            pst.setString(2, t.getMatkhau());
            pst.setInt(3, t.getManhomquyen());
            pst.setInt(4, t.getTrangthai());
     
            result = pst.executeUpdate();
            JDBC.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }


public int update(TaiKhoanDTO t) {
    int result = 0;
    try {
        Connection con = JDBC.getConnection();
        String sql = "UPDATE `taikhoan` SET `matkhau`=?, `manhomquyen`=?, `trangthai`=? WHERE manv=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, t.getMatkhau());
        pst.setInt(2, t.getManhomquyen());
        pst.setInt(3, t.getTrangthai());
        pst.setInt(4, t.getManv());        
        result = pst.executeUpdate();
        JDBC.closeConnection(con);
    } catch (SQLException ex) {
        Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return result;
}


   

    public int delete(int manv){
        int result = 0;
        try {
            Connection conn = (Connection) JDBC.getConnection();
            String query = "UPDATE `taikhoan` SET `trangthai`=0 WHERE `manv`=?";
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query);
            pst.setInt(1, manv);
            result = pst.executeUpdate();
            JDBC.closeConnection(conn);
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
    

    public ArrayList<TaiKhoanDTO> selectAll() {
        ArrayList<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int manv = rs.getInt("manv");
                String matkhau = rs.getString("matkhau");
                int manhomquyen = rs.getInt("manhomquyen");
                int trangthai = rs.getInt("trangthai");

                TaiKhoanDTO tk = new TaiKhoanDTO(manv, matkhau, manhomquyen, trangthai);
                result.add(tk);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }
    
    public ArrayList<TaiKhoanDTO> selectAllforNVNhap() {
        ArrayList<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE taikhoan.manhomquyen = 2";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int manv = rs.getInt("manv");
                String matkhau = rs.getString("matkhau");
                int manhomquyen = rs.getInt("manhomquyen");
                int trangthai = rs.getInt("trangthai");

                TaiKhoanDTO tk = new TaiKhoanDTO(manv, matkhau, manhomquyen, trangthai);
                result.add(tk);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }
    
    public ArrayList<TaiKhoanDTO> selectAllforNVXuat() {
        ArrayList<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE taikhoan.manhomquyen = 3";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int manv = rs.getInt("manv");
                String matkhau = rs.getString("matkhau");
                int manhomquyen = rs.getInt("manhomquyen");
                int trangthai = rs.getInt("trangthai");

                TaiKhoanDTO tk = new TaiKhoanDTO(manv, matkhau, manhomquyen, trangthai);
                result.add(tk);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
        }
        return result;
    }

    @Override
    public TaiKhoanDTO selectById(String t) {
        TaiKhoanDTO result = null;
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE manv=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int manv = rs.getInt("manv");
                String matkhau = rs.getString("matkhau");
                int manhomquyen = rs.getInt("manhomquyen");
                int trangthai = rs.getInt("trangthai");

                result = new TaiKhoanDTO(manv, matkhau, manhomquyen, trangthai); // Gán giá trị của tk cho result
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi??????? Ở đâu");// In ra lỗi để biết nguyên nhân vấn đề
        }
        return result; // Trả về result sau khi vòng lặp kết thúc
    }
 
    public ArrayList<TaiKhoanDTO> selectAllByManhomquyen(String t) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<TaiKhoanDTO>();
        try {
            Connection con = (Connection) JDBC.getConnection();
            String sql = "SELECT * FROM taikhoan WHERE manhomquyen=?";
            PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, t);
            ResultSet rs = (ResultSet) pst.executeQuery();
            while(rs.next()){
                int manv = rs.getInt("manv");
                String matkhau = rs.getString("matkhau");
                int manhomquyen = rs.getInt("manhomquyen");
                int trangthai = rs.getInt("trangthai");

                TaiKhoanDTO tk = new TaiKhoanDTO(manv, matkhau, manhomquyen, trangthai); // Gán giá trị của tk cho result
                result.add(tk);
            }
            JDBC.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi??????? Ở đâu ai mà biết");// In ra lỗi để biết nguyên nhân vấn đề
        }
        return result; // Trả về result sau khi vòng lặp kết thúc
    }

    public void insert(taikhoan tk) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    @Override
    public int getAutoIncrement() {
    int result = -1;
    try {
        Connection con = (Connection) JDBC.getConnection();
        String sql = "SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'sieuthimini' AND   TABLE_NAME   = 'taikhoan'";
        PreparedStatement pst = (PreparedStatement) con.prepareStatement(sql);
        ResultSet rs2 = pst.executeQuery(sql);
        if (!rs2.isBeforeFirst() ) {
            System.out.println("No data");
        } else {
            while ( rs2.next() ) {
                result = rs2.getInt("AUTO_INCREMENT");
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println("du lieu kh dung");
    }
    return result;
}

    @Override
    public int delete(TaiKhoanDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
