package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.ThongKeRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewThongKe;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewThongKeNgay;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.ThongKeService;
import java.sql.Date;
import java.util.List;

public class ThongKeServiceImpl implements ThongKeService {

    ThongKeRepository repository = new ThongKeRepository();

    @Override
    public List<HoaDon> getAll() {
        return repository.getAll();
    }

    @Override
    public ViewThongKeNgay getTongHoaDonNgay(Date ngay) {
        return repository.getTongHoaDonNgay(ngay);
    }

    @Override
    public ViewThongKe getTongHoaDonNam(Date nam) {
        return repository.getTongHoaDonNam(nam);
    }

    @Override
    public ViewThongKe getTongHoaDonThang(Date thang) {
        return repository.getTongHoaDonThang(thang);
    }

    @Override
    public ViewThongKe getTongHoaDonTuyChon(java.util.Date batDau, java.util.Date ketThuc) {
        return repository.getTongHoaDonTuyChon(batDau, ketThuc);
    }

    @Override
    public List<ViewThongKeNgay> getViewNgayTrongThang(int thang, int nam) {
        return repository.getViewNgayTrongThang(thang, nam);
    }

    @Override
    public List<ViewThongKeNgay> getViewThangTrongNam(int nam) {
        return repository.getViewThangTrongNam(nam);
    }

    @Override
    public List<ViewThongKeNgay> getViewTKNam(int nam) {
        return repository.getViewTKNam(nam);
    }


}
