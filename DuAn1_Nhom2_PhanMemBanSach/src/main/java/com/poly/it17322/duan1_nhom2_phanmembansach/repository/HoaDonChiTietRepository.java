package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;

public class HoaDonChiTietRepository {

    private String fromTable = "From HoaDonChiTiet";

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<HoaDonChiTiet> getAll() {
        Query query = session.createQuery(fromTable, HoaDonChiTiet.class);
        List<HoaDonChiTiet> list = query.getResultList();
        return list;
    }
    
    public List<HoaDonChiTiet> getViewTable(UUID id) {
        String sql = fromTable + " WHERE idHoaDon = :id";
        Query query = session.createQuery(sql, HoaDonChiTiet.class);
        query.setParameter("id", id);
        List<HoaDonChiTiet> list = query.getResultList();
        return list;
    }
    
}
