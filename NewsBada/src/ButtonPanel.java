

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import java.awt.Font;
import java.awt.Color;

public class ButtonPanel extends JPanel implements ActionListener {
   
    // MySQL 연결
    String url = "jdbc:mysql://localhost:3306/newschema";
    String user = "root"; 
    String password = "1111";  // 자기꺼 비밀번호
    Connection myConn = null;
    PreparedStatement myStmt = null;
    ResultSet myRs = null;
    
    String Title;
    String Imgurl;
    
    private static final int IMG_WIDTH = 200;
    private static final int IMG_HEIGHT = 200;
    
    // 이미지 축소 method
   private static BufferedImage resizeImage(BufferedImage originalImage, int type){
            
       BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
       Graphics2D g = resizedImage.createGraphics();
       g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
       g.dispose();

       return resizedImage;
   }

    
   public ButtonPanel(String theme , int n) {
      setBackground(Color.WHITE);
      
      try {
         // 1. Get connection
         myConn = DriverManager.getConnection(url, user, password);
         // 2. Create a statement

         myStmt = myConn.prepareStatement("SELECT Imgurl,Title FROM article WHERE Theme = ?"
               + "ORDER BY Date DESC LIMIT ?,1");
         // 3. Set the parameters
         myStmt.setString(1, theme);
         myStmt.setInt(2, n-1);
         
         // 4. Execute SQL query
         ResultSet rs = myStmt.executeQuery();
         if(rs.next()){
            Title = rs.getString("Title");
            Imgurl = rs.getString("Imgurl");
         }
         System.out.println("Done");

      }

      catch (Exception exc) {
         exc.printStackTrace();
      }
      
      JButton btnNewButton = new JButton(Title);
      btnNewButton.setBackground(Color.WHITE);
      btnNewButton.setFont(new Font("돋움", Font.BOLD, 15));
      btnNewButton.addActionListener(this);
      btnNewButton.setSize(IMG_WIDTH, IMG_HEIGHT);
       btnNewButton.setHorizontalTextPosition(AbstractButton.CENTER);
       btnNewButton.setVerticalTextPosition(AbstractButton.BOTTOM);

      
      String url = Imgurl;
        BufferedImage img;
        BufferedImage newimg;
         try {
            img = ImageIO.read(new URL(url));
            int type = img.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : img.getType();
            newimg = resizeImage(img,type);
            ImageIcon pic = new ImageIcon(newimg);
            btnNewButton.setIcon(pic);
         } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }

      this.setSize(IMG_WIDTH ,IMG_HEIGHT);
      GroupLayout groupLayout = new GroupLayout(this);
      groupLayout.setHorizontalGroup(
         groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(groupLayout.createSequentialGroup()
               .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
               .addGap(116))
      );
      groupLayout.setVerticalGroup(
         groupLayout.createParallelGroup(Alignment.TRAILING)
            .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
               .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
               .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE))
      );
      setLayout(groupLayout);

   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      
      System.out.println("yeah");
      
   }


}