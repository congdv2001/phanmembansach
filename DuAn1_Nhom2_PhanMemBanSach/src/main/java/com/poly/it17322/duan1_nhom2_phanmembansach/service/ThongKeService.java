package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewThongKe;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewThongKeNgay;
import java.sql.Date;
import java.util.List;

public interface ThongKeService {

    public List<HoaDon> getAll();
    
    public ViewThongKeNgay getTongHoaDonNgay(Date ngay);
    
    public ViewThongKe getTongHoaDonThang(Date thang);
    
    public ViewThongKe getTongHoaDonNam(Date nam);
    
    public ViewThongKe getTongHoaDonTuyChon(java.util.Date batDau, java.util.Date ketThuc);
    
    public List<ViewThongKeNgay> getViewNgayTrongThang(int thang, int nam);
    
    public List<ViewThongKeNgay> getViewThangTrongNam(int nam);
    
    public List<ViewThongKeNgay> getViewTKNam(int nam);
}
