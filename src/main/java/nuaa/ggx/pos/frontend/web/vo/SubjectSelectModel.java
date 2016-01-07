package nuaa.ggx.pos.frontend.web.vo;

import java.util.ArrayList;
import java.util.List;

public class SubjectSelectModel {
	private Integer id;
	private String name;
	private List<KeywordSelectModel> keywords = new ArrayList<KeywordSelectModel>();
	
	public SubjectSelectModel(Integer id, String name,
							List<KeywordSelectModel> keywords) {
		super();
		this.id = id;
		this.name = name;
		this.keywords = keywords;
	}
	public SubjectSelectModel() {

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
	public List<KeywordSelectModel> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<KeywordSelectModel> keywords) {
		this.keywords = keywords;
	}
}
