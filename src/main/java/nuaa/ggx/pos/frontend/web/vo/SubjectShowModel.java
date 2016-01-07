package nuaa.ggx.pos.frontend.web.vo;

import java.sql.Timestamp;

public class SubjectShowModel {
	
	private String name;
	private String desc;
	private Integer updateNum;
	private Timestamp updateTime;	
	
	public SubjectShowModel(String name, String desc, Integer updateNum,
			Timestamp updateTime) {
		super();
		this.name = name;
		this.desc = desc;
		this.updateNum = updateNum;
		this.updateTime = updateTime;
	}

	public SubjectShowModel() {
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
