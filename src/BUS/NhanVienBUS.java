/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import GUI.nhanvien;
import java.util.ArrayList;

public class NhanVienBUS {

    public NhanVienDAO nvDAO = new NhanVienDAO();
    public ArrayList<DTO.NhanVienDTO> listNv = NhanVienDAO.getInstance().selectAll();
    public NhanVienDAO nhanVienDAO = NhanVienDAO.getInstance();

    public NhanVienBUS() {
        listNv = nvDAO.selectAll();
    }

    public ArrayList<DTO.NhanVienDTO> getAll() {
        return this.listNv;
    }

    public NhanVienDTO getByIndex(int index) {
        return this.listNv.get(index);
    }

    public int getIndexById(int manv) {
        int i = 0;
        int vitri = -1;
        int size = this.listNv.size();
        while (i < size && vitri == -1) {
            if (this.listNv.get(i).getManv() == manv) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(NhanVienDTO nv) {
        boolean check = nvDAO.insert(nv) != 0;
        if (check) {
            this.listNv.add(nv);
        }
        return check;
    }

    public String getNameById(int manv) {
        return nhanVienDAO.selectById(manv + "").getHoten();
    }

    public String[] getArrTenNhanVien() {
        int size = listNv.size();
        String[] result = new String[size];
        for (int i = 0; i < size; i++) {
            result[i] = listNv.get(i).getHoten();
        }
        return result;
    }

    public boolean update(NhanVienDTO nv) {
        boolean check = nvDAO.update(nv) != 0;
        if (check) {
            this.listNv.set(getIndexById(nv.getManv()), nv);
        }
        return check;
    }

    public Boolean delete(NhanVienDTO nv) {
        boolean check = nvDAO.delete(nv) != 0;
        if (check) {
            this.listNv.remove(nv);
        }
        return check;
    }
    
    public NhanVienDTO getNewlyAddedNV() {
        NhanVienDTO result = null;
        ArrayList<NhanVienDTO> armt = nhanVienDAO.selectAll();
        int max = -1;
        for (var i : armt) {
            if (i.getManv() > max) {
                max = i.getManv();
                result = i;
            }
        }
        return result;
    }
    
    public ArrayList<NhanVienDTO> searchTatCa(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = nhanVienDAO.selectAll();
        for (var nv : armt) {
            if ((""+nv.getManv()).toLowerCase().contains(text.toLowerCase())
                    || nv.getHoten().toLowerCase().contains(text.toLowerCase()))
             {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> searchTenNv(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = nhanVienDAO.selectAll();
        for (var nv : armt) {
            if (nv.getHoten().toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> searchMaNv(int text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = nhanVienDAO.selectAll();
        for (var nv : armt) {
            if (nv.getManv() == text) {
                result.add(nv);
            }
        }
        return result;
    }

    public ArrayList<NhanVienDTO> searchSdt(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = nhanVienDAO.selectAll();
        for (var nv : armt) {
            if (nv.getSdt().contains(text)) {
                result.add(nv);
            }
        }
        return result;
    }
    
    public ArrayList<NhanVienDTO> searchEmail(String text) {
        ArrayList<NhanVienDTO> result = new ArrayList<>();
        ArrayList<NhanVienDTO> armt = nhanVienDAO.selectAll();
        for (var nv : armt) {
            if (nv.getEmail().toLowerCase().contains(text.toLowerCase())) {
                result.add(nv);
            }
        }
        return result;
    }
}
