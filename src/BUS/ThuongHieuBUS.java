/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ThuongHieuDAO;
import DTO.ThuongHieuDTO;
import java.util.ArrayList;

/**
 *
 * @author 84907
 */
public class ThuongHieuBUS {

    public final ThuongHieuDAO thDAO = new ThuongHieuDAO();
    private ArrayList<ThuongHieuDTO> listTH = new ArrayList<>();

    public ThuongHieuBUS() {
        listTH = thDAO.selectAll();
    }

    public ArrayList<ThuongHieuDTO> getAll() {
        return this.listTH;
    }

    public ThuongHieuDTO getByIndex(int index) {
        return this.listTH.get(index);
    }

    public int getIndexByMaLH(int ma) {
        int i = 0;
        int vitri = -1;
        while (i < this.listTH.size() && vitri == -1) {
            if (listTH.get(i).getMathuonghieu() == ma) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(ThuongHieuDTO th) {

        boolean check = thDAO.insert(th) != 0;
        if (check) {
            this.listTH.add(th);
        }
        return check;
    }

    public Boolean delete(ThuongHieuDTO lh) {
        boolean check = thDAO.delete(lh) != 0;
        if (check) {
            this.listTH.remove(lh);
        }
        return check;
    }

    public Boolean update(ThuongHieuDTO th) {
        boolean check = thDAO.update(th) != 0;
        if (check) {
            this.listTH.set(getIndexByMaLH(th.getMathuonghieu()), th);
        }
        return check;
    }

    public ArrayList<ThuongHieuDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<ThuongHieuDTO> result = new ArrayList<>();
        for (ThuongHieuDTO i : this.listTH) {
            if (Integer.toString(i.getMathuonghieu()).toLowerCase().contains(text) || i.getTenthuonghieu().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }

    public String[] getArrTenThuongHieu() {
        int size = listTH.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listTH.get(i).getTenthuonghieu();
        }
        return result;
    }

    public String getTenThuongHieu(int mathuonghieu) {
        return this.listTH.get(this.getIndexByMaLH(mathuonghieu)).getTenthuonghieu();
    }

    public boolean checkDup(String name) {
        boolean check = true;
        int i = 0;
        while (i <= this.listTH.size() && check == true) {
            if (this.listTH.get(i).getTenthuonghieu().toLowerCase().contains(name.toLowerCase())) {
                check = false;
            } else {
                i++;
            }
        }
        return check;
    }
}
