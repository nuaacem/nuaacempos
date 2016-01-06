package nuaa.ggx.pos.frontend.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import nuaa.ggx.pos.frontend.model.TSubject;
import nuaa.ggx.pos.frontend.service.interfaces.IConsensusService;
import nuaa.ggx.pos.frontend.service.interfaces.ISubjectManageService;
import nuaa.ggx.pos.frontend.util.Constants;
import nuaa.ggx.pos.frontend.util.pager.PageList;
import nuaa.ggx.pos.frontend.web.auth.AccountAuth;
import nuaa.ggx.pos.frontend.web.auth.AuthPassport;
import nuaa.ggx.pos.frontend.web.vo.ConsensusShowModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectSelectModel;
import nuaa.ggx.pos.frontend.web.vo.TreeModel;
import nuaa.ggx.pos.frontend.web.vo.extension.SubjectModelExtension;
import nuaa.ggx.pos.frontend.web.vo.extension.TreeModelExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/observe")
public class ObserveController {  
	
	@Autowired
	public ISubjectManageService subjectManageService;
	@Autowired
	public IConsensusService consensusService;
	
	@AuthPassport
	@RequestMapping(value = "/list", method = {RequestMethod.GET})
	public String list(@RequestParam(required=false, value="keywordId")String keywordId, HttpServletRequest request, Model model) {
		if(!model.containsAttribute("contentModel")){
			AccountAuth accountAuth = (AccountAuth)request.getSession().getAttribute("accountAuth");
			List<TSubject> tSubjects = subjectManageService.findByUserId(accountAuth.getId());
//			List<TSubject> tSubjects = subjectManageService.findByUserId(1);
			List<SubjectSelectModel> subjectSelectModels = new ArrayList<SubjectSelectModel>();
			for (TSubject tSubject : tSubjects) {
				subjectSelectModels.add(SubjectModelExtension.toSubjectSelectModel(tSubject));
			}
			List<TreeModel> treeModels=TreeModelExtension.toTreeModels(subjectSelectModels, null, null, null);		
			String jsonString  = JSONArray.fromObject(treeModels, new JsonConfig()).toString();

			model.addAttribute("contentModel", jsonString);
			if (keywordId != null && !keywordId.equals("")) {
				model.addAttribute("ajaxSource", "show/0/" + keywordId);
			} else {
				model.addAttribute("ajaxSource", "");
			}
		}
    	return "observe/list";
    }  
	
	@AuthPassport
	@RequestMapping(value = "/show/{subjectId}/{keywordId}", method = {RequestMethod.POST})
    @ResponseBody
    public String show(@RequestBody String aoData, @PathVariable(value="subjectId") Integer subjectId, @PathVariable(value="keywordId") Integer keywordId) {

		JSONArray jsonarray = JSONArray.fromObject(aoData);
	     
        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
     
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();
     
            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getInt("value");
     
            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getInt("value");
        }
        
        consensusService.updateKeywordConsensus(keywordId, Constants.COLLECT_DATA_REFRESH_CYCLE);
        PageList<ConsensusShowModel> pageList = consensusService.findByKeywordAndList(keywordId, iDisplayStart, iDisplayLength);
        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
        getObj.put("iTotalRecords", pageList.getItemCount());//实际的行数
        getObj.put("iTotalDisplayRecords", pageList.getItemCount());//显示的行数,这个要和上面写的一样
        
        getObj.put("aaData", pageList.getItems());//要以JSON格式返回
		return getObj.toString();
	}
	
	@AuthPassport
	@RequestMapping(value = "/show/{subjectId}", method = {RequestMethod.POST})
    @ResponseBody
    public String show(@RequestBody String aoData, @PathVariable(value="subjectId") Integer subjectId) {
		JSONArray jsonarray = JSONArray.fromObject(aoData);
	     
        String sEcho = null;
        int iDisplayStart = 0; // 起始索引
        int iDisplayLength = 0; // 每页显示的行数
     
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();
     
            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getInt("value");
     
            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getInt("value");
        }
        
        consensusService.updateSubjectConsensus(subjectId, Constants.COLLECT_DATA_REFRESH_CYCLE);
        PageList<ConsensusShowModel> pageList = consensusService.findBySubjectAndList(subjectId, iDisplayStart, iDisplayLength);
        JSONObject getObj = new JSONObject();
        getObj.put("sEcho", sEcho);// 不知道这个值有什么用,有知道的请告知一下
        getObj.put("iTotalRecords", pageList.getItemCount());//实际的行数
        getObj.put("iTotalDisplayRecords", pageList.getItemCount());//显示的行数,这个要和上面写的一样
        
        getObj.put("aaData", pageList.getItems());//要以JSON格式返回
		return getObj.toString();
	}
    
}  
