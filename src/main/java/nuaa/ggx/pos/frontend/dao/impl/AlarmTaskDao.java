package nuaa.ggx.pos.frontend.dao.impl;
import nuaa.ggx.pos.frontend.dao.interfaces.IAlarmTaskDao;
import nuaa.ggx.pos.frontend.model.TAlarmTask;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("AlarmTaskDao")
public class AlarmTaskDao extends BaseDao<TAlarmTask> implements IAlarmTaskDao{
	
	private static Logger log = Logger.getLogger(AlarmTaskDao.class);
	
      public TAlarmTask findByUserId(Integer user_id) {
        log.debug("getting User instance with user_id: " + user_id);
        try {
            TAlarmTask instance = (TAlarmTask) getSession()
                    .get("model.TalarmTask", user_id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get User_id failed", re);
            throw re;
        }
    }
   
}