package Main;

import javax.swing.UIManager;

import model.DanhSachCauHoi;
import view.Start_page;

public class Main {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new DanhSachCauHoi();
			new Start_page();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
