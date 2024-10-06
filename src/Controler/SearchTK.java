/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import java.util.ArrayList;
import DAO.TaiKhoanDAO;
import DAO.NhomQuyenDAO;
import java.util.ArrayList;
import DTO.TaiKhoanDTO;
import DTO.NhomQuyenDTO;

/**
 *
 * @author babib
 */
public class SearchTK {

    public static SearchTK getInstance() {
        return new SearchTK();
    }

    public boolean isInteger(String text) { //Big pp move
        try {
            int test = Integer.valueOf(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public ArrayList<TaiKhoanDTO> searchTatCaAcc(String text, ArrayList<TaiKhoanDTO> currentAcc) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<NhomQuyenDTO> listnq = NhomQuyenDAO.getInstance().selectAll();
        if (isInteger(text)) {
            for (var tk : currentAcc) {
                if (Integer.toString(tk.getManv()).toLowerCase().contains(text.toLowerCase())) {
                    result.add(tk);
                }
            }
        } else {
            for (var i : listnq) {
                if (i.getTennhomquyen().toLowerCase().contains(text.toLowerCase())) {
                    for (var j : currentAcc) {
                        if (i.getManhomquyen() == j.getManhomquyen()) {
                            result.add(j);
                        }
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<TaiKhoanDTO> searchTennhomquyen(String text, ArrayList<TaiKhoanDTO> currentAcc) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        ArrayList<NhomQuyenDTO> listnq = NhomQuyenDAO.getInstance().selectAll();
        for (var i : listnq) {
            if (i.getTennhomquyen().toLowerCase().contains(text.toLowerCase())) {
                for (var j : currentAcc) {
                    if (i.getManhomquyen() == j.getManhomquyen()) {
                        result.add(j);
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<TaiKhoanDTO> searchmanv(String manv, ArrayList<TaiKhoanDTO> currentAcc) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        for (var tk : currentAcc) {
            if (Integer.toString(tk.getManv()).toLowerCase().contains(manv)) {
                result.add(tk);
            }
        }
        return result;
    }
}
