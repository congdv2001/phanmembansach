package com.poly.it17322.duan1_nhom2_phanmembansach.service;

import com.poly.it17322.duan1_nhom2_phanmembansach.response.LogInReponse;
import java.util.List;

public interface LogInService {

    public List<LogInReponse> getAll();

    public List<LogInReponse> getOne(Long id);
}
