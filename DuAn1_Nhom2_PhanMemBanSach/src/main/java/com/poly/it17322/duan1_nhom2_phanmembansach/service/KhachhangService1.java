/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.KhachHangResponse;
import java.util.List;

/**
 *
 * @author 84865
 */
public interface KhachhangService1 {

    public List<KhachHang> getAll();

    KhachHang getKHBySDT(String ma);

    public List<KhachHang> timKiem(String sdt);

    public KhachHang getOne(Long id);

    public List<KhachHangResponse> getAllViewTable();

    public Boolean add(KhachHang khachHang);

    public Boolean update(KhachHang khachHang);

}
