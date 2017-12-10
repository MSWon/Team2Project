import java.sql.Blob;
import java.sql.Connection;

public class ArticleImage {
	
	

	private String title;
	private byte[] image;

	public ArticleImage(String Title,byte[] Image){
		this.title = Title;
		this.image = Image;
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
