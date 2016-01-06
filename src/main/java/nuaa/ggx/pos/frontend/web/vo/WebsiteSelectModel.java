package nuaa.ggx.pos.frontend.web.vo;

public class WebsiteSelectModel {
	
	private Integer id;
	private String name;
	private String url;
	private String type;
	private Boolean isSelected;
	
	public WebsiteSelectModel(Integer id, String name, String url, 
			String type, Boolean isSelected) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.isSelected = isSelected;
	}
	
	public WebsiteSelectModel() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Boolean getIsSelected() {
		return isSelected;
	}

	public void setIsSelected(Boolean isSelected) {
		this.isSelected = isSelected;
	}
	
}
