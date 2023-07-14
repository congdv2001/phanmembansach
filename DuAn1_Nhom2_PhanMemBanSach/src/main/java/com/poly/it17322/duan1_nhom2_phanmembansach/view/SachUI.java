/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.poly.it17322.duan1_nhom2_phanmembansach.view;

import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChiTietSach;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.NXB;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Sach;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TacGia;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.TheLoai;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.QLCTSach;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.ChiTietSachService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.NXBService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.SachService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.TacGiaService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.TheloaiService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.ChiTietSachServiceImpl;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.NXBServiceImpl;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.SachServiceImpl;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.TacGiaServiceImpl;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.TheLoaiServiceImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class SachUI extends javax.swing.JPanel {

    /**
     * Creates new form SachUI
     */
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel combo = new DefaultComboBoxModel();
    private ChiTietSachService ctsService = new ChiTietSachServiceImpl();
    private NXBService nxbService = new NXBServiceImpl();
    private TacGiaService tgService = new TacGiaServiceImpl();
    private TheloaiService tlService = new TheLoaiServiceImpl();
    private SachService sachService = new SachServiceImpl();

    public SachUI() {
        initComponents();
        loadData(ctsService.getListQLCTSach());
        loadCBO_NXB(nxbService.getAll());
        loadCBO_TacGia(tgService.getAll());
        loadCBO_TheLoai(tlService.getAll());
        loadCBO_Sach(sachService.getAll());
    }

    public void loadData(List<QLCTSach> list) {
        defaultTableModel = (DefaultTableModel) tblCTS.getModel();
        defaultTableModel.setRowCount(0);
        for (QLCTSach s : list) {
            defaultTableModel.addRow(new Object[]{
                s.getSach(),
                s.getTacGia(),
                s.getNxb(),
                s.getGiaBan(),
                s.getSoLuongTon(),
                s.getTheLoai(),
                s.getMoTa()
            });
        }
    }

    public void loadCBO_NXB(List<NXB> list) {
        combo = (DefaultComboBoxModel) cboNXB.getModel();
        combo.removeAllElements();

        for (NXB nxb : list) {
            combo.addElement(nxb.getTenNXB());
        }
    }

    public void loadCBO_TheLoai(List<TheLoai> list) {
        combo = (DefaultComboBoxModel) cboTheLoai.getModel();
        combo.removeAllElements();

        for (TheLoai tl : list) {
            combo.addElement(tl.getTenTL());
        }
    }

    public void loadCBO_TacGia(List<TacGia> list) {
        combo = (DefaultComboBoxModel) cboTacGia.getModel();
        combo.removeAllElements();

        for (TacGia tg : list) {
            combo.addElement(tg.getTenTG());
        }
    }

    public void loadCBO_Sach(List<Sach> list) {
        combo = (DefaultComboBoxModel) cboSach.getModel();
        combo.removeAllElements();

        for (Sach s : list) {
            combo.addElement(s.getTenSach());
        }
    }

    public ChiTietSach getData() {

        int row = tblCTS.getSelectedRow();
        ChiTietSach cts = ctsService.getList().get(row);

        NXB nxb = nxbService.getAll().get(cboNXB.getSelectedIndex());
        cts.setNxb(nxb);

        TacGia tg = tgService.getAll().get(cboTacGia.getSelectedIndex());
        cts.setTacGia(tg);

        TheLoai tl = tlService.getAll().get(cboTheLoai.getSelectedIndex());
        cts.setTheLoai(tl);

        Sach s = sachService.getAll().get(cboSach.getSelectedIndex());
        cts.setSach(s);

        cts.setDonGia(new BigDecimal(txtGia.getText()));
        cts.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
        cts.setMoTa(txaMoTa.getText());

        return cts;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnTheLoai = new javax.swing.JButton();
        cboNXB = new javax.swing.JComboBox<>();
        tbnThem = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboTacGia = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaMoTa = new javax.swing.JTextArea();
        btnNhap = new javax.swing.JButton();
        cboTheLoai = new javax.swing.JComboBox<>();
        cboSach = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        btnSach = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCTS = new javax.swing.JTable();
        btnNXB = new javax.swing.JButton();
        btnTacGia = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();

        setBackground(new java.awt.Color(153, 255, 153));

        jLabel3.setText("Sách");

        jLabel4.setText("Giá");

        jLabel5.setText("Nhà xuất bản");

        btnXoa.setBackground(new java.awt.Color(204, 102, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel6.setText("Tác giả");

        jLabel9.setText("Mô tả");

        btnTheLoai.setText("+");
        btnTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheLoaiActionPerformed(evt);
            }
        });

        cboNXB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbnThem.setBackground(new java.awt.Color(204, 102, 0));
        tbnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tbnThem.setForeground(new java.awt.Color(255, 255, 255));
        tbnThem.setText("Thêm");
        tbnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnThemActionPerformed(evt);
            }
        });

        jLabel10.setText("Số lượng");

        jLabel7.setText("Thể loại");

        cboTacGia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSua.setBackground(new java.awt.Color(204, 102, 0));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        txaMoTa.setColumns(20);
        txaMoTa.setRows(5);
        jScrollPane1.setViewportView(txaMoTa);

        btnNhap.setBackground(new java.awt.Color(204, 102, 0));
        btnNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhap.setForeground(new java.awt.Color(255, 255, 255));
        btnNhap.setText("importExcel");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        cboTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSach.setText("+");
        btnSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSachActionPerformed(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(700, 400));

        tblCTS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sách", "Tác giả", "Nhà xuất bản", "Giá", "Số lượng", "Thể loại", "Mô tả"
            }
        ));
        tblCTS.setPreferredSize(new java.awt.Dimension(700, 400));
        tblCTS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCTS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        btnNXB.setText("+");
        btnNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNXBActionPerformed(evt);
            }
        });

        btnTacGia.setText("+");
        btnTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTacGiaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 70));

        jLabel2.setText("Tìm kiếm");

        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(txtTim)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cboTacGia, javax.swing.GroupLayout.Alignment.LEADING, 0, 102, Short.MAX_VALUE)
                            .addComponent(cboNXB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboTheLoai, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboSach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnTacGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNXB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(185, 185, 185)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(tbnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(btnNhap)
                        .addGap(83, 286, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(cboSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSach)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cboNXB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNXB))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(cboTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTacGia))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTheLoai)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnNhap))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        ChiTietSach cts = getData();

        if (ctsService.xoa(cts)) {
            JOptionPane.showMessageDialog(this, "Xóa thành công");
            loadData(ctsService.getListQLCTSach());
        } else {
            JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTheLoaiActionPerformed
        // TODO add your handling code here:
        addTheLoai dialog = new addTheLoai(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        loadCBO_TheLoai(tlService.getAll());

    }//GEN-LAST:event_btnTheLoaiActionPerformed

    private void tbnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnThemActionPerformed
        // TODO add your handling code here:
        ChiTietSach cts = new ChiTietSach();

        NXB nxb = nxbService.getAll().get(cboNXB.getSelectedIndex());
        cts.setNxb(nxb);

        TacGia tg = tgService.getAll().get(cboTacGia.getSelectedIndex());
        cts.setTacGia(tg);

        TheLoai tl = tlService.getAll().get(cboTheLoai.getSelectedIndex());
        cts.setTheLoai(tl);

        Sach s = sachService.getAll().get(cboSach.getSelectedIndex());
        cts.setSach(s);

        cts.setDonGia(new BigDecimal(txtGia.getText()));
        cts.setSoLuongTon(Integer.parseInt(txtSoLuong.getText()));
        cts.setMoTa(txaMoTa.getText());

        if (ctsService.them(cts)) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadData(ctsService.getListQLCTSach());
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }
    }//GEN-LAST:event_tbnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        ChiTietSach cts = getData();

        if (ctsService.sua(cts)) {
            JOptionPane.showMessageDialog(this, "sua thanh cong");
            loadData(ctsService.getListQLCTSach());
        } else {
            JOptionPane.showMessageDialog(this, "sua that bai");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        // TODO add your handling code here:
        File excelF;
        FileInputStream excelFis = null;
        BufferedInputStream excelBis = null;
        XSSFWorkbook excelJTableImport = null;
        String file = "D:\\tam";
        JFileChooser excelFile = new JFileChooser(file);
        FileNameExtensionFilter fileName = new FileNameExtensionFilter("Excel file (.xlsx)", "xlsx");
        excelFile.setFileFilter(fileName);
        excelFile.setDialogTitle("Thêm file excel");
        int excel = excelFile.showOpenDialog(null);

        if (excel == JFileChooser.APPROVE_OPTION) {
            try {
                excelF = excelFile.getSelectedFile();
                excelFis = new FileInputStream(excelF);
                excelBis = new BufferedInputStream(excelFis);
                excelJTableImport = new XSSFWorkbook(excelBis);
                XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);

                for (int row = 1; row < excelSheet.getLastRowNum() + 1; row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    XSSFCell sach = excelRow.getCell(0);
                    XSSFCell tacGia = excelRow.getCell(1);
                    XSSFCell nxb = excelRow.getCell(2);
                    XSSFCell gia = excelRow.getCell(3);
                    XSSFCell soLuong = excelRow.getCell(4);
                    XSSFCell theLoai = excelRow.getCell(5);
                    XSSFCell moTa = excelRow.getCell(6);

                    defaultTableModel.addRow(new Object[]{sach, tacGia, nxb, gia, soLuong, theLoai, moTa});
                }
                JOptionPane.showMessageDialog(this, "import thành công!");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } finally {
                try {
                    if (excelFis != null) {
                        excelFis.close();
                    }
                    if (excelBis != null) {
                        excelBis.close();
                    }
                    if (excelJTableImport != null) {
                        excelJTableImport.close();
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }

        }
    }//GEN-LAST:event_btnNhapActionPerformed

    private void btnSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSachActionPerformed
        // TODO add your handling code here:
        addSach dialog = new addSach(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        loadCBO_Sach(sachService.getAll());
    }//GEN-LAST:event_btnSachActionPerformed

    private void tblCTSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTSMouseClicked
        // TODO add your handling code here:
        int row = tblCTS.getSelectedRow();
        ChiTietSach chiTietSP = ctsService.getList().get(row);
        cboSach.setSelectedItem(tblCTS.getValueAt(row, 0));
        cboNXB.setSelectedItem(tblCTS.getValueAt(row, 2));
        cboTacGia.setSelectedItem(tblCTS.getValueAt(row, 1));
        cboTheLoai.setSelectedItem(tblCTS.getValueAt(row, 5));
        txaMoTa.setText(tblCTS.getValueAt(row, 6).toString());
        txtSoLuong.setText(tblCTS.getValueAt(row, 4).toString());
        txtGia.setText(tblCTS.getValueAt(row, 3).toString());
    }//GEN-LAST:event_tblCTSMouseClicked

    private void btnNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNXBActionPerformed
        // TODO add your handling code here:
        addNXB dialog = new addNXB(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        loadCBO_NXB(nxbService.getAll());

    }//GEN-LAST:event_btnNXBActionPerformed

    private void btnTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTacGiaActionPerformed
        // TODO add your handling code here:
        addTacGia dialog = new addTacGia(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        loadCBO_TacGia(tgService.getAll());

    }//GEN-LAST:event_btnTacGiaActionPerformed

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        // TODO add your handling code here:
        String timSach = txtTim.getText();
        List<ChiTietSach> list = ctsService.timKiem(timSach);
        loadData(ctsService.getListQLCTSach());
    }//GEN-LAST:event_txtTimCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNXB;
    private javax.swing.JButton btnNhap;
    private javax.swing.JButton btnSach;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTacGia;
    private javax.swing.JButton btnTheLoai;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboNXB;
    private javax.swing.JComboBox<String> cboSach;
    private javax.swing.JComboBox<String> cboTacGia;
    private javax.swing.JComboBox<String> cboTheLoai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblCTS;
    private javax.swing.JButton tbnThem;
    private javax.swing.JTextArea txaMoTa;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
