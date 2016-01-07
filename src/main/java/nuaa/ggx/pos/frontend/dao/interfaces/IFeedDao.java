package nuaa.ggx.pos.frontend.dao.interfaces;

import java.util.List;

import nuaa.ggx.pos.frontend.model.TFeed;

/**
 * 范例 UserDao接口 首先按照UML类图定义接口 然后再实现
 * @author KOC-RY
 *
 */
public interface IFeedDao extends IBaseDao<TFeed>{
	
	public List<TFeed> findBaseTime(Integer num);
}
