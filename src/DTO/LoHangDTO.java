/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author ASUS
 */
public class LoHangDTO {
    private int malosanpham;
    private int maphieunhap;
    private int masp;
    private String tensp;
    private int soluong;
    private int dongia;
    private int giaban;

    public LoHangDTO() {
    }

    public LoHangDTO(int malosanpham, int maphieunhap, int masp, int soluong, int dongia, int giaban) {
        this.malosanpham = malosanpham;
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.giaban = giaban;
    }
    
    public LoHangDTO(int maphieunhap, int masp, int soluong, int dongia, int giaban) {
        this.maphieunhap = maphieunhap;
        this.masp = masp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.giaban = giaban;
    }
    
    public int getMalosanpham() {
        return malosanpham;
    }

    public void setMalosanpham(int malosanpham) {
        this.malosanpham = malosanpham;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }
    
    public LoHangDTO(int masp, String tensp, int soluong, int dongia) {
        this.masp = masp;
        this.tensp = tensp;
        this.soluong = soluong;
        this.dongia = dongia;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public int getMasp() {
        return masp;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
    
    
}
