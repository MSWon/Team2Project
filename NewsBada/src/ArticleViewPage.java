import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Blob;

public class ArticleViewPage {
	
	private static int ColumnID; 

	private JFrame frame;
	JPanel panel = new JPanel();
	private JTextField textField;  // 뉴스텍스트
	private JTextField textTitle;  // 뉴스타이틀
	private JTextField text;  // 추가메뉴

	static loadingMysql lm;
	
	static String ColumnText = null;
	static String ColumnTitle = null;
	static String ColumnImgae = null;
	
	static Blob blob;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// 칼럼 번호를 삽입해야 하는 부분
					int id =28;
					// 칼럼 번호 삽입해야하는 부분
					ArticleViewPage window = new ArticleViewPage(id);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArticleViewPage(int columnID) {
		
		// 칼럼 번호 입력 하는 부분
		ArticleViewPage.ColumnID = columnID;
		try {
			loadingMysql lm = new loadingMysql(ColumnID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initialize(lm);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(loadingMysql lmclass) {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1800, 900);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		
		frame.setContentPane(panel);
		frame.setLocation(150, 100);
		
		GridLayout gl = new GridLayout(2,1);
		panel.setLayout(gl);
		panel.setSize(800, 1200);
		
		
		JButton btnNewButton = new JButton();
		
		// Image File insert here!
		try {
			String path = new String();
			blob = lmclass.ColumnImage;
			if (path != null) {
				System.out.println(path);
				URL image = new URL(path);
				BufferedImage img = ImageIO.read(image);
				btnNewButton.setIcon(new ImageIcon(img));
			}
			else btnNewButton.setIcon(new ImageIcon());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.getContentPane().add(btnNewButton);
		
		JPanel innerFrame = new JPanel();
		GridLayout innerGl = new GridLayout(3,1);
		innerFrame.setLayout(innerGl);
		innerFrame.setSize(800, 600);
		
		frame.getContentPane().add(innerFrame);
		
		// 뉴스 타이틀 삽입 부분
		textTitle = new JTextField();
		
		//News Text insert here
		if (lm.ColumnTitle != null){
			ColumnTitle = lm.ColumnTitle;
			textTitle.setText(lm.ColumnTitle);
		}
		else {
			textTitle.setText("값을 가져올 수 없습니다.");
		}
		innerFrame.add(textTitle);
		textTitle.setColumns(10);
		
		// 뉴스 텍스트 삽입 부분
		textField = new JTextField();
		
		// News Title insert here
		if (lm.ColumnText != null){
			ColumnText = lm.ColumnText;
			textField.setText(lm.ColumnText);
		}
		else{
			textTitle.setText("값을 가져올 수 없습니다.");
		}
		
		innerFrame.add(textField);
		textField.setColumns(10);
		
		
		// 추가 메뉴 삽입
		
		frame.pack();
		frame.setVisible(true);
		
	}

}

class loadingMysql {
	
	static Statement stmt = null;
	static Statement stmt1 = null;
	static Connection conn = null;
	
	// article 테이블 정보 불러오기
	public static String ColumnURL = new String();
	public static String ColumnTheme = new String();
	public static String ColumnPname = new String();
	public static String ColumnViews = new String();
	public static String ColumnMale = new String();
	public static String ColumnFemale = new String();

	
	// url_info 테이블 정보 불러오기
	public static String ColumnDate = new String();
	public static String ColumnTitle = new String();
	public static String ColumnText = new String();
	public static Blob ColumnImage;
	
	public loadingMysql (int i) throws Exception {
		// 1.  드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 테이블 이름 수정 필요
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsbada","root","1111");
			System.out.println("DB Connection OK!");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB Driver Error!");
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB Connection Error!");
		}
		
		
		// article 테이블의 정보 불러오기
		String sql = "select * from article";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				if(rs.getInt("A_Number")==i){
					// article 테이블의 정보 불러오기
					ColumnURL = rs.getString("Url");
					ColumnTheme = rs.getString("Theme");
					ColumnPname = rs.getString("P_name");
					ColumnViews = rs.getString("Views");
					ColumnMale = rs.getString("Male");
					ColumnFemale = rs.getString("Female");
					
					System.out.println("url: "+ColumnURL);
					System.out.println("Theme: "+ColumnTheme);
					System.out.println("P_name: "+ColumnPname);
					System.out.println("Views: "+ColumnViews);
					System.out.println("Male: "+ColumnMale);
					System.out.println("Female: "+ColumnFemale);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// article 테이블의 정보 불러오기
		String sql2 = "select * from url_info where Url='" +ColumnURL+"'";
		try {
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql2);
			
			while(rs1.next()){
				// article 테이블의 정보 불러오기
				ColumnDate = rs1.getString("Date");
				ColumnTitle = rs1.getString("A_title");
				ColumnText = rs1.getString("A_text");
				//ColumnImage = rs1.getString("A_img");
				try{
					ColumnImage = (Blob) rs1.getBlob("A_img");
					int blobLength = (int) ColumnImage.length();  
	
					byte[] bytes = ColumnImage.getBytes(1, blobLength);
					ColumnImage.free();
					BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
				} catch(Exception e){
					e.getStackTrace();
				}
					
				System.out.println("Date: "+ColumnDate);
				System.out.println("A_title: "+ColumnTitle);
				System.out.println("A_img: "+ColumnText);
				System.out.println("Female: "+ColumnImage);
				}
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

