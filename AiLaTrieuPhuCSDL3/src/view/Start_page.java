package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.StartPageController;
import model.AmThanh;
import model.DanhSachCauHoi;

public class Start_page extends JFrame{
	private BackgroundImage background;
	private JButton button_start;
	private JTextField userName;
	
	public Start_page() {
		StartPageController startPageListener = new StartPageController(this);
		
		this.setTitle("Ai Là triệu phú");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.addWindowListener(startPageListener);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		
		// Set Font
		Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
		
		// Tạo background
		URL imageURL = getClass().getResource("/assets/AiLaTrieuPhuPlayPicture.png");
		background = new BackgroundImage(imageURL);
		background.setLayout(new GridLayout(7, 5, 10, 10));
		
		// Tạo button
		imageURL = getClass().getResource("/assets/play.png");
		ImageIcon imageIcon_play = new ImageIcon(imageURL);
		button_start = new JButton("Sẵn sàng", imageIcon_play);
		button_start.setFont(font);
		button_start.setForeground(new Color(3, 151, 244));
		button_start.setVerticalTextPosition(SwingConstants.BOTTOM);
		button_start.setHorizontalTextPosition(SwingConstants.CENTER);
		button_start.setMargin(new Insets(10, 5, 10, 5));
		button_start.setBorderPainted(false);
		button_start.setBackground(Color.PINK);
		button_start.addActionListener(startPageListener);
		
		for (int i = 1; i <= 35; i++)
		{
			if (i == 28) {
				background.add(button_start);
			}
			else if (i == 18) {
				JPanel jPanel = new JPanel(new GridLayout(2, 1, 10, 10));
				
				JLabel jLabel_nhapTen = new JLabel("Mời nhập tên:");
				jLabel_nhapTen.setFont(font);
				jLabel_nhapTen.setHorizontalAlignment(JLabel.CENTER);
				
				userName = new JTextField();
				userName.setFont(new Font("Arial", Font.ITALIC, 20));
				userName.setMargin(new Insets(0, 15, 0, 15));
				userName.setForeground(Color.BLUE);
				userName.setHorizontalAlignment(JTextField.CENTER);
				userName.addKeyListener(startPageListener);
				
				jPanel.add(jLabel_nhapTen);
				jPanel.add(userName);
				
				background.add(jPanel);
			} 
			else {
				JLabel jLabel = new JLabel();
				background.add(jLabel);
			}
		}
		
		this.add(background);
		this.setVisible(true);
		
		new AmThanh();
		AmThanh.clip_bat_dau.loop(1000);
	}

	public JButton getButton_start() {
		return button_start;
	}

	public void setButton_start(JButton button_start) {
		this.button_start = button_start;
	}

	public JTextField getUserName() {
		return userName;
	}

	public void setUserName(JTextField userName) {
		this.userName = userName;
	}
	
}
