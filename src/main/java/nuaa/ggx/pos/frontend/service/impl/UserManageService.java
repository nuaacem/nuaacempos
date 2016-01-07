package nuaa.ggx.pos.frontend.service.impl;
import java.security.NoSuchAlgorithmException;

import nuaa.ggx.pos.frontend.dao.impl.UserDao;
import nuaa.ggx.pos.frontend.model.TUser;
import nuaa.ggx.pos.frontend.service.interfaces.IUserManageService;
import nuaa.ggx.pos.frontend.util.StringHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@SuppressWarnings("unused")
@Service("UserManageService")
public class UserManageService implements IUserManageService{
	@Autowired
	private UserDao userdao;
	@Override
	public TUser findById(Integer id) {
		// TODO Auto-generated method stub
		return userdao.findById(id);
	}

	@Override
	public void save(TUser user) {
		// TODO Auto-generated method stub
		 userdao.save(user);
	}

	@Override
	public void update(TUser user) {
		// TODO Auto-generated method stub
		userdao.attachDirty(user);
	}

	@Override
	public TUser findByIdName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
