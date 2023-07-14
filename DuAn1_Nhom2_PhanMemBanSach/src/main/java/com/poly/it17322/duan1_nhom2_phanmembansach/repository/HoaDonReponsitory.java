/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class HoaDonReponsitory {

    private String fromTable = "From HoaDon";
    Session session = HibernateUtil.getFACTORY().openSession();
    Transaction transaction = null;

    public List<HoaDon> getList() {
        Query query = session.createQuery("from HoaDon order by ngayTao desc");
        return query.getResultList();
    }

    public HoaDon getOne(UUID id) {
        String sql = fromTable + "WHERE id = :id";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("id", id);
        HoaDon hoaDon = (HoaDon) query.getSingleResult();
        return hoaDon;
    }

    public HoaDon getHoaDonById(UUID Id) {
        HoaDon hd = new HoaDon();
        try {
            session = HibernateUtil.getFACTORY().openSession();
            Query query = session.createQuery("FROM HoaDon where id = :id", HoaDon.class);
            query.setParameter("id", Id);
            hd = (HoaDon) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hd;
    }

    public List<HoaDon> locTT(Integer tt) {
        Query query = session.createQuery("from HoaDon where tinhTrang=: tt order by ngayTao desc");
        query.setParameter("tt", tt);
        return query.getResultList();
    }

    public List<HoaDon> getHDByDate(Date from, Date to) {
        List<HoaDon> list = new ArrayList<>();
        try {
            session = HibernateUtil.getFACTORY().openSession();
            Query query = session.createQuery("FROM HoaDon where ngayThanhToan >= :from and ngayThanhToan <= :to and tinhTrang = 1", HoaDon.class);
            query.setParameter("from", from);
            query.setParameter("to", to);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                list = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<HoaDon> timKiem(String ma) {
        Query query = session.createQuery("from HoaDon where ma like: ma order by ngayTao asc");
        query.setParameter("ma", "%" + ma + "%");
        return query.getResultList();
    }

    public HoaDon getHDByMa(String ma) {
        try {
            Query query = session.createQuery("from HoaDon where ma=: ma");
            query.setParameter("ma", ma);
            return (HoaDon) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
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

    public List<HoaDon> getViewTrangThai(int tinhTrang) {
        String sql = fromTable + " WHERE tinhTrang = :tinhTrang";
        Query query = session.createQuery(sql, HoaDon.class);
        query.setParameter("tinhTrang", tinhTrang);
        List<HoaDon> list = query.getResultList();
        return list;
    }

    public Boolean them(HoaDon hoaDon) {
        try {
            transaction = session.beginTransaction();

            session.save(hoaDon);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean sua(HoaDon hoaDon) {
        try {
            transaction = session.beginTransaction();

            session.update(hoaDon);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean xoa(HoaDon hoaDon) {
        try {
            transaction = session.beginTransaction();

            session.delete(hoaDon);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
