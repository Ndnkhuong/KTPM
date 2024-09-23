
package DTO;

import java.util.Objects;



public class TaiKhoanDTO {
    private int manv;
    private NhanVienDTO manv1 = new NhanVienDTO();
    private String matkhau;
    private int manhomquyen;
    private String tendangnhap;
    private int trangthai;
    private int maaccount;
    private int manhomquyenaccount;
//     private String email;
     
    
    public TaiKhoanDTO() {
        
    }

    public TaiKhoanDTO(int manv,String matkhau, int manhomquyen, String tendangnhap, int trangthai) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.manhomquyen = manhomquyen;
        this.tendangnhap = tendangnhap;
        this.trangthai = trangthai;
//        this.email = email;
    }
    
    public TaiKhoanDTO(int maaccount, int manhomquyenaccount) {
        this.maaccount = maaccount;
        this.manhomquyenaccount = manhomquyenaccount;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public NhanVienDTO getManv1() {
        return manv1;
    }

    public void setManv1(NhanVienDTO manv1) {
        this.manv1 = manv1;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getManhomquyen() {
        return manhomquyen;
    }

    public void setManhomquyen(int manhomquyen) {
        this.manhomquyen = manhomquyen;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    public int getMaaccount() {
        return maaccount;
    }

    public void setMaaccount(int maaccount) {
        this.maaccount = maaccount;
    }

    public int getManhomquyenaccount() {
        return manhomquyenaccount;
    }

    public void setManhomquyenaccount(int manhomquyenaccount) {
        this.manhomquyenaccount = manhomquyenaccount;
    }
    
    
   
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    @Override
    public int hashCode() {
        int hash = 7;
      
        hash = 83 * hash + Objects.hashCode(this.matkhau);
        hash = 83 * hash + this.manhomquyen;
        hash = 83 * hash + Objects.hashCode(this.tendangnhap);
        hash = 83 * hash + this.trangthai;
//        hash = 83 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TaiKhoanDTO other = (TaiKhoanDTO) obj;
        if (this.manv != other.manv) {
            return false;
        }
        if (this.manhomquyen != other.manhomquyen) {
            return false;
        }
        if (this.trangthai != other.trangthai) {
            return false;
        }
        if (!Objects.equals(this.matkhau, other.matkhau)) {
            return false;
        }
        return Objects.equals(this.tendangnhap, other.tendangnhap);
    }


    @Override
    public String toString() {
        return "TaiKhoanDTO{"  +", matkhau=" + matkhau + ", manhomquyen=" + manhomquyen + ", tendangnhap=" + tendangnhap + ", trangthai=" + trangthai + '}';
    }

    public void setTennhomquyen(String roleName) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
    
}
