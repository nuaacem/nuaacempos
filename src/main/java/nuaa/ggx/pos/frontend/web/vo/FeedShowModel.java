package nuaa.ggx.pos.frontend.web.vo;

import java.sql.Timestamp;

public class FeedShowModel {
	private String desc;
	private Integer type;
	private Timestamp feedTime;	
	public FeedShowModel(String desc, Integer type, Timestamp feedTime) {
		super();
		this.desc = desc;
		this.type = type;
		this.feedTime = feedTime;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Timestamp getFeedTime() {
		return feedTime;
	}
	public void setFeedTime(Timestamp feedTime) {
		this.feedTime = feedTime;
	}
	
}
