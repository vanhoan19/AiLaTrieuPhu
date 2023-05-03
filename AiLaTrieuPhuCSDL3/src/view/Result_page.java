package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ResultPageController;
import model.AmThanh;
import model.NguoiChoi;

public class Result_page extends JFrame{
	private NguoiChoi nguoiChoi;
	private JButton jButton_tiepTuc;
	private JButton jButton_thoat;
	private JButton jButton_banhRank;
	private JButton jButton_trangChu;
	
	public Result_page(NguoiChoi nguoiChoi) {
		this.nguoiChoi = nguoiChoi;
		this.init(nguoiChoi);
		this.setVisible(true);
	}

	private void init(NguoiChoi nguoiChoi) {
		ResultPageController resultPageController = new ResultPageController(this);
		this.setTitle("Ai Là triệu phú");
		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.addWindowListener(resultPageController);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		int level = nguoiChoi.getLevel();
		
		AmThanh.clip_giai_thuong.start();
		
		
		this.setLayout(new BorderLayout());
		Font font = new Font("Arial", Font.BOLD, 20);
		
		Border border = BorderFactory.createEmptyBorder(100, 50, 100, 50);
		
		Color color_result = new Color(255 , 127, 0);
		
		JLabel jLabel_chucMung = new JLabel("Chúc mừng " + nguoiChoi.getUserName() + " đã chiến thắng trong chương trình Ai Là Triệu Phú");
		jLabel_chucMung.setFont(font);
		jLabel_chucMung.setForeground(color_result);
		
		JLabel jLabel_soCau = new JLabel("Bạn đã vượt qua câu hỏi số : " + String.valueOf(level - 1));
		jLabel_soCau.setFont(font);
		jLabel_soCau.setForeground(color_result);
		
		JLabel jLabel_tienThuong = new JLabel("Bạn nhận được số điểm là: " + String.valueOf(NguoiChoi.levels[level-1]));
		jLabel_tienThuong.setFont(font);
		jLabel_tienThuong.setForeground(color_result);
		
		JLabel jLabel_thoiGian = new JLabel("Tổng thời gian bạn đã sử dụng là: " + nguoiChoi.getTimes() + " giây");
		jLabel_thoiGian.setFont(font);
		jLabel_thoiGian.setForeground(color_result);
		
		jButton_trangChu = new JButton("Trang chủ");
		jButton_trangChu.setFont(font);
		jButton_trangChu.setForeground(Color.RED);
		jButton_trangChu.addActionListener(resultPageController);
		
		jButton_tiepTuc = new JButton("Tiếp tục");
		jButton_tiepTuc.setFont(font);
		jButton_tiepTuc.setForeground(Color.RED);
		jButton_tiepTuc.addActionListener(resultPageController);
		
		jButton_thoat = new JButton("Thoát");
		jButton_thoat.setFont(font);
		jButton_thoat.setForeground(Color.RED);
		jButton_thoat.addActionListener(resultPageController);
		
		jButton_banhRank = new JButton("Bảng xếp hạng");
		jButton_banhRank.setFont(font);
		jButton_banhRank.setForeground(Color.RED);
		jButton_banhRank.addActionListener(resultPageController);
		
		JPanel jPanel_group_buttons = new JPanel(new FlowLayout());
		jPanel_group_buttons.add(jButton_trangChu);
		jPanel_group_buttons.add(jButton_tiepTuc);
		jPanel_group_buttons.add(jButton_banhRank);
		jPanel_group_buttons.add(jButton_thoat);
		
		JPanel jPanel_khungKetQua = new JPanel(new GridLayout(4, 1, 20, 20));
		jPanel_khungKetQua.setBorder(border);
		
		jPanel_khungKetQua.add(jLabel_chucMung);
		jPanel_khungKetQua.add(jLabel_soCau);
		jPanel_khungKetQua.add(jLabel_thoiGian);
		jPanel_khungKetQua.add(jLabel_tienThuong);
		
		this.add(jPanel_khungKetQua, BorderLayout.CENTER);
		this.add(jPanel_group_buttons, BorderLayout.SOUTH);
		this.pack();
	}

	public JButton getjButton_tiepTuc() {
		return jButton_tiepTuc;
	}

	public JButton getjButton_thoat() {
		return jButton_thoat;
	}
	
	public JButton getjButton_banhRank() {
		return jButton_banhRank;
	}

	public JButton getjButton_trangChu() {
		return jButton_trangChu;
	}
	public void close() {
		this.setVisible(false);
	}
	
	public void open() {
		this.setVisible(true);
	}

	public NguoiChoi getNguoiChoi() {
		return nguoiChoi;
	}

	public void setNguoiChoi(NguoiChoi nguoiChoi) {
		this.nguoiChoi = nguoiChoi;
	}
}
