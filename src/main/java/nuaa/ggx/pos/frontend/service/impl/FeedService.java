package nuaa.ggx.pos.frontend.service.impl;

import java.util.List;

import nuaa.ggx.pos.frontend.dao.impl.FeedDao;
import nuaa.ggx.pos.frontend.model.TFeed;
import nuaa.ggx.pos.frontend.service.interfaces.IFeedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FeedService")
public class FeedService implements IFeedService{

	@Autowired
	private FeedDao feeddao ;

	@Override
	public List<TFeed> findBaseTime(Integer num) {
		return feeddao.findBaseTime(num);
	}
	

}
