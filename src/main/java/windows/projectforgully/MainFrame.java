package windows.projectforgully;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import windows.projectforgully.*;
import windows.projectforgully.*;

public class MainFrame{
	JFrame frame;
	public MainFrame() {
		ArrayList<Product> products=null;
    	try {
			products = new ProductDao().getAll();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	
		frame = new JFrame("Main Frame");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(3);
		frame.setLayout(new BorderLayout());
		frame.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {	
			}
			public void keyReleased(KeyEvent e) {
			}
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					frame.dispose();
					frame.setUndecorated(false);
					frame.setVisible(true);

				}
			}
		});
		JScrollPane productsPane = new JScrollPane(new ProductsPanel(products));
    	frame.add(productsPane, BorderLayout.CENTER);
    	BillingPanel billingPanel = new BillingPanel();
    	frame.add(billingPanel, BorderLayout.EAST);
    	frame.setVisible(true);
	}
	
}
