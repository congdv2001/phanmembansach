/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.KhachhangRepository1;

import com.poly.it17322.duan1_nhom2_phanmembansach.response.KhachHangResponse;
import java.util.ArrayList;
import java.util.List;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.KhachhangService1;

/**
 *
 * @author 84865
 */
public class KhachhangServiceImpl1 implements KhachhangService1 {
    
    private KhachhangRepository1 khachHangRepository = new KhachhangRepository1();
    
    @Override
    public List<KhachHang> getAll() {
        return this.khachHangRepository.getAll();
    }
    
    @Override
    public KhachHang getOne(Long id) {
        return this.khachHangRepository.getOne(id);
    }
    
    @Override
    public List<KhachHangResponse> getAllViewTable() {
        List<KhachHangResponse> reponse = new ArrayList<>();
        List<KhachHang> list = khachHangRepository.getAll();
        for (KhachHang p : list) {
            KhachHangResponse viewHH = new KhachHangResponse(p);
            reponse.add(viewHH);
        }
        return reponse;
    }
    
    @Override
    public Boolean add(KhachHang khachHang) {
        return this.khachHangRepository.add(khachHang);
    }
    
    @Override
    public Boolean update(KhachHang khachHang) {
        return this.khachHangRepository.update(khachHang);
    }
    
    @Override
    public KhachHang getKHBySDT(String ma) {
        return this.khachHangRepository.getKHByMa(ma);
    }
    
    @Override
    public List<KhachHang> timKiem(String sdt) {
        return this.khachHangRepository.timKiem(sdt);
    }
    
}
