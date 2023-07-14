package com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="KhuyenMai")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KhuyenMai implements Serializable {

     @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID Id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "tenKhuyenMai")
    private String tenKhuyenMai;

    @Column(name = "mucGiamGia")
    private Integer mucGiamGia;

    @Temporal(TemporalType.DATE)
    @Column(name = "thoiGianBatDau")
    private Date thoiGianBatDau;

    @Temporal(TemporalType.DATE)
    @Column(name = "thoiGianKetThuc")
    private Date thoiGianKetThuc;

    @Column(name = "trangThai")
    private Integer trangThai;

}
