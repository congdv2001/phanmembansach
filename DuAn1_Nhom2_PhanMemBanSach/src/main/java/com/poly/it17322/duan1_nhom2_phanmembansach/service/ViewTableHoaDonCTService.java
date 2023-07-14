
package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewTableHoaDonCT;
import java.util.List;
import java.util.UUID;

public interface ViewTableHoaDonCTService {
    
    public List<HoaDonChiTiet> getAll();
    
    public List<ViewTableHoaDonCT> getAllTableCT();
    
    public List<ViewTableHoaDonCT> getViewTable(UUID id);
}
