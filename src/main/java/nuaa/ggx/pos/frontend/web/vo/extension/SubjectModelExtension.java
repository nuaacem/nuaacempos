package nuaa.ggx.pos.frontend.web.vo.extension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nuaa.ggx.pos.frontend.model.TKeyword;
import nuaa.ggx.pos.frontend.model.TSubject;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.web.vo.KeywordEditModel;
import nuaa.ggx.pos.frontend.web.vo.KeywordManageModel;
import nuaa.ggx.pos.frontend.web.vo.KeywordSelectModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectEditModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectManageModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectSelectModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectShowModel;
import nuaa.ggx.pos.frontend.web.vo.WebsiteManageModel;

public class SubjectModelExtension {
	
	public static SubjectManageModel toSubjectManageModel(TSubject tSubject) {
		
		int heat = 0;
		int tempHeat = 0;
		String hotWord = "";
		Set<TKeyword> tKeywords = tSubject.getTKeywords();
		List<KeywordManageModel> keywordModels = new ArrayList<KeywordManageModel>(0);
		
		for (TKeyword tKeyword : tKeywords) {
			KeywordManageModel keywordManageModel = KeywordModelExtension.toKeywordModel(tKeyword);
			keywordModels.add(keywordManageModel);
			int num = keywordManageModel.getConsensusNum();
			if (num > tempHeat) {
				tempHeat = num;
				hotWord = tKeyword.getKeyword();
			}
			else if (num == tempHeat && tempHeat != 0) {
				hotWord = hotWord + "," + tKeyword.getKeyword();  
			}
			heat += num;
		}
		
		Set<TWebsite> tWebsites = tSubject.getTWebsites();
		List<WebsiteManageModel> websiteModels = new ArrayList<WebsiteManageModel>(0);
		
		for (TWebsite tWebsite : tWebsites) {
			websiteModels.add(WebsiteModelExtension.toWebsiteManageModel(tWebsite));
		}
		
		return new SubjectManageModel(tSubject.getId(), 
				tSubject.getSubjectName(), tSubject.getSubjectDesc(), 
				tSubject.getUpdateTime(), tSubject.getUpdateNum(), 
				heat, hotWord, keywordModels, websiteModels);
		
	}
	
	public static SubjectEditModel toSubjectEditModel(TSubject tSubject) {
		Map<String, KeywordEditModel> keywords = new HashMap<String, KeywordEditModel>();
		for (TKeyword tKeyword : tSubject.getTKeywords()) {
			keywords.put(tKeyword.getKeyword(), new KeywordEditModel(tKeyword.getId(), tKeyword.getKeyword()));
		}
		List<Integer> websites = new ArrayList<Integer>();
		for (TWebsite tWebsite : tSubject.getTWebsites()) {
			websites.add(tWebsite.getId());
		}
		return new SubjectEditModel(tSubject.getId(), tSubject.getTUser().getId(), 
				tSubject.getSubjectName(), tSubject.getSubjectDesc(), 
				keywords, websites);
	}
	
	public static TSubject toTSubject(SubjectEditModel subjectEditModel) {
		TSubject tSubject = new TSubject();
		if (subjectEditModel.getId() != null) {
			tSubject.setId(subjectEditModel.getId());
		}
		tSubject.setSubjectName(subjectEditModel.getName());
		tSubject.setSubjectDesc(subjectEditModel.getDesc());
		return tSubject;
	}
	
	public static TSubject toTSubject(SubjectEditModel subjectEditModel,TSubject tSubject) {
		tSubject.setSubjectName(subjectEditModel.getName());
		tSubject.setSubjectDesc(subjectEditModel.getDesc());
		return tSubject;
	}
	
	public static SubjectSelectModel toSubjectSelectModel(TSubject tSubject) {
		Set<TKeyword> keywords = tSubject.getTKeywords();
		List<KeywordSelectModel> keywordSelectModels = new ArrayList<KeywordSelectModel>();
		for (TKeyword tKeyword : keywords) {
			keywordSelectModels.add(KeywordModelExtension.toKeywordSelectModel(tKeyword));
		}
		return new SubjectSelectModel(tSubject.getId(), tSubject.getSubjectName(), keywordSelectModels);
	}
	
	public static SubjectShowModel toSubjectShowModel(TSubject tSubject) {
		return new SubjectShowModel(tSubject.getSubjectName(), tSubject.getSubjectDesc(), tSubject.getUpdateNum(), tSubject.getUpdateTime());
	}
}
