/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.NhomQuyenDAO;
import DAO.TaiKhoanDAO;
import DTO.NhomQuyenDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

import DAO.NhomQuyenDAO;
import DAO.SanPhamDAO;
import DAO.TaiKhoanDAO;
import DTO.NhomQuyenDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author robot
 */
public class TaiKhoanBUS {

    private ArrayList<TaiKhoanDTO> listTaiKhoan;
    public final TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private ArrayList<NhomQuyenDTO> listNhomQuyen;
    private NhomQuyenDAO nhomQuyenDAO = NhomQuyenDAO.getInstance();

    public TaiKhoanBUS() {
        this.listTaiKhoan = TaiKhoanDAO.getInstance().selectAll();
        this.listNhomQuyen = NhomQuyenDAO.getInstance().selectAll();

    }

    public NhomQuyenDTO getNhomQuyenDTO(int manhom) {
        return nhomQuyenDAO.selectById(manhom + "");
    }

    public ArrayList<TaiKhoanDTO> getTaiKhoanAll() {
        return listTaiKhoan;
    }

    public TaiKhoanDTO getTaiKhoan(int index) {
        return listTaiKhoan.get(index);
    }

    public int getTaiKhoanByMaNV(int manv) {
        int i = 0;
        int vitri = -1;
        while (i < this.listTaiKhoan.size() && vitri == -1) {
            if (listTaiKhoan.get(i).getManv() == manv) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(TaiKhoanDTO tk) {
        boolean check = tkDAO.insert(tk) != 0;
        if (check) {
            this.listTaiKhoan.add(tk);
        }
        return check;
    }

    public boolean delete(TaiKhoanDTO tk) {
    if (tkDAO.delete(tk.getManv()) != 0) {
        // Kiểm tra trực tiếp xem tài khoản đã được xóa thành công từ cơ sở dữ liệu hay không
        listTaiKhoan.remove(tk);
        return true;
    }
    return false;
}

    public Boolean update(TaiKhoanDTO tk) {
        boolean check = tkDAO.update(tk) != 0;
        if (check) {
            this.listTaiKhoan.set(getTaiKhoanByMaNV(tk.getManv()), tk);
        }
        return check;
    }

    public ArrayList<TaiKhoanDTO> search(String txt, String type) {
        ArrayList<TaiKhoanDTO> result = new ArrayList<>();
        txt = txt.toLowerCase();
        switch (type) {
            case "Tất cả" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (Integer.toString(i.getManv()).contains(txt) || i.getTendangnhap().contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Mã nhân viên" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (Integer.toString(i.getManv()).contains(txt)) {
                        result.add(i);
                    }
                }
            }
            case "Username" -> {
                for (TaiKhoanDTO i : listTaiKhoan) {
                    if (i.getTendangnhap().toLowerCase().contains(txt)) {
                        result.add(i);
                    }
                }
            }
        }
        return result;
    }

}
