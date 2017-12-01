

import java.awt.BorderLayout;
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

public class Main extends JFrame {

   private JPanel contentPane;

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
      
      setBounds(100, 100, 1416, 745);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      
      JPanel panel_1 = new JPanel();
      
      JPanel panel_2 = new JPanel();
     
      panel_2.setLayout(new GridLayout(2,3));
      panel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      ButtonPanel buttonPanel = new ButtonPanel("정치",3);
      buttonPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
      buttonPanel.setForeground(Color.BLACK);
      panel_2.add(buttonPanel);
      ButtonPanel buttonPanel_1 = new ButtonPanel("정치",3);
      buttonPanel_1.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
      panel_2.add(buttonPanel_1);
      ButtonPanel buttonPanel_2 = new ButtonPanel("정치",3);
      buttonPanel_2.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
      panel_2.add(buttonPanel_2);
      ButtonPanel buttonPanel_3 = new ButtonPanel("정치",3);
      buttonPanel_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
      panel_2.add(buttonPanel_3);
      ButtonPanel buttonPanel_4 = new ButtonPanel("정치",3);
      buttonPanel_4.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
      panel_2.add(buttonPanel_4);
      ButtonPanel buttonPanel_5 = new ButtonPanel("정치",3);
      buttonPanel_5.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
      panel_2.add(buttonPanel_5);
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
      	gl_contentPane.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
      			.addPreferredGap(ComponentPlacement.UNRELATED)
      			.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE))
      		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1242, Short.MAX_VALUE)
      );
      gl_contentPane.setVerticalGroup(
      	gl_contentPane.createParallelGroup(Alignment.TRAILING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
      			.addPreferredGap(ComponentPlacement.RELATED)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
      				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
      				.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 545, Short.MAX_VALUE)))
      );
      contentPane.setLayout(gl_contentPane);
   }
}