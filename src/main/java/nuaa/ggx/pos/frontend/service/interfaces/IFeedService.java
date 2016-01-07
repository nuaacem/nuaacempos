package nuaa.ggx.pos.frontend.service.interfaces;

import java.util.List;

import nuaa.ggx.pos.frontend.model.TFeed;

public interface IFeedService {
	public List<TFeed> findBaseTime(Integer num);
}
