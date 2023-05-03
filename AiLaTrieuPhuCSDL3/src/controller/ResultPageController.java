package controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.AmThanh;
import model.NguoiChoi;
import view.BangRank_page;
import view.Play_page;
import view.Result_page;
import view.Start_page;

public class ResultPageController implements ActionListener, WindowListener{
	private Result_page result_page;
	public ResultPageController(Result_page result_page) {
		this.result_page = result_page;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(result_page.getjButton_thoat()))
		{
			AmThanh.clip_giai_thuong.stop();
			result_page.close();
			System.exit(0);
		}
		else if (e.getSource().equals(result_page.getjButton_tiepTuc())) {
			AmThanh.clip_giai_thuong.stop();
			result_page.close();
			new Play_page(result_page.getNguoiChoi().getUserName());
		}
		else if (e.getSource().equals(result_page.getjButton_banhRank())) {
			AmThanh.clip_giai_thuong.stop();
			result_page.close();
			new BangRank_page(result_page.getNguoiChoi());
		}
		else if (e.getSource().equals(result_page.getjButton_trangChu())) {
			AmThanh.clip_giai_thuong.stop();
			result_page.close();
			new Start_page();
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
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
