/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.response;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 84865
 */
@Getter
@Setter
public class NhanvienResponse {

    private String ma;
    private String ten;
    private String chucVu;
    private String gioiTinh;
    private String tinhTrang;
    private String email;
    private String sdt;
    

    public NhanvienResponse() {
    }

    public NhanvienResponse(Users users) {
        this.ma = users.getMa();
        this.ten = users.getTen();
        this.chucVu = users.getChucVu().getTenCV();
        this.gioiTinh = users.getGioiTinh() == 0 ? "Nam" : "Nữ";
        this.tinhTrang = users.getTinhTrang() == 0 ? "Đang làm" : "Thôi việc";
        this.email = users.getEmail();
        this.sdt = users.getSdt();
    }

}
