/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoHangDAO;
import DTO.LoHangDTO;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class LoHangBUS {

    public final LoHangDAO lhDAO = new LoHangDAO();
    private ArrayList<LoHangDTO> listLh;

    public LoHangBUS() {
        listLh = lhDAO.selectAll();
    }

    public ArrayList<LoHangDTO> getAll() {
        return this.listLh;
    }

    public LoHangDTO getByIndex(int index) {
        return this.listLh.get(index);
    }

    private int getIndexByMaPX(int maphieuxuat) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
