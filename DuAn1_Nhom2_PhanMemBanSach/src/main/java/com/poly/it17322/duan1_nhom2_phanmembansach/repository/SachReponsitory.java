
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;


import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Sach;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SachReponsitory {
    private String fromTable = "From Sach";

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<Sach> getAll() {
        Query query = session.createQuery("from Sach order by ma desc");
        List<Sach> list = query.getResultList();
        return list;
    }

    public Sach getOne(String ma) {
         try {
            Query query = session.createQuery("from Sach where ma =: ma");
            query.setParameter("ma", ma);
            return (Sach) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean add(Sach sach) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(sach);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public Boolean update(Sach sach) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(sach);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
}
