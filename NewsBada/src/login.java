import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class login extends JFrame implements ActionListener{

   private JPanel contentPane;
   private JTextField textField;
   private JPasswordField passwordField;
   JButton button_signin;
   JButton button_signup;
   
   String url = "jdbc:mysql://localhost:3306/newsbada";
   String user = "root";
   String password = "1111";
   String id;
   String pw;

   Connection conn = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   int result;
   static ArrayList<ArticleImage> list;
   
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
	   
	   
	   
	  ImageDAO dao = new ImageDAO();
	  list = dao.returnImage("정치");
	     	   
	  setResizable(false);
      setTitle("\uB85C\uADF8\uC778");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 641, 457);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      
      JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514 :");
      lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
      
      JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
      label.setFont(new Font("굴림", Font.BOLD, 25));
      
      textField = new JTextField();
      textField.setFont(new Font("굴림", Font.PLAIN, 25));
      textField.setColumns(10);
      
      passwordField = new JPasswordField();
      passwordField.setColumns(10);
      passwordField.setFont(new Font("굴림", Font.PLAIN, 25));
      
      button_signin = new JButton("\uB85C\uADF8\uC778");
      button_signin.addActionListener(this);
      button_signin.setFont(new Font("굴림", Font.BOLD, 25));
      
      button_signup = new JButton("\uD68C\uC6D0\uAC00\uC785");
      button_signup.addActionListener(this);
      button_signup.setFont(new Font("굴림", Font.BOLD, 25));
      
      GroupLayout gl_contentPane = new GroupLayout(contentPane);
      gl_contentPane.setHorizontalGroup(
      	gl_contentPane.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addGap(131)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
      				.addComponent(button_signin, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      				.addComponent(label, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      				.addComponent(lblNewLabel))
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      				.addGroup(gl_contentPane.createSequentialGroup()
      					.addPreferredGap(ComponentPlacement.UNRELATED)
      					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
      						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
      						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
      				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
      					.addGap(99)
      					.addComponent(button_signup)))
      			.addContainerGap(124, Short.MAX_VALUE))
      );
      gl_contentPane.setVerticalGroup(
      	gl_contentPane.createParallelGroup(Alignment.LEADING)
      		.addGroup(gl_contentPane.createSequentialGroup()
      			.addGap(110)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
      				.addComponent(lblNewLabel)
      				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(36)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
      				.addComponent(label, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
      				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
      			.addGap(52)
      			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
      				.addComponent(button_signin)
      				.addComponent(button_signup, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
      			.addContainerGap(108, Short.MAX_VALUE))
      );
      contentPane.setLayout(gl_contentPane);
      this.setVisible(true);
   }

   
   public void actionPerformed(ActionEvent e) {
      
      Object source = e.getSource();
      
      if(source == button_signin) {
    	  
    	  id = textField.getText();
          pw = String.valueOf(passwordField.getPassword());

    	   try {
    			Class.forName("com.mysql.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsbada","root","1111");
    			pstmt = conn.prepareStatement("SELECT COUNT(ID) AS n FROM user WHERE ID=? and Password=?");
                pstmt.setString(1, id);
                pstmt.setString(2, pw);
                ResultSet rs = pstmt.executeQuery();
                if(rs.next()){
                   result = rs.getInt("n");
                }
    		} catch(ClassNotFoundException cnfe) {
    			cnfe.printStackTrace();
    			System.out.println("DB Driver Error!");
    		} catch(SQLException se) {
    			se.printStackTrace();
    			System.out.println("DB Connection Error!");
    		}
//    	   to main
    	   if(result == 1){
               this.dispose();
               Main m = new Main("정치");
            }
    	   else {
               JOptionPane.showMessageDialog(login.this, "아이디 또는 비밀번호가 일치하지 않습니다.");
    	   }
      }
//      to signup
      else if(source == button_signup){
         this.dispose();
         Signup s = new Signup();
      }
   }
}