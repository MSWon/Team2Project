
import java.math.BigDecimal;

/**
 * 
 * @author www.luv2code.com
 *
 */
public class Employee {

	private String A_title;
	private String Url;
	
	public Employee(String A_title, String Url) {
		super();
		this.A_title = A_title;
		this.Url = Url;
	}



	public String getA_title() {
		return A_title;
	}



	public void setA_title(String a_title) {
		A_title = a_title;
	}



	public String getUrl() {
		return Url;
	}



	public void setUrl(String url) {
		Url = url;
	}



	@Override
	public String toString() {
		return String
				.format("Employee [A_title=%s, Url=%s]",A_title, Url);
	}
	
	
		
}
