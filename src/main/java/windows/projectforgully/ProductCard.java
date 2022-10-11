package windows.projectforgully;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import windows.projectforgully.*;
public class ProductCard extends JPanel {
	static Product p;
	public ProductCard(Product p) {
		this.p=p;
		BufferedImage myPicture=null;
		try {
			myPicture = ImageIO.read(new File("img/product-2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel picLabel = new JLabel(new ImageIcon(myPicture.getScaledInstance(150, 150,Image.SCALE_SMOOTH)));
		/*
		picLabel.setPreferredSize(new Dimension(150,150));
		picLabel.setMaximumSize(new Dimension(150,150));
		*/
		picLabel.setSize(new Dimension(150, 150));
		picLabel.setText(p.getName());
		picLabel.setIconTextGap(-100);
		picLabel.setFont(new Font("Arial", 1, 24));
		picLabel.setForeground(Color.GRAY);
		picLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {	
			}		
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(p.getName());
				
			}
		});
		add(picLabel);
		
		
		
		
	}

}
