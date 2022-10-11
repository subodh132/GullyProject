package windows.projectforgully;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ScrollPaneLayout;

import windows.projectforgully.*;

public class ProductsPanel extends JPanel {

	public ProductsPanel(ArrayList<Product> products) {
		GridBagConstraints gbc = new GridBagConstraints();  
        
         
        GridBagLayout layout = new GridBagLayout();  
		setLayout(layout);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridx = 0;  
		gbc.gridy = 0;  

		add(new Button("Button One"), gbc);  
		gbc.gridx = 1;  
		gbc.gridy = 0;  
		add(new Button("Button two"), gbc);  
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.ipady = 20;  
		gbc.gridx = 0;  
		gbc.gridy = 1;  
		add(new Button("Button Three"), gbc);  
		gbc.gridx = 1;  
		gbc.gridy = 1;  
		add(new Button("Button Four"), gbc);  
		gbc.gridx = 0;  
		gbc.gridy = 2;  
		gbc.fill = GridBagConstraints.HORIZONTAL;  
		gbc.gridwidth = 2;  
		add(new JButton("Button Five"), gbc);  
        setSize(300, 300);  
        setPreferredSize(getSize());     

		
		for(Product p:products) {
			ProductCard pCard = new ProductCard(p);
			
			
			add(pCard,gbc);
			if(gbc.gridx<3) {
				gbc.gridx++;
			}else {
				gbc.gridy++;
				gbc.gridx=0;
			}
			
		}
		
	}
	
}
