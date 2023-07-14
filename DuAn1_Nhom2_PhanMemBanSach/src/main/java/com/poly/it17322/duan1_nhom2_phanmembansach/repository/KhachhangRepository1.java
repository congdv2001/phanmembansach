/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 84865
 */
public class KhachhangRepository1 {
     private String fromTable = "From KhachHang";

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<KhachHang> getAll() {
        Query query = session.createQuery(fromTable, KhachHang.class);
        List<KhachHang> list = query.getResultList();
        return list;
    }
    

    public KhachHang getKHByMa(String ma) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From KhachHang where ma =: ma");
            query.setParameter("ma", ma);
            return (KhachHang) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
    
     public List<KhachHang> timKiem(String sdt) {
        Query query = session.createQuery("from KhachHang where sdt like: sdt");
        query.setParameter("sdt", "%" + sdt + "%");
        return query.getResultList();
    }



    public KhachHang getOne(Long id) {
        String sql = fromTable + "WHERE id = :id";
        Query query = session.createQuery(sql, KhachHang.class);
        query.setParameter("id", id);
        KhachHang khachHang = (KhachHang) query.getSingleResult();
        return khachHang;
    }

    public Boolean add(KhachHang khachHang) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    
    public static void main(String[] args) {
        List<KhachHang> list = new KhachhangRepository1().getAll();
        for (KhachHang x : list) {
            System.out.println(x.toString());
        }
    }
    
}
