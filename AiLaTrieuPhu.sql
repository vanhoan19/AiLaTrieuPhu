-- --------------------------------------------------------
-- Máy chủ:                      127.0.0.1
-- Server version:               10.4.28-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Phiên bản:           12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for ailatrieuphu
CREATE DATABASE IF NOT EXISTS `ailatrieuphu` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `ailatrieuphu`;

-- Dumping structure for table ailatrieuphu.cauhoi
CREATE TABLE IF NOT EXISTS `cauhoi` (
  `NoiDung` varchar(150) NOT NULL,
  `DapAn_A` varchar(150) NOT NULL,
  `DapAn_B` varchar(150) NOT NULL,
  `DapAn_C` varchar(150) NOT NULL,
  `DapAn_D` varchar(150) NOT NULL,
  `DapAnDung` varchar(1) NOT NULL,
  `Level` int(11) NOT NULL DEFAULT 0,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='bảng câu hỏi';

-- Dumping data for table ailatrieuphu.cauhoi: ~195 rows (approximately)
INSERT INTO `cauhoi` (`NoiDung`, `DapAn_A`, `DapAn_B`, `DapAn_C`, `DapAn_D`, `DapAnDung`, `Level`, `ID`) VALUES
	('Đội bóng đã từng đoạt nhiều chức vô địch Copa America nhất?', 'Uruguay', 'Brazil', 'Arghentina', 'Paraguay', 'A', 2, 1),
	('Phi hành gia Phạm Tuân đã mang loại thực vật nào để nghiên cứu trên con tàu vũ trụ Phương Đông ?', 'Bèo tấm', 'Bèo tổ ong', 'Bèo hoa dâu', 'Bèo cái', 'C', 2, 2),
	('Tác phẩm "Quê hương" của cố nhạc sĩ Hoàng Việt thuộc thể loại nào?', 'Giao hưởng', 'Hòa tấu nhạc cụ dân tộc', 'Nhạc kịch', 'Trường ca', 'A', 3, 3),
	('Nền văn hóa của dân tộc Mường tập trung nhiều nhất ở địa phương nào ở nước ta?', 'Sơn La', 'Lạng Sơn', 'Hòa Bình', 'Thái Bình', 'C', 2, 4),
	('Phong trào "Ba sẵn sàng" ở miền Bắc nước ta ra đời trong thời gian nào?', 'Cách mạng tháng Tám', 'kháng chiến chống Pháp', 'kháng chiến chống Mỹ', 'Sau giải phóng', 'B', 12, 5),
	('Ở áp suất thường, nhiệt độ đông đặc của thủy ngân lỏng là bao nhiêu độ bách phân?', '-29 độ C', '-39 độ C', '-49 độ C', '-59 độ C', 'B', 13, 6),
	('Bà chúa thơ Nôm Hồ Xuân Hương có bài thơ ví thân phận người phụ nữ với loại trái cây nào?', 'Trái mít', 'Trái bưởi', 'Trái thị', 'Trái cam', 'A', 7, 7),
	('Sa mạc nào được công nhận là một trong 7 kỳ quan thiên nhiên của châu Phi ?', 'Sa mạc Sahara', 'Sa mạc Namib', 'Sa mạc Kalahari', 'Sa mạc Gobi', 'A', 1, 8),
	('Đoạn sông Hồng chảy qua Việt Nam có độ dài bao nhiêu km?', '490', '510', '530', '550', 'D', 8, 9),
	('Trong 4 nguyên tố khí trơ dưới đây, nguyên tố nào có số electron ngoài cùng thấp nhất ?', 'Khí Neon (Ne)', 'Khí Argon (Ar)', 'Khí Heli (He)', 'Khí Kripton', 'C', 2, 10),
	('Tay đua nào đã đoạt chiếc áo vàng chung cuộc Tour De France 2009?', 'Andy Schleck', 'Lance Armtrong', 'Anberto Contador', 'Georg Totschnig', 'C', 9, 11),
	('Ở nước ta vị vua nào là người khởi đầu việc dùng chữ Nôm thay chữ Hán nhằm chấn hưng văn hóa Việt ?', 'Quang Trung', 'Hồ Quý Ly', 'Lê Thánh Tông', 'Lý Nhân Tông', 'C', 1, 12),
	('Từ năm 2006 đến nay, các tập phim về James Bond do ai thủ vai chính?', 'Marc Foster', 'Daniel Craig', 'Michael Sheen', 'Rowan Atkison', 'B', 10, 13),
	('Thăng Long tứ trấn là các đền Bạch Mã, Voi Phục, Quán Thánh và đền nào sau đây?', 'Đền Kim Liên', 'Đền Ngọc Sơn', 'Đền Phù Đổng', 'Đền Cửa Ông', 'B', 9, 14),
	('Cầu thủ nào có biệt danh là "Tóc đuôi ngựa thần thánh"?', 'Luigi Di Biagio', 'Salvatore Schillaci', 'Roberto Baggio', 'Lionel Messi', 'C', 14, 15),
	(' Phòng trưng bày "Không gian mộc bản triều Nguyễn - Di sản tư liệu thế giới" hiện nay nằm ở thành phố nào của nước ta ? ', 'Đà Lạt', 'Huế', 'Nha Trang', 'Đà Nẵng', 'B', 5, 16),
	('Vương cung thánh đường Sở Kiện tọa lạc ở tỉnh nào?', 'Nam Định', 'Quảng Trị', 'Hà Nam', 'Hải Phòng', 'D', 8, 17),
	('Bộ phim truyền hình "Trò đời" được chuyển thể từ những tác phẩm của nhà văn nào ?', 'Vũ Trọng Phọng', 'Nam Cao', 'Ma Văn Kháng', 'Ngô Tất Tố', 'A', 7, 18),
	('Cao trào cách mạng mà Đảng ta phát động ngay sau khi Nhật đảo chính Pháp (9/3/1945) mang tên gì?', 'Khởi nghĩa giành chính quyền', 'Đánh đuổi phát xít Nhật – Pháp', 'Kháng Nhật cứu nước', 'Tổng động viên', 'C', 10, 19),
	('Trong phim "Triệu phú ổ chuột", nhân vật chính đã trả lời được bao nhiêu câu hỏi trong chương trình "Ai là triệu phú"?', '18', '20', '14', '16', 'B', 6, 20),
	('Con đom đóm phát sáng trong đêm tối chủ yếu nhằm mục đích gì?', 'Soi sáng đường bay', 'Dẫn dụ con mồi', 'Dẫn dụ bạn tình', 'Cho con ăn', 'B', 6, 21),
	('Ai là tác giả của cuốn tiểu thuyết "Tôi thấy hoa vàng trên cỏ xanh"?', 'Nguyễn Nhật Ánh', 'Nguyễn Du', 'Nguyễn Trãi', 'Nguyễn Tuân', 'A', 5, 22),
	('Thành phố nào được gọi là "thành phố hoa" ở Việt Nam?', 'Huế', 'Đà Lạt', 'Hội An', 'Sapa', 'B', 1, 23),
	('Nước nào là quốc gia đầu tiên trên thế giới công nhận đồng tính hôn nhân?', 'Mỹ', 'Canada', 'Hà Lan', 'Bỉ', 'C', 3, 24),
	('Trong bảng tuần hoàn các nguyên tố hóa học, nguyên tố nào có ký hiệu là "O"?', 'Oxi', 'Nito', 'Heli', 'Canxi', 'A', 1, 25),
	('Ai là người đầu tiên đi bộ trên mặt trăng?', 'Neil Armstrong', 'Buzz Aldrin', 'Yuri Gagarin', 'Alan Shepard', 'A', 6, 26),
	('Ai là vị tướng quân của quân đội Carthage trong Thế chiến II?', 'Julius Caesar', 'Alexander the Great', 'Napoleon Bonaparte', 'Hannibal Barca', 'D', 14, 27),
	('Ai là tác giả của cuốn tiểu thuyết "Đi tìm lẽ sống"?', 'Paulo Coelho', 'Haruki Murakami', 'Mitch Albom', 'Khaled Hosseini', 'C', 9, 28),
	('Ai là người đầu tiên đưa ra lý thuyết về Tử vi học?', 'Albert Einstein', 'Isaac Newton', 'Galileo Galilei', 'Ptolemy', 'D', 8, 29),
	('Ai là người đoạt giải Nobel Vật lý đầu tiên trong lịch sử?', 'Marie Curie', 'Albert Einstein', 'Max Planck', 'Wilhelm Conrad Röntgen', 'D', 15, 30),
	('Trong bài hát "Give Peace a Chance", ai là người đã sáng tác và thể hiện bài hát này?', 'John Lennon', 'Bob Dylan', 'Bruce Springsteen', 'Michael Jackson', 'A', 10, 31),
	('Quốc gia nào là quốc gia đầu tiên trên thế giới phát sóng chương trình truyền hình màu?', 'Mỹ', 'Nhật Bản', 'Anh', 'Pháp', 'B', 4, 32),
	('Trong tiểu thuyết "Thủy hử", ai là người đã giúp Tôn Ngộ Không lấy được Kinh Thiên Sách?', 'Bạch Cốt Tinh', 'Thanh Vân Chí', 'Trường Sinh Giới', 'Tam Thiên Nhai Ngư', 'A', 3, 33),
	('Ai là tác giả của tác phẩm "Nỗi đau của tội ác"?', 'Fyodor Dostoevsky', 'Leo Tolstoy', 'Anton Chekhov', 'Ivan Turgenev', 'A', 6, 34),
	('Năm 1955, quốc gia nào đã ký Hiệp định Geneva chấm dứt chiến tranh ở Việt Nam?', 'Pháp', 'Anh', 'Hoa Kỳ', 'Liên Xô', 'A', 3, 35),
	('Ai là người đầu tiên phát hiện ra chứng bệnh AIDS?', 'Luc Montagnier', 'Robert Gallo', 'Paul Ehrlich', 'Jonas Salk', 'A', 7, 36),
	('Ai là người đầu tiên đưa ra giả thiết về sự hiện diện của "hạt cơ bản" trong vật chất?', 'Niels Bohr', 'James Clerk Maxwell', 'Werner Heisenberg', 'Ernest Rutherford', 'B', 11, 37),
	('Ai là nhà vật lý đầu tiên đề xuất khái niệm "lỗ đen"?', 'Albert Einstein', 'Stephen Hawking', 'Roger Penrose', 'John Michell', 'D', 9, 38),
	('Lục địa nào là lục địa lớn nhất trên Trái đất?', 'Nam Mỹ', 'Châu Á', 'Châu Âu', 'Châu Phi', 'B', 1, 39),
	('Ai là người đầu tiên tạo ra máy tính điện tử?', 'John von Neumann', 'Alan Turing', 'Charles Babbage', 'John Atanasoff', 'C', 7, 40),
	('Ai là vận động viên đầu tiên giành được 8 huy chương vàng tại một kỳ Thế vận hội?', 'Michael Phelps', 'Usain Bolt', 'Carl Lewis', 'Paavo Nurmi', 'A', 11, 41),
	('Ai là người đầu tiên điều khiển máy bay thành công?', 'Orville Wright', 'Wilbur Wright', 'Samuel Langley', 'Alberto Santos-Dumont', 'B', 15, 42),
	('Ai là người đầu tiên phát hiện ra chất bảo quản thực phẩm tên là "formaldehyde"?', 'Louis Pasteur', 'Antoine Lavoisier', 'Dmitri Mendeleev', 'August Wilhelm von Hofmann', 'D', 8, 43),
	('Bộ phim nào đoạt giải Oscar cho phim hay nhất năm 2020?', '1917', 'Joker', 'Parasite', ' The Irishman', 'C', 8, 44),
	('Ai là cầu thủ vô địch World Cup 2018 và giành giải Cầu thủ xuất sắc nhất giải?', 'Lionel Messi', 'Cristiano Ronaldo', 'Kylian Mbappé', 'Neymar Jr', 'C', 1, 45),
	('Đội tuyển bóng đá nào đã vô địch World Cup năm 2014?', 'Argentina', 'Brazil', 'Germany', 'Spain', 'C', 2, 46),
	('Ai là cầu thủ vô địch World Cup nhiều nhất trong lịch sử?', 'Pelé', 'Diego Maradona', 'Ronaldo', 'Miroslav Klose', 'D', 6, 47),
	('Đội bóng nào vô địch Champions League mùa giải 2020-2021?', 'Manchester City', 'Real Madrid', 'Chelsea', 'Bayern Munich', 'C', 3, 48),
	('Đội bóng nào vô địch Priemer League nhiều nhất?', 'Manchester United', 'Arsenal', 'Liverpool', 'Manchester City', 'A', 1, 49),
	('Ai là cầu thủ giành giải Quả bóng vàng nhiều nhất trong lịch sử?', 'Lionel Messi', 'Cristiano Ronaldo', 'Johan Cruyff', 'Michel Platini', 'A', 1, 50),
	('Đội tuyển bóng đá nào vô địch Euro 2020?', 'Italy', 'England', 'Spain', 'France', 'A', 1, 51),
	('Đây là loài gì: có răng nhọn, có vảy, không có chân, sống trong nước?', 'Cá sấu', 'Rắn', 'Cá mập', 'Lươn', 'C', 2, 52),
	('Người nào từng làm tổng thống Hoa Kỳ và đồng thời là diễn viên Hollywood?', 'Ronald Reagan', 'George W. Bush', 'Richard Nixon', 'Jimmy Carter', 'A', 2, 53),
	('Tên gì của quốc gia có diện tích lớn nhất thế giới?', 'Nga', 'Trung Quốc', 'Mỹ', 'Canada', 'A', 2, 54),
	('Đâu là tên một trong những bộ phim nổi tiếng của đạo diễn Stanley Kubrick?', 'The Godfather', 'Goodfellas', 'A Clockwork Orange', 'Pulp Fiction', 'C', 15, 55),
	('Vận động viên nào đã giành được huy chương vàng Olympic nhiều nhất trong lịch sử?', 'Michael Phelps', 'Usain Bolt', 'Carl Lewis', 'Larisa Latynina', 'D', 10, 56),
	('Ai là nhà vật lý nổi tiếng với định luật về chuyển động của các vật?', 'Isaac Newton', 'Albert Einstein', 'Galileo Galilei', 'James Clerk Maxwell', 'A', 9, 57),
	('Tên gì của loài cá có khả năng thở bằng phổi trên mặt đất?', 'Cá đuối', 'Cá voi', 'Cá mập', 'Cá trê', 'D', 3, 58),
	('Người nào là người đầu tiên đặt chân lên sao Hỏa?', 'Yuri Gagarin', 'Neil Armstrong', 'Buzz Aldrin', 'Viking 1', 'D', 12, 59),
	('Theo truyền thuyết Hy Lạp, ai là nữ thần chiến tranh?', 'Athena', 'Hera', 'Aphrodite', 'Artemis', 'A', 13, 60),
	('Tên gì của tác phẩm nổi tiếng của William Shakespeare?', 'Moby Dick', 'Hamlet', 'Jane Eyre', 'Pride and Prejudice', 'B', 15, 61),
	('Tên gì của dãy núi cao nhất thế giới?', 'Rocky Mountains', 'Alpas', 'Andes', 'Himalaya', 'D', 13, 62),
	('Tên gì của bộ phim nổi tiếng của đạo diễn Steven Spielberg về một con cá mập khổng lồ?', 'The Godfather', 'Goodfellas', 'Jurassic Park', 'Jaws', 'D', 13, 63),
	('Trong bảng tuần hoàn các nguyên tố hóa học, nguyên tố có ký hiệu là Ti là gì?', 'Titan', 'Thiếc', 'Thiên thể', 'Tinh thể', 'A', 13, 64),
	('Hệ thống định vị toàn cầu GPS được phát triển bởi:', 'NASA', 'Cục Hàng không và Vũ trụ Hoa Kỳ (FAA)', 'Bộ Quốc phòng Hoa Kỳ', 'Cục Điều tra Liên bang Hoa Kỳ (FBI)', 'C', 12, 65),
	('Ngôn ngữ lập trình nào được sử dụng để phát triển trang web động?', 'HTML', 'CSS', 'JavaScript', 'Python', 'C', 7, 66),
	('Nguyên tố hóa học nào có tên gọi theo tên của một bang của Mỹ?', 'California', 'Texas', 'Floriđa', 'Georgia', 'A', 11, 67),
	('Sông nào là sông dài nhất thế giới?', 'Sông Nile', ' Sông Amazon', 'Sông Mississippi', 'Sông Yangtze', 'B', 10, 68),
	('Trong loạt phim "Star Wars", tên gì của robot được gọi là "người bạn trung thành nhất" của Luke Skywalker?', 'C-3PO', 'R2-D2', 'BB-8', 'K-2SO', 'B', 15, 69),
	('"Ăn quả nhớ kẻ ... cây". Điền từ vào chỗ trống.', 'đội', 'chặt', 'trồng', 'leo', 'C', 1, 70),
	('"Gần mực thì đen, gần ... thì rạng". Điền từ vào chỗ trống.', 'điện', 'đèn', 'bạn', 'heo', 'B', 1, 71),
	('"Một miếng đất hơn một ... thân". Điền từ vào chỗ trống.', 'tắc', 'tấc', 'nấc', 'tất', 'B', 1, 72),
	('"Một cây làm chẳng nên non, ... cây chụm lại nên hòn núi cao". Điền từ vào chỗ trống.', 'một', 'hai', 'ba', 'bốn', 'C', 1, 73),
	('Vịnh Hạ Long nằm ở đâu?', 'Nghệ An', 'Hà Nội', 'Phú Thọ', 'Quảng Ninh', 'D', 2, 74),
	('Đỉnh Fansipan, đỉnh núi cao nhất Việt Nam, nằm ở tỉnh nào?', 'Lào Cai', 'Sơn La', 'Điện Biên', 'Hà Giang', 'A', 5, 75),
	('Thác Pongour, một trong những thác nước đẹp nhất Việt Nam, nằm ở tỉnh nào?', 'Lâm Đồng', 'Ninh Thuận', 'Khánh Hòa', 'Đắk Lắk', 'D', 6, 76),
	('Hang Sơn Đoòng, hang động lớn nhất thế giới, nằm ở tỉnh nào của Việt Nam?', 'Quảng Bình', 'Quảng Trị', 'Thừa Thiên Huế', 'Quảng Nam', 'A', 5, 77),
	('Địa danh "Phong Nha - Kẻ Bàng" là tên của:', 'Một quần thể hang động', 'Một khu rừng nguyên sinh', 'Một đồi cát bay', 'Một vịnh biển đẹp', 'A', 4, 78),
	('Địa danh "Hà Giang" là nơi có:', 'Cánh đồng hoa tam giác mạch', 'Biển đảo hoang sơ', 'Rừng nguyên sinh nhiệt đới', 'Thác nước lớn nhất Đông Nam Á', 'A', 4, 79),
	('Thành phố cổ Hội An nằm ở tỉnh nào của Việt Nam?', 'Huế', 'Quảng Bình', 'Quảng Nam', 'Quảng Ngãi', 'C', 5, 80),
	('Khu du lịch sinh thái Tràng An, một di sản thế giới của UNESCO, nằm ở tỉnh nào?', 'Ninh Bình', 'Thanh Hóa', 'Nam Định', 'Hà Tĩnh', 'A', 3, 81),
	('Núi Bà Đen nằm ở tỉnh nào của Việt Nam?', 'Bình Dương', 'Tây Ninh', 'Bình Thuận', 'Bình Phước', 'B', 5, 82),
	('Thác Bản Giốc, thác nước lớn nhất Việt Nam, nằm ở tỉnh nào?', 'Lào Cai', 'Yên Bái', 'Điện Biên', 'Lai Châu', 'A', 5, 83),
	('Khu bảo tồn thiên nhiên Phong Nha - Kẻ Bàng nằm ở tỉnh nào của Việt Nam?', 'Quảng Ninh', 'Quảng Bình', 'Quảng Ngãi', 'Quảng Trị', 'B', 5, 84),
	('Công viên quốc gia Yok Đôn nằm ở tỉnh nào của Việt Nam?', 'Đắk Lắk', 'Gia Lai', 'Kon Tum', 'Đắk Nông', 'A', 6, 85),
	('Phong trào Đông Du(1908-1910) do ai lãnh đạo?', 'Phan Bội Châu', 'Nguyễn Ái Quốc', 'Hồ Chí Minh', 'Lê Duẩn', 'A', 6, 86),
	('Vua Lê Thánh Tông đã ban hành nghị định nào năm 1470 để khai thác vàng bạc ở miền Bắc?', 'Đại Nam thực lục', 'Hồng Đức điển loại chi', 'Lĩnh Nam chích quái', 'Kinh tế học lược', 'B', 8, 87),
	('Quân Nguyên đã chiếm đóng Việt Nam vào năm nào?', '1407', '1428', '1789', '1862', 'A', 7, 88),
	('Tên gọi "Đồng Khánh" xuất phát từ triều đại nào của Việt Nam?', 'Triều Nguyễn', 'Triều Tây Sơn', 'Đại Việt', 'Triều Trần', 'A', 7, 89),
	('Ai là người sáng lập ra Apple?', 'Bill Gates', 'Steve Jobs', 'Mark Zuckerberg', 'Jeff Bezos', 'B', 5, 90),
	('Cuộc khởi nghĩa Tây Sơn nổ ra năm nào và do ai lãnh đạo?', '1771', '1789', '1868', '1945', 'A', 6, 91),
	('Tác giả của tác phẩm "Nhật ký trong tù" là ai?', 'Hồ Chí Minh', 'Bảo Ninh', 'Lê Văn Tam', 'Hàn Mặc Tử', 'A', 4, 92),
	('Tác giả của tiểu thuyết "Người giàu cũng khóc" là ai?', 'Nguyễn Nhật Ánh', 'Vũ Trọng Phụng', 'Võ Phiến', 'Vũ Bằng', 'C', 6, 93),
	('Tên gọi "Mùa hè đỏ lửa" được dùng để chỉ giai đoạn nào của cuộc kháng chiến chống Mỹ của Việt Nam?', 'Giai đoạn khởi nghĩa', 'Giai đoạn đấu tranh phòng thủ', 'Giai đoạn tấn công phản công', 'Giai đoạn hoà giải', 'C', 9, 94),
	('Đại dịch COVID-19 lần đầu tiên được phát hiện tại thành phố nào của Trung Quốc?', 'Thượng Hải', 'Bắc Kinh', 'Vũ Hán', 'Thâm Quyến', 'C', 6, 95),
	('Vương quốc Anh có bao nhiêu đỉnh núi cao hơn 1.000 mét?', '50', '100', '150', '200', 'D', 11, 96),
	('Bệnh tiểu đường là bệnh gì?', 'Bệnh lây truyền qua đường tình dục', 'Bệnh lây truyền qua đường máu', 'Bệnh do tăng đường huyết và khả năng tiết insulin giảm', 'Bệnh do vi khuẩn gây ra', 'C', 8, 97),
	('Loại vitamin nào giúp cải thiện thị lực?', 'Vitamin A', 'Vitamin B', 'Vitamin C', 'Vitamin D', 'A', 3, 98),
	('Bệnh ung thư là do gì gây ra?', 'Vi khuẩn', 'Nấm', 'Các tế bào phát triển không bình thường', 'Virus', 'C', 4, 99),
	('Chất dinh dưỡng nào giúp cải thiện sức khỏe tim mạch?', 'Chất xơ', 'Chất béo', 'Vitamin C', 'Chất đạm', 'A', 6, 100),
	('Bệnh viêm phổi do virus COVID-19 gây ra ảnh hưởng đến hệ cơ quan nào của cơ thể?', 'Hệ thống tiêu hóa', 'Hệ thống hô hấp', 'Hệ thống thần kinh', 'Hệ thống tuần hoàn', 'B', 5, 101),
	('Tình trạng thiếu máu do thiếu sắt thường gặp ở đối tượng nào?', 'Trẻ em', 'Người già', 'Phụ nữ mang thai', 'Nam giới', 'C', 9, 102),
	('Chất gì trong thuốc lá được cho là nguyên nhân chính gây ung thư phổi?', 'Nicotin', 'Carbon monoxide', 'Khí radon', 'Lead', 'C', 10, 103),
	('Bệnh nhân bị đái tháo đường thường phải kiêng những thực phẩm nào?', 'Thực phẩm có đường', 'Thực phẩm có chất béo', 'Thực phẩm có chất đạm', 'Thực phẩm có chất xơ', 'A', 2, 104),
	('Chất dinh dưỡng nào cần thiết cho sự phát triển của xương?', 'Canxi', 'Sắt', 'Magiê', 'Kali', 'A', 2, 105),
	('Vị trí nào trên cơ thể thường được đo để xác định chỉ số khối cơ thể (BMI)?', 'Chiều cao', 'Chu vi vòng eo', 'Chu vi cổ tay', 'Cổ chân', 'A', 3, 106),
	('Bệnh nhân mắc bệnh cúm thường bị các triệu chứng gì?', 'Sốt, đau đầu, đau họng', 'Đau bụng, đầy hơi, buồn nôn', 'Đau lưng, đau cổ, đau khớp', 'Đau ngực, khó thở, ho khan', 'A', 3, 107),
	('Tình trạng thiếu vitamin D có thể dẫn đến vấn đề gì về sức khỏe?', 'Bệnh còi xương ở trẻ em', 'Bệnh đái tháo đường', 'Bệnh ung thư da', 'Bệnh viêm khớp', 'A', 4, 108),
	('Trong bài hát "Happy" của Pharrell Williams, anh ta hát về điều gì?', 'Tình yêu', 'Tiền bạc', 'Hạnh phúc', 'Sự nổi tiếng', 'C', 1, 109),
	('Thành phố nào được coi là thủ đô của nước Pháp?', 'Nice', 'Paris', 'Bordeaux', 'Lyon', 'B', 2, 110),
	('Trong bộ phim "Star Wars", nhân vật chính là ai?', 'Han Solo', 'Luke Skywalker', 'Darth Vader', 'Chewbacca', 'B', 6, 111),
	('Trong bóng đá, giải đấu World Cup được tổ chức mỗi bao lâu một lần?', 'Hai năm', 'Bốn năm', 'Sáu năm', 'Tám năm', 'B', 2, 112),
	('Trong công thức hóa học H2O, "H2O" đại diện cho chất gì?', 'Oxy', 'Nước', 'Hiđrô', 'Khí nitơ', 'B', 1, 113),
	('Ai là tác giả của cuốn tiểu thuyết "The Catcher in the Rye"?', 'J.D. Salinger', 'Ernest Hemingway', 'F. Scott Fitzgerald', 'William Faulkner', 'A', 7, 114),
	('Trong bộ phim "The Lord of the Rings", nhân vật Frodo Baggins phải đưa chiếc nhẫn về đâu để tiêu diệt Sauron?', 'Mordor', 'Rivendell', 'Gondor', 'Isengard', 'A', 6, 115),
	('Tên đầy đủ của chủ tịch nước thứ 45 của Hoa Kỳ là gì?', 'George W. Bush', 'Barack Obama', 'Donald Trump', 'Joe Biden', 'D', 7, 116),
	('Ai đã viết cuốn tiểu thuyết "To Kill a Mockingbird"?', 'Harper Lee', 'Truman Capote', 'Truman Capote', 'F. Scott Fitzgerald', 'A', 8, 117),
	('Nhà văn Ernest Hemingway được biết đến với tác phẩm nào?', 'To Kill a Mockingbird', 'The Great Gatsby', 'The Old Man and the Sea', '1984', 'C', 9, 118),
	('Câu chuyện "Romeo and Juliet" của William Shakespeare kể về tình yêu giữa những nhân vật nào?', 'Romeo và Juliet', 'Hamlet và Ophelia', 'Macbeth và Lady Macbeth', 'Julius Caesar và Cleopatra', 'A', 4, 119),
	('Trong bộ phim nào, diễn viên Heath Ledger đóng vai Joker?', 'The Dark Knight', 'The Avengers', 'Iron Man', 'Spider-Man', 'A', 5, 120),
	('Ai là vận động viên vô địch quần vợt nữ đầu tiên trong lịch sử giành được 23 danh hiệu Grand Slam?', 'Serena Williams', 'Steffi Graf', 'Martina Navratilova', 'Billie Jean King', 'B', 8, 121),
	('Ai là người phát minh ra đèn điện đầu tiên?', 'Thomas Edison', 'Alexander Graham Bell', 'Nikola Tesla', 'Benjamin Franklin', 'A', 5, 122),
	('Bộ phim "Forrest Gump" kể về cuộc đời của nhân vật chính Forrest Gump, anh ta làm nghề gì trong phim?', 'Lính đánh thuê', 'Vận động viên bơi lội', 'Thợ may', 'Nhân viên bán hàng', 'A', 6, 123),
	('Trong bóng đá, giải đấu Copa America là giải đấu đối đầu giữa các đội tuyển quốc gia ở khu vực nào?', 'Châu Âu', 'Nam Mỹ', 'Châu Á', 'Bắc Mỹ', 'B', 4, 124),
	('Tên đầy đủ của hãng sản xuất điện thoại di động nổi tiếng Apple là gì?', 'Apple Corporation', 'Apple Computers', 'Apple Inc.', 'Apple Technologies', 'C', 6, 125),
	('Người nổi tiếng nào đã viết cuốn sách "A Brief History of Time"?', 'Stephen Hawking', 'Richard Dawkins', 'Neil deGrasse Tyson', 'Carl Sagan', 'A', 10, 126),
	('Thành phố nào được gọi là "Thành phố không bao giờ ngủ"?', 'New York City', 'Las Vegas', 'Tokyo', 'Bangkok', 'B', 9, 127),
	('Ai là người đưa ra lý thuyết Tử Thần cho các ngôi sao lớn?', 'Albert Einstein', 'Stephen Hawking', 'Carl Sagan', 'Neil deGrasse Tyson', 'B', 7, 128),
	('Loài vật nào được coi là động vật nhanh nhất trên trái đất?', 'Sói', 'Chó săn', 'Chim cánh cụt', 'Chạy đua', 'D', 8, 129),
	('Ai là vị hoàng đế của Đế quốc La Mã đầu tiên?', 'Julius Caesar', 'Augustus', 'Caligula', 'Nero', 'B', 6, 130),
	('Tên đầy đủ của nhà vua Anh đầu tiên là gì?', 'William the Conqueror', 'Henry VIII', 'Alfred the Great', 'Edward the Confessor', 'C', 7, 131),
	('Cuộc cách mạng Pháp nổ ra vào năm nào?', '1789', '1815', '1830', '1848', 'A', 6, 132),
	('Tên hòn đảo nào là nơi diễn ra trận chiến Pearl Harbor trong Thế chiến II?', 'Hawaii', 'Guam', 'Saipan', 'Okinawa', 'D', 7, 133),
	('Ai là người đứng đầu nước Nga trong Thế chiến II?', 'Joseph Stalin', 'Vladimir Lenin', 'Nikita Khrushchev', 'Leonid Brezhnev', 'A', 7, 134),
	('Thành phố nào đã trở thành thủ đô của Đức vào năm 1871?', 'Munich', 'Frankfurt', 'Hamburg', 'Berlin', 'D', 7, 135),
	('Thành phố nào được phát triển từ một khu định cư của người Viking trên bờ biển bắc nước Anh?', 'Edinburgh', 'Dublin', 'York', 'Copenhagen', 'C', 8, 136),
	('Ai là vị tướng lĩnh của quân đội Liên Xô trong cuộc Chiến tranh Lạnh?', 'Nikita Khrushchev', 'Leonid Brezhnev', 'Joseph Stalin', 'Georgy Zhukov', 'D', 6, 137),
	('Thành phố nào được coi là thủ đô của Việt Nam trước khi Hà Nội trở thành thủ đô chính thức vào năm 1976?', 'Huế', 'Đà Nẵng', 'Hội An', 'Sài Gòn', 'D', 5, 138),
	('Ai là người sáng lập ra nhà nước Văn Lang, được coi là nhà nước đầu tiên của Việt Nam?', 'Lạc Long Quân', 'Âu Lạc Thủy Hoàng', 'Trần Hưng Đạo', 'Nguyễn Huệ', 'A', 4, 139),
	('Ai là người đặt tên cho thành phố Hà Nội?', 'Trần Hưng Đạo', 'Nguyễn Huệ', 'Lý Thường Kiệt', 'Lê Đức Thọ', 'C', 3, 140),
	('Khởi nghĩa Bình Ngô đánh dấu sự kết thúc của triều đại nào?', 'Triều Ngô', 'Triều Hồ', 'Triều Lê', 'Triều Trần', 'B', 4, 141),
	('Tên đầy đủ của vua Gia Long, người đặt nền móng cho triều đại Nguyễn, là gì?', 'Nguyễn Phúc Ánh', 'Nguyễn Huệ', 'Nguyễn Công Trứ', 'Nguyễn Bỉnh Khiêm', 'A', 3, 142),
	('Cuộc khởi nghĩa nông dân nào đã phản đối chế độ thuộc địa của Pháp vào thế kỷ 20?', 'Khởi nghĩa Yên Bái', 'Khởi nghĩa Tây Nguyên', 'Khởi nghĩa Nam Kỳ', 'Khởi nghĩa Hà Tây', 'A', 3, 143),
	('Ai là người lãnh đạo của quân đội Việt Nam Cộng hòa trong Thế chiến II?', 'Trần Trọng Kim', 'Nguyễn Văn Thinh', 'Nguyễn Bá Thanh', 'Nguyễn Văn Thiệu', 'B', 5, 144),
	('Ai là người sáng lập ra Đại Việt, được coi là nhà nước đầu tiên của Việt Nam độc lập?', 'Lý Thái Tổ', 'Lê Lợi', 'Trần Thái Tông', 'Nguyễn Huệ', 'A', 5, 145),
	('Ai là người đứng đầu của Việt Minh, tổ chức đấu tranh độc lập của Việt Nam trong thời kỳ chiến tranh giành độc lập?', 'Hồ Chí Minh', 'Võ Nguyên Giáp', 'Phạm Văn Đồng', 'Nguyễn Thị Minh Khai', 'A', 5, 146),
	('Món ăn nào được coi là món ăn quốc gia của Ý?', 'Pizza', 'Spaghetti', 'Lasagna', 'Risotto', 'A', 4, 147),
	('Trong ẩm thực Nhật Bản, món ăn nào được làm từ rau diếp và tôm khô?', 'Soba', 'Udon', 'Okonomiyaki', 'Takoyaki', 'A', 10, 148),
	('Món ăn nào là món ăn truyền thống của Mexico và được làm từ bột ngô?', 'Tostadas', 'Enchiladas', 'Burritos', 'Tamales', 'D', 11, 149),
	('Món ăn nào được xem là món ăn quốc gia của Thái Lan?', 'Pad Thai', 'Tom Yum', 'Massaman Curry', 'Som Tam', 'D', 11, 150),
	('Món ăn nào được làm từ thịt bò, khoai tây, hành tây và cà rốt, thường được phục vụ trong các bữa tiệc tối?', 'Beef Wellington', 'Shepherd\'s Pie', 'Pot Roast', 'Beef Stew', 'B', 11, 151),
	('Món ăn nào được coi là món ăn truyền thống của Hàn Quốc và được làm từ cá nướng?', 'Kimchi', 'Bibimbap', 'Samgyeopsal', 'Hoe', 'D', 10, 152),
	('Trong ẩm thực Pháp, món ăn nào được làm từ gan vịt?', 'Coq au Vin', 'Escargots', 'Foie Gras', 'Bouillabaisse', 'C', 12, 153),
	('Món ăn nào được coi là món ăn quốc gia của Ấn Độ và được làm từ gà?', 'Biryani', 'Tandoori Chicken', 'Butter Chicken', 'Chicken Korma', 'B', 12, 154),
	('Món ăn nào là món ăn truyền thống của Argentina và được làm từ thịt bò nướng?', 'Empanadas', 'Churrasco', 'Asado', 'Milanesa', 'C', 13, 155),
	('Món ăn nào là món ăn truyền thống của Trung Quốc và được làm từ bánh mì và các loại thịt, trứng, rau củ khác nhau?', 'Hotpot', 'Congee', 'Jianbing', 'Xiaolongbao', 'C', 13, 156),
	('Câu hỏi nào được sử dụng để hỏi về thời gian?', 'What?', 'How?', 'When?', 'Why?', 'C', 4, 157),
	('Thành phố nào được coi là thủ đô của vùng Provence của Pháp và nổi tiếng với kiến trúc cổ đại và đồi Lavender?', 'Aix-en-Provence', 'Avignon', 'Marseille', 'Nice', 'B', 10, 158),
	('Thị trấn nào ở miền nam Tây Ban Nha được biết đến với các ngôi nhà màu trắng, mặt biển xanh và là nơi sinh ra của danh họa nổi tiếng Pablo Picasso?', 'Seville', 'Valencia', 'Malaga', 'Granada', 'C', 12, 159),
	('Điểm đến nào ở châu Phi được mô tả là "vùng đất chịu ảnh hưởng của núi lửa và bao quanh bởi một rạn san hô lớn nhất thế giới"?', 'Mauritius', 'Madagascar', 'Seychelles', 'Zanzibar', 'A', 13, 160),
	('Khu vực nào của Úc được coi là một trong những điểm đến du lịch hấp dẫn nhất của đất nước này, với những bãi biển đẹp, rặng san hô và các hoạt động ng', 'Vùng New South Wales', 'Vùng Northern Territory', 'Vùng Queensland', 'Vùng Victoria', 'C', 14, 161),
	('Thành phố nào được coi là "thành phố cổ nhất châu Á" và nổi tiếng với các đền đài, lăng tẩm và các công trình kiến trúc khác?', 'Kyoto, Nhật Bản', 'Luang Prabang, Lào', 'Siem Reap, Campuchia', 'Mandalay, Myanmar', 'A', 14, 162),
	('Thành phố nào của Brazil được coi là điểm đến du lịch nổi tiếng với các bãi biển đẹp và công viên quốc gia lớn nhất châu Mỹ Latinh?', 'Rio de Janeiro', 'São Paulo', 'Brasília', 'Salvador', 'A', 10, 163),
	('Thị trấn nào ở Thụy Sĩ được nằm giữa hồ Geneva và hồ Neuchâtel và được biết đến với các lâu đài và dinh thự cổ đại?', 'Lucerne', 'Interlaken', 'Montreux', 'Zermatt', 'C', 14, 164),
	('Khu nghỉ mát nào ở Mexico được biết đến với các bãi biển đẹp và là điểm đến phổ biến của các ngôi sao và người nổi tiếng?', 'Cancun', 'Puerto Vallarta', 'Los Cabos', 'Acapulco', 'C', 15, 165),
	('Thành phố nào của Hàn Quốc nổi tiếng với các công trình kiến trúc cổ đại, các đền đài và là trung tâm của nền văn hóa Hàn Quốc?', 'Busan', 'Incheon', 'Seoul', 'Gyeongju', 'D', 10, 166),
	('Thành phố nào của Ai Cập được biết đến với các di tích cổ đại, như kim tự tháp Giza và đền thờ Ramses II, và là điểm đến du lịch phổ biến của thế giới', 'Alexandria', 'Luxor', 'Aswan', 'Cairo', 'D', 10, 167),
	('Ngôi sao nào được coi là ngôi sao sáng nhất trên bầu trời đêm và là ngôi sao mạnh nhất trong vùng thiên hà của chúng ta?', 'Sirius A', 'Rigel', 'Canopus', 'VY Canis Majoris', 'D', 14, 168),
	('Các thiên thể nào được gọi là các hành tinh ngoài khí quyển của hệ mặt trời?', 'Planemo', 'Dwarf planet', 'Exoplanet', 'Gas giant', 'C', 15, 169),
	('Tên gọi "Thiên hà đôi" được đặt cho cặp thiên hà nào?', 'Thiên hà Bode', 'Thiên hà M51', 'Thiên hà Antennae', 'Thiên hà Sombrero', 'C', 15, 170),
	('Trong hệ mặt trời, hành tinh nào có nguồn gốc từ một vật thể lớn hơn bị phá vỡ, tạo ra một vòng đai các mảnh đá quay quanh hành tinh đó?', 'Vỏ Trái Đất', 'Sao Thủy', 'Sao Kim', 'Sao Mộc', 'B', 11, 171),
	('Đội bóng nào đã giành chức vô địch World Cup năm 2018?', 'Đức', 'Argentina', 'Pháp', 'Brazil', 'C', 2, 172),
	('Cầu thủ nào đã giành danh hiệu Quả bóng vàng năm 2021?', 'Cristiano Ronaldo', 'Lionel Messi', 'Robert Lewandowski', 'Kevin De Bruyne', 'B', 6, 173),
	('Nước nào đã giành huy chương vàng bóng đá nam tại Olympic Tokyo 2020?', 'Brazil', 'Argentina', 'Tây Ban Nha', 'Đức', 'A', 8, 174),
	('Vận động viên nào đã giành danh hiệu vô địch Wimbledon đơn nam mùa giải 2021?', 'Novak Djokovic', 'Roger Federer', 'Rafael Nadal', 'Andy Murray', 'A', 9, 175),
	('Đội tuyển bóng rổ nào đã giành chức vô địch NBA mùa giải 2020-2021?', 'Milwaukee Bucks', 'Golden State Warriors', 'Los Angeles Lakers', 'Miami Heat', 'A', 9, 176),
	('Vận động viên nào đã giành danh hiệu vô địch Olympic Tokyo 2020 ở môn đơn nam quần vợt?', 'Novak Djokovic', 'Alexander Zverev', 'Daniil Medvedev', 'Pablo Carreño Busta', 'B', 8, 177),
	('Cầu thủ nào đã giành danh hiệu Quả bóng vàng năm 2020?', 'Robert Lewandowski', 'Lionel Messi', 'Cristiano Ronaldo', 'Neymar', 'A', 9, 178),
	('Vận động viên nào đã giành huy chương vàng đơn nam quần vợt tại Olympic Rio 2016?', 'Novak Djokovic', 'Rafael Nadal', 'Andy Murray', 'Juan Martín del Potro', 'C', 8, 179),
	('Đội tuyển bóng rổ nào đã giành chức vô địch Olympic Tokyo 2020?', 'Hoa Kỳ', 'Tây Ban Nha', 'Pháp', 'Úc', 'D', 9, 180),
	('Các vi khuẩn gây bệnh truyền qua đường nào?', 'Da', 'Khí', 'Tiêu hoá', 'Máu', 'C', 4, 181),
	('Một người trưởng thành cần bao nhiêu thời gian ngủ trong một ngày?', '4 giờ', '6 giờ', '8 giờ', '10 giờ', 'C', 8, 182),
	('Bệnh tim là do nguyên nhân gì?', 'Vi rút', 'Vi khuẩn', 'Nấm', 'Lối sống không lành mạnh', 'D', 3, 183),
	('Bệnh tiểu đường là do gì gây ra?', 'Không đủ insulin', 'Có quá nhiều insulin', 'Cholesterol cao', 'Mỡ trong máu', 'A', 8, 184),
	('Chất dinh dưỡng nào cần thiết để cơ thể tạo ra năng lượng?', 'Carbohydrates', 'Protein', 'Fat', 'Fiber', 'A', 6, 185),
	('Một người bị cận thị thường nhìn được tốt ở khoảng cách bao nhiêu?', '10 cm', '20 cm', '30 cm', '40 cm', 'C', 8, 186),
	('Chất dinh dưỡng nào cần thiết cho sự phát triển và bảo vệ của tế bào?', 'Vitamin', 'Protein', 'Carbohydrates', 'Fat', 'B', 7, 187),
	('Bệnh trầm cảm là do nguyên nhân gì?', 'Vi khuẩn', 'Vi rút', 'Hormone', 'Sự suy giảm hoạt động của não bộ', 'D', 5, 188),
	('Thành phố nào được biết đến với tượng Chúa Cứu Thế Đức Kitô được tạo hình bởi nghệ sĩ Michelangelo?', 'Paris', 'Rome', 'Berlin', 'Amsterdam', 'B', 6, 189),
	('Trong lịch sử, chiến tranh thế giới thứ nhất bắt đầu vào năm nào?', '1914', '1915', '1916', '1917', 'A', 4, 190),
	('Đâu là quốc gia đầu tiên trên thế giới công nhận độc lập của Hoa Kỳ?', 'Pháp', 'Anh', 'Tây Ban Nha', 'Hà Lan', 'B', 13, 191),
	('Ai là nhà vật lý đầu tiên đo được tốc độ ánh sáng?', 'Albert Einstein', 'Max Planck', 'James Clerk Maxwell', 'Ole Rømer', 'D', 9, 192),
	('Trong tác phẩm "The Great Gatsby" của F. Scott Fitzgerald, nhân vật chính Gatsby sống ở đâu?', 'West Egg', 'East Egg', 'Manhattan', 'Long Island', 'A', 9, 193),
	('Đâu là ngôn ngữ chính thức của Liên Hiệp Quốc?', 'Tiếng Anh', 'Tiếng Pháp', 'Tiếng Trung Quốc', 'Tiếng Tây Ban Nha', 'A', 4, 194),
	('Trong bài hát "Imagine" của John Lennon, ông hát về một thế giới không có gì, chỉ có gì?', 'Hòa bình', 'Tình yêu', 'Tiền bạc', 'Chính trị', 'A', 4, 195),
	('Trong tác phẩm "1984" của George Orwell, nhân vật chính Winston Smith sống ở đâu?', 'Oceania', 'Eurasia', 'Eastasia', 'Airstrip One', 'D', 14, 196),
	('Ai là tác giả của tác phẩm "The Catcher in the Rye"?', 'J.D. Salinger', 'Ernest Hemingway', 'F. Scott Fitzgerald', 'Harper Lee', 'A', 14, 197),
	('Trong bộ phim "The Godfather", nhân vật chính Vito Corleone được đóng bởi diễn viên nào?', 'Marlon Brando', 'Al Pacino', 'Robert De Niro', 'James Caan', 'A', 13, 198),
	('Ai là người đã thành lập nhà nước Đại Việt vào thế kỷ 10?', 'Ngô Quyền', 'Đinh Tiên Hoàng', 'Lý Thái Tổ', 'Trần Thái Tông', 'B', 4, 199),
	('Ai là vị vua đầu tiên của triều đại Lê?', 'Lê Hoàn', 'Lê Lợi', 'Lê Thái Tổ', 'Lê Thánh Tông', 'C', 6, 200),
	('Khi nước Việt Nam được chia thành hai phần vào năm 1954, thành phố nào trở thành thủ đô của miền Nam?', 'Hà Nội', 'Sài Gòn', 'Huế', 'Hải Phòng', 'B', 5, 201),
	('Ai là người đã lãnh đạo cuộc khởi nghĩa Tây Sơn vào cuối thế kỷ 18?', 'Trịnh Sâm', 'Nguyễn Huệ', 'Lê Lợi', 'Tôn Thất Thuyết', 'B', 7, 202),
	('Ai là người đã đặt tên cho thành phố Hà Nội vào năm 1831?', 'Lê Văn Duyệt', 'Nguyễn Văn Thành', 'Nguyễn Văn Tố', 'Nguyễn Phúc Chu', 'A', 8, 203),
	('Trong thời kỳ Trần, ai là người đã đánh bại quân Nguyên Mông (Mông Cổ) và giành lại độc lập cho Việt Nam?', 'Trần Quốc Tuấn', 'Trần Nhân Tông', 'Trần Hưng Đạo', 'Trần Thái Tông', 'C', 4, 204);

-- Dumping structure for table ailatrieuphu.nguoichoi
CREATE TABLE IF NOT EXISTS `nguoichoi` (
  `TENNGUOICHOI` varchar(50) NOT NULL,
  `SOCAU` int(11) NOT NULL,
  `TONGTHOIGIAN` int(11) NOT NULL,
  `THOIGIANTHUC` datetime NOT NULL,
  PRIMARY KEY (`TENNGUOICHOI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table ailatrieuphu.nguoichoi: ~21 rows (approximately)
INSERT INTO `nguoichoi` (`TENNGUOICHOI`, `SOCAU`, `TONGTHOIGIAN`, `THOIGIANTHUC`) VALUES
	('123', 0, 15, '2023-05-02 10:41:49'),
	('a', 2, 0, '2023-04-26 23:21:02'),
	('aaa', 3, 18, '2023-04-26 23:09:49'),
	('afafaaffa', 0, 3, '2023-04-27 13:38:20'),
	('da', 0, 31, '2023-04-27 13:11:54'),
	('dâdadad', 0, 2, '2023-04-27 13:37:47'),
	('đạt', 7, 72, '2023-04-27 11:21:02'),
	('Đạt Thường Tín', 11, 47, '2023-04-25 17:32:03'),
	('fff', 0, 31, '2023-04-27 13:13:44'),
	('hiep', 7, 40, '2023-04-26 13:05:51'),
	('hoang', 3, 34, '2023-04-27 12:42:31'),
	('Hoang ha', 3, 99, '2023-04-27 13:02:04'),
	('stop', 1, 5, '2023-04-26 13:41:19'),
	('sy', 0, 19, '2023-04-27 13:09:03'),
	('Thắng cá chép', 11, 83, '2023-04-27 10:12:54'),
	('Thành Đạt', 4, 5, '2023-04-25 17:19:58'),
	('tiến đạt', 5, 53, '2023-04-27 11:23:37'),
	('Văn Hoàn', 0, 31, '2023-05-02 12:01:47'),
	('Văn Hoàn đẹp zai', 2, 10, '2023-04-25 17:19:58'),
	('vh19', 2, 9, '2023-04-26 13:36:49'),
	('Việt Hoàng ngu', 3, 9, '2023-04-25 17:19:58'),
	('Việt Hoàng nổ', 8, 57, '2023-04-26 23:13:50');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
