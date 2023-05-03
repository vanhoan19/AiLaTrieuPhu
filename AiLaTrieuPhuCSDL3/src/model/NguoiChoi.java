package model;

import java.util.Date;

import dao.cauHoiDAO;

public class NguoiChoi {
	private int STT;
	private String userName;
	private CauHoi dsCH[];
	private Help helps;
	private int times;
	private int level; // levels đạt được
	private static boolean isOnPlay;
	public static int levels[] = new int[] {0, 200, 400, 600, 1000, 2000, 3000, 6000, 10000, 14000, 22000, 30000, 40000, 60000, 85000, 150000};
	private String dateTime;
	
	public NguoiChoi() {
		this.dsCH = new CauHoi[16];
		this.helps = new Help();
		this.isOnPlay = true;
		this.level = 1;
		this.times = 0;
	}
	
	public NguoiChoi(String userName) {
		this.userName = userName;
		this.dsCH = new CauHoi[16];
		this.helps = new Help();
		this.level = 1;
		this.times = 0;
		this.isOnPlay = true;
		this.dsCH[1] = cauHoiDAO.getInstance().selectById1(25);
		System.out.println(this.dsCH[1]);
		for(int i = 2; i <= 15; i++)
			this.dsCH[i] = DanhSachCauHoi.sinhCauHoi(i);
	}
	
	public NguoiChoi(String userName, int level, int times, String dateTime)
	{
		this.userName = userName;
		this.level = level;
		this.times = times;
		this.dateTime = dateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public CauHoi[] getDsCH() {
		return dsCH;
	}

	public void setDsCH(CauHoi[] dsCH) {
		this.dsCH = dsCH;
	}
	
	public CauHoi getCauHoi(int i) {
		return this.dsCH[i];
	}
	
	public void setCauHoi(int i, CauHoi cauHoi) {
		this.dsCH[i] = cauHoi;
	}

	public Help getHelps() {
		return helps;
	}

	public void setHelps(Help helps) {
		this.helps = helps;
	}

	public boolean isOnPlay() {
		return isOnPlay;
	}

	public void setOnPlay(boolean isOnPlay) {
		NguoiChoi.isOnPlay = isOnPlay;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void increaseLevel() {
		this.level++;
	}
	
	public void increaseTime() {
		this.times++;
	}
	
	public CauHoi getCauHoiHienTai() {
		return dsCH[this.level];
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public int getSTT() {
		return STT;
	}

	public void setSTT(int sTT) {
		STT = sTT;
	}
	
}
