/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class KhachHangRepository {
    
  Session session = HibernateUtil.getFACTORY().openSession();
    Transaction transaction = null;

    public List<KhachHang> getList() {
        Query query = session.createQuery("from KhachHang order by ma asc");
        return query.getResultList();
    }
    
       public KhachHang getKhachHangById(UUID Id) {
        KhachHang kh = new KhachHang();
        try {
            session = HibernateUtil.getFACTORY().openSession();
            Query query = session.createQuery("FROM KhachHang where id = :id", KhachHang.class);
            query.setParameter("id", Id);
            kh = (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }

    public List<KhachHang> timKiem(String sdt) {
        Query query = session.createQuery("from KhachHang where sdt like: sdt");
        query.setParameter("sdt", "%" + sdt + "%");
        return query.getResultList();
    }

    public KhachHang getKHByMa(String ma){
        try {
            Query query = session.createQuery("from KhachHang where ma =: ma");
            query.setParameter("ma", ma);
            return (KhachHang) query.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    public Boolean them(KhachHang khachHang) {
        try {
            transaction = session.beginTransaction();

            session.save(khachHang);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean sua(KhachHang khachHang) {
        try {
            transaction = session.beginTransaction();

            session.update(khachHang);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean xoa(KhachHang khachHang) {
        try {
            transaction = session.beginTransaction();

            session.delete(khachHang);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
