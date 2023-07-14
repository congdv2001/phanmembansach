/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChucVu;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.ChucVuRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.ChucVuService;
import java.util.List;

/**
 *
 * @author 84865
 */
public class ChucVuServiceImpl implements ChucVuService {

    ChucVuRepository cvRepo = new ChucVuRepository();
    
    @Override
    public List<ChucVu> getAll() {
        return cvRepo.getAll();
    }
    
   
    
}
