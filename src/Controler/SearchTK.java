/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.NhomQuyenDAO;
import java.util.ArrayList;
import DAO.TaiKhoanDAO;
import DTO.NhomQuyenDTO;
import java.util.ArrayList;
import DTO.TaiKhoanDTO;

/**
 *
 * @author babib
 */
public class SearchTK {
    
    private ArrayList<NhomQuyenDTO> nhomQuyenDTO = NhomQuyenDAO.getInstance().selectAll();
    
    public static SearchTK getInstance() {
        return new SearchTK();
    }
    
    public String checkTenNhomQuyen(int maNQ) {
        for(var x : nhomQuyenDTO) {
            if(x.getManhomquyen()==maNQ)
                return x.getTennhomquyen().toLowerCase();
        }
        return null;
    }


    public ArrayList<TaiKhoanDTO> searchTatCaAcc(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        
        for (var tk : armt) {
            if ((tk.getManv()+"").contains(text) || checkTenNhomQuyen(tk.getManhomquyen()).contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }

    public ArrayList<TaiKhoanDTO> searchManhomquyen(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            if (checkTenNhomQuyen(tk.getManhomquyen()).contains(text.toLowerCase())) {
                result.add(tk);
            }
        }
        return result;
    }
    
    public ArrayList<TaiKhoanDTO> searchmanv(String text) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<TaiKhoanDTO> armt = TaiKhoanDAO.getInstance().selectAll();
        for (var tk : armt) {
            if ((tk.getManv()+"").contains(text)) {
                result.add(tk);
            }
        }
        return result;
    }
}

    




