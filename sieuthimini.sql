-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2024 at 06:51 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sieuthimini`
--

-- --------------------------------------------------------

--
-- Table structure for table `ctphieunhap`
--

CREATE TABLE `ctphieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `masp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gianhap` bigint(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctphieunhap`
--

INSERT INTO `ctphieunhap` (`maphieunhap`, `masp`, `soluong`, `gianhap`) VALUES
(21, 1, 2, 4000),
(22, 1, 2, 4000),
(23, 1, 4, 5000),
(24, 7, 3, 5000),
(25, 7, 7, 4000),
(26, 1, 3, 5000),
(27, 2, 2, 20000),
(28, 3, 2, 300),
(29, 3, 3, 400),
(30, 2, 5, 25000),
(21, 1, 2, 4000),
(22, 1, 2, 4000),
(23, 1, 4, 5000),
(24, 7, 3, 5000),
(25, 7, 7, 4000),
(26, 1, 3, 5000),
(27, 2, 2, 20000),
(28, 3, 2, 300),
(29, 3, 3, 400),
(30, 2, 5, 25000),
(31, 4, 10000, 100000);

-- --------------------------------------------------------

--
-- Table structure for table `ctphieuxuat`
--

CREATE TABLE `ctphieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `masp` int(11) NOT NULL DEFAULT 0,
  `soluong` int(11) NOT NULL DEFAULT 0,
  `dongia` bigint(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctphieuxuat`
--

INSERT INTO `ctphieuxuat` (`maphieuxuat`, `masp`, `soluong`, `dongia`) VALUES
(30, 4, 1, 130000),
(31, 4, 1, 130000),
(32, 4, 2, 130000),
(33, 4, 100, 130000);

-- --------------------------------------------------------

--
-- Table structure for table `ctquyen`
--

CREATE TABLE `ctquyen` (
  `manhomquyen` int(11) NOT NULL,
  `machucnang` int(11) NOT NULL,
  `hanhdong` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ctquyen`
--

INSERT INTO `ctquyen` (`manhomquyen`, `machucnang`, `hanhdong`) VALUES
(1, 1, 'add'),
(1, 1, 'delete'),
(1, 1, 'edit'),
(1, 1, 'view'),
(1, 2, 'add'),
(1, 2, 'view'),
(1, 3, 'add'),
(1, 3, 'delete'),
(1, 3, 'view'),
(1, 4, 'add'),
(1, 4, 'delete'),
(1, 4, 'edit'),
(1, 4, 'view'),
(1, 5, 'add'),
(1, 5, 'delete'),
(1, 5, 'edit'),
(1, 5, 'view'),
(1, 6, 'add'),
(1, 6, 'delete'),
(1, 6, 'edit'),
(1, 6, 'view'),
(1, 7, 'add'),
(1, 7, 'delete'),
(1, 7, 'edit'),
(1, 7, 'view'),
(1, 8, 'add'),
(1, 8, 'delete'),
(1, 8, 'edit'),
(1, 8, 'view'),
(1, 9, 'add'),
(1, 9, 'delete'),
(1, 9, 'edit'),
(1, 9, 'view'),
(1, 10, 'add'),
(1, 10, 'delete'),
(1, 10, 'edit'),
(1, 10, 'view'),
(5, 1, 'view'),
(5, 2, 'view'),
(5, 3, 'view'),
(5, 4, 'view'),
(5, 5, 'view'),
(5, 6, 'view'),
(5, 7, 'view'),
(5, 8, 'view'),
(6, 1, 'view'),
(6, 2, 'view'),
(6, 3, 'view'),
(6, 4, 'view'),
(6, 5, 'view'),
(6, 6, 'view'),
(6, 7, 'view'),
(6, 8, 'view'),
(7, 1, 'view'),
(7, 2, 'view'),
(7, 3, 'view'),
(16, 1, 'view'),
(16, 2, 'view'),
(16, 3, 'view'),
(16, 4, 'view'),
(16, 5, 'view'),
(16, 6, 'view'),
(18, 1, 'add'),
(18, 1, 'delete'),
(18, 1, 'edit'),
(18, 1, 'view'),
(18, 2, 'add'),
(2, 1, 'view'),
(2, 1, 'add'),
(2, 2, 'view'),
(2, 2, 'add'),
(2, 3, 'view'),
(2, 3, 'add'),
(2, 4, 'view'),
(2, 4, 'add'),
(2, 5, 'view'),
(2, 5, 'add'),
(2, 7, 'view'),
(2, 7, 'add'),
(1, 1, 'add'),
(1, 1, 'delete'),
(1, 1, 'edit'),
(1, 1, 'view'),
(1, 2, 'add'),
(1, 2, 'view'),
(1, 3, 'add'),
(1, 3, 'delete'),
(1, 3, 'view'),
(1, 4, 'add'),
(1, 4, 'delete'),
(1, 4, 'edit'),
(1, 4, 'view'),
(1, 5, 'add'),
(1, 5, 'delete'),
(1, 5, 'edit'),
(1, 5, 'view'),
(1, 6, 'add'),
(1, 6, 'delete'),
(1, 6, 'edit'),
(1, 6, 'view'),
(1, 7, 'add'),
(1, 7, 'delete'),
(1, 7, 'edit'),
(1, 7, 'view'),
(1, 8, 'add'),
(1, 8, 'delete'),
(1, 8, 'edit'),
(1, 8, 'view'),
(1, 9, 'add'),
(1, 9, 'delete'),
(1, 9, 'edit'),
(1, 9, 'view'),
(1, 10, 'add'),
(1, 10, 'delete'),
(1, 10, 'edit'),
(1, 10, 'view'),
(5, 1, 'view'),
(5, 2, 'view'),
(5, 3, 'view'),
(5, 4, 'view'),
(5, 5, 'view'),
(5, 6, 'view'),
(5, 7, 'view'),
(5, 8, 'view'),
(6, 1, 'view'),
(6, 2, 'view'),
(6, 3, 'view'),
(6, 4, 'view'),
(6, 5, 'view'),
(6, 6, 'view'),
(6, 7, 'view'),
(6, 8, 'view'),
(7, 1, 'view'),
(7, 2, 'view'),
(7, 3, 'view'),
(16, 1, 'view'),
(16, 2, 'view'),
(16, 3, 'view'),
(16, 4, 'view'),
(16, 5, 'view'),
(16, 6, 'view'),
(18, 1, 'add'),
(18, 1, 'delete'),
(18, 1, 'edit'),
(18, 1, 'view'),
(18, 2, 'add'),
(2, 1, 'view'),
(2, 1, 'add'),
(2, 2, 'view'),
(2, 2, 'add'),
(2, 3, 'view'),
(2, 3, 'add'),
(2, 4, 'view'),
(2, 4, 'add'),
(2, 5, 'view'),
(2, 5, 'add'),
(2, 7, 'view'),
(2, 7, 'add'),
(-1, 1, 'view'),
(-1, 1, 'add'),
(-1, 1, 'edit'),
(-1, 1, 'delete'),
(-1, 2, 'view'),
(-1, 2, 'add'),
(-1, 3, 'view'),
(-1, 3, 'add'),
(-1, 3, 'delete'),
(-1, 4, 'view'),
(-1, 4, 'add'),
(-1, 4, 'edit'),
(-1, 4, 'delete'),
(-1, 5, 'view'),
(-1, 5, 'add'),
(-1, 5, 'edit'),
(-1, 5, 'delete'),
(-1, 6, 'view'),
(-1, 6, 'add'),
(-1, 6, 'edit'),
(-1, 6, 'delete'),
(-1, 7, 'view'),
(-1, 7, 'add'),
(-1, 7, 'edit'),
(-1, 7, 'delete'),
(-1, 8, 'view'),
(-1, 8, 'add'),
(-1, 8, 'edit'),
(-1, 8, 'delete'),
(-1, 9, 'view'),
(-1, 9, 'add'),
(-1, 9, 'edit'),
(-1, 9, 'delete'),
(4, 1, 'view'),
(4, 1, 'add'),
(4, 1, 'edit'),
(4, 1, 'delete'),
(4, 2, 'view'),
(4, 2, 'add'),
(4, 3, 'view'),
(4, 3, 'add'),
(4, 3, 'delete'),
(4, 4, 'view'),
(4, 4, 'add'),
(4, 4, 'edit'),
(4, 4, 'delete'),
(4, 5, 'view'),
(4, 5, 'add'),
(4, 5, 'edit'),
(4, 5, 'delete'),
(4, 6, 'view'),
(4, 6, 'add'),
(4, 6, 'edit'),
(4, 6, 'delete'),
(4, 7, 'view'),
(4, 7, 'add'),
(4, 7, 'edit'),
(4, 7, 'delete'),
(4, 8, 'view'),
(4, 8, 'add'),
(4, 8, 'edit'),
(4, 8, 'delete'),
(4, 9, 'view'),
(4, 9, 'add'),
(4, 9, 'edit'),
(4, 9, 'delete'),
(-1, 1, 'view'),
(-1, 2, 'view'),
(-1, 3, 'view');

-- --------------------------------------------------------

--
-- Table structure for table `danhmucchucnang`
--

CREATE TABLE `danhmucchucnang` (
  `machucnang` int(10) NOT NULL,
  `tenchucnang` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `danhmucchucnang`
--

INSERT INTO `danhmucchucnang` (`machucnang`, `tenchucnang`, `trangthai`) VALUES
(1, 'Quản lý khách hàng', 1),
(2, 'Quản lý khu vực kho', 1),
(3, 'Quản lý nhà cung cấp', 1),
(4, 'Quản lý nhân viên', 1),
(5, 'Quản lý nhập hàng', 1),
(6, 'Quản lý nhóm quyền', 1),
(7, 'Quản lý sản phẩm', 1),
(8, 'Quản lý tài khoản', 1),
(9, 'Quản lý thống kê', 1),
(10, 'Quản lý thuộc tính', 1);

-- --------------------------------------------------------

--
-- Table structure for table `giamgia`
--

CREATE TABLE `giamgia` (
  `magiamgia` int(11) NOT NULL,
  `tenctgiamgia` varchar(50) NOT NULL,
  `mocgiamgia` int(11) NOT NULL,
  `sotienduocgiam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `giamgia`
--

INSERT INTO `giamgia` (`magiamgia`, `tenctgiamgia`, `mocgiamgia`, `sotienduocgiam`) VALUES
(1, 'mua 2 tang 1', 200000, 20000),
(2, 'Sự kiện mua sắm lớn', 500000, 20000),
(3, 'Giảm giá đặc biệt', 1000000, 100000),
(4, 'Mùa hè rực rỡ', 2000000, 200000);

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

CREATE TABLE `khachhang` (
  `makh` int(11) NOT NULL,
  `tenkhachhang` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `gioitinh` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `ngaythamgia` date NOT NULL DEFAULT current_timestamp(),
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkhachhang`, `diachi`, `gioitinh`, `sdt`, `ngaythamgia`, `trangthai`) VALUES
(1, 'Nguyễn Văn A', 'Gia Đức, Ân Đức, Hoài Ân, Bình Định', 'Nam', '0387913347', '2023-04-19', 1),
(2, 'Trần Nhất Nhất', '205 Trần Hưng Đạo, Phường 10, Quận 5, Thành phố Hồ Chí Minh', 'Nam', '0123456789', '2023-04-19', 1),
(3, 'Hoàng Gia Bo', 'Khoa Trường, Hoài Ân, Bình Định', 'Nam', '0987654321', '2023-04-19', 1),
(4, 'Hồ Minh Hưng', 'Khoa Trường, Hoài Ân, Bình Định', 'Nam', '0867987456', '2023-04-19', 0),
(8, 'hhh', 'hhh', 'Nam', '0999111111', '2024-09-22', 0),
(9, 'hhh', 'hhh', 'Nam', '0999999111', '2024-09-22', 1),
(10, 'hhh', 'hhh', 'Nam', '0999111111', '2024-09-22', 1);

-- --------------------------------------------------------

--
-- Table structure for table `khuvuckho`
--

CREATE TABLE `khuvuckho` (
  `makhuvuc` int(11) NOT NULL,
  `tenkhuvuc` varchar(255) NOT NULL,
  `ghichu` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `khuvuckho`
--

INSERT INTO `khuvuckho` (`makhuvuc`, `tenkhuvuc`, `ghichu`, `trangthai`) VALUES
(1, 'Khu vực k', 'null', 0),
(2, 'Khu vực B', 'bánh kẹo', 1),
(3, 'Khu vực C', 'đồ ăn', 1),
(4, 'Khu vực D', 'đồ dùng học tập', 1),
(5, 'Khu vực E', 'nước ngọt', 1),
(6, 'Khu vực A', 'null', 1),
(7, 'khu vực Z', 'a', 0);

-- --------------------------------------------------------

--
-- Table structure for table `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `maloai` int(11) NOT NULL,
  `tenloai` varchar(255) NOT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loaisanpham`
--

INSERT INTO `loaisanpham` (`maloai`, `tenloai`, `trangthai`) VALUES
(1, 'Đồ ăn', 1),
(2, 'Nước uống', 1),
(3, 'Rau củ quả', 1),
(4, 'Đồ dùng cá nhân', 1),
(5, 'Dụng cụ học tập', 1);

-- --------------------------------------------------------

--
-- Table structure for table `losanpham`
--

CREATE TABLE `losanpham` (
  `malosanpham` int(11) NOT NULL,
  `maphieunhap` int(11) NOT NULL,
  `masp` int(11) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gianhap` int(11) NOT NULL,
  `giaban` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `losanpham`
--

INSERT INTO `losanpham` (`malosanpham`, `maphieunhap`, `masp`, `soluong`, `gianhap`, `giaban`) VALUES
(10, 25, 7, 5, 4000, 4200),
(11, 26, 1, 3, 5000, 5200),
(13, 28, 3, 2, 300, 315),
(14, 29, 3, 3, 400, 440),
(15, 30, 2, 4, 25000, 26250),
(16, 31, 4, 9896, 100000, 130000);

-- --------------------------------------------------------

--
-- Table structure for table `nhacungcap`
--

CREATE TABLE `nhacungcap` (
  `mancc` int(11) NOT NULL,
  `tenncc` varchar(255) NOT NULL,
  `diachi` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `sdt` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhacungcap`
--

INSERT INTO `nhacungcap` (`mancc`, `tenncc`, `diachi`, `email`, `sdt`, `trangthai`) VALUES
(1, 'Công Ty TNHH rau', ' Phòng 6.5, Tầng6, Tòa Nhà E. Town 2, 364 Cộng Hòa, P. 13, Q. Tân Bình, Tp. Hồ Chí Minh', 'lienhe@thegioididong.com', '02835100100', 1),
(2, 'Công ty bánh kẹo Việt Nam', 'Số 79 đường số 6, Hưng Phước 4, Phú Mỹ Hưng, quận 7, TPHCM', 'contact@paviet.vn', '19009477', 1),
(3, 'Công Ty TNHH đồ ăn nhanh', '8/38 Đinh Bô Lĩnh, P.24, Q. Bình Thạnh, Tp. Hồ Chí Minh', 'contact@baola.vn', '02835119060', 1),
(4, 'Công Ty nguyễn long ', 'Phòng 703, Tầng7, Tòa Nhà Metropolitan, 235 Đồng Khởi, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM)', 'chau.nguyen@nokia.com', '02838236894', 1),
(5, 'Hệ Thống Phân Phối nước ngọt', '261 Lê Lợi, P. Lê Lợi, Q. Ngô Quyền, Tp. Hải Phòng', 'info@mihome.vn', '0365888866', 1),
(6, 'Công Ty atech Việt Nam', 'Tòa nhà tài chính Bitexco, 2 Hải Triều, Bến Nghé, Quận 1, Thành phố Hồ Chí Minh', 'contact@samsung.vn', '0988788456', 1),
(7, 'Công ty suzuki Việt Nam', '27 Đ. Nguyễn Trung Trực, Phường Bến Thành, Quận 1, Thành phố Hồ Chí Minh', 'oppovietnam@oppo.vn', '0456345234', 1),
(8, 'ssdad', '3333', 'nq@gmail.com', '0911111111', 1);

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

CREATE TABLE `nhanvien` (
  `manv` varchar(10) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `gioitinh` varchar(11) NOT NULL,
  `ngaysinh` date NOT NULL,
  `sdt` varchar(50) NOT NULL,
  `email` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `hoten`, `gioitinh`, `ngaysinh`, `sdt`, `email`, `trangthai`) VALUES
('31220001', 'Đỗ Anh Đài', 'Nam', '2003-12-20', '0387913347', 'doanhdaigr5.2004@gmail.com', 1),
('31220002', 'Vũ Em', 'Nam', '2023-04-11', '0355374322', 'aaaa@gmail.com', 1),
('31220003', 'Đỗ Nam Công Chính', 'Nam', '2003-04-11', '0123456789', 'bbbbb@gmail.com', 1),
('31220004', 'Đinh Ngọc Ân', 'Nam', '2003-04-03', '0123456789', 'ccccc@gmail.com', 1),
('31220005', 'Vũ Trung Hiếu', 'Nam', '2023-05-06', '0123456789', 'ddddd@gmail.com', 1),
('31220009', 'Bùi Bảo Long', 'Nam', '2024-09-18', '0789654321', 'aa@gmail.com', 1);

--
-- Triggers `nhanvien`
--
DELIMITER $$
CREATE TRIGGER `new_ma_nhanvien` BEFORE INSERT ON `nhanvien` FOR EACH ROW BEGIN
  DECLARE max_manv INT;
  
  -- Lấy mã nhân viên cao nhất hiện có
  SELECT MAX(CAST(SUBSTRING(manv, 5) AS UNSIGNED)) INTO max_manv FROM nhanvien;
  
  -- Gán mã mới cho manv
  IF max_manv IS NULL THEN
    SET max_manv = 1;
  ELSE
    SET max_manv = max_manv + 1;
  END IF;
  
  SET NEW.manv = CONCAT('3122', LPAD(max_manv, 4, '0'));
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `nhomquyen`
--

CREATE TABLE `nhomquyen` (
  `manhomquyen` int(11) NOT NULL,
  `tennhomquyen` varchar(255) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhomquyen`
--

INSERT INTO `nhomquyen` (`manhomquyen`, `tennhomquyen`, `trangthai`) VALUES
(1, 'admin', 1),
(2, 'Nhân viên nhập hàng', 1),
(3, 'Nhân viên xuất hàng', 1),
(4, 'Quản lý', 1),
(5, 'Nhân viên mới', 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieunhap`
--

CREATE TABLE `phieunhap` (
  `maphieunhap` int(11) NOT NULL,
  `mancc` int(11) NOT NULL,
  `makhuvuc` int(11) NOT NULL,
  `manv` varchar(10) DEFAULT NULL,
  `thoigian` datetime DEFAULT current_timestamp(),
  `tongtien` bigint(20) NOT NULL DEFAULT 0,
  `trangthai` int(11) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieunhap`
--

INSERT INTO `phieunhap` (`maphieunhap`, `mancc`, `makhuvuc`, `manv`, `thoigian`, `tongtien`, `trangthai`) VALUES
(21, 1, 1, '31220001', '2024-09-22 00:00:00', 8000, 1),
(22, 5, 1, '31220001', '2024-09-22 00:00:00', 8000, 1),
(23, 1, 1, '31220001', '2024-09-22 00:00:00', 20000, 1),
(24, 1, 1, '31220001', '2024-09-22 00:00:00', 15000, 0),
(25, 1, 1, '31220001', '2024-09-22 00:00:00', 28000, 1),
(26, 1, 1, '31220001', '2024-09-22 00:00:00', 15000, 1),
(27, 1, 2, '31220001', '2024-09-22 00:00:00', 40000, 1),
(28, 1, 2, '31220001', '2024-09-22 00:00:00', 600, 0),
(29, 1, 2, '31220001', '2024-09-22 00:00:00', 1200, 1),
(30, 1, 2, '31220001', '2024-09-22 00:00:00', 125000, 1),
(31, 7, 6, '31220001', '2024-09-26 00:00:00', 1000000000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `phieuxuat`
--

CREATE TABLE `phieuxuat` (
  `maphieuxuat` int(11) NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT current_timestamp(),
  `tongtien` bigint(20) DEFAULT NULL,
  `soluong` int(11) NOT NULL,
  `manv` varchar(10) DEFAULT NULL,
  `makh` int(11) NOT NULL,
  `magiamgia` int(11) DEFAULT NULL,
  `trangthai` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `phieuxuat`
--

INSERT INTO `phieuxuat` (`maphieuxuat`, `thoigian`, `tongtien`, `soluong`, `manv`, `makh`, `magiamgia`, `trangthai`) VALUES
(30, '2024-09-26 00:00:00', 130000, 0, '31220001', 3, 1, 0),
(31, '2024-09-26 00:00:00', 130000, 0, '31220001', 2, 1, 0),
(32, '2024-09-26 00:00:00', 260000, 0, '31220001', 1, 1, 0),
(33, '2024-09-27 00:00:00', 13000000, 0, '31220001', 1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

CREATE TABLE `sanpham` (
  `masp` int(11) NOT NULL,
  `maloai` int(11) NOT NULL,
  `tensp` varchar(255) DEFAULT NULL,
  `hinhanh` varchar(255) DEFAULT NULL,
  `xuatxu` int(11) DEFAULT NULL,
  `NSX` date NOT NULL,
  `HSD` date NOT NULL,
  `thuonghieu` int(11) DEFAULT NULL,
  `giaban` int(11) NOT NULL,
  `soluongton` int(11) DEFAULT 0,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`masp`, `maloai`, `tensp`, `hinhanh`, `xuatxu`, `NSX`, `HSD`, `thuonghieu`, `giaban`, `soluongton`, `trangthai`) VALUES
(1, 2, 'pepsi', '', 1, '2023-04-11', '2023-11-11', 1, 0, 6, 0),
(2, 1, 'bánh kem', '', 1, '2023-04-11', '2023-11-11', 1, 0, 10, 1),
(3, 1, 'bánh quy', '', 1, '2023-04-11', '2023-11-11', 1, 0, 2, 1),
(4, 3, 'cà rốt', '', 1, '2023-04-11', '2023-11-11', 1, 0, 9996, 1),
(5, 3, 'khoai tây', '', 1, '2023-04-11', '2023-11-11', 1, 0, 0, 1),
(6, 3, 'rau muống', '', 1, '2023-04-11', '2023-11-11', 1, 0, 0, 1),
(7, 2, 'coca', '', 1, '2023-04-11', '2023-11-11', 1, 0, 6, 1),
(8, 5, 'bút xóa', '', 1, '2023-04-11', '2023-11-11', 1, 0, 0, 1),
(12, 1, 'ddf', NULL, 1, '2024-09-03', '2024-09-26', 1, 0, 0, 0),
(13, 1, 'aaa', NULL, 1, '2024-09-01', '2024-09-17', 1, 0, 0, 0),
(14, 1, 'aaaa', NULL, 1, '2024-09-01', '2024-09-25', 1, 0, 0, 1),
(15, 1, 'jjj', NULL, 1, '2024-09-02', '2024-09-25', 1, 0, 0, 0),
(16, 1, 'dfgdgf', NULL, 1, '2024-09-01', '2024-09-26', 1, 0, 0, 1),
(17, 1, 'Bánh quy Oreo', 'src/GUI/imageSanPham/banhquy.jpg', 3, '2025-12-04', '2025-12-04', 1, 35000, 0, 1),
(18, 2, 'CoCa Cola', 'src/GUI/imageSanPham/cocacola.jpg', 4, '2025-12-05', '2025-12-05', 2, 10000, 0, 1),
(19, 5, 'Thước kẻ ', 'src/GUI/imageSanPham/thuocke.jpg', 1, '2025-12-06', '2025-12-06', 3, 7000, 0, 1),
(20, 2, 'Pepsi', 'src/GUI/imageSanPham/pepsi.jpg', 4, '2025-12-07', '2025-12-07', 2, 10000, 0, 1),
(21, 4, 'Kem đánh răng', 'src/GUI/imageSanPham/kemdanhrang.jpg', 3, '2025-12-08', '2025-12-08', 1, 25000, 0, 1),
(22, 3, 'Bắp cải', 'src/GUI/imageSanPham/bapcai.jpg', 3, '2025-12-09', '2025-12-09', 1, 12000, 0, 1),
(23, 4, 'Nước rửa tay', 'src/GUI/imageSanPham/nuocruatay.jpg', 2, '2025-12-10', '2025-12-10', 9, 45000, 0, 1),
(24, 5, 'Bút chì', 'src/GUI/imageSanPham/butchi.jpg', 1, '2025-12-11', '2025-12-11', 3, 8000, 0, 1),
(25, 1, 'Bánh mì', 'src/GUI/imageSanPham/banhmi.jpg', 3, '2025-12-12', '2025-12-12', 1, 15000, 0, 1),
(26, 4, 'Dầu gội', 'src/GUI/imageSanPham/daugoi.jpg', 2, '2025-12-13', '2025-12-13', 9, 55000, 0, 1),
(27, 3, 'Cà chua', 'src/GUI/imageSanPham/cachua.jpg', 3, '2025-12-14', '2025-12-14', 1, 13000, 0, 1),
(28, 2, 'Redbull', 'src/GUI/imageSanPham/redbull.jpg', 4, '2025-12-15', '2025-12-15', 2, 15000, 0, 1),
(29, 5, 'Vở', 'src/GUI/imageSanPham/vo.jpg', 1, '2025-12-16', '2025-12-16', 3, 8000, 0, 1),
(30, 2, 'Sting', 'src/GUI/imageSanPham/sting.jpg', 3, '2025-12-17', '2025-12-17', 1, 10000, 0, 1),
(31, 5, 'Sách ', 'src/GUI/imageSanPham/sach.jpg', 3, '2025-12-18', '2025-12-18', 1, 35000, 0, 1),
(32, 3, 'Hành lá', 'src/GUI/imageSanPham/hanhla.jpg', 1, '2025-12-19', '2025-12-19', 3, 3000, 0, 1),
(33, 1, 'Mì gói', 'src/GUI/imageSanPham/migoi.jpg', 2, '2025-12-20', '2025-12-20', 9, 7500, 0, 1),
(34, 3, 'Quả chanh', 'src/GUI/imageSanPham/chanh.jpg', 3, '2025-12-21', '2025-12-21', 1, 4000, 0, 1),
(35, 1, 'Kem ốc quế', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 9000, 0, 1),
(36, 1, 'Kem dừa', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 99000, 0, 1),
(37, 1, 'dakjgkjsdg', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-23', '2025-12-23', 1, 10, 0, 1),
(38, 1, 'Bánh quy Oreo', 'src/GUI/imageSanPham/banhquy.jpg', 3, '2025-12-04', '2025-12-04', 1, 35000, 0, 1),
(39, 2, 'CoCa Cola', 'src/GUI/imageSanPham/cocacola.jpg', 4, '2025-12-05', '2025-12-05', 2, 10000, 0, 1),
(40, 5, 'Thước kẻ ', 'src/GUI/imageSanPham/thuocke.jpg', 1, '2025-12-06', '2025-12-06', 3, 7000, 0, 1),
(41, 2, 'Pepsi', 'src/GUI/imageSanPham/pepsi.jpg', 4, '2025-12-07', '2025-12-07', 2, 10000, 0, 1),
(42, 4, 'Kem đánh răng', 'src/GUI/imageSanPham/kemdanhrang.jpg', 3, '2025-12-08', '2025-12-08', 1, 25000, 0, 1),
(43, 3, 'Bắp cải', 'src/GUI/imageSanPham/bapcai.jpg', 3, '2025-12-09', '2025-12-09', 1, 12000, 0, 1),
(44, 4, 'Nước rửa tay', 'src/GUI/imageSanPham/nuocruatay.jpg', 2, '2025-12-10', '2025-12-10', 9, 45000, 0, 1),
(45, 5, 'Bút chì', 'src/GUI/imageSanPham/butchi.jpg', 1, '2025-12-11', '2025-12-11', 3, 8000, 0, 1),
(46, 1, 'Bánh mì', 'src/GUI/imageSanPham/banhmi.jpg', 3, '2025-12-12', '2025-12-12', 1, 15000, 0, 1),
(47, 4, 'Dầu gội', 'src/GUI/imageSanPham/daugoi.jpg', 2, '2025-12-13', '2025-12-13', 9, 55000, 0, 1),
(48, 3, 'Cà chua', 'src/GUI/imageSanPham/cachua.jpg', 3, '2025-12-14', '2025-12-14', 1, 13000, 0, 1),
(49, 2, 'Redbull', 'src/GUI/imageSanPham/redbull.jpg', 4, '2025-12-15', '2025-12-15', 2, 15000, 0, 1),
(50, 5, 'Vở', 'src/GUI/imageSanPham/vo.jpg', 1, '2025-12-16', '2025-12-16', 3, 8000, 0, 1),
(51, 2, 'Sting', 'src/GUI/imageSanPham/sting.jpg', 3, '2025-12-17', '2025-12-17', 1, 10000, 0, 1),
(52, 5, 'Sách ', 'src/GUI/imageSanPham/sach.jpg', 3, '2025-12-18', '2025-12-18', 1, 35000, 0, 1),
(53, 3, 'Hành lá', 'src/GUI/imageSanPham/hanhla.jpg', 1, '2025-12-19', '2025-12-19', 3, 3000, 0, 1),
(54, 1, 'Mì gói', 'src/GUI/imageSanPham/migoi.jpg', 2, '2025-12-20', '2025-12-20', 9, 7500, 0, 1),
(55, 3, 'Quả chanh', 'src/GUI/imageSanPham/chanh.jpg', 3, '2025-12-21', '2025-12-21', 1, 4000, 0, 1),
(56, 1, 'Kem ốc quế', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 9000, 0, 1),
(57, 1, 'Kem dừa', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 99000, 0, 1),
(58, 1, 'dakjgkjsdg', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-23', '2025-12-23', 1, 10, 0, 1),
(59, 1, 'Bánh quy Oreo', 'src/GUI/imageSanPham/banhquy.jpg', 3, '2025-12-04', '2025-12-04', 1, 35000, 0, 1),
(60, 2, 'CoCa Cola', 'src/GUI/imageSanPham/cocacola.jpg', 4, '2025-12-05', '2025-12-05', 2, 10000, 0, 1),
(61, 5, 'Thước kẻ ', 'src/GUI/imageSanPham/thuocke.jpg', 1, '2025-12-06', '2025-12-06', 3, 7000, 0, 1),
(62, 2, 'Pepsi', 'src/GUI/imageSanPham/pepsi.jpg', 4, '2025-12-07', '2025-12-07', 2, 10000, 0, 1),
(63, 4, 'Kem đánh răng', 'src/GUI/imageSanPham/kemdanhrang.jpg', 3, '2025-12-08', '2025-12-08', 1, 25000, 0, 1),
(64, 3, 'Bắp cải', 'src/GUI/imageSanPham/bapcai.jpg', 3, '2025-12-09', '2025-12-09', 1, 12000, 0, 1),
(65, 4, 'Nước rửa tay', 'src/GUI/imageSanPham/nuocruatay.jpg', 2, '2025-12-10', '2025-12-10', 9, 45000, 0, 1),
(66, 5, 'Bút chì', 'src/GUI/imageSanPham/butchi.jpg', 1, '2025-12-11', '2025-12-11', 3, 8000, 0, 1),
(67, 1, 'Bánh mì', 'src/GUI/imageSanPham/banhmi.jpg', 3, '2025-12-12', '2025-12-12', 1, 15000, 0, 1),
(68, 4, 'Dầu gội', 'src/GUI/imageSanPham/daugoi.jpg', 2, '2025-12-13', '2025-12-13', 9, 55000, 0, 1),
(69, 3, 'Cà chua', 'src/GUI/imageSanPham/cachua.jpg', 3, '2025-12-14', '2025-12-14', 1, 13000, 0, 1),
(70, 2, 'Redbull', 'src/GUI/imageSanPham/redbull.jpg', 4, '2025-12-15', '2025-12-15', 2, 15000, 0, 1),
(71, 5, 'Vở', 'src/GUI/imageSanPham/vo.jpg', 1, '2025-12-16', '2025-12-16', 3, 8000, 0, 1),
(72, 2, 'Sting', 'src/GUI/imageSanPham/sting.jpg', 3, '2025-12-17', '2025-12-17', 1, 10000, 0, 1),
(73, 5, 'Sách ', 'src/GUI/imageSanPham/sach.jpg', 3, '2025-12-18', '2025-12-18', 1, 35000, 0, 1),
(74, 3, 'Hành lá', 'src/GUI/imageSanPham/hanhla.jpg', 1, '2025-12-19', '2025-12-19', 3, 3000, 0, 1),
(75, 1, 'Mì gói', 'src/GUI/imageSanPham/migoi.jpg', 2, '2025-12-20', '2025-12-20', 9, 7500, 0, 1),
(76, 3, 'Quả chanh', 'src/GUI/imageSanPham/chanh.jpg', 3, '2025-12-21', '2025-12-21', 1, 4000, 0, 1),
(77, 1, 'Kem ốc quế', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 9000, 0, 1),
(78, 1, 'Kem dừa', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 99000, 0, 1),
(79, 1, 'dakjgkjsdg', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-23', '2025-12-23', 1, 10, 0, 1),
(80, 1, 'Bánh quy Oreo', 'src/GUI/imageSanPham/banhquy.jpg', 3, '2025-12-04', '2025-12-04', 1, 35000, 0, 1),
(81, 2, 'CoCa Cola', 'src/GUI/imageSanPham/cocacola.jpg', 4, '2025-12-05', '2025-12-05', 2, 10000, 0, 1),
(82, 5, 'Thước kẻ ', 'src/GUI/imageSanPham/thuocke.jpg', 1, '2025-12-06', '2025-12-06', 3, 7000, 0, 1),
(83, 2, 'Pepsi', 'src/GUI/imageSanPham/pepsi.jpg', 4, '2025-12-07', '2025-12-07', 2, 10000, 0, 1),
(84, 4, 'Kem đánh răng', 'src/GUI/imageSanPham/kemdanhrang.jpg', 3, '2025-12-08', '2025-12-08', 1, 25000, 0, 1),
(85, 3, 'Bắp cải', 'src/GUI/imageSanPham/bapcai.jpg', 3, '2025-12-09', '2025-12-09', 1, 12000, 0, 1),
(86, 4, 'Nước rửa tay', 'src/GUI/imageSanPham/nuocruatay.jpg', 2, '2025-12-10', '2025-12-10', 9, 45000, 0, 1),
(87, 5, 'Bút chì', 'src/GUI/imageSanPham/butchi.jpg', 1, '2025-12-11', '2025-12-11', 3, 8000, 0, 1),
(88, 1, 'Bánh mì', 'src/GUI/imageSanPham/banhmi.jpg', 3, '2025-12-12', '2025-12-12', 1, 15000, 0, 1),
(89, 4, 'Dầu gội', 'src/GUI/imageSanPham/daugoi.jpg', 2, '2025-12-13', '2025-12-13', 9, 55000, 0, 1),
(90, 3, 'Cà chua', 'src/GUI/imageSanPham/cachua.jpg', 3, '2025-12-14', '2025-12-14', 1, 13000, 0, 1),
(91, 2, 'Redbull', 'src/GUI/imageSanPham/redbull.jpg', 4, '2025-12-15', '2025-12-15', 2, 15000, 0, 1),
(92, 5, 'Vở', 'src/GUI/imageSanPham/vo.jpg', 1, '2025-12-16', '2025-12-16', 3, 8000, 0, 1),
(93, 2, 'Sting', 'src/GUI/imageSanPham/sting.jpg', 3, '2025-12-17', '2025-12-17', 1, 10000, 0, 1),
(94, 5, 'Sách ', 'src/GUI/imageSanPham/sach.jpg', 3, '2025-12-18', '2025-12-18', 1, 35000, 0, 1),
(95, 3, 'Hành lá', 'src/GUI/imageSanPham/hanhla.jpg', 1, '2025-12-19', '2025-12-19', 3, 3000, 0, 1),
(96, 1, 'Mì gói', 'src/GUI/imageSanPham/migoi.jpg', 2, '2025-12-20', '2025-12-20', 9, 7500, 0, 1),
(97, 3, 'Quả chanh', 'src/GUI/imageSanPham/chanh.jpg', 3, '2025-12-21', '2025-12-21', 1, 4000, 0, 1),
(98, 1, 'Kem ốc quế', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 9000, 0, 1),
(99, 1, 'Kem dừa', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 99000, 0, 1),
(100, 1, 'dakjgkjsdg', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-23', '2025-12-23', 1, 10, 0, 1),
(101, 1, 'Bánh quy Oreo', 'src/GUI/imageSanPham/banhquy.jpg', 3, '2025-12-04', '2025-12-04', 1, 35000, 0, 1),
(102, 2, 'CoCa Cola', 'src/GUI/imageSanPham/cocacola.jpg', 4, '2025-12-05', '2025-12-05', 2, 10000, 0, 1),
(103, 5, 'Thước kẻ ', 'src/GUI/imageSanPham/thuocke.jpg', 1, '2025-12-06', '2025-12-06', 3, 7000, 0, 1),
(104, 2, 'Pepsi', 'src/GUI/imageSanPham/pepsi.jpg', 4, '2025-12-07', '2025-12-07', 2, 10000, 0, 1),
(105, 4, 'Kem đánh răng', 'src/GUI/imageSanPham/kemdanhrang.jpg', 3, '2025-12-08', '2025-12-08', 1, 25000, 0, 1),
(106, 3, 'Bắp cải', 'src/GUI/imageSanPham/bapcai.jpg', 3, '2025-12-09', '2025-12-09', 1, 12000, 0, 1),
(107, 4, 'Nước rửa tay', 'src/GUI/imageSanPham/nuocruatay.jpg', 2, '2025-12-10', '2025-12-10', 9, 45000, 0, 1),
(108, 5, 'Bút chì', 'src/GUI/imageSanPham/butchi.jpg', 1, '2025-12-11', '2025-12-11', 3, 8000, 0, 1),
(109, 1, 'Bánh mì', 'src/GUI/imageSanPham/banhmi.jpg', 3, '2025-12-12', '2025-12-12', 1, 15000, 0, 1),
(110, 4, 'Dầu gội', 'src/GUI/imageSanPham/daugoi.jpg', 2, '2025-12-13', '2025-12-13', 9, 55000, 0, 1),
(111, 3, 'Cà chua', 'src/GUI/imageSanPham/cachua.jpg', 3, '2025-12-14', '2025-12-14', 1, 13000, 0, 1),
(112, 2, 'Redbull', 'src/GUI/imageSanPham/redbull.jpg', 4, '2025-12-15', '2025-12-15', 2, 15000, 0, 1),
(113, 5, 'Vở', 'src/GUI/imageSanPham/vo.jpg', 1, '2025-12-16', '2025-12-16', 3, 8000, 0, 1),
(114, 2, 'Sting', 'src/GUI/imageSanPham/sting.jpg', 3, '2025-12-17', '2025-12-17', 1, 10000, 0, 1),
(115, 5, 'Sách ', 'src/GUI/imageSanPham/sach.jpg', 3, '2025-12-18', '2025-12-18', 1, 35000, 0, 1),
(116, 3, 'Hành lá', 'src/GUI/imageSanPham/hanhla.jpg', 1, '2025-12-19', '2025-12-19', 3, 3000, 0, 1),
(117, 1, 'Mì gói', 'src/GUI/imageSanPham/migoi.jpg', 2, '2025-12-20', '2025-12-20', 9, 7500, 0, 1),
(118, 3, 'Quả chanh', 'src/GUI/imageSanPham/chanh.jpg', 3, '2025-12-21', '2025-12-21', 1, 4000, 0, 1),
(119, 1, 'Kem ốc quế', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 9000, 0, 1),
(120, 1, 'Kem dừa', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-22', '2025-12-22', 2, 99000, 0, 1),
(121, 1, 'dakjgkjsdg', 'src/GUI/imageSanPham/kemocque.jpg', 4, '2025-12-23', '2025-12-23', 1, 10, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

CREATE TABLE `taikhoan` (
  `mataikhoan` int(11) NOT NULL,
  `manv` varchar(10) DEFAULT NULL,
  `matkhau` char(255) NOT NULL,
  `manhomquyen` int(11) NOT NULL,
  `trangthai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`mataikhoan`, `manv`, `matkhau`, `manhomquyen`, `trangthai`) VALUES
(1, '31220001', 'abc', 1, 1),
(2, '31220003', 'abc', 1, 1),
(3, '31220002', 'abc', 1, 1),
(4, '31220004', 'abc', 2, 1),
(5, '31220005', 'abc', 3, 1),
(9, '31220008', '123', 2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `thuonghieu`
--

CREATE TABLE `thuonghieu` (
  `mathuonghieu` int(11) NOT NULL,
  `tenthuonghieu` varchar(255) NOT NULL,
  `trangthai` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `thuonghieu`
--

INSERT INTO `thuonghieu` (`mathuonghieu`, `tenthuonghieu`, `trangthai`) VALUES
(1, 'Thương hiệu A', 1),
(2, 'Thương hiệu B', 1),
(3, 'Thương hiệu C', 1),
(4, 'Thương hiệu D', 0),
(7, 'Thương hiệu E', 0),
(8, 'Thương hiệu F', 0),
(9, 'Thương hiệu G', 1),
(10, 'Thương hiệu H', 1);

-- --------------------------------------------------------

--
-- Table structure for table `xuatxu`
--

CREATE TABLE `xuatxu` (
  `maxuatxu` int(11) NOT NULL,
  `tenxuatxu` varchar(50) NOT NULL,
  `trangthai` tinyint(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `xuatxu`
--

INSERT INTO `xuatxu` (`maxuatxu`, `tenxuatxu`, `trangthai`) VALUES
(1, 'Trung Quốc', 1),
(2, 'Hàn Quốc', 1),
(3, 'Việt Nam', 1),
(4, 'USA', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD KEY `fk_ctphieunhap_maphieunhap` (`maphieunhap`),
  ADD KEY `fk_ctphieunhap_masp` (`masp`);

--
-- Indexes for table `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD KEY `fk_ctphieuxuat_masp` (`masp`),
  ADD KEY `fk_ctphieuxuat_maphieuxuat` (`maphieuxuat`);

--
-- Indexes for table `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  ADD PRIMARY KEY (`machucnang`);

--
-- Indexes for table `giamgia`
--
ALTER TABLE `giamgia`
  ADD PRIMARY KEY (`magiamgia`);

--
-- Indexes for table `khachhang`
--
ALTER TABLE `khachhang`
  ADD PRIMARY KEY (`makh`);

--
-- Indexes for table `khuvuckho`
--
ALTER TABLE `khuvuckho`
  ADD PRIMARY KEY (`makhuvuc`);

--
-- Indexes for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`maloai`);

--
-- Indexes for table `losanpham`
--
ALTER TABLE `losanpham`
  ADD PRIMARY KEY (`malosanpham`);

--
-- Indexes for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  ADD PRIMARY KEY (`mancc`);

--
-- Indexes for table `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`manv`);

--
-- Indexes for table `nhomquyen`
--
ALTER TABLE `nhomquyen`
  ADD PRIMARY KEY (`manhomquyen`);

--
-- Indexes for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD PRIMARY KEY (`maphieunhap`),
  ADD KEY `fk_phieunhap_mancc` (`mancc`),
  ADD KEY `fk_phieunhap_makhuvuc` (`makhuvuc`),
  ADD KEY `fk_phieunhap_manv` (`manv`);

--
-- Indexes for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD PRIMARY KEY (`maphieuxuat`),
  ADD KEY `fk_phieuxuat_manv` (`manv`),
  ADD KEY `fk_phieuxuat_makh` (`makh`),
  ADD KEY `fk_phieuxuat_magiamgia` (`magiamgia`);

--
-- Indexes for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`masp`),
  ADD KEY `fk_sanpham_loaisanpham` (`maloai`),
  ADD KEY `fk_sanpham_thuonghieu` (`thuonghieu`),
  ADD KEY `fk_sanpham_xuatxu` (`xuatxu`);

--
-- Indexes for table `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`mataikhoan`),
  ADD KEY `fk_taikhoan_manhomquyen` (`manhomquyen`),
  ADD KEY `fk_taikhoan_manv` (`manv`);

--
-- Indexes for table `thuonghieu`
--
ALTER TABLE `thuonghieu`
  ADD PRIMARY KEY (`mathuonghieu`);

--
-- Indexes for table `xuatxu`
--
ALTER TABLE `xuatxu`
  ADD PRIMARY KEY (`maxuatxu`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `danhmucchucnang`
--
ALTER TABLE `danhmucchucnang`
  MODIFY `machucnang` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `giamgia`
--
ALTER TABLE `giamgia`
  MODIFY `magiamgia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `khachhang`
--
ALTER TABLE `khachhang`
  MODIFY `makh` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `khuvuckho`
--
ALTER TABLE `khuvuckho`
  MODIFY `makhuvuc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `maloai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `losanpham`
--
ALTER TABLE `losanpham`
  MODIFY `malosanpham` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `nhacungcap`
--
ALTER TABLE `nhacungcap`
  MODIFY `mancc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `nhomquyen`
--
ALTER TABLE `nhomquyen`
  MODIFY `manhomquyen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `phieunhap`
--
ALTER TABLE `phieunhap`
  MODIFY `maphieunhap` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  MODIFY `maphieuxuat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `masp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=122;

--
-- AUTO_INCREMENT for table `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `mataikhoan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `thuonghieu`
--
ALTER TABLE `thuonghieu`
  MODIFY `mathuonghieu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `xuatxu`
--
ALTER TABLE `xuatxu`
  MODIFY `maxuatxu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ctphieunhap`
--
ALTER TABLE `ctphieunhap`
  ADD CONSTRAINT `fk_ctphieunhap_maphieunhap` FOREIGN KEY (`maphieunhap`) REFERENCES `phieunhap` (`maphieunhap`),
  ADD CONSTRAINT `fk_ctphieunhap_masp` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Constraints for table `ctphieuxuat`
--
ALTER TABLE `ctphieuxuat`
  ADD CONSTRAINT `fk_ctphieuxuat_maphieuxuat` FOREIGN KEY (`maphieuxuat`) REFERENCES `phieuxuat` (`maphieuxuat`),
  ADD CONSTRAINT `fk_ctphieuxuat_masp` FOREIGN KEY (`masp`) REFERENCES `sanpham` (`masp`);

--
-- Constraints for table `phieunhap`
--
ALTER TABLE `phieunhap`
  ADD CONSTRAINT `fk_phieunhap_makhuvuc` FOREIGN KEY (`makhuvuc`) REFERENCES `khuvuckho` (`makhuvuc`),
  ADD CONSTRAINT `fk_phieunhap_mancc` FOREIGN KEY (`mancc`) REFERENCES `nhacungcap` (`mancc`),
  ADD CONSTRAINT `fk_phieunhap_manv` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Constraints for table `phieuxuat`
--
ALTER TABLE `phieuxuat`
  ADD CONSTRAINT `fk_phieuxuat_magiamgia` FOREIGN KEY (`magiamgia`) REFERENCES `giamgia` (`magiamgia`),
  ADD CONSTRAINT `fk_phieuxuat_makh` FOREIGN KEY (`makh`) REFERENCES `khachhang` (`makh`),
  ADD CONSTRAINT `fk_phieuxuat_manv` FOREIGN KEY (`manv`) REFERENCES `nhanvien` (`manv`);

--
-- Constraints for table `sanpham`
--
ALTER TABLE `sanpham`
  ADD CONSTRAINT `fk_sanpham_loaisanpham` FOREIGN KEY (`maloai`) REFERENCES `loaisanpham` (`maloai`),
  ADD CONSTRAINT `fk_sanpham_thuonghieu` FOREIGN KEY (`thuonghieu`) REFERENCES `thuonghieu` (`mathuonghieu`),
  ADD CONSTRAINT `fk_sanpham_xuatxu` FOREIGN KEY (`xuatxu`) REFERENCES `xuatxu` (`maxuatxu`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
