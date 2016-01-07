package nuaa.ggx.pos.frontend.dao.interfaces;

import nuaa.ggx.pos.frontend.model.TAnalysisReport;

public interface IAnalysisReportDao extends IBaseDao<TAnalysisReport>{
    public TAnalysisReport getById(Integer id);
}
