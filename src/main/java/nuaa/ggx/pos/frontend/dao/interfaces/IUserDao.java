package nuaa.ggx.pos.frontend.dao.interfaces;

import nuaa.ggx.pos.frontend.model.TUser;

/**
 * 范例 UserDao接口 首先按照UML类图定义接口 然后再实现
 * @author KOC-RY
 *
 */
public interface IUserDao extends IBaseDao<TUser>{
	
	public TUser findById(Integer id);
	
	public TUser findWhenLogin(String username, String password);
	public boolean findIfExists(String username);
}
