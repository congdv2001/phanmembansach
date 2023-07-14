/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.NhanvienResponse;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author 84865
 */
public class NhanVienRepository {
     private String fromTable = "From Users";

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<Users> getAll() {
        Query query = session.createQuery(fromTable, Users.class);
        List<Users> list = query.getResultList();
        return list;
    }
    

    public Users getUserByMa(String ma) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("From Users where ma =: ma");
            query.setParameter("ma", ma);
            return (Users) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public Users getOne(Long id) {
        String sql = fromTable + "WHERE id = :id";
        Query query = session.createQuery(sql, Users.class);
        query.setParameter("id", id);
        Users users = (Users) query.getSingleResult();
        return users;
    }

    public Boolean add(Users users) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(users);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    public Boolean update(Users users) {
        Transaction transaction = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(users);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return false;
    }

    
    public static void main(String[] args) {
        List<Users> list = new NhanVienRepository().getAll();
        for (Users x : list) {
            System.out.println(x.toString());
        }
    }
}
