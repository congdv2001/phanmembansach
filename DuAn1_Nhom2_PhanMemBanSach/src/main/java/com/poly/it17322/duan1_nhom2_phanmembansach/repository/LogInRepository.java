package com.poly.it17322.duan1_nhom2_phanmembansach.repository;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.HibernateUtil;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

public class LogInRepository {

    private String fromTable = "From Users";

    private Session session = HibernateUtil.getFACTORY().openSession();

    public List<Users> getAll() {
        Query query = session.createQuery(fromTable, Users.class);
        List<Users> list = query.getResultList();
        return list;
    }
    
    public Users getOne(Long id) {
        String sql = fromTable + "WHERE id = :id";
        Query query = session.createQuery(sql, Users.class);
        query.setParameter("id", id);
        Users users = (Users) query.getSingleResult();
        return users;
    }
}
