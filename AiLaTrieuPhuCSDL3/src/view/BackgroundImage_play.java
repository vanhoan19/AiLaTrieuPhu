package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundImage_play extends JPanel{
	private Image backgroundImage;

    public BackgroundImage_play(URL imageURL) {
        backgroundImage = new ImageIcon(imageURL).getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, getWidth()/4, 0, getWidth()/2, getHeight(), this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(backgroundImage.getWidth(this), backgroundImage.getHeight(this));
    }
}
