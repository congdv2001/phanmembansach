package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.HoaDonChiTietRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewTableHoaDonCT;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.ViewTableHoaDonCTService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ViewTableHoaDonCTServieImpl implements ViewTableHoaDonCTService {
    
    private HoaDonChiTietRepository repositoryCt = new HoaDonChiTietRepository();
    
    @Override
    public List<HoaDonChiTiet> getAll() {
        return repositoryCt.getAll();
    }
    
    @Override
    public List<ViewTableHoaDonCT> getAllTableCT() {
        List<ViewTableHoaDonCT> reponse = new ArrayList<>();
        List<HoaDonChiTiet> list = repositoryCt.getAll();
        
        for (HoaDonChiTiet p : list) {
            ViewTableHoaDonCT viewNhanVien = new ViewTableHoaDonCT(p);
            reponse.add(viewNhanVien);
        }
        return reponse;
    }
    
    @Override
    public List<ViewTableHoaDonCT> getViewTable(UUID id) {
        List<ViewTableHoaDonCT> reponse = new ArrayList<>();
        List<HoaDonChiTiet> list = repositoryCt.getViewTable(id);

        for (HoaDonChiTiet p : list) {
            ViewTableHoaDonCT viewNhanVien = new ViewTableHoaDonCT(p);
            reponse.add(viewNhanVien);
        }
        return reponse;
    }
    
}
