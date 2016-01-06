package nuaa.ggx.pos.frontend.web.auth;

/**
 * 用户的登录状态，保存于cookie中
 * @author RY
 * 2016年1月6日
 */
public class AccountAuth {
	
	private Integer id;
	private String name;
	private String username;
	private Integer typeId;
	
	public AccountAuth(Integer id, String name, String username){
		this.id=id;
		this.name=name;
		this.username=username;
	}
	
	public void setId(Integer id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public Integer getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getUsername(){
		return this.username;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
}
