
package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.ViewTableHoaDon;
import java.sql.Date;
import java.util.List;

public interface ViewTableHoaDonService {
    
    public List<HoaDon> getAll();
    
    public List<ViewTableHoaDon> getAllTableHD();
    
    public List<ViewTableHoaDon> timKiem(String tenkh);
    
    public List<ViewTableHoaDon> getViewTrangThai(int tinhTrang);
    
    public List<ViewTableHoaDon> getViewNgayChon(java.util.Date ngayTu, java.util.Date ngayDen);
}
