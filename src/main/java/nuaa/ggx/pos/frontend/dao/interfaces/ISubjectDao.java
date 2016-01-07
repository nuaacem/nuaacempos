package nuaa.ggx.pos.frontend.dao.interfaces;

import java.util.List;

import nuaa.ggx.pos.frontend.model.TSubject;

public interface ISubjectDao extends IBaseDao<TSubject> {
	
	public List<TSubject> findByUserID(Integer userId);
}

