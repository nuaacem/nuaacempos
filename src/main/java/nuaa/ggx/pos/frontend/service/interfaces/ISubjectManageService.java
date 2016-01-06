package nuaa.ggx.pos.frontend.service.interfaces;

import java.util.List;

import nuaa.ggx.pos.frontend.model.TSubject;
import nuaa.ggx.pos.frontend.web.vo.SubjectEditModel;

public interface ISubjectManageService {
	public TSubject getById(Integer id);
	public TSubject loadById(Integer id);
	public void findByIdlist();
	public List<TSubject> findByUserId(Integer userId);
	public void save(SubjectEditModel subjectEditModel);
	public void delete(Integer id);
	public void update(TSubject subject);
	public void update(SubjectEditModel subjectEditModel);
	public TSubject merge(TSubject subject);
}
