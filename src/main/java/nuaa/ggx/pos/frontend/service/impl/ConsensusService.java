package nuaa.ggx.pos.frontend.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nuaa.ggx.pos.frontend.dao.interfaces.IConsensusDao;
import nuaa.ggx.pos.frontend.dao.interfaces.IKeywordDao;
import nuaa.ggx.pos.frontend.dao.interfaces.ISubjectDao;
import nuaa.ggx.pos.frontend.model.TConsensus;
import nuaa.ggx.pos.frontend.model.TKeyword;
import nuaa.ggx.pos.frontend.model.TSubject;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.service.interfaces.IConsensusService;
import nuaa.ggx.pos.frontend.util.pager.PageList;
import nuaa.ggx.pos.frontend.util.pager.PageListUtil;
import nuaa.ggx.pos.frontend.web.vo.ConsensusShowModel;
import nuaa.ggx.pos.frontend.web.vo.extension.ConsensusModelExtension;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("ConsensusService")
public class ConsensusService implements IConsensusService {

	@Autowired
	private IConsensusDao consensusDao;
	
	@Autowired
	private IKeywordDao keywordDao;
	
	@Autowired
	private ISubjectDao subjectDao;
	
	@Override
	public TConsensus getById(Integer id) {
		return consensusDao.getById(id);
	}

	@Override
	public TConsensus loadById(Integer id) {
		return consensusDao.loadById(id);
	}

	@Override
	public Set<TConsensus> findByKeywordId(Integer keywordId) {
		TKeyword keyword = keywordDao.loadById(keywordId);
		Hibernate.initialize(keyword.getTConsensuses());
		Set<TConsensus> consensus = keyword.getTConsensuses();
		for (TConsensus tConsensus : consensus) {
			Hibernate.initialize(tConsensus.getTConsensusDetail());
			Hibernate.initialize(tConsensus.getTTagwords());
		}
		return consensus;
	}

	@Override
	public Set<TConsensus> findBySubjectId(Integer subjectId) {
		TSubject tSubject = subjectDao.loadById(subjectId);
		Hibernate.initialize(tSubject.getTKeywords());
		Set<TKeyword> keywords = tSubject.getTKeywords();
		Set<TConsensus> consensus = new HashSet<TConsensus>();
		for (TKeyword tKeyword : keywords) {
			consensus.addAll(this.findByKeywordId(tKeyword.getId()));
		}
		for (TConsensus tConsensus : consensus) {
			Hibernate.initialize(tConsensus.getTConsensusDetail());
			Hibernate.initialize(tConsensus.getTTagwords());
		}
		return consensus;
	}
    @Override
	public PageList<ConsensusShowModel> findByKeywordAndList(Integer keywordId, 
			Integer pageStart, Integer pageSize) {
		Criteria criteria = consensusDao.getSession()
				.createCriteria(TConsensus.class)
				.createAlias("TKeywords", "keywords")
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.eq("keywords.id", keywordId))
				.addOrder(Order.asc("id"))
				.setFirstResult(pageStart)
				.setMaxResults(pageSize);
		Criteria countCriteria = consensusDao.getSession()
				.createCriteria(TConsensus.class)
				.createAlias("TKeywords", "keywords")
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.add(Restrictions.eq("keywords.id", keywordId))
				.setProjection(Projections.countDistinct("id"));				
		List<TConsensus> consensusList = criteria.list();
		Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());

		List<ConsensusShowModel> consensusShowModels = new ArrayList<ConsensusShowModel>();
		for (TConsensus tConsensus : consensusList) {
			Hibernate.initialize(tConsensus.getTConsensusDetail());
			Hibernate.initialize(tConsensus.getTTagwords());
			consensusShowModels.add(ConsensusModelExtension.toConsensusShowModel(tConsensus));
		}
		PageList<ConsensusShowModel> pageList = PageListUtil.getPageList(count, pageStart, pageSize, consensusShowModels);
		return pageList;
	}

	@Override
	public PageList<ConsensusShowModel> findBySubjectAndList(Integer subjectId,
			Integer pageStart, Integer pageSize) {
		String sql = "select id from t_keyword where subject_id = " + subjectId;
		List keywordIdList = keywordDao.getSession().createSQLQuery(sql).list();
		Criteria consensusCriteria = consensusDao.getSession().createCriteria(TConsensus.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.createAlias("TKeywords", "keyword")
				.add(Restrictions.in("keyword.id", keywordIdList))
				.addOrder(Order.asc("id"))
				.setFirstResult(pageStart)
				.setMaxResults(pageSize);
		Criteria countCriteria = consensusDao.getSession().createCriteria(TConsensus.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.createAlias("TKeywords", "keyword")
				.add(Restrictions.in("keyword.id", keywordIdList))
				.setProjection(Projections.countDistinct("id"));				
		List<TConsensus> consensusList = consensusCriteria.list();	
		Integer count=Integer.parseInt(countCriteria.uniqueResult().toString());
		List<ConsensusShowModel> consensusShowModels = new ArrayList<ConsensusShowModel>();
		for (TConsensus tConsensus : consensusList) {
			Hibernate.initialize(tConsensus.getTConsensusDetail());
			Hibernate.initialize(tConsensus.getTTagwords());
			consensusShowModels.add(ConsensusModelExtension.toConsensusShowModel(tConsensus));
		}
		PageList<ConsensusShowModel> pageList = PageListUtil.getPageList(count, pageStart, pageSize, consensusShowModels);
		return pageList;
	}
	
	@Override
	public void updateKeywordConsensus(Integer keywordId, int minute) {
		Date nowDate = new Date();
		Long nowTime = nowDate.getTime();
		TKeyword keyword = keywordDao.loadById(keywordId);
		Hibernate.initialize(keyword.getTSubject());
		TSubject subject = keyword.getTSubject();
		Set<Integer> websiteIds = new HashSet<Integer>();
		for (TWebsite website : subject.getTWebsites()) {
			websiteIds.add(website.getTCollectWebsite().getId());
		}
		if (null == keyword.getUpdateTime() 
			|| (nowTime - keyword.getUpdateTime().getTime() >= minute * 60 * 1000)) {
			
			Criteria criteria = consensusDao.getSession().createCriteria(TConsensus.class);
			criteria.add(Restrictions.like("summary", "%" + keyword.getKeyword() + "%"));
			criteria.add(Restrictions.in("collectWebsiteId", websiteIds));
			Set<TConsensus> consensussSet = new HashSet<TConsensus>(criteria.list());
			keyword.setTConsensuses(consensussSet);
			keyword.setUpdateTime(new Timestamp(nowTime));
			keywordDao.attachDirty(keyword);
		}		
	}

	@Override
	public void updateSubjectConsensus(Integer subjectId, int minute) {
		TSubject subject = subjectDao.loadById(subjectId);
		Date nowDate = new Date();
		Long nowTime = nowDate.getTime();
		if (null == subject.getUpdateTime() || 
			(nowTime - subject.getUpdateTime().getTime() > minute * 60 * 1000)) {
			
			Set<Integer> websiteIds = new HashSet<Integer>();
			for (TWebsite website : subject.getTWebsites()) {
				websiteIds.add(website.getTCollectWebsite().getId());
			}
			Set<TKeyword> keywords = subject.getTKeywords();
			for (TKeyword keyword : keywords) {
				if (null == keyword.getUpdateTime() 
						|| (nowTime - keyword.getUpdateTime().getTime() >= minute * 60 * 1000)) {
						
						Criteria criteria = consensusDao.getSession().createCriteria(TConsensus.class);
						criteria.add(Restrictions.like("summary", "%" + keyword.getKeyword() + "%"));
						criteria.add(Restrictions.in("collectWebsiteId", websiteIds));
						Set<TConsensus> consensussSet = new HashSet<TConsensus>(criteria.list());
						keyword.setTConsensuses(consensussSet);
						keyword.setUpdateTime(new Timestamp(nowTime));
						keywordDao.attachDirty(keyword);
					}		
			}
			subject.setUpdateTime(new Timestamp(nowTime));
			subjectDao.attachDirty(subject);
		}
	}
}
