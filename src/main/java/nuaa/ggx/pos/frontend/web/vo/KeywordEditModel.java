package nuaa.ggx.pos.frontend.web.vo;

public class KeywordEditModel {
	
	private Integer id;
	private String name;
	
	public KeywordEditModel(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public KeywordEditModel() {
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
