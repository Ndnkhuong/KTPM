/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;
public class NhaCungCapBUS {
 
    public final NhaCungCapDAO nccDAO = new NhaCungCapDAO();

    private ArrayList<NhaCungCapDTO> listNCC = new ArrayList<>();

    public NhaCungCapBUS() {
        listNCC = nccDAO.selectAll();
    }

    public ArrayList<NhaCungCapDTO> getAll() {

        return this.listNCC;
    }

    public NhaCungCapDTO getByIndex(int index) {
        return this.listNCC.get(index);
    }

    public NhaCungCapDTO getByMaSP(int mancc) {
        int vitri = -1;
        int i = 0;
        while (i <= this.listNCC.size() && vitri == -1) {
            if (this.listNCC.get(i).getMancc() == mancc) {
                vitri = i;
            } else {
                i++;
            }
        }
        return this.listNCC.get(vitri);
    }

    public int getIndexByMaSP(int mancc) {
        int i = 0;
        int vitri = -1;
        while (i < this.listNCC.size() && vitri == -1) {
            if (listNCC.get(i).getMancc() == mancc) {
                vitri = i;
            } else {
                i++;
            }
        }
        return vitri;
    }

    public Boolean add(NhaCungCapDTO ncc) {
        boolean check = nccDAO.insert(ncc) != 0;
        if (check) {
            this.listNCC.add(ncc);
        }
        return check;
    }

    public Boolean delete(NhaCungCapDTO ncc) {
        boolean check = nccDAO.delete(ncc) != 0;
        if (check) {
            this.listNCC.remove(ncc);
        }
        return check;
    }

    public Boolean update(NhaCungCapDTO ncc) {
        boolean check = nccDAO.update(ncc) != 0;
        if (check) {
            this.listNCC.set(getIndexByMaSP(ncc.getMancc()), ncc);
        }
        return check;
    }
    public ArrayList<NhaCungCapDTO> search(String text) {
        text = text.toLowerCase();
        ArrayList<NhaCungCapDTO> result = new ArrayList<>();
        for (NhaCungCapDTO i : this.listNCC) {
            if (Integer.toString(i.getMancc()).toLowerCase().contains(text) || i.getTenncc().toLowerCase().contains(text)) {
                result.add(i);
            }
        }
        return result;
    }
    
}

