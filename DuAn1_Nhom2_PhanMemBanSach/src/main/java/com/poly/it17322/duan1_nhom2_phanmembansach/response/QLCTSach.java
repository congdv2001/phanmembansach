package com.poly.it17322.duan1_nhom2_phanmembansach.response;


import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor


public class QLCTSach {
    private String Sach;
    private String nxb;
    private String theLoai;
    private String tacGia;
    private Integer soLuongTon;
    private BigDecimal giaBan;
    private String moTa;
  
}
