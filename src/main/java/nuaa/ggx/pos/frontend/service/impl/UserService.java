package nuaa.ggx.pos.frontend.service.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nuaa.ggx.pos.frontend.dao.impl.UserDao;
import nuaa.ggx.pos.frontend.dao.interfaces.ICollectWebsiteDao;
import nuaa.ggx.pos.frontend.dao.interfaces.IWebsiteDao;
import nuaa.ggx.pos.frontend.model.TCollectWebsite;
import nuaa.ggx.pos.frontend.model.TUser;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.service.interfaces.IUserService;
import nuaa.ggx.pos.frontend.util.StringHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService implements IUserService{

	@Autowired
	private UserDao userdao;
	
	@Autowired
	private IWebsiteDao websiteDao;

	@Autowired
	private ICollectWebsiteDao collectWebsiteDao;
	
	@Override
	public TUser getById(Integer id) {
		return userdao.getById(id);
	}
	
	@Override
	public TUser loadById(Integer id) {
		return userdao.loadById(id);
	}

	@Override
	public TUser login(String username, String password) throws NoSuchAlgorithmException {
		String encodePassword = StringHelper.md5(username+password);
		return userdao.findWhenLogin(username, encodePassword);
	}

	@Override
	public boolean accountExist(String username) {
		return userdao.findIfExists(username);
	}

	@Override
	public void saveRegister(TUser user) throws NoSuchAlgorithmException {
		user.setPassword(StringHelper.md5(user.getUsername()+user.getPassword()));
		user.setCreateTime(new Timestamp(System.currentTimeMillis()));
		user = userdao.merge(user);
		List<TCollectWebsite> collectWebsites = collectWebsiteDao.findPublicWebsite();
		for (TCollectWebsite tCollectWebsite : collectWebsites) {
			TWebsite website = new TWebsite();
			website.setTUser(user);
			website.setTCollectWebsite(tCollectWebsite);
			website.setUrl(tCollectWebsite.getUrl());
			websiteDao.save(website);
		}
	}
	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println(StringHelper.md5("yc12345678"));
	}
}
