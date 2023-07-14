package com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="HoaDon")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon implements Serializable{

   @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID Id;
    
     @Column(name = "ma")
    private String ma;

    @Column(name = "tenKH")
    private String tenKH;
    
    @ManyToOne
    @JoinColumn(name = "idVC")
    private Voucher voucher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idKhachHang", referencedColumnName = "id")
    private KhachHang khachHang;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private Users users;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayTao")
    private Date ngayTao;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayThanhToan")
    private Date ngayThanhToan;
    
    @Column(name = "tinhTrang")
    private Integer tinhTrang;

    @Column(name = "tongTien")
    private BigDecimal tongTien;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayCapNhat")
    private Date ngayCapNhat;

    @Column(name = "nguoiTao")
    private String nguoiTao;

    @Column(name = "nguoiCapNhat")
    private String nguoiCapNhat;
    
    @OneToMany(mappedBy = "hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTietList;
}
