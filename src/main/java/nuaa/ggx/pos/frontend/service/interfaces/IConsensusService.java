package nuaa.ggx.pos.frontend.service.interfaces;

import java.util.Set;

import nuaa.ggx.pos.frontend.model.TConsensus;
import nuaa.ggx.pos.frontend.util.pager.PageList;
import nuaa.ggx.pos.frontend.web.vo.ConsensusShowModel;

public interface IConsensusService {
	public TConsensus getById(Integer id);
	public TConsensus loadById(Integer id);
	public Set<TConsensus> findByKeywordId(Integer keywordId);
	public Set<TConsensus> findBySubjectId(Integer subjectId);
	public PageList<ConsensusShowModel> findByKeywordAndList(Integer keywordId, Integer pageStart, Integer pageSize);
	public PageList<ConsensusShowModel> findBySubjectAndList(Integer subjectId, Integer pageStart, Integer pageSize);
	public void updateKeywordConsensus(Integer keywordId, int minute);
	public void updateSubjectConsensus(Integer subjectId, int minute);
}
