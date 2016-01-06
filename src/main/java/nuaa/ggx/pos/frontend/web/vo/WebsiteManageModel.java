package nuaa.ggx.pos.frontend.web.vo;

import java.sql.Timestamp;

public class WebsiteManageModel {
	
	private Integer id;
	private String name;
	private String url;
	private String type;
	private Integer updateNum;
	private Timestamp updateTime;
	private Boolean isPublic;
	
	public WebsiteManageModel(Integer id, String name, String url, String type,
			Integer updateNum,  Timestamp updateTime, Boolean isPublic) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
		this.type = type;
		this.updateNum = updateNum;
		this.updateTime = updateTime;
		this.isPublic = isPublic;
	}
	
	public WebsiteManageModel() {
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
	public Integer getUpdateNum() {
		return updateNum;
	}
	public void setUpdateNum(Integer updateNum) {
		this.updateNum = updateNum;
	}	
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Boolean getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}	
}
