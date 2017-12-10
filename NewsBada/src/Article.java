import java.sql.Blob;
import java.sql.Connection;

public class Article {
	
	

	private String title;
	private byte[] image;
	private int view;

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public Article(String Title,byte[] Image,int View){
		this.title = Title;
		this.image = Image;
		this.view = View;
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
