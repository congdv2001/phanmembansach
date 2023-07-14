/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.NhanvienResponse;
import java.util.List;

/**
 *
 * @author 84865
 */
public interface NhanVienService {
    
     public List<Users> getAll();
    
    Users getUserByMa(String ma);

    public Users getOne(Long id);

    public List<NhanvienResponse> getAllViewTable();

    public Boolean add(Users users);

    public Boolean update(Users users);
    
}
