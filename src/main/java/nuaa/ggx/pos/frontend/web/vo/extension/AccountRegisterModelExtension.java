package nuaa.ggx.pos.frontend.web.vo.extension;

import nuaa.ggx.pos.frontend.model.TUser;
import nuaa.ggx.pos.frontend.web.vo.AccountRegisterModel;

public class AccountRegisterModelExtension {
	public static TUser toAccount(AccountRegisterModel registerModel){
		TUser user=new TUser();
		user.setTrueName(registerModel.getName());
		user.setEmail(registerModel.getEmail());
		user.setMobileNumber(registerModel.getMobile());
		user.setTypeId(1);
		user.setUsername(registerModel.getUsername());
		user.setPassword(registerModel.getPassword());
		
		return user;
	}
}
