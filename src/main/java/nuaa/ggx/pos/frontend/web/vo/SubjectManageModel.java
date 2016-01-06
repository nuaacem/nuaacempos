package nuaa.ggx.pos.frontend.web.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SubjectManageModel {
	private Integer id;
	private String name;
	private String desc;
	private Timestamp updateTime;
	private Integer updateNum;
	private Integer heat;
	private String hotWord;
	private List<KeywordManageModel> keywords = new ArrayList<KeywordManageModel>(0);
	private List<WebsiteManageModel> websites = new ArrayList<WebsiteManageModel>(0);
	
	public SubjectManageModel(Integer id, String name, String desc,
			Timestamp updateTime, Integer updateNum, Integer heat,
			String hotWord, List<KeywordManageModel> keywords,
			List<WebsiteManageModel> websites) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.updateTime = updateTime;
		this.updateNum = updateNum;
		this.heat = heat;
		this.hotWord = hotWord;
		this.keywords = keywords;
		this.websites = websites;
	}
	public SubjectManageModel() {

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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getUpdateNum() {
		return updateNum;
	}
	public void setUpdateNum(Integer updateNum) {
		this.updateNum = updateNum;
	}
	public Integer getHeat() {
		return heat;
	}
	public void setHeat(Integer heat) {
		this.heat = heat;
	}
	public String getHotWord() {
		return hotWord;
	}
	public void setHotWord(String hotWord) {
		this.hotWord = hotWord;
	}
	public List<KeywordManageModel> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<KeywordManageModel> keywords) {
		this.keywords = keywords;
	}
	public List<WebsiteManageModel> getWebsites() {
		return websites;
	}
	public void setWebsites(List<WebsiteManageModel> websites) {
		this.websites = websites;
	}
	
}
