package com.poly.it17322.duan1_nhom2_phanmembansach.response;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ViewThongKe {

    private Long soDH;
    private BigDecimal doanhThu;

    public ViewThongKe() {
    }

    public ViewThongKe(Long soDH, BigDecimal doanhThu) {
        this.soDH = soDH;
        this.doanhThu = doanhThu;
    }
    
    
}
