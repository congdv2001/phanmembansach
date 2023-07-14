package com.poly.it17322.duan1_nhom2_phanmembansach.view;

import com.poly.it17322.duan1_nhom2_phanmembansach.config.InHoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.ChiTietSach;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDon;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.HoaDonChiTiet;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.KhachHang;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.ChiTietSachService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.HoaDonChiTietService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.HoaDonService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.KhachHangService;
import com.poly.it17322.duan1_nhom2_phanmembansach.domainmodel.Voucher;
import com.poly.it17322.duan1_nhom2_phanmembansach.response.KhachHangI;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.VCService;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.ChiTietSachServiceImpl;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.HoaDonChiTietServiceImpl;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.HoaDonServiceImpl;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.KhachHangServiceImpl;
import com.poly.it17322.duan1_nhom2_phanmembansach.service.impl.VCServiceImpl;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class BanHangUI extends javax.swing.JPanel {

//    private static final long serialVersionUID = 6441489157408381878L;
//    private Executor executor = Executors.newSingleThreadExecutor(this);
//    private Webcam webcam = null;
//    private WebcamPanel panel = null;
//    private JTextArea textarea = null;
    private HoaDonService hoaDonService = new HoaDonServiceImpl();
    private HoaDonChiTietService hdctService = new HoaDonChiTietServiceImpl();
    private ChiTietSachService chiTietSachService = new ChiTietSachServiceImpl();
    private DefaultTableModel defaultTableModel = new DefaultTableModel();
    private DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel();
    private KhachHangService khachHangService = (KhachHangService) new KhachHangServiceImpl();
    private VCService vcService = new VCServiceImpl();
    private KhachHangI khs = new KhachHangI();
    List<HoaDonChiTiet> list = new ArrayList<>();
    DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Locale locale = new Locale("vi", "VN");
    NumberFormat formatter = NumberFormat.getInstance(locale);

    public BanHangUI() {
        initComponents();
        loadTableHD(hoaDonService.getList());
        loadTableHDCT(hdctService.getList());
        loadTableSach(chiTietSachService.getList());
        if (tblHoaDon.getRowCount() > 0) {
            tblHoaDon.setRowSelectionInterval(0, 0);
        } 
        showDeltai();
        loadCBOHD();
        loadCBXKH(khachHangService.getList());
        loadCBOVC(vcService.getList());
    }

    public void loadTableSach(List<ChiTietSach> list) {
        defaultTableModel = (DefaultTableModel) tblSach.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (ChiTietSach cts : list) {
            defaultTableModel.addRow(new Object[]{
                stt++,
                cts.getSach().getMa(),
                cts.getSach().getTenSach(),
                cts.getSoLuongTon(),
                cts.getDonGia(),
                cts.getMoTa()
            });
        }
    }

    public void loadTableHDCT(List<HoaDonChiTiet> list) {
        defaultTableModel = (DefaultTableModel) tblCTHD.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (HoaDonChiTiet hdct : list) {
            defaultTableModel.addRow(new Object[]{
                stt++,
                hdct.getChiTietSach().getSach().getMa(),
                hdct.getChiTietSach().getSach().getTenSach(),
                hdct.getSoLuong(),
                hdct.getDonGia(),
                hdct.thanhTien()
            });
        }
    }

    public void loadTableHD(List<HoaDon> list) {
        defaultTableModel = (DefaultTableModel) tblHoaDon.getModel();
        defaultTableModel.setRowCount(0);
        int stt = 1;
        for (HoaDon hd : list) {
            defaultTableModel.addRow(new Object[]{
                stt++,
                hd.getMa(),
                hd.getNgayTao(),
                "Đoàn Văn Công",
                //                hd.getUsers().getTen(),
                hd.getTinhTrang() == 0 ? "Chờ thanh toán" : "Đã thanh toán"
            });
        }
    }

    public String genMaHD() {
        for (int i = 0; i < hoaDonService.getList().size() + 1; i++) {
            String ma = "HD" + i;
            if (hoaDonService.getHDByMa(ma) == null) {
                return ma;
            }
        }
        return null;
    }

    public Boolean checkTT() {
        int row = tblHoaDon.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng click lại hóa đơn");
            return false;
        }
        HoaDon hoaDon = hoaDonService.getList().get(row);
        if (hoaDon.getTinhTrang() == 1) {
            JOptionPane.showMessageDialog(this, "Hóa đơn đã thanh toám");
            return false;
        }
        return true;
    }

    public Double tongTien() {
        double tong = 0.0;
        for (int i = 0; i < tblCTHD.getRowCount(); i++) {
            tong += Float.parseFloat(tblCTHD.getValueAt(i, 5).toString());
        }
        return tong;
    }

    private void addToGioHang() {

        if (txtMaHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn trước");
        } else {
            HoaDon hoaDon = hoaDonService.getHDByMa(txtMaHD.getText());
            if (checkTT()) {
                int rowSP = tblSach.getSelectedRow();
                ChiTietSach ctsp = chiTietSachService.getList().get(rowSP);
                if (ctsp.getSoLuongTon() == 0) {
                    JOptionPane.showMessageDialog(this, "Hết hàng");
                    return;
                } else {
                    String input = JOptionPane.showInputDialog("Nhập số lượng sản phẩm: ");
                    try {
                        Integer.parseInt(input);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Nhập lại số lượng");
                        return;
                    }
                    if (Integer.parseInt(input) > ctsp.getSoLuongTon()) {
                        JOptionPane.showMessageDialog(this, "Không đủ, số lượng còn lại: " + ctsp.getSoLuongTon());
                        return;
                    }
                    if (Integer.parseInt(input) <= 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng nhập vào phải lớn hơn 0");
                        return;
                    } else {
                        if (hdctService.getCTHD(hoaDon.getId(), ctsp.getId()) == null) {
                            HoaDonChiTiet cthd = new HoaDonChiTiet();
                            cthd.setHoaDon(hoaDonService.getHDByMa(txtMaHD.getText()));
                            cthd.setChiTietSach(chiTietSachService.getList().get(rowSP));

                            cthd.setSoLuong(Integer.parseInt(input));
                            cthd.setDonGia(new BigDecimal(tblSach.getValueAt(rowSP, 4).toString()));

                            hdctService.them(cthd);
                        } else {
                            HoaDonChiTiet cthd = hdctService.getCTHD(hoaDon.getId(), ctsp.getId());
                            cthd.setSoLuong(cthd.getSoLuong() + Integer.parseInt(input));
                            hdctService.sua(cthd);
                        }

                        loadTableHDCT(hdctService.getCTHDByMaHD(txtMaHD.getText()));
                        txtTongTien.setText(tongTien().toString());
                        ctsp.setSoLuongTon(ctsp.getSoLuongTon() - Integer.parseInt(input));
                        chiTietSachService.sua(ctsp);
                    }
                }
            }

        }
        loadTableSach(chiTietSachService.timKiem(txtTim.getText()));
        txtTongTien.setText(tongTien().toString());
    }

    public void loadCBOHD() {
        defaultComboBoxModel = (DefaultComboBoxModel) cboHD.getModel();
        defaultComboBoxModel.removeAllElements();
        List<String> listTT = new ArrayList<>();
        listTT.add("Tất cả");
        listTT.add("Chưa thanh toán");
        listTT.add("Đã thanh toán");

        for (String s : listTT) {
            defaultComboBoxModel.addElement(s);
        }
    }

    public void loadCBXKH(List<KhachHang> list) {
        defaultComboBoxModel = (DefaultComboBoxModel) cboKH.getModel();
        defaultComboBoxModel.removeAllElements();
        defaultComboBoxModel.addElement("khách lẻ");
        for (KhachHang kh : list) {
            defaultComboBoxModel.addElement(kh.getTen());
        }
    }

    public void loadCBOVC(List<Voucher> list) {
        defaultComboBoxModel = (DefaultComboBoxModel) cboVC.getModel();
        defaultComboBoxModel.removeAllElements();

        for (Voucher vc : list) {
            defaultComboBoxModel.addElement(vc.getTen());
        }
    }

    public List<HoaDon> locHD() {
        List<HoaDon> list;
        int index = cboHD.getSelectedIndex();
        if (index == 0) {
            list = hoaDonService.getList();
        } else if (index == 1) {
            list = hoaDonService.locTT(0);
        } else {
            list = hoaDonService.locTT(1);
        }
        return list;
    }

    public Boolean checkForm() {
        if (txtMaHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn");
            return false;
        }
        if (txtTienNhan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập tiền khách thanh toán");
            return false;
        }

        if (Float.parseFloat(txtTongTien.getText()) <= 0) {
            JOptionPane.showMessageDialog(this, "Hóa đơn trống");
            return false;
        }

        try {
            Integer.parseInt(txtTienNhan.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập lại");
            txtTienNhan.setText("");
            return false;
        }

        if ((khachTT() - thanhTien()) < 0) {
            String tienThieu = formatter.format(thanhTien() - khachTT()) + " VNĐ";
            System.out.println(thanhTien());
            System.out.println(khachTT());
            JOptionPane.showMessageDialog(this, "Chưa dủ tiền thanh toán, còn thiếu: " + tienThieu);
            return false;
        } else {
            JOptionPane.showMessageDialog(this, "Tiền thừa: " + formatter.format(Math.abs(thanhTien() - khachTT())) + "VNĐ");
        }

        return true;
    }

    public void clearFrom() {
        txtMaHD.setText("");
        cboKH.setSelectedIndex(0);
        cboVC.setSelectedIndex(0);
        txtTongTien.setText("");
        txtTongTien.setText("");
        txtTienNhan.setText("");
        txtTienThua.setText("");
        txtNgayTao.setText("");
        txtTenNV.setText("");

    }

    public void showDeltai() {
        int row = tblHoaDon.getSelectedRow();
        HoaDon hd = hoaDonService.getList().get(row);
        txtMaHD.setText(tblHoaDon.getValueAt(row, 1).toString());
//        if (hd.getTinhTrang() == 0) {
//            cboVC.setSelectedIndex(0);
//        } else {
//            cboVC.setSelectedItem(hd.getVoucher().getPhanTramGiam());
//        }
        txtNgayTao.setText(tblHoaDon.getValueAt(row, 2).toString());
        txtTenNV.setText(tblHoaDon.getValueAt(row, 3).toString());
        loadTableHDCT(hdctService.getCTHDByMaHD(txtMaHD.getText()));
        txtTongTien.setText(formatter.format(tongTien()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        insertKH = new javax.swing.JDialog();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        txtTimSDT = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAddKH = new javax.swing.JButton();
        txtSDT = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        cboHD = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        btnXoaAll = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienNhan = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        btnKhachHang = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        cboKH = new javax.swing.JComboBox<>();
        txtTienThua = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cboVC = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        txtGiam = new javax.swing.JTextField();

        insertKH.setMinimumSize(new java.awt.Dimension(400, 300));

        jPanel9.setMinimumSize(new java.awt.Dimension(427, 500));

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã", "Tên", "SDT", "CCCD"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblKhachHang);

        txtTimSDT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimSDTCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 305, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thông tin khách hàng", jPanel6);

        jLabel4.setText("Tên");

        jLabel10.setText("SDT");

        btnAddKH.setText("Thêm");
        btnAddKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(btnAddKH)
                        .addGap(178, 178, 178))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(33, 33, 33)
                .addComponent(btnAddKH)
                .addGap(99, 99, 99))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Thêm khách hàng", jPanel7);

        javax.swing.GroupLayout insertKHLayout = new javax.swing.GroupLayout(insertKH.getContentPane());
        insertKH.getContentPane().setLayout(insertKHLayout);
        insertKHLayout.setHorizontalGroup(
            insertKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        insertKHLayout.setVerticalGroup(
            insertKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        setBackground(new java.awt.Color(153, 255, 153));
        setAutoscrolls(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin sản phẩm"));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 250));

        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Số lượng", "Đơn giá", "Mô tả"
            }
        ));
        tblSach.setPreferredSize(new java.awt.Dimension(400, 250));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSach);

        jLabel1.setText("Tìm kiếm");

        txtTim.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTim)
                .addGap(384, 384, 384))
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa đơn"));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 250));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Ngày tạo", "Nhân Viên", "Tình trạng"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHoaDon);

        btnTaoHoaDon.setBackground(new java.awt.Color(204, 102, 0));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        cboHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboHD.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHDItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnTaoHoaDon)
                        .addGap(37, 37, 37)
                        .addComponent(cboHD, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 250));

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        tblCTHD.setPreferredSize(new java.awt.Dimension(400, 250));
        tblCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTHD);

        btnXoaAll.setBackground(new java.awt.Color(204, 102, 0));
        btnXoaAll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaAll.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaAll.setText("Xóa tất cả");
        btnXoaAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnXoaAll)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaAll)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin hóa đơn"));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 800));

        jLabel2.setText("Mã HĐ");

        jLabel3.setText("Ngày tạo");

        jLabel5.setText("Tiền khách đưa");

        jLabel6.setText("Tổng tiền");

        jLabel7.setText("Tiền thừa");

        txtTongTien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTongTienCaretUpdate(evt);
            }
        });

        txtTienNhan.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienNhanCaretUpdate(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(204, 102, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel8.setText("Tên nhân viên");

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Khách hàng"));

        btnKhachHang.setText("+");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        jLabel16.setText("Khách hàng");

        cboKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel16)
                .addGap(37, 37, 37)
                .addComponent(cboKH, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(btnKhachHang)
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachHang)
                    .addComponent(cboKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        txtTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThuaActionPerformed(evt);
            }
        });

        jLabel9.setText("Thành tiền");

        txtThanhTien.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtThanhTienCaretUpdate(evt);
            }
        });

        jLabel11.setText("Giảm %");

        cboVC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboVC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboVCItemStateChanged(evt);
            }
        });
        cboVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboVCActionPerformed(evt);
            }
        });

        jLabel12.setText("Voucher");

        txtGiam.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtGiamCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(btnThanhToan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtTienNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(cboVC, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiam))
                .addGap(65, 65, 65))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboVC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(btnThanhToan)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        if (txtMaHD.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Chọn hóa đơn trước");
            return;
        } else {
            HoaDon hoaDon = hoaDonService.getHDByMa(txtMaHD.getText());
            if (checkTT()) {
                int row = tblSach.getSelectedRow();
                ChiTietSach cts = chiTietSachService.getList().get(row);
                if (cts.getSoLuongTon() == 0) {
                    JOptionPane.showMessageDialog(this, "Hết hàng");
                    return;
                } else {
                    String input = JOptionPane.showInputDialog("Nhập số lượng sản phẩm: ");
                    try {
                        Integer.parseInt(input);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Nhập lại số lượng");
                        return;
                    }
                    if (Integer.parseInt(input) > cts.getSoLuongTon()) {
                        JOptionPane.showMessageDialog(this, "Không đủ, số lượng còn lại: " + cts.getSoLuongTon());
                        return;
                    }
                    if (Integer.parseInt(input) <= 0) {
                        JOptionPane.showMessageDialog(this, "Số lượng nhập vào phải lớn hơn 0");
                        return;
                    } else {
                        if (hdctService.getCTHD(hoaDon.getId(), cts.getId()) == null) {
                            HoaDonChiTiet cthd = new HoaDonChiTiet();
                            cthd.setHoaDon(hoaDonService.getHDByMa(txtMaHD.getText()));
                            cthd.setChiTietSach(chiTietSachService.getList().get(row));
                            cthd.setSoLuong(Integer.parseInt(input));
                            cthd.setDonGia(new BigDecimal(tblSach.getValueAt(row, 4).toString()));

                            hdctService.them(cthd);
                        } else {
                            HoaDonChiTiet cthd = hdctService.getCTHD(hoaDon.getId(), cts.getId());
                            cthd.setSoLuong(cthd.getSoLuong() + Integer.parseInt(input));
                            hdctService.sua(cthd);
                        }

                        loadTableHDCT(hdctService.getCTHDByMaHD(txtMaHD.getText()));
                        txtTongTien.setText(tongTien().toString());
                        cts.setSoLuongTon(cts.getSoLuongTon() - Integer.parseInt(input));
                        chiTietSachService.sua(cts);
                    }
                }
            }
        }
        loadTableSach(chiTietSachService.getList());
        txtTongTien.setText(formatter.format(tongTien()));
    }//GEN-LAST:event_tblSachMouseClicked

    private void txtTimCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimCaretUpdate
        String timSach = txtTim.getText();
        List<ChiTietSach> list = chiTietSachService.timKiem(timSach);
        loadTableSach(list);
    }//GEN-LAST:event_txtTimCaretUpdate

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked

        showDeltai();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed

        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa(genMaHD());
        hoaDon.setNgayTao(Date.valueOf(LocalDate.now()));
        hoaDon.setTinhTrang(0);
        KhachHang khachHang = khachHangService.getList().get(1);
        hoaDon.setKhachHang(khachHang);
        Voucher voucher = vcService.getList().get(0);
        hoaDon.setVoucher(voucher);
        hoaDonService.them(hoaDon);
        loadTableHD(hoaDonService.getList());
        JOptionPane.showMessageDialog(this, "Tạo hóa đơn thành công");
        if (tblHoaDon.getRowCount() > 0) {
            tblHoaDon.setRowSelectionInterval(0, 0);
        }
        showDeltai();
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void cboHDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHDItemStateChanged
        // TODO add your handling code here:
        if (cboHD.getSelectedIndex() == 0) {
            loadTableHD(hoaDonService.getList());
        } else if (cboHD.getSelectedIndex() == 1) {
            List<HoaDon> list = hoaDonService.locTT(0);
            loadTableHD(list);
        } else {
            List<HoaDon> list = hoaDonService.locTT(1);
            loadTableHD(list);
        }
    }//GEN-LAST:event_cboHDItemStateChanged

    private void tblCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDMouseClicked

//        addToGioHang();
        int row = tblCTHD.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sách!");
            return;
        }
        String inputString = JOptionPane.showInputDialog("Nhập lại số lượng sản phẩm");
        try {
            Integer.parseInt(inputString);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập lại");
            return;
        }
        Integer intput = Integer.parseInt(inputString);
        if (intput < 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
            return;
        }

        HoaDonChiTiet cthd = hdctService.getCTHDByMaHD(txtMaHD.getText()).get(row);
        if (intput == cthd.getSoLuong()) {
            return;
        }

        ChiTietSach cts = cthd.getChiTietSach();
        if (cts.getSoLuongTon() == 0) {
            JOptionPane.showMessageDialog(this, "Sản phẩm đã hết hàng");
            return;
        }

        int soLuongSach = cthd.getSoLuong();
        if (intput == 0) {
            cts.setSoLuongTon(cts.getSoLuongTon() + soLuongSach);
            //            cts.setSoLuongTon(cts.getSoLuongTon() + intput);
            chiTietSachService.sua(cts);
            hdctService.xoa(cthd);
            //            loadTableHDCT(hdctService.getCTHDByMaHD(txtMaHD.getText()));
        }
        if (intput > 0) {
            if (intput < cthd.getSoLuong()) {
                cts.setSoLuongTon(cts.getSoLuongTon() + (soLuongSach - intput));
            } else {
                cts.setSoLuongTon(cts.getSoLuongTon() - (soLuongSach - intput));
            }
            cthd.setSoLuong(intput);
            hdctService.sua(cthd);
            loadTableHDCT(hdctService.getCTHDByMaHD(txtMaHD.getText()));
            chiTietSachService.sua(cts);

        }
        loadTableHDCT(hdctService.getCTHDByMaHD(txtMaHD.getText()));
        loadTableSach(chiTietSachService.getList());
        txtTongTien.setText(formatter.format(tongTien()));
    }//GEN-LAST:event_tblCTHDMouseClicked

    private void btnXoaAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaAllActionPerformed
        // TODO add your handling code here:
        if (checkTT()) {
            int confirm = JOptionPane.showConfirmDialog(this, "Bỏ tất cả sản phẩm ra khỏi giỏ hàng?");
            if (confirm == 0) {
                for (int i = 0; i < tblCTHD.getRowCount(); i++) {
                    HoaDonChiTiet cthd = hdctService.getCTHDByMaHD(txtMaHD.getText()).get(0);
                    ChiTietSach ctsp = cthd.getChiTietSach();
                    ctsp.setSoLuongTon(ctsp.getSoLuongTon() + cthd.getSoLuong());
                    chiTietSachService.sua(ctsp);
                    hdctService.xoa(cthd);
                }
            }
        }
        loadTableSach(chiTietSachService.timKiem(txtTim.getText()));
        loadTableHDCT(hdctService.getCTHDByMaHD(txtMaHD.getText()));
    }//GEN-LAST:event_btnXoaAllActionPerformed

    private void txtTongTienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTongTienCaretUpdate
        // TODO add your handling code here:
        txtThanhTien.setText(txtTongTien.getText());
    }//GEN-LAST:event_txtTongTienCaretUpdate

    private void txtTienNhanCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienNhanCaretUpdate
        if (!txtTienNhan.getText().equals("")) {
            txtTienThua.setText(formatter.format((Integer.parseInt(txtTienNhan.getText())) - thanhTien()));
        }
    }//GEN-LAST:event_txtTienNhanCaretUpdate
    public Integer khachTT() {
        return Integer.parseInt(txtTienNhan.getText());
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed

        if (checkTT()) {
            if (checkForm()) {
                HoaDon hoaDon = hoaDonService.getHDByMa(txtMaHD.getText());
                hoaDon.setTongTien(new BigDecimal(txtTongTien.getText()));
                hoaDon.setTinhTrang(1);
                hoaDon.setNgayThanhToan(Date.valueOf(LocalDate.now()));
                KhachHang khachHang = khachHangService.getList().get(cboKH.getSelectedIndex());
                hoaDon.setKhachHang(khachHang);
                Voucher voucher = vcService.getList().get(cboVC.getSelectedIndex());
                hoaDon.setVoucher(voucher);
                hoaDonService.sua(hoaDon);
                if (hoaDonService.thanhToan(hoaDon)) {
                    JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                    if (JOptionPane.showConfirmDialog(this, "Bạn muốn in hóa đơn không") == JOptionPane.YES_OPTION) {
                        HoaDon hdin = new HoaDon();
                        hdin.setMa(genMaHD());
//                        hdin.setUsers(null);
//                        hdin.setKhachHang("Nguyễn Sỹ Sơn");
                        hdin.setKhachHang(khachHang);
                        hdin.setTongTien(new BigDecimal(txtTongTien.getText()));
                        List<HoaDonChiTiet> ghin = new ArrayList<>();
                        for (int i = 0; i < tblCTHD.getRowCount(); i++) {
                            HoaDonChiTiet hdct = new HoaDonChiTiet();
                            System.out.println(tblCTHD.getValueAt(i, 4).toString());
                            System.out.println(tblCTHD.getValueAt(i, 5).toString());
                            hdct.setTenSach(tblCTHD.getValueAt(i, 2).toString());
                            hdct.setDonGia(new BigDecimal(tblCTHD.getValueAt(i, 4).toString()));
                            hdct.setSoLuong(Integer.parseInt(tblCTHD.getValueAt(i, 3).toString()));
                            try {
                                float donGia = Float.parseFloat(hdct.getDonGia().toString());
                                float giam = Float.parseFloat(hoaDon.getVoucher().getPhanTramGiam().toString());
                                float tongTien = donGia * hdct.getSoLuong();
                                float thanhTien = tongTien - tongTien/100*giam;
                                hdct.setThanhTien(new BigDecimal(thanhTien));
                                
                            } catch (Exception e) {
                                e.printStackTrace();

                            }
                            ghin.add(hdct);
                        }
                        if (InHoaDon.makePDF(hdin, ghin)) {
                            JOptionPane.showMessageDialog(this, "In hoá đơn thành công");
                        }
                    }
                    clearFrom();
                    loadTableHD(hoaDonService.getList());
                    loadTableHDCT(hdctService.getCTHDByMaHD(txtMaHD.getText()));
                    loadTableSach(chiTietSachService.getList());
                } else {
                    JOptionPane.showMessageDialog(this, "Thanh toán thất bại");
                }
            }

        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
//        addKH dialog = new addKH(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);
//        loadCBXKH(khachHangService.getList());
        if (insertKH.isVisible()) {
            insertKH.dispose();
        }
        insertKH.setVisible(true);
        insertKH.setLocationRelativeTo(null);
        fillToTable(khachHangService.getList());
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void txtTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int row = tblKhachHang.getSelectedRow();
        KhachHang kh = khachHangService.getList().get(row);
        cboKH.setSelectedItem(tblKhachHang.getValueAt(row, 1));
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnAddKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddKHActionPerformed
        // TODO add your handling code here:
        KhachHang kh = new KhachHang();
        kh.setTen(txtTen.getText());
        kh.setMa(genMa());
        kh.setSdt(txtSDT.getText());
        kh.setCccd(null);
        kh.setGioiTinh(null);
        khachHangService.them(kh);
        JOptionPane.showMessageDialog(this, "Thêm thành công!");
        this.clearForm();
        fillToTable(khachHangService.getList());
    }//GEN-LAST:event_btnAddKHActionPerformed

    private void txtTimSDTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimSDTCaretUpdate
        // TODO add your handling code here:
        String tim = txtTimSDT.getText();
        List<KhachHang> list = khachHangService.timKiem(tim);
        fillToTable(list);
    }//GEN-LAST:event_txtTimSDTCaretUpdate

    private void txtThanhTienCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtThanhTienCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienCaretUpdate

    private void cboVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboVCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboVCActionPerformed

    private void txtGiamCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtGiamCaretUpdate
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiamCaretUpdate

    private void cboVCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboVCItemStateChanged
        // TODO add your handling code here:
        Voucher voucher = vcService.getList().get(cboVC.getSelectedIndex() + 1);
        txtGiam.setText(voucher.getPhanTramGiam().toString());
        txtThanhTien.setText(formatter.format(thanhTien()));
    }//GEN-LAST:event_cboVCItemStateChanged

    public Double thanhTien() {
        return tongTien() - tongTien() / 100 * Integer.parseInt(txtGiam.getText());
    }

    public void clearForm() {
        txtTen.setText("");
        txtSDT.setText("");
    }

    private void fillToTable(List<KhachHang> list) {
        defaultTableModel = (DefaultTableModel) tblKhachHang.getModel();
        defaultTableModel.setRowCount(0);

        for (KhachHang s : list) {
            defaultTableModel.addRow(new Object[]{
                s.getMa(),
                s.getTen(),
                s.getCccd(),
                s.getSdt(),});
        }
    }

    public String genMa() {
        for (int i = 0; i < khachHangService.getList().size() + 1; i++) {
            String ma = "KH" + i;
            if (khachHangService.getKHByMa(ma) == null) {
                return ma;
            }
        }
        return null;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddKH;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnXoaAll;
    private javax.swing.JComboBox<String> cboHD;
    private javax.swing.JComboBox<String> cboKH;
    private javax.swing.JComboBox<String> cboVC;
    private javax.swing.JDialog insertKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblSach;
    private javax.swing.JTextField txtGiam;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienNhan;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTimSDT;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
