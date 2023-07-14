/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.HoaDonChiTietReponsitory;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.HoaDonChiTietService;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService{

    HoaDonChiTietReponsitory hdctRepo = new HoaDonChiTietReponsitory();
    @Override
    public List<HoaDonChiTiet> getList() {
       return hdctRepo.getList();
    }

    @Override
    public List<HoaDonChiTiet> timKiem(String ma) {
        return hdctRepo.timKiem(ma);
    }

    @Override
    public HoaDonChiTiet getCTHD(UUID idHD, UUID idCTS) {
        return hdctRepo.getCTHD(idHD, idCTS);
    }

    @Override
    public HoaDonChiTiet getByMaHD(String ma) {
       return hdctRepo.getByMaHD(ma);
    }

    @Override
    public List<HoaDonChiTiet> getCTHDByMaHD(String maHD) {
        return hdctRepo.getCTHDByMaHD(maHD);
    }

    @Override
    public Boolean them(HoaDonChiTiet cthd) {
      return hdctRepo.them(cthd);
    }

    @Override
    public Boolean sua(HoaDonChiTiet cthd) {
        return hdctRepo.sua(cthd);
    }

    @Override
    public Boolean xoa(HoaDonChiTiet cthd) {
        return hdctRepo.xoa(cthd);
    }
    
}
