package nuaa.ggx.pos.frontend.dao.impl;

import java.util.List;

import nuaa.ggx.pos.frontend.dao.interfaces.ICollectWebsiteDao;
import nuaa.ggx.pos.frontend.model.TCollectWebsite;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("CollectWebsiteDao")
public class CollectWebsiteDao extends BaseDao<TCollectWebsite> implements ICollectWebsiteDao {
	private static Logger log = Logger.getLogger(CollectWebsiteDao.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<TCollectWebsite> findPublicWebsite() {
		log.debug("finding public websites");
		List<TCollectWebsite> collectWebsites = null;
		try {
			Criteria criteria = getSession().createCriteria(TCollectWebsite.class);
			criteria.add(Restrictions.eq("isPublic", true));
			collectWebsites = criteria.list();
		} catch (RuntimeException re) {
            log.error("finding public websites failed", re);
            throw re;
		}
		return collectWebsites;
	}
}
