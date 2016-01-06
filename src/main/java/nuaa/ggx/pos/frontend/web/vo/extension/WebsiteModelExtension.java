package nuaa.ggx.pos.frontend.web.vo.extension;

import java.util.List;

import nuaa.ggx.pos.frontend.model.TUser;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.web.vo.WebsiteEditModel;
import nuaa.ggx.pos.frontend.web.vo.WebsiteManageModel;
import nuaa.ggx.pos.frontend.web.vo.WebsiteSelectModel;
import nuaa.ggx.pos.frontend.web.vo.WebsiteShowModel;

public class WebsiteModelExtension {

	public static WebsiteManageModel toWebsiteManageModel(TWebsite tWebsite) {
		return new WebsiteManageModel(tWebsite.getId(), tWebsite.getWebsiteName(), 
				tWebsite.getUrl(), tWebsite.getType(), tWebsite.getUpdateNum(),
				tWebsite.getUpdateTime(), tWebsite.getIsPublic());
		
	}
	
	public static WebsiteSelectModel toWebsiteSelectModel(TWebsite tWebsite, List<Integer> selectedWebsites) {
		if (selectedWebsites.contains(tWebsite.getId())) {
			return new WebsiteSelectModel(tWebsite.getId(), tWebsite.getWebsiteName(), 
					tWebsite.getUrl(), tWebsite.getType(), true);
		}
		else {
			return new WebsiteSelectModel(tWebsite.getId(), tWebsite.getWebsiteName(), 
					tWebsite.getUrl(), tWebsite.getType(), false);
		}
	}
	
	public static WebsiteEditModel toWebsiteEditModel(TWebsite tWebsite) {
		return new WebsiteEditModel(tWebsite.getId(), tWebsite.getWebsiteName(), tWebsite.getUrl(), tWebsite.getType());
	}
	
	public static TWebsite toTWebsite(WebsiteEditModel websiteEditModel, TUser user) {
		TWebsite tWebsite = new TWebsite();
		if (websiteEditModel.getId() != null) {
			tWebsite.setId(websiteEditModel.getId());
		}
		tWebsite.setWebsiteName(websiteEditModel.getName());
		tWebsite.setUrl(websiteEditModel.getUrl());
		tWebsite.setType(websiteEditModel.getType());
		tWebsite.setTUser(user);
		tWebsite.setIsPublic(false);
		return tWebsite;
	}
	public static TWebsite toTWebsite(WebsiteEditModel websiteEditModel, TWebsite tWebsite) {
		tWebsite.setWebsiteName(websiteEditModel.getName());
		tWebsite.setUrl(websiteEditModel.getUrl());
		tWebsite.setType(websiteEditModel.getType());
		return tWebsite;
	}
	
	public static WebsiteShowModel toWebsiteShowModel(TWebsite tWebsite){
		return new WebsiteShowModel(tWebsite.getWebsiteName(), tWebsite.getUrl(), tWebsite.getUpdateNum(), tWebsite.getUpdateTime());
		
	}
}
