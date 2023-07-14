package com.poly.it17322.duan1_nhom2_phanmembansach.config;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChiTietSach;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChucVu;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhuyenMai;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.NXB;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Sach;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Sach_KhuyenMai;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TacGia;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TheLoai;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Voucher;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=CuaHangBanSach_Group2_IT17322");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");
        
        conf.setProperties(properties);
        conf.addAnnotatedClass(ChiTietSach.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(NXB.class);
        conf.addAnnotatedClass(Sach.class);
        conf.addAnnotatedClass(TacGia.class);
        conf.addAnnotatedClass(TheLoai.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(Users.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(Sach_KhuyenMai.class);
        conf.addAnnotatedClass(Voucher.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }
    
}
