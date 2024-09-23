/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.LoHangDAO;
import DAO.SanPhamDAO;
import DTO.LoHangDTO;
import DTO.SanPhamDTO;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Bao Phan
 */
public class SanPhamBUS {

    public final SanPhamDAO spDAO = new SanPhamDAO();
    public final LoHangDAO lhDAO = new LoHangDAO();

    private ArrayList<SanPhamDTO> listSP = new ArrayList<>();
    private ArrayList<LoHangDTO> listLH = new ArrayList<>();

    public SanPhamBUS() {
        listSP = spDAO.selectAll();
    }

    public ArrayList<SanPhamDTO> getAll() {
        return this.listSP;
    }

    public SanPhamDTO getByIndex(int index) {
        return this.listSP.get(index);
    }

    public SanPhamDTO getByMaSP(int masp) {
        int vitri = -1;
        int i = 0;
        while (i <= this.listSP.size() && vitri == -1) {
            if (this.listSP.get(i).getMasp() == masp) {
                vitri = i;
            } else {
                i++;
            }
        }
        return this.listSP.get(vitri);
    }

    public int getIndexByMaSP(int masanpham) {
        int i = 0;
        int vitri = -1;
        while (i < this.listSP.size() && vitri == -1) {
            if (listSP.get(i).getMasp() == masanpham) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(SanPhamDTO sp) {
        boolean check = spDAO.insert(sp) != 0;
        if (check) {
            this.listSP.add(sp);
        }
        return check;
    }

    public Boolean delete(SanPhamDTO sp) {
        boolean check = spDAO.delete(sp) != 0;
        if (check) {
            this.listSP.remove(sp);
        }
        return check;
    }

    public Boolean update(SanPhamDTO sp) {
        boolean check = spDAO.update(sp) != 0;
        if (check) {
            this.listSP.set(getIndexByMaSP(sp.getMasp()), sp);
        }
        return check;
    }

    public ArrayList<SanPhamDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        for (SanPhamDTO i : this.listSP) {
            if (Integer.toString(i.getMasp()).toLowerCase().contains(text) || i.getTensp().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }

    public int getQuantity() {
        ArrayList<SanPhamDTO> result = new ArrayList<>();
        int n = 0;
        for (SanPhamDTO i : this.listSP) {
            if (i.getSoluongton() != 0) {
                n += i.getSoluongton();
            }
        }
        return n;
    }

    public boolean updateQuantity(int masp, int soluong) {
        SanPhamDTO sp = getByMaSP(masp);
        if (sp != null) {
            // Cập nhật số lượng tồn mới bằng cách cộng thêm vào số lượng hiện tại
            int newQuantity = sp.getSoluongton() + soluong;
            sp.setSoluongton(newQuantity);

            // Gọi phương thức update của SanPhamDAO để cập nhật thông tin sản phẩm vào cơ sở dữ liệu
            int updateSuccess = spDAO.updateQuantity(sp);
            return true;
        }
        return false; // Trả về false nếu không tìm thấy sản phẩm
    }

    public boolean subtractQuantity(int masp, int soluong) {
        // Lấy thông tin sản phẩm từ cơ sở dữ liệu dựa trên mã sản phẩm
        SanPhamDTO sp = getByMaSP(masp);

        if (sp != null) {
            // Kiểm tra xem số lượng tồn kho hiện tại có đủ để trừ không
            if (sp.getSoluongton() >= soluong) {
                // Trừ số lượng tồn kho mới bằng cách trừ đi số lượng hiện tại
                int newQuantity = sp.getSoluongton() - soluong;
                sp.setSoluongton(newQuantity);

                // Gọi phương thức update của SanPhamDAO để cập nhật thông tin sản phẩm vào cơ sở dữ liệu
                int updateSuccess = spDAO.updateQuantity(sp);
                return true;
            } else {
                // Trả về false nếu số lượng tồn kho không đủ để trừ
                return false;
            }
        }
        return false; // Trả về false nếu không tìm thấy sản phẩm
    }

    // Trừ số lượng sản phẩm và cập nhật vào CSDL
//    public void truSoLuong(int maSanPham, int soLuongCanTru) {
//        // Lọc danh sách sản phẩm cần xử lý
//        ArrayList<LoHangDTO> danhSachSanPham = new ArrayList<>();
//        for (LoHangDTO loHang : dsLoHang) {
//            if (loHang.getMasp() == maSanPham) {
//                danhSachSanPham.add(loHang);
//            }
//        }
//
//        // Sắp xếp theo mã phiếu nhập tăng dần
//        Collections.sort(danhSachSanPham, Comparator.comparing(LoHangDTO::getMaphieunhap));
//
//        // Trừ số lượng theo thứ tự
//        for (LoHangDTO loHang : danhSachSanPham) {
//            if (soLuongCanTru <= 0) {
//                break;
//            }
//
//            int soLuongHienTai = loHang.getSoluong();
//            if (soLuongHienTai <= soLuongCanTru) {
//                soLuongCanTru -= soLuongHienTai;
//                loHang.setSoluong(0);
//            } else {
//                loHang.setSoluong(soLuongHienTai - soLuongCanTru);
//                soLuongCanTru = 0;
//            }
//        }
//        LoHangDTO lh = new LoHangDTO(maphieunhap, masp, soluong, gianhap, giaban);
//        lhDAO.update(lh);
//    }
}
