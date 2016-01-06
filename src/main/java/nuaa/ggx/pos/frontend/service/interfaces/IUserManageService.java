package nuaa.ggx.pos.frontend.service.interfaces;

import java.security.NoSuchAlgorithmException;

import nuaa.ggx.pos.frontend.model.TUser;

public interface IUserManageService {

	public TUser findById(Integer id);
	
	public void save(TUser user);
	
	public void update(TUser user);
	
	public TUser findByIdName(String name);
}
