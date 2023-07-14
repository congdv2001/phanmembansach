/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChucVu;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author 84865
 */
public class ChucVuRepository {
    private String fromTable = "From ChucVu";

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<ChucVu> getAll() {
       Query query = session.createQuery(fromTable, ChucVu.class);
        List<ChucVu> list = query.getResultList();
        return list;

    }
    
   

    
}
