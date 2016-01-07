package nuaa.ggx.pos.frontend.dao.impl;

import nuaa.ggx.pos.frontend.dao.interfaces.IConsensusDao;
import nuaa.ggx.pos.frontend.model.TConsensus;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository("ConsensusDao")
public class ConsensusDao extends BaseDao<TConsensus> implements IConsensusDao{

	private static Logger log = Logger.getLogger(ConsensusDao.class);

}
