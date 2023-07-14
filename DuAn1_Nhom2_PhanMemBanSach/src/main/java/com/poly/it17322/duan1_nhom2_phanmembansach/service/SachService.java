/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Sach;
import java.util.List;

/**
 *
 * @author Administrator
 */
public interface SachService {
     List<Sach>getAll();
    
     Sach getOne(String ma);
    
     Boolean add(Sach sach);
    
     Boolean update(Sach sach);
}
