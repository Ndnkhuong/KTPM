/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import java.util.*;

/**
 *
 * @author NeON
 */
public class KhoHangDTO {
    private int makhuvuc;
    private String tenkhuvuc;
    private String ghichu;
    
    private int maphieunhap;
    private String tensp;
    private int slton;
    private long gianhap;
    private int giaban;
    private String hinhanh;
    private int trangthai;
    private Date ngaynhap;
    
    public KhoHangDTO() {}
    
    public KhoHangDTO(int makhuvuc, String tenkhuvuc, String ghichu) {
        this.makhuvuc = makhuvuc;
        this.tenkhuvuc = tenkhuvuc;
        this.ghichu = ghichu;
    }

    public KhoHangDTO(int makhuvuc, int maphieunhap, String tensp, int slton, long gianhap, String hinhanh) {
        this.makhuvuc = makhuvuc;
        this.maphieunhap = maphieunhap;
        this.tensp = tensp;
        this.slton = slton;
        this.gianhap = gianhap;
        this.hinhanh = hinhanh;
    }

    public KhoHangDTO(int makhuvuc, String tenkhuvuc, String ghichu, int trangthai) {
        this.makhuvuc = makhuvuc;
        this.tenkhuvuc = tenkhuvuc;
        this.ghichu = ghichu;
        this.trangthai = trangthai;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
    
    public KhoHangDTO(int makhuvuc, int maphieunhap, String tensp, int slton, long gianhap, int giaban, Date ngaynhap) {
        this.makhuvuc = makhuvuc;
        this.maphieunhap = maphieunhap;
        this.tensp = tensp;
        this.slton = slton;
        this.gianhap = gianhap;
        this.giaban = giaban;
        this.ngaynhap = ngaynhap;
    }

    public long getGianhap() {
        return gianhap;
    }

    public void setGianhap(long gianhap) {
        this.gianhap = gianhap;
    }

    public int getGiaban() {
        return giaban;
    }

    public void setGiaban(int giaban) {
        this.giaban = giaban;
    }
    
    public int getMakhuvuc() {
        return makhuvuc;
    }
    
    public void setMakhuvuc(int makhuvuc) {
        this.makhuvuc = makhuvuc;
    }
    
    public String getTenkhuvuc() {
        return tenkhuvuc;
    }
    
    public void setTenkhuvuc(String tenkhuvuc) {
        this.tenkhuvuc = tenkhuvuc;
    }
    
    public String getGhichu() {
        return ghichu;
    }
    
    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public int getMaphieunhap() {
        return maphieunhap;
    }

    public void setMaphieunhap(int maphieunhap) {
        this.maphieunhap = maphieunhap;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSlton() {
        return slton;
    }

    public void setSlton(int slton) {
        this.slton = slton;
    }

    public long getGia() {
        return gianhap;
    }

    public void setGia(long gianhap) {
        this.gianhap = gianhap;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    } 

    public Date getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(Date ngaynhap) {
        this.ngaynhap = ngaynhap;
    }
    
    
    
    
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + makhuvuc;
        result = prime * result + ((tenkhuvuc == null) ? 0 : tenkhuvuc.hashCode());
        result = prime * result + ((ghichu == null) ? 0 : ghichu.hashCode());
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
        KhoHangDTO other = (KhoHangDTO) obj;
        if (makhuvuc != other.makhuvuc)
            return false;
        if (tenkhuvuc == null) {
            if (other.tenkhuvuc != null)
                return false;
        } else if (!tenkhuvuc.equals(other.tenkhuvuc))
            return false;
        if (ghichu == null) {
            if (other.ghichu != null)
                return false;
        } else if (!ghichu.equals(other.ghichu))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Khu vuc kho{" + "makhuvuc=" + makhuvuc + ", tenkhuvuc=" + tenkhuvuc + ", ghichu=" + ghichu + "}";
    }
}
