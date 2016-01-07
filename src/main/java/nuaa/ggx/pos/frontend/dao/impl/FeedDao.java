package nuaa.ggx.pos.frontend.dao.impl;

import java.util.List;

import nuaa.ggx.pos.frontend.dao.interfaces.IFeedDao;
import nuaa.ggx.pos.frontend.model.TFeed;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

/**
 * Dao层范例 其它Dao都可以仿照此类写
 * @author KOC-RY
 *
 */
@Repository("FeedDao")
public class FeedDao extends BaseDao<TFeed> implements IFeedDao{
	
	private static Logger log = Logger.getLogger(FeedDao.class);

	@Override
	public List<TFeed> findBaseTime(Integer num) {
		log.debug("finding Feeds base time");
    	List<TFeed> feeds = null;
        try {
        	Criteria criteria = getSession().createCriteria(TFeed.class);
        	criteria.addOrder(Order.desc("feedTime"))
        			.setMaxResults(num);
        	feeds = criteria.list();
        }
        catch (RuntimeException re) {
            log.error("find Feed base time failed", re);
            throw re;
        }
		return feeds;
	}
	
    
    
}
