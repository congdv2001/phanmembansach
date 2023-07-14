package com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Table(name = "Vocher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Voucher implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID Id;

    @Column(unique = true)
    private String ma;

    @Column
    @Nationalized
    private String ten;

    @Column
    private Integer phanTramGiam;

    @Column
    private Date ngayTao;

    @Column
    private Date ngayBD;

    @Column
    private Date ngayKT;

    @Column
    private String moTa;

    @Column
    private Boolean trangThai;

    @OneToMany(mappedBy = "voucher", fetch = FetchType.LAZY)
    private List<HoaDon> hoaDonList;

    @Override
    public String toString() {
        return ten;
    }
}
