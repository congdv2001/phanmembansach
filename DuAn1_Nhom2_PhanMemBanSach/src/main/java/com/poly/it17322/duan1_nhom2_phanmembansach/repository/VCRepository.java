package com.poly.it17322.duan1_nhom2_phanmembansach.repository;



import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Voucher;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class VCRepository {
    Session session = HibernateUtil.getFACTORY().openSession();
    Transaction transaction;

    public List<Voucher> getList(){
        Query query = session.createQuery("from Voucher ");
        return query.getResultList();
    }
    
        public List<Voucher> locTT(boolean tt) {
        Query query = session.createQuery("from Voucher where trangThai=: tt order by ngayTao desc");
        query.setParameter("tt", tt);
        return query.getResultList();
    }

    public List<Voucher> timKiem(String ten) {
        Query query = session.createQuery("from Voucher where ten like: ten order by ngayTao desc");
        query.setParameter("ten", "%" + ten + "%");
        return query.getResultList();
    }

    public Voucher getVCByMa(String ma){
        try {
            Query query = session.createQuery("from Voucher where ma =: ma");
            query.setParameter("ma", ma);
            return (Voucher) query.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    public Boolean them(Voucher voucher) {
        try{
            transaction = session.beginTransaction();

            session.save(voucher);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean sua(Voucher voucher) {
        try{
            transaction = session.beginTransaction();

            session.update(voucher);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean xoa(Voucher voucher) {
        try{
            transaction = session.beginTransaction();

            session.delete(voucher);

            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
