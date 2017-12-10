import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class CardPanel extends JPanel {
	
	public CardPanel(String theme, int n){	
		this.setLayout(new CardLayout());
		this.setBackground(Color.WHITE);
	    for(int x = 0; x<=n; x++){
	    	  this.add(new Panel(theme,x));
	    }
		
	}

}
