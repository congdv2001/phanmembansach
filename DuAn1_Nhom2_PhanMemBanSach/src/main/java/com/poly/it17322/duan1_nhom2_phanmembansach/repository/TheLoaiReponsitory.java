/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TheLoai;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ngo Duy Linh
 */
public class TheLoaiReponsitory {

    private String fromTable = "From TheLoai";

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<TheLoai> getAll() {
        Query query = session.createQuery("from TheLoai order by ma desc");
        List<TheLoai> listTheLoai = query.getResultList();
        return listTheLoai;
    }

  

    public TheLoai getOne(String ma) {
        try {
            Query query = session.createQuery("from TheLoai where ma =: ma");
            query.setParameter("ma", ma);
            return (TheLoai) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean add(TheLoai theLoai) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(theLoai);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(TheLoai theLoai) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(theLoai);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean delete(TheLoai theLoai) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(theLoai);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
