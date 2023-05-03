package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import controller.BangRankPageController;
import model.DanhSachNguoiChoi;
import model.NguoiChoi;

public class BangRank_page extends JFrame{
	private NguoiChoi nguoiChoi;
	public BangRank_page(NguoiChoi nguoiChoi) {
		this.nguoiChoi = nguoiChoi;
		new DanhSachNguoiChoi();
		this.init(nguoiChoi);
	}
	public void init(NguoiChoi nguoiChoi) {
		BangRankPageController bangRankPageController = new BangRankPageController(this);
		this.setTitle("Bảng xếp hạng");
		this.setSize(new Dimension(700, 500	));
		this.setLocationRelativeTo(null);
		this.addWindowListener(bangRankPageController);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
		
		// Nút quay về trang chủ
		JPanel jPanel_top = new JPanel(new FlowLayout());
		JButton jButton_trangChu = new JButton("Trang chủ");
		jButton_trangChu.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		jButton_trangChu.setForeground(Color.RED);
		jButton_trangChu.addActionListener(bangRankPageController);
		
		// Nút chơi tiếp
		JButton jButton_choiTiep = new JButton("Tiếp tục");
		jButton_choiTiep.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		jButton_choiTiep.setForeground(Color.RED);
		jButton_choiTiep.addActionListener(bangRankPageController);
		
		// Nút thoát game
		JButton jButton_thoat = new JButton("Thoát");
		jButton_thoat.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
		jButton_thoat.setForeground(Color.RED);
		jButton_thoat.addActionListener(bangRankPageController);
		
		jPanel_top.add(jButton_trangChu);
		jPanel_top.add(jButton_choiTiep);
		jPanel_top.add(jButton_thoat);
		
		JPanel jPanel_center = new JPanel(new BorderLayout());
		
		JLabel jLabel_tenBang = new JLabel("Bảng xếp hạng");
		jLabel_tenBang.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		jLabel_tenBang.setHorizontalAlignment(JLabel.CENTER);
		jLabel_tenBang.setForeground(Color.GREEN);
		
		Object[] columnNames = {"Thứ hạng", "Tên người chơi", "Số câu lớn nhất", "Tổng thời gian", "Thời gian thi"};
		
		NguoiChoi danhSachNguoiChoi[] = DanhSachNguoiChoi.getDanhSachNguoiChoi();
		Object[][] data = new Object[DanhSachNguoiChoi.getCount()][];
		for (int i = 0; i < DanhSachNguoiChoi.getCount(); i++)
		{
			data[i] = new Object[] {danhSachNguoiChoi[i].getSTT(),
					danhSachNguoiChoi[i].getUserName(),
					danhSachNguoiChoi[i].getLevel(),
					danhSachNguoiChoi[i].getTimes(),
					danhSachNguoiChoi[i].getDateTime()};
		}
		
		DefaultTableModel model = new DefaultTableModel(data, columnNames)
			{
				@Override
			    public boolean isCellEditable(int row, int column) {
			        // Không cho phép chỉnh sửa tất cả các ô
			        return false;
			    }
			};
			
		JTable table = new JTable(model);

		Font font_table_content = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		table.setRowHeight(25);
		table.setFont(font_table_content);
		table.setPreferredScrollableViewportSize(new Dimension(500, 25 * 50));
		
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 15));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		jPanel_center.add(jLabel_tenBang, BorderLayout.NORTH);
		jPanel_center.add(scrollPane, BorderLayout.CENTER);
		
		this.setLayout(new BorderLayout(10, 10));
		this.add(jPanel_top, BorderLayout.SOUTH);
		this.add(jPanel_center, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public NguoiChoi getNguoiChoi() {
		return nguoiChoi;
	}
	public void setNguoiChoi(NguoiChoi nguoiChoi) {
		this.nguoiChoi = nguoiChoi;
	}
}
