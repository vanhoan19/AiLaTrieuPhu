package model;

import java.util.Arrays;
import java.util.Random;

public class Help {
	private boolean[] helps;
	// 0: 50/50
	// 1: Gọi điện thoại cho người thân
	// 2: Hỏi ý kiến khán giả trong trường quay
	// 3: Đổi câu hỏi khác
	public Help() {
		this.helps = new boolean[] {true, true, true, true};
	}
	public boolean[] getHelps() {
		return helps;
	}
	public boolean getHelp(int i) {
		return helps[i];
	}
	public void setHelps(int i, boolean trangThai) {
		this.helps[i] = trangThai;
	}
	public boolean hasHelp() {
		for (int i = 0; i < 4; i++) {
			if (this.helps[i]) return true;
		}
		return false;
	}
	public String getTenTroGiup(int i) {
		if (i == 0) return "50/50";
		else if (i == 1) return "Gọi điện thoại cho người thân";
		else if (i == 2) return "Hỏi ý kiến khán giả trong trường quay";
		else return "Đổi câu hỏi khác";
	}
}
