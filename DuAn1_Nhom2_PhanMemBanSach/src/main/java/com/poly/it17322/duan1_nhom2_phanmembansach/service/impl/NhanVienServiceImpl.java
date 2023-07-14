/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.NhanVienRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.NhanvienResponse;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.NhanVienService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author 84865
 */
public class NhanVienServiceImpl implements NhanVienService {

    private NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public List<Users> getAll() {
        return this.nhanVienRepository.getAll();
    }

    @Override
    public Users getUserByMa(String ma) {
        return this.nhanVienRepository.getUserByMa(ma);
    }

    @Override
    public Users getOne(Long id) {
        return this.nhanVienRepository.getOne(id);
    }

    @Override
    public Boolean add(Users users) {
        return this.nhanVienRepository.add(users);
    }

    @Override
    public Boolean update(Users users) {
        return this.nhanVienRepository.update(users);
    }

    @Override
    public List<NhanvienResponse> getAllViewTable() {
         List<NhanvienResponse> reponse = new ArrayList<>();
        List<Users> list = nhanVienRepository.getAll();
        
        for (Users p : list) {
            NhanvienResponse viewNhanVien = new NhanvienResponse(p);
            reponse.add(viewNhanVien);
        }
        return reponse;  
    }
    
    public static void main(String[] args) {
        List<NhanvienResponse> list = new NhanVienServiceImpl().getAllViewTable();
        for (NhanvienResponse x : list) {
            System.out.println(x.toString());
            
        }
        
    }

}
