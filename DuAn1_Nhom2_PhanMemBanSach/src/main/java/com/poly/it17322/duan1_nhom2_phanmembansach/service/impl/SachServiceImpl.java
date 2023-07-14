/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Sach;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.SachReponsitory;

import com.poly.it17322.duan1_nhom2_phanmembansach.service.SachService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SachServiceImpl implements SachService {

    private SachReponsitory reponsitory = new SachReponsitory();

    @Override
    public List<Sach> getAll() {
        return reponsitory.getAll();
    }

    @Override
    public Sach getOne(String ma) {
        return reponsitory.getOne(ma);
    }

    @Override
    public Boolean add(Sach sach) {
        return reponsitory.add(sach);
    }

    @Override
    public Boolean update(Sach sach) {
        return reponsitory.update(sach);
    }

}
