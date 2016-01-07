package nuaa.ggx.pos.frontend.web.vo;

public class KeywordSelectModel {
	
	private Integer id;
	private String name;
	
	public KeywordSelectModel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public KeywordSelectModel() {
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
}
