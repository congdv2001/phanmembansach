/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class HoaDonChiTietReponsitory {
      Session session = HibernateUtil.getFACTORY().openSession();
    Transaction transaction = null;

    public List<HoaDonChiTiet> getList() {
        Query query = session.createQuery("from HoaDonChiTiet ");
        return query.getResultList();
    }

    public List<HoaDonChiTiet> timKiem(String ma) {
        Query query = session.createQuery("from HoaDonChiTiet cthd where cthd.hoaDon.ma like: maHD or cthd.chiTietSach.sach.ma like: maSach");
        query.setParameter("maHD", "%" + ma + "%");
        query.setParameter("maSP", "%" + ma + "%");
        return query.getResultList();
    }
    
    public List<HoaDonChiTiet> SelectByHoaDonCTID(UUID id) {
        List<HoaDonChiTiet> listHoaDonChiTiet = new ArrayList<>();
        try {
            Query query = session.createQuery("FROM HoaDonChiTiet where idHoaDon = :id", HoaDonChiTiet.class);
            query.setParameter("id", id);
            if (query.getResultList() != null && !query.getResultList().isEmpty()) {
                listHoaDonChiTiet = query.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonChiTiet;
    }

    public HoaDonChiTiet getCTHD(UUID idHD, UUID idCTS) {
        HoaDonChiTiet cthd = null;
        try {
            Query query = session.createQuery("select cthd from HoaDonChiTiet cthd where cthd.hoaDon.id =: idHD and cthd.chiTietSach.id =: idCTS ");
            query.setParameter("idHD", idHD);
            query.setParameter("idCTS", idCTS);
            cthd = (HoaDonChiTiet) query.getSingleResult();
        } catch (Exception ignored) {
        }
        return cthd;
    }

    public HoaDonChiTiet getByMaHD(String ma) {
        Query query = session.createQuery("from HoaDonChiTiet cthd where cthd.hoaDon.ma =: ma");
        query.setParameter("ma", ma);
        return (HoaDonChiTiet) query.getSingleResult();
    }


    public List<HoaDonChiTiet> getCTHDByMaHD(String ma) {
        Query query = session.createQuery("select cthd from HoaDonChiTiet cthd where cthd.hoaDon.ma = : ma");
        query.setParameter("ma", ma);
        return query.getResultList();
    }


    public Boolean them(HoaDonChiTiet cthd) {
        try {
            transaction = session.beginTransaction();

            session.save(cthd);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean sua(HoaDonChiTiet cthd) {
        try {
            transaction = session.beginTransaction();

            session.update(cthd);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean xoa(HoaDonChiTiet cthd) {
        try {
            transaction = session.beginTransaction();

            session.delete(cthd);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
