/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface KhachHangService {
    List<KhachHang> getList();
    KhachHang getKHByMa(String ma);
    List<KhachHang> timKiem(String sdt);
    Boolean them(KhachHang khachHang);
    Boolean sua(KhachHang khachHang);
    Boolean xoa(KhachHang khachHang);

}
