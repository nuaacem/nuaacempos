package nuaa.ggx.pos.frontend.web.vo;

import java.sql.Timestamp;
import java.util.List;

public class ConsensusShowModel {
	private Integer id;
	private String title;
	private String url;
	private String from;
	private String collectTime;
	private String summary;
	private Integer clickNum;
	private Integer pole;
	private String tagwords;
	public ConsensusShowModel() {
	}	
	public ConsensusShowModel(Integer id,String title, String url, String from,
			String collectTime, String summary, Integer clickNum,
			Integer pole, String tagwords) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.from = from;
		this.collectTime = collectTime;
		this.summary = summary;
		this.clickNum = clickNum;
		this.pole = pole;
		this.tagwords = tagwords;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(String collectTime) {
		this.collectTime = collectTime;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public Integer getClickNum() {
		return clickNum;
	}
	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	public Integer getPole() {
		return pole;
	}
	public void setPole(Integer pole) {
		this.pole = pole;
	}
	public String getTagwords() {
		return tagwords;
	}
	public void setTagwords(String tagwords) {
		this.tagwords = tagwords;
	}	
}
