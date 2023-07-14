
package com.poly.it17322.duan1_nhom2_phanmembansach.response;

import java.math.BigDecimal;
import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewThongKeNgay {
    private int thang;
    private Date ngayTao;
    private BigDecimal doanhThu;
    private Long soHD;

    public ViewThongKeNgay() {
    }

    public ViewThongKeNgay(Date ngayTao, BigDecimal doanhThu, Long soHD) {
        this.ngayTao = ngayTao;
        this.doanhThu = doanhThu;
        this.soHD = soHD;
    }

    public ViewThongKeNgay(BigDecimal doanhThu, Long soHD) {
        this.doanhThu = doanhThu;
        this.soHD = soHD;
    }

    public ViewThongKeNgay(int thang, BigDecimal doanhThu, Long soHD) {
        this.thang = thang;
        this.doanhThu = doanhThu;
        this.soHD = soHD;
    }
    
    
}
