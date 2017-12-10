import java.sql.Blob;
import java.sql.Connection;

public class Article {
	
	

	private String title;
	private int a_number;
	private byte[] image;
	private int view;
	
	public int getA_number() {
		return a_number;
	}

	public void setA_number(int a_number) {
		this.a_number = a_number;
	}


	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public Article(String Title,byte[] Image,int View,int A_Number){
		this.title = Title;
		this.image = Image;
		this.view = View;
		this.a_number = A_Number;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	


}
