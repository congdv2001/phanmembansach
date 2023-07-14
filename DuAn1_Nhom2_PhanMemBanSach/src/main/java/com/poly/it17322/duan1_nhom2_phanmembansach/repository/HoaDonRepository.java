package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import java.sql.Date;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class HoaDonRepository {

    private String fromTable = "From HoaDon";

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<HoaDon> getAll() {
        Query query = session.createQuery(fromTable, HoaDon.class);
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public List<HoaDon> timKiem(String tenkh) {
        String sql = fromTable + " WHERE tenKH = :tenkh";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("tenkh", "%" + tenkh + "%");
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public List<HoaDon> getViewTrangThai(int tinhTrang) {
        String sql = fromTable + " WHERE tinhTrang = :tinhTrang";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("tinhTrang", tinhTrang);
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public List<HoaDon> getViewNgayChon(java.util.Date ngayTu, java.util.Date ngayDen) {
        String sql = fromTable + " WHERE (ngayTao BETWEEN :ngayTu AND :ngayDen)"
                + " OR (ngayThanhToan BETWEEN :ngayTu AND :ngayDen)";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("ngayTu", ngayTu);
        query.setParameter("ngayDen", ngayDen);
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public static void main(String[] args) {
        List<HoaDon> list = new HoaDonRepository().getViewTrangThai(0);

        for (HoaDon hoaDon : list) {
            System.out.println(hoaDon.toString());
        }
    }
}
