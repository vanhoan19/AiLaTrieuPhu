package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.BangRank_page;
import view.Play_page;
import view.Start_page;

public class BangRankPageController implements ActionListener, WindowListener{
	private BangRank_page bangRank;
	
	public BangRankPageController(BangRank_page bangRank)
	{
		this.bangRank = bangRank;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		if (src.equals("Trang chủ"))
		{
			bangRank.setVisible(false);
			new Start_page();
		}
		else if (src.equals("Tiếp tục"))
		{
			bangRank.setVisible(false);
			new Play_page(bangRank.getNguoiChoi().getUserName());
		}
		else if (src.equals("Thoát"))
		{
			System.exit(0);
		}
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

}
