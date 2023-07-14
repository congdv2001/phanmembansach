package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Voucher;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.VCRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.VCService;
import java.util.List;

public class VCServiceImpl implements VCService {

    VCRepository vcRepository = new VCRepository();

    @Override
    public List<Voucher> getList() {
        return vcRepository.getList();
    }

    @Override
    public List<Voucher> locTT(boolean tt) {
        return vcRepository.locTT(tt);
    }

    @Override
    public Voucher getVCByMa(String ma) {
        return vcRepository.getVCByMa(ma);
    }

    @Override
    public List<Voucher> timKiem(String ten) {
        return vcRepository.timKiem(ten);
    }

    @Override
    public Boolean them(Voucher voucher) {
        return vcRepository.them(voucher);
    }

    @Override
    public Boolean sua(Voucher voucher) {
        return vcRepository.sua(voucher);
    }

    @Override
    public Boolean xoa(Voucher voucher) {
        return vcRepository.xoa(voucher);
    }
}
