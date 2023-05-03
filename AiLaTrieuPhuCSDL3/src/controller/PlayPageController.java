package controller;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import com.mysql.cj.protocol.a.result.ResultsetRowsStatic;

import dao.nguoiChoiDAO;
import model.AmThanh;
import model.CauHoi;
import model.DanhSachCauHoi;
import model.NguoiChoi;
import view.Play_page;
import view.Result_page;

public class PlayPageController implements ActionListener, WindowListener{
	private Play_page play_page;
	
	public PlayPageController(Play_page play_page) {
		this.play_page = play_page;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 4; i++)
		{
			final int chi_so = i;
			if (e.getSource().equals(play_page.getjButtons_dapAns(i))) // khi người chơi bấm vào 1 trong đáp án
			{
				AmThanh.clip_dem_nguoc.stop();
				play_page.getTimer_thoiGianChay().stop();
				
				Timer timer = new Timer(500, new ActionListener() {
					int count = 0;
					@Override
					public void actionPerformed(ActionEvent e) {
						if (count == 0)
						{
							play_page.setDisableDapAn();
							play_page.setDapAnChon(play_page.getjButtons_dapAns(chi_so));
						}
						count++;
						if (count == 6) 
						{
							if (play_page.getNguoiChoi().getCauHoiHienTai().getDapAnDung().equals(CauHoi.nhanDapAn(chi_so)))
							{
								play_page.setBackGroundDapAnDung(play_page.getjButtons_dapAns(chi_so));
								AmThanh.clip_vo_tay.setMicrosecondPosition(0);
								AmThanh.clip_vo_tay.start();
							}
							else 
							{
								final int csoDung = play_page.getNguoiChoi().getCauHoiHienTai().getChiSoDapAnDung();
								play_page.setBackGroundDapAnDung(play_page.getjButtons_dapAns(csoDung));
								play_page.setBackGroundDapAnSai(play_page.getjButtons_dapAns(chi_so));
								AmThanh.clip_tra_loi_sai.start();
								play_page.upDateBangRank();
								play_page.upDateBangRank();
							}
						}
						else if (count == 16)
						{
							if (play_page.getNguoiChoi().getCauHoiHienTai().getDapAnDung().equals(CauHoi.nhanDapAn(chi_so)))
							{
								play_page.setMauChuChoCauDung(play_page.getNguoiChoi().getLevel());
								play_page.getNguoiChoi().increaseLevel();
								AmThanh.clip_vo_tay.stop();
								play_page.reset();
								play_page.xuli(play_page.getNguoiChoi().getLevel());
								((Timer) e.getSource()).stop();
							}
							else 
							{
								AmThanh.clip_tra_loi_sai.stop();
								play_page.setVisible(false);
								new Result_page(play_page.getNguoiChoi());
							}
							((Timer) e.getSource()).stop();
						}
					}
				});
				timer.start();
			}
		}
		
		if (e.getSource().equals(play_page.getjButton_50_50())) // xử lí trợ giúp 50/50
		{
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						AmThanh.clip_dem_nguoc.stop();
						play_page.getTimer_thoiGianChay().stop();
						Thread.sleep(3000);
						Random random = new Random();
						int ans1 = random.nextInt(4);
						int ans2 = random.nextInt(4);
						int ansDung = play_page.getNguoiChoi().getCauHoiHienTai().getChiSoDapAnDung();
						while(ans1 == ans2 || ans2 == ansDung) ans2 = random.nextInt(4);
						while(ans1 == ans2 || ans1 == ansDung) ans1 = random.nextInt(4);
						play_page.getNguoiChoi().getCauHoiHienTai().setEnable(ans1, false);
						play_page.getNguoiChoi().getCauHoiHienTai().setEnable(ans2, false);
						for (int i = 0; i < 4; i++)
							if (!play_page.getNguoiChoi().getCauHoiHienTai().getEnable(i))
							{
								play_page.getjButtons_dapAns(i).setEnabled(false);
							}
						play_page.getjButton_50_50().setEnabled(false);
						
						play_page.getTimer_thoiGianChay().restart();
						AmThanh.clip_dem_nguoc.start();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			thread.run();
		}
		else if (e.getSource().equals(play_page.getjButton_phone())) // xử lí sự trợ giúp gọi điện thoại cho người thân
		{
			Thread thread = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						AmThanh.clip_goi_dien.start();
						play_page.getTimer_thoiGianChay().stop();
						AmThanh.clip_dem_nguoc.stop();
						Thread.sleep(5000);
						AmThanh.clip_goi_dien.stop();
						play_page.getjButton_phone().setEnabled(false);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			thread.run();
			
			String dapAnNguoiThan;
			if (play_page.getNguoiChoi().getCauHoiHienTai().getLevel() < 10) {
				dapAnNguoiThan = play_page.getNguoiChoi().getCauHoiHienTai().getDapAnDung();
			}
			else 
			{
				int stt;
				do {
					Random random = new Random();
					stt = random.nextInt(4);
				} while (!play_page.getNguoiChoi().getCauHoiHienTai().getEnable(stt));
				dapAnNguoiThan = play_page.getNguoiChoi().getCauHoiHienTai().nhanDapAn(stt);
			}
			
			// dialog hiển thị đáp án 
			JDialog dialog = new JDialog();
			dialog.setName("Gọi điện thoại cho homie");
	        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	        dialog.setLayout(new BorderLayout());
	        JLabel jLabel = new JLabel("Theo tôi đáp án là: " + dapAnNguoiThan, SwingConstants.CENTER);
	        jLabel.setHorizontalAlignment(JLabel.CENTER);
	        jLabel.setFont(new Font("Arial", Font.ITALIC, 25));
	        dialog.add(jLabel, BorderLayout.CENTER);
	        dialog.setSize(300, 100);
	        dialog.setLocationRelativeTo(null);
	        dialog.setVisible(true);

	        Timer timer = new Timer(4000, new ActionListener() {
				int count = 1;
				@Override
				public void actionPerformed(ActionEvent e) {
					count--;
					if (count == 0)
					{
						dialog.dispose();
						play_page.getTimer_thoiGianChay().restart();
						((Timer) e.getSource()).stop();
					}
				}
			}); 
	        timer.start();
		}
		else if (e.getSource().equals(play_page.getjButton_khan_gia())) // xử lí hỏi ý kiến khán giả trong trưởng quay
		{
			AmThanh.clip_dem_nguoc.stop();
			play_page.getTimer_thoiGianChay().stop();
			
			try {
				Thread.sleep(3000);
				play_page.getjButton_khan_gia().setEnabled(false);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			int tiLe[] = new int[4];
			CauHoi cauHoi = play_page.getNguoiChoi().getCauHoiHienTai();
			int ansDung = cauHoi.getChiSoDapAnDung();
			int sum = 0;
			Random random = new Random();
			if (cauHoi.getLevel() <= 5) tiLe[ansDung] = 50 + random.nextInt(50);
			else if (cauHoi.getLevel() <= 10) tiLe[ansDung] = 35 + random.nextInt(70);
			else tiLe[ansDung] = 25 + random.nextInt(75);
			sum = tiLe[ansDung];
			for (int j = 0; j < 4; j++) 
				if (!cauHoi.getEnable(j)) 
				{
					tiLe[j] = 0;
				}
				else if (j != ansDung) {
					tiLe[j] = random.nextInt(100 - sum);
					sum += tiLe[j];
				}
			if (sum != 100) {
				for (int j = 0; j < 4; j++) 
					if (cauHoi.getEnable(j)) 
						{
							tiLe[j] += (100 - sum);
							break;
						}
			}
			
			// Tạo biểu đồ
			DefaultCategoryDataset dataset = new DefaultCategoryDataset();
			for (int i = 0; i < 4; i++)
				dataset.addValue(tiLe[i], "Phần trăm", CauHoi.nhanDapAn(i));
			
			JFreeChart jFreeChart = ChartFactory.createBarChart(
					"Ý kiến của khán giả trong trường quay", // Tên biểu đồ
					"Đáp án", // Tên trục x
					"Phần trăm", // Tên trục Y
					dataset, // dữ liệu
					PlotOrientation.VERTICAL, // hướng của biểu đồ
					true, // hiển thị chú thích
					true, // 
					false);
			
			// Thiết lập kiểu hiển thị và vị trí của nhãn số trên các cột
	        CategoryPlot plot = jFreeChart.getCategoryPlot();
	        BarRenderer renderer = (BarRenderer) plot.getRenderer();
	        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        renderer.setDefaultItemLabelsVisible(true);
	        renderer.setDefaultPositiveItemLabelPosition(new ItemLabelPosition(
	                ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER, TextAnchor.CENTER, 0
	        ));
	        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}%", new DecimalFormat("0")));
	        
	        ValueAxis rangeAxis = plot.getRangeAxis();
	        rangeAxis.setRange(0, 100);
	        
			ChartFrame frame = new ChartFrame("Biểu đồ", jFreeChart);
			frame.setSize(400, 400);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			Timer timer = new Timer(4000, new ActionListener() {
				int count = 1;
				@Override
				public void actionPerformed(ActionEvent e) {
					count--;
					if (count == 0)
					{
						frame.setVisible(false);
						AmThanh.clip_dem_nguoc.start();
						play_page.getTimer_thoiGianChay().restart();
						((Timer) e.getSource()).stop();
					}
				}
			}); 
	        timer.start();
		}
		else if (e.getSource().equals(play_page.getjButton_doi_cau_hoi())) // xử lí đổi câu hỏi
		{
			play_page.getTimer_thoiGianChay().stop();
			AmThanh.clip_dem_nguoc.stop();
			int level = play_page.getNguoiChoi().getLevel();
			play_page.getNguoiChoi().setCauHoi(level, DanhSachCauHoi.sinhThemCauHoi(play_page.getNguoiChoi().getCauHoiHienTai(), level));
			play_page.reset();
			play_page.xuli(level);
			play_page.getjButton_doi_cau_hoi().setEnabled(false);
		}
		else if (e.getSource().equals(play_page.getjButton_stop()))
		{
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Bạn có chắc chắn muốn dừng lại?");
			label.setFont(new Font("Arial", Font.ITALIC, 15));
			panel.add(label);
			int result = JOptionPane.showOptionDialog(null, panel, "Xác nhận dừng lại",
			    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
			    null, new String[] { "Đồng ý", "Hủy bỏ" }, null);
			if (result == JOptionPane.OK_OPTION) {
				AmThanh.clip_dem_nguoc.stop();
				play_page.getTimer_thoiGianChay().stop();
				play_page.setVisible(false);
				play_page.upDateBangRank();
				new Result_page(play_page.getNguoiChoi());
			} else {
				JOptionPane.getRootFrame().dispose();
			}
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
