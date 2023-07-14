/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.response;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author 84865
 */

@Getter
@Setter
public class KhachHangResponse {
    private String ma;
    private String ten;
    private String gioiTinh;
    private String sdt;
    private Integer diemTichLuy;

    public KhachHangResponse() {
    }

    public KhachHangResponse(KhachHang kh) {
        this.ma = kh.getMa();
        this.ten = kh.getTen();
        this.gioiTinh = null;
//                kh.getGioiTinh()  == 0 ? "Nam" : "Nữ";
        this.sdt = kh.getSdt() ;
        this.diemTichLuy = kh.getDiemTichLuy();
    }
    
    

}
