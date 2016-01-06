package nuaa.ggx.pos.frontend.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import nuaa.ggx.pos.frontend.model.TSubject;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.service.interfaces.ISubjectManageService;
import nuaa.ggx.pos.frontend.service.interfaces.IWebsiteManageService;
import nuaa.ggx.pos.frontend.web.auth.AccountAuth;
import nuaa.ggx.pos.frontend.web.auth.AuthPassport;
import nuaa.ggx.pos.frontend.web.vo.SubjectEditModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectManageModel;
import nuaa.ggx.pos.frontend.web.vo.WebsiteSelectModel;
import nuaa.ggx.pos.frontend.web.vo.extension.SubjectModelExtension;
import nuaa.ggx.pos.frontend.web.vo.extension.WebsiteModelExtension;

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
@RequestMapping(value = "/subject")
public class SubjectController {  

	@Autowired
	@Qualifier("SubjectManageService")
	public ISubjectManageService subjectManageService;
	
	@Autowired
	@Qualifier("WebsiteManageService")
	public IWebsiteManageService websiteManageService;
	
	@AuthPassport
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public String list(HttpServletRequest request, Model model) {
		if (!model.containsAttribute("contentModel")) {
			AccountAuth accountAuth = (AccountAuth)request.getSession().getAttribute("accountAuth");
			List<TSubject> tSubjects = subjectManageService.findByUserId(accountAuth.getId());
//			List<TSubject> tSubjects = subjectManageService.findByUserId(1);
			List<SubjectManageModel> subjectModels = new ArrayList<SubjectManageModel>();
			
			for (TSubject tSubject : tSubjects) {
				subjectModels.add(SubjectModelExtension.toSubjectManageModel(tSubject));
			}
			model.addAttribute("contentModel", subjectModels);
		}
		return "subject/list";
	}
    
	@AuthPassport
	@RequestMapping(value = "/add", method = {RequestMethod.GET})
	public String add(HttpServletRequest request, Model model){	
		if (!model.containsAttribute("contentModel")) {
			SubjectEditModel subjectEditModel = new SubjectEditModel();
			AccountAuth accountAuth = (AccountAuth)request
					.getSession().getAttribute("accountAuth");
			
//			KeywordEditModel keywordEditModel = new KeywordEditModel(1, "体育生");
//			Map<String, KeywordEditModel> keywords = new HashMap<String, KeywordEditModel>();
//			keywords.put(keywordEditModel.getName(),keywordEditModel);
//			subjectEditModel.setKeywords(keywords);
			
			List<TWebsite> tWebsites = websiteManageService.findByUserId(accountAuth.getId());
//			List<TWebsite> tWebsites = websiteManageService.findByUserId(1);
			List<WebsiteSelectModel> websiteSelectModels = new ArrayList<WebsiteSelectModel>();
			for (TWebsite tWebsite : tWebsites) {
				 websiteSelectModels.add(WebsiteModelExtension.toWebsiteSelectModel(tWebsite,new ArrayList<Integer>()));
			}
			model.addAttribute("contentModel", subjectEditModel);
			model.addAttribute("websiteSelectModel", websiteSelectModels);
		}
		return "subject/edit";
	}
	
	@AuthPassport
	@RequestMapping(value = "/add", method = {RequestMethod.POST})
	public String add(HttpServletRequest request, Model model, @Valid @ModelAttribute SubjectEditModel subjectEditModel, BindingResult result) throws IOException{	
		if (result.hasErrors()) {
            return add(request, model);
		}		
		AccountAuth accountAuth = (AccountAuth)request
				.getSession().getAttribute("accountAuth");
		subjectEditModel.setUserId(accountAuth.getId());
//		subjectEditModel.setUserId(1);
		subjectManageService.save(subjectEditModel);
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		if(returnUrl==null)
        	returnUrl="list";
    	return "redirect:"+returnUrl;
	}
	
	@AuthPassport
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.GET})	
	public String edit(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id){	
		if (!model.containsAttribute("contentModel")) {
			SubjectEditModel subjectEditModel = SubjectModelExtension.toSubjectEditModel(subjectManageService.getById(id));
			AccountAuth accountAuth = (AccountAuth)request
					.getSession().getAttribute("accountAuth");
//			KeywordEditModel keywordEditModel = new KeywordEditModel(1, "体育生");
//			Map<String, KeywordEditModel> keywords = new HashMap<String, KeywordEditModel>();
//			keywords.put(keywordEditModel.getName(),keywordEditModel);
//			subjectEditModel.setKeywords(keywords);
			
			List<TWebsite> tWebsites = websiteManageService.findByUserId(accountAuth.getId());
//			List<TWebsite> tWebsites = websiteManageService.findByUserId(1);
			List<WebsiteSelectModel> websiteSelectModels = new ArrayList<WebsiteSelectModel>();
			for (TWebsite tWebsite : tWebsites) {
				 websiteSelectModels.add(WebsiteModelExtension.toWebsiteSelectModel(tWebsite,subjectEditModel.getWebsites()));
			}
			model.addAttribute("contentModel", subjectEditModel);
			model.addAttribute("websiteSelectModel", websiteSelectModels);
		}
		return "subject/edit";
	}
	
	@AuthPassport
	@RequestMapping(value = "/edit/{id}", method = {RequestMethod.POST})
	public String edit(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id, @Valid @ModelAttribute SubjectEditModel subjectEditModel, BindingResult result) throws IOException{	
		if (result.hasErrors()) {
            return add(request, model);
		}		
		AccountAuth accountAuth = (AccountAuth)request
				.getSession().getAttribute("accountAuth");
		subjectEditModel.setUserId(accountAuth.getId());
//		subjectEditModel.setUserId(1);
		subjectManageService.update(subjectEditModel);
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		if(returnUrl==null)
        	returnUrl="/subject/list";
    	return "redirect:"+returnUrl;
	}
	
	@AuthPassport
	@RequestMapping(value = "/delete/{id}", method = {RequestMethod.GET})
	public String delete(HttpServletRequest request, Model model, @PathVariable(value="id") Integer id) {	
		subjectManageService.delete(id);
		String returnUrl = ServletRequestUtils.getStringParameter(request, "returnUrl", null);
		if(returnUrl==null)
        	returnUrl="/subject/list";
        return "redirect:"+returnUrl;	
	}
}  
