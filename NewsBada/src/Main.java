

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;



import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Main extends JFrame implements ActionListener{

   private JPanel contentPane;
   JPanel Btnpanel;
   JButton first,prev,next,last;
   JButton btnNewButton,btnNewButton_1,btnNewButton_2,btnNewButton_3,btnNewButton_4,btnNewButton_5;
   CardLayout cl;
   CardPanel cp;
   String Theme;
   int k= 1;
   /**

   /**
    * Create the frame.
    */
   public Main(String theme) {
	  
	   Theme = theme;
   	setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setBounds(100, 100, 1800, 900);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      
      JPanel panel_1 = new JPanel();
      panel_1.setLayout(new GridLayout(6,1));
      
      
      JPanel panel_2 = new JPanel();
      panel_2.setLayout(new BoxLayout(panel_2,BoxLayout.Y_AXIS));
      cp = new CardPanel(theme,1);
      
		Btnpanel = new JPanel(); // Button panel

		prev = new JButton("  Prev");
		prev.addActionListener(this);
		prev.setBackground(Color.WHITE);
		prev.setBorder(null);
		prev.setFont(new Font("Gothic",Font.BOLD,25));
		next = new JButton("  Next");
		next.addActionListener(this);
		next.setBackground(Color.WHITE);
		next.setBorder(null);
		next.setFont(new Font("Gothic",Font.BOLD,25));

		Btnpanel.add(prev);
		Btnpanel.add(next);
		Btnpanel.setBackground(Color.WHITE);
		
		panel_2.add(cp);
		panel_2.add(Btnpanel);

      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
      	gl_contentPane.createParallelGroup(Alignment.TRAILING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
      			.addPreferredGap(ComponentPlacement.RELATED)
      			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 1531, GroupLayout.PREFERRED_SIZE))
      		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1784, Short.MAX_VALUE)
      );
      gl_contentPane.setVerticalGroup(
      	gl_contentPane.createParallelGroup(Alignment.TRAILING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
      			.addPreferredGap(ComponentPlacement.RELATED)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
      				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 656, GroupLayout.PREFERRED_SIZE)))
      );
      
      JButton btnNewButton_6 = new JButton("Search");
      btnNewButton_6.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		new EmployeeSearchApp();
      	}
      });
      btnNewButton_6.setBackground(Color.WHITE);
      btnNewButton_6.setFont(new Font("±¼¸²", Font.BOLD, 17));
      GroupLayout gl_panel = new GroupLayout(panel);
      gl_panel.setHorizontalGroup(
      	gl_panel.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_panel.createSequentialGroup()
      			.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
      			.addContainerGap(1539, Short.MAX_VALUE))
      );
      gl_panel.setVerticalGroup(
      	gl_panel.createParallelGroup(Alignment.LEADING)
      		.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
      			.addContainerGap(149, Short.MAX_VALUE)
      			.addComponent(btnNewButton_6, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
      );
      panel.setLayout(gl_panel);
      
      btnNewButton = new JButton("Á¤Ä¡");
      btnNewButton.setBackground(new Color(255, 250, 250));
      btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 24));
      btnNewButton.addActionListener(this);
      panel_1.add(btnNewButton);
      
      btnNewButton_1 = new JButton("»çÈ¸");
      btnNewButton_1.setBackground(new Color(255, 250, 250));
      btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 24));
      btnNewButton_1.addActionListener(this);
      panel_1.add(btnNewButton_1);
      
      btnNewButton_2 = new JButton("°æÁ¦");
      btnNewButton_2.setBackground(new Color(255, 250, 250));
      btnNewButton_2.setForeground(new Color(0, 0, 0));
      btnNewButton_2.setFont(new Font("±¼¸²", Font.BOLD, 24));
      btnNewButton_2.addActionListener(this);
      panel_1.add(btnNewButton_2);

      btnNewButton_3 = new JButton("IT");
      btnNewButton_3.setBackground(new Color(255, 250, 250));
      btnNewButton_3.setFont(new Font("±¼¸²", Font.BOLD, 24));
      btnNewButton_3.addActionListener(this);
      panel_1.add(btnNewButton_3);
      
      
      btnNewButton_4 = new JButton("¹®È­");
      btnNewButton_4.setBackground(new Color(255, 250, 250));
      btnNewButton_4.setFont(new Font("±¼¸²", Font.BOLD, 24));
      btnNewButton_4.addActionListener(this);
      panel_1.add(btnNewButton_4);
      
      btnNewButton_5 = new JButton("¿¬¿¹");
      btnNewButton_5.setBackground(new Color(255, 250, 250));
      btnNewButton_5.setFont(new Font("±¼¸²", Font.BOLD, 24));
      btnNewButton_5.addActionListener(this);
      panel_1.add(btnNewButton_5);
      contentPane.setLayout(gl_contentPane);
      this.setVisible(true);
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton source = (JButton)e.getSource();
		cl = (CardLayout) (cp.getLayout());
		
		if (e.getSource().equals(prev)) {

			cl.previous(cp);

		} else if (e.getSource().equals(next)) {
			k++;
			cp.add(new Panel(Theme,k));
			cl.next(cp);

		} else if(e.getSource().equals(btnNewButton)){
			this.dispose();
			new Main("Á¤Ä¡");
		} else if(e.getSource().equals(btnNewButton_1)){
			this.dispose();
			new Main("»çÈ¸");
		} else if(e.getSource().equals(btnNewButton_2)){
			this.dispose();
			new Main("°æÁ¦");
		}else if(e.getSource().equals(btnNewButton_3)){
			this.dispose();
			new Main("IT");
		}else if(e.getSource().equals(btnNewButton_4)){
			this.dispose();
			new Main("¹®È­");
		}else if(e.getSource().equals(btnNewButton_5)){
			this.dispose();
			new Main("¿¬¿¹");
		}
	
}
}