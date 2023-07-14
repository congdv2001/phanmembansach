/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChiTietSach;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.NXB;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TacGia;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TheLoai;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Administrator
 */
public class ChiTietSachReponsitory {
     Session session = HibernateUtil.getFACTORY().openSession();
    Transaction transaction = null;

    public List<ChiTietSach> getList(){
        Query query = session.createQuery("from ChiTietSach ");
        return query.getResultList();
    }


    public List<ChiTietSach> timKiem(String ten){
        Query query = session.createQuery("from ChiTietSach ctsp where ctsp.sach.tenSach like: ten or ctsp.sach.ma like: ma");
        query.setParameter("ten", "%" + ten + "%");
        query.setParameter("ma", "%" + ten + "%");
        return query.getResultList();
    }

    public ChiTietSach getCTSByMaSP(String maSach){
        try{
            Query query = session.createQuery("from ChiTietSach ctsp where ctsp.sach.ma =: ma ");
            query.setParameter("ma", maSach);
            return (ChiTietSach) query.getSingleResult();
        }catch (Exception e){
            return null;
        }
    }

    public List<TheLoai> listTheLoai(){
        Query query = session.createQuery("from TheLoai ");
        return query.getResultList();
    }

    public List<NXB> listNXB(){
        Query query = session.createQuery("from NXB ");
        return query.getResultList();
    }

    public List<TacGia> listTacGia(){
        Query query = session.createQuery("from TacGia ");
        return query.getResultList();
    }

    public Boolean them(ChiTietSach cts){
        try{
            transaction = session.beginTransaction();

            session.saveOrUpdate(cts);

            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean sua(ChiTietSach cts){
        try{
            transaction = session.beginTransaction();
            session.update(cts);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public Boolean xoa(ChiTietSach cts){
        try{
            transaction = session.beginTransaction();

            session.delete(cts);

            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }
}
