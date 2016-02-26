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
import nuaa.ggx.pos.frontend.util.Constants;
import nuaa.ggx.pos.frontend.util.pager.PageList;
import nuaa.ggx.pos.frontend.web.auth.AccountAuth;
import nuaa.ggx.pos.frontend.web.auth.AuthPassport;
import nuaa.ggx.pos.frontend.web.vo.ConsensusShowModel;
import nuaa.ggx.pos.frontend.web.vo.FeedShowModel;
import nuaa.ggx.pos.frontend.web.vo.KeywordShowModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectManageModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectShowModel;
import nuaa.ggx.pos.frontend.web.vo.WebsiteShowModel;
import nuaa.ggx.pos.frontend.web.vo.extension.FeedModelExtension;
import nuaa.ggx.pos.frontend.web.vo.extension.KeywordModelExtension;
import nuaa.ggx.pos.frontend.web.vo.extension.SubjectModelExtension;
import nuaa.ggx.pos.frontend.web.vo.extension.WebsiteModelExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping(value = "/deep/topic-mine")
public class TopicMineController {  

	@Autowired
	private ISubjectManageService subjectManageService;
	
	@AuthPassport
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public String list(HttpServletRequest request, Model model) {
		if (!model.containsAttribute("contentModel")) {
			AccountAuth accountAuth = (AccountAuth)request.getSession().getAttribute("accountAuth");
			List<TSubject> tSubjects = subjectManageService.findByUserId(accountAuth.getId());
			List<SubjectManageModel> subjectModels = new ArrayList<SubjectManageModel>();
			
			for (TSubject tSubject : tSubjects) {
				subjectModels.add(SubjectModelExtension.toSubjectManageModel(tSubject));
			}
			model.addAttribute("contentModel", subjectModels);
		}
		return "deep/topic-mine/list";
	}
  
	@AuthPassport
	@RequestMapping(value = "/mine", method = {RequestMethod.POST})
    @ResponseBody
    public String show(@RequestBody String weiboUrl) {

		
		return "abc";
	}
	
}  
