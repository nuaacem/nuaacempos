package nuaa.ggx.pos.frontend.service.impl;

import nuaa.ggx.pos.frontend.dao.impl.AnalysisReportDao;
import nuaa.ggx.pos.frontend.model.TAnalysisReport;
import nuaa.ggx.pos.frontend.service.interfaces.IAlaramSetManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("AlarmSetManagerService")
public class AlarmSetManagerService implements IAlaramSetManager{
	
	@Autowired
    private AnalysisReportDao analysisreportdao;
	

	@Override
	public TAnalysisReport findById(Integer id) {
		// TODO Auto-generated method stub
		return analysisreportdao.getById(id);
	}

	@Override
	public void save(TAnalysisReport analysisreport) {
		// TODO Auto-generated method stub
		analysisreportdao.save(analysisreport);

	}

	@Override
	public void delete(TAnalysisReport analysisreport) {
		// TODO Auto-generated method stub
		analysisreportdao.delete(analysisreport);
	}

}
