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
@Table(name="ChiTiet_Sach")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSach implements Serializable {

   @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTacGia", referencedColumnName = "id")
    private TacGia tacGia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTheLoai", referencedColumnName = "id")
    private TheLoai theLoai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idNXB", referencedColumnName = "id")
    private NXB nxb;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idSach", referencedColumnName = "id")
    private Sach sach;

    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "donGia")
    private BigDecimal donGia;

    @Column(name = "moTa")
    private String moTa;

    @Column(name = "hinhAnh")
    private String hinhAnh;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayTao")
    private Date ngayTao;

    @Temporal(TemporalType.DATE)
    @Column(name = "ngayCapNhat")
    private Date ngayCapNhat;

    @Column(name = "nguoiTao")
    private String nguoiTao;

    @Column(name = "nguoiCapNhat")
    private String nguoiCapNhat;

    @OneToMany(mappedBy = "chiTietSach", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> hoaDonChiTietList;
}
