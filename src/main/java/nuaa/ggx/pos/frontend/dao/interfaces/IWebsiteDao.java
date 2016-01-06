package nuaa.ggx.pos.frontend.dao.interfaces;

import java.util.List;

import nuaa.ggx.pos.frontend.model.TWebsite;

public interface IWebsiteDao extends IBaseDao<TWebsite> {
    public List<TWebsite> findByUserId(Integer userId);
}
