package com.poly.it17322.duan1_nhom2_phanmembansach.service.impl;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import com.poly.it17322.duan1_nhom2_phanmembansach.repository.LogInRepository;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.LogInReponse;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.LogInService;
import java.util.ArrayList;
import java.util.List;

public class LogInServiceImpl implements LogInService {

    private LogInRepository reponsitory = new LogInRepository();

    @Override
    public List<LogInReponse> getAll() {
        List<LogInReponse> reponse = new ArrayList<>();
        List<Users> list = reponsitory.getAll();

        for (Users p : list) {
            LogInReponse logInReponse = new LogInReponse(p);
            reponse.add(logInReponse);
        }
        return reponse;
    }

    @Override
    public List<LogInReponse> getOne(Long id) {
        List<LogInReponse> reponse = new ArrayList<>();
        List<Users> list = (List<Users>) reponsitory.getOne(id);
        for (Users p : list) {
            LogInReponse logInReponse = new LogInReponse(p);
            reponse.add(logInReponse);
        }
        return reponse;
    }

    public static void main(String[] args) {

        List<LogInReponse> list = new LogInServiceImpl().getAll();
        for (LogInReponse i : list) {
            System.out.println(i.toString());
        }
    }
}
