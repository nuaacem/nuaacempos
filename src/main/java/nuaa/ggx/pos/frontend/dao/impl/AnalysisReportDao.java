package nuaa.ggx.pos.frontend.dao.impl;

import nuaa.ggx.pos.frontend.dao.interfaces.IAnalysisReportDao;
import nuaa.ggx.pos.frontend.model.TAnalysisReport;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("AnalysisReportDao")
public class AnalysisReportDao extends BaseDao<TAnalysisReport> implements IAnalysisReportDao{

	private static Logger log = Logger.getLogger(AnalysisReportDao.class);
	public TAnalysisReport getById(Integer id) {		 
		try{
		TAnalysisReport instance = (TAnalysisReport) getSession()
                .get("model.TAnalysisReport", id);
		 return instance;
        
		    }catch (RuntimeException re) {
	            log.error("get id failed", re);
	            throw re;
	}
		
	}
	}

