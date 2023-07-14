/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service;


import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getList();
    List<HoaDonChiTiet> timKiem(String ma);
    HoaDonChiTiet getCTHD(UUID idHD, UUID idCTS);
    HoaDonChiTiet getByMaHD(String ma);
    List<HoaDonChiTiet> getCTHDByMaHD(String maHD);
    Boolean them(HoaDonChiTiet cthd);
    Boolean sua(HoaDonChiTiet cthd);
    Boolean xoa(HoaDonChiTiet cthd);
}
