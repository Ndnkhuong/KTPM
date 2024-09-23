/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import java.util.ArrayList;
import DAO.TaiKhoanDAO;
import java.util.ArrayList;
import DTO.TaiKhoanDTO;

/**
 *
 * @author babib
 */
public class SearchTK {
     public static SearchTK getInstance() {
        return new SearchTK();
    }


 public ArrayList<TaiKhoanDTO> searchTatCaAcc(String text) {
    ArrayList<TaiKhoanDTO> result = new ArrayList<>();
    ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
    for (var tk : armt) {
        String role = String.valueOf(tk.getManhomquyen());
        if (String.valueOf(tk.getMatkhau()).toLowerCase().contains(text.toLowerCase())
                || tk.getTendangnhap().toLowerCase().contains(text.toLowerCase())
                || role.toLowerCase().contains(text.toLowerCase())) {
            result.add(tk);
        }
    }
    return result;
}



    public ArrayList<TaiKhoanDTO> searchUserName(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            if (tk.getTendangnhap().toLowerCase().contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }
    public ArrayList<TaiKhoanDTO> searchmanv(int manv) {
    ArrayList<TaiKhoanDTO> result = new ArrayList<>();
    ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
    for (var tk : armt) {
        if (tk.getManv() == manv) {
            result.add(tk);
        }
    }
    return result;
}


}

    




