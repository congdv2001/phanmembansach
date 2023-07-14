package com.poly.it17322.duan1_nhom2_phanmembansach.service;



import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Voucher;
import java.util.List;

public interface VCService {
    List<Voucher> getList();
    List<Voucher> locTT(boolean tt);
    Voucher getVCByMa(String ma);
    List<Voucher> timKiem(String ten);
    Boolean them(Voucher voucher);
    Boolean sua(Voucher voucher);
    Boolean xoa(Voucher voucher);
}
