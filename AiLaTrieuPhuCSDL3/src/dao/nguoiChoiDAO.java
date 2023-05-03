package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import database.JDBCUtil;
import model.NguoiChoi;

public class nguoiChoiDAO implements DAOInterface<NguoiChoi>{
	
	public static nguoiChoiDAO getInstance() {
		return new nguoiChoiDAO();
	}
	
	@Override
	public int insert(NguoiChoi t) {
		int kq = 0;
		// Bước 1: Tạo connection với SQL
		try {
			Connection connection = JDBCUtil.getConnection1();
			
			// Bước 2: Tạo Statement
			Statement statement = connection.createStatement();
			
			// Bước 3: Thực thi câu lệnh
			String sql = "INSERT INTO nguoichoi "
					+ "VALUES ('" + t.getUserName() + "', " + (t.getLevel() - 1) + ", " + t.getTimes() + ", NOW())";
			kq = statement.executeUpdate(sql);
			System.out.println(kq);
			
			// Bước 4: 
			JDBCUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int update(NguoiChoi t) {
		int kq = 0;
		// Bước 1: Tạo connection với SQL
		try {
			Connection connection = JDBCUtil.getConnection1();
			
			// Bước 2: Tạo Statement
			Statement statement = connection.createStatement();
			
			// Bước 3: Thực thi câu lệnh
			String sql = "UPDATE nguoichoi "
					+ "SET " 
					+ "SOCAU = " + (t.getLevel() - 1) 
					+ ", " + "TONGTHOIGIAN = " + t.getTimes() 
					+ ", " + "THOIGIANTHUC = NOW() "
					+ "WHERE TENNGUOICHOI = '" + t.getUserName() + "'";
			kq = statement.executeUpdate(sql);
			
			// Bước 4: 
			JDBCUtil.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public int delete(NguoiChoi t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<NguoiChoi> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<NguoiChoi> danhsSach = new ArrayList<>();
		try {
			// Bước 1: Kết nối đến CSDL
			Connection connection = JDBCUtil.getConnection1();
			
			// Bước 2: Tạo ra đối tượng Statement
			Statement statement = connection.createStatement();
			
			// Bước 3: Thực thi câu lệnh
			String sql = "SELECT * FROM nguoichoi ORDER BY SOCAU DESC, TONGTHOIGIAN ASC, THOIGIANTHUC ASC, TENNGUOICHOI ASC";
			ResultSet kq = statement.executeQuery(sql);
			
			// Bước 4: Lấy dữ liệu
			while(kq.next()) 
			{
				String userName = kq.getString("TENNGUOICHOI");
				int soCau = kq.getInt("SOCAU");
				int tongSoGiay = kq.getInt("TONGTHOIGIAN");
				String date = kq.getString("THOIGIANTHUC");
			    NguoiChoi nguoiChoi = new NguoiChoi(userName, soCau, tongSoGiay, date);
			    System.out.println(nguoiChoi);
			    danhsSach.add(nguoiChoi);
			}
			
			// Bước 5: Ngắt kết nối đến CSDL
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return danhsSach;
	}

	@Override
	public NguoiChoi selectById(NguoiChoi t) {
		NguoiChoi nguoiChoi = null;
		try {
			// Bước 1: Kết nối đến CSDL
			Connection connection = JDBCUtil.getConnection1();
			
			// Bước 2: Tạo ra đối tượng Statement
			Statement statement = connection.createStatement();
			
			// Bước 3: Thực thi câu lệnh
			String sql = "SELECT * FROM nguoichoi WHERE TENNGUOICHOI = '" + t.getUserName()+ "'";
			ResultSet kq = statement.executeQuery(sql);
			
			// Bước 4: Lấy dữ liệu
			while(kq.next()) 
			{
				String userName = kq.getString("TENNGUOICHOI");
				int soCau = kq.getInt("SOCAU");
				int tongSoGiay = kq.getInt("TONGTHOIGIAN");
				String date = kq.getString("THOIGIANTHUC");
			    nguoiChoi = new NguoiChoi(userName, soCau, tongSoGiay, date);
			}
			
			// Bước 5: Ngắt kết nối đến CSDL
			JDBCUtil.closeConnection(connection);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("selectbyID " + nguoiChoi);
		return nguoiChoi;
	}

	@Override
	public ArrayList<NguoiChoi> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
