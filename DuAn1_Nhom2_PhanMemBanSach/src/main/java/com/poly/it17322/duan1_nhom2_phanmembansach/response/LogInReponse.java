
package com.poly.it17322.duan1_nhom2_phanmembansach.response;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInReponse {
    
    private String ma;
    private String matKhau;
    private String chucVu;
    private String tenNV;

    public LogInReponse() {
    }

    public LogInReponse(Users users) {
        this.ma = users.getMa();
        this.matKhau = users.getMatKhau();
        this.chucVu = users.getChucVu().getTenCV();
        this.tenNV = users.getTen();
    }

}
