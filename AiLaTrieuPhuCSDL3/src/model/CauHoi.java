package model;

import java.util.Arrays;

public class CauHoi {
	private String noiDung;
	private String dsDapAn[] = new String[4];
	private String dapAnDung;
	private boolean enable[];
	private int level; // từ 1-15
	private int ID;
	
	public CauHoi() {
		
	}
	
	public CauHoi(String noiDung, String A, String B, String C, String D, String dapAnDung, int level) {
		this.noiDung = noiDung;
		this.dsDapAn[0] = A;
		this.dsDapAn[1] = B;
		this.dsDapAn[2] = C;
		this.dsDapAn[3] = D;
		this.dapAnDung = dapAnDung;
		this.enable = new boolean[] {true, true, true, true};
		this.level = level;
	}
	
	public CauHoi(String noiDung, String A, String B, String C, String D, String dapAnDung, int level, int ID) {
		this.noiDung = noiDung;
		this.dsDapAn[0] = A;
		this.dsDapAn[1] = B;
		this.dsDapAn[2] = C;
		this.dsDapAn[3] = D;
		this.dapAnDung = dapAnDung;
		this.enable = new boolean[] {true, true, true, true};
		this.level = level;
		this.ID = ID;
	}

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getDapAn(int i) {
		return dsDapAn[i];
	}

	public void setDsDapAn(String[] dsDapAn) {
		this.dsDapAn = dsDapAn;
	}

	public String getDapAnDung() {
		return dapAnDung;
	}

	public void setDapAnDung(String dapAnDung) {
		this.dapAnDung = dapAnDung;
	}
	
	public boolean getEnable(int i) {
		return this.enable[i];
	}
	
	public void setEnable(int i, boolean tt) {
		this.enable[i] = tt;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getID() {
		return ID;
	}
	
	public static String nhanDapAn(int i) {
		String nhan[] = {"A", "B", "C", "D"};
		return nhan[i];
	}
	
	public int getChiSoDapAnDung() {
		if (dapAnDung.equals("A")) return 0;
		if (dapAnDung.equals("B")) return 1;
		if (dapAnDung.equals("C")) return 2;
		return 3;
	}
	
	public void hienThiDapAn() {
		System.out.println("Cau " + level + ": " + noiDung);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 4; i++) {
			if (this.enable[i]) 
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println((char)('A' + i) + ". " + this.dsDapAn[i]);
				}
		}
	}

	@Override
	public String toString() {
		return "Câu hỏi " + level + ": " + noiDung + "\nA. " + this.dsDapAn[0] + "\nB. " + this.dsDapAn[1] 
				+ "\nC. " + this.dsDapAn[2] + "\nD. " + this.dsDapAn[3] + "\n";
	}
}
