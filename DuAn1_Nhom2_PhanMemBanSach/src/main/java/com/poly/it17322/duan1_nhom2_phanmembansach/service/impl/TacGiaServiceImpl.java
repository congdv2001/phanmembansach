/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TacGia;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.TacGiaRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.TacGiaService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TacGiaServiceImpl implements TacGiaService{

    TacGiaRepository repo = new TacGiaRepository();
    @Override
    public List<TacGia> getAll() {
        return repo.getAll();
    }

    @Override
    public TacGia getOne(String ma) {
        return repo.getOne(ma);
    }

    @Override
    public Boolean add(TacGia tg) {
        return repo.add(tg);
    }
    @Override
    public Boolean update(TacGia tg) {
        return repo.update(tg);
    }

    @Override
    public Boolean delete(TacGia tg) {
       return repo.delete(tg);
    }
    
}
