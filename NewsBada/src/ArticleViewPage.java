import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class ArticleViewPage {
	
	private static int ColumnID; 
	private static String ColumnTheme;

	private JFrame frame;
	JPanel panel = new JPanel();
	private JTextArea textField;  // 뉴스텍스트
	private JTextField textTitle;  // 뉴스타이틀
	private JTextField text;  // 추가메뉴

	static loadingMysql lm;
	
	static String ColumnText = null;
	static String ColumnTitle = null;
	static String ColumnImgae = null;
	private JLabel lblNewsbade;
	private JTextField textField_1;
	
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
					ArticleViewPage window = new ArticleViewPage("정치",id);
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
	public ArticleViewPage(String theme, int columnID) {
		
		this.ColumnTheme = theme;
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
	@SuppressWarnings("deprecation")
	private void initialize(loadingMysql lmclass) {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.text);
		frame.setLocation(150, 100);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(new URI(lm.ColumnURL));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Article path;
		int views = Integer.parseInt(lm.ColumnViews);
		// Image File insert here!
		
		try {
			path = new Article(lm.ColumnURL, lm.ColumnImage, views);
			
			if (path != null) {
				ImageIcon image = new ImageIcon(new ImageIcon(path.getImage()).getImage()
						.getScaledInstance(400, 300, Image.SCALE_SMOOTH));
				btnNewButton.setIcon(image);
				
				
			}
			else btnNewButton.setIcon(new ImageIcon());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//News Title insert here
		

		// 뉴스 텍스트 삽입 부분
		textField = new JTextArea();
		textField.setBackground(UIManager.getColor("CheckBox.background"));
		textField.setEditable(false);
		textField.setLineWrap(true);
		textField.setFont(new Font("굴림", Font.PLAIN, 20));
		textField.setColumns(10);
		
		// News Field insert here
		if (lm.ColumnText != null){
			ColumnText = lm.ColumnText;
			textField.setText(lm.ColumnText);
		}
		else{
			textField.setText("값을 가져올 수 없습니다.");
		}
		
		// 뉴스 타이틀 삽입 부분
		textTitle = new JTextField();
		textTitle.setBackground(UIManager.getColor("Button.light"));
		textTitle.setEditable(false);
		textTitle.setFont(new Font("굴림", Font.PLAIN, 24));
		textTitle.setColumns(10);
		if (lm.ColumnTitle != null){
			ColumnTitle = lm.ColumnTitle;
			textTitle.setText(lm.ColumnTitle);
		}
		else {
			textTitle.setText("값을 가져올 수 없습니다.");
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		
		// 수정
		int sum = Integer.parseInt(lm.ColumnFemale) + Integer.parseInt(lm.ColumnMale);
		int a = 0;
		int b = 0;
		try{
			a = (Integer.parseInt(lm.ColumnMale)*100 / sum);
			b = (Integer.parseInt(lm.ColumnFemale)*100 / sum);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		JLabel lblMan = new JLabel("male: "+a+"%");
		lblMan.setFont(new Font("굴림", Font.PLAIN, 20));
		
		// 수정
		JLabel lblFemale = new JLabel("female: "+b+"%");
		lblFemale.setFont(new Font("굴림", Font.PLAIN, 20));
		
		// URL, 신문사, 날짜
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.disabledShadow"));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setText(lm.ColumnURL+"                    "+lm.ColumnPname+"                    "+lm.ColumnDate);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setText("Views: "+lm.ColumnViews);
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1112, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 425, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(lblFemale, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblMan, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
										.addComponent(textTitle, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
										.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))))
							.addGap(10))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textTitle, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
					.addGap(10)
					.addComponent(lblMan, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFemale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel))
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{489, 134, 0};
		gbl_panel_1.rowHeights = new int[]{28, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		
	
		lblNewsbade = new JLabel("NewsBada");
		lblNewsbade.setForeground(SystemColor.textHighlightText);
		lblNewsbade.setFont(new Font("HY목각파임B", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewsbade = new GridBagConstraints();
		gbc_lblNewsbade.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewsbade.gridx = 1;
		gbc_lblNewsbade.gridy = 1;
		panel_1.add(lblNewsbade, gbc_lblNewsbade);
		frame.getContentPane().setLayout(groupLayout);
		
		
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
	public static byte[] ColumnImage;
	
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
		String sql = "select * from article ORDER BY Views DESC";
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
		String sql2 = "select * from url_info where Url = '" + ColumnURL+"'";
		try {
			Statement stmt1 = conn.createStatement();
			ResultSet rs1 = stmt1.executeQuery(sql2);
			
			while(rs1.next()){
				// article 테이블의 정보 불러오기
				ColumnDate = rs1.getString("Date");
				ColumnTitle = rs1.getString("A_title");
				ColumnText = rs1.getString("A_text");
				ColumnImage = rs1.getBytes("A_img");
					
				System.out.println("P_name: "+ColumnDate);
				System.out.println("Views: "+ColumnTitle);
				System.out.println("text: "+ColumnText);
				//System.out.println("Female: "+ColumnImage);
				}
			
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


