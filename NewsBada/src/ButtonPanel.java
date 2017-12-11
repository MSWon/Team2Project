

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Blob;

public class ButtonPanel extends JPanel implements ActionListener {
   
    // MySQL 연결
    String url = "jdbc:mysql://localhost:3306/newsbada";  //newsbada <- mysql에 있는 (내가 불러올) 스키마 이름
    String user = "root"; 
    String password = "1111";  // 자기꺼 비밀번호
    Connection myConn = null;
    PreparedStatement myStmt = null;
    PreparedStatement myStmt2 = null;
    ResultSet myRs = null;
    int Num;
    String Theme;
    String Title;
    
    private static final int IMG_WIDTH = 300;
    private static final int IMG_HEIGHT = 200;
    ArrayList<Article> list;
    
    
   public ButtonPanel(String theme , int n) {
      
	  setBackground(Color.MAGENTA);
      Num = n;
      Theme = theme;
      ImageDAO dao = new ImageDAO();
      list = dao.returnImage(theme);
      
      
      JButton btnNewButton = new JButton(list.get(n).getTitle());
      btnNewButton.setVerticalTextPosition(SwingConstants.BOTTOM);
      btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setFont(new Font("돋움", Font.BOLD, 15));
      btnNewButton.addActionListener(this);
      btnNewButton.setSize(IMG_WIDTH,IMG_HEIGHT);

	  ImageIcon image = new ImageIcon(new ImageIcon(list.get(n).getImage()).getImage()
				.getScaledInstance(IMG_WIDTH, IMG_HEIGHT, Image.SCALE_SMOOTH));
	  btnNewButton.setIcon(image);
      this.setSize(302,187);
      GroupLayout groupLayout = new GroupLayout(this);
      groupLayout.setHorizontalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 302, Short.MAX_VALUE)
      );
      groupLayout.setVerticalGroup(
      	groupLayout.createParallelGroup(Alignment.LEADING)
      		.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 187, Short.MAX_VALUE)
      );
      setLayout(groupLayout);

   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      
	   int num;
	   
	   try {
	         // 1. Get connection
	         myConn = DriverManager.getConnection(url, user, password);
	         // 2. Create a statement
	         myStmt = myConn.prepareStatement("INSERT INTO read_on (`Time`, `ID`, `A_Number`) VALUES (?, ?, ?)");
	         User u = new User();
	         String date =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	         myStmt.setString(1, date);
	         myStmt.setString(2, u.getId());
	         myStmt.setInt(3, list.get(Num).getA_number());
	         // 4. Execute SQL query
	         myStmt.executeUpdate();
	         
	   } catch (Exception exc) {
	         exc.printStackTrace();
	   }
	   try{
	         myConn = DriverManager.getConnection(url, user, password);
	         myStmt = myConn.prepareStatement("UPDATE newsbada.article SET Views=Views+1 WHERE A_Number=?");
	         User u = new User();
	         myStmt.setInt(1,list.get(Num).getA_number());
	         myStmt.executeUpdate();
	      }catch(Exception exc){
	         exc.printStackTrace();
	      }
	   try{
	         myConn = DriverManager.getConnection(url, user, password);
	         myStmt = myConn.prepareStatement("SET @male = (SELECT COUNT(DISTINCT user.id) "
	         		+ "FROM article,read_on,user "
	         		+ "WHERE read_on.id = user.id AND "
	         		+ "read_on.A_Number = article.A_Number AND "
	         		+ "article.A_Number = ? AND user.sex = '남')");
	         myStmt.setInt(1, list.get(Num).getA_number());
	         myStmt.executeUpdate();
	         myStmt = myConn.prepareStatement("UPDATE article SET male = @male WHERE A_Number=?");
	         myStmt.setInt(1, list.get(Num).getA_number());	
	         myStmt.executeUpdate();
	         myStmt = myConn.prepareStatement("SET @female = (SELECT COUNT(DISTINCT user.id) "
	         		+ "FROM article,read_on,user "
	         		+ "WHERE read_on.id = user.id AND "
	         		+ "read_on.A_Number = article.A_Number AND "
	         		+ "article.A_Number = ? AND user.sex = '여')");
	         myStmt.setInt(1, list.get(Num).getA_number());	
	         myStmt.executeUpdate();
	         myStmt = myConn.prepareStatement("UPDATE article SET female = @female WHERE A_Number=?");
	         myStmt.setInt(1, list.get(Num).getA_number());
	         myStmt.executeUpdate();
	      }catch(Exception exc){
	         exc.printStackTrace();
	      }
	 
	 
	  
	   num = list.get(Num).getA_number();
       new ArticleViewPage(Theme,num);
       
      
   }


}