package model;

import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import dao.cauHoiDAO;

public class DanhSachCauHoi {
	private static CauHoi[][] danhSachCauHoi;
	private static int count[];
	
	public DanhSachCauHoi() {
		danhSachCauHoi = new CauHoi[16][1000];
		count = new int[16];
		Arrays.fill(count, 0);
		ArrayList<CauHoi> kq = cauHoiDAO.getInstance().selectAll();
		for (CauHoi cauHoi : kq) {
			int level = cauHoi.getLevel();
			danhSachCauHoi[level][count[level]++] = cauHoi;
		}
	}
	public static CauHoi[][] getDanhSachCauHoi() {
		return danhSachCauHoi;
	}
	
	public static CauHoi sinhCauHoi(int i) // i là level
	{
		Random random = new Random();
		int stt = random.nextInt(count[i]);
		return danhSachCauHoi[i][stt];
	}
	
	public static CauHoi sinhThemCauHoi(CauHoi hienTai, int i) // i là level
	{
		Random random = new Random();
		int stt;
		do {
			stt = random.nextInt(count[i]);
		} while (danhSachCauHoi[i][stt].getID() == hienTai.getID());
		return danhSachCauHoi[i][stt];
	}
}
