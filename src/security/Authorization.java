/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security;

import GUI.login;
import javax.swing.JButton;

/**
 *
 * @author ASUS
 */
public class Authorization {
    JButton btnThem;
    JButton btnSua;
    JButton btnXoa;

    public Authorization(JButton btnThem, JButton btnSua, JButton btnXoa) {
        this.btnThem = btnThem;
        this.btnSua = btnSua;
        this.btnXoa = btnXoa;
        
        if(login.t.getManhomquyenaccount() == 1 ||  login.t.getManhomquyenaccount() == 4){
             
        } else {
            btnThem.hide();
            btnSua.hide();
            btnXoa.hide();
        }
    }
    
    
}
