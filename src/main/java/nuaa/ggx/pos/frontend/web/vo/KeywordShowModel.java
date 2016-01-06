package nuaa.ggx.pos.frontend.web.vo;

public class KeywordShowModel {
	
	private String url;
	private String color;
	private String name;
	public KeywordShowModel(String url, String color, String name) {
		super();
		this.url = url;
		this.color = color;
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
