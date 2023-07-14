/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.response;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Administrator
 */
@Getter
@Setter
public class KhachHangI {
    private UUID id;
    private String ten;
    private String sdt;

    public KhachHangI(KhachHang kh) {
        this.id = kh.getId();
        this.ten = kh.getMa()+"-"+kh.getTen();
        this.sdt = kh.getSdt();
    }

    public KhachHangI() {
    }
    
}
