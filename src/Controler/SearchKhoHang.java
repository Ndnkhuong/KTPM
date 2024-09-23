/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controler;

import DAO.KhoHangDAO;
import DTO.KhoHangDTO;
import java.util.ArrayList;

/**
 *
 * @author NeON
 */
public class SearchKhoHang {
    public static SearchKhoHang getInstance() {
        return new SearchKhoHang();
    }

    public ArrayList<KhoHangDTO> searchTatCa(String text) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        ArrayList<KhoHangDTO> armt = KhoHangDAO.getInstance().selectAll();
        for (var pn : armt) {
            if ((""+pn.getMakhuvuc()).toLowerCase().contains(text.toLowerCase())
                    || pn.getTenkhuvuc().toLowerCase().contains(text.toLowerCase())
                    || pn.getGhichu().toLowerCase().contains(text.toLowerCase()))
             {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<KhoHangDTO> searchMakhuvuc(String text) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        ArrayList<KhoHangDTO> armt = KhoHangDAO.getInstance().selectAll();
        for (var pn : armt) {
            if ((""+pn.getMakhuvuc()).toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }

    public ArrayList<KhoHangDTO> searchTenkhuvuc(String text) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        ArrayList<KhoHangDTO> armt = KhoHangDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getTenkhuvuc().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }
    
    public ArrayList<KhoHangDTO> searchGhichu(String text) {
        ArrayList<KhoHangDTO> result = new ArrayList<>();
        ArrayList<KhoHangDTO> armt = KhoHangDAO.getInstance().selectAll();
        for (var pn : armt) {
            if (pn.getGhichu().toLowerCase().contains(text.toLowerCase())) {
                result.add(pn);
            }
        }
        return result;
    }
}
