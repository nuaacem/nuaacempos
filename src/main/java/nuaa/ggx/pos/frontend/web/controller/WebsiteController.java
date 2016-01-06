package nuaa.ggx.pos.frontend.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import nuaa.ggx.pos.frontend.model.TUser;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.service.interfaces.IUserService;
import nuaa.ggx.pos.frontend.service.interfaces.IWebsiteManageService;
import nuaa.ggx.pos.frontend.web.auth.AccountAuth;
import nuaa.ggx.pos.frontend.web.auth.AuthPassport;
import nuaa.ggx.pos.frontend.web.vo.WebsiteEditModel;
import nuaa.ggx.pos.frontend.web.vo.WebsiteManageModel;
import nuaa.ggx.pos.frontend.web.vo.extension.WebsiteModelExtension;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/website")
public class WebsiteController {  

	@Autowired
	@Qualifier("WebsiteManageService")
	public IWebsiteManageService websiteManageService;
	
	@Autowired
	public IUserService userService;
	
	@AuthPassport
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public String list(HttpServletRequest request, Model model) {
		if(!model.containsAttribute("contentModel")) {
			AccountAuth accountAuth = (AccountAuth)request.getSession().getAttribute("accountAuth");
			List<TWebsite> tWebsites = websiteManageService.findByUserId(accountAuth.getId());
			List<WebsiteManageModel> websiteManageModels = new ArrayList<WebsiteManageModel>();
//			List<TWebsite> tWebsites = websiteManageService.findByUserId(1);
			for (TWebsite tWebsite : tWebsites) {
				websiteManageModels.add(WebsiteModelExtension.toWebsiteManageModel(tWebsite));
			}
			model.addAttribute("contentModel", websiteManageModels);	
		}
		return "website/list";
	}
    
	@AuthPassport
	@RequestMapping(value = "/add", method = {RequestMethod.GET})
	public String add(HttpServletRequest request, Model model){	
		if (!model.containsAttribute("contentModel")) {
			WebsiteEditModel websiteEditModel = new WebsiteEditModel();
//			AccountAuth accountAuth = (AccountAuth)request.getSession().getAttribute("accountAuth");			
			model.addAttribute("contentModel", websiteEditModel);
		}
		return "website/edit";
	}
	
	@AuthPassport
	@RequestMapping(value = "/add", method = {RequestMethod.POST})
	public String add(HttpServletRequest request, Model model, @Valid @ModelAttribute WebsiteEditModel websiteEditModel, BindingResult result) throws IOException{	
		if (result.hasErrors()) {
            return add(request, model);
		}		
		AccountAuth accountAuth = (AccountAuth)request
				.getSession().getAttribute("accountAuth");
		TUser user = userService.loadById(accountAuth.getId());
//		TUser user = userService.loadById(1);
		TWebsite tWebsite = WebsiteModelExtension.toTWebsite(websiteEditModel,user);
		websiteManageService.save(tWebsite);
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		if(returnUrl==null)
        	returnUrl="list";
    	return "redirect:"+returnUrl;
	}
	
	@AuthPassport
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})	
	public String edit(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id){	
		if (!model.containsAttribute("contentModel")) {
//			AccountAuth accountAuth = (AccountAuth)request
//					.getSession().getAttribute("accountAuth");
			TWebsite tWebsite = websiteManageService.getById(id);
			WebsiteEditModel websiteEditModel = WebsiteModelExtension.toWebsiteEditModel(tWebsite);
			model.addAttribute("contentModel", websiteEditModel);
		}
		return "website/edit";
	}
	
	@AuthPassport
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.POST})
	public String edit(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id, @Valid @ModelAttribute WebsiteEditModel websiteEditModel, BindingResult result) throws IOException{	
		if (result.hasErrors()) {
            return add(request, model);
		}		
		AccountAuth accountAuth = (AccountAuth)request
				.getSession().getAttribute("accountAuth");
		TWebsite tWebsite = websiteManageService.getById(id);
		TUser user = userService.loadById(accountAuth.getId());
		tWebsite.setTUser(user);
		websiteManageService.update(WebsiteModelExtension.toTWebsite(websiteEditModel, tWebsite));
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		if(returnUrl==null)
        	returnUrl="/website/list";
    	return "redirect:"+returnUrl;
	}
	
	@AuthPassport
	@RequestMapping(value = "/delete/{ids}", method = {RequestMethod.GET})
	public String delete(HttpServletRequest request, Model model, @PathVariable(value="ids") String ids) {	
		String[] idArray = StringUtils.split(ids, ",");
		websiteManageService.deleteWebsites(idArray);
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		if(returnUrl==null)
        	returnUrl="/website/list";
        return "redirect:"+returnUrl;	
	}
}  
