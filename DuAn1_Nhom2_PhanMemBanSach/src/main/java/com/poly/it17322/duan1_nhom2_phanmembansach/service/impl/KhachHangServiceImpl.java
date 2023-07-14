/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.KhachHangRepository;

import com.poly.it17322.duan1_nhom2_phanmembansach.service.KhachHangService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class KhachHangServiceImpl implements KhachHangService{
    
     KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    public List<KhachHang> getList() {
        return khachHangRepository.getList();
    }

    @Override
    public KhachHang getKHByMa(String ma) {
        return khachHangRepository.getKHByMa(ma);
    }

    @Override
    public List<KhachHang> timKiem(String sdt) {
        return khachHangRepository.timKiem(sdt);
    }

    @Override
    public Boolean them(KhachHang khachHang) {
        return khachHangRepository.them(khachHang);
    }

    @Override
    public Boolean sua(KhachHang khachHang) {
        return khachHangRepository.sua(khachHang);
    }

    @Override
    public Boolean xoa(KhachHang khachHang) {
        return khachHangRepository.xoa(khachHang);
    }
}
