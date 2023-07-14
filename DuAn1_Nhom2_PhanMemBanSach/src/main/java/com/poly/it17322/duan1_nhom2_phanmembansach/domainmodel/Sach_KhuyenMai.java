package com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Sach_KhuyenMai")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sach_KhuyenMai implements Serializable {

   @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID Id;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idChiTiet_Sach",referencedColumnName = "id" )
    private ChiTietSach chiTietSach;
    
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "idKhuyenMai",referencedColumnName = "id" )
    private KhuyenMai khuyenMai;
    
    @Column(name = "donGia")
    private BigDecimal donGia;
    
    @Column(name = "soTienConLai")
    private BigDecimal soTienConLai;
    
    @Column(name = "trangThai")
    private Integer trangThai;
}
