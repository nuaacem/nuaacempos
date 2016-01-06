package nuaa.ggx.pos.frontend.web.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import nuaa.ggx.pos.frontend.model.TUser;
import nuaa.ggx.pos.frontend.service.interfaces.IUserService;
import nuaa.ggx.pos.frontend.web.auth.AccountAuth;
import nuaa.ggx.pos.frontend.web.auth.AuthHelper;
import nuaa.ggx.pos.frontend.web.vo.AccountLoginModel;
import nuaa.ggx.pos.frontend.web.vo.AccountRegisterModel;
import nuaa.ggx.pos.frontend.web.vo.extension.AccountRegisterModelExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/account")
public class AccountController {  
	
	@Autowired
    @Qualifier("UserService")
    private IUserService userService;
	
	@RequestMapping(value="/login", method = {RequestMethod.GET})
    public String login(Model model){
		if(!model.containsAttribute("contentModel"))
            model.addAttribute("contentModel", new AccountLoginModel());
        return "account/login";
    }
	
	@RequestMapping(value="/login", method = {RequestMethod.POST})
	public String login(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AccountLoginModel accountLoginModel, BindingResult result) throws NoSuchAlgorithmException{
		//如果有验证错误 返回到form页面
        if(result.hasErrors())
            return login(model);
        TUser user = userService.login(accountLoginModel.getUsername().trim(), accountLoginModel.getPassword().trim());
        if(user==null){
        	if(user==null){
	        	result.addError(new FieldError("contentModel","username","用户名或密码错误。"));
	        	result.addError(new FieldError("contentModel","password","用户名或密码错误。"));
        	}
            return login(model);
        }
        else{
        	AccountAuth accountAuth=new AccountAuth(user.getId(), user.getTrueName(), user.getUsername());
        	AuthHelper.setSessionAccountAuth(request, accountAuth);
        }
        String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
        if(returnUrl==null)
        {
        	returnUrl="/home/index";
        }
        return "redirect:"+returnUrl; 	
	}
	
	@RequestMapping(value="/register", method = {RequestMethod.GET})
    public String register(Model model) {
		if(!model.containsAttribute("contentModel"))
		{
            model.addAttribute("contentModel", new AccountRegisterModel());
		}
        return "account/register";
    }
	
	@RequestMapping(value="/register", method = {RequestMethod.POST})
	public String register(HttpServletRequest request, Model model, @Valid @ModelAttribute("contentModel") AccountRegisterModel accountRegisterModel, BindingResult result) throws NoSuchAlgorithmException{
		if(!accountRegisterModel.getPassword().equals(accountRegisterModel.getConfirmPassword()))
			result.addError(new FieldError("contentModel","confirmPassword","确认密码与密码输入不一致。"));
		//如果有验证错误 返回到form页面
        if(result.hasErrors())
        {
            return register(model);
        }
        else if(userService.accountExist(accountRegisterModel.getUsername()))
        {
        	result.addError(new FieldError("contentModel","username","该用户名已被注册。"));
            return register(model);
        }      
        userService.saveRegister(AccountRegisterModelExtension.toAccount(accountRegisterModel));
        
        String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
        if(returnUrl==null)
        	returnUrl="login";
    	return "redirect:"+returnUrl; 	
	}
	
	@RequestMapping(value="/logout", method = {RequestMethod.GET})
    public String logout(HttpServletRequest request){
		AuthHelper.removeSessionAccountAuth(request);
		return "redirect:login";
	}
}  
