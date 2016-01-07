package nuaa.ggx.pos.frontend.service.impl;

import nuaa.ggx.pos.frontend.dao.impl.AlarmTaskDao;
import nuaa.ggx.pos.frontend.model.TAlarmTask;
import nuaa.ggx.pos.frontend.service.interfaces.IAlarmTaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("AlarmTaskService")
public class AlarmTaskService implements IAlarmTaskService {
	
	@Autowired
	private AlarmTaskDao alarmtaskdao;
	@Override
	public TAlarmTask findByUserId(Integer id) {
		// TODO Auto-generated method stub
		return alarmtaskdao.findByUserId(id);
	}

	@Override
	public void save(TAlarmTask alarmtask) {
		// TODO Auto-generated method stub
		alarmtaskdao.save(alarmtask);
	}

	@Override
	public void update(TAlarmTask alarmtask) {
		// TODO Auto-generated method stub
		alarmtaskdao.attachDirty(alarmtask);
	}

}
