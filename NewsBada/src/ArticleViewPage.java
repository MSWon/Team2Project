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
		this.ColumnID = columnID;
		try {
			loadingMysql lm = new loadingMysql(ColumnID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setLocation(150, 100);
		GridLayout gl = new GridLayout(2,1);
		frame.setLayout(gl);
		frame.setSize(800, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton();
		
		// Image File insert here!
		try {
			String path = new String();
			path = lm.ColumnImage;
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
	
	//static Statement stmt = null;
	static Connection conn = null;
	
	public String ColumnTitle = new String();
	public String ColumnURL = new String();
	public String ColumnText = new String();
	public String ColumnImage = new String();
	
	public loadingMysql (int i) throws Exception {
		// 1.  드라이버 로드
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcpractice","root","1111");
			System.out.println("DB Connection OK!");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("DB Driver Error!");
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB Connection Error!");
		}
		
		String sql = "select * from mytable";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				if(rs.getInt("A_Number")==i){
					ColumnTitle = rs.getString("Title");
					ColumnText = rs.getString("text");
					ColumnURL = rs.getString("Url");
					ColumnImage = rs.getString("Imgurl");
					System.out.println("title: "+ColumnTitle);
					System.out.println("url: "+ColumnURL);
					System.out.println("Text: "+ColumnText);
					System.out.println("Imgurl: "+ColumnImage);
					}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

