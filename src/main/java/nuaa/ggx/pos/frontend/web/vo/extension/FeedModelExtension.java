package nuaa.ggx.pos.frontend.web.vo.extension;

import nuaa.ggx.pos.frontend.model.TFeed;
import nuaa.ggx.pos.frontend.web.vo.FeedShowModel;

public class FeedModelExtension {

	public static FeedShowModel toFeedShowModel(TFeed tFeed) {
		return new FeedShowModel(tFeed.getContent(), tFeed.getType(), tFeed.getFeedTime());
	}
}
