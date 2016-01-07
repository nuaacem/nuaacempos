package nuaa.ggx.pos.frontend.dao.interfaces;

import java.util.List;

import nuaa.ggx.pos.frontend.model.TCollectWebsite;

public interface ICollectWebsiteDao extends IBaseDao<TCollectWebsite> {
	public List<TCollectWebsite> findPublicWebsite();
}
