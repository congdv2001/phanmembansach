/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChiTietSach;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.NXB;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TacGia;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TheLoai;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.ChiTietSachReponsitory;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.QLCTSach;

import com.poly.it17322.duan1_nhom2_phanmembansach.service.ChiTietSachService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ChiTietSachServiceImpl implements ChiTietSachService {

    ChiTietSachReponsitory repo = new ChiTietSachReponsitory();

    @Override
    public List<ChiTietSach> getList() {
        return repo.getList();
    }

    @Override
    public List<ChiTietSach> timKiem(String ten) {
        return repo.timKiem(ten);
    }

    @Override
    public List<NXB> listNxb() {
        return repo.listNXB();
    }

    @Override
    public List<TheLoai> listTheLoai() {
        return repo.listTheLoai();
    }

    @Override
    public List<TacGia> listTacGia() {
        return repo.listTacGia();
    }

    @Override
    public ChiTietSach getCTSPByMaSP(String maSach) {
        return repo.getCTSByMaSP(maSach);
    }

    @Override
    public Boolean them(ChiTietSach cts) {
        return repo.them(cts);
    }

    @Override
    public Boolean sua(ChiTietSach cts) {
        return repo.sua(cts);
    }

    @Override
    public Boolean xoa(ChiTietSach cts) {
        return repo.xoa(cts);
    }

    @Override
    public List<QLCTSach> getListQLCTSach() {
        List<QLCTSach> list = new ArrayList<>();
        for (ChiTietSach s : repo.getList()) {
            list.add(new QLCTSach(
                    s.getSach().getTenSach(),
                    s.getNxb().getTenNXB(),
                    s.getTheLoai().getTenTL(),
                    s.getTacGia().getTenTG(),
                    s.getSoLuongTon(),
                    s.getDonGia(),
                    s.getMoTa()
                    ));
        }
        return list;
    }

}