

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

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
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 1157, 653);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JPanel panel = new JPanel();
      
      JPanel panel_1 = new JPanel();
      
      JPanel panel_2 = new JPanel();
      panel_2.setLayout(new GridLayout(2,3));
      panel_2.add(new ButtonPanel("정치",3));
      panel_2.add(new ButtonPanel("정치",3));
      panel_2.add(new ButtonPanel("정치",3));
      panel_2.add(new ButtonPanel("정치",3));
      panel_2.add(new ButtonPanel("정치",3));
      panel_2.add(new ButtonPanel("정치",3));
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
      	gl_contentPane.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
      			.addPreferredGap(ComponentPlacement.UNRELATED)
      			.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 896, Short.MAX_VALUE))
      		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
      );
      gl_contentPane.setVerticalGroup(
      	gl_contentPane.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
      			.addPreferredGap(ComponentPlacement.RELATED)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      				.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
      				.addComponent(panel_2, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)))
      );
      contentPane.setLayout(gl_contentPane);
   }
}