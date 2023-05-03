package model;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AmThanh {
	public static Clip clip_bat_dau;
	public static Clip clip_vo_tay;
	public static Clip clip_tra_loi_sai;
	public static Clip clip_giai_thuong;
	public static Clip clip_dem_nguoc;
	public static Clip clip_het_gio;
	public static Clip clip_goi_dien;

	public AmThanh() {
		// Âm thanh bắt đầu vào game
		URL soundUrl = getClass().getResource("/assets/bắt đầu.wav");

		try {
			clip_bat_dau = AudioSystem.getClip();
			clip_bat_dau.open(AudioSystem.getAudioInputStream(soundUrl));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Âm thanh tiến vỗ tay khi trả lời đúng
		soundUrl = getClass().getResource("/assets/vỗ tay trả lời đúng.wav");

		try {
			clip_vo_tay = AudioSystem.getClip();
			clip_vo_tay.open(AudioSystem.getAudioInputStream(soundUrl));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Âm thanh khi trả lời sai
		soundUrl = getClass().getResource("/assets/trả lời sai.wav");

		try {
			clip_tra_loi_sai = AudioSystem.getClip();
			clip_tra_loi_sai.open(AudioSystem.getAudioInputStream(soundUrl));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Âm thanh khi trao thưởng
		soundUrl = getClass().getResource("/assets/công bố giải.wav");

		try {
			clip_giai_thuong = AudioSystem.getClip();
			clip_giai_thuong.open(AudioSystem.getAudioInputStream(soundUrl));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Âm thanh đếm ngược
		soundUrl = getClass().getResource("/assets/đếm ngược.wav");

		try {
			clip_dem_nguoc = AudioSystem.getClip();
			clip_dem_nguoc.open(AudioSystem.getAudioInputStream(soundUrl));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Âm thanh chuông hết giờ
		soundUrl = getClass().getResource("/assets/chuông hết giờ.wav");

		try {
			clip_het_gio = AudioSystem.getClip();
			clip_het_gio.open(AudioSystem.getAudioInputStream(soundUrl));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Âm thanh chuông hết giờ
		soundUrl = getClass().getResource("/assets/gọi người thân.wav");
		try {
			clip_goi_dien = AudioSystem.getClip();
			clip_goi_dien.open(AudioSystem.getAudioInputStream(soundUrl));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
