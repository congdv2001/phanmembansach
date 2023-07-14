/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TheLoai;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.TheLoaiReponsitory;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.TheloaiService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class TheLoaiServiceImpl implements TheloaiService{

    TheLoaiReponsitory repo = new TheLoaiReponsitory();
    @Override
    public List<TheLoai> getAll() {
       return repo.getAll();
    }

    @Override
    public TheLoai getOne(String ma) {
        return repo.getOne(ma);
    }

    @Override
    public Boolean add(TheLoai tl) {
        return repo.add(tl);
    }

    @Override
    public Boolean update(TheLoai tl) {
        return repo.update(tl);
    }

    @Override
    public Boolean delete(TheLoai tl) {
       return repo.delete(tl);
    }
    
}
