package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.CauHoi;
import model.NguoiChoi;

public class cauHoiDAO implements DAOInterface<CauHoi>{
	
	public static cauHoiDAO getInstance() {
		return new cauHoiDAO();
	}
	@Override
	public int insert(CauHoi t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL 
			Connection connection = JDBCUtil.getConnection1();
			
			// Bước 2: tạo ra đối tượng Statement
			Statement statement = connection.createStatement();
			
			// Bước 3: Thực thi câu lệnh
			String sql = "INSERT INTO cauhoi(NoiDung, DapAn_A, DapAn_B, DapAn_C, DapAn_D, DapAnDung, Level) "
						+ "VALUES ('" + t.getNoiDung() + "', '"  + t.getDapAn(0) + "', '"  + t.getDapAn(1) + "', '" 
						+ t.getDapAn(2) + "', '"  + t.getDapAn(3) + "', '" + t.getDapAnDung() + "' , " + t.getLevel()+")";
			ketQua = statement.executeUpdate(sql);
			
			System.out.println("Bạn đã thực thi SQL " + sql);
			System.out.println("Số dòng bị t hay đôi là: " + ketQua);
			
			// Bước 5: 
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ketQua;
	}

	@Override
	public int update(CauHoi t) {
		int ketQua = 0;
//		try {
//			// Bước 1: tạo kết nối đến CSDL 
//			Connection connection = JDBCUtil.getConnection1();
//			
//			// Bước 2: tạo ra đối tượng Statement
//			Statement statement = connection.createStatement();
//			
//			// Bước 3: Thực thi câu lệnh
//			String sql = "UPDATE cauhoi "
//						+ "SET "
//						+ "NoiDung = '" + t.getNoiDung() + "'"
//						+ ", DapAn_A = '" + t.getDsDapAn(0) + "'" 
//						+ ", DapAn_B = '" + t.getDsDapAn(1) + "'" 
//						+ ", DapAn_C = '" + t.getDsDapAn(2) + "'" 
//						+ ", DapAn_D = '" + t.getDsDapAn(3) + "'" 
//						+ ", DapAnDung = '" + t.getDapAnDung() + "'"
//						+ ", Level = " + t.getLevel()
//						+ " WHERE ID = " + t.getID();
//			ketQua = statement.executeUpdate(sql);
//			
//			System.out.println("Bạn đã thực thi SQL " + sql);
//			System.out.println("Số dòng bị t hay đôi là: " + ketQua);
//			
//			// Bước 5: 
//			JDBCUtil.closeConnection(connection);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
		return ketQua;
	}

	@Override
	public int delete(CauHoi t) {
		int ketQua = 0;
//		try {
//			// Bước 1: tạo kết nối đến CSDL 
//			Connection connection = JDBCUtil.getConnection1();
//			
//			// Bước 2: tạo ra đối tượng Statement
//			Statement statement = connection.createStatement();
//			
//			// Bước 3: Thực thi câu lệnh
//			String sql = "DELETE from cauhoi"
//						+ " WHERE ID = " + t.getID();
//			ketQua = statement.executeUpdate(sql);
//			
//			System.out.println("Bạn đã thực thi SQL " + sql);
//			System.out.println("Số dòng bị t hay đôi là: " + ketQua);
//			
//			// Bước 5: 
//			JDBCUtil.closeConnection(connection);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} 
		return ketQua;
	}

	@Override
	public ArrayList<CauHoi> selectAll() {
		ArrayList<CauHoi> ketQua = new ArrayList<CauHoi>();
		try {
			// Bước 1: tạo kết nối đến CSDL 
			Connection connection = JDBCUtil.getConnection1();
			
			// Bước 2: tạo ra đối tượng Statement
			Statement statement = connection.createStatement();
			
			// Bước 3: Thực thi câu lệnh
			String sql = "SELECT * from cauhoi";
			ResultSet kq = statement.executeQuery(sql);
			
//			System.out.println("Bạn đã thực thi SQL " + sql);
//			System.out.println("Số dòng bị t hay đôi là: " + ketQua);
			
			// Bước 4:
			while(kq.next())
			{
				String noiDung = kq.getString("NoiDung");
				String DapAn_A = kq.getString("DapAn_A");
				String DapAn_B = kq.getString("DapAn_B");
				String DapAn_C = kq.getString("DapAn_C");
				String DapAn_D = kq.getString("DapAn_D");
				String DapAnDung = kq.getString("DapAnDung");
				int Level = kq.getInt("Level");
				int ID = kq.getInt("ID");
				CauHoi cauHoi = new CauHoi(noiDung, DapAn_A, DapAn_B, DapAn_C, DapAn_D, DapAnDung, Level, ID);
				ketQua.add(cauHoi);
			}
			
			// Bước 5: 
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ketQua;
	}

	@Override
	public CauHoi selectById(CauHoi t) {
		return null;
	}
	
	public CauHoi selectById1(int ID) {
		// TODO Auto-generated method stub
		CauHoi cauhoi = null;
		try {
			// Bước 1: Kết nối đến CSDL
			Connection connection = JDBCUtil.getConnection1();
			
			// Bước 2: Tạo ra đối tượng Statement
			Statement statement = connection.createStatement();
			
			// Bước 3: Thực thi câu lệnh
			String sql = "SELECT * FROM cauhoi WHERE ID = " + ID ;
			ResultSet kq = statement.executeQuery(sql);
			System.out.println(kq);
			
			// Bước 4: Lấy dữ liệu
			while(kq.next()) 
			{
				String noidung = kq.getString("NoiDung");
				String dapAn_A = kq.getString("DapAn_A");
				String dapAn_B = kq.getString("DapAn_B");
				String dapAn_C = kq.getString("DapAn_C");
				String dapAn_D = kq.getString("DapAn_D");
				String dapAnDung = kq.getString("DapAnDung");
				int level = kq.getInt("Level");
				int ID1 = kq.getInt("ID");
				cauhoi = new CauHoi(noidung, dapAn_A, dapAn_B, dapAn_C, dapAn_D, dapAnDung, level, ID1);
				System.out.println("Cau hoi dao " + cauhoi);
			}
			
			// Bước 5: Ngắt kết nối đến CSDL
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cauhoi;
	}

	@Override
	public ArrayList<CauHoi> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
