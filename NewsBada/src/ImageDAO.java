import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ImageDAO {
	
    // MySQL 연결
    static String url = "jdbc:mysql://localhost:3306/newsbada";  //newsbada <- mysql에 있는 (내가 불러올) 스키마 이름
    static String user = "root"; 
    static String password = "1111";  // 자기꺼 비밀번호
    
	static Connection myConn = null;
	static PreparedStatement myStmt = null;
	ResultSet rs = null;
	
	public ArrayList<Article> returnImage(String theme){
		ArrayList<Article> list = new ArrayList<Article>();
		try {
	         // 1. Get connection
	         myConn = DriverManager.getConnection(url, user, password);
	         // 2. Create a statement
	    
	         myStmt = myConn.prepareStatement("SELECT article.Url,A_img,Theme,A_title,Views,A_Number,P_name,Male,Female,Date,A_text "
	         		+ "FROM url_info,article WHERE url_info.Url=article.Url AND theme = ? ORDER BY Views DESC");
	         
	         myStmt.setString(1, theme);
	         // 4. Execute SQL query
	         ResultSet rs = myStmt.executeQuery();
	         Article AI;
	         while(rs.next()){
	        	 AI = new Article();
	        	 AI.setUrl(rs.getString("Url"));
	        	 AI.setImage(rs.getBytes("A_img"));
	        	 AI.setTheme(rs.getString("Theme"));
	        	 AI.setTitle(rs.getString("A_title"));
	        	 AI.setView(rs.getInt("Views"));
	        	 AI.setA_number(rs.getInt("A_Number"));
	        	 AI.setP_name(rs.getString("P_name"));
	        	 AI.setMale(rs.getInt("Male"));
	        	 AI.setFemale(rs.getInt("Female"));
	        	 AI.setDate(rs.getString("Date"));
	        	 AI.setText(rs.getString("A_text"));
	        
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
	



