package BUS;

import DAO.PhieuXuatDAO;
import DTO.PhieuXuatDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author robot
 */
public class PhieuXuatBUS {

    public final PhieuXuatDAO phieuXuatDAO = new PhieuXuatDAO();

    private final ArrayList<PhieuXuatDTO> listPhieuXuat;

    NhanVienBUS nvBUS = new NhanVienBUS();
    KhachHangBUS khBUS = new KhachHangBUS();

    public PhieuXuatBUS() {
        this.listPhieuXuat = phieuXuatDAO.selectAll();
    }

    public ArrayList<PhieuXuatDTO> getAll() {
        return this.listPhieuXuat;
    }

    public PhieuXuatDTO getSelect(int index) {
        return listPhieuXuat.get(index);
    }

//    public void cancel(int px) {
//        phieuXuatDAO.cancel(px);
//    }

    public void remove(int px) {
        listPhieuXuat.remove(px);
    }
    
    public boolean delete(PhieuXuatDTO phieuXuat, int index) {
        boolean check = phieuXuatDAO.delete(phieuXuat) != 0;
        if (check) {
            this.listPhieuXuat.remove(index);
        }
        return check;
    }

    public boolean update(PhieuXuatDTO phieuXuat) {
        boolean check = phieuXuatDAO.update(phieuXuat) != 0;
        if (check) {
            this.listPhieuXuat.set(getIndexByMaphieuxuat(phieuXuat.getMaphieuxuat()), phieuXuat);
        }
        return check;
    }

    public int getIndexByMaphieuxuat(int mapx) {
        int i = 0;
        int vitri = -1;
        while (i < this.listPhieuXuat.size() && vitri == -1) {
            if (listPhieuXuat.get(i).getMaphieuxuat() == mapx) {
                vitri = i;
                break;
            } else {
                i++;
            }
        }
        return vitri;
    }
    
    public boolean delete(int mapx) {
        boolean check = phieuXuatDAO.delete(mapx) > 0;
        if (check) {
            // Xóa thành công, tiến hành cập nhật giao diện hoặc thực hiện các hành động khác nếu cần
        } else {
            // Xóa không thành công, có thể hiển thị thông báo lỗi hoặc xử lý các trường hợp khác
        }
        return check;
    }

}
