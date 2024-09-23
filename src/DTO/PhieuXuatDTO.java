package DTO;
import java.sql.Date;

public class PhieuXuatDTO {
    private int maphieuxuat;
    private Date thoigian;
    private long tongtien;
    private int soluong;
    private int manv;
    private int makh;
    
    private String tenkhachhang;
    private String tennvnhap;
    private int masp;
    private int dongia;
    private String tensp;

    public PhieuXuatDTO() {}

    public PhieuXuatDTO(int maphieuxuat, Date thoigian, long tongtien, int soluong, int manv, int makh) {
        this.maphieuxuat = maphieuxuat;
        this.thoigian = thoigian;
        this.tongtien = tongtien;
        this.soluong = soluong;
        this.manv = manv;
        this.makh = makh;
    }

    public PhieuXuatDTO(int maphieuxuat, String tenkhachhang, String tennvnhap, Date thoigian, long tongtien) {
        this.maphieuxuat = maphieuxuat;
        this.thoigian = thoigian;
        this.tongtien = tongtien;
        this.tenkhachhang = tenkhachhang;
        this.tennvnhap = tennvnhap;
    }
    
    // Constructor ct

    public PhieuXuatDTO(int maphieuxuat, int masp, int soluong, int dongia) {
        this.maphieuxuat = maphieuxuat;
        this.soluong = soluong;
        this.masp = masp;
        this.dongia = dongia;
    }

    public PhieuXuatDTO(int maphieuxuat,int masp, String tensp, int soluong,  int dongia) {
        this.maphieuxuat = maphieuxuat;
        this.soluong = soluong;
        this.masp = masp;
        this.dongia = dongia;
        this.tensp = tensp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    
    

    public int getMaphieuxuat() {
        return maphieuxuat;
    }

    public void setMaphieuxuat(int maphieuxuat) {
        this.maphieuxuat = maphieuxuat;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public long getTongtien() {
        return tongtien;
    }

    public void setTongtien(long tongtien) {
        this.tongtien = tongtien;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getManv() {
        return manv;
    }

    public void setManv(int manv) {
        this.manv = manv;
    }

    public int getMakh() {
        return makh;
    }

    public void setMakh(int makh) {
        this.makh = makh;
    }

    public String getTenkhachhang() {
        return tenkhachhang;
    }

    public void setTenkhachhang(String tenkhachhang) {
        this.tenkhachhang = tenkhachhang;
    }

    public String getTennvnhap() {
        return tennvnhap;
    }

    public void setTennvnhap(String tennvnhap) {
        this.tennvnhap = tennvnhap;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
    
    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + maphieuxuat;
        result = prime * result + ((thoigian == null) ? 0 : thoigian.hashCode());
        result = prime * result + (int) (tongtien ^ (tongtien >>> 32));
        result = prime * result + soluong;
        result = prime * result + manv;
        result = prime * result + makh;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhieuXuatDTO other = (PhieuXuatDTO) obj;
        if (maphieuxuat != other.maphieuxuat)
            return false;
        if (thoigian == null) {
            if (other.thoigian != null)
                return false;
        } else if (!thoigian.equals(other.thoigian))
            return false;
        if (tongtien != other.tongtien)
            return false;
        if (soluong != other.soluong)
            return false;
        if (manv != other.manv)
            return false;
        if (makh != other.makh)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PhieuXuatDTO{" + "maphieuxuat=" + maphieuxuat + ", thoigian=" + thoigian + ", tongtien=" + tongtien
                + ", soluong=" + soluong + ", manv=" + manv + ", makh=" + makh + "}";
    }
}
