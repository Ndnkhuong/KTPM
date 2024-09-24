/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class DoanhThuDTO {
    private String tensp;
    private int giaban;
    private int gianhap;
    private int soluongban;
    private int doanhthu;
    private int loinhuan;
    private String thoigian;
    
    public DoanhThuDTO() {}
    
    public DoanhThuDTO(String tensp, int giaban, int gianhap, int soluongban, int doanhthu, int loinhuan, String thoigian) {
        this.tensp = tensp;
        this.giaban = giaban;
        this.gianhap = gianhap;
        this.soluongban = soluongban;
        this.doanhthu = doanhthu;
        this.loinhuan = loinhuan;
        this.thoigian = thoigian;
    }
    
    
    
    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }

    public void setGianhap(int gianhap) {
        this.gianhap = gianhap;
    }

    public void setSoluongban(int soluongban) {
        this.soluongban = soluongban;
    }

    public void setDoanhthu() {
        doanhthu = giaban * soluongban;
    }

    public void setLoinhuan() {
        loinhuan = doanhthu - gianhap * soluongban;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getTensp() {
        return tensp;
    }

    public int getGiaban() {
        return giaban;
    }

    public int getGianhap() {
        return gianhap;
    }

    public int getSoluongban() {
        return soluongban;
    }

    public int getDoanhthu() {
        return doanhthu;
    }

    public int getLoinhuan() {
        return loinhuan;
    }

    public String getThoigian() {
        return thoigian;
    }
}
