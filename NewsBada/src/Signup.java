

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Character.UnicodeBlock;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class Signup extends JFrame implements ActionListener {

   private JPanel contentPane;
   private JTextField textField;
   //
   String url = "jdbc:mysql://localhost:3306/newsbada";
   String user = "root";
   String password = "1111";
   //
   String id;
   String ps;
   String sex;
   int age;
   //
   private JLabel lblSex;
   private JLabel label;
   private JTextField textField_2;
   private JLabel label_1;
   ButtonGroup buttonGroup = new ButtonGroup();
   JRadioButton rdbtnNewRadioButton;
   JRadioButton radioButton;
   JButton btnNewButton,btnNewButton_1;
   private JPasswordField passwordField;
   Connection myConn = null;
   PreparedStatement myStmt = null;
   ResultSet myRs = null;
   int result;


   public static boolean containsHangul(String str) {
      for (int i = 0; i < str.length(); i++) {
         char ch = str.charAt(i);
         Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.of(ch);
         if (UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock)
               || UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlock)
               || UnicodeBlock.HANGUL_JAMO.equals(unicodeBlock))
            return true;
      }
      return false;
   }

   /**
    * Create the frame.
    */
   public Signup() {

      setForeground(Color.WHITE);
      setBackground(Color.WHITE);
      setTitle("\uD68C\uC6D0\uAC00\uC785");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 596, 444);
      contentPane = new JPanel();
      contentPane.setBackground(new Color(153, 204, 255));
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      this.setLocationRelativeTo(null);
      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514(\uC601\uBB38) :");
      lblNewLabel.setForeground(SystemColor.desktop);
      lblNewLabel.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      lblNewLabel.setBackground(Color.WHITE);

      JLabel lblPassword = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
      lblPassword.setForeground(SystemColor.desktop);
      lblPassword.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      lblPassword.setBackground(Color.WHITE);

      textField = new JTextField();
      textField.setFont(new Font("±¼¸²", Font.PLAIN, 25));
      textField.setColumns(10);
      textField.addActionListener(this);

      lblSex = new JLabel("\uC131\uBCC4 :");
      lblSex.setForeground(SystemColor.desktop);
      lblSex.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      lblSex.setBackground(Color.WHITE);

      label = new JLabel("\uB098\uC774 :");
      label.setForeground(SystemColor.desktop);
      label.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      label.setBackground(Color.WHITE);

      textField_2 = new JTextField();
      textField_2.setFont(new Font("±¼¸²", Font.PLAIN, 25));
      textField_2.setColumns(10);
      textField_2.addActionListener(this);

      label_1 = new JLabel("\uC138");
      label_1.setForeground(SystemColor.desktop);
      label_1.setFont(new Font("±¼¸²Ã¼", Font.BOLD, 25));
      label_1.setBackground(Color.WHITE);

      rdbtnNewRadioButton = new JRadioButton("\uB0A8");
      rdbtnNewRadioButton.setForeground(SystemColor.desktop);
      rdbtnNewRadioButton.addActionListener(this);
      buttonGroup.add(rdbtnNewRadioButton);
      rdbtnNewRadioButton.setFont(new Font("±¼¸²", Font.PLAIN, 25));
      rdbtnNewRadioButton.setBackground(new Color(153, 204, 255));

      radioButton = new JRadioButton("\uC5EC");
      radioButton.setForeground(SystemColor.desktop);
      radioButton.addActionListener(this);
      buttonGroup.add(radioButton);
      radioButton.setFont(new Font("±¼¸²", Font.PLAIN, 25));
      radioButton.setBackground(new Color(153, 204, 255));

      btnNewButton = new JButton("\uAC00\uC785");
      btnNewButton.setBackground(SystemColor.text);
      btnNewButton.addActionListener(this);
      btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 20));

      passwordField = new JPasswordField();
      passwordField.setFont(new Font("±¼¸²", Font.PLAIN, 25));
      passwordField.addActionListener(this);
      
       btnNewButton_1 = new JButton("\uBA54\uC778");
       btnNewButton_1.addActionListener(this);
      btnNewButton_1.setBackground(SystemColor.text);
      btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
      	gl_contentPane.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      				.addGroup(gl_contentPane.createSequentialGroup()
      					.addGap(397)
      					.addComponent(btnNewButton)
      					.addPreferredGap(ComponentPlacement.RELATED)
      					.addComponent(btnNewButton_1))
      				.addGroup(gl_contentPane.createSequentialGroup()
      					.addGap(100)
      					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      						.addGroup(gl_contentPane.createSequentialGroup()
      							.addComponent(label, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
      							.addPreferredGap(ComponentPlacement.RELATED)
      							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
      							.addPreferredGap(ComponentPlacement.UNRELATED)
      							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
      						.addGroup(gl_contentPane.createSequentialGroup()
      							.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
      							.addPreferredGap(ComponentPlacement.RELATED)
      							.addComponent(rdbtnNewRadioButton)
      							.addGap(52)
      							.addComponent(radioButton))
      						.addGroup(gl_contentPane.createSequentialGroup()
      							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
      								.addGroup(gl_contentPane.createSequentialGroup()
      									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
      									.addGap(46))
      								.addGroup(gl_contentPane.createSequentialGroup()
      									.addComponent(lblNewLabel)
      									.addPreferredGap(ComponentPlacement.UNRELATED)))
      							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
      								.addComponent(passwordField)
      								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))))
      			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      gl_contentPane.setVerticalGroup(
      	gl_contentPane.createParallelGroup(Alignment.TRAILING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addContainerGap(62, Short.MAX_VALUE)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
      				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      				.addComponent(lblNewLabel))
      			.addGap(39)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      				.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
      				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(36)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
      				.addComponent(lblSex, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
      				.addComponent(rdbtnNewRadioButton)
      				.addComponent(radioButton, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
      			.addGap(30)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
      				.addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
      				.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      				.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
      			.addGap(28)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      				.addComponent(btnNewButton_1)
      				.addComponent(btnNewButton))
      			.addContainerGap())
      );
      contentPane.setLayout(gl_contentPane);
   this.setVisible(true);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      
      Object source = e.getSource();
      

      if (source == btnNewButton) {

         if (rdbtnNewRadioButton.isSelected()) {
            sex = rdbtnNewRadioButton.getText();
         }

         else if (radioButton.isSelected()) {
            sex = radioButton.getText();
         }
         
         id = textField.getText();
         ps = String.valueOf(passwordField.getPassword());
         age = Integer.parseInt(textField_2.getText());
         
         if (containsHangul(id) == true) {
             JOptionPane.showMessageDialog(Signup.this, "¾ÆÀÌµð´Â ÇÑ±ÛÀÌ ¾Æ´Ñ ¿µ¹®À¸·Î ÀÔ·ÂÇØÁÖ¼¼¿ä.");
          }
         
         else{
         
               try{
                   // 1. Get connection
                   myConn = DriverManager.getConnection(url, user, password);
                   myStmt = myConn.prepareStatement("SELECT COUNT(ID) AS n FROM user WHERE ID=?");
                   myStmt.setString(1, id);
                   ResultSet rs = myStmt.executeQuery();
                   if(rs.next()){
                      result = rs.getInt("n");
                   }
               }
               
               catch (Exception exc){
                  exc.printStackTrace();
               }
               
               if(result == 1){
                  JOptionPane.showMessageDialog(Signup.this, "Áßº¹µÈ ¾ÆÀÌµðÀÔ´Ï´Ù.");
           
               }
               
               else{
                     try {
                        // 1. Get connection
                        myConn = DriverManager.getConnection(url, user, password);
                        // 2. Create a statement
                        myStmt = myConn.prepareStatement("insert into user (ID, Password, Sex, Age) values (?,?,?,?)");
                        // 3. Set the parameters
                        myStmt.setString(1, id);
                        myStmt.setString(2, ps);
                        myStmt.setString(3, sex);
                        myStmt.setInt(4, age);
                        
                        // 4. Execute SQL query
                        myStmt.executeUpdate();
         
                        System.out.println("Insert Done");
         
                      }
         
                     catch (Exception exc) {
                        exc.printStackTrace();
                     }     
                     this.dispose();
                     new login();
                }
           
             }
         //

         
        }
      else if(source == btnNewButton_1){
    	  this.dispose();
    	  new login();
      }
    }
}