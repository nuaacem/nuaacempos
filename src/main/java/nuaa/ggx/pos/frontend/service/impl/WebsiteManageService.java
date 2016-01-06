package nuaa.ggx.pos.frontend.service.impl;

import java.util.List;

import nuaa.ggx.pos.frontend.dao.impl.WebsiteDao;
import nuaa.ggx.pos.frontend.dao.interfaces.ICollectWebsiteDao;
import nuaa.ggx.pos.frontend.dao.interfaces.IWebsiteDao;
import nuaa.ggx.pos.frontend.model.TCollectWebsite;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.service.interfaces.IWebsiteManageService;
import nuaa.ggx.pos.frontend.util.UrlHelper;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("WebsiteManageService")
public class WebsiteManageService implements IWebsiteManageService{
    
	@Autowired
	private IWebsiteDao websitedao;
	@Autowired
	private ICollectWebsiteDao collectWebsiteDao;
	
	@Override
	public List<TWebsite> findByUserId(Integer userId) {
		return websitedao.findByUserId(userId);
	}

	@Override
	public void save(TWebsite website) {
		String websiteUrl = UrlHelper.explainWebsiteUrl(website.getUrl());
		Criteria criteria = collectWebsiteDao
				.getSession().createCriteria(TCollectWebsite.class);
		criteria.add(Restrictions.eq("url", websiteUrl));
		TCollectWebsite collectWebsite = (TCollectWebsite)criteria.uniqueResult();
		if (null == collectWebsite) {
			collectWebsite = new TCollectWebsite(websiteUrl);
			collectWebsite = collectWebsiteDao.merge(collectWebsite);
		}
		website.setTCollectWebsite(collectWebsite);
		websitedao.save(website);
	}

	@Override
	public void delete(TWebsite website) {
		websitedao.delete(website);
	}

	@Override
	public void update(TWebsite website) {
		String websiteUrl = UrlHelper.explainWebsiteUrl(website.getUrl());
		Criteria criteria = collectWebsiteDao
				.getSession().createCriteria(TCollectWebsite.class);
		criteria.add(Restrictions.eq("url", websiteUrl));
		TCollectWebsite collectWebsite = (TCollectWebsite)criteria.uniqueResult();
		if (null == collectWebsite) {
			collectWebsite = new TCollectWebsite(websiteUrl);
			collectWebsite = collectWebsiteDao.merge(collectWebsite);
		}
		website.setTCollectWebsite(collectWebsite);
		websitedao.attachDirty(website);
	}

	@Override
	public TWebsite getById(Integer id) {
		return websitedao.getById(id);
	}

	@Override
	public TWebsite loadById(Integer id) {
		return websitedao.loadById(id);
	}

	@Override
	public void deleteWebsites(String[] ids) {
		for (String idString : ids) {
			if (StringUtils.isNumeric(idString))
			{
				Integer id = Integer.parseInt(idString);
				delete(id);
			}
		}
	}

	@Override
	public void delete(Integer id) {
		delete(this.loadById(id));
	}

}
