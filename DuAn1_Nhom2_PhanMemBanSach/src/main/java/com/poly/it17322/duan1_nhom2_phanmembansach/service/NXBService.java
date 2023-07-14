/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.NXB;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface NXBService {
     List<NXB>getAll();
    
     NXB getOne(String ma);
    
     Boolean add(NXB nxb);
    
     Boolean update(NXB nxb);
     
     Boolean delete(NXB nxb);
             
             
     
}
