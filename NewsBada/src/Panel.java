import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Panel extends JPanel{
	
	public Panel(String theme, int n){	
		
		  this.setSize(1600,800);
	      this.setLayout(new GridLayout(2,3));
	      this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	      for(int x = n; x<n+6; x++){
		      ButtonPanel buttonPanel = new ButtonPanel(theme,x);
		      buttonPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		      buttonPanel.setForeground(Color.BLACK);
		      this.add(buttonPanel);
	      }
	      
	}
	
}
