package nuaa.ggx.pos.frontend.dao.interfaces;
import nuaa.ggx.pos.frontend.model.TAlarmTask;

public interface IAlarmTaskDao extends IBaseDao<TAlarmTask> {
	
	public TAlarmTask findByUserId(Integer user_id);
}