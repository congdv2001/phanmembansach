package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.HoaDonRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewTableHoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.ViewTableHoaDonService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ViewTableHoaDonServiceImpl implements ViewTableHoaDonService {

    private HoaDonRepository repositoryHD = new HoaDonRepository();

    @Override
    public List<HoaDon> getAll() {
        return repositoryHD.getAll();
    }

    @Override
    public List<ViewTableHoaDon> getAllTableHD() {
        List<ViewTableHoaDon> reponse = new ArrayList<>();
        List<HoaDon> list = repositoryHD.getAll();

        for (HoaDon p : list) {
            ViewTableHoaDon viewNhanVien = new ViewTableHoaDon(p);
            reponse.add(viewNhanVien);
        }
        return reponse;
    }

    @Override
    public List<ViewTableHoaDon> timKiem(String tenkh) {
        List<ViewTableHoaDon> reponse = new ArrayList<>();
        List<HoaDon> list = repositoryHD.timKiem(tenkh);

        for (HoaDon p : list) {
            ViewTableHoaDon viewNhanVien = new ViewTableHoaDon(p);
            reponse.add(viewNhanVien);
        }
        return reponse;
    }

    @Override
    public List<ViewTableHoaDon> getViewTrangThai(int tinhTrang) {
        List<ViewTableHoaDon> reponse = new ArrayList<>();
        List<HoaDon> list = repositoryHD.getViewTrangThai(tinhTrang);

        for (HoaDon p : list) {
            ViewTableHoaDon viewNhanVien = new ViewTableHoaDon(p);
            reponse.add(viewNhanVien);
        }
        return reponse;
    }

    @Override
    public List<ViewTableHoaDon> getViewNgayChon(java.util.Date ngayTu, java.util.Date ngayDen) {
        List<ViewTableHoaDon> reponse = new ArrayList<>();
        List<HoaDon> list = repositoryHD.getViewNgayChon(ngayTu, ngayDen);

        for (HoaDon p : list) {
            ViewTableHoaDon viewNhanVien = new ViewTableHoaDon(p);
            reponse.add(viewNhanVien);
        }
        return reponse;
    }

}
