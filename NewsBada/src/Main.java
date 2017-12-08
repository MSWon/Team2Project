

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
   CardLayout cl;
   CardPanel cp;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Main frame = new Main();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Main() {
	   
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
      cp = new CardPanel("Á¤Ä¡",6);

      
		Btnpanel = new JPanel(); // Button panel
		
		first = new JButton("  First");
		first.setBackground(Color.WHITE);
		first.setBorder(null);
		first.addActionListener(this);
		first.setFont(new Font("Gothic",Font.BOLD,25));
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
		last = new JButton("  Last");
		last.addActionListener(this);
		last.setBackground(Color.WHITE);
		last.setBorder(null);
		last.setFont(new Font("Gothic",Font.BOLD,25));
		
		Btnpanel.add(first);
		Btnpanel.add(prev);
		Btnpanel.add(next);
		Btnpanel.add(last);
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
      
      JButton btnNewButton = new JButton("\uC815\uCE58");
      btnNewButton.setBackground(new Color(255, 250, 250));
      btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 24));
      panel_1.add(btnNewButton);
      
      JButton btnNewButton_1 = new JButton("\uC0AC\uD68C");
      btnNewButton_1.setBackground(new Color(255, 250, 250));
      btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 24));
      panel_1.add(btnNewButton_1);
      
      JButton btnNewButton_2 = new JButton("\uACBD\uC81C");
      btnNewButton_2.setBackground(new Color(255, 250, 250));
      btnNewButton_2.setForeground(new Color(0, 0, 0));
      btnNewButton_2.setFont(new Font("±¼¸²", Font.BOLD, 24));
      panel_1.add(btnNewButton_2);
      
      JButton btnNewButton_3 = new JButton("IT");
      btnNewButton_3.setBackground(new Color(255, 250, 250));
      btnNewButton_3.setFont(new Font("±¼¸²", Font.BOLD, 24));
      panel_1.add(btnNewButton_3);
      
      JButton btnNewButton_4 = new JButton("\uBB38\uD654");
      btnNewButton_4.setBackground(new Color(255, 250, 250));
      btnNewButton_4.setFont(new Font("±¼¸²", Font.BOLD, 24));
      panel_1.add(btnNewButton_4);
      
      JButton btnNewButton_5 = new JButton("\uC5F0\uC608");
      btnNewButton_5.setBackground(new Color(255, 250, 250));
      btnNewButton_5.setFont(new Font("±¼¸²", Font.BOLD, 24));
      panel_1.add(btnNewButton_5);
      contentPane.setLayout(gl_contentPane);
   }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton source = (JButton)e.getSource();
		cl = (CardLayout) (cp.getLayout());
		
		if (e.getSource().equals(first)) {

			cl.first(cp);

		} else if (e.getSource().equals(prev)) {

			cl.previous(cp);

		} else if (e.getSource().equals(next)) {

			cl.next(cp);

		} else if (e.getSource().equals(last)) {

			cl.last(cp);
		}
	
}
}