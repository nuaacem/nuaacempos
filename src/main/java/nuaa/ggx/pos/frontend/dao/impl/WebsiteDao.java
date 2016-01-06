package nuaa.ggx.pos.frontend.dao.impl;

import java.util.List;

import nuaa.ggx.pos.frontend.dao.interfaces.IWebsiteDao;
import nuaa.ggx.pos.frontend.model.TSubject;
import nuaa.ggx.pos.frontend.model.TUser;
import nuaa.ggx.pos.frontend.model.TWebsite;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("WebsiteDao")
public class WebsiteDao extends BaseDao<TWebsite> implements IWebsiteDao {

	private static Logger log = Logger.getLogger(WebsiteDao.class);
	
	@Override
	public List<TWebsite> findByUserId(Integer userId) {
		log.debug("getting User instance with userId: " + userId);
        try {
        	TUser user = (TUser) getSession().load(TUser.class, userId);
    		Criteria criteria = getSession().createCriteria(TWebsite.class);
    		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
    		criteria.add(Restrictions.eq("TUser", user));
    		return criteria.list();
        } catch (RuntimeException re) {
            log.error("get User_id failed", re);
            throw re;
        }
	}

}
