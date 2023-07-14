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
@Table(name = "Sach")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Sach implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID Id;
    
     @Column(name = "ma")
    private String ma;
    
    @Column(name = "tenSach")
    private String tenSach;
    
    @Column(name = "tinhTrang")
    private Integer tinhTrang;
    
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
}
