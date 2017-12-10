import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ImageDAO {
	
    // MySQL 연결
    String url = "jdbc:mysql://localhost:3306/newsbada";  //newsbada <- mysql에 있는 (내가 불러올) 스키마 이름
    String user = "root"; 
    String password = "1111";  // 자기꺼 비밀번호
    
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet rs = null;
	
	public ArrayList<ArticleImage> returnImage(String theme){
		
		ArrayList<ArticleImage> list = new ArrayList<ArticleImage>();


		
	    try {
	         // 1. Get connection
	         myConn = DriverManager.getConnection(url, user, password);
	         // 2. Create a statement
	         myStmt = myConn.prepareStatement("SELECT A_img,A_title FROM url_info,article WHERE url_info.Url=article.Url AND theme = ?");
	         
	         myStmt.setString(1, theme);
	         // 4. Execute SQL query
	         ResultSet rs = myStmt.executeQuery();
	         ArticleImage AI;
	         while(rs.next()){
	        	 AI = new ArticleImage(rs.getString("A_title"),rs.getBytes("A_img"));
	        	 list.add(AI);
	         }
	         rs.close();
	         myStmt.close();
	         rs = null;
	         myStmt = null;
	         myConn = null;
	         
	   }
	   catch (Exception exc) {
	         exc.printStackTrace();
	   }
	    
		return list;
  }

}
