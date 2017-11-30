

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JTextField textField;
   private JPasswordField passwordField;
   JButton button_1;
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               login frame = new login();
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
   public login() {
      setTitle("\uB85C\uADF8\uC778");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 641, 457);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 :");
      lblNewLabel.setFont(new Font("±¼¸²", Font.BOLD, 25));
      
      JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
      label.setFont(new Font("±¼¸²", Font.BOLD, 25));
      
      textField = new JTextField();
      textField.setFont(new Font("±¼¸²", Font.PLAIN, 25));
      textField.setColumns(10);
      
      passwordField = new JPasswordField();
      passwordField.setColumns(10);
      passwordField.setFont(new Font("±¼¸²", Font.PLAIN, 25));
      
      JButton button = new JButton("\uB85C\uADF8\uC778");
      button.setFont(new Font("±¼¸²", Font.BOLD, 25));
      
      button_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
      button_1.addActionListener(this);
      button_1.setFont(new Font("±¼¸²", Font.BOLD, 25));
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGap(131)
               .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addComponent(button)
                     .addGap(18)
                     .addComponent(button_1))
                  .addGroup(gl_contentPane.createSequentialGroup()
                     .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(label)
                        .addComponent(lblNewLabel))
                     .addPreferredGap(ComponentPlacement.UNRELATED)
                     .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
               .addContainerGap(154, Short.MAX_VALUE))
      );
      gl_contentPane.setVerticalGroup(
         gl_contentPane.createParallelGroup(Alignment.LEADING)
            .addGroup(gl_contentPane.createSequentialGroup()
               .addGap(110)
               .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                  .addComponent(lblNewLabel))
               .addGap(30)
               .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                  .addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                  .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
               .addGap(52)
               .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                  .addComponent(button)
                  .addComponent(button_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
               .addContainerGap(97, Short.MAX_VALUE))
      );
      contentPane.setLayout(gl_contentPane);
      this.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      
      Object source = e.getSource();
      if(source == button_1){
         this.dispose();
         Signup s = new Signup();
      }
      
   }
}