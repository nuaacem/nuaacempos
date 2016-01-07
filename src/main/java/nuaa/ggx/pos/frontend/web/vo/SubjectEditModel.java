package nuaa.ggx.pos.frontend.web.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectEditModel {
	private Integer id;
	private Integer userId;
	private String name;
	private String desc;
	private Map<String, KeywordEditModel> keywords = new HashMap<String, KeywordEditModel>();
	private List<Integer> websites = new ArrayList<Integer>(0);
	
	public SubjectEditModel(Integer id, Integer userId, String name, String desc,
			Map<String, KeywordEditModel> keywords,
			List<Integer> websites) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.desc = desc;
		this.keywords = keywords;
		this.websites = websites;
	}
	public SubjectEditModel() {

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Map<String, KeywordEditModel> getKeywords() {
		return keywords;
	}
	public void setKeywords(Map<String, KeywordEditModel> keywords) {
		this.keywords = keywords;
	}
	public List<Integer> getWebsites() {
		return websites;
	}
	public void setWebsites(List<Integer> websites) {
		this.websites = websites;
	}
	
}
