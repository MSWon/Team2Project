
import java.util.*;
import java.sql.*;
import java.io.*;
import java.math.BigDecimal;


public class EmployeeDAO {

	private Connection myConn;
	
	public EmployeeDAO() throws Exception {
		
		// get db properties
		 String url = "jdbc:mysql://localhost:3306/newsbada";  //newsbada <- mysql에 있는 (내가 불러올) 스키마 이름
		 String user = "root"; 
		 String password = "1111";  // 자기꺼 비밀번호
		
		// connect to database
		myConn = DriverManager.getConnection(url, user, password);
		
		System.out.println("DB connection successful to: " + url);
	}
	
	public List<Employee> getAllEmployees() throws Exception {
		List<Employee> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select A_title,Views,article.Url from url_info,article where url_info.Url=article.Url ORDER BY Views DESC");
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Employee> searchEmployees(String A_title) throws Exception {
		List<Employee> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			A_title = '%'+A_title+'%';
			myStmt = myConn.prepareStatement("select A_title,Views,article.Url from url_info,article where url_info.Url=article.Url AND A_title like ? ORDER BY Views DESC");
			
			myStmt.setString(1, A_title);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Employee tempEmployee = convertRowToEmployee(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private Employee convertRowToEmployee(ResultSet myRs) throws SQLException {
		
		String A_title = myRs.getString("A_Title");
		String Url = myRs.getString("Url");
		int Views = myRs.getInt("Views");
		
		Employee tempEmployee = new Employee(A_title,Url,Views);
		
		return tempEmployee;
	}

	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	public static void main(String[] args) throws Exception {
		
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.searchEmployees("thom"));

		System.out.println(dao.getAllEmployees());
	}
}
