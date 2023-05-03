package model;

import java.util.ArrayList;

import dao.nguoiChoiDAO;

public class DanhSachNguoiChoi {
	private static NguoiChoi[] danhSaNguoiChoi;
	private static int count = 0;
	
	public DanhSachNguoiChoi() {
		count = 0;
		danhSaNguoiChoi = new NguoiChoi[55];
		ArrayList<NguoiChoi> danhSach = nguoiChoiDAO.getInstance().selectAll();
		for(NguoiChoi nguoiChoi : danhSach)
		{
			if (count >= 50) break;
			nguoiChoi.setSTT(count + 1);
			danhSaNguoiChoi[count++] = nguoiChoi;
		}
	}
	
	public static NguoiChoi[] getDanhSachNguoiChoi() {
		return danhSaNguoiChoi;
	}
	
	public static int getCount() {
		return count;
	}
}
