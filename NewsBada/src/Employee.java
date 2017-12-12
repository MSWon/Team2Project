
import java.math.BigDecimal;

/**
 * 
 * @author www.luv2code.com
 *
 */
public class Employee {

	private String A_title;
	private String Url;
	private int Views;
	
	public Employee(String A_title, String Url,int Views) {
		super();
		this.A_title = A_title;
		this.Url = Url;
		this.Views = Views;
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
				.format("Employee [A_title=%s, Url=%s, Views=%s]",A_title, Url,Views);
	}



	public int getViews() {
		return Views;
	}



	public void setViews(int views) {
		Views = views;
	}
	
	
		
}
