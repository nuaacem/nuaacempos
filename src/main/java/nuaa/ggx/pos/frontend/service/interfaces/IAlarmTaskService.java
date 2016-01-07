package nuaa.ggx.pos.frontend.service.interfaces;
import nuaa.ggx.pos.frontend.model.TAlarmTask;
public interface IAlarmTaskService {
    
	public TAlarmTask findByUserId(Integer id);
    public void save (TAlarmTask alarmtask);
    public void update(TAlarmTask alarmtask);
}
