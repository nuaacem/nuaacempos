package nuaa.ggx.pos.frontend.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import nuaa.ggx.pos.frontend.dao.impl.SubjectDao;
import nuaa.ggx.pos.frontend.dao.impl.UserDao;
import nuaa.ggx.pos.frontend.dao.interfaces.IKeywordDao;
import nuaa.ggx.pos.frontend.dao.interfaces.ISubjectDao;
import nuaa.ggx.pos.frontend.dao.interfaces.IUserDao;
import nuaa.ggx.pos.frontend.dao.interfaces.IWebsiteDao;
import nuaa.ggx.pos.frontend.model.TKeyword;
import nuaa.ggx.pos.frontend.model.TSubject;
import nuaa.ggx.pos.frontend.model.TUser;
import nuaa.ggx.pos.frontend.model.TWebsite;
import nuaa.ggx.pos.frontend.service.interfaces.IConsensusService;
import nuaa.ggx.pos.frontend.service.interfaces.ISubjectManageService;
import nuaa.ggx.pos.frontend.util.Constants;
import nuaa.ggx.pos.frontend.web.vo.KeywordEditModel;
import nuaa.ggx.pos.frontend.web.vo.SubjectEditModel;
import nuaa.ggx.pos.frontend.web.vo.extension.SubjectModelExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("SubjectManageService")
public class SubjectManageService implements ISubjectManageService{
    
	@Autowired
	private ISubjectDao subjectDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IWebsiteDao websiteDao;
	
	@Autowired
	private IKeywordDao keywordDao;
	
	@Autowired
	private IConsensusService consensusService;
	
	@Override
	public void findByIdlist() {
		//不会
	}

	@Override
	public List<TSubject> findByUserId(Integer userId) {
		return subjectDao.findByUserID(userId);
	}

	@Override
	public void save(SubjectEditModel subjectEditModel) {
		TSubject tSubject = SubjectModelExtension.toTSubject(subjectEditModel);
		TUser user = userDao.loadById(subjectEditModel.getUserId());
		Set<TWebsite> websites = new HashSet<TWebsite>();
		for (int websiteId : subjectEditModel.getWebsites()) {
			TWebsite tWebsite = websiteDao.loadById(websiteId);
			websites.add(tWebsite);
		}
		Timestamp timestamp = new Timestamp(new Date().getTime());
		Set<TKeyword> keywords = new HashSet<TKeyword>();
		for (Entry<String, KeywordEditModel> entry : subjectEditModel.getKeywords().entrySet()) {
			keywords.add(new TKeyword(entry.getValue().getName()));
		}
		tSubject.setCreateTime(timestamp);
		tSubject.setTUser(user);
		tSubject.setTKeywords(keywords);
		tSubject.setTWebsites(websites);
		TSubject subject = subjectDao.merge(tSubject);
		consensusService.updateSubjectConsensus(subject.getId(), Constants.COLLECT_DATA_REFRESH_CYCLE);
	}

	@Override
	public void delete(Integer id) {
		subjectDao.delete(subjectDao.loadById(id));
	}

	@Override
	public void update(TSubject subject) {
		subjectDao.attachDirty(subject);
	}

	@Override
	public TSubject getById(Integer id) {
		return subjectDao.getById(id);
	}

	@Override
	public TSubject loadById(Integer id) {
		return subjectDao.loadById(id);
	}

	@Override
	public TSubject merge(TSubject subject) {
		return subjectDao.merge(subject);
	}

	@Override
	public void update(SubjectEditModel subjectEditModel) {
		TSubject tSubject = subjectDao.loadById(subjectEditModel.getId());
		tSubject = SubjectModelExtension.toTSubject(subjectEditModel, tSubject);
		TUser user = userDao.loadById(subjectEditModel.getUserId());
		Set<TWebsite> websites = new HashSet<TWebsite>();
		for (int websiteId : subjectEditModel.getWebsites()) {
			TWebsite tWebsite = websiteDao.loadById(websiteId);
			websites.add(tWebsite);
		}
//		Timestamp timestamp = new Timestamp(new Date().getTime());
		Set<TKeyword> keywords = new HashSet<TKeyword>();
		for (Entry<String, KeywordEditModel> entry : subjectEditModel.getKeywords().entrySet()) {
			if (entry.getValue().getId() != null) {
				TKeyword tKeyword = keywordDao.getById(entry.getValue().getId());
				tKeyword.setKeyword(entry.getValue().getName());
				keywords.add(tKeyword);
			}
			else {
				keywords.add(new TKeyword(entry.getValue().getName()));
			}
		}
		tSubject.setTUser(user);
		tSubject.setUpdateTime(null);
		tSubject.setTKeywords(keywords);
		tSubject.setTWebsites(websites);
		subjectDao.attachDirty(tSubject);
		consensusService.updateSubjectConsensus(subjectEditModel.getId(), Constants.COLLECT_DATA_REFRESH_CYCLE);
	}

}
