package nuaa.ggx.pos.frontend.web.vo;

import java.sql.Timestamp;

public class WebsiteShowModel {
	
	private String name;
	private String url;
	private Integer updateNum;
	private Timestamp updateTime;	
	
	public WebsiteShowModel(String name, String url, Integer updateNum,
			Timestamp updateTime) {
		super();
		this.name = name;
		this.url = url;
		this.updateNum = updateNum;
		this.updateTime = updateTime;
	}

	public WebsiteShowModel() {
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
}
