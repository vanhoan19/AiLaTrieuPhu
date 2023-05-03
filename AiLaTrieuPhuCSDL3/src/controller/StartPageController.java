package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.AmThanh;
import model.DanhSachCauHoi;
import view.Play_page;
import view.Start_page;

public class StartPageController implements ActionListener, KeyListener, WindowListener{
	private Start_page start_page;
	
	public StartPageController(Start_page start_page) {
		this.start_page = start_page;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(start_page.getButton_start())) xu_li_nhap_ten();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) xu_li_nhap_ten();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Bạn có chắc chắn muốn thoát chương trình?");
		label.setFont(new Font("Arial", Font.ITALIC, 15));
		panel.add(label);
		int result = JOptionPane.showOptionDialog(null, panel, "Xác nhận dừng lại",
		    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
		    null, new String[] { "Đồng ý", "Hủy bỏ" }, null);
		if (result == JOptionPane.OK_OPTION) {
			System.exit(0);
		} else {
			JOptionPane.getRootFrame().dispose();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void xu_li_nhap_ten() {
		String userName = start_page.getUserName().getText().trim();
		if (userName.equals("")) {
			JOptionPane.showMessageDialog(start_page,
				    "Bạn cần nhập tên để chơi",
				    "Lỗi nhập tên",
				    JOptionPane.ERROR_MESSAGE);
		}
		else if (userName.length() > 25)
		{
			JOptionPane.showMessageDialog(start_page,
				    "Tên người chơi không được vượt quá 30 kí tự",
				    "Lỗi nhập tên",
				    JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			DanhSachCauHoi danhSachCauHoi = new DanhSachCauHoi();
			new Play_page(userName);
			start_page.setVisible(false);
			AmThanh.clip_bat_dau.stop();
		}
	}
}
