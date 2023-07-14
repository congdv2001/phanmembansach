package com.poly.it17322.duan1_nhom2_phanmembansach.response;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewTableHoaDonCT {

    private String maHD;
    private String tenSach;
    private Integer soLuong;
    private BigDecimal donGia;
    private BigDecimal thanhTien;

    public ViewTableHoaDonCT() {
    }

    public ViewTableHoaDonCT(HoaDonChiTiet chiTiet) {
        this.maHD = chiTiet.getHoaDon().getMa();
        this.tenSach = chiTiet.getChiTietSach().getSach().getTenSach();
        this.soLuong = chiTiet.getSoLuong();
        this.donGia = chiTiet.getDonGia();
        this.thanhTien = chiTiet.thanhTien();
    }
    
     public BigDecimal thanhTien() {
        return new BigDecimal(soLuong).multiply(donGia);
    }
}
