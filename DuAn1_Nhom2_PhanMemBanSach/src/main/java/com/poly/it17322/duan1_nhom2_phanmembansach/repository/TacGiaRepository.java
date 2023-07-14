/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;


import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TacGia;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ADMIN
 */
public class TacGiaRepository {
     private String fromTable = "From TacGia";

    private Session session = HibernateUtil.getFACTORY().openSession();
    
    public List<TacGia> getAll() {
        Query query = session.createQuery("from TacGia order by ma desc");
        List<TacGia> listtg = query.getResultList();
        return listtg;
        
}
 
     public TacGia getOne(String ma) {
       try {
            Query query = session.createQuery("from TacGia where ma =: ma");
            query.setParameter("ma", ma);
            return (TacGia) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean add(TacGia tg ) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(tg);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(TacGia tg) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(tg);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(TacGia tg) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(tg);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
