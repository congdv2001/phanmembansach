/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChiTietSach;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.NXB;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TacGia;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TheLoai;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.QLCTSach;

import java.util.List;

/**
 *
 * @author Administrator
 */
public interface ChiTietSachService {

    List<ChiTietSach> getList();

    List<ChiTietSach> timKiem(String ten);

    List<QLCTSach> getListQLCTSach();

    List<NXB> listNxb();

    List<TheLoai> listTheLoai();

    List<TacGia> listTacGia();

    ChiTietSach getCTSPByMaSP(String maSach);

    Boolean them(ChiTietSach cts);

    Boolean sua(ChiTietSach cts);

    Boolean xoa(ChiTietSach cts);
}
