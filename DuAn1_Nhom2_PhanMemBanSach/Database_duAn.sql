DROP DATABASE CuaHangBanSach_Group2_IT17322
CREATE DATABASE CuaHangBanSach_Group2_IT17322
USE CuaHangBanSach_Group2_IT17322
GO
--Chuc vu
CREATE TABLE ChucVu(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  ma VARCHAR(20) UNIQUE,
  tenCV NVARCHAR(50) NULL,
  moTa NVARCHAR(225) NULL,
  ngayTao DATE NULL,
  ngayCapNhat DATE NULL
)
go

-- Users
CREATE TABLE Users(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
idChucVu UNIQUEIDENTIFIER,
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30) NULL,
cccd VARCHAR(30) NULL,
ngaySinh DATE NULL,
sdt VARCHAR(30) NULL,
diaChi NVARCHAR(100) NULL,
email VARCHAR(100) NULL,
gioiTinh INT DEFAULT 0,
matKhau VARCHAR(50) NULL,
tinhTrang INT DEFAULT 0,
ngayTao DATE NULL,
ngayCapNhat DATE NULL
)
GO

-- Khách hàng
CREATE TABLE KhachHang(
id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
ma VARCHAR(20) UNIQUE,
ten NVARCHAR(30) NULL,
cccd VARCHAR(30) NULL,
sdt VARCHAR(30) NULL,
gioiTinh INT DEFAULT 0,
diemTichLuy INT DEFAULT 0,
ngayTao DATE NULL,
ngayCapNhat DATE NULL
)
GO

--HoaDon
CREATE TABLE HoaDon(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  ma VARCHAR(20) UNIQUE,
  tenKH NVARCHAR(225) NULL,
  idKhachHang UNIQUEIDENTIFIER,
  idUser UNIQUEIDENTIFIER,
  idVC UNIQUEIDENTIFIER,
  ngayTao DATE null,
  ngayThanhToan DATE NULL,
  tinhTrang INT DEFAULT 0,
  tongTien DECIMAL(20,0) DEFAULT 0,
  ghiChu NVARCHAR(225) NULL,
  ngayCapNhat DATE NULL,
  nguoiTao NVARCHAR(225) NUll,
  nguoiCapNhat NVARCHAR(225) NULL
)
GO

-- sach
CREATE TABLE Sach(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  ma VARCHAR(20) UNIQUE,
  tenSach NVARCHAR(50) NULL,
  tinhTrang INT DEFAULT 0,
  ngayTao DATE NULL,
  ngayCapNhat DATE NULL,
  nguoiTao NVARCHAR(225) NUll,
  nguoiCapNhat NVARCHAR(225) NULL
)
GO

-- Tac gia
CREATE TABLE TacGia(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  ma VARCHAR(20) UNIQUE,
  tenTG NVARCHAR(50) NULL,
  ngaySinh DATE NULL,
  ngayMat DATE NULL,
  gioiTinh INT DEFAULT 0,
  moTa NVARCHAR(225) NULL,
  ngayTao DATE NULL,
  ngayCapNhat DATE NULL
)
GO

-- THE LOAI
CREATE TABLE TheLoai(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  ma VARCHAR(20) UNIQUE,
  tenTL NVARCHAR(50) NULL,
  ngayTao DATE NULL,
  ngayCapNhat DATE NULL
)
GO

-- NXB
CREATE TABLE NXB(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  ma VARCHAR(20) UNIQUE,
  tenNXB NVARCHAR(50) NULL,
  diaChi NVARCHAR(225) NULL,
  ngayTao DATE NULL,
  ngayCapNhat DATE NULL
)
GO

-- hoa don chi tiet
CREATE TABLE HoaDon_ChiTiet(
  Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  idHoaDon UNIQUEIDENTIFIER,
  idChiTietSach UNIQUEIDENTIFIER,
  tenSach NVARCHAR(50) NULL,
  soLuong int,
  donGia DECIMAL(20,0) DEFAULT 0,
  thanhTien DECIMAL(20,0) DEFAULT 0,
  ngayTao DATE NUll,
  ngayCapNhat DATE NULL,
  nguoiTao NVARCHAR(225) NUll,
  nguoiCapNhat NVARCHAR(225) NULL
)
GO

-- chi tiet sach
CREATE TABLE ChiTiet_Sach(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  idSach UNIQUEIDENTIFIER,
  idTacGia UNIQUEIDENTIFIER,
  idTheLoai UNIQUEIDENTIFIER,
  idNXB UNIQUEIDENTIFIER,
  soLuongTon INT,
  donGia DECIMAL(20,0) DEFAULT 0,
  moTa NVARCHAR(225) NULL,
  hinhAnh NVARCHAR(225) NULL,
  ngayTao DATE NULL,
  ngayCapNhat DATE NULL,
  nguoiTao NVARCHAR(225) NUll,
  nguoiCapNhat NVARCHAR(225) NULL
)
GO

-- khuyến mãi
CREATE TABLE KhuyenMai(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  ma VARCHAR(20) UNIQUE,
  tenKhuyenMai NVARCHAR(50) NULL,
  mucGiamGia int null,
  thoiGianBatDau DATE NULL,
  thoiGianKetThuc DATE NULL,
  trangThai int DEFAULT 0
)
GO

--sach_khuyemmai
CREATE TABLE Sach_KhuyenMai(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
  idChiTiet_Sach UNIQUEIDENTIFIER,
  idKhuyenMai UNIQUEIDENTIFIER,
  donGia DECIMAL(20,0) DEFAULT 0,
  soTienConLai DECIMAL(20,0) DEFAULT 0,
  trangThai INT DEFAULT 0
)
CREATE TABLE Vocher(
  id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
   ma VARCHAR(20) UNIQUE,
   ten NVARCHAR(50) NULL,
   phanTramGiam INT DEFAULT 0,
   ngayTao DATE null,
   ngayBD DATE null,
   ngayKT DATE null,
   moTa NVARCHAR(100) null,
   trangThai BIT DEFAULT 0
 )


-- moi quan he giua cac bang
-- chi tiet sach - tac gia
ALTER TABLE ChiTiet_Sach ADD CONSTRAINT FK_CTSach1 FOREIGN KEY (idTacGia) REFERENCES TacGia(id)
-- chi tiet sach - the loai
ALTER TABLE ChiTiet_Sach ADD CONSTRAINT FK_CTSach2 FOREIGN KEY (idTheLoai) REFERENCES TheLoai(id)
-- chi tiet sach - NXB
ALTER TABLE ChiTiet_Sach ADD CONSTRAINT FK_CTSach3 FOREIGN KEY (idNXB) REFERENCES NXB(id)
-- chi tiet sach - sach
ALTER TABLE ChiTiet_Sach ADD CONSTRAINT FK_CTSach4 FOREIGN KEY (idSach) REFERENCES Sach(id)
-- Hoa don - Users
ALTER TABLE HoaDon ADD CONSTRAINT FK_HoaDon1 FOREIGN KEY (idUser) REFERENCES Users(id)
--Hoa don - Vocher
ALTER TABLE HoaDon ADD CONSTRAINT FK_HoaDon2 FOREIGN KEY (idVC) REFERENCES Vocher(id)
-- Users - Chuc vu
ALTER TABLE Users ADD CONSTRAINT FK_Users FOREIGN KEY (idChucVu) REFERENCES ChucVu(id)
--HOA DON CHI TIET - HOA DON
ALTER TABLE HoaDon_ChiTiet ADD CONSTRAINT fk_HoaDonCT1 FOREIGN KEY (idHoaDon) REFERENCES HoaDon(id)
--HOA DON CHI TIET - CHI TIET SACH
ALTER TABLE HoaDon_ChiTiet ADD CONSTRAINT fk_HoaDonCT2 FOREIGN KEY (idChiTietSach) REFERENCES ChiTiet_Sach(id)
--hoá đơn - khách hàng
ALTER TABLE HoaDon ADD CONSTRAINT FK_HoaDon3 FOREIGN KEY (idKhachHang) REFERENCES KhachHang(id)
--sach_khuyenMai - chiTiet_Sach
ALTER TABLE Sach_KhuyenMai ADD CONSTRAINT FK_khuyenMai1 FOREIGN KEY (idChiTiet_Sach) REFERENCES ChiTiet_Sach(id)
--sach_khuyenMai - khuyenMai
ALTER TABLE Sach_KhuyenMai ADD CONSTRAINT FK_khuyenMai2 FOREIGN KEY (idKhuyenMai) REFERENCES KhuyenMai(id)

INSERT INTO [dbo].[ChucVu]([ma],[tenCV],[moTa])VALUES('CV001', 'Nhân viên', 'Nhân viên')
INSERT INTO [dbo].[ChucVu]([ma],[tenCV],[moTa])VALUES('CV002', 'Quản lý', 'Quản lý')
INSERT INTO [dbo].[Sach]([ma],[tenSach],[tinhTrang])VALUES('S001', N'Gió lạnh đầu mùa', 0)
INSERT INTO [dbo].[Sach]([ma],[tenSach],[tinhTrang])VALUES('S002', N'Nắng trong vườn', 0)
INSERT INTO [dbo].[Sach]([ma],[tenSach],[tinhTrang])VALUES('S003', N'Nhà hai mẹ con', 0)
INSERT INTO [dbo].[Sach]([ma],[tenSach],[tinhTrang])VALUES('S004', N'Ngẫm chuyện xưa', 0)
INSERT INTO [dbo].[Sach]([ma],[tenSach],[tinhTrang])VALUES('S005', N'Giữ gìn 36 phố phường', 0)
INSERT INTO [dbo].[Sach]([ma],[tenSach],[tinhTrang])VALUES('S006', N'Ngưới thắp đèn cho núi', 0)
INSERT INTO [dbo].[NXB]([ma],[tenNXB],[diaChi])VALUES('NXB001', 'Kim Đồng', 'Hà Nội')
INSERT INTO [dbo].[TacGia]([ma],[tenTG],[ngaySinh],[ngayMat],[gioiTinh],[moTa])
     VALUES('TG001', N'Thạch Lam', '1910-07-07', '1942-06-27', 1, N'Thạch Lam đã góp phần tạo nên sự đa dạng cho nền văn học Việt Nam thông qua những tác phẩm mang đậm dấu ấn riêng biệt.')
INSERT INTO [dbo].[TacGia]([ma],[tenTG],[ngaySinh],[ngayMat],[gioiTinh],[moTa])
     VALUES('TG002', N'Hồ Xuân Hương', '1772-07-07', '1822-06-27', 0, N'Thơ Hồ Xuân Hương luôn được trình bày theo phong cách thất ngôn bát cú hoặc thất ngôn tứ tuyệt, bút pháp được nhận định là điêu luyện nhưng phần chữ Nôm nhiều phần đặc sắc hơn chữ Hán')
INSERT INTO [dbo].[TacGia]([ma],[tenTG],[ngaySinh],[ngayMat],[gioiTinh],[moTa])
     VALUES('TG003', N'Nguyễn Khuyến', '1853-02-15', '1909-02-05', 1, N'Trong bộ phận thơ Nôm, Nguyễn Khuyến vừa là nhà thơ trào phúng vừa là nhà thơ trữ tình, nhuốm đậm tư tưởng Lão Trang và triết lý Đông Phương')
INSERT INTO [dbo].[TacGia]([ma],[tenTG],[ngaySinh],[ngayMat],[gioiTinh],[moTa])
     VALUES('TG004', N'Tố Hữu', '1920-10-04', '2002-12-09', 1, N'Ở Tố Hữu có sự thống nhất đẹp đẽ giữa cuộc đời cách mạng và cuộc đời thơ, giữa lý tưởng trong trái tim và những câu thơ trên đầu bút')
INSERT INTO [dbo].[TheLoai]([ma],[tenTL])VALUES('TL001', N'Văn học Việt Nam')
INSERT INTO [dbo].[TheLoai]([ma],[tenTL])VALUES('TL002', N'Văn học Nước Ngoài')
INSERT INTO [dbo].[TheLoai]([ma],[tenTL])VALUES('TL003', N'Lịch sử truyền thống')
INSERT INTO [dbo].[TheLoai]([ma],[tenTL])VALUES('TL004', N'Kiến thức - Khoa học')
INSERT INTO [dbo].[TheLoai]([ma],[tenTL])VALUES('TL005', N'Truyện tranh')
select * from Sach
select * from TacGia
select * from TheLoai
select * from NXB
INSERT INTO [dbo].[ChiTiet_Sach]([idTacGia],[idTheLoai],[idNXB],[idSach],[SoLuongTon],[donGia],[moTa],[hinhAnh])
	 VALUES('C1F31AF5-5D3F-4122-97FD-63C8C9EA8E34', '59E21327-B1B4-4D2D-A080-2428131097D6', '9EF8C1FD-BA80-4483-8424-697C8E378110','BA4C9541-DAD3-4656-99B8-387C133B1C33', 20, 20000, N'Tập truyện ngắn', null)
INSERT INTO [dbo].[ChiTiet_Sach]([idTacGia],[idTheLoai],[idNXB],[idSach],[SoLuongTon],[donGia],[moTa],[hinhAnh])
	 VALUES('9BE6DD6C-5644-4FCE-A75F-71D0BEF1212C', '70249C1C-0E2F-4DC1-A136-69436B957107', '9EF8C1FD-BA80-4483-8424-697C8E378110', '197D7CB7-864B-426F-A39E-9A96CDDC6792', 30, 30000, N'Tập truyện dài', null)
INSERT INTO [dbo].[ChiTiet_Sach]([idTacGia],[idTheLoai],[idNXB],[idSach],[SoLuongTon],[donGia],[moTa],[hinhAnh])
	 VALUES('3BA0140F-DDA0-420C-8D67-98CB349F9B1B', 'FC1902FF-7B8B-4678-8982-9AA3542EEF7D', '9EF8C1FD-BA80-4483-8424-697C8E378110', '2FC84A18-C5D1-49C4-822B-ECBF2CCE0D12', 100, 20000, N'Tập truyện ngắn', null)
INSERT INTO [dbo].[ChiTiet_Sach]([idTacGia],[idTheLoai],[idNXB],[idSach],[SoLuongTon],[donGia],[moTa],[hinhAnh])
	 VALUES('E147327D-F8C6-487B-962B-B4F7F653B406', '3581B890-3408-4143-B95F-D8C6EAAAF48C', '9EF8C1FD-BA80-4483-8424-697C8E378110', '7B5887DE-6DEF-41A5-B281-DE614970103E', 70, 25000, N'Tập truyện ngắn', null)
