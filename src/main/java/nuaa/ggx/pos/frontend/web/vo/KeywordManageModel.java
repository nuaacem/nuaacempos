package nuaa.ggx.pos.frontend.web.vo;

public class KeywordManageModel {
	
	private Integer id;
	private String name;
	private Integer updateNum;
	private Integer consensusNum;
	
	public KeywordManageModel(Integer id, String name, Integer updateNum,Integer consensusNum) {
		super();
		this.id = id;
		this.name = name;
		this.updateNum = updateNum;
		this.consensusNum = consensusNum;
	}
	public KeywordManageModel() {
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
	public Integer getUpdateNum() {
		return updateNum;
	}
	public void setUpdateNum(Integer updateNum) {
		this.updateNum = updateNum;
	}
	public Integer getConsensusNum() {
		return consensusNum;
	}
	public void setConsensusNum(Integer consensusNum) {
		this.consensusNum = consensusNum;
	}
	
}
