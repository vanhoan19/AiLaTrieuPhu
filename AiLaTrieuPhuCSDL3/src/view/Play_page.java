package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.Timer;

import controller.PlayPageController;
import dao.nguoiChoiDAO;
import model.AmThanh;
import model.CauHoi;
import model.DanhSachCauHoi;
import model.NguoiChoi;

public class Play_page extends JFrame{
	
	private NguoiChoi nguoiChoi;
	private JTextArea cauHoi;
	private JLabel jLabel_time;
	private JButton jButton_stop;
	private JButton jButton_50_50;
	private JButton jButton_phone;
	private JButton jButton_khan_gia;
	private JButton jButton_doi_cau_hoi;
	private JButton[] jButtons_dapAns;
	private JLabel[] jLabel_levels;
	
	private Timer timer_thoiGianChay, timer_dapAn;
	private boolean isThoiGianChay, isDapAn;
	
	public Play_page(String userName) {
		nguoiChoi = new NguoiChoi(userName);
		this.init(userName);
		this.xuli(1);
	}

	public void init(String userName) {
		this.setTitle("Ai Là triệu phú");
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout(10, 10));
		JPanel jPanel_container = new JPanel(new BorderLayout());
		Font font = new Font("Arial", Font.CENTER_BASELINE, 20);
		
		Border border = BorderFactory.createLineBorder(Color.RED, 2);
		
		PlayPageController playPageController = new PlayPageController(this);
		
		// Thời gian chạy
		jLabel_time = new JLabel("30");
		jLabel_time.setFont(font);
		jLabel_time.setBorder(null);
		jLabel_time.setBorder(border);
		jLabel_time.setHorizontalAlignment(JLabel.CENTER);
		
		// Nút dừng lại
		jButton_stop = new JButton();
		URL imageURL = getClass().getResource("/assets/stop.png");
		ImageIcon img_stop = new ImageIcon(imageURL);
		jButton_stop.setIcon(img_stop);
		jButton_stop.setBorderPainted(false);
		jButton_stop.setBackground(new Color(166, 37, 25));
		jButton_stop.setToolTipText("Dừng lại");
		jButton_stop.addActionListener(playPageController);
//		jButton_stop.setEnabled(false);

		// Các quyền trợ giúp
		jButton_50_50 = new JButton();
		imageURL = getClass().getResource("/assets/5050.png");
		ImageIcon img_50_50 = new ImageIcon(imageURL);
		jButton_50_50.setIcon(img_50_50);
		jButton_50_50.setToolTipText("50/50");
		jButton_50_50.addActionListener(playPageController);
		
		jButton_phone = new JButton();
		imageURL = getClass().getResource("/assets/phone.png");
		ImageIcon img_phone = new ImageIcon(imageURL);
		jButton_phone.setIcon(img_phone);
		jButton_phone.setToolTipText("Gọi điện thoại cho người thân");
		jButton_phone.addActionListener(playPageController);
		
		jButton_khan_gia = new JButton();
		imageURL = getClass().getResource("/assets/toTuVan.png");
		ImageIcon img_khan_gia = new ImageIcon(imageURL);
		jButton_khan_gia.setIcon(img_khan_gia);
		jButton_khan_gia.setToolTipText("Hỏi ý kiến khán giả trong trường quay");
		jButton_khan_gia.addActionListener(playPageController);

		jButton_doi_cau_hoi = new JButton();
		imageURL = getClass().getResource("/assets/changeCauHoi.png");
		ImageIcon img_doi_cau_hoi = new ImageIcon(imageURL);
		jButton_doi_cau_hoi.setIcon(img_doi_cau_hoi);
		jButton_doi_cau_hoi.setToolTipText("Đổi câu hỏi khác");		
		jButton_doi_cau_hoi.addActionListener(playPageController);
		
		// Các quyền trợ giúp + thời gian
		JPanel jPanel_left = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(10, 10, 10, 10);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		jPanel_left.add(jLabel_time, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 0;
		c.gridheight = 1;
		jPanel_left.add(new JLabel(), c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		jPanel_left.add(jButton_50_50, c);
		
		c.gridx = 0;
		c.gridy = 3;
		jPanel_left.add(jButton_phone, c);

		c.gridx = 0;
		c.gridy = 4;
		jPanel_left.add(jButton_khan_gia, c);
		
		c.gridx = 0;
		c.gridy = 5;
		jPanel_left.add(jButton_doi_cau_hoi, c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 0;
		c.gridheight = 1;
		jPanel_left.add(new JLabel(), c);
		
		c.gridx = 0;
		c.gridy = 8;
		jPanel_left.add(jButton_stop, c);
		
		jPanel_left.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		// Nội dung + đáp án
		JPanel jPanel_center = new JPanel(new GridLayout(2, 1, 30, 30));
		
		JPanel jPanel_center_top = new JPanel(new GridLayout(1, 3, 10, 10)); 
		
		imageURL = getClass().getResource("/assets/ảnh nền.jpg");
		BackgroundImage_play background_center_top = new BackgroundImage_play(imageURL);
		
		JPanel jPanel_empty = new JPanel();
		
		jPanel_center_top.add(background_center_top);
		
		JPanel jPanel_center_bottom = new JPanel(new GridLayout(2, 1, 30, 30));
		cauHoi = new JTextArea("Câu hỏi");
		cauHoi.setFont(font);
		cauHoi.setLineWrap(true);
		cauHoi.setWrapStyleWord(true);
		cauHoi.setEditable(false);
		JScrollPane jScrollPane = new JScrollPane(cauHoi);
		cauHoi.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		JPanel jPanel_dapAn = new JPanel(new GridLayout(2, 2, 50,20));
		
		jButtons_dapAns = new JButton[4];
		for (int i = 0; i < 4; i++) {
			jButtons_dapAns[i] = new JButton();
			jButtons_dapAns[i].setFont(font);
			jButtons_dapAns[i].setHorizontalAlignment(JButton.LEFT);
			jButtons_dapAns[i].addActionListener(playPageController);
			jButtons_dapAns[i].setVisible(false);
			jPanel_dapAn.add(jButtons_dapAns[i]);
		}
		
		jPanel_center_bottom.add(cauHoi);
		jPanel_center_bottom.add(jPanel_dapAn);
		
		jPanel_center.add(jPanel_center_top);
		jPanel_center.add(jPanel_center_bottom);
		jPanel_center.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		// Mưc dộ câu hỏi và username
		JPanel jPanel_right = new JPanel(new BorderLayout(10, 30));
		JPanel jPanel_user = new JPanel(new FlowLayout());
		JPanel jPanel_levels = new JPanel(new GridLayout(15, 1, 10, 10));
		
		jLabel_levels = new JLabel[16];
		for (int i = 15; i > 0; i--) 
		{
			jLabel_levels[i] = new JLabel(" " + i + ". " + NguoiChoi.levels[i]);
			jLabel_levels[i].setFont(font);
			jLabel_levels[i].setMinimumSize(new Dimension(200, 500));
			jPanel_levels.add(jLabel_levels[i]);
		}
		jPanel_levels.setBorder(BorderFactory.createLineBorder(new Color(3, 151, 244), 1, true));
		
		// UserName
		JLabel jPanel_img_user = new JLabel();
		imageURL = getClass().getResource("/assets/user.png");
		ImageIcon img_user = new ImageIcon(imageURL);
		jPanel_img_user.setHorizontalAlignment(JLabel.LEFT);
		jPanel_img_user.setIcon(img_user);
		JLabel jLabel_username = new JLabel(userName);
		jLabel_username.setFont(new Font("Arial" , Font.BOLD, 15));
		jLabel_username.setForeground(new Color(3, 151, 244));
		jPanel_user.add(jPanel_img_user);
		jPanel_user.add(jLabel_username);
		
		jPanel_right.add(jPanel_user, BorderLayout.NORTH);
		jPanel_right.add(jPanel_levels, BorderLayout.CENTER);
		jPanel_right.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		
		jPanel_container.add(jPanel_left, BorderLayout.WEST);
		jPanel_container.add(jPanel_center, BorderLayout.CENTER);
		jPanel_container.add(jPanel_right, BorderLayout.EAST);

		this.add(jPanel_container);
		this.addWindowListener(playPageController);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void xuli(int level) {
			if (level > 15) 
			{
				setVisible(false);
				new Result_page(nguoiChoi);
				return;
			}
		
			CauHoi cauHoiHienTai = nguoiChoi.getCauHoiHienTai();
			System.out.println("cauhoi = " + cauHoiHienTai);
			cauHoi.setText(cauHoiHienTai.getNoiDung());
			
			themBackGroundChoLevel(level);
			
			if (isDapAn) timer_dapAn.stop();
			if (isThoiGianChay) timer_thoiGianChay.stop();
			
			isDapAn = true; 
			isThoiGianChay = true;
			
			timer_dapAn = new Timer(1000, new ActionListener() {
				int i = 0;
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if (i <= 3)
					{
						jButtons_dapAns[i].setText(CauHoi.nhanDapAn(i) + ". " + cauHoiHienTai.getDapAn(i));
						jButtons_dapAns[i].setToolTipText(cauHoiHienTai.getDapAn(i));
						jButtons_dapAns[i].setVisible(true);
						i++;
					}
					if (i == 4) 
					{
						AmThanh.clip_dem_nguoc.start();
						isDapAn = false;
						timer_dapAn.stop();
						timer_thoiGianChay = new Timer(1000, new ActionListener() {
							int secondLeft = 30;
							@Override
							public void actionPerformed(ActionEvent e) {
								AmThanh.clip_dem_nguoc.setMicrosecondPosition(0);
								secondLeft--;
								nguoiChoi.increaseTime();
								jLabel_time.setText(String.valueOf(secondLeft));
								
								if (secondLeft == -1) 
								{
									timer_thoiGianChay.stop();
									AmThanh.clip_dem_nguoc.stop();
									try {
										AmThanh.clip_het_gio.start();
										Thread.sleep(3000);
									} catch (InterruptedException e1) {
										e1.printStackTrace();
									}
									AmThanh.clip_het_gio.stop();
									setVisible(false);
									upDateBangRank();
									new Result_page(nguoiChoi);
								}
							}
						});
						timer_thoiGianChay.start();
					}
				}
			});
			timer_dapAn.start();
	}

	public NguoiChoi getNguoiChoi() {
		return nguoiChoi;
	}

	public void setNguoiChoi(NguoiChoi nguoiChoi) {
		this.nguoiChoi = nguoiChoi;
	}

	public JTextArea getCauHoi() {
		return cauHoi;
	}

	public JLabel getjLabel_time() {
		return jLabel_time;
	}
	
	public JButton getjButton_stop() {
		return jButton_stop;
	}

	public JButton getjButton_50_50() {
		return jButton_50_50;
	}

	public JButton getjButton_phone() {
		return jButton_phone;
	}
	
	public JButton getjButton_khan_gia() {
		return jButton_khan_gia;
	}

	public JButton getjButton_doi_cau_hoi() {
		return jButton_doi_cau_hoi;
	}

	public JButton[] getjButtons_dapAns() {
		return jButtons_dapAns;
	}

	public JLabel[] getjLabel_levels() {
		return jLabel_levels;
	}

	public JButton getjButtons_dapAns(int i) {
		return jButtons_dapAns[i];
	}

	public Timer getTimer_thoiGianChay() {
		return timer_thoiGianChay;
	}

	public Timer getTimer_dapAn() {
		return timer_dapAn;
	}

	public boolean isThoiGianChay() {
		return isThoiGianChay;
	}

	public boolean isDapAn() {
		return isDapAn;
	}
	
	public void setMauChuChoCauDung(int i) {
		jLabel_levels[i].setForeground(Color.YELLOW);
		jLabel_levels[i].setBackground(Color.GREEN);
		jLabel_levels[i].setOpaque(true);
	}
	
	public void themBackGroundChoLevel(int i) {
		jLabel_levels[i].setForeground(Color.WHITE);
		jLabel_levels[i].setBackground(Color.BLUE);
		jLabel_levels[i].setOpaque(true);
	}
	
	public void reset() {
		for (int i = 0; i < 4; i++) 
		{
			jButtons_dapAns[i].setText("");
			jButtons_dapAns[i].setBorderPainted(true);
			jButtons_dapAns[i].setBackground(null);
			jButtons_dapAns[i].setForeground(Color.BLACK);
			jButtons_dapAns[i].setEnabled(true);
			jButtons_dapAns[i].setVisible(false);
		}
		jLabel_time.setText("30");
	}
	
	public void setBackGroundDapAnDung(JButton jButton) {
		jButton.setBorderPainted(false);
		jButton.setBackground(Color.GREEN);
		jButton.setForeground(Color.YELLOW);
		
	}
	
	public void setBackGroundDapAnSai(JButton jButton) {
		jButton.setBorderPainted(false);
		jButton.setBackground(Color.RED);
		jButton.setForeground(Color.WHITE);
	}
	
	public void setDisableDapAn() {
		for (int i = 0; i < 4; i++)
		{
			jButtons_dapAns[i].setEnabled(false);
		}
	}
	
	public void setDapAnChon(JButton jButton) {
		jButton.setBorderPainted(false);
		jButton.setBackground(Color.BLUE);
	}
	
	public void upDateBangRank() {
		NguoiChoi nguoiChoiMoi = nguoiChoi;
		NguoiChoi nguoiChoiCu = nguoiChoiDAO.getInstance().selectById(nguoiChoiMoi);
		if (nguoiChoiCu != null)
		{
			boolean kt1 = (nguoiChoiMoi.getLevel() > nguoiChoiCu.getLevel());
			boolean kt2 = ((nguoiChoiMoi.getLevel() == nguoiChoiCu.getLevel()) && (nguoiChoiMoi.getTimes() < nguoiChoiCu.getTimes()));
			if (kt1 || kt2) nguoiChoiDAO.getInstance().update(nguoiChoiMoi);
		}
		else nguoiChoiDAO.getInstance().insert(nguoiChoi);
	}
}
