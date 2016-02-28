package nuaa.ggx.pos.frontend.web.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import nuaa.ggx.pos.frontend.model.textmodel.TextDescriptionModel;
import nuaa.ggx.pos.frontend.service.interfaces.IWeiboTopicMineService;
import nuaa.ggx.pos.frontend.web.auth.AuthPassport;

@Controller
@RequestMapping(value = "/deep/topic-mine")
public class TopicMineController {  

	@Autowired
	private IWeiboTopicMineService weiboTopicMineService;
	
	@AuthPassport
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public String list(HttpServletRequest request, Model model) {
		return "deep/topic-mine/list";
	}
  
	@AuthPassport
	@RequestMapping(value = "/mine", method = {RequestMethod.POST})
    @ResponseBody
    public String show(@RequestParam(required=false, value="weiboUrl") String weiboUrl, @RequestBody String requestBody) {
		
		TextDescriptionModel textModel = weiboTopicMineService.topicMine(weiboUrl);
		textModel = genTestModel();
		JSONObject model = new JSONObject();
        model.put("cTag", textModel.getContentTag());
        model.put("eTag", textModel.getEmotionTag());
        model.put("cWords", textModel.getContentKeywords());
        model.put("eWords", textModel.getEmotionKeywords());
        
		return model.toString();
	}
	
	private TextDescriptionModel genTestModel() {
		TextDescriptionModel model = new TextDescriptionModel();
		model.setContentTag("体育");
		model.setContentKeywords(Arrays.asList(new String[]{"篮球","足球","乒乓球"}));
		model.setEmotionKeywords(Arrays.asList(new String[]{"篮球","足球","乒乓球"}));
		return model;
	}
}  
