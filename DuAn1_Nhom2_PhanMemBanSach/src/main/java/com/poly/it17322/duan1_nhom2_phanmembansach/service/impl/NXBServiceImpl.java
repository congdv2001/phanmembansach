/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.NXB;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.NxbRepository;

import com.poly.it17322.duan1_nhom2_phanmembansach.service.NXBService;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class NXBServiceImpl implements NXBService{

    NxbRepository nxbRepo  =new NxbRepository();
    
    @Override
    public List<NXB> getAll() {
      return nxbRepo.getAll();
    }

    @Override
    public NXB getOne(String ma) {
       return nxbRepo.getOne(ma);
    }

    @Override
    public Boolean add(NXB nxb) {
       return nxbRepo.add(nxb);
    }

    @Override
    public Boolean update(NXB nxb) {
        return nxbRepo.update(nxb);
    }

    @Override
    public Boolean delete(NXB nxb) {
       return nxbRepo.delete(nxb);
    }
    
}
