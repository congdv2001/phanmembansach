/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.HoaDonReponsitory;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.KhachHangRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewTableHoaDon;

import com.poly.it17322.duan1_nhom2_phanmembansach.service.HoaDonService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class HoaDonServiceImpl implements HoaDonService {

    HoaDonReponsitory hdRepo = new HoaDonReponsitory();
    KhachHangRepository khRepo = new KhachHangRepository();

    @Override
    public List<HoaDon> getList() {
        return hdRepo.getList();
    }

    @Override
    public List<HoaDon> locTT(Integer tt) {
        return hdRepo.locTT(tt);
    }

    @Override
    public HoaDon getHDByMa(String ma) {
        return hdRepo.getHDByMa(ma);
    }

    @Override
    public List<HoaDon> timKiem(String ten) {
        return hdRepo.timKiem(ten);
    }

    @Override
    public Boolean them(HoaDon hoaDon) {
        return hdRepo.them(hoaDon);
    }

    @Override
    public Boolean sua(HoaDon hoaDon) {
        return hdRepo.sua(hoaDon);
    }

    @Override
    public Boolean xoa(HoaDon hoaDon) {
        return hdRepo.xoa(hoaDon);
    }

    @Override
    public HoaDon getOne(UUID id) {
        return hdRepo.getOne(id);
    }

    @Override
    public Boolean thanhToan(HoaDon h) {
        try {
            HoaDon hd = hdRepo.getHoaDonById(h.getId());
//            hd.setKhachHang(khRepo.getKhachHangById(h.getId()));
            hd.setMa(h.getMa());
            hd.setNgayThanhToan(new Date());
            hd.setTenKH(h.getKhachHang().getTen());
            hd.setTongTien(h.getTongTien());
            hd.setTinhTrang(1);
            return hdRepo.sua(hd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public List<ViewTableHoaDon> getViewNgayChon(java.util.Date ngayTu, java.util.Date ngayDen) {
        List<ViewTableHoaDon> reponse = new ArrayList<>();
        List<HoaDon> list = hdRepo.getViewNgayChon(ngayTu, ngayDen);

        for (HoaDon p : list) {
            ViewTableHoaDon viewNhanVien = new ViewTableHoaDon(p);
            reponse.add(viewNhanVien);
        }
        return reponse;
    }
    
        @Override
    public List<ViewTableHoaDon> getViewTrangThai(int tinhTrang) {
        List<ViewTableHoaDon> reponse = new ArrayList<>();
        List<HoaDon> list = hdRepo.getViewTrangThai(tinhTrang);

        for (HoaDon p : list) {
            ViewTableHoaDon viewNhanVien = new ViewTableHoaDon(p);
            reponse.add(viewNhanVien);
        }
        return reponse;
    }
}
