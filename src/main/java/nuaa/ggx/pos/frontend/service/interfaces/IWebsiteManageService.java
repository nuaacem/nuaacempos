package nuaa.ggx.pos.frontend.service.interfaces;

import java.util.List;

import nuaa.ggx.pos.frontend.model.TWebsite;

public interface IWebsiteManageService {
	public TWebsite getById(Integer id);
	public TWebsite loadById(Integer id);
    public List<TWebsite> findByUserId(Integer userId);
    public void save(TWebsite website);
    public void delete(TWebsite website);
    public void delete(Integer id);
    public void update(TWebsite website);
    public void deleteWebsites(String[] ids);
}
