package com.poly.it17322.duan1_nhom2_phanmembansach.response;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.NumberFormat;
import java.util.Locale;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewTableHoaDon {

    private String ma;
    private String khachHang;
    private String nhanVien;
    private Date ngayTao;
    private Date ngayThanhToan;
    private String tinhTrang;
    private String voucher;
    private BigDecimal tongTien ;
    
    public ViewTableHoaDon() {
    }

    public ViewTableHoaDon(HoaDon hoaDon) {
        this.ma = hoaDon.getMa();
        this.khachHang = hoaDon.getKhachHang().getTen();
//        this.nhanVien = hoaDon.getUsers().getTen();
        this.ngayTao = (Date) hoaDon.getNgayTao();
        this.ngayThanhToan = (Date) hoaDon.getNgayThanhToan();
        this.tinhTrang = hoaDon.getTinhTrang() == 0 ? "Chờ thanh toán" : "Đã thanh toán";
        this.voucher = hoaDon.getVoucher().getTen();
        this.tongTien = hoaDon.getTongTien();
    }
    
    
   

}
