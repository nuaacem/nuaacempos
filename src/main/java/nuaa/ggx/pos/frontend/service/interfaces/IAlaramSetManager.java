package nuaa.ggx.pos.frontend.service.interfaces;

import nuaa.ggx.pos.frontend.model.TAnalysisReport;

public interface IAlaramSetManager {
public TAnalysisReport findById(Integer id);
public void save(TAnalysisReport analysisreport);
public void delete(TAnalysisReport analysisreport);

}
