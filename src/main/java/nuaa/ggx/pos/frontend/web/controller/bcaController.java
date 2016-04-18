package nuaa.ggx.pos.frontend.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import nuaa.ggx.pos.frontend.model.TFeed;
import nuaa.ggx.pos.frontend.model.TKeyword;
import nuaa.ggx.pos.frontend.model.TSubject;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.service.interfaces.IFeedService;
import nuaa.ggx.pos.frontend.service.interfaces.ISubjectManageService;
import nuaa.ggx.pos.frontend.service.interfaces.IWebsiteManageService;
import nuaa.ggx.pos.frontend.web.auth.AccountAuth;
import nuaa.ggx.pos.frontend.web.auth.AuthPassport;
import nuaa.ggx.pos.frontend.web.vo.FeedShowModel;
import nuaa.ggx.pos.frontend.web.vo.KeywordShowModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectShowModel;
import nuaa.ggx.pos.frontend.web.vo.WebsiteShowModel;
import nuaa.ggx.pos.frontend.web.vo.extension.FeedModelExtension;
import nuaa.ggx.pos.frontend.web.vo.extension.KeywordModelExtension;
import nuaa.ggx.pos.frontend.web.vo.extension.SubjectModelExtension;
import nuaa.ggx.pos.frontend.web.vo.extension.WebsiteModelExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bca")
public class bcaController {  

	@Autowired
	private IWebsiteManageService websiteManageService;	
	@Autowired
	private ISubjectManageService subjectManageService;
	
	@AuthPassport
    @RequestMapping(value = "/discover")
    public String discover(HttpServletRequest request, Model model) {
    	AccountAuth accountAuth = (AccountAuth) request.getSession()
    									.getAttribute("accountAuth");
    	if (!model.containsAttribute("websiteList")) {
    		List<TWebsite> tWebsites = websiteManageService.findByUserId(accountAuth.getId());
//    		List<TWebsite> tWebsites = websiteManageService.findByUserId(1);
    		List<WebsiteShowModel> websiteShowModels = new ArrayList<WebsiteShowModel>();
    		for (TWebsite tWebsite : tWebsites) {
    			websiteShowModels.add(WebsiteModelExtension.toWebsiteShowModel(tWebsite));
			}
    		model.addAttribute("websiteList", websiteShowModels);
    	}
    	if (!model.containsAttribute("keywordList")) {
    		List<TSubject> tSubjects = subjectManageService.findByUserId(accountAuth.getId());
//    		List<TSubject> tSubjects = subjectManageService.findByUserId(1);
    		List<TKeyword> tKeywords = new ArrayList<TKeyword>();
    		List<KeywordShowModel> keywordShowModels = new ArrayList<KeywordShowModel>();
    		for (TSubject tSubject : tSubjects) {
    			tKeywords.addAll(tSubject.getTKeywords());
    		}
    		for (TKeyword tKeyword : tKeywords) {
				keywordShowModels.add(KeywordModelExtension.toKeywordShowModel(tKeyword));
			}
    		model.addAttribute("keywordList", keywordShowModels);
    	}
    	if (!model.containsAttribute("subjectList")) {
    		List<TSubject> tSubjects = subjectManageService.findByUserId(accountAuth.getId());
//    		List<TSubject> tSubjects = subjectManageService.findByUserId(1);
    		List<SubjectShowModel> subjectShowModels = new ArrayList<SubjectShowModel>();
    		for (TSubject tSubject : tSubjects) {
    			subjectShowModels.add(SubjectModelExtension.toSubjectShowModel(tSubject));
			}
    		model.addAttribute("subjectList", subjectShowModels);
    	}
        return "bca/discover";
    }  
}  
